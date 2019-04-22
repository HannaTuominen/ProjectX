package fi.tamk.oddyssea;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;

/**
 * @author Juuso Toivanen juuso.toivanen98@gmail.com
 * @version 1.2
 * @since 1.0
 */
public class MyServices extends Service implements StepListener,SensorEventListener {
	/**
	 * Class which detects changes in accelerometer and converts them to steps
	 */
	private StepDetector simpleStepDetector;
	/**
	 * Class which lets service use sensors
	 */
	private SensorManager sensorManager;
	/**
	 * Androids sensor
	 */
	private Sensor accel;
	/**
	 * Number of steps, this will be sent to Game itself
	 */
	static int numSteps;
	/**
	 * String which will be used for saving to AndroidSharedPreferences
	 */
	public static final String SHARED_PREFS = "Steps";

	/**
	 *
	 * @param intent Bundle object
	 * @return
	 */
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	/**
	 * Starts up the sensor when game is opened for the first time
	 */
	@Override
	public void onCreate() {
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		simpleStepDetector = new StepDetector();
		simpleStepDetector.registerListener(this);
		sensorManager.registerListener(MyServices.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
	}

	/**
	 * Called when starting the game, loads steps and updates them from game files.
	 * @param intent The Intent supplied to Context.startService(Intent), as given.
	 * @param flags Additional data about this start request. Value is either 0 or a combination of START_FLAG_REDELIVERY, and START_FLAG_RETRY
	 * @param startId A unique integer representing this specific request to start. Use with stopSelfResult(int).
	 * @return
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		loadData();
		MainClass.setSteps(numSteps);
		getGameSteps();
		return START_STICKY;
	}

	/**
	 * Called when sensor values have changed.
	 *
	 * @param event This class represents a Sensor event and holds information.
	 */
	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			simpleStepDetector.updateAccel(
					event.timestamp, event.values[0], event.values[1], event.values[2]);
		}
	}

	/**
	 * Called when the accuracy of a sensor has changed
	 * @param sensor The ID of the sensor being monitored
	 * @param accuracy The new accuracy of this sensor.
	 */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) { }

	/**
	 * Called whenever StepDetector detects movement that is counted as a step
	 *
	 * Adds 1 step every call and saves the amount of steps everytime to prevent dataloss. Step can't go over a million
	 *
	 * @param timeNs time when step happened
	 */
	@Override
	public void step(long timeNs) {
		getGameSteps();
		if (numSteps < 1000000) {
			numSteps++;
		}
		MainClass.setSteps(numSteps);
		save();
	}

	/**
	 * Saves numSteps to Androids sharedPreferences
	 */
	public void save() {
		SharedPreferences stepsPrefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
		SharedPreferences.Editor editor = stepsPrefs.edit();
		editor.putInt(SHARED_PREFS,numSteps);
		editor.commit();
	}

	/**
	 * Loads numSteps from Androids sharedPreferences
	 */
	public void loadData() {
		SharedPreferences stepsPrefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
		numSteps = stepsPrefs.getInt(SHARED_PREFS,0);
	}

	/**
	 * Called when service is terminated -> Stops counting steps
	 */
	@Override
	public void onDestroy() {
		sensorManager.unregisterListener(MyServices.this);
		stopService(new Intent(getBaseContext(), MyServices.class));
	}

	/**
	 * Gets steps that are in games MainClass (which are showed to player)
	 */
	public void getGameSteps() {
		if (MainClass.getSteps() != -1) {
			numSteps = MainClass.getSteps();
		}

	}
}
