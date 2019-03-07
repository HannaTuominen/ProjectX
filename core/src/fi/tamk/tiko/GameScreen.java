package fi.tamk.tiko;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/*
    The actual game screen where the game is "played", gotten through main menu
 */

public class GameScreen implements Screen {

    MainClass mainClass;
    SpriteBatch batch;
//    BitmapFont font12;

    Texture backGroundImage1;
    Texture backGroundImage2;
    Texture backGroundImage3;
    Texture backGroundImage4;
    Texture backGroundImage5;

    Texture buttonTexture1;
//    Texture BackGroundImage6;

    private Stage stage;
    Skin skin;



    private ChapterAssets chapter1;
    private ChapterAssets chapter2;
    private ChapterAssets chapter3;
    private ChapterAssets chapter4;
    private ChapterAssets chapter5;

    Button button;

    private boolean openedFirstTime = false;

//    private ChapterAssets chapter6;



    private float screenWidth;
    private float screenHeight;




    public void implementTextures() {
        backGroundImage1 = new Texture(Gdx.files.internal("background_001.png"));
        backGroundImage2 = new Texture(Gdx.files.internal("background_002.png"));
        backGroundImage3 = new Texture(Gdx.files.internal("background_003.png"));
        backGroundImage4 = new Texture(Gdx.files.internal("background_004.png"));
        backGroundImage5 = new Texture(Gdx.files.internal("background_005.png"));

        buttonTexture1 = new Texture(Gdx.files.internal("placeholderbutton.jpg"));

    }

    public void createScenes() {
        chapter1 = new ChapterAssets(mainClass, backGroundImage1, false, 0,0,"idk mita taha tulis", "Tyhja", 100,mainClass.getChapter1Text());
//        stage.addActor(chapter1); -- not needed here

        chapter2 = new ChapterAssets(mainClass, backGroundImage2, true, 3,300,"purje", "airot", 300, mainClass.getChapter2Text());
//        stage.addActor(chapter2);

        chapter3 = new ChapterAssets(mainClass, backGroundImage3, false, 0,0,"idk mita taha tulis", "Tyhja", 300,mainClass.getChapter3Text());
//        stage.addActor(chapter3);

        chapter4 = new ChapterAssets(mainClass, backGroundImage4, false, 0,0,"idk mita taha tulis", "Tyhja", 300,mainClass.getChapter4Text());
//        stage.addActor(chapter4);

        chapter5 = new ChapterAssets(mainClass, backGroundImage5, false, 0,0,"idk mita taha tulis", "Tyhja", 300,mainClass.getChapter5Text());
//        stage.addActor(chapter5);

//        Gdx.input.setInputProcessor(stage);
    }


    public GameScreen(MainClass MainClass2) {
        this.mainClass = MainClass2;
        batch = mainClass.getBatch();
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();
        stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);

        //Pitää tehdä vain kerran eli pitää kattoo onko jo tehty ekalla kerralla jne joskus sit :D


//        stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);
        skin = new Skin( Gdx.files.internal("uiskin.json"));
        openedFirstTime = mainClass.prefs.getBoolean("openedFirstTime");


       //These need to be created again each time you open the project again, the textures and scenes so they cannot be moved to the openedFirstTime
        implementTextures();
        createScenes();

        //Check if the game is being opened for the very first time to save the chapter number to the initial 1
        //as it hasn't been set to anything before the initial open
        //and also save the openedFirstTime boolean to true so this will only happen once
        if (!openedFirstTime) {
            System.out.println("GOT HERE");
            mainClass.prefs.putInteger("ChapterNumber",1 );
            openedFirstTime = true;
            mainClass.prefs.putBoolean("openedFirstTime", openedFirstTime);
            mainClass.prefs.flush();
            //ON FIRST OPEN SET CURRENT STEPS TO 0
            mainClass.setCurrentSteps(0);
        }
//        createButtons();

        mainClass.setChapterNumber(mainClass.prefs.getInteger("ChapterNumber"));
    }

    public void createButtons() {
//        final TextButton button = new TextButton("Play", skin);
//        button.setWidth(200f);
//        button.setHeight(100f);
//        button.setPosition(screenWidth/2 - 100f, screenHeight/2 - 100f);

        button = new Button(mainClass, buttonTexture1, mainClass.title);
        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);
        System.out.println("HI");
//        button.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                chapterNumber++;
//                System.out.println("HERE");
//                System.out.println(chapterNumber);
//                swapped = false;
//            }
//        });
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(mainClass.camera.combined);
        Gdx.gl.glClearColor(1, 2, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        System.out.println(mainClass.getChapterNumber());
        batch.begin();
        if(mainClass.getChapterNumber() == 1 && !mainClass.getSwapped()) {
            stage.addActor(chapter1);
//            mainClass.prefs.putInteger("ChapterNumber",1 );
//            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            createButtons();
        }
        if(mainClass.getChapterNumber() == 2 && !mainClass.getSwapped()) {
            stage.clear();
            stage.addActor(chapter2);
            createButtons();
            mainClass.prefs.putInteger("ChapterNumber",2 );
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
        }
//        System.out.println(chapterNumber);
        if(mainClass.getChapterNumber() == 3 && !mainClass.getSwapped()) {
            System.out.println("got here");
            stage.clear();
            stage.addActor(chapter3);
            mainClass.prefs.putInteger("ChapterNumber",3 );
            createButtons();
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
        }
        if(mainClass.getChapterNumber() == 4 && !mainClass.getSwapped()) {
            stage.clear();
            stage.addActor(chapter4);
            mainClass.prefs.putInteger("ChapterNumber",4 );
            createButtons();
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
        }
        if(mainClass.getChapterNumber() == 5 && !mainClass.getSwapped()) {
            stage.clear();
            stage.addActor(chapter5);
            mainClass.prefs.putInteger("ChapterNumber",5 );
            createButtons();
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
        }

//        if(sceneNumber == 1 && !swapped) {
//            backGroundSwap("001");
//            swapped = true;
//            createButtons();
//        }
//        if(sceneNumber == 2 && !swapped) {
//            backGroundSwap("002");
//            swapped = true;
//            createButtons();
//        }
//        if(sceneNumber == 3&& !swapped) {
//            backGroundSwap("003");
//            swapped = true;
//            createButtons();
//        }
//        if(sceneNumber == 4&& !swapped) {
//            backGroundSwap("004");
//            swapped = true;
//            createButtons();
//        }
//        if(sceneNumber == 5&& !swapped) {
//            backGroundSwap("005");
//            swapped = true;
//            createButtons();
//        }

        batch.end();

//        System.out.println( mainClass.getCurrentSteps());
//        stage.act(Gdx.graphics.getDeltaTime());
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

    }
}
