package com.example.webonise.customprogressbar;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

import com.prashant.android.dottedprogressbar.DottedProgressBar;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DottedProgressBar progressBar = (DottedProgressBar) findViewById(R.id.progress);
        progressBar.setNumberOfDots(5);

        Handler handler = new Handler();

        for (int i = 0; i <= 5; i++) {
            final int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setLevel(finalI);
                }
            }, 1000 * i);
        }
    }
}
