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
    Group group2;
    static float scrollerWidth;
    boolean pan = false;

    float touchDownX;
    float touchDownY;
    float touchUpX;
    float touchUpY;

    String currentStepsText;


    float stepsNeededAndCurrentlyHavePlace;
    int stepsLength;
    int howManyNumbersInStepsToOpenNextChapter;
    boolean swappedIndicator = true;

    public void indicatorsX3_stage_1() {
        mainClass.setTextIndicator_3_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_3_2(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_3_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX3_stage_2() {
        mainClass.setTextIndicator_3_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_3_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_3_3(new Texture(Gdx.files.internal("text_now_3.png")));
    }
    public void indicatorsX3_stage_3() {
        mainClass.setTextIndicator_3_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_3_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_3_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }

    public void setHowManyNumbersInStepsToOpenNextChapters(int steps) {
        if(steps == 0) {
            howManyNumbersInStepsToOpenNextChapter = 1;
        } else if(steps>= 10 && steps <100) {
            howManyNumbersInStepsToOpenNextChapter = 2;
        } else if (steps >=100 && steps <1000) {
            howManyNumbersInStepsToOpenNextChapter = 3;
        } else if (steps >=1000 && steps <10000) {
            howManyNumbersInStepsToOpenNextChapter = 4;
        } else if (steps >=10000 && steps <100000) {
            howManyNumbersInStepsToOpenNextChapter = 5;
        }
    }
    public int getHowManyNumbersInStepsToOpenChapters() {
        return howManyNumbersInStepsToOpenNextChapter;
    }

    public void setUpChapterTextBottomScreen(int steps) {
        setHowManyNumbersInStepsToOpenNextChapters(steps);
        gameScreenTextStuff();
    }

    public void gameScreenTextStuff() {
        int steps = mainClass.getCurrentSteps();

        stepsLength = String.valueOf(steps).length()+getHowManyNumbersInStepsToOpenChapters();
//            System.out.println(stepsLength);

        if(stepsLength <= 2) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/4f);
//            System.out.println(stepsNeededAndCurrentlyHavePlace);
        } else if(stepsLength ==3) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/3.5f);
//            System.out.println(stepsNeededAndCurrentlyHavePlace);
        }else if(stepsLength ==4) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/2.5f);
        } else if(stepsLength ==5) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/2.2f);
        } else if(stepsLength ==6) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.9f);
        } else if(stepsLength ==7) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.6f);
        } else if(stepsLength ==8) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.5f);
        } else if(stepsLength ==9) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.4f);
        } else if(stepsLength ==10) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.23f);
        } else if(stepsLength ==11) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.05f);
        } else if(stepsLength ==12) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/0.9f);
        }
    }

    public void setStepsNeededAndCurrentlyHavePlace(float stepsNeededAndCurrentlyHavePlace) {
        this.stepsNeededAndCurrentlyHavePlace = stepsNeededAndCurrentlyHavePlace;

    }
    public float getStepsNeededAndCurrentlyHavePlace() {return stepsNeededAndCurrentlyHavePlace;}


    public void setGroup1(Group group) {
       this.group = group;
    }
    public Group getGroup1() {
        return group;
    }

    public void setGroup2(Group group) {
        this.group2 = group;
    }
    public Group getGroup2() {
        return group2;
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

//        System.out.println(storyID);
        setStoryID(storyID);
        setTexture(texture);
        setUseForTheButton(useForTheButton);
        setGroup1(mainclass.getGroup1());
        setGroup2(mainclass.getGroup2());
        //this.useForTheButton = useForTheButton;
        this.xPlace = xPlace;
        this.yPlace = yPlace;
        this.buttonHeight = buttonHeight;
        this.buttonWidth = buttonWidth;
       currentStepsText = mainClass.getStepsString();

        if(useForTheButton == 12) {
            scrollerWidth = -mainclass.getScreenWidth()/4*22+(mainclass.getScreenWidth()/0.99f);
        }

        //this.storyID = storyID;

       if(useForTheButton == 14 || useForTheButton == 15) {
           buttonTextXPlace = this.xPlace;
           buttonTextYPlace = this.yPlace;
       } else {
           //SETS THE X PLACE CORRECTLY TO CENTER DEPENDING ON THE TEXT SIZE FOR BUTTONS
           buttonTextXPlace = this.xPlace + buttonWidth/2 - mainClass.getTextPlaceWIDTH(textForAButton)/2;
           buttonTextYPlace = this.yPlace+buttonHeight/1.7f;
       }


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
            touchUpX =0;
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
            14. Chapter number text in the game left corner
            15. Current and needed steps for at the current time
            16,17,18. text_now and text_hidden for the 3x textbox indicators
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
                        enoughSteps = true;
                        mainClass.setChapterNumber(chapterNumber + 1);

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
                        mainClass.setClearedChapter2(true);
                        mainClass.prefs.putBoolean("clearedChapter2", mainClass.getClearedChapter2());
                        mainClass.setChapterNumber(chapterNumber + 1);
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
                        mainClass.setClearedChapter3(true);
                        mainClass.prefs.putBoolean("clearedChapter3", mainClass.getClearedChapter3());
                        mainClass.setChapterNumber(chapterNumber + 1);
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
                        mainClass.setClearedChapter4(true);
                        mainClass.prefs.putBoolean("clearedChapter4", mainClass.getClearedChapter4());
                        mainClass.setChapterNumber(chapterNumber + 1);
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
                        mainClass.setClearedChapter5(true);
                        mainClass.prefs.putBoolean("clearedChapter5", mainClass.getClearedChapter5());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                }

                //COMPUTER TESTING ADD 250 STEPS
                if (!enoughSteps) {
                    mainClass.setSteps(880000);
                }


            } else if (getUseForTheButton() == 7) {
                mainClass.setChapterNumber(chapterNumber - 1);
                mainClass.setSwapped(false);
            } else if (getUseForTheButton() == 8) {

                mainClass.getStage().clear();
                //START THE GAME FROM MAIN MENU
                MainMenu mainMenu = new MainMenu(mainClass);
                mainClass.setSwapped(false);
                mainClass.setScreen(mainMenu);
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
                mainClass.setScreen(gameScreen);

            } else if (getUseForTheButton() == 2) {
                ChapterSelect chapterSelect = new ChapterSelect(mainClass);
                mainClass.setScreen(chapterSelect);
            } else if (getUseForTheButton() == 3) {
//                mainClass.stopBackGroundMusic();
                Credits credits = new Credits(mainClass);
                mainClass.setScreen(credits);
            } else if (getUseForTheButton() == 4) {
                //EI SULJE TAUSTAPROSESSISTA VISSIIN --- SELVITÄ
                Gdx.app.exit();
            } else if (getUseForTheButton() == 9) {
                if(touchUpX == 0) {
                System.out.println("9 pressed");
                    chapterSelect = Integer.parseInt(getTextForAButton());
                    if (mainClass.getClearedChapter1() && chapterSelect == 1 ||
                            mainClass.getClearedChapter2() && chapterSelect == 2 ||
                            mainClass.getClearedChapter3() && chapterSelect == 3 ||
                            mainClass.getClearedChapter4() && chapterSelect == 4 ||
                            mainClass.getClearedChapter5() && chapterSelect == 5 ||
                            mainClass.getCurrentFurthestChapter() == chapterSelect) {

                        mainClass.setChapterNumber(chapterSelect);
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
//                swapTextIndicators();
                swappedIndicator = false;
                System.out.println("HERE " + getStoryID());
                if (getStoryID() == 1.1f) {
                    setTextForAButton(mainClass.getChapter1_2Text());
                    setStoryID(1.2f);
                    System.out.println(getStoryID());
                    indicatorsX3_stage_1();

                } else if (getStoryID() == 1.2f) {
                    setTextForAButton(mainClass.getChapter1_3Text());
                    setStoryID(1.3f);
                   indicatorsX3_stage_2();
                } else if (getStoryID() == 1.3f) {
                    setTextForAButton(mainClass.getChapter1_1Text());
                    setStoryID(1.1f);
                    indicatorsX3_stage_3();
                }else if (getStoryID() == 2.1f) {
                    setTextForAButton(mainClass.getChapter2_2Text());
                    setStoryID(2.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 2.2f) {
                    setTextForAButton(mainClass.getChapter2_1Text());
                    setStoryID(2.1f);
                    indicatorsX3_stage_2();
                } else if (getStoryID() == 3.1f) {
                    setTextForAButton(mainClass.getChapter3_2Text());
                    setStoryID(3.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 3.2f) {
                    setTextForAButton(mainClass.getChapter3_1Text());
                    setStoryID(3.1f);
                    indicatorsX3_stage_2();
                } else if (getStoryID() == 4.1f) {
                    setTextForAButton(mainClass.getChapter4_2Text());
                    setStoryID(4.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 4.2f) {
                    setTextForAButton(mainClass.getChapter4_1Text());
                    setStoryID(4.1f);
                    indicatorsX3_stage_2();
                } else if (getStoryID() == 5.1f) {
                    setTextForAButton(mainClass.getChapter5_2Text());
                    setStoryID(5.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 5.2f) {
                    setTextForAButton(mainClass.getChapter5_1Text());
                    setStoryID(5.1f);
                    indicatorsX3_stage_2();
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
            } else if (getUseForTheButton() == 16 || getUseForTheButton() == 17 || getUseForTheButton() == 18) {
                setTexture(new Texture(Gdx.files.internal("text_hidden_3.png")));
            }
        }

        @Override

        public void pan(InputEvent event, float x, float y, float deltaX, float deltaY) {

            touchUpX = deltaX;
//            System.out.println(touchUpX + " TouchUPX   <");
            if(getUseForTheButton() == 12 || useForTheButton == 9) {
                if(getGroup1().getX()<=0 && getGroup1().getX()>= scrollerWidth) {
                    getGroup1().setX(getGroup1().getX()+deltaX);
                }else if (getGroup1().getX() > 0){
                    getGroup1().setX(-getGroup1().getX());
                } else if(getGroup1().getX()<scrollerWidth){
                    getGroup1().setX(scrollerWidth);
                }

                setGroup1(mainClass.getGroup1());
                getGroup1().setPosition(getGroup1().getX(), 20f);
            }
        }
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

        } else if (useForTheButton == 15) {
//            System.out.println(stepsToOpenNextChapter);
            setUpChapterTextBottomScreen(stepsToOpenNextChapter);
            textForAButton = String.valueOf(steps) + "/" + stepsToOpenNextChapter;
            font12.draw(batch,textForAButton, getStepsNeededAndCurrentlyHavePlace(), buttonTextYPlace);
        } else if(useForTheButton != 10) {
            font12.draw(batch,textForAButton, buttonTextXPlace, buttonTextYPlace);

        }
        //STORY BOX TEXT
        else {

            font12.draw(batch,textForAButton, 40f, yPlace+buttonHeight+50);
        }


    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

