package com.example.android.data;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Light_Sensor extends AppCompatActivity implements View.OnClickListener, SensorEventListener {
    //Start Sensor Manager
    SensorManager mSensorManager;
    Sensor myLightSensor;

    //Create text view
    TextView textLightSensorData;

    //Create Button
    private Button backhome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light__sensor);
        //Define which text view the data is going to be sent to
        textLightSensorData = (TextView)findViewById(R.id.lightsensordata);

        //Get sensor services, along with light sensor
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        myLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        //Set onclick listener to buttons.
        backhome = (Button)findViewById(R.id.homebutton);
        backhome.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Check if light sensor is present or not, if it is get the name and show it.
        if (myLightSensor == null){
            textLightSensorData.setText("No Light Sensor!");
        }else{
            mSensorManager.registerListener(this,
                    myLightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onSensorChanged(SensorEvent arg0) {
        //Check if light has data. Show data
        if(arg0.sensor.getType()==Sensor.TYPE_LIGHT) {
            textLightSensorData.setText("Light Sensor Date:"
                    + String.valueOf(arg0.values[0]));

            //If light sensor value is equal to 0, i.e. coverd play sounds and display Toast.
            if(arg0.values[0] == 0){
                Toast.makeText(Light_Sensor.this, "Light Sensor Covered", Toast.LENGTH_SHORT).show();
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();
            }
        }

    }


    @Override
    public void onClick(View v) {
        //If back button is press start intent and go back to other page.
        Intent i = new Intent(Light_Sensor.this, MainActivity.class);
        startActivity(i);
    }
}

