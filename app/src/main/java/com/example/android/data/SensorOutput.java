package com.example.android.data;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.data.R;

import java.util.List;

public class SensorOutput extends AppCompatActivity implements SensorEventListener {

    private Button lightsensor, amiMoving, enviroment, backbtn;


    TextView sensorVal, sensorInfo;
    SensorManager mSensorManager;
    Sensor sensor = null;
    List<Sensor> sensorList;

    float[] accel_vals = new float[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_output);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        sensorVal = (TextView)findViewById(R.id.sensorVal);
        sensorInfo = (TextView)findViewById(R.id.sensorInfo);

        sensor = mSensorManager.getDefaultSensor(sensorList.get(getIntent().getExtras().getInt("sensorKey")).getType());

        String stringBuffer =
                "name=\"" + sensor.getName() + "\"\n" +
                        "vendor=\"" + sensor.getVendor() + "\"\n" +
                        "version=\"" + sensor.getVersion() + "\"\n" +
                        "type=\"" + sensor.getType() + "\"\n" +
                        "maxRange=\"" + sensor.getMaximumRange() + "\"\n" +
                        "resolution=\"" + sensor.getResolution() + "\"\n" +
                        "power=\"" + sensor.getPower() + "\"\n" +
                        "minDelay=\"" + sensor.getMinDelay() + "\"\n";
        sensorInfo.setText(stringBuffer);

    }

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause(){
        mSensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        String NUM = "";
        for(int i = 0; i<values.length; i++){
            NUM += Float.toString(values[i])+ ",";
        }
        sensorVal.setText(NUM);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    }

