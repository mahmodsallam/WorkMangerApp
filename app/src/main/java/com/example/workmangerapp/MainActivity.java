package com.example.workmangerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    /**
     *            simple work manger implementation
     * class that extends from the worker class
     *  override the method do work that returns [success , failure ,retry ]
     *  supposed to put the long running operation inside this method
     *
     *  worker request
     *  one time work request  , and periodic work request
     *
     *  constraints
     *
     *  make a constraints on when the request supposed to be run
     *  that's it !
     * **/

    Button btn_work;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(Myworker.class).build();
        btn_work = findViewById(R.id.work_btn);


        btn_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkManager.getInstance().enqueue(oneTimeWorkRequest);
            }
        });


    }

}
