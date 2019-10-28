package com.example.loaderandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ControllerT ct;
    int id = 1;
    TextView loaderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ct = new ControllerT();
        findViewById(R.id.startButton).setOnClickListener(this);
        loaderText = findViewById(R.id.loaderText);
        loaderText.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onClick(View view) {
        ct.makeThread(id);
        id++;
        ct.getThread().setOnDoneListener(new OnDoneListener(){
            @Override
            public void onComplete(int progress, boolean done, int id) {
                if(done) {
                    loaderText.append(id + " Complete\n");
                }
                else {
                    loaderText.append("Thread " + id + " progress: " + progress + "%");
                }
            }
        });
    }
}
