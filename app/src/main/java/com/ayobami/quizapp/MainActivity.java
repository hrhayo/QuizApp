package com.ayobami.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correctAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks if question 1 is correct
     * <p> radioButtonAil is the correct answer
     */

    private void checkQuestionOne() {
        RadioButton radioButtonAli = findViewById(R.id.ali_rad_btn);
        boolean isQuestionOneAliChecked = radioButtonAli.isChecked();
        if (isQuestionOneAliChecked) {
            correctAnswer += 1;
        }

    }

    /**
     * This method checks if the correct answer has been supplied for question 2.
     * <p> The right answers are messiCheckBox and ronaldoCheckBox
     */

    public void checkQuestionTwo() {

        CheckBox messiCheckBox = findViewById(R.id.messi_checkbox);
        boolean messi = messiCheckBox.isChecked();

        CheckBox drogbaCheckBox = findViewById(R.id.drogba_checkbox);
        boolean drogba = drogbaCheckBox.isChecked();

        CheckBox ronaldoCheckBox = findViewById(R.id.ronaldo_checkbox);
        boolean ronaldo = ronaldoCheckBox.isChecked();


        /**
         * This conditional statement checks to see if the correct answers were chosen and adds the score
         */

        if (messi && ronaldo) {
            correctAnswer += 1;
        }

        if (messi && ronaldo && drogba) {
            correctAnswer = 0;

        } else {
            return;
        }
    }

    /**
     * This method checks if the right answer was supplied for question 3
     */

    private void checkQuestionThree() {
        RadioButton radioButtonArsenal = findViewById(R.id.arsenal_rad_btn);
        boolean isQuestionThreeArsenalChecked = radioButtonArsenal.isChecked();
        if (isQuestionThreeArsenalChecked) {
            correctAnswer += 1;
        }

    }

    /**
     * This method gets user input for question 4
     */

    private String getQuestionFourUserInput() {
        EditText userInputLastName = findViewById(R.id.answer_text);
        String userAnswer = userInputLastName.getText().toString();
        return userAnswer;
    }

    /**
     * This method checks if the answer supplied by the enduser for question 4 is correct
     */

    private void checkQuestionFour() {
        String rightAnswer = getQuestionFourUserInput();
        if (rightAnswer.trim().equalsIgnoreCase("2002")) {
            correctAnswer += 1;
        }
    }

    /**
     * This method checks if the answered supplied for question 5 is correct
     */

    private void checkQuestionFive() {
        RadioButton radioButtonBolt = findViewById(R.id.bolt_rad_btn);
        boolean isQuestionFiveBoltChecked = radioButtonBolt.isChecked();
        if (isQuestionFiveBoltChecked) {
            correctAnswer += 1;
        }

    }

    /**
     * This method executes all the coditions for all question methods above
     */

    private void checkAllQuestions() {
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
        checkQuestionFive();
    }

    private void resetCounterCorrectAnswer() {
        correctAnswer = 0;
    }


    /**
     * Onclick method to display the final output as a toast message
     */

    public void submitQuiz(View view) {

        checkAllQuestions();

        Toast.makeText(this, "You got " + correctAnswer + "/5", Toast.LENGTH_LONG).show();

        resetCounterCorrectAnswer();
        return;

    }


}





