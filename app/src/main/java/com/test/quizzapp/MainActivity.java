package com.test.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button truebtn;
    Button falsebtn;
    TextView next;
    TextView previous;
    TextView questiontestView;
    int currentIndex;

    Question[] questions= new Question[]{
            new Question(R.string.question1,false),
            new Question(R.string.question2,true),
            new Question(R.string.question3,false),
            new Question(R.string.question4,true),
            new Question(R.string.question5,false),
            new Question(R.string.question6,true)
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        truebtn=findViewById(R.id.true_btn);
        falsebtn=findViewById(R.id.false_btn);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        questiontestView=findViewById(R.id.question);

        truebtn.setOnClickListener(this);
        falsebtn.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.true_btn:
                checkQuestion(true);

                break;
            case R.id.false_btn:
               checkQuestion(false);
                break;
            case R.id.next:
                currentIndex=(currentIndex+1)%questions.length;
                updateQuestion();
                break;
            case R.id.previous:
                currentIndex=(currentIndex+questions.length-1)%questions.length;
               updateQuestion();
                break;
        }
    }


    void updateQuestion(){
        questiontestView.setText(questions[currentIndex].getQuestionId());
    }
    void checkQuestion(boolean userinput){

        if(userinput==questions[currentIndex].isResId())
            Toast.makeText(this, "R.string.correctAnswer", Toast.LENGTH_SHORT).show();
         else
            Toast.makeText(this, "R.string.wrongAnswer", Toast.LENGTH_SHORT).show();
    }
}
