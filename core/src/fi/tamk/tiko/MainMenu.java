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
        mainClass.createButtons(mainClass.getPlay(),1,screenWidth/2-50,screenHeight/2,200,50);
        mainClass.createButtons(mainClass.getChapterSelect(),2,screenWidth/2-50,screenHeight/2-50,200,50);
        mainClass.createButtons(mainClass.getCredits(),3,screenWidth/2-50,screenHeight/2-100,200,50);
        mainClass.createButtons(mainClass.getExit(),4,screenWidth/2-50,screenHeight/2-150,200,50);

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
        batch.draw(texture, 0f, 0f, screenWidth,screenHeight);

        font12.draw(batch,mainClass.getTitle(), 0, 100);

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
