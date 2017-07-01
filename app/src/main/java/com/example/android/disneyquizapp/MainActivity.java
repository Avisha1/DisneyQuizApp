package com.example.android.disneyquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.disneyquizapp.model.QuestionCheckBox;
import com.example.android.disneyquizapp.model.QuestionFreeText;
import com.example.android.disneyquizapp.model.QuestionRadioBtn;

public class MainActivity extends AppCompatActivity {

    RadioButton q1_1_rdBtn, q1_2_rdBtn, q1_3_rdBtn, q1_4_rdBtn;
    RadioButton q2_1_rdBtn, q2_2_rdBtn, q2_3_rdBtn, q2_4_rdBtn;

    CheckBox q3_1_chk, q3_2_chk, q3_3_chk, q3_4_chk;
    CheckBox q4_1_chk, q4_2_chk, q4_3_chk, q4_4_chk, q4_5_chk;

    EditText q5Edt;

    QuestionRadioBtn q1, q2;
    QuestionCheckBox q3, q4;
    QuestionFreeText q5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        //init question 1
        q1_1_rdBtn = (RadioButton) findViewById(R.id.q1_1_elza);
        q1_2_rdBtn = (RadioButton) findViewById(R.id.q1_2_rapunzel);
        q1_3_rdBtn = (RadioButton) findViewById(R.id.q1_3_merida);
        q1_4_rdBtn = (RadioButton) findViewById(R.id.q1_4_pocahontas);
        q1 = new QuestionRadioBtn();

        //init question 2
        q2_1_rdBtn = (RadioButton) findViewById(R.id.q2_1_mickey);
        q2_2_rdBtn = (RadioButton) findViewById(R.id.q2_2_winnie);
        q2_3_rdBtn = (RadioButton) findViewById(R.id.q2_3_tinkerbell);
        q2_4_rdBtn = (RadioButton) findViewById(R.id.q2_4_mr_potato);
        q2 = new QuestionRadioBtn();

        //init question 3
        q3_1_chk = (CheckBox) findViewById(R.id.q3_1_scott);
        q3_2_chk = (CheckBox) findViewById(R.id.q3_2_robbin);
        q3_3_chk = (CheckBox) findViewById(R.id.q3_3_gilbert);
        q3_4_chk = (CheckBox) findViewById(R.id.q3_4_robert);
        q3 = new QuestionCheckBox();

        //init question 4
        q4_1_chk = (CheckBox) findViewById(R.id.q4_1_prince);
        q4_2_chk = (CheckBox) findViewById(R.id.q4_2_rescued);
        q4_3_chk = (CheckBox) findViewById(R.id.q4_3_marry);
        q4_4_chk = (CheckBox) findViewById(R.id.q4_4_free_genie);
        q4_5_chk = (CheckBox) findViewById(R.id.q4_5_chest_hair);
        q4 = new QuestionCheckBox();

        //init question 5
        q5Edt = (EditText)findViewById(R.id.q5_1);
        q5 = new QuestionFreeText();
    }

    private Boolean validateQuestions(){
        return q1.isValid() && q2.isValid() && q3.isValid() && q4.isValid() && q5.isValid();
    }

    private void resetsAnswers(){
        q1.reset();
        q2.reset();
        q3.reset();
        q4.reset();
        q5.reset();
    }

    public void checkAnswers(View view){

        //Bind questions objects with their corresponding views and answers.
        q1.addButton(q1_1_rdBtn, true).addButton(q1_2_rdBtn, false).addButton(q1_3_rdBtn, false).addButton(q1_4_rdBtn, false);
        q2.addButton(q2_1_rdBtn, true).addButton(q2_2_rdBtn, false).addButton(q2_3_rdBtn, false).addButton(q2_4_rdBtn, false);
        q3.addBox(q3_1_chk, true).addBox(q3_2_chk, true).addBox(q3_3_chk, true).addBox(q3_4_chk, false);
        q4.addBox(q4_1_chk, true).addBox(q4_2_chk, true).addBox(q4_3_chk, false).addBox(q4_4_chk, true).addBox(q4_5_chk, false);
        q5.addText(q5Edt, "1998");

        //check validations
        if(!validateQuestions()){
            Toast.makeText(this, getString(R.string.validation_error) , Toast.LENGTH_LONG).show();
            return;
        }

        //check if correct
        AnswerChecker ansChecker = new AnswerChecker();
        ansChecker.calculate(
                q1.isCorrectAnswer(),
                q2.isCorrectAnswer(),
                q3.isCorrectAnswer(),
                q4.isCorrectAnswer(),
                q5.isCorrectAnswer());

        Toast.makeText(this, ansChecker.showAnswer(), Toast.LENGTH_LONG).show();

        resetsAnswers();
    }
}
