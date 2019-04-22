package fi.tamk.oddyssea;

public class StepDetector {
	/**
	 * How much accelerometer values can go into array
	 */
	private static final int ACCEL_RING_SIZE = 10;
	/**
	 * How much velocity values can go into array
	 */
	private static final int VEL_RING_SIZE = 10;
	/**
	 * Sensitivity threshold
	 */
	private static final float STEP_THRESHOLD = 15f;
	/**
	 * Time that needs to happen between steps
	 */
	private static final int STEP_DELAY_NS = 250000000;
	/**
	 * Amount of AccelRing changes
	 */
	private int accelRingCounter = 0;
	/**
	 * x-axis array
	 */
	private float[] accelRingX = new float[ACCEL_RING_SIZE];
	/**
	 * y-axis array
	 */
	private float[] accelRingY = new float[ACCEL_RING_SIZE];
	/**
	 * z-axis array
	 */
	private float[] accelRingZ = new float[ACCEL_RING_SIZE];
	/**
	 * Amount of velocity changes
	 */
	private int velRingCounter = 0;
	/**
	 * array for velocity changes
	 */
	private float[] velRing = new float[VEL_RING_SIZE];
	/**
	 * When last step was taken
	 */
	private long lastStepTimeNs = 0;
	/**
	 * Latest velocity estimate
	 */
	private float oldVelocityEstimate = 0;
	/**
	 * Interface that listens to the step alerts
	 */
	private StepListener listener;

	/**
	 * Listener registration method
	 * @param listener Registers listener for use
	 */
	public void registerListener(StepListener listener) {
		this.listener = listener;
	}

	// Where the magic happens

	/**
	 * Updates accelerometer position
	 *
	 * @param timeNs Time of update
	 * @param x x-axis of accelerometer
	 * @param y y-axis of accelerometer
	 * @param z z-axis of accelerometer
	 */
	public void updateAccel(long timeNs, float x, float y, float z) {
		float[] currentAccel = new float[3];
		currentAccel[0] = x;
		currentAccel[1] = y;
		currentAccel[2] = z;

		// First step is to update our guess of where the global z vector is.
		accelRingCounter++;
		accelRingX[accelRingCounter % ACCEL_RING_SIZE] = currentAccel[0];
		accelRingY[accelRingCounter % ACCEL_RING_SIZE] = currentAccel[1];
		accelRingZ[accelRingCounter % ACCEL_RING_SIZE] = currentAccel[2];

		float[] worldZ = new float[3];
		worldZ[0] = SensorFilter.sum(accelRingX) / Math.min(accelRingCounter, ACCEL_RING_SIZE);
		worldZ[1] = SensorFilter.sum(accelRingY) / Math.min(accelRingCounter, ACCEL_RING_SIZE);
		worldZ[2] = SensorFilter.sum(accelRingZ) / Math.min(accelRingCounter, ACCEL_RING_SIZE);

		float normalization_factor = SensorFilter.norm(worldZ);

		worldZ[0] = worldZ[0] / normalization_factor;
		worldZ[1] = worldZ[1] / normalization_factor;
		worldZ[2] = worldZ[2] / normalization_factor;

		float currentZ = SensorFilter.dot(worldZ, currentAccel) - normalization_factor;
		velRingCounter++;
		velRing[velRingCounter % VEL_RING_SIZE] = currentZ;

		float velocityEstimate = SensorFilter.sum(velRing);

		if (velocityEstimate > STEP_THRESHOLD && oldVelocityEstimate <= STEP_THRESHOLD
				&& (timeNs - lastStepTimeNs > STEP_DELAY_NS)) {
			listener.step(timeNs);
			lastStepTimeNs = timeNs;
		}
		oldVelocityEstimate = velocityEstimate;
	}
}
