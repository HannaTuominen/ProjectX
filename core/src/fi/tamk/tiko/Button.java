package fi.tamk.tiko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

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




   public Button(MainClass mainclass, Texture texture, String textForAButton, int useForTheButton, float xPlace, float yPlace, float buttonWidth, float buttonHeight, int stepsToOpenNextChapter) {

        this.mainClass = mainclass;
        this.texture = texture;
        this.textForAButton = textForAButton;
        this.useForTheButton = useForTheButton;
        this.xPlace = xPlace;
        this.yPlace = yPlace;
        this.buttonHeight = buttonHeight;
        this.buttonWidth = buttonWidth;
        if(stepsToOpenNextChapter > 0) {
            this.stepsToOpenNextChapter = stepsToOpenNextChapter;
        }
        System.out.println("BUTTON HAS BEEN CREATED WITH " + this.stepsToOpenNextChapter + " STEPS TO OPEN THE NEXT CHAPTER");
       chapterNumber = mainclass.getChapterNumber();
//       System.out.println(chapterNumber+"H");
       font12 = mainClass.getFont12();
       addListener(new PlayerListener());
       setBounds(xPlace, yPlace, buttonWidth, buttonHeight);

//       System.out.println(xPlace + "y: " + yPlace);
   }

    class PlayerListener extends InputListener {

       @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
           if(useForTheButton == 1 || useForTheButton == 2 || useForTheButton == 3 || useForTheButton == 4 || useForTheButton == 8 ) {
               texture = new Texture(Gdx.files.internal("button_orange_pressed.png"));
           }
           if (useForTheButton == 7) {
               texture = new Texture(Gdx.files.internal("back_X_pressed.png"));
           }

           if(useForTheButton == 6 || useForTheButton == 5) {
               if(stepsToOpenNextChapter > steps) {
                System.out.println("NExt chapter button pressed but too little steps");
               } else {
                   texture = new Texture(Gdx.files.internal("button_orange_pressed.png"));
               }
           }


            // JOS TULLAAN TARVIIMAAN MYÖHEMMIN NIIN VALMIIKS

//            ParallelAction parallel = new ParallelAction();
//            MoveToAction moveAction = new MoveToAction();
//            RotateToAction rotateAction = new RotateToAction();
//            ScaleToAction scaleAction = new ScaleToAction();
//            moveAction.setPosition(Gdx.graphics.getWidth() / 2 / 100 + 0.5f, Gdx.graphics.getHeight() / 2 / 100 + 1);
//            moveAction.setDuration(1f);
//            rotateAction.setRotation(180);
//            rotateAction.setDuration(1f);
//            scaleAction.setScale(1f);
//            scaleAction.setDuration(1f);
//            parallel.addAction(moveAction);
//            parallel.addAction(rotateAction);
//            parallel.addAction(scaleAction);
//            RunnableAction runnableAction = new RunnableAction();
//            runnableAction.setRunnable(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("DONE"); // KUN MOLEMMAT ROCK JA ROCK LIIKKUNU NII KÄYTÄ 41:40
//                }
//            });
//
//            SequenceAction sq = new SequenceAction();
//            sq.addAction(parallel);
//            sq.addAction(runnableAction);
//
//            addAction(sq);

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
            5. Choice 1
            6. Choice 2
            7. Back to main menu
            8. ChapterSelect Buttons
            */

           if (useForTheButton == 5 || useForTheButton == 6) {
//               System.out.println("clearedChapter" + mainClass.getChapterNumber());
               mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
               if(mainClass.getChapterNumber() == 1) {

                   if(stepsToOpenNextChapter > steps) {
                       System.out.println("ERROR TOO FEW STEPS");
                   } else {
                       System.out.println("REMOVING STEPS");
                       System.out.println("STEPS TO OPEN NEXT CHAPTER " +stepsToOpenNextChapter);
                       mainClass.removeSteps(stepsToOpenNextChapter);
                       System.out.println(steps);
                       mainClass.setClearedChapter1(true);
                       mainClass.setCurrentFurthestChapter(chapterNumber+1);
                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                       enoughSteps = true;
                   }
               } else if (mainClass.getChapterNumber() == 2) {

                   if(stepsToOpenNextChapter > steps) {
                       System.out.println("ERROR TOO FEW STEPS");
                   } else {
                       System.out.println("REMOVING STEPS");
                       System.out.println("STEPS TO OPEN NEXT CHAPTER " +stepsToOpenNextChapter);
                       mainClass.removeSteps(stepsToOpenNextChapter);
                       enoughSteps = true;
                       mainClass.setCurrentFurthestChapter(chapterNumber+1);
                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                       mainClass.setClearedChapter2(true);
                   }

               } else if (mainClass.getChapterNumber() == 3) {
                   if(stepsToOpenNextChapter > steps) {
                       System.out.println("ERROR TOO FEW STEPS");
                   } else {
                       System.out.println("REMOVING STEPS");
                       System.out.println("STEPS TO OPEN NEXT CHAPTER " +stepsToOpenNextChapter);
                       mainClass.removeSteps(stepsToOpenNextChapter);
                       enoughSteps = true;
                       mainClass.setCurrentFurthestChapter(chapterNumber+1);
                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                       mainClass.setClearedChapter3(true);
                   }
               } else if (mainClass.getChapterNumber() == 4) {
                   if(stepsToOpenNextChapter > steps) {
                       System.out.println("ERROR TOO FEW STEPS");
                   } else {
                       System.out.println("REMOVING STEPS");
                       System.out.println("STEPS TO OPEN NEXT CHAPTER " +stepsToOpenNextChapter);
                       mainClass.removeSteps(stepsToOpenNextChapter);
                       enoughSteps = true;
                       mainClass.setCurrentFurthestChapter(chapterNumber+1);
                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                       mainClass.setClearedChapter4(true);
                   }

               } else if (mainClass.getChapterNumber() == 5) {
                   if(stepsToOpenNextChapter > steps) {
                       System.out.println("ERROR TOO FEW STEPS");
                   } else {
                       System.out.println("REMOVING STEPS");
                       System.out.println("STEPS TO OPEN NEXT CHAPTER " +stepsToOpenNextChapter);
                       mainClass.removeSteps(stepsToOpenNextChapter);
                       enoughSteps = true;
                       mainClass.setCurrentFurthestChapter(chapterNumber+1);
                       mainClass.prefs.putInteger("currentFurthestChapter", mainClass.getCurrentFurthestChapter());
                       mainClass.setClearedChapter5(true);
                   }

               }

               if(enoughSteps) {
                   mainClass.setChapterNumber(chapterNumber + 1);
                   mainClass.prefs.putInteger("ChapterNumber",chapterNumber+1);

                   mainClass.setSwapped(false);
//               System.out.println(mainClass.getChapterNumber());
                   enoughSteps = false;
               }


           } else if (useForTheButton == 7) {
               mainClass.getStage().clear();
               //START THE GAME FROM MAIN MENU
               MainMenu mainMenu = new MainMenu(mainClass);
               mainClass.setSwapped(false);
               mainClass.setScreen(mainMenu);
           } else if (useForTheButton == 1) {
               mainClass.setPlayPressed(true);
               System.out.println(mainClass.getPlayPressed());
               GameScreen gameScreen = new GameScreen(mainClass);
               mainClass.setScreen(gameScreen);
           } else if (useForTheButton == 2) {
               ChapterSelect chapterSelect = new ChapterSelect(mainClass);
               mainClass.setScreen(chapterSelect);
           } else if (useForTheButton == 3) {
               Credits credits = new Credits(mainClass);
               mainClass.setScreen(credits);
           } else if (useForTheButton == 4) {
               //EI SULJE TAUSTAPROSESSISTA VISSIIN --- SELVITÄ
               Gdx.app.exit();
           } else if (useForTheButton == 8) {
//               mainClass.setPlayPressed(false);
               chapterSelect = Integer.parseInt(textForAButton);
               System.out.println(chapterSelect + "c: " + mainClass.getClearedChapter1());
               if(mainClass.getClearedChapter1() && chapterSelect == 1 ||
                       mainClass.getClearedChapter2() && chapterSelect == 2 ||
                       mainClass.getClearedChapter3() && chapterSelect == 3 ||
                       mainClass.getClearedChapter4() && chapterSelect == 4 ||
                       mainClass.getClearedChapter5() && chapterSelect == 5 ||
                       mainClass.getCurrentFurthestChapter() == chapterSelect) {

                   mainClass.setChapterNumber(chapterSelect);
//                   System.out.println(chapterSelect);
                   mainClass.prefs.putInteger("ChapterNumber",chapterSelect);
                   mainClass.setPlayPressed(false);
                   System.out.println(chapterSelect);
                   GameScreen gameScreen = new GameScreen(mainClass);
                   mainClass.setScreen(gameScreen);
               } else{

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
        font12.draw(batch,textForAButton, xPlace+buttonWidth/3, yPlace+buttonHeight/1.7f);

    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

