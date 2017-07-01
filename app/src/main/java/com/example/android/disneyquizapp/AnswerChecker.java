package com.example.android.disneyquizapp;

/**
 * Created by avishai on 7/1/2017.
 */

public class AnswerChecker {

    private int questionsCounter = 0;
    private int correctAnswerCounter = 0;

    public AnswerChecker() {
    }

    public void calculate(Boolean... args) {
        questionsCounter = args.length;

        for (Boolean b : args) {
            if (b) {
                correctAnswerCounter++;
            }
        }
    }

    public String showAnswer() {
        String resultString;

        if (questionsCounter == correctAnswerCounter) {
            resultString = "Congratulations! 100% you were correct " + correctAnswerCounter + " out of " + questionsCounter + "\nYou are a true Disney fan.";
        } else if (((double) correctAnswerCounter / questionsCounter) > 0.5) {
            resultString = "Nice! You answered correctly " + correctAnswerCounter + " out of " + questionsCounter + "\nYou will do better next time.";
        } else {
            resultString = "Nahhh.. You answered correctly " + correctAnswerCounter + " out of " + questionsCounter + "\nGo watch the movies again";
        }

        return resultString;
    }

}
