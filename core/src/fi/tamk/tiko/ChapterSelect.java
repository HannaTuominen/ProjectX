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

        mainClass.setClearedChapter1(mainClass.prefs.getBoolean("clearedChapter1"));
        mainClass.setClearedChapter2(mainClass.prefs.getBoolean("clearedChapter2"));
        mainClass.setClearedChapter3(mainClass.prefs.getBoolean("clearedChapter3"));
        mainClass.setClearedChapter4(mainClass.prefs.getBoolean("clearedChapter4"));
        mainClass.setClearedChapter5(mainClass.prefs.getBoolean("clearedChapter5"));
        mainClass.setCurrentFurthestChapter(mainClass.prefs.getInteger("currentFurthestChapter"));


        mainClass.createButtons(new Texture("chapter_1_unlock.png"),"1",0,9,
                screenWidth/2-buttonWidth*2,screenHeight/2+buttonHeight,buttonWidth/2,buttonHeight*2,0);

        if(!mainClass.getClearedChapter1()) {
            mainClass.createButtons(new Texture("chapter_1_lock.png"),"2",0,9,
                    screenWidth/2+buttonWidth,screenHeight/2+buttonHeight,buttonWidth/2,buttonHeight*2,0);
        } else {
            mainClass.createButtons(new Texture("chapter_1_unlock.png"),"2",0,9,
                    screenWidth/2+buttonWidth,screenHeight/2+buttonHeight,buttonWidth/2,buttonHeight*2,0);
        }

        if(! mainClass.getClearedChapter2()) {
            mainClass.createButtons(new Texture("chapter_1_lock.png"),"3",0,9,
                    screenWidth/2-buttonWidth*2,screenHeight/2-buttonHeight,buttonWidth/2,buttonHeight*2,0);
        } else {
            mainClass.createButtons(new Texture("chapter_1_unlock.png"),"3",0,9,
                    screenWidth/2-buttonWidth*2,screenHeight/2-buttonHeight,buttonWidth/2,buttonHeight*2,0);
        }

        if(! mainClass.getClearedChapter3()) {
            mainClass.createButtons(new Texture("chapter_1_lock.png"),"4",0,9,
                    screenWidth/2+buttonWidth,screenHeight/2-buttonHeight,buttonWidth/2,buttonHeight*2,0);
        } else {
            mainClass.createButtons(new Texture("chapter_1_unlock.png"),"4",0,9,
                    screenWidth/2+buttonWidth,screenHeight/2-buttonHeight,buttonWidth/2,buttonHeight*2,0);
        }

        if(!mainClass.getClearedChapter4()) {
            mainClass.createButtons(new Texture("chapter_1_lock.png"),"5",0,9,
                    screenWidth/2-buttonWidth*2,screenHeight/2-buttonHeight*3,buttonWidth/2,buttonHeight*2,0);
        } else {
            mainClass.createButtons(new Texture("chapter_1_unlock.png"),"5",0,9,
                    screenWidth/2-buttonWidth*2,screenHeight/2-buttonHeight*3,buttonWidth/2,buttonHeight*2,0);
        }

        //BACK
        mainClass.createButtons(new Texture("back_X.png"),"",0,8,
                20,screenHeight-screenHeight/10-20,screenWidth/20,screenHeight/10,0);
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
