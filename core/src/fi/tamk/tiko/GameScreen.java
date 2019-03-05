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
    BitmapFont font12;

    Texture BackGroundImage;
    private Stage stage;
    Skin skin;

    private float sceneNumber = 1;

    private BackGroundAssets background;
    private boolean swapped = false;
    private float screenWidth;
    private float screenHeight;

    public void backGroundSwap(String backGroundNumber) {
        stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);
        background = new BackGroundAssets(mainClass, backGroundNumber);
        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);
    }

    public GameScreen(MainClass MainClass2) {
        this.mainClass = MainClass2;
        batch = mainClass.getBatch();
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();

        backGroundSwap("001");
//        stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);
        skin = new Skin( Gdx.files.internal("uiskin.json"));
        createButtons();


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
                sceneNumber++;
                swapped = false;
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
        if(sceneNumber == 1 && !swapped) {
            backGroundSwap("001");
            swapped = true;
            createButtons();
        }
        if(sceneNumber == 2 && !swapped) {
            backGroundSwap("002");
            swapped = true;
            createButtons();
        }
        if(sceneNumber == 3&& !swapped) {
            backGroundSwap("003");
            swapped = true;
            createButtons();
        }
        if(sceneNumber == 4&& !swapped) {
            backGroundSwap("004");
            swapped = true;
            createButtons();
        }
        if(sceneNumber == 5&& !swapped) {
            backGroundSwap("005");
            swapped = true;
            createButtons();
        }

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
