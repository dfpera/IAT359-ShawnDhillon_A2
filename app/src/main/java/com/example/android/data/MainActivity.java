package com.example.android.data;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.data.model.DataItem;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener  {
    //Create a list of sensors
    List<Sensor> sensorList;
    //Create a list of sensor names
    List<DataItem> sensorNames;

    Button lightSensor, movement, environmentNoise;

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Access Sensor Manager
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //Get list of sensors
        sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        //Create buttons for each actvity
        lightSensor =(Button)findViewById(R.id.lightSensor);
        movement =(Button)findViewById(R.id.movement);
        environmentNoise =(Button)findViewById(R.id.environmentNoise);
        //Create an Arraylist with type Data Item
        sensorNames = new ArrayList<DataItem>();
        for(int i = 0; i<sensorList.size(); i++){
            sensorNames.add(new DataItem(i, sensorList.get(i).getName()));

        }

        //set click listeners for the buttons
        lightSensor.setOnClickListener(this);
        movement.setOnClickListener(this);
        environmentNoise.setOnClickListener(this);


        DataItemAdapter adapter = new DataItemAdapter(this,sensorNames);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        //Check what buton is pressed based on id.
        if(v.getId() == R.id.lightSensor){
            //on press of button go to light sensor
            Intent intent = new Intent(this, Light_Sensor.class);
            startActivity(intent);

        }
        else if(v.getId() == R.id.movement){
            //on press of button go to moving phone
            Intent intent = new Intent(this, MovingPhone.class);
            startActivity(intent);

        }
        else if(v.getId() == R.id.environmentNoise){
            //on press of button go to environment noise
            Intent intent = new Intent(this, EnvironmentNoise.class);
            startActivity(intent);
        }
    }
}
