package fi.tamk.oddyssea;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

import java.util.Locale;

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
    float storyID;
    float buttonTextXPlace;
    float buttonTextYPlace;
    Group group;
    Group group2;
    static float scrollerWidth;

    float touchUpX;

    float textboxHeight;

    String currentStepsText;



    float stepsNeededAndCurrentlyHavePlace;
    int stepsLength;
    int howManyNumbersInStepsToOpenNextChapter;
    float stepsXPlace;
    boolean swappedIndicator = true;

    public void indicatorsX2_stage_1() {
        mainClass.setTextIndicator_2_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_2_2(new Texture(Gdx.files.internal("text_now_3.png")));

    }
    public void indicatorsX2_stage_2() {
        mainClass.setTextIndicator_2_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_2_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }

    public void indicatorsX3_stage_1() {
        mainClass.setTextIndicator_3_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_3_2(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_3_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX3_stage_2() {
        mainClass.setTextIndicator_3_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_3_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_3_3(new Texture(Gdx.files.internal("text_now_3.png")));
    }
    public void indicatorsX3_stage_3() {
        mainClass.setTextIndicator_3_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_3_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_3_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }

    public void indicatorsX4_stage_1() {
        mainClass.setTextIndicator_4_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_2(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_4_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX4_stage_2() {
        mainClass.setTextIndicator_4_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_3(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_4_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX4_stage_3() {
        mainClass.setTextIndicator_4_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_4(new Texture(Gdx.files.internal("text_now_3.png")));
    }
    public void indicatorsX4_stage_4() {
        mainClass.setTextIndicator_4_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_4_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_4_4(new Texture(Gdx.files.internal("text_hidden_3.png")));

    }

    public void indicatorsX5_stage_1() {
        mainClass.setTextIndicator_5_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_2(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_5_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX5_stage_2() {
        mainClass.setTextIndicator_5_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_3(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_5_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX5_stage_3() {
        mainClass.setTextIndicator_5_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_4(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_5_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX5_stage_4() {
        mainClass.setTextIndicator_5_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_5(new Texture(Gdx.files.internal("text_now_3.png")));
    }
    public void indicatorsX5_stage_5() {
        mainClass.setTextIndicator_5_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_5_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_5_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }

    public void indicatorsX6_stage_1() {
        mainClass.setTextIndicator_6_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_2(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_6_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX6_stage_2() {
        mainClass.setTextIndicator_6_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_3(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_6_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX6_stage_3() {
        mainClass.setTextIndicator_6_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_4(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_6_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX6_stage_4() {
        mainClass.setTextIndicator_6_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_5(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_6_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX6_stage_5() {
        mainClass.setTextIndicator_6_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_6(new Texture(Gdx.files.internal("text_now_3.png")));
    }
    public void indicatorsX6_stage_6() {
        mainClass.setTextIndicator_6_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_6_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_6_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }

    public void indicatorsX7_stage_1() {
        mainClass.setTextIndicator_7_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_2(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_7_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX7_stage_2() {
        mainClass.setTextIndicator_7_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_3(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_7_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX7_stage_3() {
        mainClass.setTextIndicator_7_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_4(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_7_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX7_stage_4() {
        mainClass.setTextIndicator_7_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_5(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_7_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX7_stage_5() {
        mainClass.setTextIndicator_7_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_6(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_7_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX7_stage_6() {
        mainClass.setTextIndicator_7_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_7(new Texture(Gdx.files.internal("text_now_3.png")));
    }
    public void indicatorsX7_stage_7() {
        mainClass.setTextIndicator_7_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_7_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_7_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }

    public void indicatorsX8_stage_1() {
        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX8_stage_2() {
        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX8_stage_3() {
        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX8_stage_4() {
        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX8_stage_5() {
        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX8_stage_6() {
        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }
    public void indicatorsX8_stage_7() {
        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_now_3.png")));
    }
    public void indicatorsX8_stage_8() {
        mainClass.setTextIndicator_8_1(new Texture(Gdx.files.internal("text_now_3.png")));
        mainClass.setTextIndicator_8_2(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_3(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_4(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_5(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_6(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_7(new Texture(Gdx.files.internal("text_hidden_3.png")));
        mainClass.setTextIndicator_8_8(new Texture(Gdx.files.internal("text_hidden_3.png")));
    }



    public void setHowManyNumbersInStepsToOpenNextChapters(int steps) {
        if(steps == 0) {
            howManyNumbersInStepsToOpenNextChapter = 1;
        } else if(steps>= 10 && steps <100) {
            howManyNumbersInStepsToOpenNextChapter = 2;
        } else if (steps >=100 && steps <1000) {
            howManyNumbersInStepsToOpenNextChapter = 3;
        } else if (steps >=1000 && steps <10000) {
            howManyNumbersInStepsToOpenNextChapter = 4;
        } else if (steps >=10000 && steps <100000) {
            howManyNumbersInStepsToOpenNextChapter = 5;
        }
    }
    public int getHowManyNumbersInStepsToOpenChapters() {
        return howManyNumbersInStepsToOpenNextChapter;
    }

    public void setUpChapterTextBottomScreen(int steps) {
        setHowManyNumbersInStepsToOpenNextChapters(steps);
        gameScreenTextStuff();
    }

    public void gameScreenTextStuff() {
        int steps = mainClass.getCurrentSteps();

        stepsLength = String.valueOf(steps).length()+getHowManyNumbersInStepsToOpenChapters();
//            System.out.println(stepsLength);

        if(stepsLength <= 2) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/4f);
//            System.out.println(stepsNeededAndCurrentlyHavePlace);
        } else if(stepsLength ==3) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/3.5f);
//            System.out.println(stepsNeededAndCurrentlyHavePlace);
        }else if(stepsLength ==4) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/2.5f);
        } else if(stepsLength ==5) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/2.1f);
        } else if(stepsLength ==6) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.9f);
        } else if(stepsLength ==7) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.6f);
        } else if(stepsLength ==8) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.5f);
        } else if(stepsLength ==9) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.25f);
        } else if(stepsLength ==10) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.15f);
        } else if(stepsLength ==11) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/1.05f);
        } else if(stepsLength ==12) {
            setStepsNeededAndCurrentlyHavePlace(mainClass.getScreenWidth()-buttonWidth/0.9f);
        }
    }

    public void setStepsNeededAndCurrentlyHavePlace(float stepsNeededAndCurrentlyHavePlace) {
        this.stepsNeededAndCurrentlyHavePlace = stepsNeededAndCurrentlyHavePlace;

    }
    public float getStepsNeededAndCurrentlyHavePlace() {return stepsNeededAndCurrentlyHavePlace;}


    public void setGroup1(Group group) {
       this.group = group;
    }
    public Group getGroup1() {
        return group;
    }

    public void setGroup2(Group group) {
        this.group2 = group;
    }
    public Group getGroup2() {
        return group2;
    }

    public String getTextForAButton() {
        return textForAButton;
    }
    public void setTextForAButton(String textForAButton) {
        this.textForAButton = textForAButton;
    }
    public int getUseForTheButton() {
        return useForTheButton;
    }
    public void setUseForTheButton(int useForTheButton) {
        this.useForTheButton = useForTheButton;
    }
    public Texture getTexture() {
        return texture;
    }
    public void setTexture(Texture texture) {
        this.texture = texture;
    }
    public float getStoryID() {
        return storyID;
    }

    public void setStoryID(float storyID) {
        this.storyID = storyID;
    }

   public Button(MainClass mainclass, Texture texture, String textForAButton, float storyID, int useForTheButton, float xPlace,
                 float yPlace, float buttonWidth, float buttonHeight, int stepsToOpenNextChapter) {

        this.mainClass = mainclass;
        //this.texture = texture;
        setTextForAButton(textForAButton);

//        System.out.println(storyID);
        setStoryID(storyID);
        setTexture(texture);
        setUseForTheButton(useForTheButton);
        setGroup1(mainclass.getGroup1());
        setGroup2(mainclass.getGroup2());
        //this.useForTheButton = useForTheButton;
        this.xPlace = xPlace;
        this.yPlace = yPlace;
        this.buttonHeight = buttonHeight;
        this.buttonWidth = buttonWidth;
       currentStepsText = mainClass.getStepsString();

        if(useForTheButton == 12) {
            scrollerWidth = -mainclass.getScreenWidth()/4*22+(mainclass.getScreenWidth()/0.99f);
        }

        //this.storyID = storyID;

       if(useForTheButton == 14 || useForTheButton == 15) {
           buttonTextXPlace = this.xPlace;
           buttonTextYPlace = this.yPlace;
       } else {
           //SETS THE X PLACE CORRECTLY TO CENTER DEPENDING ON THE TEXT SIZE FOR BUTTONS
           buttonTextXPlace = this.xPlace + buttonWidth/2 - mainClass.getTextPlaceWIDTH(textForAButton)/2;
           buttonTextYPlace = this.yPlace+buttonHeight/1.7f;
       }


        if(stepsToOpenNextChapter > 0) {
            this.stepsToOpenNextChapter = stepsToOpenNextChapter;
        }
       chapterNumber = mainclass.getChapterNumber();
//       System.out.println(chapterNumber+"H");
       font12 = mainClass.getFont12();

       setBounds(xPlace, yPlace, buttonWidth, buttonHeight);

       //addListener(new PlayerListener());
       addListener(new Gesture());


   }

    class Gesture extends ActorGestureListener {
        @Override

        public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
            touchUpX =0;
            if(getUseForTheButton() == 1 || getUseForTheButton() == 2 || getUseForTheButton() == 3 || getUseForTheButton() == 4 || getUseForTheButton() == 8 ) {
                setTexture(new Texture(Gdx.files.internal("button_orange_pressed.png")));
            }
            if (getUseForTheButton() == 8) {
                setTexture(new Texture(Gdx.files.internal("back_X_pressed.png")));
            }

            if(getUseForTheButton() == 6 || getUseForTheButton() == 5 || getUseForTheButton() == 7) {
                if(stepsToOpenNextChapter > steps) {
                    System.out.println("NExt chapter button pressed but too little steps");
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_orange_pressed.png")));
                }
            }


        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
           /*
            useForTheButton
            1. Play the game / continue
            2. Chapter Select
            3. Credits
            4. Exit
            5. Choice 1 (WRONG CHOICE)
            6. Choice 2
            7. Previous chapter
            8. Back to main menu
            9. ChapterSelect Buttons
            10. StoryBox button next slide
            11. Fin/Eng switch
            12. Pan chapterScroller
            13. Mute and unMute music
            14. Chapter number text in the game left corner
            15. Current and needed steps for at the current time
            */

            if (getUseForTheButton() == 6 || getUseForTheButton() == 5) {

                if (mainClass.getChapterNumber() == 1) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        if (getUseForTheButton() == 5) {
                            mainClass.setStepsToOpenChapter3_1(mainClass.getStepsToOpenChapter3_1() + 5);//300);
                            mainClass.setChoseWrong_1(true);
                        }

                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        System.out.println(steps);
                        mainClass.setClearedChapter1(true);
                        mainClass.prefs.putBoolean("clearedChapter1", mainClass.getClearedChapter1());
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        enoughSteps = true;
                        mainClass.setChapterNumber(chapterNumber + 1);

                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }


                } else if (mainClass.getChapterNumber() == 2) {

                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter2(true);
                        mainClass.prefs.putBoolean("clearedChapter2", mainClass.getClearedChapter2());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }


                } else if (mainClass.getChapterNumber() == 3) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter3(true);
                        mainClass.prefs.putBoolean("clearedChapter3", mainClass.getClearedChapter3());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }


                } else if (mainClass.getChapterNumber() == 4) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        if (getUseForTheButton() == 5) {
                            mainClass.setStepsToOpenChapter6_1(mainClass.getStepsToOpenChapter6_1() + 5);// 1000);
                            mainClass.setChoseWrong_2(true);
                        }
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter4(true);
                        mainClass.prefs.putBoolean("clearedChapter4", mainClass.getClearedChapter4());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }


                } else if (mainClass.getChapterNumber() == 5) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter5(true);
                        mainClass.prefs.putBoolean("clearedChapter5", mainClass.getClearedChapter5());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 6) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
//                        System.out.println(mainClass.getChapterNumber());
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter6(true);
                        mainClass.prefs.putBoolean("clearedChapter6", mainClass.getClearedChapter6());
                        System.out.println(mainClass.getClearedChapter6());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                        System.out.println("GOT TO CHAPTER 6 END BUTTON");
                    }

                } else if (mainClass.getChapterNumber() == 7) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter7(true);
                        mainClass.prefs.putBoolean("clearedChapter7", mainClass.getClearedChapter7());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 8) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter8(true);
                        mainClass.prefs.putBoolean("clearedChapter8", mainClass.getClearedChapter8());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 9) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter9(true);
                        mainClass.prefs.putBoolean("clearedChapter9", mainClass.getClearedChapter9());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 10) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter10(true);
                        mainClass.prefs.putBoolean("clearedChapter10", mainClass.getClearedChapter10());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 11) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        if (getUseForTheButton() == 5) {
                            mainClass.setStepsToOpenChapter13_1(mainClass.getStepsToOpenChapter13_1() + 5);//+ 200);
                            mainClass.setChoseWrong_3(true);
                        }
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter11(true);
                        mainClass.prefs.putBoolean("clearedChapter11", mainClass.getClearedChapter11());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 12) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter12(true);
                        mainClass.prefs.putBoolean("clearedChapter12", mainClass.getClearedChapter12());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 13) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter13(true);
                        mainClass.prefs.putBoolean("clearedChapter13", mainClass.getClearedChapter13());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 14) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter14(true);
                        mainClass.prefs.putBoolean("clearedChapter14", mainClass.getClearedChapter14());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 15) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter15(true);
                        mainClass.prefs.putBoolean("clearedChapter15", mainClass.getClearedChapter15());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 16) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter16(true);
                        mainClass.prefs.putBoolean("clearedChapter16", mainClass.getClearedChapter16());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 17) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        if (getUseForTheButton() == 5) {
                            mainClass.setStepsToOpenChapter19_1(mainClass.getStepsToOpenChapter19_1() + 5 );// 800);
                            mainClass.setChoseWrong_4(true);
                        }
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter17(true);
                        mainClass.prefs.putBoolean("clearedChapter17", mainClass.getClearedChapter17());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 18) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter18(true);
                        mainClass.prefs.putBoolean("clearedChapter18", mainClass.getClearedChapter18());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 19) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter19(true);
                        mainClass.prefs.putBoolean("clearedChapter19", mainClass.getClearedChapter19());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 20) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter20(true);
                        mainClass.prefs.putBoolean("clearedChapter20", mainClass.getClearedChapter20());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 21) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter21(true);
                        mainClass.prefs.putBoolean("clearedChapte21", mainClass.getClearedChapter21());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 22) {
                    if (stepsToOpenNextChapter > steps) {
                        System.out.println("ERROR TOO FEW STEPS");
                    } else {
                        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                        System.out.println("REMOVING STEPS");
                        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                        mainClass.removeSteps(stepsToOpenNextChapter);
                        enoughSteps = true;
                        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                        mainClass.setClearedChapter22(true);
                        mainClass.prefs.putBoolean("clearedChapter22", mainClass.getClearedChapter22());
                        mainClass.setChapterNumber(chapterNumber + 1);
                        mainClass.setSwapped(false);
                        mainClass.prefs.flush();
                    }

                } else if (mainClass.getChapterNumber() == 23) {
                    if (getUseForTheButton() == 5) {
                        System.out.println("MENIS TAKAS ALKUUN MUTTA EI JAKSANU KKOODATA VIEL AFDSFD");
                    }
                    if (getUseForTheButton() == 6) {
                        System.out.println("En tiiä mitä täst pitäs tapahtuu sdfsdf");
                    }
                    System.out.println("LAST CHAPTER");
                    mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
                    System.out.println("REMOVING STEPS");
                    System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                    mainClass.removeSteps(stepsToOpenNextChapter);
                    enoughSteps = true;
                    mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                    mainClass.setClearedChapter22(true);
                    mainClass.prefs.putBoolean("clearedChapter23", mainClass.getClearedChapter23());
                    mainClass.setChapterNumber(chapterNumber + 1);
                    mainClass.setSwapped(false);
                    mainClass.prefs.flush();
                }

//                COMPUTER TESTING ADD 250 STEPS
                if (!enoughSteps) {
                    mainClass.setSteps(880000);
                }


            } else if (getUseForTheButton() == 7) {
                mainClass.setChapterNumber(chapterNumber - 1);
                mainClass.setSwapped(false);
            } else if (getUseForTheButton() == 8) {

                mainClass.getStage().clear();
                //START THE GAME FROM MAIN MENU
                MainMenu mainMenu = new MainMenu(mainClass);
                mainClass.setSwapped(false);
                mainClass.setScreen(mainMenu);
            } else if (getUseForTheButton() == 1) {
                if (mainClass.prefs.getBoolean("openedFirstTime")) {
                    mainClass.prefs.putBoolean("openedFirstTime", true);
                    mainClass.prefs.flush();
                    System.out.println("OPENEEDFIRSTTIME");
                    mainClass.prefs.flush();
                }
                mainClass.setPlayPressed(true);
                System.out.println(mainClass.getPlayPressed());
                GameScreen gameScreen = new GameScreen(mainClass);
                mainClass.setScreen(gameScreen);

            } else if (getUseForTheButton() == 2) {
                ChapterSelect chapterSelect = new ChapterSelect(mainClass);
                mainClass.setScreen(chapterSelect);
            } else if (getUseForTheButton() == 3) {
//                mainClass.stopBackGroundMusic();
                Credits credits = new Credits(mainClass);
                mainClass.setScreen(credits);
            } else if (getUseForTheButton() == 4) {
                //EI SULJE TAUSTAPROSESSISTA VISSIIN --- SELVITÄ
                Gdx.app.exit();
            } else if (getUseForTheButton() == 9) {
                if(touchUpX == 0) {
                System.out.println("9 pressed");
                    chapterSelect = Integer.parseInt(getTextForAButton());
                    if (mainClass.getClearedChapter1() && chapterSelect == 1 ||
                            mainClass.getClearedChapter2() && chapterSelect == 2 ||
                            mainClass.getClearedChapter3() && chapterSelect == 3 ||
                            mainClass.getClearedChapter4() && chapterSelect == 4 ||
                            mainClass.getClearedChapter5() && chapterSelect == 5 ||
                            mainClass.getClearedChapter6() && chapterSelect == 6 ||
                            mainClass.getClearedChapter7() && chapterSelect == 7 ||
                            mainClass.getClearedChapter8() && chapterSelect == 8 ||
                            mainClass.getClearedChapter9() && chapterSelect == 9 ||
                            mainClass.getClearedChapter10() && chapterSelect == 10 ||
                            mainClass.getClearedChapter11() && chapterSelect == 11 ||
                            mainClass.getClearedChapter12() && chapterSelect == 12 ||
                            mainClass.getClearedChapter13() && chapterSelect == 13 ||
                            mainClass.getClearedChapter14() && chapterSelect == 14 ||
                            mainClass.getClearedChapter15() && chapterSelect == 15 ||
                            mainClass.getClearedChapter16() && chapterSelect == 16 ||
                            mainClass.getClearedChapter17() && chapterSelect == 17 ||
                            mainClass.getClearedChapter18() && chapterSelect == 18 ||
                            mainClass.getClearedChapter19() && chapterSelect == 19 ||
                            mainClass.getClearedChapter20() && chapterSelect == 20 ||
                            mainClass.getClearedChapter21() && chapterSelect == 21 ||
                            mainClass.getClearedChapter22() && chapterSelect == 22 ||
                            mainClass.getClearedChapter23() && chapterSelect == 23 ||
                            mainClass.getCurrentFurthestChapter() == chapterSelect) {

                        mainClass.setChapterNumber(chapterSelect);
                        mainClass.prefs.putInteger("ChapterNumber", chapterSelect);
                        mainClass.setPlayPressed(false);
                        System.out.println(chapterSelect);
                        GameScreen gameScreen = new GameScreen(mainClass);
                        mainClass.setScreen(gameScreen);
                        mainClass.prefs.flush();
                    } else {

                    }
                }

            } else if (getUseForTheButton() == 10) {
//                swapTextIndicators();
                swappedIndicator = false;
                System.out.println("HERE " + getStoryID());
                if (getStoryID() == 1.1f) {
                    setTextForAButton(mainClass.getChapter1_2Text());
                    setStoryID(1.2f);
                    System.out.println(getStoryID());
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 1.2f) {
                    setTextForAButton(mainClass.getChapter1_3Text());
                    setStoryID(1.3f);
                   indicatorsX3_stage_2();
                   if(!mainClass.getGotToLastTextPartOkayToShowNeededButtons()) {
                       System.out.println("SET LASTTEXTOKAY TO TRUE");
                       mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
                       if(!mainClass.getClearedChapter1()) {
                           mainClass.setButton5Visible(true);
                           mainClass.setButton6Visible(true);
                       } else {
                           mainClass.setButton6Visible(true);
                       }
                   }
                } else if (getStoryID() == 1.3f) {
                    setTextForAButton(mainClass.getChapter1_1Text());
                    setStoryID(1.1f);
                    indicatorsX3_stage_3();
                }else if (getStoryID() == 2.1f) {
                    setTextForAButton(mainClass.getChapter2_2Text());
                    setStoryID(2.2f);
                    indicatorsX2_stage_1();
                    if(!mainClass.getGotToLastTextPartOkayToShowNeededButtons()) {
                        System.out.println("SET LASTTEXTOKAY TO TRUE");
//                        mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
//                        mainClass.setGotToTheLastTextOnceAlready(true);
                        if(!mainClass.getClearedChapter1()) {
//                            mainClass.setButton5Visible();
                            mainClass.setButton6Visible(true);
                        } else {
                            mainClass.setButton6Visible(true);
                        }
                    }
                } else if (getStoryID() == 2.2f) {
                    setTextForAButton(mainClass.getChapter2_1Text());
                    setStoryID(2.1f);
                    indicatorsX2_stage_2();
                } else if (getStoryID() == 3.1f) {
                    setTextForAButton(mainClass.getChapter3_2Text());
                    setStoryID(3.2f);
                    indicatorsX2_stage_1();
                } else if (getStoryID() == 3.2f) {
                    setTextForAButton(mainClass.getChapter3_1Text());
                    setStoryID(3.1f);
                    indicatorsX2_stage_2();
                } else if (getStoryID() == 4.1f) {
                    setTextForAButton(mainClass.getChapter4_2Text());
                    setStoryID(4.2f);
                    indicatorsX2_stage_1();
                } else if (getStoryID() == 4.2f) {
                    setTextForAButton(mainClass.getChapter4_1Text());
                    setStoryID(4.1f);
                    indicatorsX2_stage_2();
                } else if (getStoryID() == 5.1f) {
                    setTextForAButton(mainClass.getChapter5_2Text());
                    setStoryID(5.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 5.2f) {
                    setTextForAButton(mainClass.getChapter5_3Text());
                    setStoryID(5.3f);
                    indicatorsX3_stage_2();
                }  else if (getStoryID() == 5.3f) {
                    setTextForAButton(mainClass.getChapter5_1Text());
                    setStoryID(5.1f);
                    indicatorsX3_stage_3();
                } else if (getStoryID() == 6.1f) {
                    setTextForAButton(mainClass.getChapter6_2Text());
                    setStoryID(6.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 6.2f) {
                    setTextForAButton(mainClass.getChapter6_3Text());
                    setStoryID(6.3f);
                    indicatorsX3_stage_2();
                }  else if (getStoryID() == 6.3f) {
                    setTextForAButton(mainClass.getChapter6_1Text());
                    setStoryID(6.1f);
                    indicatorsX3_stage_3();
                } else if (getStoryID() == 7.1f) {
                    setTextForAButton(mainClass.getChapter7_2Text());
                    setStoryID(7.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 7.2f) {
                    setTextForAButton(mainClass.getChapter7_3Text());
                    setStoryID(7.3f);
                    indicatorsX3_stage_2();
                }  else if (getStoryID() == 7.3f) {
                    setTextForAButton(mainClass.getChapter7_1Text());
                    setStoryID(7.1f);
                    indicatorsX3_stage_3();
                } else if (getStoryID() == 8.1f) {
                    setTextForAButton(mainClass.getChapter8_2Text());
                    setStoryID(8.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 8.2f) {
                    setTextForAButton(mainClass.getChapter8_3Text());
                    setStoryID(8.3f);
                    indicatorsX3_stage_2();
                }  else if (getStoryID() == 8.3f) {
                    setTextForAButton(mainClass.getChapter8_1Text());
                    setStoryID(8.1f);
                    indicatorsX3_stage_3();
                } else if (getStoryID() == 9.1f) {
                    setTextForAButton(mainClass.getChapter9_2Text());
                    setStoryID(9.2f);
                    indicatorsX4_stage_1();
                } else if (getStoryID() == 9.2f) {
                    setTextForAButton(mainClass.getChapter9_3Text());
                    setStoryID(9.3f);
                    indicatorsX4_stage_2();
                }  else if (getStoryID() == 9.3f) {
                    setTextForAButton(mainClass.getChapter9_4Text());
                    setStoryID(9.4f);
                    indicatorsX4_stage_3();
                } else if (getStoryID() == 9.4f) {
                    setTextForAButton(mainClass.getChapter9_1Text());
                    setStoryID(9.1f);
                    indicatorsX4_stage_4();
                }  else if (getStoryID() == 10.1f) {
                    setTextForAButton(mainClass.getChapter10_2Text());
                    setStoryID(10.2f);
                    indicatorsX3_stage_1();
                } else if (getStoryID() == 10.2f) {
                    setTextForAButton(mainClass.getChapter10_3Text());
                    setStoryID(10.3f);
                    indicatorsX3_stage_2();
                }  else if (getStoryID() == 10.3f) {
                    setTextForAButton(mainClass.getChapter10_1Text());
                    setStoryID(10.1f);
                    indicatorsX3_stage_3();
                } else if (getStoryID() == 11.1f) {
                    setTextForAButton(mainClass.getChapter11_2Text());
                    setStoryID(11.2f);
                    indicatorsX4_stage_1();
                } else if (getStoryID() == 11.2f) {
                    setTextForAButton(mainClass.getChapter11_3Text());
                    setStoryID(11.3f);
                    indicatorsX4_stage_2();
                }  else if (getStoryID() == 11.3f) {
                    setTextForAButton(mainClass.getChapter11_4Text());
                    setStoryID(11.4f);
                    indicatorsX4_stage_3();
                } else if (getStoryID() == 11.4f) {
                    setTextForAButton(mainClass.getChapter11_1Text());
                    setStoryID(11.1f);
                    indicatorsX4_stage_4();
                } else if (getStoryID() == 12.1f) {
                    setTextForAButton(mainClass.getChapter12_2Text());
                    setStoryID(12.2f);
                    indicatorsX4_stage_1();
                } else if (getStoryID() == 12.2f) {
                    setTextForAButton(mainClass.getChapter12_3Text());
                    setStoryID(12.3f);
                    indicatorsX4_stage_2();
                }  else if (getStoryID() == 12.3f) {
                    setTextForAButton(mainClass.getChapter12_4Text());
                    setStoryID(12.4f);
                    indicatorsX4_stage_3();
                } else if (getStoryID() == 12.4f) {
                    setTextForAButton(mainClass.getChapter12_1Text());
                    setStoryID(12.1f);
                    indicatorsX4_stage_4();
                } else if (getStoryID() == 13.1f) {
                    setTextForAButton(mainClass.getChapter13_2Text());
                    setStoryID(13.2f);
                    indicatorsX4_stage_1();
                } else if (getStoryID() == 13.2f) {
                    setTextForAButton(mainClass.getChapter13_3Text());
                    setStoryID(13.3f);
                    indicatorsX4_stage_2();
                }  else if (getStoryID() == 13.3f) {
                    setTextForAButton(mainClass.getChapter13_4Text());
                    setStoryID(13.4f);
                    indicatorsX4_stage_3();
                } else if (getStoryID() == 13.4f) {
                    setTextForAButton(mainClass.getChapter13_1Text());
                    setStoryID(13.1f);
                    indicatorsX4_stage_4();
                } else if (getStoryID() == 14.1f) {
                    setTextForAButton(mainClass.getChapter14_2Text());
                    setStoryID(14.2f);
                    indicatorsX4_stage_1();
                } else if (getStoryID() == 14.2f) {
                    setTextForAButton(mainClass.getChapter14_3Text());
                    setStoryID(14.3f);
                    indicatorsX4_stage_2();
                }  else if (getStoryID() == 14.3f) {
                    setTextForAButton(mainClass.getChapter14_4Text());
                    setStoryID(14.4f);
                    indicatorsX4_stage_3();
                } else if (getStoryID() == 14.4f) {
                    setTextForAButton(mainClass.getChapter14_1Text());
                    setStoryID(14.1f);
                    indicatorsX4_stage_4();
                } else if (getStoryID() == 15.1f) {
                    setTextForAButton(mainClass.getChapter15_2Text());
                    setStoryID(15.2f);
                    indicatorsX5_stage_1();
                } else if (getStoryID() == 15.2f) {
                    setTextForAButton(mainClass.getChapter15_3Text());
                    setStoryID(15.3f);
                    indicatorsX5_stage_2();
                }  else if (getStoryID() == 15.3f) {
                    setTextForAButton(mainClass.getChapter15_4Text());
                    setStoryID(15.4f);
                    indicatorsX5_stage_3();
                } else if (getStoryID() == 15.4f) {
                    setTextForAButton(mainClass.getChapter15_5Text());
                    setStoryID(15.5f);
                    indicatorsX5_stage_4();
                } else if (getStoryID() == 15.5f) {
                    setTextForAButton(mainClass.getChapter15_1Text());
                    setStoryID(15.1f);
                    indicatorsX5_stage_5();
                } else if (getStoryID() == 16.1f) {
                    setTextForAButton(mainClass.getChapter16_2Text());
                    setStoryID(16.2f);
                    indicatorsX5_stage_1();
                } else if (getStoryID() == 16.2f) {
                    setTextForAButton(mainClass.getChapter16_3Text());
                    setStoryID(16.3f);
                    indicatorsX5_stage_2();
                }  else if (getStoryID() == 16.3f) {
                    setTextForAButton(mainClass.getChapter16_4Text());
                    setStoryID(16.4f);
                    indicatorsX5_stage_3();
                } else if (getStoryID() == 16.4f) {
                    setTextForAButton(mainClass.getChapter16_5Text());
                    setStoryID(16.5f);
                    indicatorsX5_stage_4();
                } else if (getStoryID() == 16.5f) {
                    setTextForAButton(mainClass.getChapter16_1Text());
                    setStoryID(16.1f);
                    indicatorsX5_stage_5();
                } else if (getStoryID() == 17.1f) {
                    setTextForAButton(mainClass.getChapter17_2Text());
                    setStoryID(17.2f);
                    indicatorsX8_stage_1();
                } else if (getStoryID() == 17.2f) {
                    setTextForAButton(mainClass.getChapter17_3Text());
                    setStoryID(17.3f);
                    indicatorsX8_stage_2();
                }  else if (getStoryID() == 17.3f) {
                    setTextForAButton(mainClass.getChapter17_4Text());
                    setStoryID(17.4f);
                    indicatorsX8_stage_3();
                } else if (getStoryID() == 17.4f) {
                    setTextForAButton(mainClass.getChapter17_5Text());
                    setStoryID(17.5f);
                    indicatorsX8_stage_4();
                } else if (getStoryID() == 17.5f) {
                    setTextForAButton(mainClass.getChapter17_6Text());
                    setStoryID(17.6f);
                    indicatorsX8_stage_5();
                } else if (getStoryID() == 17.6f) {
                    setTextForAButton(mainClass.getChapter17_7Text());
                    setStoryID(17.7f);
                    indicatorsX8_stage_6();
                } else if (getStoryID() == 17.7f) {
                    setTextForAButton(mainClass.getChapter17_8Text());
                    setStoryID(17.8f);
                    indicatorsX8_stage_7();
                } else if (getStoryID() == 17.8f) {
                    setTextForAButton(mainClass.getChapter17_1Text());
                    setStoryID(17.1f);
                    indicatorsX8_stage_8();
                } else if (getStoryID() == 18.1f) {
                    setTextForAButton(mainClass.getChapter18_2Text());
                    setStoryID(18.2f);
                    indicatorsX5_stage_1();
                } else if (getStoryID() == 18.2f) {
                    setTextForAButton(mainClass.getChapter18_3Text());
                    setStoryID(18.3f);
                    indicatorsX5_stage_2();
                }  else if (getStoryID() == 18.3f) {
                    setTextForAButton(mainClass.getChapter18_4Text());
                    setStoryID(18.4f);
                    indicatorsX5_stage_3();
                } else if (getStoryID() == 18.4f) {
                    setTextForAButton(mainClass.getChapter18_5Text());
                    setStoryID(18.5f);
                    indicatorsX5_stage_4();
                } else if (getStoryID() == 18.5f) {
                    setTextForAButton(mainClass.getChapter18_1Text());
                    setStoryID(18.1f);
                    indicatorsX5_stage_5();
                } else if (getStoryID() == 19.1f) {
                    setTextForAButton(mainClass.getChapter19_2Text());
                    setStoryID(19.2f);
                    indicatorsX4_stage_1();
                } else if (getStoryID() == 19.2f) {
                    setTextForAButton(mainClass.getChapter19_3Text());
                    setStoryID(19.3f);
                    indicatorsX4_stage_2();
                } else if (getStoryID() == 19.3f) {
                    setTextForAButton(mainClass.getChapter19_4Text());
                    setStoryID(19.4f);
                    indicatorsX4_stage_3();
                } else if (getStoryID() == 19.4f) {
                    setTextForAButton(mainClass.getChapter19_1Text());
                    setStoryID(19.1f);
                    indicatorsX4_stage_4();
                }  else if (getStoryID() == 20.1f) {
                    setTextForAButton(mainClass.getChapter20_2Text());
                    setStoryID(20.2f);
                    indicatorsX4_stage_1();
                } else if (getStoryID() == 20.2f) {
                    setTextForAButton(mainClass.getChapter20_3Text());
                    setStoryID(20.3f);
                    indicatorsX4_stage_2();
                }  else if (getStoryID() == 20.3f) {
                    setTextForAButton(mainClass.getChapter20_4Text());
                    setStoryID(20.4f);
                    indicatorsX4_stage_3();
                } else if (getStoryID() == 20.4f) {
                    setTextForAButton(mainClass.getChapter20_1Text());
                    setStoryID(20.1f);
                    indicatorsX4_stage_4();
                } else if (getStoryID() == 21.1f) {
                    setTextForAButton(mainClass.getChapter21_2Text());
                    setStoryID(21.2f);
                    indicatorsX5_stage_1();
                } else if (getStoryID() == 21.2f) {
                    setTextForAButton(mainClass.getChapter21_3Text());
                    setStoryID(21.3f);
                    indicatorsX5_stage_2();
                }  else if (getStoryID() == 21.3f) {
                    setTextForAButton(mainClass.getChapter21_4Text());
                    setStoryID(21.4f);
                    indicatorsX5_stage_3();
                } else if (getStoryID() == 21.4f) {
                    setTextForAButton(mainClass.getChapter21_5Text());
                    setStoryID(21.5f);
                    indicatorsX5_stage_4();
                } else if (getStoryID() == 21.5f) {
                    setTextForAButton(mainClass.getChapter21_1Text());
                    setStoryID(21.1f);
                    indicatorsX5_stage_5();
                } else if (getStoryID() == 22.1f) {
                    setTextForAButton(mainClass.getChapter22_2Text());
                    setStoryID(22.2f);
                    indicatorsX7_stage_1();
                } else if (getStoryID() == 22.2f) {
                    setTextForAButton(mainClass.getChapter22_3Text());
                    setStoryID(22.3f);
                    indicatorsX7_stage_2();
                }  else if (getStoryID() == 22.3f) {
                    setTextForAButton(mainClass.getChapter22_4Text());
                    setStoryID(22.4f);
                    indicatorsX7_stage_3();
                } else if (getStoryID() == 22.4f) {
                    setTextForAButton(mainClass.getChapter22_5Text());
                    setStoryID(22.5f);
                    indicatorsX7_stage_4();
                } else if (getStoryID() == 22.5f) {
                    setTextForAButton(mainClass.getChapter22_6Text());
                    setStoryID(22.6f);
                    indicatorsX7_stage_5();
                } else if (getStoryID() == 22.6f) {
                    setTextForAButton(mainClass.getChapter22_7Text());
                    setStoryID(22.7f);
                    indicatorsX7_stage_6();
                } else if (getStoryID() == 22.7f) {
                    setTextForAButton(mainClass.getChapter22_1Text());
                    setStoryID(22.1f);
                    indicatorsX7_stage_7();
                } else if (getStoryID() == 23.1f) {
                    setTextForAButton(mainClass.getChapter23_2Text());
                    setStoryID(23.2f);
                    indicatorsX4_stage_1();
                } else if (getStoryID() == 23.2f) {
                    setTextForAButton(mainClass.getChapter23_3Text());
                    setStoryID(23.3f);
                    indicatorsX4_stage_2();
                } else if (getStoryID() == 23.3f) {
                    setTextForAButton(mainClass.getChapter23_4Text());
                    setStoryID(23.4f);
                    indicatorsX4_stage_3();
                } else if (getStoryID() == 23.4f) {
                    setTextForAButton(mainClass.getChapter23_1Text());
                    setStoryID(23.1f);
                    indicatorsX4_stage_4();
                }






            } else if (getUseForTheButton() == 11) {

                if (mainClass.getLanguageFinnish()) {
                    mainClass.setLanguageFinnish(false);
                    mainClass.prefs.putBoolean("languageFinnish", false);
                    mainClass.prefs.flush();
                    System.out.println("I AM SWAPPING THE LANGUAGE TO ENGLISH");
                    setTexture(new Texture(Gdx.files.internal("eng_button.png")));
                    mainClass.setLocale(new Locale("en", "EN"));
                    mainClass.setLocalLanguageToString("en_EN");
                    mainClass.setLocaleTexts();
                    System.out.println("local language: " + mainClass.getlocalLanguageToString());
                } else {
                    mainClass.setLanguageFinnish(true);
                    mainClass.prefs.putBoolean("languageFinnish", true);
                    mainClass.prefs.flush();
                    System.out.println("I AM SWAPPING THE LANGUAGE TO FINNISH");
                    setTexture(new Texture(Gdx.files.internal("fin_button.png")));
                    mainClass.setLocale(new Locale("fi", "Fi"));
                    mainClass.setLocalLanguageToString("fi_FI");
                    mainClass.setLocaleTexts();
                    System.out.println("local language: " + mainClass.getlocalLanguageToString());
                }
            } else if (getUseForTheButton() == 13) {
                if (mainClass.getbackGroundMusicOffOrOn()) {
                    mainClass.setbackGroundMusicOffOrOn(false);
                    mainClass.prefs.putBoolean("backGroundMusicOn", false);
                    mainClass.prefs.flush();
                    mainClass.playBackgroundMusic();
                    setTexture(new Texture(Gdx.files.internal("sound_on_button.png")));
                    System.out.println("I AM SWAPPING THE MUSIC OFF");
                    System.out.println("Music is currently: " + mainClass.getbackGroundMusicOffOrOn());
                } else {
                    mainClass.setbackGroundMusicOffOrOn(true);
                    mainClass.prefs.putBoolean("backGroundMusicOn", true);
                    mainClass.prefs.flush();
                    mainClass.stopBackGroundMusic();
                    setTexture(new Texture(Gdx.files.internal("sound_off_button.png")));
                    System.out.println("I AM SWAPPING THE MUSIC ON");
                    System.out.println("Music is currently: " + mainClass.getbackGroundMusicOffOrOn());
                }
            } else if (getUseForTheButton() == 16 || getUseForTheButton() == 17 || getUseForTheButton() == 18) {
                setTexture(new Texture(Gdx.files.internal("text_hidden_3.png")));
            }
        }

        @Override

        public void pan(InputEvent event, float x, float y, float deltaX, float deltaY) {

            touchUpX = deltaX;
            System.out.println("PAN PAN PAN");
//            System.out.println(touchUpX + " TouchUPX   <");
            System.out.println(useForTheButton + " ads " + getGroup1().getX());

            if(getUseForTheButton() == 12 || useForTheButton == 9) {
                System.out.println(useForTheButton);
                if(getGroup1().getX()<=0 && getGroup1().getX()>= scrollerWidth) {
                    getGroup1().setX(getGroup1().getX()+deltaX);
                }else if (getGroup1().getX() > 0){
                    getGroup1().setX(-getGroup1().getX());
                } else if(getGroup1().getX()<scrollerWidth){
                    getGroup1().setX(scrollerWidth);
                }

                setGroup1(mainClass.getGroup1());
                getGroup1().setPosition(getGroup1().getX(), 20f);
            }
        }
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.setProjectionMatrix(mainClass.camera.combined);
//       System.out.println("GOT HERE");
        steps = mainClass.getCurrentSteps();

        if(useForTheButton == 5 || useForTheButton == 6) {
            if(mainClass.getGotToLastTextPartOkayToShowNeededButtons()) {
                System.out.println("GOT HERE AT THE START OF 5 AND 6");
//            System.out.println(useForTheButton);
                if(useForTheButton == 5) {
                    mainClass.setButton5Visible(true);
                    System.out.println("GOT HERE 5");
                }
                if(useForTheButton == 6) {
                    mainClass.setButton6Visible(true);
                    System.out.println("GOT HERE 6");
                }
            }
        }

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
//
//        if(useForTheButton == 5) {
//            System.out.println("BUTTON 5");
//        }
//        if(useForTheButton == 6) {
//            System.out.println("BUTTON 6");
//        }

//        System.out.println(mainClass.getGotToLastTextPartOkayToShowNeededButtons());


        if(useForTheButton == 9) {
            font12.draw(batch,"", buttonTextXPlace, buttonTextYPlace);

        } else if (useForTheButton == 15) {
//            System.out.println(stepsToOpenNextChapter);
            setUpChapterTextBottomScreen(stepsToOpenNextChapter);
            if(mainClass.getScreenHeight() < 800) {
                stepsXPlace = getStepsNeededAndCurrentlyHavePlace()- 20f;
            } else if (mainClass.getScreenHeight() >= 1000) {
                stepsXPlace = getStepsNeededAndCurrentlyHavePlace();
            }
            textForAButton = String.valueOf(steps) + "/" + stepsToOpenNextChapter;
            font12.draw(batch,textForAButton, stepsXPlace, buttonTextYPlace);
        } else if(useForTheButton != 10) {
            font12.draw(batch,textForAButton, buttonTextXPlace, buttonTextYPlace);
        }
        //STORY BOX TEXT
        else {
            if(mainClass.getScreenHeight() < 800) {
                textboxHeight = mainClass.getScreenHeight()/3.7f;
            } else if (mainClass.getScreenHeight() >= 1000) {
                textboxHeight = mainClass.getScreenHeight()/4f;
            }
            font12.draw(batch,textForAButton, textboxHeight/8, textboxHeight);
        }


    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

