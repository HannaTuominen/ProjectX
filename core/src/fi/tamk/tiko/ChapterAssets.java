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
    private Texture textbox;
    MainClass mainClass;

	boolean choice;
	int affect_id;
	int affect_steps;

	int stepCount;

    BitmapFont font12;
    float screenWidth;
    float screenHeight;

    float textboxHeight;
    int steps;
    String currentStepsText;

    public void changeBackgroundImageDependingOnChoises(Texture texture) {
        this.texture = texture;
    }

    public ChapterAssets(MainClass MainClass2, Texture texture, boolean choice, int affect_id, int affect_steps, int stepCount) {
        this.mainClass = MainClass2;
        this.texture = texture;
        this.choice = choice;
        this.affect_id = affect_id;
        this.affect_steps = affect_steps;
        this.stepCount = stepCount;
        this.screenHeight = mainClass.getScreenHeight();
        this.screenWidth = mainClass.getScreenWidth();
        currentStepsText = mainClass.getStepsString();

        this.mainClass = MainClass2;
        font12 = mainClass.getFont12();

        setWidth(mainClass.screenWidth);
        setHeight(mainClass.screenHeight);
        setBounds(0,0,getWidth(),getHeight());
        textbox = new Texture("textbox_1.png");
        if(screenHeight < 800) {
            textboxHeight = screenHeight/3.3f;
        } else if (screenHeight >= 1000) {
            textboxHeight = screenHeight/5f;
        }


    }

    @Override
    public void draw(Batch batch, float alpha) {
        steps = mainClass.getCurrentSteps();
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

        batch.draw(textbox,10f,10f,screenWidth-20f, textboxHeight);
        font12.draw(batch,currentStepsText +" " +String.valueOf(steps), screenWidth/2-50f,screenHeight-20f);


    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
