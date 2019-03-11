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

        setWidth(mainClass.screenWidth);
        setHeight(mainClass.screenHeight);
        setBounds(0,0,getWidth(),getHeight());

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
        font12.draw(batch,story, 0, 200f);

    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
