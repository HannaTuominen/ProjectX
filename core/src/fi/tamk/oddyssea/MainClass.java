package fi.tamk.oddyssea;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
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
 * Main class where the batch, fonts, camera, buttons, localisation texts, screen width and height, chapterNumber and swapped and "MyPreferences.xml" where information is saved is created.
 * These will be used in the different places of other codes.
 *
 * @author Hanna Tuominen
 * @version 24.4.2019
 * @since 15.01.2019
 */

public class MainClass extends Game {
    /**
     * SpriteBatch batch created here and used in every single java code of the game.
     */
	private SpriteBatch batch;
    /**
     * FreeTypeFontGenerator generator is used when the font is created here and used everywhere else - size and bitmapFont also.
     */
	private FreeTypeFontGenerator generator;
    /**
     * BitmapFont font12 - used everywhere that needs text font.
     */
	private BitmapFont font12;
    /**
     * int fontSize sets the font size depending on the screen size.
     */
	private int fontSize;
    /**
     * Boolean resetEverything is used to determine whether the game should be reset.
     * Either in the end if you player decides to go the party of through main menus reset game button.
     */
	private boolean resetEverything = false;
    /**
     * Boolean prefsPopUpActive is used to check if the reset game popup in main menu is active
     */
	private boolean prefsPopUpActivate;
    /**
     * Boolean tutorialShow is used to check if the tutorial should be shown and is show currently
     */
	private boolean tutorialShow;
    /**
     * Boolean tooFewStepsPopUpActivate is used to check if the error message for too few steps is activate or not or if it should be
     */
	private boolean tooFewStepsPopUpActivate;
    /**
     * String chapter1_1 .... All of the names of the MyBundle things used in the FIN/ENG distinction for chapter texts
     */
	private String chapter1_1, chapter1_2, chapter1_3,
			chapter2_1, chapter2_2,
			chapter3_1, chapter3_2,
			chapter4_1, chapter4_2,
			chapter5_1, chapter5_2, chapter5_3,
			chapter6_1, chapter6_2, chapter6_3,
			chapter7_1, chapter7_2, chapter7_3,
			chapter8_1, chapter8_2, chapter8_3,
			chapter9_1, chapter9_2, chapter9_3, chapter9_4,
			chapter10_1, chapter10_2, chapter10_3,
			chapter11_1, chapter11_2, chapter11_3, chapter11_4,
			chapter12_1, chapter12_2, chapter12_3, chapter12_4,
			chapter13_1, chapter13_2, chapter13_3, chapter13_4,
			chapter14_1, chapter14_2, chapter14_3, chapter14_4,
			chapter15_1, chapter15_2, chapter15_3, chapter15_4, chapter15_5,
			chapter16_1, chapter16_2, chapter16_3, chapter16_4, chapter16_5,
			chapter17_1, chapter17_2, chapter17_3, chapter17_4, chapter17_5, chapter17_6, chapter17_7, chapter17_8,
			chapter18_1, chapter18_2, chapter18_3, chapter18_4, chapter18_5,
			chapter19_1, chapter19_2, chapter19_3, chapter19_4,
			chapter20_1, chapter20_2, chapter20_3, chapter20_4,
			chapter21_1, chapter21_2, chapter21_3, chapter21_4, chapter21_5,
			chapter22_1, chapter22_2, chapter22_3, chapter22_4, chapter22_5, chapter22_6, chapter22_7,
			chapter23_1, chapter23_2, chapter23_3, chapter23_4;
    /**
     * String resetGame the MyBundle thing used in the FIN/ENG distinction for reset game button in main menu
     */
    private String resetGame;
    /**
     * String resetGameQuestion the MyBundle thing used in the FIN/ENG distinction for reset game text in main menu popup
     */
    private String resetGameQuestion;
    /**
     * String yes the MyBundle thing used in the FIN/ENG distinction for reset game box yes button in main menu popup
     */
    private String yes;
    /**
     * String no the MyBundle thing used in the FIN/ENG distinction for reset game box no button in main menu popup
     */
    private String no;
    /**
     * String ok the MyBundle thing used in the FIN/ENG distinction for not enough steps and tutorial popup button in the gameScreen
     */
    private String ok;
    /**
     * String tutorialText the MyBundle thing used in the FIN/ENG distinction for tutorial text popup in the gameScreen
     */
    private String tutorialText;
    /**
     * String tutorialText the MyBundle thing used in the FIN/ENG distinction for too few steps text popup in the gameScreen
     */
    private String tooFewStepsMessage;
    /**
     * String tutorialText the MyBundle thing used in the FIN/ENG distinction for tutorial text popup in the gameScreen
     */
    private String backToMainMenu;
    /**
     * String title the MyBundle thing used in the FIN/ENG distinction nowhere at ths moment but it contains the tittle of the game
     */
	private String title;
    /**
     * String play the MyBundle thing used in the FIN/ENG distinction for continuing the game / start a new game in main menu button
     */
	private String play;
    /**
     * String chapterSelect the MyBundle thing used in the FIN/ENG distinction for chapterselect button in main menu
     */
	private String chapterSelect;
    /**
     * String credits the MyBundle thing used in the FIN/ENG distinction for credits button in main menu
     */
	private String credits;
    /**
     * String exit the MyBundle thing used in the FIN/ENG distinction for exit button in main menu
     */
	private String exit;
    /**
     * String back the MyBundle thing used in the FIN/ENG distinction back button not in use anywhere at the moment
     */
	private String back;
    /**
     * String stepsString the MyBundle thing used in the FIN/ENG distinction for steps in gameScreen/button
     */
	private String stepsString;
    /**
     * String previous the MyBundle thing used in the FIN/ENG distinction for previous chapter not in use at the moment
     */
	private String previous;
    /**
     * String next the MyBundle thing used in the FIN/ENG distinction for next chapter not in use at the moment
     */
	private String next;
    /**
     * String continuee the MyBundle thing used in the FIN/ENG distinction for continue/play used in main menu
     */
    private String continuee;
    /**
     * String chapter1_choice_text_1 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 1 and chapter number 1
     */
    private String chapter1_choice_text_1;
    /**
     * String chapter1_choice_text_2 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 2 and chapter number 1
     */
    private String chapter1_choice_text_2;
    /**
     * String chapter4_choice_text_1 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 1 and chapter number 4
     */
	private String chapter4_choice_text_1;
    /**
     * String chapter4_choice_text_2 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 2 and chapter number 4
     */
	private String chapter4_choice_text_2;
    /**
     * String chapter11_choice_text_1 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 1 and chapter number 11
     */
	private String chapter11_choice_text_1;
    /**
     * String chapter11_choice_text_2 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 2 and chapter number 11
     */
	private String chapter11_choice_text_2;
    /**
     * String chapter17_choice_text_1 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 1 and chapter number 17
     */
	private String chapter17_choice_text_1;
    /**
     * String chapter17_choice_text_2 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 2 and chapter number 17
     */
	private String chapter17_choice_text_2;
    /**
     * String chapter23_choice_text_1 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 1 and chapter number 23
     */
	private String chapter23_choice_text_1;
    /**
     * String chapter23_choice_text_2 .... is used for the MyBundle thing used in the FIN/ENG distinction for
     * the choice texts in the gameScreen/Button depending on player choice number 2 and chapter number 23
     */
	private String chapter23_choice_text_2;
    /**
     * String chapter is used for the MyBundle thing used in the FIN/ENG distinction for
     * the chapter text in mainGame bottom left screen
     */
    private String chapter;
    /**
     * String sponsors is used for the MyBundle thing used in the FIN/ENG distinction for
     * sponsor texts - not used anywhere currently
     */
    private String sponsors;
    /**
     * int steps used for the steps all over the and MainClass specifically get and set and remove steps methods
     */
	private static int steps;
    /**
     * GlyphLayout layout used for the font
     */
	private GlyphLayout layout;
    /**
     * boolean choseWrong_1 used for chapter 1 choice.
     */
	private boolean choseWrong_1 = false;
    /**
     * boolean choseWrong_1 used for chapter 4 choice.
     */
    private boolean choseWrong_2 = false;
    /**
     * boolean choseWrong_1 used for chapter 17 choice.
     */
    private boolean choseWrong_3 = false;
    /**
     * boolean choseWrong_1 used for chapter 23 choice.
     */
    private boolean choseWrong_4 = false;
    /**
     * int stepsToOpenChapter2_1 used for to define neeeded steps to open chapter 2.
     */
	private int stepsToOpenChapter2_1;
    /**
     * int stepsToOpenChapter2_2 used for to define neeeded steps to open chapter 2.
     */
	private int stepsToOpenChapter2_2;
    /**
     * int stepsToOpenChapter3_1 used for to define neeeded steps to open chapter 3.
     */
	private int stepsToOpenChapter3_1;
    /**
     * int stepsToOpenChapter4_1 used for to define neeeded steps to open chapter 4.
     */
	private int stepsToOpenChapter4_1;
    /**
     * int stepsToOpenChapter5_1 used for to define neeeded steps to open chapter 5.
     */
	private int stepsToOpenChapter5_1;
    /**
     * int stepsToOpenChapter5_2 used for to define neeeded steps to open chapter 5.
     */
	private int stepsToOpenChapter5_2;
    /**
     * int stepsToOpenChapter6_1 used for to define neeeded steps to open chapter 6.
     */
	private int stepsToOpenChapter6_1;
    /**
     * int stepsToOpenChapter7_1 used for to define neeeded steps to open chapter 7.
     */
	private int stepsToOpenChapter7_1;
    /**
     * int stepsToOpenChapter8_1 used for to define neeeded steps to open chapter 8.
     */
	private int stepsToOpenChapter8_1;
    /**
     * int stepsToOpenChapter9_1 used for to define neeeded steps to open chapter 9.
     */
	private int stepsToOpenChapter9_1;
    /**
     * int stepsToOpenChapter10_1 used for to define neeeded steps to open chapter 10.
     */
	private int stepsToOpenChapter10_1;
    /**
     * int stepsToOpenChapter11_1 used for to define neeeded steps to open chapter 11.
     */
	private int stepsToOpenChapter11_1;
    /**
     * int stepsToOpenChapter12_1 used for to define neeeded steps to open chapter 12.
     */
	private int stepsToOpenChapter12_1;
    /**
     * int stepsToOpenChapter12_2 used for to define neeeded steps to open chapter 2.
     */
	private int stepsToOpenChapter12_2;
    /**
     * int stepsToOpenChapter13_1 used for to define neeeded steps to open chapter 13.
     */
	private int stepsToOpenChapter13_1;
    /**
     * int stepsToOpenChapter14_1 used for to define neeeded steps to open chapter 14.
     */
	private int stepsToOpenChapter14_1;
    /**
     * int stepsToOpenChapter15_1 used for to define neeeded steps to open chapter 15.
     */
	private int stepsToOpenChapter15_1;
    /**
     * int stepsToOpenChapter16_1 used for to define neeeded steps to open chapter 16.
     */
	private int stepsToOpenChapter16_1;
    /**
     * int stepsToOpenChapter17_1 used for to define neeeded steps to open chapter 17.
     */
	private int stepsToOpenChapter17_1;
    /**
     * int stepsToOpenChapter18_1 used for to define neeeded steps to open chapter 18.
     */
	private int stepsToOpenChapter18_1;
    /**
     * int stepsToOpenChapter18_2 used for to define neeeded steps to open chapter 18.
     */
	private int stepsToOpenChapter18_2;
    /**
     * int stepsToOpenChapter19_1 used for to define neeeded steps to open chapter 19.
     */
	private int stepsToOpenChapter19_1;
    /**
     * int stepsToOpenChapter20_1 used for to define neeeded steps to open chapter 20.
     */
	private int stepsToOpenChapter20_1;
    /**
     * int stepsToOpenChapter21_1 used for to define neeeded steps to open chapter 21.
     */
	private int stepsToOpenChapter21_1;
    /**
     * int stepsToOpenChapter22_1 used for to define neeeded steps to open chapter 22.
     */
	private int stepsToOpenChapter22_1;
    /**
     * int stepsToOpenChapter23_1 used for to define neeeded steps to open chapter 23.
     */
	private int stepsToOpenChapter23_1;
    /**
     * preferences prefs used to save important information of the game needed on reload etc.
     */
	Preferences prefs;
    /**
     * preferences soundAnLanguage used to save important sound and language settings in a different file so they are not affected on resetting the game.
     */
	Preferences soundAndLanguage;
    /**
     * Stage stage created the stage used everywhere in the code
     */
	private Stage stage;
    /**
     * float screenWidth is used to determine the current width of the used platform in pixels(android or desktop) and used everywhere
     */
	float screenWidth;
    /**
     * float screenHeight is used to determine the current height of the used platform in pixels(android or desktop)
     */
	float screenHeight;
    /**
     * Button button is used to create the universal button (mainClass createbuttons()) that are created and used everywhere.
     */
	private Button button;
    /**
     * Button button is used to create the universal button for useForTheButton5 (mainClass createbuttons()) that are created and used everywhere.
     */
    private Button button5;
    /**
     * Button button is used to create the universal button for useForTheButton6 (mainClass createbuttons()) that are created and used everywhere.
     */
    private Button button6;
    /**
     * String localLanguageToString is used to check the current local language used in the system and getting either fi_FI or en_EN and swapped between those
     */
    private String localLanguageToString;
    /**
     * Locale locale use or the languages for the game
     */
    private Locale locale;
    /**
     * I18NBundle myBundle used to get language texts from the properties files and saving them to their local Strings
     */
    private I18NBundle myBundle;
    /**
     * boolean swappedLanguage is used to check if the language has been swapped and a reload of texts is needed
     */
	private static boolean swappedLanguage = false;
    /**
     * boolean languageFinnish is used to check if the language is currently finnish or not and doing the appropriate changes depending on  if it's true or false in the button script and MainClass
     */
	private static boolean languageFinnish = false;
    /**
     *  boolean languageFirstRound is used to check if the game is being loaded for the first time language wise and used to check the users system language
     */
	private static boolean languageFirstRound;
    /**
     *  int chapterNumber is used everywhere in the code - it is the current chapter that is displayed on screen
     */
	private static int chapterNumber = 1;
    /**
     *  int currentFurthestChapter is used to get and set the furthest the player has gotten in the story so every time they press the play button in the main menu
     *  it redirects them correctly to the last chapter played
     */
    private static int currentFurthestChapter = 1;
    /**
     * float buttonWidth is used when creating a new button to set its basic universal width depending on screen width that can be changed manually
     */
    private float buttonWidth;
    /**
     * float buttonheight is used when creating a new button to set its basic universal height depending on screen height that can be changed manually
     */
    private float buttonHeight;
    /**
     * boolean swapped is needed to prevent creating new things every render lol, only creates this once when clearing screen and getting new chapters and buttons etc.
     */
	private boolean swapped = false;
    /**
     * boolean playPressed is needed to check if the PlayButton has been pressed and not getting to the chapter through the chapterSelect (changed in the Button script) to set things correctly
     * to the curerntly fursthest chapter.
     */
	public static boolean playPressed = false;
    /**
     * OrthographicCamera camera used on the whole game. Only one camera.
     */
	public OrthographicCamera camera;
    /**
     * Group group used to group the chapter select buttons in buttons script to make them move in a group
     */
    private Group group;
    /**
     * Group group2 used to group clear prefs popup buttons to make things easier to move etc.
     */
    private Group group2;
    /**
     * Group group3 used to group the tutorial buttons in chapter 1 to make things easier to move etc.
     */
    private Group group3;
    /**
     * Group group4 used to group the error too few steps buttons in mame screen to make things easier to move etc.
     */
    private Group group4;
    /**
     * boolean gotToLastTextPartOkayToShowNeededButtons is used in button script when clicking through the story
     * as you need to go through the story to the last place to show the buttons you need to get to the next chapter
     * this is checked every time you open the game again/ press play to see if you have already read it once.
     */
	private boolean gotToLastTextPartOkayToShowNeededButtons = false;
    /**
     * boolean gotToTheLastTextOnceAlready is used in button script to check if the player has skimmed through the story
     * to the last part already once and should the buttons be shown upon reopening the gameScreen or not
     * this is checked every time you open the game again/ press play to see if you have already read it through.
     */
	private boolean gotToTheLastTextOnceAlready = false;
    /**
     * Music music is the background music of the game
     */
    private Music music;
    /**
     * boolean backGroundMusicOff is a boolean used to check if the background music is off or on currently or when changed
     * using the buttons in the game.
     */
    private boolean backGroundMusicOff;
    /**
     * Texture textIndicator_2_1 is used for the texture when texture indicator is size 2 (biggest) space 1
     */
    private Texture textIndicator_2_1;
    /**
     * Texture textIndicator_2_2 is used for the texture when texture indicator is size 2 (biggest) space 2
     */
    private Texture textIndicator_2_2;
    /**
     * Texture textIndicator_3_1 is used for the texture when texture indicator is size 3 space 1
     */
    private Texture textIndicator_3_1;
    /**
     * Texture textIndicator_3_2 is used for the texture when texture indicator is size 3 space 2
     */
    private Texture textIndicator_3_2;
    /**
     * Texture textIndicator_3_3 is used for the texture when texture indicator is size 3 space 3
     */
    private Texture textIndicator_3_3;
    /**
     * Texture textIndicator_4_1 is used for the texture when texture indicator is size 4 space 1
     */
    private Texture textIndicator_4_1;
    /**
     * Texture textIndicator_4_2 is used for the texture when texture indicator is size 4 space 2
     */
    private Texture textIndicator_4_2;
    /**
     * Texture textIndicator_4_3 is used for the texture when texture indicator is size 4 space 3
     */
    private Texture textIndicator_4_3;
    /**
     * Texture textIndicator_4_4 is used for the texture when texture indicator is size 4 space 4
     */
    private Texture textIndicator_4_4;
    /**
     * Texture textIndicator_5_1 is used for the texture when texture indicator is size 5 space 1
     */
    private Texture textIndicator_5_1;
    /**
     * Texture textIndicator_5_2 is used for the texture when texture indicator is size 5 space 2
     */
    private Texture textIndicator_5_2;
    /**
     * Texture textIndicator_5_3 is used for the texture when texture indicator is size 5 space 3
     */
    private Texture textIndicator_5_3;
    /**
     * Texture textIndicator_5_4 is used for the texture when texture indicator is size 5 space 4
     */
    private Texture textIndicator_5_4;
    /**
     * Texture textIndicator_5_5 is used for the texture when texture indicator is size 5 space 5
     */
    private Texture textIndicator_5_5;
    /**
     * Texture textIndicator_6_1 is used for the texture when texture indicator is size 6 space 1
     */
    private Texture textIndicator_6_1;
    /**
     * Texture textIndicator_6_2 is used for the texture when texture indicator is size 6 space 2
     */
    private Texture textIndicator_6_2;
    /**
     * Texture textIndicator_6_3 is used for the texture when texture indicator is size 6 space 3
     */
    private Texture textIndicator_6_3;
    /**
     * Texture textIndicator_6_4 is used for the texture when texture indicator is size 6 space 4
     */
    private Texture textIndicator_6_4;
    /**
     * Texture textIndicator_6_5 is used for the texture when texture indicator is size 6 space 5
     */
    private Texture textIndicator_6_5;
    /**
     * Texture textIndicator_6_6 is used for the texture when texture indicator is size 6 space 6
     */
    private Texture textIndicator_6_6;
    /**
     * Texture textIndicator_7_1 is used for the texture when texture indicator is size 7 space 1
     */
    private Texture textIndicator_7_1;
    /**
     * Texture textIndicator_7_2 is used for the texture when texture indicator is size 7 space 2
     */
    private Texture textIndicator_7_2;
    /**
     * Texture textIndicator_7_3 is used for the texture when texture indicator is size 7 space 3
     */
    private Texture textIndicator_7_3;
    /**
     * Texture textIndicator_7_4 is used for the texture when texture indicator is size 7 space 4
     */
    private Texture textIndicator_7_4;
    /**
     * Texture textIndicator_7_5 is used for the texture when texture indicator is size 7 space 5
     */
    private Texture textIndicator_7_5;
    /**
     * Texture textIndicator_7_6 is used for the texture when texture indicator is size 7 space 6
     */
    private Texture textIndicator_7_6;
    /**
     * Texture textIndicator_7_7 is used for the texture when texture indicator is size 7 space 7
     */
    private Texture textIndicator_7_7;
    /**
     * Texture textIndicator_8_1 is used for the texture when texture indicator is size 8 space 1
     */
    private Texture textIndicator_8_1;
    /**
     * Texture textIndicator_8_2 is used for the texture when texture indicator is size 8 space 2
     */
    private Texture textIndicator_8_2;
    /**
     * Texture textIndicator_8_3 is used for the texture when texture indicator is size 8 space 3
     */
    private Texture textIndicator_8_3;
    /**
     * Texture textIndicator_8_4 is used for the texture when texture indicator is size 8 space 4
     */
    private Texture textIndicator_8_4;
    /**
     * Texture textIndicator_8_5 is used for the texture when texture indicator is size 8 space 5
     */
    private Texture textIndicator_8_5;
    /**
     * Texture textIndicator_8_6 is used for the texture when texture indicator is size 8 space 6
     */
    private Texture textIndicator_8_6;
    /**
     * Texture textIndicator_8_7 is used for the texture when texture indicator is size 8 space 7
     */
    private Texture textIndicator_8_7;
    /**
     * Texture textIndicator_8_8 is used for the texture when texture indicator is size 8 space 8
     */
    private Texture textIndicator_8_8;

    /**
	 * setResetEverything method to swap the soundAndLanguage prefs and resetEverything local boolean on what is needed
     * <p>
     * setResetEverything is used either in mainMenu when pressing the reset game buttons and pressing yes or when you
     * go to the party if last chapter(23) and if it's true the game is then free to reset prefs once to clear them.
     * Both of these instances are accessed in the button script. And also a few other places just in case they are not correctly set for some reason.
	 * @param resetEverything is a boolean used to check if the game should reset everything to its initial state
	 */
	public void setResetEverything(boolean resetEverything) {
        soundAndLanguage.putBoolean("resetEverything", resetEverything);
        this.resetEverything = resetEverything;
        soundAndLanguage.flush();
    }

    /**
     * getResetEverything is used to check what is currently saved in resetEverything and if there should be change in resetting the game
     * @return the current resetEverything that has been saved in soundAndLanguage prefs
     */
    public boolean getResetEverything() {
	    resetEverything = soundAndLanguage.getBoolean("resetEverything");
	    return resetEverything;
    }

    /**
     * sets the current newest texture needed in the indicator (Games bottom middle).
     * @param textIndicator_2_1 indicator size is biggest (2 next to each other) and the place is leftest (1).
     */
	public void setTextIndicator_2_1(Texture textIndicator_2_1) {
		this.textIndicator_2_1 = textIndicator_2_1;
	}

    /**
     *  gets the current newest texture needed in the indicator (Games bottom middle).
     * @return indicator size is biggest (2 next to each other) and the place is leftest (1).
     */
	public Texture getTextIndicator_2_1() {
		return textIndicator_2_1;
	}
	public void setTextIndicator_2_2(Texture textIndicator_2_2) {
		this.textIndicator_2_2 = textIndicator_2_2;
	}
	public Texture getTextIndicator_2_2() {
		return textIndicator_2_2;
	}



	public void setTextIndicator_3_1(Texture textIndicator_3_1) {
		this.textIndicator_3_1 = textIndicator_3_1;
	}
	public Texture getTextIndicator_3_1() {
		return textIndicator_3_1;
	}
	public void setTextIndicator_3_2(Texture textIndicator_3_2) {
		this.textIndicator_3_2 = textIndicator_3_2;
	}
	public Texture getTextIndicator_3_2() {
		return textIndicator_3_2;
	}
	public void setTextIndicator_3_3(Texture textIndicator_3_3) {
		this.textIndicator_3_3 = textIndicator_3_3;
	}
	public Texture getTextIndicator_3_3() {
		return textIndicator_3_3;
	}


	public void setTextIndicator_4_1(Texture textIndicator_4_1) {
		this.textIndicator_4_1 = textIndicator_4_1;
	}
	public Texture getTextIndicator_4_1() {
		return textIndicator_4_1;
	}
	public void setTextIndicator_4_2(Texture textIndicator_4_2) {
		this.textIndicator_4_2 = textIndicator_4_2;
	}
	public Texture getTextIndicator_4_2() {
		return textIndicator_4_2;
	}
	public void setTextIndicator_4_3(Texture textIndicator_4_3) {
		this.textIndicator_4_3 = textIndicator_4_3;
	}
	public Texture getTextIndicator_4_3() {
		return textIndicator_4_3;
	}
	public void setTextIndicator_4_4(Texture textIndicator_4_4) {
		this.textIndicator_4_4 = textIndicator_4_4;
	}
	public Texture getTextIndicator_4_4() {
		return textIndicator_4_4;
	}


	public void setTextIndicator_5_1(Texture textIndicator_5_1) {
		this.textIndicator_5_1 = textIndicator_5_1;
	}
	public Texture getTextIndicator_5_1() {
		return textIndicator_5_1;
	}
	public void setTextIndicator_5_2(Texture textIndicator_5_2) {
		this.textIndicator_5_2 = textIndicator_5_2;
	}
	public Texture getTextIndicator_5_2() {
		return textIndicator_5_2;
	}
	public void setTextIndicator_5_3(Texture textIndicator_5_3) {
		this.textIndicator_5_3 = textIndicator_5_3;
	}
	public Texture getTextIndicator_5_3() {
		return textIndicator_5_3;
	}
	public void setTextIndicator_5_4(Texture textIndicator_5_4) {
		this.textIndicator_5_4 = textIndicator_5_4;
	}
	public Texture getTextIndicator_5_4() {
		return textIndicator_5_4;
	}
	public void setTextIndicator_5_5(Texture textIndicator_5_5) {
		this.textIndicator_5_5 = textIndicator_5_5;
	}
	public Texture getTextIndicator_5_5() {
		return textIndicator_5_5;
	}


	public void setTextIndicator_6_1(Texture textIndicator_6_1) {
		this.textIndicator_6_1 = textIndicator_6_1;
	}
	public Texture getTextIndicator_6_1() {
		return textIndicator_6_1;
	}
	public void setTextIndicator_6_2(Texture textIndicator_6_2) {
		this.textIndicator_6_2 = textIndicator_6_2;
	}
	public Texture getTextIndicator_6_2() {
		return textIndicator_6_2;
	}
	public void setTextIndicator_6_3(Texture textIndicator_6_3) {
		this.textIndicator_6_3 = textIndicator_6_3;
	}
	public Texture getTextIndicator_6_3() {
		return textIndicator_6_3;
	}
	public void setTextIndicator_6_4(Texture textIndicator_6_4) {
		this.textIndicator_6_4 = textIndicator_6_4;
	}
	public Texture getTextIndicator_6_4() {
		return textIndicator_6_4;
	}
	public void setTextIndicator_6_5(Texture textIndicator_6_5) {
		this.textIndicator_6_5 = textIndicator_6_5;
	}
	public Texture getTextIndicator_6_5() {
		return textIndicator_6_5;
	}
	public void setTextIndicator_6_6(Texture textIndicator_6_6) {
		this.textIndicator_6_6 = textIndicator_6_6;
	}
	public Texture getTextIndicator_6_6() {
		return textIndicator_6_6;
	}



	public void setTextIndicator_7_1(Texture textIndicator_7_1) {
		this.textIndicator_7_1 = textIndicator_7_1;
	}
	public Texture getTextIndicator_7_1() {
		return textIndicator_7_1;
	}
	public void setTextIndicator_7_2(Texture textIndicator_7_2) {
		this.textIndicator_7_2 = textIndicator_7_2;
	}
	public Texture getTextIndicator_7_2() {
		return textIndicator_7_2;
	}
	public void setTextIndicator_7_3(Texture textIndicator_7_3) {
		this.textIndicator_7_3 = textIndicator_7_3;
	}
	public Texture getTextIndicator_7_3() {
		return textIndicator_7_3;
	}
	public void setTextIndicator_7_4(Texture textIndicator_7_4) {
		this.textIndicator_7_4 = textIndicator_7_4;
	}
	public Texture getTextIndicator_7_4() {
		return textIndicator_7_4;
	}
	public void setTextIndicator_7_5(Texture textIndicator_7_5) {
		this.textIndicator_7_5 = textIndicator_7_5;
	}
	public Texture getTextIndicator_7_5() {
		return textIndicator_7_5;
	}
	public void setTextIndicator_7_6(Texture textIndicator_7_6) {
		this.textIndicator_7_6 = textIndicator_7_6;
	}
	public Texture getTextIndicator_7_6() {
		return textIndicator_7_6;
	}
	public void setTextIndicator_7_7(Texture textIndicator_7_7) {
		this.textIndicator_7_7 = textIndicator_7_7;
	}
	public Texture getTextIndicator_7_7() {
		return textIndicator_7_7;
	}


	public void setTextIndicator_8_1(Texture textIndicator_8_1) {
		this.textIndicator_8_1 = textIndicator_8_1;
	}
	public Texture getTextIndicator_8_1() {
		return textIndicator_8_1;
	}
	public void setTextIndicator_8_2(Texture textIndicator_8_2) {
		this.textIndicator_8_2 = textIndicator_8_2;
	}
	public Texture getTextIndicator_8_2() {
		return textIndicator_8_2;
	}
	public void setTextIndicator_8_3(Texture textIndicator_8_3) {
		this.textIndicator_8_3 = textIndicator_8_3;
	}
	public Texture getTextIndicator_8_3() {
		return textIndicator_8_3;
	}
	public void setTextIndicator_8_4(Texture textIndicator_8_4) {
		this.textIndicator_8_4 = textIndicator_8_4;
	}
	public Texture getTextIndicator_8_4() {
		return textIndicator_8_4;
	}
	public void setTextIndicator_8_5(Texture textIndicator_8_5) {
		this.textIndicator_8_5 = textIndicator_8_5;
	}
	public Texture getTextIndicator_8_5() {
		return textIndicator_8_5;
	}
	public void setTextIndicator_8_6(Texture textIndicator_8_6) {
		this.textIndicator_8_6 = textIndicator_8_6;
	}
	public Texture getTextIndicator_8_6() {
		return textIndicator_8_6;
	}
	public void setTextIndicator_8_7(Texture textIndicator_8_7) {
		this.textIndicator_8_7 = textIndicator_8_7;
	}
	public Texture getTextIndicator_8_7() {
		return textIndicator_8_7;
	}
	public void setTextIndicator_8_8(Texture textIndicator_8_8) {
		this.textIndicator_8_8 = textIndicator_8_8;
	}
	public Texture getTextIndicator_8_8() {
		return textIndicator_8_8;
	}




	public void setbackGroundMusicOffOrOn(boolean backGroundMusicOff) {
        soundAndLanguage.putBoolean("backGroundMusicOff", backGroundMusicOff);
		this.backGroundMusicOff = backGroundMusicOff;
        soundAndLanguage.flush();
	}
	public boolean getbackGroundMusicOffOrOn() {
		backGroundMusicOff = soundAndLanguage.getBoolean("backGroundMusicOff");
		return backGroundMusicOff;
	}
	public void createBackGroundMusicAndLoopIt(boolean backGroundMusicOff) {
		music = Gdx.audio.newMusic(Gdx.files.internal("game_music.mp3"));
//		music.setVolume(1.0f);                 // sets the volume to half the maximum volume
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

	public void setButton5Visible(boolean visible) {
		button5.setVisible(visible);
	}
	public void setButton6Visible(boolean visible){
        button6.setVisible(visible);
    }

    public void setGotToLastTextPartOkayToShowNeededButtons(boolean gotToLastTextPartOkayToShowNeededButtons) {
        this.gotToLastTextPartOkayToShowNeededButtons = gotToLastTextPartOkayToShowNeededButtons;
        prefs.putBoolean("gotToLastTextPartOkayToShowNeededButtons", this.gotToLastTextPartOkayToShowNeededButtons);
        prefs.flush();
    }
    public boolean getGotToLastTextPartOkayToShowNeededButtons() {
        gotToLastTextPartOkayToShowNeededButtons = prefs.getBoolean("gotToLastTextPartOkayToShowNeededButtons");
        return gotToLastTextPartOkayToShowNeededButtons;
    }
    public void setGotToTheLastTextOnceAlready(boolean gotToTheLastTextOnceAlready) {
        this.gotToTheLastTextOnceAlready = gotToTheLastTextOnceAlready;
        prefs.putBoolean("gotToTheLastTextOnceAlready", this.gotToTheLastTextOnceAlready);
        prefs.flush();
    }
    public boolean getGotToTheLastTextOnceAlready() {
        gotToTheLastTextOnceAlready = prefs.getBoolean("gotToTheLastTextOnceAlready");
        return gotToTheLastTextOnceAlready;
    }

    public void setPrefsPopUpActivate(boolean prefsPopUpActivate) {
        this.prefsPopUpActivate = prefsPopUpActivate;
        prefs.putBoolean("prefsPopUpActivate", this.prefsPopUpActivate);
        prefs.flush();
    }

    public boolean getPrefsPopUpActivate() {
        prefsPopUpActivate = prefs.getBoolean("prefsPopUpActivate");
        return prefsPopUpActivate;
    }

    public void setTooFewStepsPopUpActivate(boolean tooFewStepsPopUpActivate) {
        this.tooFewStepsPopUpActivate = tooFewStepsPopUpActivate;
        prefs.putBoolean("tooFewStepsPopUpActivate", this.tooFewStepsPopUpActivate);
        prefs.flush();
    }

    public boolean getTooFewStepsPopUpActivate() {
        tooFewStepsPopUpActivate = prefs.getBoolean("tooFewStepsPopUpActivate");
        return tooFewStepsPopUpActivate;
    }

    public void setTutorialShow(boolean tutorialShow) {
        this.tutorialShow = tutorialShow;
        prefs.putBoolean("tutorialShow", this.tutorialShow);
        prefs.flush();
    }

    public boolean gettutorialShow() {
        tutorialShow = prefs.getBoolean("tutorialShow");
        return tutorialShow;
    }


    public void createButtons(Texture texture, String textForAButton, float storyID, int useForTheButton,
							  float xPlace, float yPlace, float buttonWidth, float buttonHeight, int stepsToOpenNextChapter) {

		this.buttonHeight = buttonHeight;
		this.buttonWidth = buttonWidth;

		if(useForTheButton == 1 || useForTheButton == 2
                || useForTheButton == 3 || useForTheButton == 4
                || useForTheButton == 7 || useForTheButton == 8
                || useForTheButton == 9 || useForTheButton == 10
                || useForTheButton == 11 || useForTheButton == 12
                || useForTheButton == 13 || useForTheButton == 14
                || useForTheButton == 15 || useForTheButton == 16
                || useForTheButton == 17 || useForTheButton == 18
                || useForTheButton == 19 || useForTheButton == 20
                || useForTheButton == 21 || useForTheButton == 22
                || useForTheButton == 23 || useForTheButton == 24
                ) {

            button = new Button(this, texture, textForAButton, storyID, useForTheButton, xPlace, yPlace, buttonWidth, buttonHeight, stepsToOpenNextChapter);
            stage.addActor(button);
        }

		if(useForTheButton == 9 || useForTheButton == 12 ) {
			groupActors(button);
			groupStageAdd1();
		}

        if(useForTheButton == 17 || useForTheButton == 18 || useForTheButton == 19 ) {
            groupActors2(button);
            groupStageAdd2();
        }

        if(useForTheButton == 20 || useForTheButton == 21 ) {
            groupActors3(button);
            groupStageAdd3();
        }

        if(useForTheButton == 23 || useForTheButton == 24 ) {
            groupActors4(button);
            groupStageAdd4();
        }

		if(useForTheButton == 5 || useForTheButton == 6) {
		    System.out.println("useforthebutton is " + useForTheButton);
			if(useForTheButton == 5) {
				button5 = new Button(this, texture, textForAButton, storyID, useForTheButton, xPlace, yPlace, buttonWidth, buttonHeight, stepsToOpenNextChapter);
                stage.addActor(button5);
                System.out.println("created button5" + getGotToLastTextPartOkayToShowNeededButtons());
			}
			else if (useForTheButton == 6) {
			    System.out.println("GOT HERE TO CREATING BUTTON 6");
				button6 = new Button(this, texture, textForAButton, storyID, useForTheButton, xPlace, yPlace, buttonWidth, buttonHeight, stepsToOpenNextChapter);
                stage.addActor(button6);
                System.out.println("created button6" + getGotToLastTextPartOkayToShowNeededButtons());
			}

			if(!getGotToLastTextPartOkayToShowNeededButtons()) {
			    if(useForTheButton == 5) {
                   button5.setVisible(false);
                    System.out.println("set nonvisible button5");
                }else if (useForTheButton == 6) {
                    button6.setVisible(false);
                    System.out.println("set nonvisible button6");
                }
			} else {
                if(useForTheButton == 5) {
                    setButton5Visible(true);
                    System.out.println("set visible button5");
                }else if (useForTheButton == 6) {
                    setButton6Visible(true);
                    System.out.println("set visible button6");
                }
			}
		}

		Gdx.input.setInputProcessor(stage);

	}

	public void groupActors(Actor actor) {
		group.addActor(actor);
	}
	public void groupActors2(Actor actor) {
		group2.addActor(actor);
	}
    public void groupActors3(Actor actor) {
        group3.addActor(actor);
    }
	public void groupActors4(Actor actor) {
		group4.addActor(actor);
	}

	public void clearGroup(int useForTheButton) {
		if(useForTheButton == 9 || useForTheButton == 12) {
			group.clear();
		}else if (useForTheButton == 17 || useForTheButton == 18 || useForTheButton == 19) {
			group2.clear();
		}else if (useForTheButton == 20 || useForTheButton == 21) {
		    group3.clear();
		    System.out.println("clearing group 3");
        } else {
			group4.clear();
		}
    }
	public Group getGroup1() {
		return group;
	}
	public Group getGroup2() {
		return group2;
	}
    public Group getGroup3() {
        return group3;
    }
	public Group getGroup4() {
		return group4;
	}
	public void groupStageAdd1() {
		stage.addActor(group);
	}
	public void groupStageAdd2() {
		stage.addActor(group2);
	}

    public void groupStageAdd3() {
        stage.addActor(group3);
    }
	public void groupStageAdd4() {
		stage.addActor(group4);
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

	public void setChoseWrong_2(boolean choseWrong_2) {
		this.choseWrong_2 = choseWrong_2;
		prefs.putBoolean("choseWrong_2", this.choseWrong_2);
		prefs.flush();
	}
	public boolean getChoseWrong_2() {
		choseWrong_2 = prefs.getBoolean("choseWrong_2");
		return choseWrong_2;
	}

	public void setChoseWrong_3(boolean choseWrong_3) {
		this.choseWrong_3 = choseWrong_3;
		prefs.putBoolean("choseWrong_3", this.choseWrong_3);
		prefs.flush();
	}
	public boolean getChoseWrong_3() {
		choseWrong_3 = prefs.getBoolean("choseWrong_3");
		return choseWrong_3;
	}

	public void setChoseWrong_4(boolean choseWrong_4) {
		this.choseWrong_4 = choseWrong_4;
		prefs.putBoolean("choseWrong_4", this.choseWrong_4);
		prefs.flush();
	}
	public boolean getChoseWrong_4() {
		choseWrong_4 = prefs.getBoolean("choseWrong_4");
		return choseWrong_4;
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
	public int getStepsToOpenChapter5_1() {
		return stepsToOpenChapter5_1;
	}


	public void setStepsToOpenChapter5_2(int steps) {
		stepsToOpenChapter5_2 = steps;
		prefs.putInteger("setStepsToOpenChapter5_2", stepsToOpenChapter5_2);
		prefs.flush();
	}
	public int getStepsToOpenChapter5_2() {
		return stepsToOpenChapter5_2;
	}


	public void setStepsToOpenChapter6_1(int steps) {
		stepsToOpenChapter6_1 = steps;
		prefs.putInteger("setStepsToOpenChapter6_1", stepsToOpenChapter6_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter6_1() {
		return stepsToOpenChapter6_1;
	}


	public void setStepsToOpenChapter7_1(int steps) {
		stepsToOpenChapter7_1 = steps;
		prefs.putInteger("setStepsToOpenChapter7_1", stepsToOpenChapter7_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter7_1() {
		return stepsToOpenChapter7_1;
	}


	public void setStepsToOpenChapter8_1(int steps) {
		stepsToOpenChapter8_1 = steps;
		prefs.putInteger("setStepsToOpenChapter8_1", stepsToOpenChapter8_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter8_1() {
		return stepsToOpenChapter8_1;
	}


	public void setStepsToOpenChapter9_1(int steps) {
		stepsToOpenChapter9_1 = steps;
		prefs.putInteger("setStepsToOpenChapter9_1", stepsToOpenChapter9_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter9_1() {
		return stepsToOpenChapter9_1;
	}


	public void setStepsToOpenChapter10_1(int steps) {
		stepsToOpenChapter10_1 = steps;
		prefs.putInteger("setStepsToOpenChapter10_1", stepsToOpenChapter10_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter10_1() {
		return stepsToOpenChapter10_1;
	}


	public void setStepsToOpenChapter11_1(int steps) {
		stepsToOpenChapter11_1 = steps;
		prefs.putInteger("setStepsToOpenChapter11_1", stepsToOpenChapter11_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter11_1() {
		return stepsToOpenChapter11_1;
	}


	public void setStepsToOpenChapter12_1(int steps) {
		stepsToOpenChapter12_1 = steps;
		prefs.putInteger("setStepsToOpenChapter12_1", stepsToOpenChapter12_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter12_1() {
		return stepsToOpenChapter12_1;
	}


	public void setStepsToOpenChapter12_2(int steps) {
		stepsToOpenChapter12_2 = steps;
		prefs.putInteger("setStepsToOpenChapter12_2", stepsToOpenChapter12_2);
		prefs.flush();
	}
	public int getStepsToOpenChapter12_2() {
		return stepsToOpenChapter12_2;
	}


	public void setStepsToOpenChapter13_1(int steps) {
		stepsToOpenChapter13_1 = steps;
		prefs.putInteger("setStepsToOpenChapter13_1", stepsToOpenChapter13_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter13_1() {
		return stepsToOpenChapter13_1;
	}


	public void setStepsToOpenChapter14_1(int steps) {
		stepsToOpenChapter14_1 = steps;
		prefs.putInteger("setStepsToOpenChapter14_1", stepsToOpenChapter14_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter14_1() {
		return stepsToOpenChapter14_1;
	}


	public void setStepsToOpenChapter15_1(int steps) {
		stepsToOpenChapter15_1 = steps;
		prefs.putInteger("setStepsToOpenChapter15_1", stepsToOpenChapter15_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter15_1() {
		return stepsToOpenChapter15_1;
	}


	public void setStepsToOpenChapter16_1(int steps) {
		stepsToOpenChapter16_1 = steps;
		prefs.putInteger("setStepsToOpenChapter16_1", stepsToOpenChapter16_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter16_1() {
		return stepsToOpenChapter16_1;
	}


	public void setStepsToOpenChapter17_1(int steps) {
		stepsToOpenChapter17_1 = steps;
		prefs.putInteger("setStepsToOpenChapter17_1", stepsToOpenChapter17_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter17_1() {
		return stepsToOpenChapter17_1;
	}


	public void setStepsToOpenChapter18_1(int steps) {
		stepsToOpenChapter18_1 = steps;
		prefs.putInteger("setStepsToOpenChapter18_1", stepsToOpenChapter18_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter18_1() {
		return stepsToOpenChapter18_1;
	}


	public void setStepsToOpenChapter18_2(int steps) {
		stepsToOpenChapter18_2 = steps;
		prefs.putInteger("setStepsToOpenChapter18_2", stepsToOpenChapter18_2);
		prefs.flush();
	}
	public int getStepsToOpenChapter18_2() {
		return stepsToOpenChapter18_2;
	}


	public void setStepsToOpenChapter19_1(int steps) {
		stepsToOpenChapter19_1 = steps;
		prefs.putInteger("setStepsToOpenChapter19_1", stepsToOpenChapter19_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter19_1() {
		return stepsToOpenChapter19_1;
	}


	public void setStepsToOpenChapter20_1(int steps) {
		stepsToOpenChapter20_1 = steps;
		prefs.putInteger("setStepsToOpenChapter20_1", stepsToOpenChapter20_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter20_1() {
		return stepsToOpenChapter20_1;
	}


	public void setStepsToOpenChapter21_1(int steps) {
		stepsToOpenChapter21_1 = steps;
		prefs.putInteger("setStepsToOpenChapter21_1", stepsToOpenChapter21_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter21_1() {
		return stepsToOpenChapter21_1;
	}


	public void setStepsToOpenChapter22_1(int steps) {
		stepsToOpenChapter22_1 = steps;
		prefs.putInteger("setStepsToOpenChapter22_1", stepsToOpenChapter22_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter22_1() {
		return stepsToOpenChapter22_1;
	}


	public void setStepsToOpenChapter23_1(int steps) {
		stepsToOpenChapter23_1 = steps;
		prefs.putInteger("setStepsToOpenChapter23_1", stepsToOpenChapter23_1);
		prefs.flush();
	}
	public int getStepsToOpenChapter23_1() {
		return stepsToOpenChapter23_1;
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

    public String getBackToMainMenu() {
        return backToMainMenu;
    }

    public String getResetGame() {
        return resetGame;
    }
    public String getResetGameQuestion() {
        return resetGameQuestion;
    }
    public String getYes() {
        return yes;
    }
    public String getNo() {
        return no;
    }
    public String getOk() {
        return ok;
    }
    public String getTooFewStepsMessage() {
	    return  tooFewStepsMessage;
    }
    public String getTutorialText() {
        return tutorialText;
    }
	public String getTitle() {
		return title;
	}
	public String getSponsors() {
		return sponsors;
	}

	public Stage getStage() {
		return stage;
	}

	public String getChapter() {
		return chapter;
	}


	public String getChapterText(int chapterTextNumberFirstPart, int chapterTextNumberSecondPart) {
	    String combine = "chapter"+chapterTextNumberFirstPart + "_" + chapterTextNumberSecondPart;
//	    System.out.println("chapter"+chapterTextNumberFirstPart + "_" + chapterTextNumberSecondPart);
	    if(combine.equals("chapter1_1")) {
	        return  chapter1_1;
        } else if (combine.equals("chapter1_2")) {
	        return  chapter1_2;
        }  else if (combine.equals("chapter1_3")) {
            return  chapter1_3;
        }  else if (combine.equals("chapter2_1")) {
            return  chapter2_1;
        }  else if (combine.equals("chapter2_2")) {
            return  chapter2_2;
        }  else if (combine.equals("chapter3_1")) {
            return  chapter3_1;
        }  else if (combine.equals("chapter3_2")) {
            return  chapter3_2;
        }  else if (combine.equals("chapter4_1")) {
            return  chapter4_1;
        }  else if (combine.equals("chapter4_2")) {
            return  chapter4_2;
        }  else if (combine.equals("chapter5_1")) {
            return  chapter5_1;
        }  else if (combine.equals("chapter5_2")) {
            return  chapter5_2;
        }  else if (combine.equals("chapter5_3")) {
            return  chapter5_3;
        }  else if (combine.equals("chapter6_1")) {
            return  chapter6_1;
        }  else if (combine.equals("chapter6_2")) {
            return  chapter6_2;
        }  else if (combine.equals("chapter6_3")) {
            return  chapter6_3;
        }  else if (combine.equals("chapter7_1")) {
            return  chapter7_1;
        }  else if (combine.equals("chapter7_2")) {
            return  chapter7_2;
        }  else if (combine.equals("chapter7_3")) {
            return  chapter7_3;
        }  else if (combine.equals("chapter8_1")) {
            return  chapter8_1;
        } else if (combine.equals("chapter8_2")) {
            return  chapter8_2;
        }  else if (combine.equals("chapter8_3")) {
            return  chapter8_3;
        }  else if (combine.equals("chapter9_1")) {
            return  chapter9_1;
        }  else if (combine.equals("chapter9_2")) {
            return  chapter9_2;
        }  else if (combine.equals("chapter9_3")) {
            return  chapter9_3;
        }  else if (combine.equals("chapter9_4")) {
            return  chapter9_4;
        }  else if (combine.equals("chapter10_1")) {
            return  chapter10_1;
        } else if (combine.equals("chapter10_2")) {
            return  chapter10_2;
        } else if (combine.equals("chapter10_3")) {
            return  chapter10_3;
        } else if (combine.equals("chapter11_1")) {
            return  chapter11_1;
        } else if (combine.equals("chapter11_2")) {
            return  chapter11_2;
        } else if (combine.equals("chapter11_3")) {
            return  chapter11_3;
        } else if (combine.equals("chapter11_4")) {
            return  chapter11_4;
        } else if (combine.equals("chapter12_1")) {
            return  chapter12_1;
        } else if (combine.equals("chapter12_2")) {
            return  chapter12_2;
        } else if (combine.equals("chapter12_3")) {
            return  chapter12_3;
        } else if (combine.equals("chapter12_4")) {
            return  chapter12_4;
        } else if (combine.equals("chapter13_1")) {
            return  chapter13_1;
        } else if (combine.equals("chapter13_2")) {
            return  chapter13_2;
        } else if (combine.equals("chapter13_3")) {
            return  chapter13_3;
        } else if (combine.equals("chapter13_4")) {
            return  chapter13_4;
        } else if (combine.equals("chapter14_1")) {
            return  chapter14_1;
        } else if (combine.equals("chapter14_2")) {
            return  chapter14_2;
        } else if (combine.equals("chapter14_3")) {
            return  chapter14_3;
        } else if (combine.equals("chapter14_4")) {
            return  chapter14_4;
        } else if (combine.equals("chapter15_1")) {
            return  chapter15_1;
        } else if (combine.equals("chapter15_2")) {
            return  chapter15_2;
        } else if (combine.equals("chapter15_3")) {
            return  chapter15_3;
        } else if (combine.equals("chapter15_4")) {
            return  chapter15_4;
        } else if (combine.equals("chapter15_5")) {
            return  chapter15_5;
        } else if (combine.equals("chapter16_1")) {
            return  chapter16_1;
        } else if (combine.equals("chapter16_2")) {
            return  chapter16_2;
        } else if (combine.equals("chapter16_3")) {
            return  chapter16_3;
        } else if (combine.equals("chapter16_4")) {
            return  chapter16_4;
        } else if (combine.equals("chapter16_5")) {
            return  chapter16_5;
        } else if (combine.equals("chapter17_1")) {
            return  chapter17_1;
        } else if (combine.equals("chapter17_2")) {
            return  chapter17_2;
        } else if (combine.equals("chapter17_3")) {
            return  chapter17_3;
        } else if (combine.equals("chapter17_4")) {
            return  chapter17_4;
        } else if (combine.equals("chapter17_5")) {
            return  chapter17_5;
        } else if (combine.equals("chapter17_6")) {
            return  chapter17_6;
        } else if (combine.equals("chapter17_7")) {
            return  chapter17_7;
        } else if (combine.equals("chapter17_8")) {
            return  chapter17_8;
        } else if (combine.equals("chapter18_1")) {
            return  chapter18_1;
        } else if (combine.equals("chapter18_2")) {
            return  chapter18_2;
        } else if (combine.equals("chapter18_3")) {
            return  chapter18_3;
        } else if (combine.equals("chapter18_4")) {
            return  chapter18_4;
        } else if (combine.equals("chapter18_5")) {
            return  chapter18_5;
        } else if (combine.equals("chapter19_1")) {
            return  chapter19_1;
        } else if (combine.equals("chapter19_2")) {
            return  chapter19_2;
        } else if (combine.equals("chapter19_3")) {
            return  chapter19_3;
        } else if (combine.equals("chapter19_4")) {
            return  chapter19_4;
        } else if (combine.equals("chapter20_1")) {
            return  chapter20_1;
        } else if (combine.equals("chapter20_2")) {
            return  chapter20_2;
        } else if (combine.equals("chapter20_3")) {
            return  chapter20_3;
        } else if (combine.equals("chapter20_4")) {
            return  chapter20_4;
        } else if (combine.equals("chapter21_1")) {
            return  chapter21_1;
        } else if (combine.equals("chapter21_2")) {
            return  chapter21_2;
        } else if (combine.equals("chapter21_3")) {
            return  chapter21_3;
        } else if (combine.equals("chapter21_4")) {
            return  chapter21_4;
        } else if (combine.equals("chapter21_5")) {
            return  chapter21_5;
        } else if (combine.equals("chapter22_1")) {
            return  chapter22_1;
        } else if (combine.equals("chapter22_2")) {
            return  chapter22_2;
        } else if (combine.equals("chapter22_3")) {
            return  chapter22_3;
        } else if (combine.equals("chapter22_4")) {
            return  chapter22_4;
        } else if (combine.equals("chapter22_5")) {
            return  chapter22_5;
        } else if (combine.equals("chapter22_6")) {
            return  chapter22_6;
        } else if (combine.equals("chapter22_7")) {
            return  chapter22_7;
        } else if (combine.equals("chapter23_1")) {
            return  chapter23_1;
        } else if (combine.equals("chapter23_2")) {
            return  chapter23_2;
        } else if (combine.equals("chapter23_3")) {
            return  chapter23_3;
        } else if (combine.equals("chapter23_4")) {
            return  chapter23_4;
        } else {
	        return combine + " WRONG";
        }
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

	public String getChapter4_choice_text_1() {
		return chapter4_choice_text_1;
	}
	public String getChapter4_choice_text_2() {
		return chapter4_choice_text_2;
	}

	public String getChapter11_choice_text_1() {
		return chapter11_choice_text_1;
	}
	public String getChapter11_choice_text_2() {
		return chapter11_choice_text_2;
	}

	public String getChapter17_choice_text_1() {
		return chapter17_choice_text_1;
	}
	public String getChapter17_choice_text_2() {
		return chapter17_choice_text_2;
	}

	public String getChapter23_choice_text_1() {
		return chapter23_choice_text_1;
	}
	public String getChapter23_choice_text_2() {
		return chapter23_choice_text_2;
	}



	public String getPrevious() {
		return previous;
	}
    public String getContinue() {
        return continuee;
    }
	public int getCurrentFurthestChapter() {
		currentFurthestChapter = prefs.getInteger("currentFurthestChapter");
		return currentFurthestChapter;
	}
	public String getStepsString(){
		return stepsString;
	}

	public void setCurrentFurthestChapter(int currentFurthestChapter) {
        if(currentFurthestChapter > this.currentFurthestChapter) {
            setGotToTheLastTextOnceAlready(false);
            System.out.println("setting the last text once to false in the currentfurthest" + "this.curr " + this.currentFurthestChapter + " current " + currentFurthestChapter);
        }
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
		languageFinnish =soundAndLanguage.getBoolean("languageFinnish");
		return languageFinnish;
	}
	public void setLanguageFinnish(boolean languageFinnish) {
		this.languageFinnish = languageFinnish;
        soundAndLanguage.putBoolean("languageFinnish", languageFinnish);
        soundAndLanguage.flush();
	}

	public boolean getLanguageFirstRound() {
		languageFirstRound =soundAndLanguage.getBoolean("languageFirstRound");
		return languageFirstRound;
	}
	public void setLanguageFirstRound(boolean languageFirstRound) {
		this.languageFirstRound = languageFirstRound;
        soundAndLanguage.putBoolean("languageFirstRound", languageFirstRound);
        soundAndLanguage.flush();
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

        backToMainMenu = myBundle.get("backToMainMenu");

		title = myBundle.get("title");
		play = myBundle.get("play");
		chapterSelect = myBundle.get("chapterSelect");
		credits = myBundle.get("credits");
		exit = myBundle.get("exit");
		back = myBundle.get("back");

		chapter1_choice_text_1 = myBundle.get("chapter1_choice_text_1");
		chapter1_choice_text_2 = myBundle.get("chapter1_choice_text_2");

		chapter4_choice_text_1 = myBundle.get("chapter4_choice_text_1");
		chapter4_choice_text_2 = myBundle.get("chapter4_choice_text_2");

		chapter11_choice_text_1 = myBundle.get("chapter11_choice_text_1");
		chapter11_choice_text_2 = myBundle.get("chapter11_choice_text_2");

		chapter17_choice_text_1 = myBundle.get("chapter17_choice_text_1");
		chapter17_choice_text_2 = myBundle.get("chapter17_choice_text_2");

		chapter23_choice_text_1 = myBundle.get("chapter23_choice_text_1");
		chapter23_choice_text_2 = myBundle.get("chapter23_choice_text_2");

        resetGame= myBundle.get("resetGame");
        resetGameQuestion= myBundle.get("resetGameQuestion");
        yes= myBundle.get("yes");
        no= myBundle.get("no");
        ok= myBundle.get("ok");
        tutorialText = myBundle.get("tutorialText");
        tooFewStepsMessage = myBundle.get("tooFewStepsMessage");

		chapter= myBundle.get("chapter");
		sponsors= myBundle.get("sponsors");
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
		chapter5_3 = myBundle.get("chapter5_3");

		chapter6_1 = myBundle.get("chapter6_1");
		chapter6_2 = myBundle.get("chapter6_2");
		chapter6_3 = myBundle.get("chapter6_3");

		chapter7_1 = myBundle.get("chapter7_1");
		chapter7_2 = myBundle.get("chapter7_2");
		chapter7_3 = myBundle.get("chapter7_3");

		chapter8_1 = myBundle.get("chapter8_1");
		chapter8_2 = myBundle.get("chapter8_2");
		chapter8_3 = myBundle.get("chapter8_3");

		chapter9_1 = myBundle.get("chapter9_1");
		chapter9_2 = myBundle.get("chapter9_2");
		chapter9_3 = myBundle.get("chapter9_3");
		chapter9_4 = myBundle.get("chapter9_4");

		chapter10_1 = myBundle.get("chapter10_1");
		chapter10_2 = myBundle.get("chapter10_2");
		chapter10_3 = myBundle.get("chapter10_3");

		chapter11_1 = myBundle.get("chapter11_1");
		chapter11_2 = myBundle.get("chapter11_2");
		chapter11_3 = myBundle.get("chapter11_3");
		chapter11_4 = myBundle.get("chapter11_4");

		chapter12_1 = myBundle.get("chapter12_1");
		chapter12_2 = myBundle.get("chapter12_2");
		chapter12_3 = myBundle.get("chapter12_3");
		chapter12_4 = myBundle.get("chapter12_4");

		chapter13_1 = myBundle.get("chapter13_1");
		chapter13_2 = myBundle.get("chapter13_2");
		chapter13_3 = myBundle.get("chapter13_3");
		chapter13_4 = myBundle.get("chapter13_4");

		chapter14_1 = myBundle.get("chapter14_1");
		chapter14_2 = myBundle.get("chapter14_2");
		chapter14_3 = myBundle.get("chapter14_3");
		chapter14_4 = myBundle.get("chapter14_4");

		chapter15_1 = myBundle.get("chapter15_1");
		chapter15_2 = myBundle.get("chapter15_2");
		chapter15_3 = myBundle.get("chapter15_3");
		chapter15_4 = myBundle.get("chapter15_4");
		chapter15_5 = myBundle.get("chapter15_5");

		chapter16_1 = myBundle.get("chapter16_1");
		chapter16_2 = myBundle.get("chapter16_2");
		chapter16_3 = myBundle.get("chapter16_3");
		chapter16_4 = myBundle.get("chapter16_4");
		chapter16_5 = myBundle.get("chapter16_5");

		chapter17_1 = myBundle.get("chapter17_1");
		chapter17_2 = myBundle.get("chapter17_2");
		chapter17_3 = myBundle.get("chapter17_3");
		chapter17_4 = myBundle.get("chapter17_4");
		chapter17_5 = myBundle.get("chapter17_5");
		chapter17_6 = myBundle.get("chapter17_6");
		chapter17_7 = myBundle.get("chapter17_7");
		chapter17_8 = myBundle.get("chapter17_8");

		chapter18_1 = myBundle.get("chapter18_1");
		chapter18_2 = myBundle.get("chapter18_2");
		chapter18_3 = myBundle.get("chapter18_3");
		chapter18_4 = myBundle.get("chapter18_4");
		chapter18_5 = myBundle.get("chapter18_5");

		chapter19_1 = myBundle.get("chapter19_1");
		chapter19_2 = myBundle.get("chapter19_2");
		chapter19_3 = myBundle.get("chapter19_3");
		chapter19_4 = myBundle.get("chapter19_4");

		chapter20_1 = myBundle.get("chapter20_1");
		chapter20_2 = myBundle.get("chapter20_2");
		chapter20_3 = myBundle.get("chapter20_3");
		chapter20_4 = myBundle.get("chapter20_4");

		chapter21_1 = myBundle.get("chapter21_1");
		chapter21_2 = myBundle.get("chapter21_2");
		chapter21_3 = myBundle.get("chapter21_3");
		chapter21_4 = myBundle.get("chapter21_4");
		chapter21_5 = myBundle.get("chapter21_5");

		chapter22_1 = myBundle.get("chapter22_1");
		chapter22_2 = myBundle.get("chapter22_2");
		chapter22_3 = myBundle.get("chapter22_3");
		chapter22_4 = myBundle.get("chapter22_4");
		chapter22_5 = myBundle.get("chapter22_5");
		chapter22_6 = myBundle.get("chapter22_6");
		chapter22_7 = myBundle.get("chapter22_7");

		chapter23_1 = myBundle.get("chapter23_1");
		chapter23_2 = myBundle.get("chapter23_2");
		chapter23_3 = myBundle.get("chapter23_3");
		chapter23_4 = myBundle.get("chapter23_4");

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
        soundAndLanguage.putString("localLanguageToString", localLanguageToString);
        soundAndLanguage.flush();
	}

	public void setLocalLanguageToString(String localLanguageToString) {
		this.localLanguageToString = localLanguageToString;
        soundAndLanguage.putString("localLanguageToString", this.localLanguageToString);
        soundAndLanguage.flush();
	}

	public String getlocalLanguageToString() {
		localLanguageToString = soundAndLanguage.getString("localLanguageToString");
		return localLanguageToString;
	}


	public void setClearedChapterGeneral(boolean clearedChapterNumberBoolean, int clearedChapterNumberInt) {
	    if(clearedChapterNumberInt > 0 || clearedChapterNumberInt <25) {
            prefs.putBoolean("clearedChapter" + clearedChapterNumberInt, clearedChapterNumberBoolean);
            prefs.flush();
        }
	}

	public boolean getClearedChapterGeneral(int clearedChapterNumberInt) {
        return prefs.getBoolean("clearedChapter" + clearedChapterNumberInt);
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
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Aero Matics Regular.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		if(screenHeight < 800) {
			fontSize = 23;
		} else if (screenHeight >= 1000) {
			fontSize = 50;
		}
		parameter.size = fontSize;

		font12 = generator.generateFont(parameter);

		font12.setColor(Color.BLACK);

		//CREATE OR OPEN THE MyPreferences.xml FILE THAT STORES INFO ON SCENES AND SUCH
		//Create or open file MyPreferences.xml
        soundAndLanguage = Gdx.app.getPreferences("MyPreferences2");
		prefs = Gdx.app.getPreferences("MyPreferences");


		stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);

		//CREATE THE GAMERA THAT IS USEED THROUGHOUT THE GAME
		camera = new OrthographicCamera();
		camera.setToOrtho(false, screenWidth, screenHeight);

		group = new Group();
        group2 = new Group();
        group3 = new Group();
		group4 = new Group();
		if(languageFirstRound == false) {
			languageFirstRound = soundAndLanguage.getBoolean("languageFirstRound");
            soundAndLanguage.putBoolean("languageFirstRound", true);

			backGroundMusicOff = soundAndLanguage.getBoolean("backGroundMusicOff");
			createBackGroundMusicAndLoopIt(backGroundMusicOff);
			System.out.println("CREATED A NEW BACKGROUND SOUND AND SET IT FALSE");
            soundAndLanguage.flush();

		}

		if(!getbackGroundMusicOffOrOn()) {
            createBackGroundMusicAndLoopIt(backGroundMusicOff);
            playBackgroundMusic();
            System.out.println("MAINCLASS PLAY MUSIC");
        } else {
            createBackGroundMusicAndLoopIt(backGroundMusicOff);
            stopBackGroundMusic();
            System.out.println("MAINCLASS DON'T PLAY MUSIC");
        }

		System.out.println("IS SOUND OFF AT THE START: " + getbackGroundMusicOffOrOn());



		if(languageFirstRound != soundAndLanguage.getBoolean("languageFirstRound")) {
			System.out.println("ERI FIRSTROUND LANGUAGE KUN TALLESSA" + languageFirstRound + " AND " + soundAndLanguage.getBoolean("languageFirstRound"));
			System.out.println("LANGUAGE FALSE");
			setDefaultLocale();
			setCurrentFurthestChapter(1);
			languageFirstRound = soundAndLanguage.getBoolean("languageFirstRound");
            soundAndLanguage.flush();

            setResetEverything(false);

			if(localLanguageToString.equals("fi_FI")) {
				System.out.println("LOCAL LANGUAGE FINNISH");
				languageFinnish = true;
                soundAndLanguage.putBoolean("languageFinnish", true);
				setLocalLanguageToString("fi_FI");
				setLocaleTexts();
                soundAndLanguage.flush();
				System.out.println("local language: " + localLanguageToString);
			} else {
				languageFinnish = false;
                soundAndLanguage.putBoolean("languageFinnish", false);
				setLocalLanguageToString("en_EN");
				setLocaleTexts();
                soundAndLanguage.flush();
				System.out.println("local language: " + localLanguageToString);
			}
		} else {
			languageFirstRound = soundAndLanguage.getBoolean("languageFirstRound");
			getlocalLanguageToString();
			System.out.println("local language: " + localLanguageToString);
            soundAndLanguage.flush();
			if(localLanguageToString.equals("fi_FI")) {
				System.out.println("LOCAL LANGUAGE FINNISH");
				languageFinnish = true;
                soundAndLanguage.putBoolean("languageFinnish", true);
				setLocale(new Locale("fi", "FI"));
				setLocaleTexts();
                soundAndLanguage.flush();
			} else {
				languageFinnish = false;
                soundAndLanguage.putBoolean("languageFinnish", false);
				setLocale(new Locale("en", "EN"));
				setLocaleTexts();
                soundAndLanguage.flush();
			}
		}
//		Locale locale = new Locale("en", "EN");


		//FINNISH AND ENGLISH TEXTS ARE CREATED HERE TO BE USED EVERYWHERE
		myBundle =
				I18NBundle.createBundle(Gdx.files.internal("MyBundle"), locale);

		//String steps = myBundle.format("steps");

        soundAndLanguage.flush();
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
