package fi.tamk.tiko;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**

    This is the Chapter select screen in the main menu

 */

public class ChapterSelect implements Screen {

    MainClass mainClass;
    SpriteBatch batch;
    BitmapFont font12;
    Texture texture;

    private float screenWidth;
    private float screenHeight;
    private float buttonWidth;
    private float buttonHeight;


    public ChapterSelect(MainClass MainClass2) {
        this.mainClass = MainClass2;
        batch = mainClass.getBatch();
        mainClass.getStage().clear();

        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();
        buttonWidth = screenWidth/4;
        buttonHeight = screenHeight/10;


        mainClass.createButtons(new Texture("button_orange.png"),"1",8,screenWidth/2-buttonWidth*2,screenHeight/2+buttonHeight,buttonWidth,buttonHeight);
        mainClass.createButtons(new Texture("button_orange.png"),"2",8,screenWidth/2+buttonWidth,screenHeight/2+buttonHeight,buttonWidth,buttonHeight);
        mainClass.createButtons(new Texture("button_orange.png"),"3",8,screenWidth/2-buttonWidth*2,screenHeight/2-buttonHeight,buttonWidth,buttonHeight);
        mainClass.createButtons(new Texture("button_orange.png"),"4",8,screenWidth/2+buttonWidth,screenHeight/2-buttonHeight,buttonWidth,buttonHeight);
        mainClass.createButtons(new Texture("button_orange.png"),"5",8,screenWidth/2-buttonWidth*2,screenHeight/2-buttonHeight*3,buttonWidth,buttonHeight);
        //BACK
        mainClass.createButtons(new Texture("back_X.png"),"",7,50f,screenHeight-130f,100f,100f);
        texture = new Texture(Gdx.files.internal("startBackground_1.png"));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(mainClass.camera.combined);
        Gdx.gl.glClearColor(1, 0, 5, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(texture, 0f, 0f, mainClass.getScreenWidth(),mainClass.getScreenHeight());
        batch.end();
        mainClass.getStage().draw();
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
