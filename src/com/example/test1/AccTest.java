package com.example.test1;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccTest extends Activity implements SensorEventListener{

	StringBuilder sb= new StringBuilder();
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		setContentView(tv);
		
		SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size()==0){
			tv.setText("The Accelerometer is not avaiable on your cell phone");
			
		}else {
			Sensor ss= sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			if (!sm.registerListener(this, ss, sm.SENSOR_DELAY_GAME)){
				tv.setText("the sersor listener can't be located!");
			}		
			
		}
		
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		sb.setLength(0);
		sb.append("X = ");
		sb.append((int)event.values[0]);
		sb.append(", Y = ");
		sb.append((int)event.values[1]);
		sb.append("  Z = ");
		sb.append((int)event.values[2]);
		tv.setText(sb.toString());
		
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

}
