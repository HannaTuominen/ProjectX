package fi.tamk.tiko;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/*
    Main menu where you can go to ChapterSelect, GameScreen, Credits and exit the game
 */

public class MainMenu implements Screen {
    MainClass mainClass;
    SpriteBatch batch;
    BitmapFont font12;
//    public OrthographicCamera camera;
    private float screenWidth;
    private float screenHeight;

    private Stage stage;

    Texture texture;

    public MainMenu(MainClass MainClass2) {

        this.mainClass = MainClass2;
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();

        batch = mainClass.getBatch();
        font12 = mainClass.getFont12();

        texture = new Texture(Gdx.files.internal("background_001.png"));

        stage = mainClass.getStage();

        Skin skin = new Skin( Gdx.files.internal("uiskin.json"));

        mainClass.getStage().clear();
        mainClass.createButtons(mainClass.getPlay(),1,screenWidth/2-50,screenHeight/2);
        mainClass.createButtons(mainClass.getChapterSelect(),2,screenWidth/2-50,screenHeight/2-50);
        mainClass.createButtons(mainClass.getCredits(),3,screenWidth/2-50,screenHeight/2-100);
        mainClass.createButtons(mainClass.getExit(),4,screenWidth/2-50,screenHeight/2-150);


//        final TextButton button = new TextButton("Play", skin);
//        button.setWidth(200f);
//        button.setHeight(50f);
//        button.setPosition(screenWidth/2-100, screenHeight/2-50);
//
//        final TextButton button2 = new TextButton("ChapterSelect", skin);
//        button2.setWidth(200f);
//        button2.setHeight(50f);
//        button2.setPosition(screenWidth/2-100, screenHeight/2-100);
//
//        final TextButton button3 = new TextButton("Credits", skin);
//        button3.setWidth(200f);
//        button3.setHeight(50f);
//        button3.setPosition(screenWidth/2-100, screenHeight/2-150);
//
//        final TextButton button4 = new TextButton("Exit", skin);
//        button4.setWidth(200f);
//        button4.setHeight(50f);
//        button4.setPosition(screenWidth/2-100, screenHeight/2-200);

//        stage.addActor(button);
//        stage.addActor(button2);
//        stage.addActor(button3);
//        stage.addActor(button4);

//        Gdx.input.setInputProcessor(stage);

//        button.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                GameScreen gameScreen = new GameScreen(mainClass);
//                mainClass.setScreen(gameScreen);
//            }
//        });
//        button2.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                ChapterSelect chapterSelect = new ChapterSelect(mainClass);
//                mainClass.setScreen(chapterSelect);
//            }
//        });
//        button3.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                Credits credits = new Credits(mainClass);
//                mainClass.setScreen(credits);
//            }
//        });
//        button4.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                //EI SULJE TAUSTAPROSESSISTA VISSIIN --- SELVITÄ
//                Gdx.app.exit();
//            }
//        });

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(mainClass.camera.combined);
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(texture,
                0f, 0f, screenWidth,screenHeight);

        font12.draw(batch,mainClass.getTitle(), 0, 100);

//        System.out.println(i);

        batch.end();


        stage.draw();
        //System.out.println("GOT HERE!!!");


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
