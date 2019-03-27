package fi.tamk.tiko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

import java.util.Locale;

public class Button extends Actor {
    MainClass mainClass;
    BitmapFont font12;
    Texture texture;
    String textForAButton;
    int chapterNumber;
    int useForTheButton;
    float xPlace;
    float yPlace;
    float buttonWidth;
    float buttonHeight;
    int chapterSelect;
    int stepsToOpenNextChapter;
    int steps;
    boolean enoughSteps = false;
    float storyID;
    float buttonTextXPlace;
    float buttonTextYPlace;
    Group group;
    static float scrollerWidth;
    boolean pan = false;

    float touchDownX;
    float touchDownY;
    float touchUpX;
    float touchUpY;

    public void setGroup(Group group) {
       this.group = group;
    }
    public Group getGroup() {
        return group;
    }

    public String getTextForAButton() {
        return textForAButton;
    }
    public void setTextForAButton(String textForAButton) {
        this.textForAButton = textForAButton;
    }
    public int getUseForTheButton() {
        return useForTheButton;
    }
    public void setUseForTheButton(int useForTheButton) {
        this.useForTheButton = useForTheButton;
    }
    public Texture getTexture() {
        return texture;
    }
    public void setTexture(Texture texture) {
        this.texture = texture;
    }
    public float getStoryID() {
        return storyID;
    }

    public void setStoryID(float storyID) {
        this.storyID = storyID;
    }

   public Button(MainClass mainclass, Texture texture, String textForAButton, float storyID, int useForTheButton, float xPlace,
                 float yPlace, float buttonWidth, float buttonHeight, int stepsToOpenNextChapter) {

        this.mainClass = mainclass;
        //this.texture = texture;
        setTextForAButton(textForAButton);
        setStoryID(storyID);
        setTexture(texture);
        setUseForTheButton(useForTheButton);
        setGroup(mainclass.getGroup());
        //this.useForTheButton = useForTheButton;
        this.xPlace = xPlace;
        this.yPlace = yPlace;
        this.buttonHeight = buttonHeight;
        this.buttonWidth = buttonWidth;
        if(useForTheButton == 12) {
            scrollerWidth = -mainclass.getScreenWidth()/4*22+(mainclass.getScreenWidth()/0.99f);
        }

        //this.storyID = storyID;


       //SETS THE X PLACE CORRECTLY TO CENTER DEPENDING ON THE TEXT SIZE FOR BUTTONS
        buttonTextXPlace = this.xPlace + buttonWidth/2 - mainClass.getTextPlaceWIDTH(textForAButton)/2;
        buttonTextYPlace = this.yPlace+buttonHeight/1.7f;


        if(stepsToOpenNextChapter > 0) {
            this.stepsToOpenNextChapter = stepsToOpenNextChapter;
        }
       chapterNumber = mainclass.getChapterNumber();
//       System.out.println(chapterNumber+"H");
       font12 = mainClass.getFont12();

       setBounds(xPlace, yPlace, buttonWidth, buttonHeight);

       //addListener(new PlayerListener());
       addListener(new Gesture());
   }

    class Gesture extends ActorGestureListener {
        @Override

        public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
            //touchDownX = x;
            //touchDownY = y;
            touchUpX =0;

           // System.out.println("TOUCHDOWNX: " + touchDownX + " TOUCHDOWNY: " + touchDownY);
            if(getUseForTheButton() == 1 || getUseForTheButton() == 2 || getUseForTheButton() == 3 || getUseForTheButton() == 4 || getUseForTheButton() == 8 ) {
                setTexture(new Texture(Gdx.files.internal("button_orange_pressed.png")));
            }
            if (getUseForTheButton() == 8) {
                setTexture(new Texture(Gdx.files.internal("back_X_pressed.png")));
            }

            if(getUseForTheButton() == 6 || getUseForTheButton() == 5 || getUseForTheButton() == 7) {
                if(stepsToOpenNextChapter > steps) {
                    System.out.println("NExt chapter button pressed but too little steps");
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_orange_pressed.png")));
                }
            }


        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
           /*
            useForTheButton
            1. Play the game / continue
            2. Chapter Select
            3. Credits
            4. Exit
            5. Choice 1 (WRONG CHOICE)
            6. Choice 2
            7. Previous chapter
            8. Back to main menu
            9. ChapterSelect Buttons
            10. StoryBox button next slide
            11. Fin/Eng switch
            12. Pan chapterScroller
            13. Mute and unMute music
            */

            if (getUseForTheButton() == 6 || getUseForTheButton() == 5) {

                if (mainClass.getChapterNumber() == 1) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        if (getUseForTheButton() == 5) {
                            mainClass.setStepsToOpenChapter3_1(mainClass.getStepsToOpenChapter3_1() + 10);
                            mainClass.setChoseWrong_1(true);
                        }

                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        System.out.println(steps);
                        mainClass.setClearedChapter1(true);
                        mainClass.prefs.putBoolean("clearedChapter1", mainClass.getClearedChapter1());
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
//                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                        enoughSteps = true;
                        mainClass.setChapterNumber(chapterNumber + 1);

//                     mainClass.prefs.putInteger("ChapterNumber",chapterNumber+1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }


                } else if (mainClass.getChapterNumber() == 2) {

                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
//                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                        mainClass.setClearedChapter2(true);
                        mainClass.prefs.putBoolean("clearedChapter2", mainClass.getClearedChapter2());
                        mainClass.setChapterNumber(chapterNumber + 1);
//                     mainClass.prefs.putInteger("ChapterNumber",chapterNumber+1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }


                } else if (mainClass.getChapterNumber() == 3) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
//                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                        mainClass.setClearedChapter3(true);
                        mainClass.prefs.putBoolean("clearedChapter3", mainClass.getClearedChapter3());
                        mainClass.setChapterNumber(chapterNumber + 1);
//                     mainClass.prefs.putInteger("ChapterNumber",chapterNumber+1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }


                } else if (mainClass.getChapterNumber() == 4) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
//                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                        mainClass.setClearedChapter4(true);
                        mainClass.prefs.putBoolean("clearedChapter4", mainClass.getClearedChapter4());
                        mainClass.setChapterNumber(chapterNumber + 1);
//                     mainClass.prefs.putInteger("ChapterNumber",chapterNumber+1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }


                } else if (mainClass.getChapterNumber() == 5) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
//                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                        mainClass.setClearedChapter5(true);
                        mainClass.prefs.putBoolean("clearedChapter5", mainClass.getClearedChapter5());
                        mainClass.setChapterNumber(chapterNumber + 1);
//                     mainClass.prefs.putInteger("ChapterNumber",chapterNumber+1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                }

                //COMPUTER TESTING ADD 250 STEPS
                if (!enoughSteps) {
                    mainClass.setSteps(25000);
                }


            } else if (getUseForTheButton() == 7) {
//                mainClass.stopBackGroundMusic();
                mainClass.setChapterNumber(chapterNumber - 1);
                mainClass.setSwapped(false);
            } else if (getUseForTheButton() == 8) {

                mainClass.getStage().clear();
                //START THE GAME FROM MAIN MENU
                MainMenu mainMenu = new MainMenu(mainClass);
                mainClass.setSwapped(false);
                mainClass.setScreen(mainMenu);
//                mainClass.stopBackGroundMusic();
            } else if (getUseForTheButton() == 1) {
                if (mainClass.prefs.getBoolean("openedFirstTime")) {
                    mainClass.prefs.putBoolean("openedFirstTime", true);
                    mainClass.prefs.flush();
                    System.out.println("OPENEEDFIRSTTIME");
                    mainClass.prefs.flush();
                }
                mainClass.setPlayPressed(true);
                System.out.println(mainClass.getPlayPressed());
                GameScreen gameScreen = new GameScreen(mainClass);
//                mainClass.stopBackGroundMusic();
                mainClass.setScreen(gameScreen);
               // System.out.println(mainClass.getCurrentFurthestChapter() + " CurFurth");

            } else if (getUseForTheButton() == 2) {
//                mainClass.stopBackGroundMusic();
                ChapterSelect chapterSelect = new ChapterSelect(mainClass);
                mainClass.setScreen(chapterSelect);
//                mainClass.stopBackGroundMusic();
            } else if (getUseForTheButton() == 3) {
//                mainClass.stopBackGroundMusic();
                Credits credits = new Credits(mainClass);
                mainClass.setScreen(credits);
//                mainClass.stopBackGroundMusic();
            } else if (getUseForTheButton() == 4) {
//                mainClass.stopBackGroundMusic();
                //EI SULJE TAUSTAPROSESSISTA VISSIIN --- SELVITÄ
                Gdx.app.exit();
            } else if (getUseForTheButton() == 9) {
                if(touchUpX == 0) {
                System.out.println("9 pressed");
//               mainClass.setPlayPressed(false);
                    chapterSelect = Integer.parseInt(getTextForAButton());
//               System.out.println(chapterSelect + "c: " + mainClass.getClearedChapter1());
//               System.out.println(chapterSelect + "c2: " + mainClass.getCurrentFurthestChapter());
                    if (mainClass.getClearedChapter1() && chapterSelect == 1 ||
                            mainClass.getClearedChapter2() && chapterSelect == 2 ||
                            mainClass.getClearedChapter3() && chapterSelect == 3 ||
                            mainClass.getClearedChapter4() && chapterSelect == 4 ||
                            mainClass.getClearedChapter5() && chapterSelect == 5 ||
                            mainClass.getCurrentFurthestChapter() == chapterSelect) {

                        mainClass.setChapterNumber(chapterSelect);
//                   System.out.println(chapterSelect);
                        mainClass.prefs.putInteger("ChapterNumber", chapterSelect);
                        mainClass.setPlayPressed(false);
                        System.out.println(chapterSelect);
                        GameScreen gameScreen = new GameScreen(mainClass);
                        mainClass.setScreen(gameScreen);
                        mainClass.prefs.flush();
                    } else {

                    }
                }

            } else if (getUseForTheButton() == 10) {
                if (getStoryID() == 1.1f) {
                    setTextForAButton(mainClass.getChapter1_2Text());
                    setStoryID(1.2f);
                    System.out.println(getStoryID());
                } else if (getStoryID() == 1.2f) {
                    setTextForAButton(mainClass.getChapter1_3Text());
                    setStoryID(1.3f);
                } else if (getStoryID() == 1.3f) {
                    setTextForAButton(mainClass.getChapter1_1Text());
                    setStoryID(1.1f);
                }else if (getStoryID() == 2.1f) {
                    setTextForAButton(mainClass.getChapter2_2Text());
                    setStoryID(2.2f);
                } else if (getStoryID() == 2.2f) {
                    setTextForAButton(mainClass.getChapter2_1Text());
                    setStoryID(2.1f);
                } else if (getStoryID() == 3.1f) {
                    setTextForAButton(mainClass.getChapter3_2Text());
                    setStoryID(3.2f);
                } else if (getStoryID() == 3.2f) {
                    setTextForAButton(mainClass.getChapter3_1Text());
                    setStoryID(3.1f);
                } else if (getStoryID() == 4.1f) {
                    setTextForAButton(mainClass.getChapter4_2Text());
                    setStoryID(4.2f);
                } else if (getStoryID() == 4.2f) {
                    setTextForAButton(mainClass.getChapter4_1Text());
                    setStoryID(4.1f);
                } else if (getStoryID() == 5.1f) {
                    setTextForAButton(mainClass.getChapter5_2Text());
                    setStoryID(5.2f);
                } else if (getStoryID() == 5.2f) {
                    setTextForAButton(mainClass.getChapter5_1Text());
                    setStoryID(5.1f);
                }
            } else if (getUseForTheButton() == 11) {

                if (mainClass.getLanguageFinnish()) {
                    mainClass.setLanguageFinnish(false);
                    mainClass.prefs.putBoolean("languageFinnish", false);
                    mainClass.prefs.flush();
                    System.out.println("I AM SWAPPING THE LANGUAGE TO ENGLISH");
                    setTexture(new Texture(Gdx.files.internal("eng_button.png")));
                    mainClass.setLocale(new Locale("en", "EN"));
                    mainClass.setLocalLanguageToString("en_EN");
                    mainClass.setLocaleTexts();
                    System.out.println("local language: " + mainClass.getlocalLanguageToString());
                } else {
                    mainClass.setLanguageFinnish(true);
                    mainClass.prefs.putBoolean("languageFinnish", true);
                    mainClass.prefs.flush();
                    System.out.println("I AM SWAPPING THE LANGUAGE TO FINNISH");
                    setTexture(new Texture(Gdx.files.internal("fin_button.png")));
                    mainClass.setLocale(new Locale("fi", "Fi"));
                    mainClass.setLocalLanguageToString("fi_FI");
                    mainClass.setLocaleTexts();
                    System.out.println("local language: " + mainClass.getlocalLanguageToString());
                }
            } else if (getUseForTheButton() == 13) {
                if (mainClass.getbackGroundMusicOffOrOn()) {
                    mainClass.setbackGroundMusicOffOrOn(false);
                    mainClass.prefs.putBoolean("backGroundMusicOn", false);
                    mainClass.prefs.flush();
                    mainClass.playBackgroundMusic();
                    setTexture(new Texture(Gdx.files.internal("sound_on_button.png")));
                    System.out.println("I AM SWAPPING THE MUSIC OFF");
                    System.out.println("Music is currently: " + mainClass.getbackGroundMusicOffOrOn());
                } else {
                    mainClass.setbackGroundMusicOffOrOn(true);
                    mainClass.prefs.putBoolean("backGroundMusicOn", true);
                    mainClass.prefs.flush();
                    mainClass.stopBackGroundMusic();
                    setTexture(new Texture(Gdx.files.internal("sound_off_button.png")));
                    System.out.println("I AM SWAPPING THE MUSIC ON");
                    System.out.println("Music is currently: " + mainClass.getbackGroundMusicOffOrOn());
                }
            }
        }

        @Override

        public void pan(InputEvent event, float x, float y, float deltaX, float deltaY) {

            touchUpX = deltaX;
            System.out.println(touchUpX + " TouchUPX   <");
            if(getUseForTheButton() == 12 || useForTheButton == 9) {
                if(getGroup().getX()<=0 && getGroup().getX()>= scrollerWidth) {
                    getGroup().setX(getGroup().getX()+deltaX);
                }else if (getGroup().getX() > 0){
                    getGroup().setX(-getGroup().getX());
                } else if(getGroup().getX()<scrollerWidth){
                    getGroup().setX(scrollerWidth);
                }

                setGroup(mainClass.getGroup());
                getGroup().setPosition(getGroup().getX(), 20f);

               // System.out.println("xPlace: " + getGroup().getX());
            }
        }


    }

    class PlayerListener extends InputListener {
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.setProjectionMatrix(mainClass.camera.combined);
//       System.out.println("GOT HERE");
        steps = mainClass.getCurrentSteps();
        batch.draw(texture,
                xPlace, yPlace,
                this.getOriginX(),
                this.getOriginY(),
                buttonWidth,
                buttonHeight,
                this.getScaleX(),
                this.getScaleY(),
                this.getRotation(),0,0,
                texture.getWidth(), texture.getHeight(), false, false);
        if(useForTheButton == 9) {
            font12.draw(batch,"", buttonTextXPlace, buttonTextYPlace);

        }else if(useForTheButton != 10) {
            font12.draw(batch,textForAButton, buttonTextXPlace, buttonTextYPlace);

        }else {
            font12.draw(batch,textForAButton, 40f, yPlace+buttonHeight-20f);
        }

    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

