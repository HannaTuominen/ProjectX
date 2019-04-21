package fi.tamk.oddyssea;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**

    This is the Credits screen in the main menu

 */

public class Credits implements Screen {

    private MainClass mainClass;
    private SpriteBatch batch;
    private BitmapFont font12;
    private Texture texture;
    private Texture credits;

    private float buttonWidth;
    private float buttonHeight;


    private float screenWidth;
    private float screenHeight;

    public Credits(MainClass MainClass2) {
        this.mainClass = MainClass2;
        batch = mainClass.getBatch();
        font12 = mainClass.getFont12();
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();
        mainClass.getStage().clear();
        buttonWidth = screenWidth/4;
        buttonHeight = screenHeight/10;


        mainClass.createButtons(new Texture("back_X.png"),"",0,8,
                20,screenHeight-screenHeight/6.5f, screenWidth/15,screenHeight/8.5f,0);

        texture = new Texture(Gdx.files.internal("startBackground_1.png"));

        if(mainClass.getLanguageFinnish()) {
            credits = new Texture(Gdx.files.internal("CREDITS_textbox_FINNISH.png"));
            System.out.println("FINNISH");
        }else {
            credits = new Texture(Gdx.files.internal("CREDITS_textbox.png"));

        }

        if(!mainClass.getbackGroundMusicOffOrOn()) {
            mainClass.playBackgroundMusic();
        } else {
            mainClass.stopBackGroundMusic();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(mainClass.camera.combined);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(texture, 0f, 0f, mainClass.getScreenWidth(),mainClass.getScreenHeight());
        batch.draw(credits, 15, 15, mainClass.getScreenWidth()-30,mainClass.getScreenHeight()-30);

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
