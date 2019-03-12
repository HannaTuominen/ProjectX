package fi.tamk.tiko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import java.util.ArrayList;
import java.util.List;

public class BackGroundAssets extends Actor {
    private static Texture texture;
    MainClass mainClass;
    float whichOnePicked;
	static int id;
	static boolean choice;
	static int affect_id;
	static int affect_steps;
	static String story;
	static int numberOfPages;
	static String choiceBox1;
	static String choiceBox2;
	static int stepCount;

    /*private String backgroundpicker = "";
    private String backgroundBase = "background_";
    private String backgroundEnd = ".png";*/

    public BackGroundAssets(MainClass MainClass2, String whichOne) {
        this.mainClass = MainClass2;
        /*List<Character> backgrounds = new ArrayList<Character>();


        for(int i = 0; i< backgroundBase.length(); i++) {
            backgrounds.add(backgroundBase.charAt(i));
        }
        for(int i = 0; i< whichOne.length(); i++) {
            backgrounds.add(whichOne.charAt(i));
        }
        for(int i = 0; i< backgroundEnd.length(); i++) {
            backgrounds.add(backgroundEnd.charAt(i));
        }
        for(int i = 0; i< 18; i++) {
            backgroundpicker +=  backgrounds.get(i);
        }
        System.out.println(backgroundpicker);


            texture = new Texture(Gdx.files.internal(backgroundpicker));
            setWidth(mainClass.screenWidth);
            setHeight(mainClass.screenHeight);
            setBounds(0,0,getWidth(),getHeight());*/


        addListener(new PlayerListener());
    }

    class PlayerListener extends InputListener {
        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        // JOS TULLAAN TARVIIMAAN MYÖHEMMIN NIIN VALMIIKS
//
//                ParallelAction parallel = new ParallelAction ();
//                MoveToAction moveAction = new MoveToAction();
//                RotateToAction rotateAction = new RotateToAction();
//                ScaleToAction scaleAction = new ScaleToAction();
//                moveAction.setPosition(Gdx.graphics.getWidth() /2 / 100+0.5f, Gdx.graphics.getHeight()/2 /100+1);
//                moveAction.setDuration(1f);
//                rotateAction.setRotation(180);
//                rotateAction.setDuration(1f);
//                scaleAction.setScale(1f);
//                scaleAction.setDuration(1f);
//                parallel.addAction(moveAction);
//                parallel.addAction(rotateAction);
//                parallel.addAction(scaleAction);
//                RunnableAction runnableAction = new RunnableAction();
//                runnableAction.setRunnable(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("DONE"); // KUN MOLEMMAT ROCK JA ROCK LIIKKUNU NII KÄYTÄ 41:40
//                    }
//                });
//
//                SequenceAction sq = new SequenceAction();
//                sq.addAction(parallel);
//                sq.addAction(runnableAction);
//
//                addAction(sq);
//
//            }

            return true;
        }
    }

    @Override
    public void draw(Batch batch, float alpha) {
       batch.setProjectionMatrix(mainClass.camera.combined);
        batch.draw(texture,
                this.getX(), this.getY(),
                this.getOriginX(),
                this.getOriginY(),
                this.getWidth(),
                this.getHeight(),
                this.getScaleX(),
                this.getScaleY(),
                this.getRotation(),0,0,
                texture.getWidth(), texture.getHeight(), false, false);

    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
