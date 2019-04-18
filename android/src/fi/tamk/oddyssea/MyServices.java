package fi.tamk.oddyssea;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;

public class MyServices extends Service implements StepListener,SensorEventListener {
	private StepDetector simpleStepDetector;
	private SensorManager sensorManager;
	private Sensor accel;
	static int numSteps;
	public static final String SHARED_PREFS = "Steps";


	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	@Override
	public void onCreate() {
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		simpleStepDetector = new StepDetector();
		simpleStepDetector.registerListener(this);
		sensorManager.registerListener(MyServices.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		loadData();
		MainClass.setSteps(numSteps);
		getGameSteps();
		return START_STICKY;
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			simpleStepDetector.updateAccel(
					event.timestamp, event.values[0], event.values[1], event.values[2]);
		}
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) { }
	@Override
	public void step(long timeNs) {
		getGameSteps();
		if (numSteps < 1000000) {
			numSteps++;
		}
		MainClass.setSteps(numSteps);
		save();
		System.out.println(numSteps);
	}
	public void save() {
		SharedPreferences stepsPrefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
		SharedPreferences.Editor editor = stepsPrefs.edit();
		editor.putInt(SHARED_PREFS,numSteps);
		editor.commit();
	}
	public void loadData() {
		SharedPreferences stepsPrefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
		numSteps = stepsPrefs.getInt(SHARED_PREFS,0);
	}
	@Override
	public void onDestroy() {
		sensorManager.unregisterListener(MyServices.this);
		stopService(new Intent(getBaseContext(), MyServices.class));
	}
	public void getGameSteps() {
		if (MainClass.getSteps() != -1) {
			numSteps = MainClass.getSteps();
			System.out.println("Ollaan iffissä");
		}

	}
}
