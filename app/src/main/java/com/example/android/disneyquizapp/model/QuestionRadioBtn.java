package com.example.android.disneyquizapp.model;

import android.widget.RadioButton;

import com.example.android.disneyquizapp.interfaces.QuestionInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avishai on 7/1/2017.
 */

public class QuestionRadioBtn implements QuestionInterface {

    private List<RadioButtonWrapper> rdBtnList;

    public QuestionRadioBtn() {
        rdBtnList = new ArrayList<>();
    }

    public QuestionRadioBtn addButton(RadioButton btn, Boolean isCorrect) {
        RadioButtonWrapper w = new RadioButtonWrapper();
        w.btn = btn;
        w.isCorrect = isCorrect;

        rdBtnList.add(w);

        return this;
    }

    @Override
    public Boolean isValid() {
        Boolean answer = false;

        for (RadioButtonWrapper item : rdBtnList) {
            answer = answer || item.btn.isChecked();
        }

        return answer;
    }

    @Override
    public Boolean isCorrectAnswer() {
        Boolean answer = true;

        for (RadioButtonWrapper item : rdBtnList) {
            answer = answer && (item.btn.isChecked() == item.isCorrect);
        }

        return answer;
    }

    @Override
    public void reset() {
        rdBtnList.clear();
    }
}
