package com.example.android.disneyquizapp.model;

import android.widget.EditText;

import com.example.android.disneyquizapp.interfaces.QuestionInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avishai on 7/1/2017.
 */

public class QuestionFreeText implements QuestionInterface {

    private List<EditTextWrapper> edtWrapperList;

    public QuestionFreeText() {
        edtWrapperList = new ArrayList<>();
    }

    public QuestionFreeText addText(EditText edt, String answer) {
        EditTextWrapper w = new EditTextWrapper();
        w.edt = edt;
        w.answer = answer;

        edtWrapperList.add(w);

        return this;
    }

    @Override
    public Boolean isValid() {
        Boolean answer = false;

        for (EditTextWrapper item : edtWrapperList) {

            Boolean isContainText = !item.edt.getText().toString().trim().isEmpty();
            answer = answer || isContainText;
        }

        return answer;
    }

    @Override
    public Boolean isCorrectAnswer() {
        Boolean answer = true;

        for (EditTextWrapper item : edtWrapperList) {
            answer = answer && (item.edt.getText().toString().trim().equalsIgnoreCase(item.answer.trim()));
        }

        return answer;
    }

    @Override
    public void reset() {
        edtWrapperList.clear();
    }
}
