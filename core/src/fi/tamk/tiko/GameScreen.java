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

/**
    The actual game screen where the game is "played", gotten through main menu
 */

public class GameScreen implements Screen {

    MainClass mainClass;
    SpriteBatch batch;

    Texture backGroundImage1;
    Texture backGroundImage2;
    Texture backGroundImage3;
    Texture backGroundImage4;
    Texture backGroundImage5;


    Skin skin;

    private ChapterAssets chapter1;
    private ChapterAssets chapter2;
    private ChapterAssets chapter3;
    private ChapterAssets chapter4;
    private ChapterAssets chapter5;

    float textboxHeight;


    float buttonWidth;
    float buttonHeight;

    private boolean openedFirstTime = false;




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
        chapter1 = new ChapterAssets(mainClass, backGroundImage1, false, 0,0,"idk mita taha tulis", "Tyhja", 100);
        chapter2 = new ChapterAssets(mainClass, backGroundImage2, true, 3,300,"purje", "airot", 300);
        chapter3 = new ChapterAssets(mainClass, backGroundImage3, false, 0,0,"idk mita taha tulis", "Tyhja", 300);
        chapter4 = new ChapterAssets(mainClass, backGroundImage4, false, 0,0,"idk mita taha tulis", "Tyhja", 300);
        chapter5 = new ChapterAssets(mainClass, backGroundImage5, false, 0,0,"idk mita taha tulis", "Tyhja", 300);

//        Gdx.input.setInputProcessor(stage);
    }

    public GameScreen(MainClass MainClass2) {
        this.mainClass = MainClass2;
        batch = mainClass.getBatch();
        mainClass.getStage().clear();
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();

        if(screenHeight < 800) {
            textboxHeight = screenHeight/3.3f;
        } else if (screenHeight >= 1000) {
            textboxHeight = screenHeight/5f;
        }

        skin = new Skin( Gdx.files.internal("uiskin.json"));


        openedFirstTime = mainClass.prefs.getBoolean("openedFirstTime");

        buttonWidth = screenWidth/4;
        buttonHeight = screenHeight/10;

       //These need to be created again each time you open the project again, the textures and scenes so they cannot be moved to the openedFirstTime
        implementTextures();
        createScenes();

        //Check if the game is being opened for the very first time to save the chapter number to the initial 1
        //as it hasn't been set to anything before the initial open
        //and also save the openedFirstTime boolean to true so this will only happen once

//        System.out.println("GOT HERE asdasdasdasdasdasdasdasdasdasdasdasdasdasasddas");

        if (!openedFirstTime) {

            System.out.println("GOT HERE asdasdasdasdasdasdasdasdasdasdasdasdasdasasddas");

            openedFirstTime = true;
            mainClass.prefs.putBoolean("openedFirstTime", openedFirstTime);
            mainClass.prefs.flush();
            //ON FIRST OPEN SET CURRENT STEPS TO 0
//            mainClass.setCurrentSteps(0);

            mainClass.prefs.putFloat("currentSteps", mainClass.getCurrentSteps());

            mainClass.setChapterNumber(1);
            mainClass.setCurrentFurthestChapter(1);
            mainClass.prefs.putInteger("ChapterNumber",1 );
            mainClass.prefs.putInteger("currentFurthestChapter",1);

            mainClass.setClearedChapter1(false);
            mainClass.prefs.putBoolean("clearedChapter1", false);
            mainClass.setClearedChapter2(false);
            mainClass.prefs.putBoolean("clearedChapter2", mainClass.getClearedChapter2());
            mainClass.setClearedChapter3(false);
            mainClass.prefs.putBoolean("clearedChapter2", mainClass.getClearedChapter3());
            mainClass.setClearedChapter4(false);
            mainClass.prefs.putBoolean("clearedChapter4", mainClass.getClearedChapter4());
            mainClass.setClearedChapter5(false);
            mainClass.prefs.putBoolean("clearedChapter5", mainClass.getClearedChapter5());
            mainClass.prefs.flush();

        }

//        System.out.println(mainClass.getPlayPressed());

        if (mainClass.getPlayPressed()) {
            System.out.println("HEREEEEFDFSEF");
            mainClass.setChapterNumber(mainClass.prefs.getInteger("currentFurthestChapter"));
            mainClass.prefs.putInteger("ChapterNumber",mainClass.getChapterNumber());
            mainClass.setPlayPressed(false);
            System.out.println(mainClass.getChapterNumber() + "H");
            System.out.println(mainClass.getCurrentFurthestChapter() + " CUR H");
            mainClass.prefs.flush();
        }

        mainClass.setClearedChapter1(mainClass.prefs.getBoolean("clearedChapter1"));
        mainClass.setClearedChapter2(mainClass.prefs.getBoolean("clearedChapter2"));
        mainClass.setClearedChapter3(mainClass.prefs.getBoolean("clearedChapter3"));
        mainClass.setClearedChapter4(mainClass.prefs.getBoolean("clearedChapter4"));
        mainClass.setClearedChapter5(mainClass.prefs.getBoolean("clearedChapter5"));
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


        if(mainClass.getChapterNumber() == 1 && !mainClass.getSwapped()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter1);
            mainClass.setSwapped(true);
            if(!mainClass.getClearedChapter1()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +2,0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,2);
            } else {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getNext(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,0);
            }
            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter1_1Text(),1.1f,10,
                    20f,20f, screenWidth-40f,textboxHeight,0);
            mainClass.createButtons(new Texture("back_X.png"),"",0,8,
                    20,screenHeight-screenHeight/10-20, screenWidth/20,screenHeight/10,0);
        }

        if(mainClass.getChapterNumber() == 2 && !mainClass.getSwapped() && mainClass.getClearedChapter1()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter2);
            if(!mainClass.getClearedChapter2()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +1,0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,1);
            } else {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getNext(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,0);
            }
            mainClass.createButtons(new Texture("button_orange.png"),mainClass.getPrevious(),2.1f,7,
                    50, textboxHeight+30, buttonWidth ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter2_1Text(),2.1f,10,
                    20f,20f, screenWidth-40f,textboxHeight,0);
            mainClass.createButtons(new Texture("back_X.png"),"",0,8,
                    20,screenHeight-screenHeight/10-20, screenWidth/20,screenHeight/10,0);
            mainClass.prefs.putInteger("ChapterNumber",2 );
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
        }


        if(mainClass.getChapterNumber() == 3 && !mainClass.getSwapped()&& mainClass.getClearedChapter2() ) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter3);
            mainClass.prefs.putBoolean("clearedChapter2", true);
            mainClass.prefs.putInteger("ChapterNumber",3 );

            if(!mainClass.getClearedChapter3()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +2,0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,2);
            } else {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getNext(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,0);
            }
            mainClass.createButtons(new Texture("button_orange.png"),mainClass.getPrevious(),3.1f,7,
                    50, textboxHeight+30, buttonWidth ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter3_1Text(),3.1f,10,
                    20f,20f, screenWidth-40f,textboxHeight,0);
            mainClass.createButtons(new Texture("back_X.png"),"",0,8,
                    20,screenHeight-screenHeight/10-20, screenWidth/20,screenHeight/10,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
        }


        if(mainClass.getChapterNumber() == 4 && !mainClass.getSwapped() && mainClass.getClearedChapter3()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter4);
            mainClass.prefs.putBoolean("clearedChapter3", true);
            mainClass.prefs.putInteger("ChapterNumber",4 );

            if(!mainClass.getClearedChapter4()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +2,0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,2);
            } else {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getNext(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,0);
            }
            mainClass.createButtons(new Texture("button_orange.png"),mainClass.getPrevious(),4.1f,7,
                    50, textboxHeight+30, buttonWidth ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter4_1Text(),4.1f,10,
                    20f,20f, screenWidth-40f,textboxHeight,0);
            mainClass.createButtons(new Texture("back_X.png"),"",0,8,
                    20,screenHeight-screenHeight/10-20, screenWidth/20,screenHeight/10,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
        }


        if(mainClass.getChapterNumber() == 5 && !mainClass.getSwapped()&& mainClass.getClearedChapter4()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter5);
            mainClass.prefs.putBoolean("clearedChapter4", true);
            mainClass.prefs.putInteger("ChapterNumber",5 );
            if(!mainClass.getClearedChapter5()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +2,0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,2);
            } else {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getNext(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+30, buttonWidth ,buttonHeight,0);
            }
            mainClass.createButtons(new Texture("button_orange.png"),mainClass.getPrevious(),5.1f,7,
                    50, textboxHeight+30, buttonWidth ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter5_1Text(),5.1f,10,
                    20f,20f, screenWidth-40f,textboxHeight,0);
            mainClass.createButtons(new Texture("back_X.png"),"",8,0,
                    20,screenHeight-screenHeight/10-20, screenWidth/20,screenHeight/10,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
        }

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
