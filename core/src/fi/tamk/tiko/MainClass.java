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
	Main class where the batch, fonts, camera, localisation texts, screen width and height, chapterNumber and swapped and "MyPreferences.xml" where information is saved is created.
	These will be used in the different places of other codes.
 */

public class MainClass extends Game {
	private SpriteBatch batch;

	private FreeTypeFontGenerator generator;
	private BitmapFont font12;
	private int fontSize = 20;

	//SHOULD STEPS BE HERE AS THEY ARE USED EVERYWHERE?
	private float CurrentSteps;

	String title;
	private String chapter1;
	private String chapter2;
	private String chapter3;
	private String chapter4;
	private String chapter5;

	Preferences prefs;

	float screenWidth;
	float screenHeight;

	private float chapterNumber;
	//Needed to prevent creating new things every render lol, only creates this once
	private boolean swapped = false;





	public void setChapterNumber(float chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	public float getChapterNumber() {
		return chapterNumber;
	}
	public void setSwapped(boolean swapped) {
		this.swapped = swapped;
	}
	public boolean getSwapped() {
		return swapped;
	}



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

	public void setCurrentSteps(float CurrentSteps) {
		this.CurrentSteps = CurrentSteps;
	}
	public float getCurrentSteps() {
		return CurrentSteps;
	}

	public String getChapter1Text() {
		return chapter1;
	}
	public String getChapter2Text() {
		return chapter2;
	}
	public String getChapter3Text() {
		return chapter3;
	}
	public String getChapter4Text() {
		return chapter4;
	}
	public String getChapter5Text() {
		return chapter5;
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
		//GET THE SCREEN WIDTH AND HEIGHT OF YOUR CURRENT DEVICE IN PIXELS
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		System.out.println(screenWidth);
		System.out.println(screenHeight);

		//CREATE A NEW BATCH THAT IS USED EVERYWHERE
		batch = new SpriteBatch();

		//CREATE THE FONT AND SET THE INFOR NEEDED FOR IT SUCH AS FONT SIZE AND NAME AND GENERATE IT
		generator = new FreeTypeFontGenerator(Gdx.files.internal("helsinki.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = fontSize;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		font12 = generator.generateFont(parameter);

		//CREATE OR OPEN THE MyPreferences.xml FILE THAT STORES INFO ON SCENES AND SUCH
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


		//CREATE THE GAMERA THAT IS USEED THROUGHOUT THE GAME
		camera = new OrthographicCamera();
		camera.setToOrtho(false, screenWidth, screenHeight);


		//CHOOSE FINNISH
		//Locale locale = new Locale("fi", "FI");
		//CHOOSE ENGLISH
//		Locale locale = new Locale("en", "EN");

		//DEPENDS ON YOUR PHONE
		Locale locale = Locale.getDefault();

		//FINNISH AND ENGLISH TEXTS ARE CREATED HERE TO BE USED EVERYWHERE
		I18NBundle myBundle =
				I18NBundle.createBundle(Gdx.files.internal("MyBundle"), locale);
		title = myBundle.get("title");
		chapter1 = myBundle.get("chapter1");
		chapter2 = myBundle.get("chapter2");
		chapter3 = myBundle.get("chapter3");
		chapter4 = myBundle.get("chapter4");
		chapter5 = myBundle.get("chapter5");
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
