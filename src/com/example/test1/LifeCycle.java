package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LifeCycle extends Activity{

	TextView tv;
	StringBuilder sb= new StringBuilder();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		setContentView(tv);
		log("On Creat");
		
	}
	private void log(String string) {
		// TODO Auto-generated method stub
		sb.append(string);
		sb.append("\n");
		tv.setText(sb.toString());
		Log.d("life cycle test", string);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		log("On Resume");
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		log("On Pause");
		if (isFinishing())
			log("It's stopping");
	}

}
