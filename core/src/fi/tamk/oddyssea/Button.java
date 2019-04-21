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

    float flingX;

    float textboxHeight;

    String currentStepsText;

    boolean prefsPopUpActivate;


    boolean swappedIndicator = true;

    public void useForTheButtonIs10Reverse() {

        if (getStoryID() == 1.1f) {
        } else if (getStoryID() == 1.2f) {
            setTextForAButton(mainClass.getChapterText(1,1));
            setStoryID(1.1f);
            indicatorsX3_stage_3();
        } else if (getStoryID() == 1.3f) {
            setTextForAButton(mainClass.getChapterText(1,2));
            setStoryID(1.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 2.1f) {
        } else if (getStoryID() == 2.2f) {
            setTextForAButton(mainClass.getChapterText(2,1));
            setStoryID(2.1f);
            indicatorsX2_stage_2();
        } else if (getStoryID() == 3.1f) {
        } else if (getStoryID() == 3.2f) {
            setTextForAButton(mainClass.getChapterText(3,1));
            setStoryID(3.1f);
            indicatorsX2_stage_2();
        } else if (getStoryID() == 4.1f) {
        } else if (getStoryID() == 4.2f) {
            setTextForAButton(mainClass.getChapterText(4,1));
            setStoryID(4.1f);
            indicatorsX2_stage_2();
        } else if (getStoryID() == 5.1f) {
        } else if (getStoryID() == 5.2f) {
            setTextForAButton(mainClass.getChapterText(5,1));
            setStoryID(5.1f);
            indicatorsX3_stage_3();
        }  else if (getStoryID() == 5.3f) {
            setTextForAButton(mainClass.getChapterText(5,2));
            setStoryID(5.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 6.1f) {
        } else if (getStoryID() == 6.2f) {
            setTextForAButton(mainClass.getChapterText(6,1));
            setStoryID(6.1f);
            indicatorsX3_stage_3();
        }  else if (getStoryID() == 6.3f) {
            setTextForAButton(mainClass.getChapterText(6,2));
            setStoryID(6.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 7.1f) {
        } else if (getStoryID() == 7.2f) {
            setTextForAButton(mainClass.getChapterText(7,1));
            setStoryID(7.1f);
            indicatorsX3_stage_3();
        }  else if (getStoryID() == 7.3f) {
            setTextForAButton(mainClass.getChapterText(7,2));
            setStoryID(7.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 8.1f) {
        } else if (getStoryID() == 8.2f) {
            setTextForAButton(mainClass.getChapterText(8,1));
            setStoryID(8.1f);
            indicatorsX3_stage_3();
        }  else if (getStoryID() == 8.3f) {
            setTextForAButton(mainClass.getChapterText(8,2));
            setStoryID(8.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 9.1f) {
        } else if (getStoryID() == 9.2f) {
            setTextForAButton(mainClass.getChapterText(9,1));
            setStoryID(9.1f);
            indicatorsX4_stage_4();
        }  else if (getStoryID() == 9.3f) {
            setTextForAButton(mainClass.getChapterText(9,2));
            setStoryID(9.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 9.4f) {
            setTextForAButton(mainClass.getChapterText(9,3));
            setStoryID(9.3f);
            indicatorsX4_stage_2();
        }  else if (getStoryID() == 10.1f) {
        } else if (getStoryID() == 10.2f) {
            setTextForAButton(mainClass.getChapterText(10,1));
            setStoryID(10.1f);
            indicatorsX3_stage_3();
        }  else if (getStoryID() == 10.3f) {
            setTextForAButton(mainClass.getChapterText(10,2));
            setStoryID(10.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 11.1f) {
        } else if (getStoryID() == 11.2f) {
            setTextForAButton(mainClass.getChapterText(11,1));
            setStoryID(11.1f);
            indicatorsX4_stage_4();
        }  else if (getStoryID() == 11.3f) {
            setTextForAButton(mainClass.getChapterText(11,2));
            setStoryID(11.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 11.4f) {
            setTextForAButton(mainClass.getChapterText(11,3));
            setStoryID(11.3f);
            indicatorsX4_stage_2();
        } else if (getStoryID() == 12.1f) {
        } else if (getStoryID() == 12.2f) {
            setTextForAButton(mainClass.getChapterText(12,1));
            setStoryID(12.1f);
            indicatorsX4_stage_4();
        }  else if (getStoryID() == 12.3f) {
            setTextForAButton(mainClass.getChapterText(12,2));
            setStoryID(12.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 12.4f) {
            setTextForAButton(mainClass.getChapterText(12,3));
            setStoryID(12.3f);
            indicatorsX4_stage_2();
        } else if (getStoryID() == 13.1f) {
        } else if (getStoryID() == 13.2f) {
            setTextForAButton(mainClass.getChapterText(13,1));
            setStoryID(13.1f);
            indicatorsX4_stage_4();
        }  else if (getStoryID() == 13.3f) {
            setTextForAButton(mainClass.getChapterText(13,2));
            setStoryID(13.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 13.4f) {
            setTextForAButton(mainClass.getChapterText(13,3));
            setStoryID(13.3f);
            indicatorsX4_stage_2();
        } else if (getStoryID() == 14.1f) {
        } else if (getStoryID() == 14.2f) {
            setTextForAButton(mainClass.getChapterText(14,1));
            setStoryID(14.1f);
            indicatorsX4_stage_4();
        }  else if (getStoryID() == 14.3f) {
            setTextForAButton(mainClass.getChapterText(14,2));
            setStoryID(14.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 14.4f) {
            setTextForAButton(mainClass.getChapterText(14,3));
            setStoryID(14.3f);
            indicatorsX4_stage_2();
        } else if (getStoryID() == 15.1f) {
        } else if (getStoryID() == 15.2f) {
            setTextForAButton(mainClass.getChapterText(15,1));
            setStoryID(15.1f);
            indicatorsX5_stage_5();
        }  else if (getStoryID() == 15.3f) {
            setTextForAButton(mainClass.getChapterText(15,2));
            setStoryID(15.2f);
            indicatorsX5_stage_1();
        } else if (getStoryID() == 15.4f) {
            setTextForAButton(mainClass.getChapterText(15,3));
            setStoryID(15.3f);
            indicatorsX5_stage_2();

        } else if (getStoryID() == 15.5f) {
            setTextForAButton(mainClass.getChapterText(15,4));
            setStoryID(15.4f);
            indicatorsX5_stage_3();
        } else if (getStoryID() == 16.1f) {
        } else if (getStoryID() == 16.2f) {
            setTextForAButton(mainClass.getChapterText(16,1));
            setStoryID(16.1f);
            indicatorsX5_stage_5();
        }  else if (getStoryID() == 16.3f) {
            setTextForAButton(mainClass.getChapterText(16,2));
            setStoryID(16.2f);
            indicatorsX5_stage_1();
        } else if (getStoryID() == 16.4f) {
            setTextForAButton(mainClass.getChapterText(16,3));
            setStoryID(16.3f);
            indicatorsX5_stage_2();
        } else if (getStoryID() == 16.5f) {
            setTextForAButton(mainClass.getChapterText(16,4));
            setStoryID(16.4f);
            indicatorsX5_stage_3();
        } else if (getStoryID() == 17.1f) {
        } else if (getStoryID() == 17.2f) {
            setTextForAButton(mainClass.getChapterText(17,1));
            setStoryID(17.1f);
            indicatorsX8_stage_8();
        }  else if (getStoryID() == 17.3f) {
            setTextForAButton(mainClass.getChapterText(17,2));
            setStoryID(17.2f);
            indicatorsX8_stage_1();
        } else if (getStoryID() == 17.4f) {
            setTextForAButton(mainClass.getChapterText(17,3));
            setStoryID(17.3f);
            indicatorsX8_stage_2();
        } else if (getStoryID() == 17.5f) {
            setTextForAButton(mainClass.getChapterText(17,4));
            setStoryID(17.4f);
            indicatorsX8_stage_3();
        } else if (getStoryID() == 17.6f) {
            setTextForAButton(mainClass.getChapterText(17,5));
            setStoryID(17.5f);
            indicatorsX8_stage_4();
        } else if (getStoryID() == 17.7f) {
            setTextForAButton(mainClass.getChapterText(17,6));
            setStoryID(17.6f);
            indicatorsX8_stage_5();
        } else if (getStoryID() == 17.8f) {
            setTextForAButton(mainClass.getChapterText(17,7));
            setStoryID(17.7f);
            indicatorsX8_stage_6();
        } else if (getStoryID() == 18.1f) {
        } else if (getStoryID() == 18.2f) {
            setTextForAButton(mainClass.getChapterText(18,1));
            setStoryID(18.1f);
            indicatorsX5_stage_5();
        }  else if (getStoryID() == 18.3f) {
            setTextForAButton(mainClass.getChapterText(18,2));
            setStoryID(18.2f);
            indicatorsX5_stage_1();
        } else if (getStoryID() == 18.4f) {
            setTextForAButton(mainClass.getChapterText(18,3));
            setStoryID(18.3f);
            indicatorsX5_stage_2();
        } else if (getStoryID() == 18.5f) {
            setTextForAButton(mainClass.getChapterText(18,4));
            setStoryID(18.4f);
            indicatorsX5_stage_3();
        } else if (getStoryID() == 19.1f) {
        } else if (getStoryID() == 19.2f) {
            setTextForAButton(mainClass.getChapterText(19,1));
            setStoryID(19.1f);
            indicatorsX4_stage_4();
        } else if (getStoryID() == 19.3f) {
            setTextForAButton(mainClass.getChapterText(19,2));
            setStoryID(19.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 19.4f) {
            setTextForAButton(mainClass.getChapterText(19,3));
            setStoryID(19.3f);
            indicatorsX4_stage_2();
        }  else if (getStoryID() == 20.1f) {
        } else if (getStoryID() == 20.2f) {
            setTextForAButton(mainClass.getChapterText(20,1));
            setStoryID(20.1f);
            indicatorsX4_stage_4();
        }  else if (getStoryID() == 20.3f) {
            setTextForAButton(mainClass.getChapterText(20,2));
            setStoryID(20.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 20.4f) {
            setTextForAButton(mainClass.getChapterText(20,3));
            setStoryID(20.3f);
            indicatorsX4_stage_2();
        } else if (getStoryID() == 21.1f) {
        } else if (getStoryID() == 21.2f) {
            setTextForAButton(mainClass.getChapterText(21,1));
            setStoryID(21.1f);
            indicatorsX5_stage_5();
        }  else if (getStoryID() == 21.3f) {
            setTextForAButton(mainClass.getChapterText(21,2));
            setStoryID(21.2f);
            indicatorsX5_stage_1();
        } else if (getStoryID() == 21.4f) {
            setTextForAButton(mainClass.getChapterText(21,3));
            setStoryID(21.3f);
            indicatorsX5_stage_2();
        } else if (getStoryID() == 21.5f) {
            setTextForAButton(mainClass.getChapterText(21,4));
            setStoryID(21.4f);
            indicatorsX5_stage_3();
        } else if (getStoryID() == 22.1f) {
        } else if (getStoryID() == 22.2f) {
            setTextForAButton(mainClass.getChapterText(22,1));
            setStoryID(22.1f);
            indicatorsX7_stage_7();
        }  else if (getStoryID() == 22.3f) {
            setTextForAButton(mainClass.getChapterText(22,2));
            setStoryID(22.2f);
            indicatorsX7_stage_1();
        } else if (getStoryID() == 22.4f) {
            setTextForAButton(mainClass.getChapterText(22,3));
            setStoryID(22.3f);
            indicatorsX7_stage_2();
        } else if (getStoryID() == 22.5f) {
            setTextForAButton(mainClass.getChapterText(22,4));
            setStoryID(22.4f);
            indicatorsX7_stage_3();
        } else if (getStoryID() == 22.6f) {
            setTextForAButton(mainClass.getChapterText(22,5));
            setStoryID(22.5f);
            indicatorsX7_stage_4();
        } else if (getStoryID() == 22.7f) {
            setTextForAButton(mainClass.getChapterText(22,6));
            setStoryID(22.6f);
            indicatorsX7_stage_5();
        } else if (getStoryID() == 23.1f) {
        } else if (getStoryID() == 23.2f) {
            setTextForAButton(mainClass.getChapterText(23,1));
            setStoryID(23.1f);
            indicatorsX4_stage_4();
        } else if (getStoryID() == 23.3f) {
            setTextForAButton(mainClass.getChapterText(23,2));
            setStoryID(23.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 23.4f) {
            setTextForAButton(mainClass.getChapterText(23,3));
            setStoryID(23.3f);
            indicatorsX4_stage_2();
        }
    }


    public void check2ChoicesgetGotToLastTextPartOkayToShowNeededButtons() {
        if(!mainClass.getGotToLastTextPartOkayToShowNeededButtons()) {
            System.out.println("SET LASTTEXTOKAY TO TRUE");
            mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
            mainClass.setGotToTheLastTextOnceAlready(true);
            if(!mainClass.getClearedChapterGeneral(mainClass.getChapterNumber())) {
                mainClass.setButton5Visible(true);
                mainClass.setButton6Visible(true);
            } else {
                mainClass.setButton6Visible(true);
            }
        }
    }
    public void check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons() {
        if(!mainClass.getGotToLastTextPartOkayToShowNeededButtons()) {
            System.out.println("SET LASTTEXTOKAY TO TRUE");
            mainClass.setGotToLastTextPartOkayToShowNeededButtons(true);
            mainClass.setGotToTheLastTextOnceAlready(true);
            if(!mainClass.getClearedChapterGeneral(mainClass.getChapterNumber())) {
//                            mainClass.setButton5Visible();
                mainClass.setButton6Visible(true);
            } else {
                mainClass.setButton6Visible(true);
            }
        }
    }

    public void useForTheButtonis10() {
        if (getStoryID() == 1.1f) {
            setTextForAButton(mainClass.getChapterText(1,2));
            setStoryID(1.2f);
            System.out.println(getStoryID());
            indicatorsX3_stage_1();
        } else if (getStoryID() == 1.2f) {
            setTextForAButton(mainClass.getChapterText(1,3));
            setStoryID(1.3f);
            indicatorsX3_stage_2();
            check2ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 1.3f) {
            setTextForAButton(mainClass.getChapterText(1,1));
            setStoryID(1.1f);
            indicatorsX3_stage_3();
        }else if (getStoryID() == 2.1f) {
            setTextForAButton(mainClass.getChapterText(2,2));
            setStoryID(2.2f);
            indicatorsX2_stage_1();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 2.2f) {
            setTextForAButton(mainClass.getChapterText(2,1));
            setStoryID(2.1f);
            indicatorsX2_stage_2();
        } else if (getStoryID() == 3.1f) {
            setTextForAButton(mainClass.getChapterText(3,2));
            setStoryID(3.2f);
            indicatorsX2_stage_1();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 3.2f) {
            setTextForAButton(mainClass.getChapterText(3,1));
            setStoryID(3.1f);
            indicatorsX2_stage_2();
        } else if (getStoryID() == 4.1f) {
            setTextForAButton(mainClass.getChapterText(4,2));
            setStoryID(4.2f);
            indicatorsX2_stage_1();
            check2ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 4.2f) {
            setTextForAButton(mainClass.getChapterText(4,1));
            setStoryID(4.1f);
            indicatorsX2_stage_2();
        } else if (getStoryID() == 5.1f) {
            setTextForAButton(mainClass.getChapterText(5,2));
            setStoryID(5.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 5.2f) {
            setTextForAButton(mainClass.getChapterText(5,3));
            setStoryID(5.3f);
            indicatorsX3_stage_2();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        }  else if (getStoryID() == 5.3f) {
            setTextForAButton(mainClass.getChapterText(5,1));
            setStoryID(5.1f);
            indicatorsX3_stage_3();
        } else if (getStoryID() == 6.1f) {
            setTextForAButton(mainClass.getChapterText(6,2));
            setStoryID(6.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 6.2f) {
            setTextForAButton(mainClass.getChapterText(6,3));
            setStoryID(6.3f);
            indicatorsX3_stage_2();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        }  else if (getStoryID() == 6.3f) {
            setTextForAButton(mainClass.getChapterText(6,1));
            setStoryID(6.1f);
            indicatorsX3_stage_3();
        } else if (getStoryID() == 7.1f) {
            setTextForAButton(mainClass.getChapterText(7,2));
            setStoryID(7.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 7.2f) {
            setTextForAButton(mainClass.getChapterText(7,3));
            setStoryID(7.3f);
            indicatorsX3_stage_2();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        }  else if (getStoryID() == 7.3f) {
            setTextForAButton(mainClass.getChapterText(7,1));
            setStoryID(7.1f);
            indicatorsX3_stage_3();
        } else if (getStoryID() == 8.1f) {
            setTextForAButton(mainClass.getChapterText(8,2));
            setStoryID(8.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 8.2f) {
            setTextForAButton(mainClass.getChapterText(8,3));
            setStoryID(8.3f);
            indicatorsX3_stage_2();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        }  else if (getStoryID() == 8.3f) {
            setTextForAButton(mainClass.getChapterText(8,1));
            setStoryID(8.1f);
            indicatorsX3_stage_3();
        } else if (getStoryID() == 9.1f) {
            setTextForAButton(mainClass.getChapterText(9,2));
            setStoryID(9.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 9.2f) {
            setTextForAButton(mainClass.getChapterText(9,3));
            setStoryID(9.3f);
            indicatorsX4_stage_2();
        }  else if (getStoryID() == 9.3f) {
            setTextForAButton(mainClass.getChapterText(9,4));
            setStoryID(9.4f);
            indicatorsX4_stage_3();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 9.4f) {
            setTextForAButton(mainClass.getChapterText(9,1));
            setStoryID(9.1f);
            indicatorsX4_stage_4();
        }  else if (getStoryID() == 10.1f) {
            setTextForAButton(mainClass.getChapterText(10,2));
            setStoryID(10.2f);
            indicatorsX3_stage_1();
        } else if (getStoryID() == 10.2f) {
            setTextForAButton(mainClass.getChapterText(10,3));
            setStoryID(10.3f);
            indicatorsX3_stage_2();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        }  else if (getStoryID() == 10.3f) {
            setTextForAButton(mainClass.getChapterText(10,1));
            setStoryID(10.1f);
            indicatorsX3_stage_3();
        } else if (getStoryID() == 11.1f) {
            setTextForAButton(mainClass.getChapterText(11,2));
            setStoryID(11.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 11.2f) {
            setTextForAButton(mainClass.getChapterText(11,3));
            setStoryID(11.3f);
            indicatorsX4_stage_2();
        }  else if (getStoryID() == 11.3f) {
            setTextForAButton(mainClass.getChapterText(11,4));
            setStoryID(11.4f);
            indicatorsX4_stage_3();
            check2ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 11.4f) {
            setTextForAButton(mainClass.getChapterText(11,1));
            setStoryID(11.1f);
            indicatorsX4_stage_4();
        } else if (getStoryID() == 12.1f) {
            setTextForAButton(mainClass.getChapterText(12,2));
            setStoryID(12.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 12.2f) {
            setTextForAButton(mainClass.getChapterText(12,3));
            setStoryID(12.3f);
            indicatorsX4_stage_2();
        }  else if (getStoryID() == 12.3f) {
            setTextForAButton(mainClass.getChapterText(12,4));
            setStoryID(12.4f);
            indicatorsX4_stage_3();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 12.4f) {
            setTextForAButton(mainClass.getChapterText(12,1));
            setStoryID(12.1f);
            indicatorsX4_stage_4();
        } else if (getStoryID() == 13.1f) {
            setTextForAButton(mainClass.getChapterText(13,2));
            setStoryID(13.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 13.2f) {
            setTextForAButton(mainClass.getChapterText(13,3));
            setStoryID(13.3f);
            indicatorsX4_stage_2();
        }  else if (getStoryID() == 13.3f) {
            setTextForAButton(mainClass.getChapterText(13,4));
            setStoryID(13.4f);
            indicatorsX4_stage_3();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 13.4f) {
            setTextForAButton(mainClass.getChapterText(13,1));
            setStoryID(13.1f);
            indicatorsX4_stage_4();
        } else if (getStoryID() == 14.1f) {
            setTextForAButton(mainClass.getChapterText(14,2));
            setStoryID(14.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 14.2f) {
            setTextForAButton(mainClass.getChapterText(14,3));
            setStoryID(14.3f);
            indicatorsX4_stage_2();
        }  else if (getStoryID() == 14.3f) {
            setTextForAButton(mainClass.getChapterText(14,4));
            setStoryID(14.4f);
            indicatorsX4_stage_3();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 14.4f) {
            setTextForAButton(mainClass.getChapterText(14,1));
            setStoryID(14.1f);
            indicatorsX4_stage_4();
        } else if (getStoryID() == 15.1f) {
            setTextForAButton(mainClass.getChapterText(15,2));
            setStoryID(15.2f);
            indicatorsX5_stage_1();
        } else if (getStoryID() == 15.2f) {
            setTextForAButton(mainClass.getChapterText(15,3));
            setStoryID(15.3f);
            indicatorsX5_stage_2();
        }  else if (getStoryID() == 15.3f) {
            setTextForAButton(mainClass.getChapterText(15,4));
            setStoryID(15.4f);
            indicatorsX5_stage_3();
        } else if (getStoryID() == 15.4f) {
            setTextForAButton(mainClass.getChapterText(15,5));
            setStoryID(15.5f);
            indicatorsX5_stage_4();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 15.5f) {
            setTextForAButton(mainClass.getChapterText(15,1));
            setStoryID(15.1f);
            indicatorsX5_stage_5();
        } else if (getStoryID() == 16.1f) {
            setTextForAButton(mainClass.getChapterText(16,2));
            setStoryID(16.2f);
            indicatorsX5_stage_1();
        } else if (getStoryID() == 16.2f) {
            setTextForAButton(mainClass.getChapterText(16,3));
            setStoryID(16.3f);
            indicatorsX5_stage_2();
        }  else if (getStoryID() == 16.3f) {
            setTextForAButton(mainClass.getChapterText(16,4));
            setStoryID(16.4f);
            indicatorsX5_stage_3();
        } else if (getStoryID() == 16.4f) {
            setTextForAButton(mainClass.getChapterText(16,5));
            setStoryID(16.5f);
            indicatorsX5_stage_4();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 16.5f) {
            setTextForAButton(mainClass.getChapterText(16,1));
            setStoryID(16.1f);
            indicatorsX5_stage_5();
        } else if (getStoryID() == 17.1f) {
            setTextForAButton(mainClass.getChapterText(17,2));
            setStoryID(17.2f);
            indicatorsX8_stage_1();
        } else if (getStoryID() == 17.2f) {
            setTextForAButton(mainClass.getChapterText(17,3));
            setStoryID(17.3f);
            indicatorsX8_stage_2();
        }  else if (getStoryID() == 17.3f) {
            setTextForAButton(mainClass.getChapterText(17,4));
            setStoryID(17.4f);
            indicatorsX8_stage_3();
        } else if (getStoryID() == 17.4f) {
            setTextForAButton(mainClass.getChapterText(17,5));
            setStoryID(17.5f);
            indicatorsX8_stage_4();
        } else if (getStoryID() == 17.5f) {
            setTextForAButton(mainClass.getChapterText(17,6));
            setStoryID(17.6f);
            indicatorsX8_stage_5();
        } else if (getStoryID() == 17.6f) {
            setTextForAButton(mainClass.getChapterText(17,7));
            setStoryID(17.7f);
            indicatorsX8_stage_6();
        } else if (getStoryID() == 17.7f) {
            setTextForAButton(mainClass.getChapterText(17,8));
            setStoryID(17.8f);
            indicatorsX8_stage_7();
            check2ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 17.8f) {
            setTextForAButton(mainClass.getChapterText(17,1));
            setStoryID(17.1f);
            indicatorsX8_stage_8();
        } else if (getStoryID() == 18.1f) {
            setTextForAButton(mainClass.getChapterText(18,2));
            setStoryID(18.2f);
            indicatorsX5_stage_1();
        } else if (getStoryID() == 18.2f) {
            setTextForAButton(mainClass.getChapterText(18,3));
            setStoryID(18.3f);
            indicatorsX5_stage_2();
        }  else if (getStoryID() == 18.3f) {
            setTextForAButton(mainClass.getChapterText(18,4));
            setStoryID(18.4f);
            indicatorsX5_stage_3();
        } else if (getStoryID() == 18.4f) {
            setTextForAButton(mainClass.getChapterText(18,5));
            setStoryID(18.5f);
            indicatorsX5_stage_4();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 18.5f) {
            setTextForAButton(mainClass.getChapterText(18,1));
            setStoryID(18.1f);
            indicatorsX5_stage_5();
        } else if (getStoryID() == 19.1f) {
            setTextForAButton(mainClass.getChapterText(19,2));
            setStoryID(19.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 19.2f) {
            setTextForAButton(mainClass.getChapterText(19,3));
            setStoryID(19.3f);
            indicatorsX4_stage_2();
        } else if (getStoryID() == 19.3f) {
            setTextForAButton(mainClass.getChapterText(19,4));
            setStoryID(19.4f);
            indicatorsX4_stage_3();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 19.4f) {
            setTextForAButton(mainClass.getChapterText(19,1));
            setStoryID(19.1f);
            indicatorsX4_stage_4();
        }  else if (getStoryID() == 20.1f) {
            setTextForAButton(mainClass.getChapterText(20,2));
            setStoryID(20.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 20.2f) {
            setTextForAButton(mainClass.getChapterText(20,3));
            setStoryID(20.3f);
            indicatorsX4_stage_2();
        }  else if (getStoryID() == 20.3f) {
            setTextForAButton(mainClass.getChapterText(20,4));
            setStoryID(20.4f);
            indicatorsX4_stage_3();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 20.4f) {
            setTextForAButton(mainClass.getChapterText(20,1));
            setStoryID(20.1f);
            indicatorsX4_stage_4();
        } else if (getStoryID() == 21.1f) {
            setTextForAButton(mainClass.getChapterText(21,2));
            setStoryID(21.2f);
            indicatorsX5_stage_1();
        } else if (getStoryID() == 21.2f) {
            setTextForAButton(mainClass.getChapterText(21,3));
            setStoryID(21.3f);
            indicatorsX5_stage_2();
        }  else if (getStoryID() == 21.3f) {
            setTextForAButton(mainClass.getChapterText(21,4));
            setStoryID(21.4f);
            indicatorsX5_stage_3();
        } else if (getStoryID() == 21.4f) {
            setTextForAButton(mainClass.getChapterText(21,5));
            setStoryID(21.5f);
            indicatorsX5_stage_4();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 21.5f) {
            setTextForAButton(mainClass.getChapterText(21,1));
            setStoryID(21.1f);
            indicatorsX5_stage_5();
        } else if (getStoryID() == 22.1f) {
            setTextForAButton(mainClass.getChapterText(22,2));
            setStoryID(22.2f);
            indicatorsX7_stage_1();
        } else if (getStoryID() == 22.2f) {
            setTextForAButton(mainClass.getChapterText(22,3));
            setStoryID(22.3f);
            indicatorsX7_stage_2();
        }  else if (getStoryID() == 22.3f) {
            setTextForAButton(mainClass.getChapterText(22,4));
            setStoryID(22.4f);
            indicatorsX7_stage_3();
        } else if (getStoryID() == 22.4f) {
            setTextForAButton(mainClass.getChapterText(22,5));
            setStoryID(22.5f);
            indicatorsX7_stage_4();
        } else if (getStoryID() == 22.5f) {
            setTextForAButton(mainClass.getChapterText(22,6));
            setStoryID(22.6f);
            indicatorsX7_stage_5();
        } else if (getStoryID() == 22.6f) {
            setTextForAButton(mainClass.getChapterText(22,7));
            setStoryID(22.7f);
            indicatorsX7_stage_6();
            check1ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 22.7f) {
            setTextForAButton(mainClass.getChapterText(22,1));
            setStoryID(22.1f);
            indicatorsX7_stage_7();
        } else if (getStoryID() == 23.1f) {
            setTextForAButton(mainClass.getChapterText(23,2));
            setStoryID(23.2f);
            indicatorsX4_stage_1();
        } else if (getStoryID() == 23.2f) {
            setTextForAButton(mainClass.getChapterText(23,3));
            setStoryID(23.3f);
            indicatorsX4_stage_2();
        } else if (getStoryID() == 23.3f) {
            setTextForAButton(mainClass.getChapterText(23,4));
            setStoryID(23.4f);
            indicatorsX4_stage_3();
            check2ChoicesgetGotToLastTextPartOkayToShowNeededButtons();
        } else if (getStoryID() == 23.4f) {
            setTextForAButton(mainClass.getChapterText(23,1));
            setStoryID(23.1f);
            indicatorsX4_stage_4();
        }

    }

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

    public void calculateButtonXAndYPlace() {
        //SETS THE X PLACE CORRECTLY TO CENTER DEPENDING ON THE TEXT SIZE FOR BUTTONS
        buttonTextXPlace = this.xPlace + buttonWidth/2 - mainClass.getTextPlaceWIDTH(textForAButton)/2;
        buttonTextYPlace = this.yPlace+buttonHeight/1.55f;
    }



    public void useForTheButton5Or6Commons() {
//        mainClass.prefs.putBoolean("clearedChapter" + mainClass.getChapterNumber(), true);
        System.out.println("REMOVING STEPS");
        System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
        mainClass.removeSteps(stepsToOpenNextChapter);
        System.out.println(steps);
        mainClass.setClearedChapterGeneral(true, mainClass.getChapterNumber());
        mainClass.setCurrentFurthestChapter(chapterNumber + 1);
        enoughSteps = true;
        mainClass.setChapterNumber(chapterNumber + 1);
        mainClass.setSwapped(false);
        mainClass.prefs.flush();
    }

    public void useForTheButton9Commons(boolean released) {
        for (int i = 1; i < 24; i++) {
            chapterSelect = Integer.parseInt(getTextForAButton());
            if (chapterSelect == 1) {
                if(!released) {
                    setTexture(new Texture(Gdx.files.internal("Chapter_1_unlocked_pressed.png")));
                } else {
                    setTexture(new Texture(Gdx.files.internal("Chapter_1_unlocked_unpressed.png")));
                }
            } else if (mainClass.getClearedChapterGeneral(i) && chapterSelect == i) {
                if(!released) {
                    setTexture(new Texture(Gdx.files.internal("Chapter_" + i + "_unlocked_pressed.png")));
                } else {
                    setTexture(new Texture(Gdx.files.internal("Chapter_" + i + "_unlocked_unpressed.png")));
                }
            } else if (mainClass.getCurrentFurthestChapter() == chapterSelect) {
                if (chapterSelect == i) {
                    if(!released) {
                    setTexture(new Texture(Gdx.files.internal("Chapter_" + i + "_unlocked_pressed.png")));
                    } else {
                        setTexture(new Texture(Gdx.files.internal("Chapter_" + i + "_unlocked_unpressed.png")));
                    }
                }
            }

        }
    }
   public Button(MainClass mainclass, Texture texture, String textForAButton, float storyID, int useForTheButton, float xPlace,
                 float yPlace, float buttonWidth, float buttonHeight, int stepsToOpenNextChapter) {

        this.mainClass = mainclass;
        setTextForAButton(textForAButton);

        setStoryID(storyID);
        setTexture(texture);
        setUseForTheButton(useForTheButton);
        setGroup1(mainclass.getGroup1());
        setGroup2(mainclass.getGroup2());
        this.xPlace = xPlace;
        this.yPlace = yPlace;
        this.buttonHeight = buttonHeight;
        this.buttonWidth = buttonWidth;
       currentStepsText = mainClass.getStepsString();

        if(useForTheButton == 12) {
            if(mainClass.getScreenHeight() < 800) {
                scrollerWidth = -mainclass.getScreenWidth()*2.35f;
            } else if (mainClass.getScreenHeight() >= 1000) {
                scrollerWidth = -mainclass.getScreenWidth()*2.15f;
            }

        }

       if(useForTheButton == 14) {
           buttonTextXPlace = this.xPlace+4;
           buttonTextYPlace = this.yPlace;
       } else {
          calculateButtonXAndYPlace();
       }


        if(stepsToOpenNextChapter > 0) {
            this.stepsToOpenNextChapter = stepsToOpenNextChapter;
        }
       chapterNumber = mainclass.getChapterNumber();
       font12 = mainClass.getFont12();

       setBounds(xPlace, yPlace, buttonWidth, buttonHeight);

       addListener(new Gesture());


   }

    class Gesture extends ActorGestureListener {
        @Override

        public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
            touchUpX = 0;
            flingX = 0;
            if(getUseForTheButton() == 1 || getUseForTheButton() == 2 || getUseForTheButton() == 3 || getUseForTheButton() == 4 || getUseForTheButton() == 16
                    || getUseForTheButton() == 18 || getUseForTheButton() == 19 || getUseForTheButton() == 21 || getUseForTheButton() == 22
                    || getUseForTheButton() == 24) {
                if(!mainClass.getPrefsPopUpActivate() && useForTheButton != 21 && useForTheButton !=24) {
                    setTexture(new Texture(Gdx.files.internal("button_pressed.png")));
                }else {
                    if(useForTheButton == 18 || useForTheButton == 19 || useForTheButton == 21 || useForTheButton == 24) {
                        setTexture(new Texture(Gdx.files.internal("button_pressed.png")));
                    }
                }
            }


            if(getUseForTheButton() == 6 && !getTexture().toString().equals("next_page.png") || getUseForTheButton() == 5) {
                if(stepsToOpenNextChapter > steps) {
                    System.out.println("NExt chapter button pressed but too little steps");
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_pressed.png")));
                }
            }
            if(getUseForTheButton() == 6 && getTexture().toString().equals("next_page.png")) {
                setTexture(new Texture(Gdx.files.internal("next_page_pressed.png")));
            }




            if(getUseForTheButton() == 7) {
                setTexture(new Texture(Gdx.files.internal("prev_page_pressed.png")));
            }
            if (getUseForTheButton() == 8) {
                setTexture(new Texture(Gdx.files.internal("back_X_pressed.png")));
            }


            if (getUseForTheButton() == 9) {
                useForTheButton9Commons(false);
//                for(int i = 1; i <24; i++) {
//                    chapterSelect = Integer.parseInt(getTextForAButton());
//                    if(chapterSelect == 1) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_1_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(i) && chapterSelect == i) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_"+i+"_unlocked_pressed.png")));
//                    } else if(mainClass.getCurrentFurthestChapter() == chapterSelect) {
//                    if(chapterSelect == i) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_"+i+"_unlocked_pressed.png")));
//                    }
//                }

//                chapterSelect = Integer.parseInt(getTextForAButton());

//                if(chapterSelect == 1) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_1_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(2) && chapterSelect == 2) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_2_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(3) && chapterSelect == 3) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_3_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(4) && chapterSelect == 4) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_4_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(5) && chapterSelect == 5) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_5_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(6) && chapterSelect == 6) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_6_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(7) && chapterSelect == 7) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_7_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(8) && chapterSelect == 8) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_8_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(9) && chapterSelect == 9) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_9_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(10) && chapterSelect == 10) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_10_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(11) && chapterSelect == 11) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_11_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(12) && chapterSelect == 12) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_12_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(13) && chapterSelect == 13) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_13_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(14) && chapterSelect == 14) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_14_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(15) && chapterSelect == 15) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_15_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(16) && chapterSelect == 16) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_16_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(17) && chapterSelect == 17) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_17_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(18) && chapterSelect == 18) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_18_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(19) && chapterSelect == 19) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_19_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(20) && chapterSelect == 20) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_20_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(21)&& chapterSelect == 21) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_21_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(22) && chapterSelect == 22) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_22_unlocked_pressed.png")));
//                    } else if(mainClass.getClearedChapterGeneral(23) && chapterSelect == 23) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_23_unlocked_pressed.png")));
//                } else if(mainClass.getCurrentFurthestChapter() == chapterSelect) {
//                    if(chapterSelect == 1) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_1_unlocked_pressed.png")));
//                    } else if(chapterSelect == 2) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_2_unlocked_pressed.png")));
//                    } else if( chapterSelect == 3) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_3_unlocked_pressed.png")));
//                    } else if(chapterSelect == 4) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_4_unlocked_pressed.png")));
//                    } else if( chapterSelect == 5) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_5_unlocked_pressed.png")));
//                    } else if(chapterSelect == 6) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_6_unlocked_pressed.png")));
//                    } else if(chapterSelect == 7) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_7_unlocked_pressed.png")));
//                    } else if(chapterSelect == 8) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_8_unlocked_pressed.png")));
//                    } else if(chapterSelect == 9) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_9_unlocked_pressed.png")));
//                    } else if(chapterSelect == 10) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_10_unlocked_pressed.png")));
//                    } else if(chapterSelect == 11) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_11_unlocked_pressed.png")));
//                    } else if(chapterSelect == 12) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_12_unlocked_pressed.png")));
//                    } else if(chapterSelect == 13) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_13_unlocked_pressed.png")));
//                    } else if(chapterSelect == 14) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_14_unlocked_pressed.png")));
//                    } else if(chapterSelect == 15) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_15_unlocked_pressed.png")));
//                    } else if(chapterSelect == 16) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_16_unlocked_pressed.png")));
//                    } else if(chapterSelect == 17) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_17_unlocked_pressed.png")));
//                    } else if(chapterSelect == 18) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_18_unlocked_pressed.png")));
//                    } else if( chapterSelect == 19) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_19_unlocked_pressed.png")));
//                    } else if(chapterSelect == 20) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_20_unlocked_pressed.png")));
//                    } else if(chapterSelect == 21) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_21_unlocked_pressed.png")));
//                    } else if(chapterSelect == 22) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_22_unlocked_pressed.png")));
//                    } else if(chapterSelect == 23) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_23_unlocked_pressed.png")));
//                    }
                }
//            }

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
            16. Clear prefs
            17. Empty prefs place
            18. Yes
            19. No
            20. Tutorial background place
            21. Ok
            22. Add extra steps for the Game fare
            23. Too few steps steps background
            24. Too few steps ok
            */

           if((useForTheButton == 5 || useForTheButton == 6) && !getTexture().toString().equals("next_page.png") && !getTexture().toString().equals("next_page_pressed.png")) {
               System.out.println("Setting texture back to orange");
               setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
           }
           if(getTexture().toString().equals("next_page_pressed.png")) {
               setTexture(new Texture(Gdx.files.internal("next_page.png")));
           }


            if (getUseForTheButton() == 1) {
                System.out.println("PREFSPOPUPACTIVATE" + prefsPopUpActivate);
                if(!mainClass.getPrefsPopUpActivate()) {
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
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
                }
            }else if (getUseForTheButton() == 2) {
                if(!mainClass.getPrefsPopUpActivate()) {
                    ChapterSelect chapterSelect = new ChapterSelect(mainClass);
                    mainClass.setScreen(chapterSelect);
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
                }
            } else if (getUseForTheButton() == 3) {
                if(!mainClass.getPrefsPopUpActivate()) {
                    Credits credits = new Credits(mainClass);
                    mainClass.setScreen(credits);
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
                }
            } else if (getUseForTheButton() == 4) {
                if(!mainClass.getPrefsPopUpActivate()) {
                    //EI SULJE TAUSTAPROSESSISTA VISSIIN --- SELVITÄ
                    Gdx.app.exit();
                    System.exit(0);
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
                }
            } if (getUseForTheButton() == 6 || getUseForTheButton() == 5) {
                if (stepsToOpenNextChapter > steps) {
                    if (!mainClass.getTooFewStepsPopUpActivate()) {
                        mainClass.createButtons(new Texture("box.png"), mainClass.getTooFewStepsMessage(), 0, 23, mainClass.getScreenWidth() / 2 - mainClass.getScreenWidth() / 1.5f / 2, mainClass.getScreenHeight() / 2 - mainClass.getScreenHeight() / 1.6f / 2, mainClass.getScreenWidth() / 1.5f, mainClass.getScreenHeight() / 1.6f, 0);
                        mainClass.createButtons(new Texture("button_unpressed.png"), mainClass.getOk(), 0, 24, mainClass.getScreenWidth()/2f-mainClass.getScreenWidth()/8, mainClass.getScreenHeight() / 2 - mainClass.getScreenHeight() / 1.6f / 2 + mainClass.getScreenHeight() / 20, buttonWidth, buttonHeight, 0);
                        mainClass.setTooFewStepsPopUpActivate(true);
                    }
                }
                if(touchUpX == 0) {
                    if (mainClass.getChapterNumber() == 1) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            if (getUseForTheButton() == 5) {
                                mainClass.setStepsToOpenChapter3_1(mainClass.getStepsToOpenChapter3_1() + 300);
                                mainClass.setChoseWrong_1(true);
                            }
                            useForTheButton5Or6Commons();
                        }


                    } else if (mainClass.getChapterNumber() == 2) {

                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }


                    } else if (mainClass.getChapterNumber() == 3) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }


                    } else if (mainClass.getChapterNumber() == 4) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            if (getUseForTheButton() == 5) {
                                mainClass.setStepsToOpenChapter6_1(mainClass.getStepsToOpenChapter6_1() + 1000);
                                mainClass.setChoseWrong_2(true);
                            }
                            useForTheButton5Or6Commons();
                        }


                    } else if (mainClass.getChapterNumber() == 5) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 6) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 7) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 8) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 9) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 10) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 11) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            if (getUseForTheButton() == 5) {
                                mainClass.setStepsToOpenChapter13_1(mainClass.getStepsToOpenChapter13_1() + 200);
                                mainClass.setChoseWrong_3(true);
                            }
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 12) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 13) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 14) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 15) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 16) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 17) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            if (getUseForTheButton() == 5) {
                                mainClass.setStepsToOpenChapter19_1(mainClass.getStepsToOpenChapter19_1() + 800);
                                mainClass.setChoseWrong_4(true);
                            }
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 18) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 19) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 20) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 21) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 22) {
                        if (stepsToOpenNextChapter > steps) {
                            System.out.println("ERROR TOO FEW STEPS");
                        } else {
                            useForTheButton5Or6Commons();
                        }

                    } else if (mainClass.getChapterNumber() == 23) {
                        System.out.println("GOT HERE at 23");
                        if (getUseForTheButton() == 5) {
                            mainClass.prefs.clear();
                            mainClass.setResetEverything(true);
                            mainClass.prefs.putBoolean("openedFirstTime", true);
                            mainClass.removeSteps(stepsToOpenNextChapter);
                            enoughSteps = true;
                            mainClass.setChapterNumber(1);
                            mainClass.setCurrentFurthestChapter(1);
                            mainClass.setClearedChapterGeneral(false, 1);
                            mainClass.setSwapped(false);
                            mainClass.setSteps(0);
                            mainClass.prefs.flush();
                        }
                        if (getUseForTheButton() == 6) {
                            System.out.println("LAST CHAPTER");
                            System.out.println("REMOVING STEPS");
                            System.out.println("STEPS TO OPEN NEXT CHAPTER " + stepsToOpenNextChapter);
                            mainClass.removeSteps(stepsToOpenNextChapter);
                            enoughSteps = true;
                            mainClass.setCurrentFurthestChapter(chapterNumber + 1);
                            mainClass.setClearedChapterGeneral(true, 23);
                            mainClass.setChapterNumber(chapterNumber + 1);
                            mainClass.setSwapped(false);
                            mainClass.prefs.flush();
                        }

                    } else if (mainClass.getChapterNumber() == 24) {
                        mainClass.getStage().clear();
                        //START THE GAME FROM MAIN MENU
                        MainMenu mainMenu = new MainMenu(mainClass);
                        mainClass.setSwapped(false);
                        mainClass.setScreen(mainMenu);
                    }
                }


            } else if (getUseForTheButton() == 7) {
                mainClass.setChapterNumber(chapterNumber - 1);
                mainClass.setSwapped(false);
            } else if (getUseForTheButton() == 8) {
                mainClass.getStage().clear();
                if(mainClass.gettutorialShow()) {
                    mainClass.clearGroup(20);
                }
                if(mainClass.getTooFewStepsPopUpActivate()) {
                    mainClass.clearGroup(24);
                }
                mainClass.setTooFewStepsPopUpActivate(false);
                //START THE GAME FROM MAIN MENU
                MainMenu mainMenu = new MainMenu(mainClass);
                mainClass.setSwapped(false);
                mainClass.setScreen(mainMenu);
            } else if (getUseForTheButton() == 9) {
                if(touchUpX == 0) {
                    System.out.println("9 pressed");
                    System.out.println(mainClass.getCurrentFurthestChapter());
                    chapterSelect = Integer.parseInt(getTextForAButton());
//                    mainClass.getClearedChapterGeneral(1);
                    if (mainClass.getClearedChapterGeneral(1) && chapterSelect == 1 ||
                            mainClass.getClearedChapterGeneral(2) && chapterSelect == 2 ||
                            mainClass.getClearedChapterGeneral(3) && chapterSelect == 3 ||
                            mainClass.getClearedChapterGeneral(4) && chapterSelect == 4 ||
                            mainClass.getClearedChapterGeneral(5) && chapterSelect == 5 ||
                            mainClass.getClearedChapterGeneral(6) && chapterSelect == 6 ||
                            mainClass.getClearedChapterGeneral(7) && chapterSelect == 7 ||
                            mainClass.getClearedChapterGeneral(8) && chapterSelect == 8 ||
                            mainClass.getClearedChapterGeneral(9) && chapterSelect == 9 ||
                            mainClass.getClearedChapterGeneral(10) && chapterSelect == 10 ||
                            mainClass.getClearedChapterGeneral(11) && chapterSelect == 11 ||
                            mainClass.getClearedChapterGeneral(12) && chapterSelect == 12 ||
                            mainClass.getClearedChapterGeneral(13) && chapterSelect == 13 ||
                            mainClass.getClearedChapterGeneral(14) && chapterSelect == 14 ||
                            mainClass.getClearedChapterGeneral(15) && chapterSelect == 15 ||
                            mainClass.getClearedChapterGeneral(16) && chapterSelect == 16 ||
                            mainClass.getClearedChapterGeneral(17) && chapterSelect == 17 ||
                            mainClass.getClearedChapterGeneral(18) && chapterSelect == 18 ||
                            mainClass.getClearedChapterGeneral(19) && chapterSelect == 19 ||
                            mainClass.getClearedChapterGeneral(20) && chapterSelect == 20 ||
                            mainClass.getClearedChapterGeneral(21) && chapterSelect == 21 ||
                            mainClass.getClearedChapterGeneral(22) && chapterSelect == 22 ||
                            mainClass.getClearedChapterGeneral(23) && chapterSelect == 23 ||
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
                } else {
                    useForTheButton9Commons(true);
//                    for(int i = 1; i <24; i++) {
//                        chapterSelect = Integer.parseInt(getTextForAButton());
//                        if (chapterSelect == 1) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_1_unlocked_unpressed.png")));
//                        } else if (mainClass.getClearedChapterGeneral(i) && chapterSelect == i) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_" + i + "_unlocked_unpressed.png")));
//                        } else if (mainClass.getCurrentFurthestChapter() == chapterSelect) {
//                            if (chapterSelect == i) {
//                                setTexture(new Texture(Gdx.files.internal("Chapter_" + i + "_unlocked_unpressed.png")));
//                            }
//                        }
//                    }
//                    chapterSelect = Integer.parseInt(getTextForAButton());
//                    System.out.println("RELEASED SCROLL SHOULD CHANGE BUTTON TO NORMAL");
//                    if (chapterSelect == 1) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_1_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(2) && chapterSelect == 2) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_2_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(3) && chapterSelect == 3) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_3_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(4) && chapterSelect == 4) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_4_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(5) && chapterSelect == 5) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_5_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(6) && chapterSelect == 6) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_6_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(7) && chapterSelect == 7) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_7_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(8) && chapterSelect == 8) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_8_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(9) && chapterSelect == 9) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_9_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(10) && chapterSelect == 10) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_10_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(11) && chapterSelect == 11) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_11_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(12) && chapterSelect == 12) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_12_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(13) && chapterSelect == 13) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_13_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(14) && chapterSelect == 14) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_14_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(15) && chapterSelect == 15) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_15_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(16) && chapterSelect == 16) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_16_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(17) && chapterSelect == 17) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_17_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(18) && chapterSelect == 18) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_18_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(19)&& chapterSelect == 19) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_19_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(20) && chapterSelect == 20) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_20_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(21) && chapterSelect == 21) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_21_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(22) && chapterSelect == 22) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_22_unlocked_unpressed.png")));
//                    } else if (mainClass.getClearedChapterGeneral(23) && chapterSelect == 23) {
//                        setTexture(new Texture(Gdx.files.internal("Chapter_23_unlocked_unpressed.png")));
//                    } else if (mainClass.getCurrentFurthestChapter() == chapterSelect) {
//                        if (chapterSelect == 1) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_1_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 2) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_2_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 3) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_3_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 4) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_4_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 5) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_5_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 6) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_6_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 7) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_7_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 8) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_8_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 9) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_9_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 10) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_10_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 11) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_11_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 12) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_12_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 13) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_13_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 14) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_14_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 15) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_15_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 16) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_16_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 17) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_17_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 18) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_18_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 19) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_19_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 20) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_20_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 21) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_21_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 22) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_22_unlocked_unpressed.png")));
//                        } else if (chapterSelect == 23) {
//                            setTexture(new Texture(Gdx.files.internal("Chapter_23_unlocked_unpressed.png")));
//                        }
//                    }
                }

            } else if (getUseForTheButton() == 10) {
                if(!mainClass.gettutorialShow() && !mainClass.getTooFewStepsPopUpActivate()) {
                    swappedIndicator = false;
                    System.out.println("HERE " + getStoryID());
                    if(flingX == 0) {
                        useForTheButtonis10();
                    }
                }
            } else if (getUseForTheButton() == 11) {
                if(!mainClass.getPrefsPopUpActivate()) {
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
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
                }
            } else if (getUseForTheButton() == 13) {
                if(!mainClass.getPrefsPopUpActivate()) {
                    if (mainClass.getbackGroundMusicOffOrOn()) {
                        mainClass.setbackGroundMusicOffOrOn(false);
                        mainClass.soundAndLanguage.putBoolean("backGroundMusicOff", false);
                        mainClass.soundAndLanguage.flush();
                        mainClass.playBackgroundMusic();
                        setTexture(new Texture(Gdx.files.internal("sound_on_button.png")));
                        System.out.println("I AM SWAPPING THE MUSIC OFF");
                        System.out.println("Music is currently: " + mainClass.getbackGroundMusicOffOrOn());
                    } else {
                        mainClass.setbackGroundMusicOffOrOn(true);
                        mainClass.soundAndLanguage.putBoolean("backGroundMusicOff", true);
                        mainClass.soundAndLanguage.flush();
                        mainClass.stopBackGroundMusic();
                        setTexture(new Texture(Gdx.files.internal("sound_off_button.png")));
                        System.out.println("I AM SWAPPING THE MUSIC ON");
                        System.out.println("Music is currently: " + mainClass.getbackGroundMusicOffOrOn());
                    }
                } else {
                    setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
                }
            }

            if (getUseForTheButton() == 16) {
               if(!mainClass.getPrefsPopUpActivate()) {
                   setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
                   mainClass.setPrefsPopUpActivate(true);
                   mainClass.createButtons(new Texture("box.png"), mainClass.getResetGameQuestion(), 0, 17, mainClass.getScreenWidth() / 2 - mainClass.getScreenWidth() / 1.5f/2, mainClass.getScreenHeight() / 2-mainClass.getScreenHeight() / 1.6f/2, mainClass.getScreenWidth() / 1.5f, mainClass.getScreenHeight() / 1.6f, 0);
                   mainClass.createButtons(new Texture("button_unpressed.png"), mainClass.getYes(), 0, 18, mainClass.getScreenWidth() / 2 - mainClass.getScreenWidth() / 1.5f/2+20, mainClass.getScreenHeight() / 2-mainClass.getScreenHeight() / 1.6f/2+mainClass.getScreenHeight()/20, buttonWidth, buttonHeight, 0);
                   mainClass.createButtons(new Texture("button_unpressed.png"), mainClass.getNo(), 0, 19, mainClass.getScreenWidth() / 2 - mainClass.getScreenWidth() / 1.5f/2 + mainClass.getScreenWidth() / 1.5f - buttonWidth-20, mainClass.getScreenHeight() / 2-mainClass.getScreenHeight() / 1.6f/2+mainClass.getScreenHeight()/20, buttonWidth, buttonHeight, 0);
               }
           }
            if (getUseForTheButton() == 18) {
                mainClass.prefs.clear();
                mainClass.setSteps(0);
                mainClass.setCurrentFurthestChapter(1);
                mainClass.setClearedChapterGeneral(false, 1);
//                mainClass.setClearedChapter1(false);
//                mainClass.prefs.putBoolean("clearedChapter1", mainClass.getClearedChapter1());
                mainClass.setChapterNumber(1);
                mainClass.setResetEverything(true);
                mainClass.prefs.flush();
                System.out.println("PREFS CLEARED PRESSED");
                mainClass.setPrefsPopUpActivate(false);
            }
            if (getUseForTheButton() == 19) {
                mainClass.clearGroup(17);
                mainClass.setPrefsPopUpActivate(false);
            }

            if (getUseForTheButton() == 20) {
                mainClass.clearGroup(20);
                mainClass.setTutorialShow(false);
            }

            if (getUseForTheButton() == 21) {
                mainClass.clearGroup(20);
                mainClass.setTutorialShow(false);
            }
            if (getUseForTheButton() == 22) {
                //Doesn't save on computer as you need at least 1 legit step for the save
                mainClass.setSteps(mainClass.getCurrentSteps()+1000);
                setTexture(new Texture(Gdx.files.internal("button_unpressed.png")));
            }
            if (getUseForTheButton() == 23 || getUseForTheButton() == 24) {
                mainClass.clearGroup(24);
                mainClass.setTooFewStepsPopUpActivate(false);
            }
        }

        @Override

        public void pan(InputEvent event, float x, float y, float deltaX, float deltaY) {

            touchUpX = deltaX;

            if(getUseForTheButton() == 12 || useForTheButton == 9) {
                if(getGroup1().getX()<=0 && getGroup1().getX()>= scrollerWidth) {
                    getGroup1().setX(getGroup1().getX()+deltaX);
                    System.out.println("FIRST OPTION GOING ON " + getGroup1().getX());
                }

                if (getGroup1().getX() > 0){
                    getGroup1().setX(-1);
                    System.out.println("SECOND OPTION GOING ON");
                }

                if (getGroup1().getX() < scrollerWidth){
                    getGroup1().setX(scrollerWidth+1);
                    System.out.println("THIRD OPTION GOING ON");
                }

                setGroup1(mainClass.getGroup1());
                getGroup1().setPosition(getGroup1().getX(), 17f);
            }


        }
        @Override
        public void fling(InputEvent event, float velocityX, float velocityY, int button) {
            if(!mainClass.gettutorialShow() && !mainClass.getTooFewStepsPopUpActivate()) {
                if (useForTheButton == 10) {
                    if (velocityX > 0) {
                        flingX = velocityX;
                        useForTheButtonIs10Reverse();
                    } else if (velocityX < 0) {
                        System.out.println("SMALLER");
                        flingX = velocityX;

                        useForTheButtonis10();
                    }
                    System.out.println("changing slides " + flingX + " StoryID: " + getStoryID());

                }
            }
        }
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.setProjectionMatrix(mainClass.camera.combined);
        steps = mainClass.getCurrentSteps();

        if(useForTheButton == 5 || useForTheButton == 6) {
            if(mainClass.getGotToLastTextPartOkayToShowNeededButtons()) {

                if(useForTheButton == 5) {
                    mainClass.setButton5Visible(true);
                }
                if(useForTheButton == 6) {
                    mainClass.setButton6Visible(true);
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


        if(useForTheButton == 9) {
            font12.draw(batch,"", buttonTextXPlace, buttonTextYPlace);

        } else if (useForTheButton == 15) {

            textForAButton = String.valueOf(steps) + "/" + stepsToOpenNextChapter;
            calculateButtonXAndYPlace();
            font12.draw(batch,textForAButton, buttonTextXPlace+20, buttonTextYPlace);
        }
        else if(useForTheButton != 10) {
           if (mainClass.getChapterNumber() == 24 && getUseForTheButton() == 6) {
                font12.draw(batch,textForAButton, buttonTextXPlace, buttonTextYPlace);
            } else {
               if(mainClass.getChapterNumber() == 24 && useForTheButton == 14) {

               } else {
                   font12.draw(batch,textForAButton, buttonTextXPlace, buttonTextYPlace);
               }

           }

        }
        //STORY BOX TEXT
        else {
            if(mainClass.getScreenHeight() < 800) {
                textboxHeight = mainClass.getScreenHeight()/3.9f;
                font12.draw(batch,textForAButton, textboxHeight/8+4, textboxHeight+12);
            } else if (mainClass.getScreenHeight() >= 1000) {
                textboxHeight = mainClass.getScreenHeight()/4.2f;
                font12.draw(batch,textForAButton, textboxHeight/8+4, textboxHeight+25);
            }
        }


    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

