package com.example.android.disneyquizapp.model;

import android.widget.CheckBox;

import com.example.android.disneyquizapp.interfaces.QuestionInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avishai on 7/1/2017.
 */

public class QuestionCheckBox implements QuestionInterface {

    private List<CheckBoxWrapper> chkList;

    public QuestionCheckBox() {
        chkList = new ArrayList<>();
    }

    public QuestionCheckBox addBox(CheckBox chk, Boolean isCorrect) {
        CheckBoxWrapper w = new CheckBoxWrapper();
        w.chk = chk;
        w.isCorrect = isCorrect;

        chkList.add(w);

        return this;
    }

    @Override
    public Boolean isValid() {
        Boolean answer = false;

        for (CheckBoxWrapper item : chkList) {
            answer = answer || item.chk.isChecked();
        }

        return answer;
    }

    @Override
    public Boolean isCorrectAnswer() {
        Boolean answer = true;

        for (CheckBoxWrapper item : chkList) {
            answer = answer && (item.chk.isChecked() == item.isCorrect);
        }

        return answer;
    }

    @Override
    public void reset() {
        chkList.clear();
    }
}
