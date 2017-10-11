package com.example.android.data;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EnvironmentNoise extends AppCompatActivity implements  View.OnClickListener {

    //Call text view iniater
    TextView ProximitySensor, ProximityMax, ProximityReading;
    private TextView environoise;

    //Call button initiater
    private Button checknoise,backhome;

    //Set up sensor manager to hold sensor data.
    SensorManager SensorManager;
    Sensor myProximitySensor;

    // boolean variable to check if noise is present or not.
    boolean envnoise = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment_noise);

//        //Setting the sensor data to text views
//        ProximitySensor = (TextView)findViewById(R.id.proximitySensor);
//        ProximityMax = (TextView)findViewById(R.id.proximityMax);
//        ProximityReading = (TextView)findViewById(R.id.proximityReading);
//
//        //getting sensor services and calling on proximity sensor.
//        SensorManager = (SensorManager)getSystemService(
//                Context.SENSOR_SERVICE);
//        myProximitySensor = SensorManager.getDefaultSensor(
//                Sensor.TYPE_PROXIMITY);
//
//
//        //check if the sesnro is present, if not display message, otherwise, display sensor info
//        if (myProximitySensor == null){
//            ProximitySensor.setText("No Proximity Sensor!");
//        }else{
//            ProximitySensor.setText(myProximitySensor.getName());
//            ProximityMax.setText("Maximum Range: "
//                    + String.valueOf(myProximitySensor.getMaximumRange()));
//            SensorManager.registerListener(proximitySensorEventListener,
//                    myProximitySensor,
//                    SensorManager.SENSOR_DELAY_NORMAL);
//        }
//
//        //Set the text view to show stateus of enviroment noise.
//        environoise = (TextView)findViewById(R.id.noisetextView);
//
//        //Create button variables and call on button id.
//        checknoise = (Button)findViewById(R.id.isnoise);
//        backhome = (Button)findViewById(R.id.backtosensroslist);
    }

//    //Sensor event listener
//    SensorEventListener proximitySensorEventListener = new SensorEventListener(){
//    }

    @Override
    public void onClick(View v) {
//        //Check what buton is pressed based on id.
//        if(v.getId() == R.id.backtosensroslist){
//            //on press of button go to back page
//            Intent intent = new Intent(EnvironmentNoise.this, SensorOutput.class);
//            startActivity(intent);
//
//        }
//        //if its the check noise button, check if booloean is true ot false and set text in textview.
//        else if(v.getId() == R.id.isnoise){
//            if(envnoise == true){
//                environoise.setText("There Is Noise");
//            }
//            if(envnoise == false){
//                environoise.setText("No Noise Present");
//            }
//        }
    }
}
