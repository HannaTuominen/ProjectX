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

/**
    Main menu where you can go to ChapterSelect, GameScreen, Credits and exit the game
 */

public class MainMenu implements Screen {
    MainClass mainClass;
    SpriteBatch batch;
    BitmapFont font12;
//    public OrthographicCamera camera;
    private float screenWidth;
    private float screenHeight;
    private float buttonWidth;
    private float buttonHeight;

    private Stage stage;

    Texture texture;

    public MainMenu(MainClass MainClass2) {

        this.mainClass = MainClass2;
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();

        batch = mainClass.getBatch();
        font12 = mainClass.getFont12();

        texture = new Texture(Gdx.files.internal("startBackground_1.png"));

        stage = mainClass.getStage();

//        Skin skin = new Skin( Gdx.files.internal("uiskin.json"));

        buttonWidth = screenWidth/4;
        buttonHeight = screenHeight/10;

        mainClass.getStage().clear();

        mainClass.createButtons(new Texture("button_orange.png"),mainClass.getPlay(),1,screenWidth/2-buttonWidth/2,screenHeight/2+buttonHeight+10, buttonWidth ,buttonHeight,0);
        mainClass.createButtons(new Texture("button_orange.png"),mainClass.getChapterSelect(),2,screenWidth/2-buttonWidth/2,screenHeight/2, buttonWidth ,buttonHeight,0);
        mainClass.createButtons(new Texture("button_orange.png"),mainClass.getCredits(),3,screenWidth/2-buttonWidth/2,screenHeight/2-buttonHeight-10, buttonWidth ,buttonHeight,0);
        mainClass.createButtons(new Texture("button_orange.png"),mainClass.getExit(),4,screenWidth/2-buttonWidth/2,screenHeight/2-buttonHeight*2-20, buttonWidth ,buttonHeight,0);

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
