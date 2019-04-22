package fi.tamk.oddyssea;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * This is the Chapter select screen in the main menu that has all 23 chapters accessible via buttons depending on the progress of the game
 * @author Hanna Tuominen hanna.h.tuominen@tuni.fi
 * @version 24.4.2019
 * @since 15.01.2019
 */

public class ChapterSelect implements Screen {
    /**
     * the mainclass
     */
    private MainClass mainClass;
    /**
     * the batch from mainclass
     */
    private SpriteBatch batch;
    /**
     * the font
     */
    BitmapFont font12;
    /**
     * the chapter select background texture
     */
    private Texture texture;

    /**
     * the screen width of the device
     */
    private float screenWidth;
    /**
     * the screen height of the device
     */
    private float screenHeight;
    /**
     * the button width
     */
    private float buttonWidth;
    /**
     * the button height
     */
    private float buttonHeight;

    /**
     * everything needed on chapter select is created here (changed only when going to the chapter select through the main menu button)
     * <p>
     * first get needed stuff from main class and save locally
     * if currentfursthest chapter is 0 somehow set it to 1 to make chapter 1 possible to enter always
     * get the current status of the music playing if it should be on or off
     * set and get the current furthest chapter
     * create the inv scroller that will be under the chapter buttons to help with the pan scrolling of the buttons
     * create the top and bottom row of the chapter buttons
     * set the group (group1) place
     * add everything to the stage
     * and finally create the back X button to get back to main menu
     *
     * @param MainClass2 main class
     */
    public ChapterSelect(MainClass MainClass2) {
        this.mainClass = MainClass2;
        batch = mainClass.getBatch();
        mainClass.getStage().clear();
        mainClass.clearGroup(9);
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();
        buttonWidth = screenWidth/4;
        buttonHeight = screenHeight/10;

        if (mainClass.getCurrentFurthestChapter() == 0) {
            mainClass.setCurrentFurthestChapter(1);
        }

        if(!mainClass.getbackGroundMusicOffOrOn()) {
            mainClass.playBackgroundMusic();
        } else {
            mainClass.stopBackGroundMusic();
        }

        mainClass.setCurrentFurthestChapter(mainClass.prefs.getInteger("currentFurthestChapter"));
        mainClass.prefs.flush();

        texture = new Texture("inv_scroller.png");


        mainClass.createButtons(new Texture("inv_scroller.png"),"",0,12,
                0,0,buttonWidth*22,buttonHeight *8.5f,0);

        //System.out.println("BTTONWIDTH*22: " + buttonWidth*22);

        //UPROW
        //1
        mainClass.createButtons(new Texture("Chapter_1_unlocked_unpressed.png"),"1",0,9,
                20f,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        //3
        if(!mainClass.getClearedChapterGeneral(2)) {
            mainClass.createButtons(new Texture("Chapter_3_locked_unpressed.png"),"3",0,9,
                    (20f*2)+buttonWidth,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_3_unlocked_unpressed.png"),"3",0,9,
                    (20f*2)+buttonWidth,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }
        //5
        if(!mainClass.getClearedChapterGeneral(4)) {
            mainClass.createButtons(new Texture("Chapter_5_locked_unpressed.png"),"5",0,9,
                    (20f*3)+buttonWidth*2,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_5_unlocked_unpressed.png"),"5",0,9,
                    (20f*3)+buttonWidth*2,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }
        //7
        if(!mainClass.getClearedChapterGeneral(6)) {
            mainClass.createButtons(new Texture("Chapter_7_locked_unpressed.png"),"7",0,9,
                    (20f*4)+buttonWidth*3,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_7_unlocked_unpressed.png"),"7",0,9,
                    (20f*4)+buttonWidth*3,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //9
        if(!mainClass.getClearedChapterGeneral(8)) {
            mainClass.createButtons(new Texture("Chapter_9_locked_unpressed.png"),"9",0,9,
                    (20f*5)+buttonWidth*4,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_9_unlocked_unpressed.png"),"9",0,9,
                    (20f*5)+buttonWidth*4,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //11
        if(!mainClass.getClearedChapterGeneral(10)) {
            mainClass.createButtons(new Texture("Chapter_11_locked_unpressed.png"),"11",0,9,
                    (20f*6)+buttonWidth*5,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_11_unlocked_unpressed.png"),"11",0,9,
                    (20f*6)+buttonWidth*5,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //13
        if(!mainClass.getClearedChapterGeneral(12)) {
            mainClass.createButtons(new Texture("Chapter_13_locked_unpressed.png"),"13",0,9,
                    (20f*7)+buttonWidth*6,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_13_unlocked_unpressed.png"),"13",0,9,
                    (20f*7)+buttonWidth*6,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //15
        if(!mainClass.getClearedChapterGeneral(14)) {
            mainClass.createButtons(new Texture("Chapter_15_locked_unpressed.png"),"15",0,9,
                    (20f*8)+buttonWidth*7,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_15_unlocked_unpressed.png"),"15",0,9,
                    (20f*8)+buttonWidth*7,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //17
        if(!mainClass.getClearedChapterGeneral(16)) {
            mainClass.createButtons(new Texture("Chapter_17_locked_unpressed.png"),"17",0,9,
                    (20f*9)+buttonWidth*8,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_17_unlocked_unpressed.png"),"17",0,9,
                    (20f*9)+buttonWidth*8,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //19
        if(!mainClass.getClearedChapterGeneral(18)) {
            mainClass.createButtons(new Texture("Chapter_19_locked_unpressed.png"),"19",0,9,
                    (20f*10)+buttonWidth*9,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_19_unlocked_unpressed.png"),"19",0,9,
                    (20f*10)+buttonWidth*9,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //21
        if(!mainClass.getClearedChapterGeneral(20)) {
            mainClass.createButtons(new Texture("Chapter_21_locked_unpressed.png"),"21",0,9,
                    (20f*11)+buttonWidth*10,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_21_unlocked_unpressed.png"),"21",0,9,
                    (20f*11)+buttonWidth*10,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //23
        if(!mainClass.getClearedChapterGeneral(22)) {
            mainClass.createButtons(new Texture("Chapter_23_locked_unpressed.png"),"23",0,9,
                    (20f*12)+buttonWidth*11,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_23_unlocked_unpressed.png"),"23",0,9,
                    (20f*12)+buttonWidth*11,screenHeight/2.2f-6,buttonWidth,buttonHeight*3.5f,0);
        }






        //DOWNROW
        //2
        if(!mainClass.getClearedChapterGeneral(1)) {
            mainClass.createButtons(new Texture("Chapter_2_locked_unpressed.png"),"2",0,9,
                    20f,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_2_unlocked_unpressed.png"),"2",0,9,
                    20f,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }
        //4
        if(! mainClass.getClearedChapterGeneral(3)) {
            mainClass.createButtons(new Texture("Chapter_4_locked_unpressed.png"),"4",0,9,
                    (20f*2)+buttonWidth,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_4_unlocked_unpressed.png"),"4",0,9,
                    (20f*2)+buttonWidth,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //6
        if(! mainClass.getClearedChapterGeneral(5)) {
            mainClass.createButtons(new Texture("Chapter_6_locked_unpressed.png"),"6",0,9,
                    (20f*3)+buttonWidth*2,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_6_unlocked_unpressed.png"),"6",0,9,
                    (20f*3)+buttonWidth*2,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //8
        if(! mainClass.getClearedChapterGeneral(7)) {
            mainClass.createButtons(new Texture("Chapter_8_locked_unpressed.png"),"8",0,9,
                    (20f*4)+buttonWidth*3,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_8_unlocked_unpressed.png"),"8",0,9,
                    (20f*4)+buttonWidth*3,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //10
        if(! mainClass.getClearedChapterGeneral(9)) {
            mainClass.createButtons(new Texture("Chapter_10_locked_unpressed.png"),"10",0,9,
                    (20f*5)+buttonWidth*4,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_10_unlocked_unpressed.png"),"10",0,9,
                    (20f*5)+buttonWidth*4,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //12
        if(! mainClass.getClearedChapterGeneral(11)) {
            mainClass.createButtons(new Texture("Chapter_12_locked_unpressed.png"),"12",0,9,
                    (20f*6)+buttonWidth*5,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_12_unlocked_unpressed.png"),"12",0,9,
                    (20f*6)+buttonWidth*5,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //14
        if(! mainClass.getClearedChapterGeneral(13)) {
            mainClass.createButtons(new Texture("Chapter_14_locked_unpressed.png"),"14",0,9,
                    (20f*7)+buttonWidth*6,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_14_unlocked_unpressed.png"),"14",0,9,
                    (20f*7)+buttonWidth*6,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //16
        if(! mainClass.getClearedChapterGeneral(15)) {
            mainClass.createButtons(new Texture("Chapter_16_locked_unpressed.png"),"16",0,9,
                    (20f*8)+buttonWidth*7,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_16_unlocked_unpressed.png"),"16",0,9,
                    (20f*8)+buttonWidth*7,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //18
        if(!mainClass.getClearedChapterGeneral(17)) {
            mainClass.createButtons(new Texture("Chapter_18_locked_unpressed.png"),"18",0,9,
                    (20f*9)+buttonWidth*8,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_18_unlocked_unpressed.png"),"18",0,9,
                    (20f*9)+buttonWidth*8,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //20
        if(! mainClass.getClearedChapterGeneral(19)) {
            mainClass.createButtons(new Texture("Chapter_20_locked_unpressed.png"),"20",0,9,
                    (20f*10)+buttonWidth*9,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_20_unlocked_unpressed.png"),"20",0,9,
                    (20f*10)+buttonWidth*9,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }

        //22
        if(! mainClass.getClearedChapterGeneral(21)) {
            mainClass.createButtons(new Texture("Chapter_22_locked_unpressed.png"),"22",0,9,
                    (20f*11)+buttonWidth*10,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        } else {
            mainClass.createButtons(new Texture("Chapter_22_unlocked_unpressed.png"),"22",0,9,
                    (20f*11)+buttonWidth*10,screenHeight/2f - buttonHeight*4.5f-6,buttonWidth,buttonHeight*3.5f,0);
        }




        mainClass.getGroup1().setX(0);
        mainClass.getGroup1().setY(20);

        mainClass.groupStageAdd1();
        //BACK
        mainClass.createButtons(new Texture("back_X.png"),"",0,8,
                20,screenHeight-screenHeight/6.5f, screenWidth/15,screenHeight/8.5f,0);
        texture = new Texture(Gdx.files.internal("startBackground_1.png"));


    }

    @Override
    public void show() {

    }

    /**
     * render the current stage and background
     * @param delta
     */
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
