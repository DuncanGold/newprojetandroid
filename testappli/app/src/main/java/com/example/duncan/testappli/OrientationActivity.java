package com.example.duncan.testappli;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class OrientationActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mRotationSensor;
    private ImageView shakerimg;
    private static final int SENSOR_DELAY = 5 * 1000; // 500ms
    private static final int FROM_RADS_TO_DEGS = -57;
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StartActivity.class));
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        shakerimg = (ImageView) findViewById(R.id.shakerimg);
        try {
            mSensorManager = (SensorManager) getSystemService(Activity.SENSOR_SERVICE);
            mRotationSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            mSensorManager.registerListener(this, mRotationSensor, SENSOR_DELAY);
        } catch (Exception e) {
            Toast.makeText(this, "Hardware compatibility issue", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor == mRotationSensor) {
            if (event.values.length > 4) {
                float[] truncatedRotationVector = new float[4];
                System.arraycopy(event.values, 0, truncatedRotationVector, 0, 4);
                update(truncatedRotationVector);
            } else {
                update(event.values);
            }
        }
    }

    private void update(float[] vectors) {
        float[] rotationMatrix = new float[9];
        SensorManager.getRotationMatrixFromVector(rotationMatrix, vectors);
        int worldAxisX = SensorManager.AXIS_X;
        int worldAxisZ = SensorManager.AXIS_Z;
        float[] adjustedRotationMatrix = new float[9];
        SensorManager.remapCoordinateSystem(rotationMatrix, worldAxisX, worldAxisZ, adjustedRotationMatrix);
        float[] orientation = new float[3];
        SensorManager.getOrientation(adjustedRotationMatrix, orientation);
     shakerimg.setX(orientation[1] * FROM_RADS_TO_DEGS + 300);
        shakerimg.setY(orientation[2] * FROM_RADS_TO_DEGS + 200);
        float pitch = orientation[1] * FROM_RADS_TO_DEGS;
        float roll = orientation[2] * FROM_RADS_TO_DEGS;
        ((TextView)findViewById(R.id.pitch)).setText("Pitch: "+pitch);
        ((TextView)findViewById(R.id.roll)).setText("Roll: "+roll);
    }

}