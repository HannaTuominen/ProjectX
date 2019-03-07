package fi.tamk.tiko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;
import java.util.List;

public class ChapterAssets extends Actor {
    private Texture texture;
    MainClass mainClass;
//    float whichOnePicked;

	static int id; //Ei tarvii?
    String story;
     int numberOfPages = 1;


	boolean choice;
	int affect_id;
	int affect_steps;
	String choiceBox1;
    String choiceBox2;
	int stepCount;

    BitmapFont font12;

    /*private String backgroundpicker = "";
    private String backgroundBase = "background_";
    private String backgroundEnd = ".png";*/

    public ChapterAssets(MainClass MainClass2, Texture texture, boolean choice, int affect_id, int affect_steps, String choiceBox1, String choiceBox2, int stepCount, String story) {
        this.mainClass = MainClass2;
        this.texture = texture;
        this.choice = choice;
        this.affect_id = affect_id;
        this.affect_steps = affect_steps;
        this.choiceBox1 = choiceBox1;
        this.choiceBox2 = choiceBox2;
        this.stepCount = stepCount;

        this.mainClass = MainClass2;
        this.story = story;
        font12 = mainClass.getFont12();



//        mainClass.setFontSize(15);
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

            */
            setWidth(mainClass.screenWidth);
            setHeight(mainClass.screenHeight);
            setBounds(0,0,getWidth(),getHeight());


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
//    public void createButton1() {
//
//        final TextButton button = new TextButton("Play", mainClass.);
//        button.setWidth(200f);
//        button.setHeight(100f);
//        button.setPosition(screenWidth/2 - 100f, screenHeight/2 - 100f);
//        stage.addActor(button);
//        Gdx.input.setInputProcessor(stage);
//
//        button.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y){
//                chapterNumber++;
//                swapped = false;
//            }
//        });
//    }
    @Override
    public void draw(Batch batch, float alpha) {
       batch.setProjectionMatrix(mainClass.camera.combined);
//       System.out.println("GOT HERE");

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
        font12.draw(batch,story, 0, 100);

    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
