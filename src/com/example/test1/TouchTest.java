package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class TouchTest extends Activity implements OnTouchListener{

	StringBuilder sb = new StringBuilder();
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setOnTouchListener(this);
		setContentView(tv);
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		//sb.setLength(0);
		switch (event.getAction()) {
		case (MotionEvent.ACTION_DOWN):
			sb.append("Down ");
			break;
			
		case (MotionEvent.ACTION_MOVE):
			sb.append("Move ");
			break;
			
		case (MotionEvent.ACTION_UP):
			sb.append("Up ");
			break;
			
		case (MotionEvent.ACTION_CANCEL):
			sb.append("Cancel");
			break;
			
		}
		sb.append(" X = ");
		sb.append(event.getX());
		sb.append("    Y = ");
		sb.append(event.getY());
		sb.append("\n");
		tv.setText(sb.toString());
		
		return true;
	}

}
