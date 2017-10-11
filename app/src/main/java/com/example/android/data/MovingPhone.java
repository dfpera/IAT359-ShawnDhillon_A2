package com.example.android.data;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MovingPhone extends AppCompatActivity {
        //implements View.OnClickListener,SensorEventListener {

    //Call androind buttons
    private Button backtohome, amiMovingNow;

    //boolean variable to check status
    boolean ami = false;
    //Used for vibrating sensor
    Context context = this;

    //Set edit text to sho accellerometer data
    private EditText accelXEditText; //display acceleration on X
    private EditText accelYEditText; //display acceleration on Y
    private EditText accelZEditText; //display acceleration on Z

    //Text view for showing status
    private TextView immovingText;

    //Setup sensor manager
    private SensorManager SensorManager = null;
    private Sensor myAccelerometer = null;

    //Saves the accelerometer values into variable
    float[] accel_vals = new float[3];

    // declare vibrator sensor
    private Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_phone);

//        //assign and set up vibration sensor
//        v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
//
//        //Set text view which will show status
//        immovingText = (TextView)findViewById(R.id.immoving);
//
//
//        //get references to the layout components
//        accelXEditText = (EditText)findViewById(R.id.accelXEditText);
//        accelYEditText = (EditText)findViewById(R.id.accelYEditText);
//        accelZEditText = (EditText)findViewById(R.id.accelZEditText);
//
//        //get reference to sensor and attach a listene
//        SensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//
//        //get reference to the accelerometer sensor
//        myAccelerometer = SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//
//
//        //Create button variables and call from id, from xml
//        backtohome = (Button)findViewById(R.id.backtohome);
//        amiMovingNow = (Button)findViewById(R.id.amimovingnow);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //listener for the accelerometer sensor
        //SensorManager.registerListener(this, myAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        //unregister listener - release the sensor
        //SensorManager.unregisterListener(this);
        super.onPause();
    }

//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//
//        int type = event.sensor.getType();
//
//        //If the type is accelerometer assign values to accel_val variable
//        if (type == Sensor.TYPE_ACCELEROMETER)
//        {
//            accel_vals =event.values;
//            accelXEditText.setText("AccelX: " + accel_vals[0]);
//            accelYEditText.setText("AccelY: " + accel_vals[1]);
//            accelZEditText.setText("AccelZ: " + accel_vals[2]);
//        }
//
//        //If values are between these number set boolean am i to true
//        if(((accel_vals[0])>0 && (accel_vals[0])<-2) && ((accel_vals[1])>8 && (accel_vals[1])<-8) && ((accel_vals[2])>9 && (accel_vals[2])<9)){
//
//
//            ami = true;
//
//        }else{
//            //if not moving display toast that device is flat and vibrate.
//            ami = false;
//            Toast.makeText(MovingPhone.this, "Device is Flat", Toast.LENGTH_SHORT).show();
//        }
//
//    }



//    @Override
//    public void onClick(View v) {
//        //Check which button is pressed
//        if(v.getId() == R.id.backtohome){
//            Intent intent = new Intent(MovingPhone.this, SensorOutput.class);
//            startActivity(intent);
//
//        }
//        // if check status button is pressed, set text in text view to moving if true and not moving if false.
//        else if(v.getId() == R.id.amimovingnow){
//            if(ami == true){
//                immovingText.setText("You're Moving");
//            }else{
//                immovingText.setText("You're Not Moving");
//            }
//        }
//
//
//    }

}



