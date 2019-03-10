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

/*

    This is the Chapter select screen in the main menu

 */

public class ChapterSelect implements Screen {

    MainClass mainClass;
    SpriteBatch batch;
    BitmapFont font12;


    public ChapterSelect(MainClass MainClass2) {
        this.mainClass = MainClass2;
        batch = mainClass.getBatch();
        mainClass.getStage().clear();
        mainClass.createButtons("1",8,50,350,200,50);
        mainClass.createButtons("2",8,300,350,200,50);
        mainClass.createButtons("3",8,50,250,200,50);
        mainClass.createButtons("4",8,300,250,200,50);
        mainClass.createButtons("5",8,50,150,200,50);
        //BACK
        mainClass.createButtons(mainClass.getBack(),7,50,100,200,50);

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
