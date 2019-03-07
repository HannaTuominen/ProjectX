package fi.tamk.tiko;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

/*
	Main class where the batch,
 */

public class MainClass extends Game {
	SpriteBatch batch;

	FreeTypeFontGenerator generator;
	BitmapFont font12;
	int fontSize = 20;

	String title;
	String chapter1;
	String chapter2;

	Preferences prefs;

	float screenWidth;
	float screenHeight;

	public OrthographicCamera camera;

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont12() {
		return font12;
	}


	public String getTitle() {
		return title;
	}

	public Preferences getPrefs() {
		return prefs;
	}
	public void setPrefs( int ChapterNumber) {
		prefs.putInteger("ChapterNumber",ChapterNumber);
	}

	public String getChapter1Text() {
		return chapter1;
	}
	public String getChapter2Text() {
		return chapter2;
	}

	public void setFontSize(int size) {
		fontSize= size;
	}


	public float getScreenWidth() {
		return screenWidth;
	}

	public float getScreenHeight() {
		return screenHeight;
	}
	
	@Override
	public void create () {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		System.out.println(screenWidth);
		System.out.println(screenHeight);
		batch = new SpriteBatch();


		generator = new FreeTypeFontGenerator(Gdx.files.internal("helsinki.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = fontSize;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		font12 = generator.generateFont(parameter);

		//Create or open file MyPreferences.xml
		prefs = Gdx.app.getPreferences("MyPreferences");
		//Save in this textfile name = Donald Duck
//		prefs.putString("name", "Donald Duck");
//		prefs.putInteger("ChapterNumber",1 );
		// Try to find things by the key "name"
//		String name = prefs.getString("name", "No name Stored");

//		prefs.putBoolean("soundOn", true);

//		prefs.putInteger("highscore", 10);
		//Save happens here



		camera = new OrthographicCamera();
		camera.setToOrtho(false, screenWidth, screenHeight);


		//CHOOSE FINNISH
		//Locale locale = new Locale("fi", "FI");
		//CHOOSE ENGLISH
//		Locale locale = new Locale("en", "EN");

		//DEPENDS ON YOUR PHONE
		Locale locale = Locale.getDefault();


		I18NBundle myBundle =
				I18NBundle.createBundle(Gdx.files.internal("MyBundle"), locale);
		title = myBundle.get("title");
		chapter1 = myBundle.get("chapter1");
		chapter2 = myBundle.get("chapter2");

		//String steps = myBundle.format("steps");

		//START THE GAME FROM MAIN MENU
		MainMenu mainMenu = new MainMenu(this);
		setScreen(mainMenu);
	}

	@Override
	public void render () {

		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
