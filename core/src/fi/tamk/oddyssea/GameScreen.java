package fi.tamk.oddyssea;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
    The actual game screen where the game is "played", gotten through main menu
 */

public class GameScreen implements Screen {

    MainClass mainClass;
    SpriteBatch batch;

    Texture backGroundImage1;
    Texture backGroundImage2_1;
    Texture backGroundImage2_2;
    Texture backGroundImage3;
    Texture backGroundImage4;
    Texture backGroundImage5_1;
    Texture backGroundImage5_2;
    Texture backGroundImage6;
    Texture backGroundImage7;
    Texture backGroundImage8;
    Texture backGroundImage9;
    Texture backGroundImage10;
    Texture backGroundImage11;
    Texture backGroundImage12_1;
    Texture backGroundImage12_2;
    Texture backGroundImage13;
    Texture backGroundImage14;
    Texture backGroundImage15;
    Texture backGroundImage16;
    Texture backGroundImage17;
    Texture backGroundImage18_1;
    Texture backGroundImage18_2;
    Texture backGroundImage19;
    Texture backGroundImage20;
    Texture backGroundImage21;
    Texture backGroundImage22;
    Texture backGroundImage23;



    Skin skin;

    private ChapterAssets chapter1;
    private ChapterAssets chapter2_1;
    private ChapterAssets chapter2_2;
    private ChapterAssets chapter3;
    private ChapterAssets chapter4;
    private ChapterAssets chapter5_1;
    private ChapterAssets chapter5_2;
    private ChapterAssets chapter6;
    private ChapterAssets chapter7;
    private ChapterAssets chapter8;
    private ChapterAssets chapter9;
    private ChapterAssets chapter10;
    private ChapterAssets chapter11;
    private ChapterAssets chapter12_1;
    private ChapterAssets chapter12_2;
    private ChapterAssets chapter13;
    private ChapterAssets chapter14;
    private ChapterAssets chapter15;
    private ChapterAssets chapter16;
    private ChapterAssets chapter17;
    private ChapterAssets chapter18_1;
    private ChapterAssets chapter18_2;
    private ChapterAssets chapter19;
    private ChapterAssets chapter20;
    private ChapterAssets chapter21;
    private ChapterAssets chapter22;
    private ChapterAssets chapter23;




    float textboxHeight;


    float buttonWidth;
    float buttonHeight;

    private boolean openedFirstTime = false;




    private float screenWidth;
    private float screenHeight;



    public void implementTextures() {
        backGroundImage1 = new Texture(Gdx.files.internal("background_001.png"));
        backGroundImage2_1 = new Texture(Gdx.files.internal("background_002_purje.png"));
        backGroundImage2_2 = new Texture(Gdx.files.internal("background_002_airo.png"));
        backGroundImage3 = new Texture(Gdx.files.internal("background_003.png"));
        backGroundImage4 = new Texture(Gdx.files.internal("background_004.png"));
        backGroundImage5_1 = new Texture(Gdx.files.internal("background_005_1.png"));
        backGroundImage5_2 = new Texture(Gdx.files.internal("background_005_2.png"));
        backGroundImage6 = new Texture(Gdx.files.internal("background_006.png"));
        backGroundImage7 = new Texture(Gdx.files.internal("background_007.png"));
        backGroundImage8 = new Texture(Gdx.files.internal("background_008.png"));
        backGroundImage9 = new Texture(Gdx.files.internal("background_009.png"));
        backGroundImage10 = new Texture(Gdx.files.internal("background_010.png"));
        backGroundImage11 = new Texture(Gdx.files.internal("background_011.png"));
        backGroundImage12_1 = new Texture(Gdx.files.internal("background_012_1.png"));
        backGroundImage12_2 = new Texture(Gdx.files.internal("background_012_2.png"));
        backGroundImage13 = new Texture(Gdx.files.internal("background_013.png"));
        backGroundImage14 = new Texture(Gdx.files.internal("background_014.png"));
        backGroundImage15 = new Texture(Gdx.files.internal("background_015.png"));
        backGroundImage16 = new Texture(Gdx.files.internal("background_016.png"));
        backGroundImage17 = new Texture(Gdx.files.internal("background_017.png"));
        backGroundImage18_1 = new Texture(Gdx.files.internal("background_018_1.png"));
        backGroundImage18_2 = new Texture(Gdx.files.internal("background_018_2.png"));
        backGroundImage19 = new Texture(Gdx.files.internal("background_019.png"));
        backGroundImage20 = new Texture(Gdx.files.internal("background_020.png"));
        backGroundImage21 = new Texture(Gdx.files.internal("background_021.png"));
        backGroundImage22 = new Texture(Gdx.files.internal("background_022.png"));
        backGroundImage23 = new Texture(Gdx.files.internal("background_023.png"));



    }
    public void implementTexturesForTextIndicators() {
        mainClass.setTextIndicator_2_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_2_2(new Texture(Gdx.files.internal("text_hidden_3.png")));

        mainClass.setTextIndicator_3_1(new Texture("text_now_3.png"));
        mainClass.setTextIndicator_3_2(new Texture("text_hidden_3.png"));
        mainClass.setTextIndicator_3_3(new Texture("text_hidden_3.png"));

        mainClass.setTextIndicator_4_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_4_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_4(new Texture(Gdx.files.internal("text_hidden_3.png")));

        mainClass.setTextIndicator_5_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_5_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_5(new Texture(Gdx.files.internal("text_hidden_3.png")));

        mainClass.setTextIndicator_6_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_6_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_6(new Texture(Gdx.files.internal("text_hidden_3.png")));

        mainClass.setTextIndicator_7_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_7_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_7(new Texture(Gdx.files.internal("text_hidden_3.png")));

        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_hidden_3.png")));

    }

    public void createScenes() {
        chapter1 = new ChapterAssets(mainClass, backGroundImage1, 3);
        chapter2_1 = new ChapterAssets(mainClass, backGroundImage2_1, 2);
        chapter2_2 = new ChapterAssets(mainClass, backGroundImage2_2, 2);
        chapter3 = new ChapterAssets(mainClass, backGroundImage3, 2);
        chapter4 = new ChapterAssets(mainClass, backGroundImage4, 2);
        chapter5_1 = new ChapterAssets(mainClass, backGroundImage5_1, 3);
        chapter5_2 = new ChapterAssets(mainClass, backGroundImage5_2, 3);
        chapter6 = new ChapterAssets(mainClass, backGroundImage6, 3);
        chapter7 = new ChapterAssets(mainClass, backGroundImage7, 3);
        chapter8 = new ChapterAssets(mainClass, backGroundImage8, 3);
        chapter9 = new ChapterAssets(mainClass, backGroundImage9, 4);
        chapter10 = new ChapterAssets(mainClass, backGroundImage10, 3);
        chapter11 = new ChapterAssets(mainClass, backGroundImage11, 4);
        chapter12_1 = new ChapterAssets(mainClass, backGroundImage12_1, 4);

        chapter12_2 = new ChapterAssets(mainClass, backGroundImage12_2, 4);
        chapter13 = new ChapterAssets(mainClass, backGroundImage13, 4);
        chapter14 = new ChapterAssets(mainClass, backGroundImage14, 4);
        chapter15 = new ChapterAssets(mainClass, backGroundImage15, 5);
        chapter16 = new ChapterAssets(mainClass, backGroundImage16, 5);
        chapter17 = new ChapterAssets(mainClass, backGroundImage17, 8);
        chapter18_1 = new ChapterAssets(mainClass, backGroundImage18_1, 5);

        chapter18_2 = new ChapterAssets(mainClass, backGroundImage18_2, 5);
        chapter19 = new ChapterAssets(mainClass, backGroundImage19, 4);
        chapter20 = new ChapterAssets(mainClass, backGroundImage20, 4);
        chapter21 = new ChapterAssets(mainClass, backGroundImage21, 5);
        chapter22 = new ChapterAssets(mainClass, backGroundImage22, 7);
        chapter23 = new ChapterAssets(mainClass, backGroundImage23, 4);

    }


        public void requiredStepsFirstLoad() {
        mainClass.setStepsToOpenChapter2_1(10);//(500); //WRONG + 300 (5);//
        mainClass.setStepsToOpenChapter2_2(10);//(500);
        mainClass.setStepsToOpenChapter3_1(5);//(700);
        mainClass.setStepsToOpenChapter4_1(10);//(4000);
        mainClass.setStepsToOpenChapter5_1(5);//(2000); //WRONG + 1000
        mainClass.setStepsToOpenChapter5_2(5);//(2000);
        mainClass.setStepsToOpenChapter6_1(10);//(2000);
        mainClass.setStepsToOpenChapter7_1(5);//(6500);
        mainClass.setStepsToOpenChapter8_1(10);//(2000);
        mainClass.setStepsToOpenChapter9_1(5);//(4000);
        mainClass.setStepsToOpenChapter10_1(10);//(3000);
        mainClass.setStepsToOpenChapter11_1(5);//(3600);
        mainClass.setStepsToOpenChapter12_1(10);//(4000); //WRONG + 200
        mainClass.setStepsToOpenChapter12_2(10);//(4000);
        mainClass.setStepsToOpenChapter13_1(5);//(4500);
        mainClass.setStepsToOpenChapter14_1(10);//(4000);
        mainClass.setStepsToOpenChapter15_1(5);//(3000);
        mainClass.setStepsToOpenChapter16_1(10);//(6000);
        mainClass.setStepsToOpenChapter17_1(5);//(4500);
        mainClass.setStepsToOpenChapter18_1(10);//(5000); //WRONG + 800
        mainClass.setStepsToOpenChapter18_2(10);//(5000);
        mainClass.setStepsToOpenChapter19_1(5);//(2000);
        mainClass.setStepsToOpenChapter20_1(10);//(2000);
        mainClass.setStepsToOpenChapter21_1(5);//(3000);
        mainClass.setStepsToOpenChapter22_1(10);//(2200);
        mainClass.setStepsToOpenChapter23_1(5);//(3500); //Vaihtoehtoja (jos alex valtisee mennä juhliin, alkaa peli alusta)
    }

    public void requiredStepsUpdater() {
        mainClass.setStepsToOpenChapter2_1(mainClass.prefs.getInteger("setStepsToOpenChapter2_1"));
        mainClass.setStepsToOpenChapter2_2(mainClass.prefs.getInteger("setStepsToOpenChapter2_2"));

        mainClass.setStepsToOpenChapter3_1(mainClass.prefs.getInteger("setStepsToOpenChapter3_1"));
        mainClass.setStepsToOpenChapter4_1(mainClass.prefs.getInteger("setStepsToOpenChapter4_1"));

        mainClass.setStepsToOpenChapter5_1(mainClass.prefs.getInteger("setStepsToOpenChapter5_1"));
        mainClass.setStepsToOpenChapter5_2(mainClass.prefs.getInteger("setStepsToOpenChapter5_2"));

        mainClass.setStepsToOpenChapter6_1(mainClass.prefs.getInteger("setStepsToOpenChapter6_1"));
        mainClass.setStepsToOpenChapter7_1(mainClass.prefs.getInteger("setStepsToOpenChapter7_1"));
        mainClass.setStepsToOpenChapter8_1(mainClass.prefs.getInteger("setStepsToOpenChapter8_1"));
        mainClass.setStepsToOpenChapter9_1(mainClass.prefs.getInteger("setStepsToOpenChapter9_1"));
        mainClass.setStepsToOpenChapter10_1(mainClass.prefs.getInteger("setStepsToOpenChapter10_1"));
        mainClass.setStepsToOpenChapter11_1(mainClass.prefs.getInteger("setStepsToOpenChapter11_1"));

        mainClass.setStepsToOpenChapter12_1(mainClass.prefs.getInteger("setStepsToOpenChapter12_1"));
        mainClass.setStepsToOpenChapter12_2(mainClass.prefs.getInteger("setStepsToOpenChapter12_2"));

        mainClass.setStepsToOpenChapter13_1(mainClass.prefs.getInteger("setStepsToOpenChapter13_1"));
        mainClass.setStepsToOpenChapter14_1(mainClass.prefs.getInteger("setStepsToOpenChapter14_1"));
        mainClass.setStepsToOpenChapter15_1(mainClass.prefs.getInteger("setStepsToOpenChapter15_1"));
        mainClass.setStepsToOpenChapter16_1(mainClass.prefs.getInteger("setStepsToOpenChapter16_1"));
        mainClass.setStepsToOpenChapter17_1(mainClass.prefs.getInteger("setStepsToOpenChapter17_1"));

        mainClass.setStepsToOpenChapter18_1(mainClass.prefs.getInteger("setStepsToOpenChapter18_1"));
        mainClass.setStepsToOpenChapter18_2(mainClass.prefs.getInteger("setStepsToOpenChapter18_2"));

        mainClass.setStepsToOpenChapter19_1(mainClass.prefs.getInteger("setStepsToOpenChapter19_1"));
        mainClass.setStepsToOpenChapter20_1(mainClass.prefs.getInteger("setStepsToOpenChapter20_1"));
        mainClass.setStepsToOpenChapter21_1(mainClass.prefs.getInteger("setStepsToOpenChapter21_1"));
        mainClass.setStepsToOpenChapter22_1(mainClass.prefs.getInteger("setStepsToOpenChapter22_1"));
        mainClass.setStepsToOpenChapter23_1(mainClass.prefs.getInteger("setStepsToOpenChapter23_1"));

    }

    public void addExitAndMusicButtons() {

        mainClass.createButtons(new Texture("back_X.png"),"",0,8,
                20,screenHeight-screenHeight/6.5f, screenWidth/15,screenHeight/7.5f,0);

        if(!mainClass.getbackGroundMusicOffOrOn()) {
            mainClass.createButtons(new Texture("sound_on_button.png"), "", 0, 13, screenWidth - buttonWidth/4.5f -10,
                    screenHeight - buttonHeight - 10, buttonWidth / 4.5f, buttonHeight, 0);
            System.out.println("CREATED SOUND BUTTON ON");
        } else {
            mainClass.createButtons(new Texture("sound_off_button.png"), "", 0, 13, screenWidth - buttonWidth/4.5f -10,
                    screenHeight - buttonHeight - 10, buttonWidth / 4.5f, buttonHeight, 0);
            System.out.println("CREATED SOUND BUTTON OFF");
        }

        //CHAPTER TEXT IN THE BOTTOM LEFT CORNER OF THE TEXT BOX
        mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter() + " " + mainClass.getChapterNumber(),0,14,
                textboxHeight/8, screenHeight/18, 30 ,20,0);

    }


    public GameScreen(MainClass MainClass2) {
        this.mainClass = MainClass2;
        batch = mainClass.getBatch();
        mainClass.getStage().clear();
        screenHeight = mainClass.getScreenHeight();
        screenWidth = mainClass.getScreenWidth();
//        mainClass.clearGroup(15);
        if(screenHeight < 800) {
            textboxHeight = screenHeight/3.7f;
        } else if (screenHeight >= 1000) {
            textboxHeight = screenHeight/4f;
        }


        openedFirstTime = mainClass.prefs.getBoolean("openedFirstTime");

        buttonWidth = screenWidth/4;
        buttonHeight = screenHeight/10;

       //These need to be created again each time you open the project again, the textures and scenes so they cannot be moved to the openedFirstTime
        implementTextures();
        createScenes();


        if(!mainClass.getbackGroundMusicOffOrOn()) {
            mainClass.playBackgroundMusic();
        } else {
            mainClass.stopBackGroundMusic();
        }

        //Check if the game is being opened for the very first time to save the chapter number to the initial 1
        //as it hasn't been set to anything before the initial open
        //and also save the openedFirstTime boolean to true so this will only happen once

//        System.out.println("GOT HERE asdasdasdasdasdasdasdasdasdasdasdasdasdasasddas");

        if (!openedFirstTime) {

//            mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
//            mainClass.setGotToTheLastTextOnceAlready(false);
//            System.out.println("GOT HERE asdasdasdasdasdasdasdasdasdasdasdasdasdasasddas");

            openedFirstTime = true;
            mainClass.prefs.putBoolean("openedFirstTime", openedFirstTime);
            mainClass.prefs.flush();
            requiredStepsFirstLoad();
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
            mainClass.setClearedChapter6(false);
            mainClass.prefs.putBoolean("clearedChapter6", mainClass.getClearedChapter6());
            mainClass.setClearedChapter7(false);
            mainClass.prefs.putBoolean("clearedChapter7", mainClass.getClearedChapter7());
            mainClass.setClearedChapter8(false);
            mainClass.prefs.putBoolean("clearedChapter8", mainClass.getClearedChapter8());
            mainClass.setClearedChapter9(false);
            mainClass.prefs.putBoolean("clearedChapter9", mainClass.getClearedChapter9());
            mainClass.setClearedChapter10(false);
            mainClass.prefs.putBoolean("clearedChapter10", mainClass.getClearedChapter10());
            mainClass.setClearedChapter11(false);
            mainClass.prefs.putBoolean("clearedChapter11", mainClass.getClearedChapter11());
            mainClass.setClearedChapter12(false);
            mainClass.prefs.putBoolean("clearedChapter12", mainClass.getClearedChapter12());
            mainClass.setClearedChapter13(false);
            mainClass.prefs.putBoolean("clearedChapter13", mainClass.getClearedChapter13());
            mainClass.setClearedChapter14(false);
            mainClass.prefs.putBoolean("clearedChapter14", mainClass.getClearedChapter14());
            mainClass.setClearedChapter15(false);
            mainClass.prefs.putBoolean("clearedChapter15", mainClass.getClearedChapter15());
            mainClass.setClearedChapter16(false);
            mainClass.prefs.putBoolean("clearedChapter16", mainClass.getClearedChapter16());
            mainClass.setClearedChapter17(false);
            mainClass.prefs.putBoolean("clearedChapter17", mainClass.getClearedChapter17());
            mainClass.setClearedChapter18(false);
            mainClass.prefs.putBoolean("clearedChapter18", mainClass.getClearedChapter18());
            mainClass.setClearedChapter19(false);
            mainClass.prefs.putBoolean("clearedChapter19", mainClass.getClearedChapter19());
            mainClass.setClearedChapter20(false);
            mainClass.prefs.putBoolean("clearedChapter20", mainClass.getClearedChapter20());
            mainClass.setClearedChapter21(false);
            mainClass.prefs.putBoolean("clearedChapter21", mainClass.getClearedChapter21());
            mainClass.setClearedChapter22(false);
            mainClass.prefs.putBoolean("clearedChapter22", mainClass.getClearedChapter22());
            mainClass.setClearedChapter23(false);
            mainClass.prefs.putBoolean("clearedChapter23", mainClass.getClearedChapter23());
            mainClass.prefs.flush();

        }

//        System.out.println(mainClass.getPlayPressed());

        if (mainClass.getPlayPressed()) {
//            System.out.println("HEREEEEFDFSEF");
            mainClass.setChapterNumber(mainClass.prefs.getInteger("currentFurthestChapter"));
            mainClass.prefs.putInteger("ChapterNumber",mainClass.getChapterNumber());
            mainClass.setPlayPressed(false);
//            System.out.println(mainClass.getChapterNumber() + "H");
//            System.out.println(mainClass.getCurrentFurthestChapter() + " CUR H");
            mainClass.prefs.flush();
        }

        requiredStepsUpdater();
        mainClass.setClearedChapter1(mainClass.prefs.getBoolean("clearedChapter1"));
        mainClass.setClearedChapter2(mainClass.prefs.getBoolean("clearedChapter2"));
        mainClass.setClearedChapter3(mainClass.prefs.getBoolean("clearedChapter3"));
        mainClass.setClearedChapter4(mainClass.prefs.getBoolean("clearedChapter4"));
        mainClass.setClearedChapter5(mainClass.prefs.getBoolean("clearedChapter5"));
        mainClass.setClearedChapter6(mainClass.prefs.getBoolean("clearedChapter6"));
        mainClass.setClearedChapter7(mainClass.prefs.getBoolean("clearedChapter7"));
        mainClass.setClearedChapter8(mainClass.prefs.getBoolean("clearedChapter8"));
        mainClass.setClearedChapter9(mainClass.prefs.getBoolean("clearedChapter9"));
        mainClass.setClearedChapter10(mainClass.prefs.getBoolean("clearedChapter10"));
        mainClass.setClearedChapter11(mainClass.prefs.getBoolean("clearedChapter11"));
        mainClass.setClearedChapter12(mainClass.prefs.getBoolean("clearedChapter12"));
        mainClass.setClearedChapter13(mainClass.prefs.getBoolean("clearedChapter13"));
        mainClass.setClearedChapter14(mainClass.prefs.getBoolean("clearedChapter14"));
        mainClass.setClearedChapter15(mainClass.prefs.getBoolean("clearedChapter15"));
        mainClass.setClearedChapter16(mainClass.prefs.getBoolean("clearedChapter16"));
        mainClass.setClearedChapter17(mainClass.prefs.getBoolean("clearedChapter17"));
        mainClass.setClearedChapter18(mainClass.prefs.getBoolean("clearedChapter18"));
        mainClass.setClearedChapter19(mainClass.prefs.getBoolean("clearedChapter19"));
        mainClass.setClearedChapter20(mainClass.prefs.getBoolean("clearedChapter20"));
        mainClass.setClearedChapter21(mainClass.prefs.getBoolean("clearedChapter21"));
        mainClass.setClearedChapter22(mainClass.prefs.getBoolean("clearedChapter22"));
        mainClass.setClearedChapter23(mainClass.prefs.getBoolean("clearedChapter23"));
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


        int steps = mainClass.getCurrentSteps();
        if(mainClass.getChapterNumber() == 1 && !mainClass.getSwapped()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter1);
            mainClass.setSwapped(true);

//            if(!mainClass.getGotToTheLastTextOnceAlready()) {
//                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
//                System.out.println(mainClass.getGotToLastTextPartOkayToShowNeededButtons() + "G");
//            } else {
//                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
//                System.out.println(mainClass.getGotToLastTextPartOkayToShowNeededButtons() + "GG");
//            }

            if(!mainClass.getClearedChapter1()) {
//                if(mainClass.getGotToLastTextPartOkayToShowNeededButtons()) {
//                    System.out.println("GOT TO THE LAST PART OF THE TEXT, HERE THE BUTTONS WOULD COME VISIBLE");
//                }
//                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);

                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getChapter1_choice_text_1() +mainClass.getStepsToOpenChapter2_1(),0,5,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter2_1());
//                mainClass.setButton5Visible(false);
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getChapter1_choice_text_2() +mainClass.getStepsToOpenChapter2_2(),0,6,
                        screenWidth-buttonWidth*2-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter2_2());
//                mainClass.setButton6Visible(false);
//
//                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        screenWidth-buttonWidth*2-50, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter2_1());

            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        screenWidth-buttonWidth*2-50, screenHeight/18, screenWidth/4 ,20,0);
            }



            implementTexturesForTextIndicators();

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter1_1Text(),1.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);

            addExitAndMusicButtons();

        }

        if(mainClass.getChapterNumber() == 2 && !mainClass.getSwapped() && mainClass.getClearedChapter1()) {
            mainClass.getStage().clear();

            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter2()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }

            if(mainClass.getChoseWrong_1()) {
                mainClass.getStage().addActor(chapter2_1);
            } else {
                mainClass.getStage().addActor(chapter2_2);
            }
            if(!mainClass.getClearedChapter2()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +mainClass.getStepsToOpenChapter3_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter3_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter3_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }

            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);


            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter2_1Text(),2.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.putInteger("ChapterNumber",2 );
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();

        }


        if(mainClass.getChapterNumber() == 3 && !mainClass.getSwapped()&& mainClass.getClearedChapter2() ) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter3);
            mainClass.prefs.putBoolean("clearedChapter2", true);
            mainClass.prefs.putInteger("ChapterNumber",3 );

            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter3()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }

            if(!mainClass.getClearedChapter3()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +mainClass.getStepsToOpenChapter4_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter4_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter4_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter3_1Text(),3.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }


        if(mainClass.getChapterNumber() == 4 && !mainClass.getSwapped() && mainClass.getClearedChapter3()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter4);
            mainClass.prefs.putBoolean("clearedChapter3", true);
            mainClass.prefs.putInteger("ChapterNumber",4 );

            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter4()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }

            if(!mainClass.getClearedChapter4()) {
                mainClass.createButtons(new Texture("button_orange.png"),"Älä luota " +mainClass.getStepsToOpenChapter5_1(),0,5,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter5_1());
                mainClass.createButtons(new Texture("button_orange.png"),"Luota "+mainClass.getStepsToOpenChapter5_2(),0,6,
                        screenWidth-buttonWidth*2-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter5_2());


                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter5_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }

            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter4_1Text(),4.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }


        if(mainClass.getChapterNumber() == 5 && !mainClass.getSwapped()&& mainClass.getClearedChapter4()) {
            mainClass.getStage().clear();
            if(mainClass.getChoseWrong_2()) {
                mainClass.getStage().addActor(chapter5_1);
            } else {
                mainClass.getStage().addActor(chapter5_2);
            }
            mainClass.prefs.putBoolean("clearedChapter4", true);
            mainClass.prefs.putInteger("ChapterNumber",5 );

            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter5()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }

            if(!mainClass.getClearedChapter5()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +mainClass.getStepsToOpenChapter6_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter6_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter6_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter5_1Text(),5.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 6 && !mainClass.getSwapped()&& mainClass.getClearedChapter5()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter6);
            mainClass.prefs.putBoolean("clearedChapter5", true);
            mainClass.prefs.putInteger("ChapterNumber",6 );

            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter6()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }

            if(!mainClass.getClearedChapter6()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +mainClass.getStepsToOpenChapter7_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter7_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter7_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter6_1Text(),6.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

//        System.out.println(mainClass.getChapterNumber() + "CHAPTER NUMBER AND CLEARED CHAPTER 6 IS " + mainClass.getClearedChapter6());
        if(mainClass.getChapterNumber() == 7 && !mainClass.getSwapped()&& mainClass.getClearedChapter6()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter7);
            mainClass.prefs.putBoolean("clearedChapter6", true);
            mainClass.prefs.putInteger("ChapterNumber",7 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter7()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }

            if(!mainClass.getClearedChapter7()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +mainClass.getStepsToOpenChapter8_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter8_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter8_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter7_1Text(),7.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 8 && !mainClass.getSwapped()&& mainClass.getClearedChapter7()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter8);
            mainClass.prefs.putBoolean("clearedChapter7", true);
            mainClass.prefs.putInteger("ChapterNumber",8 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter8()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter8()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +mainClass.getStepsToOpenChapter9_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter9_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter9_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter8_1Text(),8.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }
        if(mainClass.getChapterNumber() == 9 && !mainClass.getSwapped()&& mainClass.getClearedChapter8()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter9);
            mainClass.prefs.putBoolean("clearedChapter8", true);
            mainClass.prefs.putInteger("ChapterNumber",9 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter9()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter9()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +mainClass.getStepsToOpenChapter10_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter10_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter10_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter9_1Text(),9.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 10 && !mainClass.getSwapped()&& mainClass.getClearedChapter9()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter10);
            mainClass.prefs.putBoolean("clearedChapter9", true);
            mainClass.prefs.putInteger("ChapterNumber",10 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter10()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter10()) {
                mainClass.createButtons(new Texture("button_orange.png"),mainClass.getStepsString() +mainClass.getStepsToOpenChapter11_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter11_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter11_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter10_1Text(),10.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 11 && !mainClass.getSwapped()&& mainClass.getClearedChapter10()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter11);
            mainClass.prefs.putBoolean("clearedChapter10", true);
            mainClass.prefs.putInteger("ChapterNumber",11 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter11()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter11()) {
                mainClass.createButtons(new Texture("button_orange.png"),"Jätä Albert" +mainClass.getStepsToOpenChapter12_1(),0,5,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter12_1());
                mainClass.createButtons(new Texture("button_orange.png"),"Ota Albert" +mainClass.getStepsToOpenChapter12_2(),0,6,
                        screenWidth-buttonWidth*2-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter12_2());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter12_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter11_1Text(),11.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 12 && !mainClass.getSwapped()&& mainClass.getClearedChapter11()) {
            mainClass.getStage().clear();
            if(mainClass.getChoseWrong_3()) {
                mainClass.getStage().addActor(chapter12_1);
            } else {
                mainClass.getStage().addActor(chapter12_2);
            }
            mainClass.prefs.putBoolean("clearedChapter11", true);
            mainClass.prefs.putInteger("ChapterNumber",12 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter12()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter12()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter13_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter13_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter13_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter12_1Text(),12.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 13 && !mainClass.getSwapped()&& mainClass.getClearedChapter12()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter13);
            mainClass.prefs.putBoolean("clearedChapter12", true);
            mainClass.prefs.putInteger("ChapterNumber",13 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter13()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter13()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter14_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter14_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter14_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter13_1Text(),13.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 14 && !mainClass.getSwapped()&& mainClass.getClearedChapter13()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter14);
            mainClass.prefs.putBoolean("clearedChapter13", true);
            mainClass.prefs.putInteger("ChapterNumber",14 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter14()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter14()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter15_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter15_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter15_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter14_1Text(),14.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 15 && !mainClass.getSwapped()&& mainClass.getClearedChapter14()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter15);
            mainClass.prefs.putBoolean("clearedChapter14", true);
            mainClass.prefs.putInteger("ChapterNumber",15 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter15()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter15()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter16_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter16_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter16_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter15_1Text(),15.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 16 && !mainClass.getSwapped()&& mainClass.getClearedChapter15()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter16);
            mainClass.prefs.putBoolean("clearedChapter15", true);
            mainClass.prefs.putInteger("ChapterNumber",16 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter16()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter16()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter17_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter17_1());

                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter17_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter16_1Text(),16.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 17 && !mainClass.getSwapped()&& mainClass.getClearedChapter16()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter17);
            mainClass.prefs.putBoolean("clearedChapter16", true);
            mainClass.prefs.putInteger("ChapterNumber",17 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter17()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter17()) {
                mainClass.createButtons(new Texture("button_orange.png"),"Hyökkää itse"+mainClass.getStepsToOpenChapter18_1(),0,5,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter18_1());
                mainClass.createButtons(new Texture("button_orange.png"),"Albert hyökkää" +mainClass.getStepsToOpenChapter18_2(),0,6,
                        screenWidth-buttonWidth*2-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter18_2());


                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter18_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter17_1Text(),17.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 18 && !mainClass.getSwapped()&& mainClass.getClearedChapter17()) {
            mainClass.getStage().clear();
            if(mainClass.getChoseWrong_4()) {
                mainClass.getStage().addActor(chapter18_1);
            } else {
                mainClass.getStage().addActor(chapter18_2);
            }
            mainClass.prefs.putBoolean("clearedChapter17", true);
            mainClass.prefs.putInteger("ChapterNumber",18 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter18()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter18()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter19_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter19_1());


                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter19_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter18_1Text(),18.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 19 && !mainClass.getSwapped()&& mainClass.getClearedChapter18()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter19);
            mainClass.prefs.putBoolean("clearedChapter18", true);
            mainClass.prefs.putInteger("ChapterNumber",19 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter19()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter19()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter20_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter20_1());


                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter20_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter19_1Text(),19.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 20 && !mainClass.getSwapped()&& mainClass.getClearedChapter19()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter20);
            mainClass.prefs.putBoolean("clearedChapter19", true);
            mainClass.prefs.putInteger("ChapterNumber",20 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter20()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter20()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter21_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter21_1());


                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter21_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter20_1Text(),20.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 21 && !mainClass.getSwapped()&& mainClass.getClearedChapter20()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter21);
            mainClass.prefs.putBoolean("clearedChapter20", true);
            mainClass.prefs.putInteger("ChapterNumber",21 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter21()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter21()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter22_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter22_1());


                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter22_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter21_1Text(),21.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 22 && !mainClass.getSwapped()&& mainClass.getClearedChapter21()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter22);
            mainClass.prefs.putBoolean("clearedChapter21", true);
            mainClass.prefs.putInteger("ChapterNumber",22 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter22()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter22()) {
                mainClass.createButtons(new Texture("button_orange.png"),""+mainClass.getStepsToOpenChapter23_1(),0,6,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,mainClass.getStepsToOpenChapter23_1());


                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,mainClass.getStepsToOpenChapter23_1());
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter22_1Text(),22.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
        }

        if(mainClass.getChapterNumber() == 23 && !mainClass.getSwapped()&& mainClass.getClearedChapter22()) {
            mainClass.getStage().clear();
            mainClass.getStage().addActor(chapter23);
            mainClass.prefs.putBoolean("clearedChapter22", true);
            mainClass.prefs.putInteger("ChapterNumber",23 );
            if(!mainClass.getGotToTheLastTextOnceAlready() && !mainClass.getClearedChapter23()) {
                System.out.println("don't show buttons at the start");
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(false);
            } else {
                mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                System.out.println("show buttons at the start");
            }
            if(!mainClass.getClearedChapter23()) {
                mainClass.createButtons(new Texture("button_orange.png"),"Mene Juhliin",0,5,
                        screenWidth-buttonWidth-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,0);
                mainClass.createButtons(new Texture("button_orange.png"),"Älä mene",0,6,
                        screenWidth-buttonWidth*2-50, textboxHeight+buttonHeight/2.5f, buttonWidth ,buttonHeight,0);


                //CURRENT STEPS AND NEEDED STEPS WHEN NOT CLREARED YET
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            } else {
                mainClass.createButtons(new Texture("next_page.png"),"",0,6,
                        screenWidth-buttonWidth/5-50, textboxHeight+buttonHeight/2.5f, buttonWidth /5 ,buttonHeight,0);

                //CURRENT STEPS AND NEEDED STEPS WHEN CLEARED
                mainClass.createButtons(new Texture("textboxEMPTY.png"),"",0,15,
                        20, screenHeight/18, screenWidth/4 ,20,0);
            }
            mainClass.createButtons(new Texture("prev_page.png"),"",0,7,
                    50, textboxHeight+buttonHeight/2.5f, buttonWidth/5 ,buttonHeight,0);

            mainClass.createButtons(new Texture("textboxEMPTY.png"),mainClass.getChapter23_1Text(),23.1f,10,
                    20f,10f, screenWidth-40f,textboxHeight,0);
            mainClass.prefs.flush();
            mainClass.setSwapped(true);
            implementTexturesForTextIndicators();
            addExitAndMusicButtons();
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
