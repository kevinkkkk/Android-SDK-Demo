package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MPointTest extends Activity implements OnTouchListener{

	StringBuilder sb = new StringBuilder();
	TextView tv;
	float[] x = new float[10];
	float[] y = new float[10];
	boolean[] touched = new boolean[10]; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		setContentView(tv);
		tv.setOnTouchListener(this);
		
	}
	

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction()&MotionEvent.ACTION_MASK;
		int pointerIndex = (event.getAction()&MotionEvent.ACTION_POINTER_INDEX_MASK)
				>>MotionEvent.ACTION_POINTER_INDEX_SHIFT;
		int pointerId = event.getPointerId(pointerIndex);
		
		switch (action) {
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_POINTER_DOWN:
			touched[pointerId] = true;
			x[pointerId]=event.getX(pointerIndex);
			y[pointerId]=event.getY(pointerIndex);
			break;
			
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_POINTER_UP:
		case MotionEvent.ACTION_CANCEL:
			touched[pointerId]=false;
			x[pointerId]=event.getX(pointerIndex);
			y[pointerId]=event.getY(pointerIndex);
			break;
			
		case MotionEvent.ACTION_MOVE:
			int pc = event.getPointerCount();
			for (int i =0; i<pc; i++){
				pointerIndex = i;
				pointerId = event.getPointerId(pointerIndex);
				x[pointerId]=event.getX(pointerIndex);
				y[pointerId]=event.getY(pointerIndex);
			}
			break;
		}
		updateView();
		return true;
	}


	private void updateView() {
		// TODO Auto-generated method stub
		sb.setLength(0);
		for (int i = 0; i<10; i++){
			sb.append(touched[i]);
			sb.append("  x = ");
			sb.append(x[i]);
			sb.append("   Y = ");
			sb.append(y[i]);
			sb.append("\n");
		}
		tv.setText(sb.toString());
	}

}
