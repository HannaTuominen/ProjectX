package fi.tamk.oddyssea;

/**
 * @author Juuso Toivanen juuso.toivanen98@gmail.com
 * @version 1.2
 * @since 1.0
 */
public class SensorFilter {
	private SensorFilter() {
	}

	/**
	 * Called from StepDetector class, gives a starting value for axis changes in accelerometer
	 *
	 * @param array Array that consists of x, y or z axis
	 * @return Returns int that is used in StepDetector class for math
	 */
	public static float sum(float[] array) {
		float retval = 0;
		for (int i = 0; i < array.length; i++) {
			retval += array[i];
		}
		return retval;
	}

	/**
	 * Math method used to figure current z-position out, but through array
	 * @param arrayA worldZ-array
	 * @param arrayB currentAccel-array
	 * @return returns current Z-position
	 */
	public static float[] cross(float[] arrayA, float[] arrayB) {
		float[] retArray = new float[3];
		retArray[0] = arrayA[1] * arrayB[2] - arrayA[2] * arrayB[1];
		retArray[1] = arrayA[2] * arrayB[0] - arrayA[0] * arrayB[2];
		retArray[2] = arrayA[0] * arrayB[1] - arrayA[1] * arrayB[0];
		return retArray;
	}

	/**
	 * Counts worldZ position
	 * @param array worldZ-array
	 * @return Square root of math answer
	 */
	public static float norm(float[] array) {
		float retval = 0;
		for (int i = 0; i < array.length; i++) {
			retval += array[i] * array[i];
		}
		return (float) Math.sqrt(retval);
	}

	/**
	 * Math method used to figure current z-position out
	 *
	 * @param a worldZ-array
	 * @param b currentAccel-array
	 * @return current Z-position
	 */
	public static float dot(float[] a, float[] b) {
		float retval = a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
		return retval;
	}

	/**
	 * normalizes accelerometer values
	 *
	 * @param a currentAccel-array
	 * @return returns accelArray
	 */
	public static float[] normalize(float[] a) {
		float[] retval = new float[a.length];
		float norm = norm(a);
		for (int i = 0; i < a.length; i++) {
			retval[i] = a[i] / norm;
		}
		return retval;
	}
}
