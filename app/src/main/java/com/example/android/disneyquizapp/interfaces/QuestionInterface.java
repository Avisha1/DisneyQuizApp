package com.example.android.disneyquizapp.interfaces;

/**
 * Created by avishai on 7/1/2017.
 */

public interface QuestionInterface {

    /**
     * Check if user chose some answer.
     *
     * @return
     */
    Boolean isValid();

    /**
     * Check if user chose the correct answer.
     *
     * @return
     */
    Boolean isCorrectAnswer();

    /**
     * Reset the list inside the class.
     */
    void reset();

}
