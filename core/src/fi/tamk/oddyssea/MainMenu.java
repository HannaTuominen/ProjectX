package fi.tamk.oddyssea;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Main menu where you can go to ChapterSelect, GameScreen, Credits, exit the game and reset the game
 * @author Hanna Tuominen hanna.h.tuominen@tuni.fi
 * @version 24.4.2019
 * @since 15.01.2019
 */

public class MainMenu implements Screen {
    /**
     * main class
     */
    private MainClass mainClass;
    /**
     * batch
     */
    private SpriteBatch batch;
    /**
     * font
     */
    private BitmapFont font12;
    /**
     * the screen width of the current device
     */
    private float screenWidth;
    /**
     * the screen height of the current device
     */
    private float screenHeight;
    /**
     * the button width
     */
    private float buttonWidth;
    /**
     * the button height
     */
    private float buttonHeight;
    /**
     * the stage
     */
    private Stage stage;
    /**
     * the background texture
     */
    private Texture texture;
    /**
     * the oddyssea logo texture
     */
    private Texture texture2;
    /**
     * check if the game is opened for the first time or not
     */
    private boolean firstRound = false;

    /**
     * everything needed on main menu is created here (changed only when changing the language or reopening the menu whatever way)
     * <p>
     *     first save needed info locally
     *     set up textures for backgroun and logo
     *     get stage
     *     set button widths and heights
     *     clear stage
     *     get the first round infor from prefs
     *     createned buttons
     *     check if the background music should be on or off and play music depending on that
     * @param MainClass2
     */
    public MainMenu(MainClass MainClass2) {
        System.out.println(firstRound + " IS IT FIRST ROUND");

        this.mainClass = MainClass2;
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();

        batch = mainClass.getBatch();
        font12 = mainClass.getFont12();

        texture = new Texture(Gdx.files.internal("startBackground_1.png"));
        texture2 = new Texture(Gdx.files.internal("18tiko3D-Oddyssea.png"));

        stage = mainClass.getStage();

        buttonWidth = screenWidth/4;
        buttonHeight = screenHeight/10;

        mainClass.getStage().clear();
        firstRound = mainClass.prefs.getBoolean("openedFirstTime");
        createNewButtons();

        if(!mainClass.getbackGroundMusicOffOrOn()) {
            System.out.println("PLAYING BACKGROUN MUSIC IN MAIN MENU");
            mainClass.playBackgroundMusic();

        } else {
            System.out.println("NOT PLAYING BACKGROUN MUSIC IN MAIN MENU");
            mainClass.stopBackGroundMusic();
        }

    }

    /**
     * create new main menu buttons depending on given info and if the game has been started or not (new game - continue game text)
     * created again whenever the language is changed
     */
    public void createNewButtons() {
        if(!firstRound) {
            mainClass.createButtons(new Texture("button_unpressed.png"),mainClass.getPlay(),0,1,screenWidth/10,screenHeight/1.55f, buttonWidth*1.3f ,buttonHeight*1.3f,0);
            System.out.println(firstRound + " IS IT FIRST ROUND");
            System.out.println(mainClass.getCurrentFurthestChapter() + " MAIN CUR FURTH");


        } else {
            mainClass.createButtons(new Texture("button_unpressed.png"),mainClass.getContinue(),0,1,screenWidth/10,screenHeight/1.55f, buttonWidth*1.3f, buttonHeight*1.3f,0);
            System.out.println(mainClass.getCurrentFurthestChapter() + " MAIN CUR FURTH");
        }

        if(mainClass.getLanguageFinnish()) {
            mainClass.createButtons(new Texture("fin_button.png"), "", 0, 11, screenWidth - buttonWidth/1.9f, screenHeight - buttonHeight - 10, buttonWidth / 4.4f, buttonHeight, 0);
        } else {
            mainClass.createButtons(new Texture("eng_button.png"), "", 0, 11, screenWidth - buttonWidth/1.9f, screenHeight - buttonHeight - 10, buttonWidth / 4.4f, buttonHeight, 0);
        }
        if(!mainClass.getbackGroundMusicOffOrOn()) {
            mainClass.createButtons(new Texture("sound_on_button.png"), "", 0, 13, screenWidth - buttonWidth/4.5f -10, screenHeight - buttonHeight - 10, buttonWidth / 4.5f, buttonHeight, 0);
            System.out.println("CREATED SOUND BUTTON ON");
        } else {
            mainClass.createButtons(new Texture("sound_off_button.png"), "", 0, 13, screenWidth - buttonWidth/4.5f -10, screenHeight - buttonHeight - 10, buttonWidth / 4.5f, buttonHeight, 0);
            System.out.println("CREATED SOUND BUTTON OFF");
        }
//        mainClass.createButtons(new Texture("sound_on_button.png"), "", 0, 13, screenWidth - buttonWidth/4.5f -50, screenHeight - buttonHeight - 10, buttonWidth / 4.5f, buttonHeight, 0);

        mainClass.createButtons(new Texture("button_unpressed.png"),mainClass.getChapterSelect(),0,2,screenWidth/10*1.35f,screenHeight/2f, buttonWidth ,buttonHeight,0);
        mainClass.createButtons(new Texture("button_unpressed.png"),mainClass.getCredits(),0,3,screenWidth/10*1.35f,screenHeight/2.2f-buttonHeight, buttonWidth ,buttonHeight,0);
        mainClass.createButtons(new Texture("button_unpressed.png"),mainClass.getExit(),0,4,screenWidth/10*1.35f,screenHeight/2.4f-buttonHeight*2, buttonWidth ,buttonHeight,0);
        mainClass.createButtons(new Texture("button_unpressed.png"),mainClass.getResetGame(),0,16,screenWidth/10*1.35f,screenHeight/2.4f-buttonHeight*3.3f, buttonWidth ,buttonHeight,0);

        mainClass.setPrefsPopUpActivate(false);
    }

    @Override
    public void show() {

    }

    /**
     * render the stage and batch that are needed for the scene
     * draw background and logo textures
     * if the game language is swapped the stage needs to be cleared and buttons reloaded new
     * if the game is resetted the stage needs to be cleared and original buttons need to be created again
     * @param delta
     */
    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(mainClass.camera.combined);
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(texture, 0f, 0f, screenWidth,screenHeight);
        batch.draw(texture2, screenWidth/2.1f, screenWidth/23.5f, screenWidth/2.2f,screenHeight/1.2f);

//        font12.draw(batch,mainClass.getTitle(), 0, 100);
        if(mainClass.getSwappedlanguage()) {
            System.out.println("SWAPPED BUTTONS AND THEIR LANGUAGE");
            stage.clear();
            createNewButtons();
            mainClass.setSwappedlanguage(false);
        }

        if(mainClass.getResetEverything()) {
            System.out.println("RESETTING MAIN MENU");
            stage.clear();
            mainClass.setResetEverything(false);
            firstRound = mainClass.prefs.getBoolean("openedFirstTime");
            createNewButtons();
        }
        batch.end();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();

    }
}
