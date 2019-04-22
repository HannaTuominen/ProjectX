package fi.tamk.oddyssea;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

/**
 * @author Juuso Toivanen juuso.toivanen98@gmail.com
 * @version 1.2
 * @since 1.0
 */
public class AndroidLauncher extends AndroidApplication {
	/**
	 * On launch creates pedometer function and game itself
	 *
	 * Pedometer works as background service
	 *
	 * @param savedInstanceState Bundle object containing activity's
	 */
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MainClass(), config);
		startService(new Intent(getBaseContext(),MyServices.class));
	}
}
