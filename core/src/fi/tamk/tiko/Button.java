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
    float chapterNumber;
    int useForTheButton;
    float xPlace;
    float yPlace;



   public Button(MainClass mainclass, Texture texture, String textForAButton, int useForTheButton, float xPlace, float yPlace) {

        this.mainClass = mainclass;
        this.texture = texture;
        this.textForAButton = textForAButton;
        this.useForTheButton = useForTheButton;
        this.xPlace = xPlace;
        this.yPlace = yPlace;
       chapterNumber = mainclass.getChapterNumber();
//       System.out.println(chapterNumber+"H");
       font12 = mainClass.getFont12();
       addListener(new PlayerListener());
//       System.out.println("BUTOTTOTTOTOTO");
       setBounds(xPlace, yPlace, mainClass.getScreenWidth()/5, mainClass.getScreenHeight()/12);
//       System.out.println(xPlace + "y: " + yPlace);
   }

    class PlayerListener extends InputListener {

       @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            texture = new Texture(Gdx.files.internal("placeholderbuttonpressed.jpg"));
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
            */
           if (useForTheButton == 5 || useForTheButton == 6) {
//               System.out.println("HEREEEEEE");
               mainClass.setChapterNumber(chapterNumber + 1);
               mainClass.setSwapped(false);
               System.out.println(mainClass.getChapterNumber());
           } else if (useForTheButton == 7) {
               mainClass.getStage().clear();
               //START THE GAME FROM MAIN MENU
               MainMenu mainMenu = new MainMenu(mainClass);
               mainClass.setSwapped(false);
               mainClass.setScreen(mainMenu);
           } else if (useForTheButton == 1) {
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
           }

        }
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.setProjectionMatrix(mainClass.camera.combined);
//       System.out.println("GOT HERE");

        batch.draw(texture,
                xPlace, yPlace,
                this.getOriginX(),
                this.getOriginY(),
                mainClass.getScreenWidth()/5,
                mainClass.getScreenHeight()/12,
                this.getScaleX(),
                this.getScaleY(),
                this.getRotation(),0,0,
                texture.getWidth(), texture.getHeight(), false, false);
        font12.draw(batch,textForAButton, xPlace+10, yPlace+35);

    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

