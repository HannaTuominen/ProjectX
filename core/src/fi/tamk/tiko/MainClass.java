package fi.tamk.tiko;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
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
	private int fontSize;

	//SHOULD STEPS BE HERE AS THEY ARE USED EVERYWHERE?
//	private float CurrentSteps;

	//All of the names of the MyBundle things used in the FIN/ENG distinction

	private String chapter1_1;
	private String chapter1_2;
	private String chapter1_3;

	private String chapter2_1;
	private String chapter2_2;

	private String chapter3_1;
	private String chapter3_2;

	private String chapter4_1;
	private String chapter4_2;

	private String chapter5_1;
	private String chapter5_2;

	private String title;
	private String play;
	private String chapterSelect;
	private String credits;
	private String exit;
	private String back;
	private String stepsString;
	private String previous;
	private String next;
    private String continuee;
    private String chapter1_choice_text_1;
    private String chapter1_choice_text_2
            ;
	// remove steps by: MyServices.removeSteps(int);
	static int steps;

	GlyphLayout layout;

	//Used to check what chapters have been cleared
	private boolean clearedChapter1;
	private boolean clearedChapter2;
	private boolean clearedChapter3;
	private boolean clearedChapter4;
	private boolean clearedChapter5;

	private boolean choseWrong_1 = false;
    private boolean choseWrong_2 = false;
    private boolean choseWrong_3 = false;
    private boolean choseWrong_4 = false;

	private int stepsToOpenChapter2_1;
	private int stepsToOpenChapter2_2;

	private int stepsToOpenChapter3_1;
//	private int stepsToOpenChapter3_2;

	private int stepsToOpenChapter4_1;

	private int stepsToOpenChapter5_1;

	private int stepsToOpenChapter6_1;

	//Created the prefs file here that is used everywhere in the code
	Preferences prefs;

	//Created the stage used everywhere in the code
	private Stage stage;

	//Screen width and height used everywhere in the code
	float screenWidth;
	float screenHeight;

	//Implement the button used everywhere in the code
	Button button;
	String localLanguageToString;
	Locale locale;
	I18NBundle myBundle;
	private static boolean swappedLanguage = false;

	private static boolean languageFinnish = false;
	private static boolean languageFirstRound;

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
	Group group;


	//BACKGROUND MUSIC
	Music music;
	long id;
	boolean backGroundMusicOff;



	public void setbackGroundMusicOffOrOn(boolean backGroundMusicOff) {
		prefs.putBoolean("backGroundMusicOff", backGroundMusicOff);
		this.backGroundMusicOff = backGroundMusicOff;
		prefs.flush();
	}
	public boolean getbackGroundMusicOffOrOn() {
		backGroundMusicOff = prefs.getBoolean("backGroundMusicOff");
		return backGroundMusicOff;
	}
	public void createBackGroundMusicAndLoopIt(boolean backGroundMusicOff) {
		music = Gdx.audio.newMusic(Gdx.files.internal("game_music.mp3"));
		music.setVolume(1.0f);                 // sets the volume to half the maximum volume
		music.setLooping(true);                // will repeat playback until music.stop() is called
//		music.stop();                          // stops the playback
//		music.pause();                         // pauses the playback
//		music.play();                          // resumes the playback
//		boolean isPlaying = music.isPlaying(); // obvious :)
//		boolean isLooping = music.isLooping(); // obvious as well :)
//		float position = music.getPosition();  // returns the playback position in seconds

		//first load set the backgroundmusic true
		setbackGroundMusicOffOrOn(backGroundMusicOff);
	}

	public void playBackgroundMusic() {
		music.play();                          // resumes the playback

    }

	public void stopBackGroundMusic() {
		music.pause();                         // pauses the playback
	}


	public void createButtons(Texture texture, String textForAButton, float storyID, int useForTheButton, float xPlace, float yPlace, float buttonWidth, float buttonHeight, int stepsToOpenNextChapter) {
		this.buttonHeight = buttonHeight;
		this.buttonWidth = buttonWidth;
//		buttonTexture1 = new Texture(Gdx.files.internal("button_orange.png"));
		button = new Button(this, texture, textForAButton, storyID, useForTheButton, xPlace, yPlace, buttonWidth, buttonHeight, stepsToOpenNextChapter);

		if(useForTheButton == 9 || useForTheButton == 12) {
			groupAcotrs(button);
		} else {
			stage.addActor(button);
		}
		Gdx.input.setInputProcessor(stage);

	}
	public void groupAcotrs(Actor actor) {
		group.addActor(actor);
	}
	public void clearGroup() {
	    group.clear();
    }
	public Group getGroup() {
		return group;
	}
	public void groupStageAdd() {
		stage.addActor(group);
	}

    public void setChoseWrong_1(boolean choseWrong_1) {
        this.choseWrong_1 = choseWrong_1;
        prefs.putBoolean("choseWrong_1", this.choseWrong_1);
        prefs.flush();
    }
    public boolean getChoseWrong_1() {
	    choseWrong_1 = prefs.getBoolean("choseWrong_1");
        return choseWrong_1;
    }





	public void setStepsToOpenChapter2_1(int steps) {
		stepsToOpenChapter2_1 = steps;
		prefs.putInteger("setStepsToOpenChapter2_1", stepsToOpenChapter2_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter2_1() {
		return stepsToOpenChapter2_1;
	}
	public void setStepsToOpenChapter2_2(int steps) {
		stepsToOpenChapter2_2 = steps;
		prefs.putInteger("setStepsToOpenChapter2_2", stepsToOpenChapter2_2);
		prefs.flush();
	}
	public int getStepsToOpenChapter2_2() {
		return stepsToOpenChapter2_2;
	}


	public void setStepsToOpenChapter3_1(int steps) {
		stepsToOpenChapter3_1 = steps;
		prefs.putInteger("setStepsToOpenChapter3_1", stepsToOpenChapter3_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter3_1() {
		return stepsToOpenChapter3_1;
	}


	public void setStepsToOpenChapter4_1(int steps) {
		stepsToOpenChapter4_1 = steps;
		prefs.putInteger("setStepsToOpenChapter4_1", stepsToOpenChapter4_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter4_1() {
		return stepsToOpenChapter4_1;
	}

	public void setStepsToOpenChapter5_1(int steps) {
		stepsToOpenChapter5_1 = steps;
		prefs.putInteger("setStepsToOpenChapter5_1", stepsToOpenChapter5_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter6_1() {
		return stepsToOpenChapter6_1;
	}

	public void setStepsToOpenChapter6_1(int steps) {
		stepsToOpenChapter6_1 = steps;
		prefs.putInteger("setStepsToOpenChapter6_1", stepsToOpenChapter6_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter5_1() {
		return stepsToOpenChapter5_1;
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

	public Stage getStage() {
		return stage;
	}

	public String getChapter1_1Text() {
		return chapter1_1;
	}
	public String getChapter1_2Text() {
		return chapter1_2;
	}
	public String getChapter1_3Text() {
		return chapter1_3;
	}

	public String getChapter2_1Text() {
		return chapter2_1;
	}
	public String getChapter2_2Text() {
		return chapter2_2;
	}

	public String getChapter3_1Text() {
		return chapter3_1;
	}
	public String getChapter3_2Text() {
		return chapter3_2;
	}

	public String getChapter4_1Text() {
		return chapter4_1;
	}
	public String getChapter4_2Text() {
		return chapter4_2;
	}

	public String getChapter5_1Text() {
		return chapter5_1;
	}
	public String getChapter5_2Text() {
		return chapter5_2;
	}

	public String getNext() {
		return next;
	}
    public String getChapter1_choice_text_1() {
        return chapter1_choice_text_1;
    }
    public String getChapter1_choice_text_2() {
        return chapter1_choice_text_2;
    }
	public String getPrevious() {
		return previous;
	}
    public String getContinue() {
        return continuee;
    }
	public int getCurrentFurthestChapter() {
		return currentFurthestChapter;
	}
	public String getStepsString(){
		return stepsString;
	}

	public void setCurrentFurthestChapter(int currentFurthestChapter) {
		if(this.currentFurthestChapter <= currentFurthestChapter) {
			this.currentFurthestChapter = currentFurthestChapter;
			prefs.putInteger("currentFurthestChapter", currentFurthestChapter);
			prefs.flush();
		}
	}


	public boolean getPlayPressed() {
		return playPressed;
	}
	public void setPlayPressed(boolean playPressed) {
		this.playPressed = playPressed;
	}

	public boolean getLanguageFinnish() {
		languageFinnish =prefs.getBoolean("languageFinnish");
		return languageFinnish;
	}
	public void setLanguageFinnish(boolean languageFinnish) {
		this.languageFinnish = languageFinnish;
		prefs.putBoolean("languageFinnish", languageFinnish);
		prefs.flush();
	}

	public boolean getLanguageFirstRound() {
		languageFirstRound =prefs.getBoolean("languageFirstRound");
		return languageFirstRound;
	}
	public void setLanguageFirstRound(boolean languageFirstRound) {
		this.languageFirstRound = languageFirstRound;
		prefs.putBoolean("languageFirstRound", languageFirstRound);
		prefs.flush();
	}
	public boolean getSwappedlanguage() {
		return swappedLanguage;
	}

	public void setSwappedlanguage(boolean swappedLanguage) {
		this.swappedLanguage = swappedLanguage;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
		swappedLanguage = true;
		myBundle =
				I18NBundle.createBundle(Gdx.files.internal("MyBundle"), locale);
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocaleTexts() {

		title = myBundle.get("title");
		play = myBundle.get("play");
		chapterSelect = myBundle.get("chapterSelect");
		credits = myBundle.get("credits");
		exit = myBundle.get("exit");
		back = myBundle.get("back");

		chapter1_choice_text_1 = myBundle.get("chapter1_choice_text_1");
		chapter1_choice_text_2 = myBundle.get("chapter1_choice_text_2");
		chapter1_1 = myBundle.get("chapter1_1");
		chapter1_2 = myBundle.get("chapter1_2");
        chapter1_3 = myBundle.get("chapter1_3");

		chapter2_1 = myBundle.get("chapter2_1");
		chapter2_2 = myBundle.get("chapter2_2");

		chapter3_1 = myBundle.get("chapter3_1");
		chapter3_2 = myBundle.get("chapter3_2");

		chapter4_1 = myBundle.get("chapter4_1");
		chapter4_2 = myBundle.get("chapter4_2");

		chapter5_1 = myBundle.get("chapter5_1");
		chapter5_2 = myBundle.get("chapter5_2");

		stepsString = myBundle.get("stepString");
		previous = myBundle.get("previous");
		next = myBundle.get("next");
		continuee = myBundle.get("continuee");
	}
	public void setDefaultLocale() {
		locale = Locale.getDefault();
		localLanguageToString = java.util.Locale.getDefault().toString();
		setLocale(locale);
		setLocalLanguageToString(localLanguageToString);
		prefs.putString("localLanguageToString", localLanguageToString);
		prefs.flush();
	}

	public void setLocalLanguageToString(String localLanguageToString) {
		this.localLanguageToString = localLanguageToString;
		prefs.putString("localLanguageToString", this.localLanguageToString);
		prefs.flush();
	}

	public String getlocalLanguageToString() {
		localLanguageToString = prefs.getString("localLanguageToString");
		return localLanguageToString;
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
		buttonWidth = screenWidth/2;
		return buttonWidth;
	}
	public float getButtonHeight()
	{	buttonHeight = screenHeight/2;
		return buttonWidth;
	}

	public int getFontSize() {
		return fontSize;
	}

	public float getTextPlaceWIDTH(String text) {
		layout.setText(font12,text);
		float width = layout.width;
		return width;
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
		layout = new GlyphLayout();

		//CREATE A NEW BATCH THAT IS USED EVERYWHERE
		batch = new SpriteBatch();

		//CREATE THE FONT AND SET THE INFOR NEEDED FOR IT SUCH AS FONT SIZE AND NAME AND GENERATE IT
		generator = new FreeTypeFontGenerator(Gdx.files.internal("sui-generis-rg.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		if(screenHeight < 800) {
			fontSize = 20;
		} else if (screenHeight >= 1000) {
			fontSize = 40;
		}
		parameter.size = fontSize;

//		parameter.borderColor = Color.BLACK;
//		parameter.borderWidth = 3;
		font12 = generator.generateFont(parameter);

		font12.setColor(Color.BLACK);

		//CREATE OR OPEN THE MyPreferences.xml FILE THAT STORES INFO ON SCENES AND SUCH
		//Create or open file MyPreferences.xml
		prefs = Gdx.app.getPreferences("MyPreferences");

		stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);

		//CREATE THE GAMERA THAT IS USEED THROUGHOUT THE GAME
		camera = new OrthographicCamera();
		camera.setToOrtho(false, screenWidth, screenHeight);

		group = new Group();
		if(languageFirstRound == false) {
			languageFirstRound = prefs.getBoolean("languageFirstRound");
			prefs.putBoolean("languageFirstRound", true);
			prefs.flush();

			backGroundMusicOff = prefs.getBoolean("backGroundMusicOff");
			createBackGroundMusicAndLoopIt(backGroundMusicOff);
			System.out.println("CREATED A NEW BACKGROUND SOUND AND SET IT FALSE");

		}

//		if(backGroundMusicOff != prefs.getBoolean("backGroundMusicOff")) {
//			createBackGroundMusicAndLoopIt(true);
//		}
		System.out.println("IS SOUND OFF AT THE START: " + getbackGroundMusicOffOrOn());

		if(!getbackGroundMusicOffOrOn()) {
			playBackgroundMusic();
			System.out.println("MAINCLASS PLAY MUSIC");
		} else {
			stopBackGroundMusic();
			System.out.println("MAINCLASS DON'T PLAY MUSIC");
		}


		if(languageFirstRound != prefs.getBoolean("languageFirstRound")) {
			System.out.println("ERI FIRSTROUND LANGUAGE KUN TALLESSA" + languageFirstRound + " AND " + prefs.getBoolean("languageFirstRound"));
			System.out.println("LANGUAGE FALSE");
			setDefaultLocale();
//			getbackGroundMusicOffOrOff();
			languageFirstRound = prefs.getBoolean("languageFirstRound");
			prefs.flush();



			if(localLanguageToString.equals("fi_FI")) {
				System.out.println("LOCAL LANGUAGE FINNISH");
				languageFinnish = true;
				prefs.putBoolean("languageFinnish", true);
				setLocalLanguageToString("fi_FI");
				setLocaleTexts();
				prefs.flush();
				System.out.println("local language: " + localLanguageToString);
			} else {
				languageFinnish = false;
				prefs.putBoolean("languageFinnish", false);
				setLocalLanguageToString("en_EN");
				setLocaleTexts();
				prefs.flush();
				System.out.println("local language: " + localLanguageToString);
			}
		} else {
			languageFirstRound = prefs.getBoolean("languageFirstRound");
			getlocalLanguageToString();
			System.out.println("local language: " + localLanguageToString);
			prefs.flush();
			if(localLanguageToString.equals("fi_FI")) {
				System.out.println("LOCAL LANGUAGE FINNISH");
				languageFinnish = true;
				prefs.putBoolean("languageFinnish", true);
				setLocale(new Locale("fi", "FI"));
				setLocaleTexts();
				prefs.flush();
			} else {
				languageFinnish = false;
				prefs.putBoolean("languageFinnish", false);
				setLocale(new Locale("en", "EN"));
				setLocaleTexts();
				prefs.flush();
			}
		}
//		Locale locale = new Locale("en", "EN");


		//FINNISH AND ENGLISH TEXTS ARE CREATED HERE TO BE USED EVERYWHERE
		myBundle =
				I18NBundle.createBundle(Gdx.files.internal("MyBundle"), locale);

		//String steps = myBundle.format("steps");

		prefs.flush();


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

	public static void setSteps(int numSteps) {
		steps = numSteps;
	}
	public static int getSteps() {
		return steps;
	}
	public int getCurrentSteps() {
		return steps;
	}
	public void removeSteps(int steps) {
		if (steps <= this.getCurrentSteps()) {
			setSteps(this.getCurrentSteps() - steps);
		} else {
			System.out.println("ERROR: Not enough steps");
		}
	}
}
