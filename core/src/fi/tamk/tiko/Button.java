package fi.tamk.tiko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

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


   public Button(MainClass mainclass, Texture texture, String textForAButton, float storyID, int useForTheButton, float xPlace, float yPlace, float buttonWidth, float buttonHeight, int stepsToOpenNextChapter) {

        this.mainClass = mainclass;
        this.texture = texture;
        this.textForAButton = textForAButton;
        this.useForTheButton = useForTheButton;
        this.xPlace = xPlace;
        this.yPlace = yPlace;
        this.buttonHeight = buttonHeight;
        this.buttonWidth = buttonWidth;
        this.storyID = storyID;


       //SETS THE X PLACE CORRECTLY TO CENTER DEPENDING ON THE TEXT SIZE FOR BUTTONS
        buttonTextXPlace = this.xPlace + buttonWidth/2 - mainClass.getTextPlaceWIDTH(textForAButton)/2;
        buttonTextYPlace = this.yPlace+buttonHeight/1.7f;


        if(stepsToOpenNextChapter > 0) {
            this.stepsToOpenNextChapter = stepsToOpenNextChapter;
        }
       chapterNumber = mainclass.getChapterNumber();
//       System.out.println(chapterNumber+"H");
       font12 = mainClass.getFont12();
       addListener(new PlayerListener());
       setBounds(xPlace, yPlace, buttonWidth, buttonHeight);

   }

    class PlayerListener extends InputListener {

       @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
           if(useForTheButton == 1 || useForTheButton == 2 || useForTheButton == 3 || useForTheButton == 4 || useForTheButton == 8 ) {
               texture = new Texture(Gdx.files.internal("button_orange_pressed.png"));
           }
           if (useForTheButton == 8) {
               texture = new Texture(Gdx.files.internal("back_X_pressed.png"));
           }

           if(useForTheButton == 6 || useForTheButton == 5 || useForTheButton == 7) {
               if(stepsToOpenNextChapter > steps) {
                System.out.println("NExt chapter button pressed but too little steps");
               } else {
                   texture = new Texture(Gdx.files.internal("button_orange_pressed.png"));
               }
           }

            return true;
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
            */

            if (useForTheButton == 6 || useForTheButton == 5) {

                if (mainClass.getChapterNumber() == 1) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        if (useForTheButton == 5) {
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
//                if (!enoughSteps) {
//                    mainClass.setSteps(25000);
//                }


            } else if (useForTheButton == 7) {
                mainClass.setChapterNumber(chapterNumber - 1);
                mainClass.setSwapped(false);
            } else if (useForTheButton == 8) {
                mainClass.getStage().clear();
                //START THE GAME FROM MAIN MENU
                MainMenu mainMenu = new MainMenu(mainClass);
                mainClass.setSwapped(false);
                mainClass.setScreen(mainMenu);
            } else if (useForTheButton == 1) {
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
                System.out.println(mainClass.getCurrentFurthestChapter() + " CurFurth");

            } else if (useForTheButton == 2) {
                ChapterSelect chapterSelect = new ChapterSelect(mainClass);
                mainClass.setScreen(chapterSelect);
            } else if (useForTheButton == 3) {
                Credits credits = new Credits(mainClass);
                mainClass.setScreen(credits);
            } else if (useForTheButton == 4) {
                //EI SULJE TAUSTAPROSESSISTA VISSIIN --- SELVITÄ
                Gdx.app.exit();
            } else if (useForTheButton == 9) {
//               mainClass.setPlayPressed(false);
                chapterSelect = Integer.parseInt(textForAButton);
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

            } else if (useForTheButton == 10) {
                if (storyID == 1.1f) {
                    textForAButton = mainClass.getChapter1_1Text();
                    storyID = 1.2f;
                } else if (storyID == 1.2f) {
                    textForAButton = mainClass.getChapter1_2Text();
                    storyID = 1.3f;
                } else if (storyID == 1.3f) {
                    textForAButton = mainClass.getChapter1_3Text();
                    storyID = 1.1f;
                }else if (storyID == 2.1f) {
                    textForAButton = mainClass.getChapter2_2Text();
                    storyID = 2.2f;
                } else if (storyID == 2.2f) {
                    textForAButton = mainClass.getChapter2_1Text();
                    storyID = 2.1f;
                } else if (storyID == 3.1f) {
                    textForAButton = mainClass.getChapter3_2Text();
                    storyID = 3.2f;
                } else if (storyID == 3.2f) {
                    textForAButton = mainClass.getChapter3_1Text();
                    storyID = 3.1f;
                } else if (storyID == 4.1f) {
                    textForAButton = mainClass.getChapter4_2Text();
                    storyID = 4.2f;
                } else if (storyID == 4.2f) {
                    textForAButton = mainClass.getChapter4_1Text();
                    storyID = 4.1f;
                } else if (storyID == 5.1f) {
                    textForAButton = mainClass.getChapter5_2Text();
                    storyID = 5.2f;
                } else if (storyID == 5.2f) {
                    textForAButton = mainClass.getChapter5_1Text();
                    storyID = 5.1f;
                }
            } else if (useForTheButton == 11) {

                if (mainClass.getLanguageFinnish()) {
                    mainClass.setLanguageFinnish(false);
                    mainClass.prefs.putBoolean("languageFinnish", false);
                    mainClass.prefs.flush();
                    System.out.println("I AM SWAPPING THE LANGUAGE TO ENGLISH");
                    texture = new Texture(Gdx.files.internal("eng_button.png"));
                    mainClass.setLocale(new Locale("en", "EN"));
                    mainClass.setLocalLanguageToString("en_EN");
                    mainClass.setLocaleTexts();
                    System.out.println("local language: " + mainClass.getlocalLanguageToString());
                } else {
                    mainClass.setLanguageFinnish(true);
                    mainClass.prefs.putBoolean("languageFinnish", true);
                    mainClass.prefs.flush();
                    System.out.println("I AM SWAPPING THE LANGUAGE TO FINNISH");
                    texture = new Texture(Gdx.files.internal("fin_button.png"));
                    mainClass.setLocale(new Locale("fi", "Fi"));
                    mainClass.setLocalLanguageToString("fi_FI");
                    mainClass.setLocaleTexts();
                    System.out.println("local language: " + mainClass.getlocalLanguageToString());
                }
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

