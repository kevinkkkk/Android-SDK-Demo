package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ExternalSDtest extends Activity{

	TextView tvr,tvw;
	String stat;
    String[] paths={"Music","Pictures","Books"}; 	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externalmem);
		tvr = (TextView) findViewById(R.id.tvRead);
		tvw = (TextView) findViewById(R.id.tvWrite);
		Spinner sp = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> ad1 = new ArrayAdapter <String> (ExternalSDtest.this, android.R.layout.simple_spinner_dropdown_item, paths); 

		sp.setAdapter(ad1);
		stat = Environment.getExternalStorageState();
		if (stat.equals(Environment.MEDIA_MOUNTED)){
			tvr.setText("True");
			tvw.setText("True");
		}else if (stat.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			tvr.setText("True");
			tvw.setText("False");
		}else if (stat.equals(Environment.MEDIA_UNMOUNTED)){
			tvr.setText("False");
			tvw.setText("False");
	}else {
		tvr.setText("Unknown");
		tvw.setText("Unknown");
	}
	
	

}
}