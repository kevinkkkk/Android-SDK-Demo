package com.example.test1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class SurfaceTest extends Activity implements OnTouchListener {
	MyGamePad GameTest;
	float x, y;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		GameTest = new MyGamePad(this);
		GameTest.setOnTouchListener(this);
		setContentView(GameTest);	
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		GameTest.resume();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		GameTest.pause();
	}


	
	


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		GameTest.touch();
		return false;
	}


	

}
