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



   public Button(MainClass mainclass, Texture texture, String textForAButton) {
        this.mainClass = mainclass;
        this.texture = texture;
        this.textForAButton = textForAButton;
       chapterNumber = mainclass.getChapterNumber();
       System.out.println(chapterNumber+"H");
       font12 = mainClass.getFont12();
       addListener(new PlayerListener());
       System.out.println("BUTOTTOTTOTOTO");
       setBounds(65f, 185f, 200, 100);
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
            System.out.println("HEREEEEEE");
            mainClass.setChapterNumber(chapterNumber + 1);
            mainClass.setSwapped(false);
            System.out.println(mainClass.getChapterNumber());
        }
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.setProjectionMatrix(mainClass.camera.combined);
//       System.out.println("GOT HERE");

        batch.draw(texture,
                65f, 185f,
                this.getOriginX(),
                this.getOriginY(),
                200,
                100,
                this.getScaleX(),
                this.getScaleY(),
                this.getRotation(),0,0,
                texture.getWidth(), texture.getHeight(), false, false);
        font12.draw(batch,textForAButton, 100, 250);

    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

