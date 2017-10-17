package com.example.android.data;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class EnvironmentNoise extends AppCompatActivity implements  View.OnClickListener {

    //Call text view iniater
    TextView environoise;

    //Call button initiater
    Button checknoise,backhome;
    MediaRecorder mRecorder;


    // boolean variable to check if noise is present or not.
    boolean envnoise = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment_noise);
        mRecorder = new MediaRecorder();


        //Set the text view to show stateus of enviroment noise.
        environoise = (TextView)findViewById(R.id.isnoiseText);

        //Create button variables and call on button id.
        checknoise = (Button)findViewById(R.id.isnoise);
        backhome = (Button)findViewById(R.id.backtohome);
        checknoise.setOnClickListener(this);
        backhome.setOnClickListener(this);
    }

    @Override
    protected void onPause(){
        mRecorder.release();
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        //Check what buton is pressed based on id.
        if(v.getId() == R.id.backtohome){
            //on press of button go to back page
            Intent intent = new Intent(this, SensorOutput.class);
            startActivity(intent);

        }
        //if its the is noise button
        else if(v.getId() == R.id.isnoise){
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.setOutputFile("/dev/null");
            try {
                mRecorder.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mRecorder.start();
            mRecorder.getMaxAmplitude();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run()
                        {
                            if (mRecorder.getMaxAmplitude() > 500) {
                                environoise.setText("There is noise.");
                            } else {
                                environoise.setText("It is quiet.");
                            }
                            mRecorder.reset();
                        }
                    });
                }
            }, 1000);
        }
    }
}
