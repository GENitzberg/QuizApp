package com.example.quizappproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //Defining global variables
    RadioGroup radioGroup_q2;
    RadioGroup radioGroup_q3;
    TextView score;
    String scoreMessage;
    String name;
    int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the name of the quiz taker
        EditText nameText = (EditText) findViewById(R.id.name_input);
        name = nameText.getText().toString();

        //Final score TextView
        score = (TextView) findViewById(R.id.final_score);
        scoreMessage = score.getText().toString();

        //Initialize radioGroups
        radioGroup_q2 = findViewById(R.id.radioGroup_q2);
        radioGroup_q3 = findViewById(R.id.radioGroup_q3);

        //Set onClick listener for Button
        final Button button = findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v)
            {
                submitQuiz(findViewById(R.id.submit_button));
            }
        });
    }

    //Method that will be called as soon as the submit quiz button is clicked
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void submitQuiz(View v){
        EditText nameText = (EditText) findViewById(R.id.name_input);
        name = nameText.getText().toString();
        finalScore = calculateScore();
        String finalScoreMessage = name + " Score: " + finalScore + "/60";
        score.setText(finalScoreMessage);
        Toast.makeText(getApplicationContext(), finalScoreMessage, Toast.LENGTH_LONG).show();
    }

    //Question one answer check
    private boolean isQuestionOneRight(){
        CheckBox q1a2 = (CheckBox) findViewById(R.id.justice_checkbox);
        CheckBox q1a4 = (CheckBox) findViewById(R.id.advocate_checkbox);
        boolean correctAnswer1 = q1a2.isChecked();
        boolean correctAnswer2 = q1a4.isChecked();

        if(correctAnswer1 && correctAnswer2){
            return true;
        }else
            return false;
    }

    //Question two answer check
    private boolean isQuestionTwoRight(){
        RadioButton q2Answer = (RadioButton) findViewById(R.id.martin_radio_button);
        boolean correctAnswer = q2Answer.isChecked();
        if(correctAnswer){
            return true;
        }else
            return false;
    }

    //Question three answer check
    private boolean isQuestionThreeRight(){
        RadioButton q3Answer = (RadioButton) findViewById(R.id.two_children_true);
        boolean correctAnswer = q3Answer.isChecked();
        if(correctAnswer){
            return true;
        }else
            return false;
    }

    //Question four answer check
    private boolean isQuestionFourRight(){
        CheckBox q4a1 = (CheckBox) findViewById(R.id.columbia_law_checkbox);
        CheckBox q4a2 = (CheckBox) findViewById(R.id.harvard_law_checkbox);
        boolean correct1 = q4a1.isChecked();
        boolean correct2 = q4a2.isChecked();

        if(correct1 && correct2){
            return true;
        }else
            return false;
    }

    //Question five answer check
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private boolean isQuestionFiveRight(){
        EditText answer = (EditText) findViewById(R.id.nomination_year_edit_text);
        String q5Answer = answer.getText().toString();
        String year = "1993";
        if(Objects.equals(q5Answer, year)){
            return true;
        }else
            return false;
    }

    //Question six answer check
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private boolean isQuestionSixRight(){
        EditText answer = (EditText) findViewById(R.id.maiden_name_edit_text);
        String q6Answer = answer.getText().toString().toLowerCase();
        String maidenName = "bader";
        if(Objects.equals(q6Answer, maidenName)){
            return true;
        }else
            return false;
    }
    //Method that calculates the total quiz score
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private int calculateScore() {
        finalScore = 0;

        if(isQuestionOneRight())
        {
            finalScore += 10;
        }
        if(isQuestionTwoRight())
        {
            finalScore += 10;
        }
        if(isQuestionThreeRight())
        {
            finalScore += 10;
        }
        if (isQuestionFourRight())
        {
            finalScore += 10;
        }
        if(isQuestionFiveRight()){
            finalScore += 10;
        }
        if(isQuestionSixRight()){
            finalScore += 10;
        }
        return finalScore;
    }
}