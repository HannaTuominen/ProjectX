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

    BitmapFont font12;
    float screenWidth;
    float screenHeight;

    float textboxHeight;
    int steps;

    int howManyPageSwaps;

    public ChapterAssets(MainClass MainClass2, Texture texture, int howManyPageSwaps) {
        this.mainClass = MainClass2;
        this.texture = texture;
        this.howManyPageSwaps = howManyPageSwaps;
        this.screenHeight = mainClass.getScreenHeight();
        this.screenWidth = mainClass.getScreenWidth();

        this.mainClass = MainClass2;
        font12 = mainClass.getFont12();

        setWidth(mainClass.screenWidth);
        setHeight(mainClass.screenHeight);
        setBounds(0,0,getWidth(),getHeight());
        textbox = new Texture("textbox_2.png");
        if(screenHeight < 800) {
            textboxHeight = screenHeight/3.3f;
        } else if (screenHeight >= 1000) {
            textboxHeight = screenHeight/3.6f;
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

        batch.draw(textbox,10f,0f,screenWidth-20f, textboxHeight);

        if(howManyPageSwaps == 3) {
            batch.draw(mainClass.getTextIndicator_3_1(),screenWidth/6,screenHeight/40,screenWidth/4/1.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_3_2(),screenWidth/6+screenWidth/4/1.5f+20,screenHeight/40,screenWidth/4/1.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_3_3(),screenWidth/6+screenWidth/4/1.5f*2+40,screenHeight/40,screenWidth/4/1.5f, screenHeight/40);
        }



    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
