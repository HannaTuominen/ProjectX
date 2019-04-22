package fi.tamk.oddyssea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
/**
 * The chapterassets actor that has the text box texture that's not empty and text indicators and the backgroound images depending on chapter
 * @author Hanna Tuominen hanna.h.tuominen@tuni.fi
 * @version 24.4.2019
 * @since 15.01.2019
 */
public class ChapterAssets extends Actor {
    /**
     * the background image texture
     */
    private Texture texture;
    /**
     * the textbox image texture
     */
    private Texture textbox;
    /**
     * main class
     */
    private MainClass mainClass;
    /**
     * font
     */
    private BitmapFont font12;
    /**
     * screen width depending on the device
     */
    private float screenWidth;
    /**
     * screen height depending on the device
     */
    private float screenHeight;
    /**
     * textbox height
     */
    private float textboxHeight;
    /**
     * stepbox height
     */
    private float stepboxHeight;
    /**
     * current steps
     */
    private int steps;
    /**
     * how many pages is in use for the current chapter
     */
    private int howManyPageSwaps;

    /**
     * the actor created in chapter assets (images mostly) that don't need changing during the chapters at all
     * <p>
     *     first set locally all needed things from main class
     *     set width and height and bounds of the actor
     *     textbox texture
     *     depending on screen width textbox and stepbox heights
     * @param MainClass2 main class
     * @param texture the background texture
     * @param howManyPageSwaps how many page swaps are there needed
     */
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
        textbox = new Texture("textbox_90.png");
        if(screenHeight < 800) {
            textboxHeight = screenHeight/3.3f;
            stepboxHeight = screenHeight/7.3f;

        } else if (screenHeight >= 1000) {
            textboxHeight = screenHeight/3.6f;
            stepboxHeight = screenHeight/7.6f;
        }

    }

    /**
     * draw all needed textures to the stage
     * <p>
     *     howmanypages changes the textindicators number and size and place drawn initially
     *     also draw the textbox with the actual texture if the chapternumber is not 24
     * @param batch
     * @param alpha
     */
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

        if(mainClass.getChapterNumber() != 24) {
            batch.draw(textbox,10f,0f,screenWidth-20f, textboxHeight);
        }

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

    /**
     * act the scene
     * @param delta
     */
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
