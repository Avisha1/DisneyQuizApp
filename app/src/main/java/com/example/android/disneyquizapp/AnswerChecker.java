package com.example.android.disneyquizapp;

import android.content.Context;

/**
 * Created by avishai on 7/1/2017.
 */

class AnswerChecker {

    private int questionsCounter = 0;
    private int correctAnswerCounter = 0;

    private Context context;

    public AnswerChecker(Context context) {
        this.context = context;
    }

    void calculate(Boolean... args) {
        questionsCounter = args.length;

        for (Boolean b : args) {
            if (b) {
                correctAnswerCounter++;
            }
        }
    }

    String showAnswer() {
        String resultString;
        String numOutOfNum = correctAnswerCounter + " " + context.getString(R.string.out_of) + " " + questionsCounter;

        if (questionsCounter == correctAnswerCounter) {
            resultString = context.getString(R.string.excellent) + " " + numOutOfNum + "\n" + context.getString(R.string.excellent2);
        } else if (((double) correctAnswerCounter / questionsCounter) > 0.5) {
            resultString = context.getString(R.string.average) + " " + numOutOfNum + "\n" + context.getString(R.string.average2);
        } else {
            resultString = context.getString(R.string.lame) + " " + numOutOfNum + "\n" + context.getString(R.string.lame2);
        }

        return resultString;
    }

}
