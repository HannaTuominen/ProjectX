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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Locale;

/**
	Main class where the batch, fonts, camera, buttons, localisation texts, screen width and height, chapterNumber and swapped and "MyPreferences.xml" where information is saved is created.
	These will be used in the different places of other codes.
 */

public class MainClass extends Game {
	//Batch created here and used in every single java code of the game
	private SpriteBatch batch;

	//the font is created here and used everywhere else - size and bitmapFont also
	private FreeTypeFontGenerator generator;
	private BitmapFont font12;
	private int fontSize = 20;

	//SHOULD STEPS BE HERE AS THEY ARE USED EVERYWHERE?
	private float CurrentSteps;

	//All of the names of the MyBundle things used in the FIN/ENG distinction
	private String title;
	private String chapter1;
	private String chapter2;
	private String chapter3;
	private String chapter4;
	private String chapter5;
	private String play;
	private String chapterSelect;
	private String credits;
	private String exit;
	private String back;

	//Used to check what chapters have been cleared
	private boolean clearedChapter1;
	private boolean clearedChapter2;
	private boolean clearedChapter3;
	private boolean clearedChapter4;
	private boolean clearedChapter5;

	//Created the prefs file here that is used everywhere in the code
	Preferences prefs;

	//Created the stage used everywhere in the code
	private Stage stage;

	//Screen width and height used everywhere in the code
	float screenWidth;
	float screenHeight;

	//Implement the button used everywhere in the code
	Button button;
	Texture buttonTexture1;

	//ChapterNumber is used everywhere in the code - it is the current chapter that is displayed
	private static int chapterNumber = 1;
	//Used to get and set the furthest the player has gotten in the story so evry time they press the play button in the main menu it redirects them correctly to the last chapter played
	static int currentFurthestChapter = 1;

	//Used when creating a new button to set its width and height
	float buttonWidth;
	float buttonHeight;

	//Needed to prevent creating new things every render lol, only creates this once
	private boolean swapped = false;

	//Needed to check if the PlayButton has been pressed (changed in the Button script) to set things correctly
	public static boolean playPressed = false;

	//Camera used everywhere
	public OrthographicCamera camera;


	public void createButtons(String textForAButton, int useForTheButton, float xPlace, float yPlace, float buttonWidth, float buttonHeight) {
		this.buttonHeight = buttonHeight;
		this.buttonWidth = buttonWidth;
		buttonTexture1 = new Texture(Gdx.files.internal("placeholderbutton.jpg"));
		button = new Button(this, buttonTexture1, textForAButton, useForTheButton, xPlace, yPlace, buttonWidth, buttonHeight);
		stage.addActor(button);
		Gdx.input.setInputProcessor(stage);

	}


	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	public int getChapterNumber() {
		return chapterNumber;
	}
	public void setSwapped(boolean swapped) {
		this.swapped = swapped;
	}
	public boolean getSwapped() {
		return swapped;
	}


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

	public Stage getStage() {
		return stage;
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
	public int getCurrentFurthestChapter() {
		return currentFurthestChapter;
	}

	public void setCurrentFurthestChapter(int currentFurthestChapter) {
		if(this.currentFurthestChapter <= currentFurthestChapter) {
			this.currentFurthestChapter = currentFurthestChapter;
			prefs.putInteger("currentFurthestChapter", currentFurthestChapter);
		}
	}


	public boolean getPlayPressed() {
		return playPressed;
	}
	public void setPlayPressed(boolean playPressed) {
		this.playPressed = playPressed;
	}




	public boolean getClearedChapter1() {
		return clearedChapter1;
	}
	public boolean getClearedChapter2() {
		return clearedChapter2;
	}
	public boolean getClearedChapter3() {
		return clearedChapter3;
	}
	public boolean getClearedChapter4() {
		return clearedChapter4;
	}
	public boolean getClearedChapter5() {
		return clearedChapter5;
	}



	public void setClearedChapter1(boolean clearedChapter1) {
		this.clearedChapter1 = clearedChapter1;
	}
	public void setClearedChapter2(boolean clearedChapter2) {
		this.clearedChapter2 = clearedChapter2;
	}
	public void setClearedChapter3(boolean clearedChapter3) {
		this.clearedChapter3 = clearedChapter3;
	}
	public void setClearedChapter4(boolean clearedChapter4) {
		this.clearedChapter4 = clearedChapter4;
	}
	public void setClearedChapter5(boolean clearedChapter5) {
		this.clearedChapter5 = clearedChapter5;
	}



	public String getPlay() {
		return play;
	}
	public String getChapterSelect() {
		return chapterSelect;
	}

	public String getCredits() {
		return credits;
	}

	public String getExit() {
		return exit;
	}

	public String getBack() {
		return back;
	}
	public float getButtonWidth() {
		return buttonWidth;
	}
	public float getButtonHeight() {
		return buttonWidth;
	}
	public void setFontSize(int size) {
		fontSize = size;
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

		stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);

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
		play = myBundle.get("play");
		chapterSelect = myBundle.get("chapterSelect");
		credits = myBundle.get("credits");
		exit = myBundle.get("exit");
		back = myBundle.get("back");

		chapter1 = myBundle.get("chapter1");
		chapter2 = myBundle.get("chapter2");
		chapter3 = myBundle.get("chapter3");
		chapter4 = myBundle.get("chapter4");
		chapter5 = myBundle.get("chapter5");
		//String steps = myBundle.format("steps");
		//SO YOU CAN GET TO THE GAME THROUGH THE CHAPTERSELECT SCREEN TOO I THINK
		prefs.putInteger("ChapterNumber",1 );
		prefs.putInteger("currentFurthestChapter",1);
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
