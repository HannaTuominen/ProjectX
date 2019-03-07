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
//    Texture BackGroundImage6;

    private Stage stage;
    Skin skin;

    private float chapterNumber;

    private ChapterAssets chapter1;
    private ChapterAssets chapter2;
    private ChapterAssets chapter3;
    private ChapterAssets chapter4;
    private ChapterAssets chapter5;
    private boolean openedFirstTime = false;

//    private ChapterAssets chapter6;

//    private boolean swapped = false;
    private float screenWidth;
    private float screenHeight;

    public void implementTextures() {
        backGroundImage1 = new Texture(Gdx.files.internal("background_001.png"));
        backGroundImage2 = new Texture(Gdx.files.internal("background_002.png"));
        backGroundImage3 = new Texture(Gdx.files.internal("background_003.png"));
        backGroundImage4 = new Texture(Gdx.files.internal("background_004.png"));
        backGroundImage5 = new Texture(Gdx.files.internal("background_005.png"));

    }

    public void createScenes() {
        chapter1 = new ChapterAssets(mainClass, backGroundImage1, false, 0,0,"idk mita taha tulis", "Tyhja", 100,mainClass.getChapter1Text());
//        stage.addActor(chapter1);

        chapter2 = new ChapterAssets(mainClass, backGroundImage2, true, 3,300,"purje", "airot", 300, mainClass.getChapter2Text());
//        stage.addActor(chapter2);

        chapter3 = new ChapterAssets(mainClass, backGroundImage3, false, 0,0,"idk mita taha tulis", "Tyhja", 300,mainClass.getChapter1Text());
//        stage.addActor(chapter3);

        chapter4 = new ChapterAssets(mainClass, backGroundImage4, false, 0,0,"idk mita taha tulis", "Tyhja", 300,mainClass.getChapter2Text());
//        stage.addActor(chapter4);

        chapter5 = new ChapterAssets(mainClass, backGroundImage5, false, 0,0,"idk mita taha tulis", "Tyhja", 300,mainClass.getChapter1Text());
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
        implementTextures();
        createScenes();

//        stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);
        skin = new Skin( Gdx.files.internal("uiskin.json"));
        openedFirstTime = mainClass.prefs.getBoolean("openedFirstTime");
        if (!openedFirstTime) {
            System.out.println("GOT HERE");
            mainClass.prefs.putInteger("ChapterNumber",1 );
            openedFirstTime = true;
            mainClass.prefs.putBoolean("openedFirstTime", openedFirstTime);
            mainClass.prefs.flush();
        }
        createButtons();

        chapterNumber = mainClass.prefs.getInteger("ChapterNumber");
    }

    public void createButtons() {

        final TextButton button = new TextButton("Play", skin);
        button.setWidth(200f);
        button.setHeight(100f);
        button.setPosition(screenWidth/2 - 100f, screenHeight/2 - 100f);
        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);

        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                chapterNumber++;
//                swapped = false;
            }
        });
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(mainClass.camera.combined);
        Gdx.gl.glClearColor(1, 2, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        if(chapterNumber == 1) {
            stage.addActor(chapter1);
//            mainClass.prefs.putInteger("ChapterNumber",1 );
//            mainClass.prefs.flush();
            createButtons();
        }
        if(chapterNumber == 2) {
            stage.clear();
            stage.addActor(chapter2);
            mainClass.prefs.putInteger("ChapterNumber",2 );
            createButtons();
           mainClass.prefs.flush();
        }
        if(chapterNumber == 3) {
            stage.clear();
            stage.addActor(chapter3);
            mainClass.prefs.putInteger("ChapterNumber",3 );
            createButtons();
            mainClass.prefs.flush();
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
