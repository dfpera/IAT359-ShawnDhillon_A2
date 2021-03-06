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

public class MovingPhone extends AppCompatActivity implements View.OnClickListener,SensorEventListener {

    //Call androind buttons
    private Button backtohome, amiMovingNow;

    //boolean variable to check status
    boolean ami = false; // Used for if device is flat
    boolean isMoving = false;
    //variables for dampening function
    float movement;
    float movementLast;
    float dampening;
    Context context = this;

    //Text view for showing status
    private TextView immovingText;

    //Setup sensor manager
    private SensorManager SensorManager = null;
    private Sensor myAccelerometer = null;

    //Saves the accelerometer values into variable
    float[] accel_vals = new float[3];

    // declare vibrator sensor
    Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_phone);

        //Set text view which will show status
        immovingText = (TextView)findViewById(R.id.immoving);

        //get reference to sensor
        SensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //Intialize values for dampening function
        movement = SensorManager.GRAVITY_EARTH;
        movementLast = SensorManager.GRAVITY_EARTH;
        dampening = 0.0f;

        //get reference to the accelerometer sensor
        myAccelerometer = SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Create button variables and call from id, from xml
        backtohome = (Button)findViewById(R.id.backtohome);
        amiMovingNow = (Button)findViewById(R.id.amimovingnow);
        backtohome.setOnClickListener(this);
        amiMovingNow.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // listener for the accelerometer sensor
        SensorManager.registerListener(this, myAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        //unregister listener - release the sensor
        SensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int type = event.sensor.getType();

        //If the type is accelerometer assign values to accel_val variable
        if (type == Sensor.TYPE_ACCELEROMETER)
        {
            accel_vals = event.values;

            // Device is flat, begin vibration
            if(accel_vals[0] < 0.3 && accel_vals[1] < 0.3 && accel_vals[2] > 9.7 && !ami){
                ami = true;

                v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // Using vibrator variable v to check if a vibrator exists

                if(v.hasVibrator()) {
                    // Vibrate for 5000 milliseconds
                    v.vibrate(5000);

                    Toast.makeText(MovingPhone.this, "Device is Flat", Toast.LENGTH_SHORT).show();

                }
                else {
                    //Else display a toast "No Vibrator - Device Flat"
                    Toast.makeText(MovingPhone.this, "No Vibrator - Device is Flat", Toast.LENGTH_SHORT).show();
                    // TODO: FINISHED VIBRATION
                }




            // Device is no longer flat, reset boolean
            } else if(((accel_vals[0] > 3.0 || accel_vals[1] > 3.0) && accel_vals[2] < 8.0) && ami){
                //if not moving display toast that device is flat and vibrate.
                ami = false;

            }

            // A dampening function to determine whether device is moving

            movementLast = movement;
            movement = (float) Math.sqrt (accel_vals[0] * accel_vals[0]+ accel_vals[1] * accel_vals[1] + accel_vals[2] * accel_vals[2]);
            float diff = movement - movementLast;
            dampening = dampening * 0.95f + diff;

            if(dampening > 0.2){
                isMoving = true;

            }

            else if(dampening < 3){
                isMoving = false;
            }
        }



    }



    @Override
    public void onClick(View v) {
        //Check which button is pressed
        if(v.getId() == R.id.backtohome){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
        // if check status button is pressed, set text in text view to moving if true and not moving if false.
        else if(v.getId() == R.id.amimovingnow){
            if(isMoving){
                immovingText.setText("You're Moving");
            }else{
                immovingText.setText("You're Not Moving");
            }
        }


    }

}



