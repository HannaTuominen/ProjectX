package fi.tamk.oddyssea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ChapterAssets extends Actor {
    private Texture texture;
    private Texture textbox;
    private Texture stepbox;


    MainClass mainClass;

    BitmapFont font12;
    float screenWidth;
    float screenHeight;

    float textboxHeight;
    float stepboxHeight;
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
        stepbox = new Texture ("askelbox.png");
        if(screenHeight < 800) {
            textboxHeight = screenHeight/3.3f;
            stepboxHeight = screenHeight/7.3f;

        } else if (screenHeight >= 1000) {
            textboxHeight = screenHeight/3.6f;
            stepboxHeight = screenHeight/7.6f;
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
        batch.draw(stepbox,screenWidth/3.2f,screenHeight-stepboxHeight,screenWidth/4, stepboxHeight);

        if(howManyPageSwaps == 2) {
            batch.draw(mainClass.getTextIndicator_2_1(),screenWidth/6,screenHeight/40,screenWidth/4/1, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_2_2(),screenWidth/6+screenWidth/4f+20,screenHeight/40,screenWidth/4/1, screenHeight/40);
        } else if(howManyPageSwaps == 3) {
            batch.draw(mainClass.getTextIndicator_3_1(),screenWidth/6,screenHeight/40,screenWidth/4/1.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_3_2(),screenWidth/6+screenWidth/4/1.5f+20,screenHeight/40,screenWidth/4/1.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_3_3(),screenWidth/6+screenWidth/4/1.5f*2+40,screenHeight/40,screenWidth/4/1.5f, screenHeight/40);
        } else if(howManyPageSwaps == 4) {
            batch.draw(mainClass.getTextIndicator_4_1(),screenWidth/6,screenHeight/40,screenWidth/4/2f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_4_2(),screenWidth/6+screenWidth/4/2f+20,screenHeight/40,screenWidth/4/2f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_4_3(),screenWidth/6+screenWidth/4/2f*2+40,screenHeight/40,screenWidth/4/2f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_4_4(),screenWidth/6+screenWidth/4/2f*3+60,screenHeight/40,screenWidth/4/2f, screenHeight/40);
        } else if(howManyPageSwaps == 5) {
            batch.draw(mainClass.getTextIndicator_5_1(),screenWidth/6,screenHeight/40,screenWidth/4/2.7f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_5_2(),screenWidth/6+screenWidth/4/2.7f+20,screenHeight/40,screenWidth/4/2.7f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_5_3(),screenWidth/6+screenWidth/4/2.7f*2+40,screenHeight/40,screenWidth/4/2.7f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_5_4(),screenWidth/6+screenWidth/4/2.7f*3+60,screenHeight/40,screenWidth/4/2.7f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_5_5(),screenWidth/6+screenWidth/4/2.7f*4+80,screenHeight/40,screenWidth/4/2.7f, screenHeight/40);
        } else if(howManyPageSwaps == 6) {
            batch.draw(mainClass.getTextIndicator_6_1(),screenWidth/6,screenHeight/40,screenWidth/4/3.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_6_2(),screenWidth/6+screenWidth/4/3f+20,screenHeight/40,screenWidth/4/3.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_6_3(),screenWidth/6+screenWidth/4/3f*2+40,screenHeight/40,screenWidth/4/3.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_6_4(),screenWidth/6+screenWidth/4/3f*3+60,screenHeight/40,screenWidth/4/3.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_6_5(),screenWidth/6+screenWidth/4/3f*4+80,screenHeight/40,screenWidth/4/3.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_6_6(),screenWidth/6+screenWidth/4/3f*5+100,screenHeight/40,screenWidth/4/3.5f, screenHeight/40);
        } else if(howManyPageSwaps == 7) {
            batch.draw(mainClass.getTextIndicator_7_1(),screenWidth/6,screenHeight/40,screenWidth/4/4f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_7_2(),screenWidth/6+screenWidth/4/4f+20,screenHeight/40,screenWidth/4/4.2f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_7_3(),screenWidth/6+screenWidth/4/4f*2+40,screenHeight/40,screenWidth/4/4.2f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_7_4(),screenWidth/6+screenWidth/4/4f*3+60,screenHeight/40,screenWidth/4/4.2f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_7_5(),screenWidth/6+screenWidth/4/4f*4+80,screenHeight/40,screenWidth/4/4.2f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_7_6(),screenWidth/6+screenWidth/4/4f*5+100,screenHeight/40,screenWidth/4/4.2f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_7_7(),screenWidth/6+screenWidth/4/4f*6+120,screenHeight/40,screenWidth/4/4.2f, screenHeight/40);
        } else if(howManyPageSwaps == 8) {
            batch.draw(mainClass.getTextIndicator_8_1(),screenWidth/6,screenHeight/40,screenWidth/4/4.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_8_2(),screenWidth/6+screenWidth/4/5f+20,screenHeight/40,screenWidth/4/4.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_8_3(),screenWidth/6+screenWidth/4/5f*2+40,screenHeight/40,screenWidth/4/4.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_8_4(),screenWidth/6+screenWidth/4/5f*3+60,screenHeight/40,screenWidth/4/4.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_8_5(),screenWidth/6+screenWidth/4/5f*4+80,screenHeight/40,screenWidth/4/4.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_8_6(),screenWidth/6+screenWidth/4/5f*5+100,screenHeight/40,screenWidth/4/4.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_8_7(),screenWidth/6+screenWidth/4/5f*6+120,screenHeight/40,screenWidth/4/4.5f, screenHeight/40);
            batch.draw(mainClass.getTextIndicator_8_8(),screenWidth/6+screenWidth/4/5f*7+140,screenHeight/40,screenWidth/4/4.5f, screenHeight/40);
        }



    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
