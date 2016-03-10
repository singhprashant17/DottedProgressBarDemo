package com.example.webonise.customprogressbar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DottedProgressBar progressBar = (DottedProgressBar) findViewById(R.id.progress);
        progressBar.setNumberOfDots(5);
        progressBar.setLevel(4);
    }
}
