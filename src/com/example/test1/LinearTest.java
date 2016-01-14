package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;


public class LinearTest extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{
	
	Button test;
	GridView gd;
	TextView tv;
	String[] list={"asa","ggg","kkk","bbb","mmm","sss","zzz","ppp","hgh","aesr","pkpo","jhvbhj","jbj","cbvc","hvh"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lineartest);
		test = (Button) findViewById(R.id.Test);
		gd = (GridView) findViewById(R.id.gridView1);
		tv = (TextView) findViewById(R.id.result1);
		test.setOnClickListener(this);
		gd.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		gd.setAdapter(new ArrayAdapter<String>(this, R.layout.cell, list));
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		// TODO Auto-generated method stub
		
		tv.setText(list[arg2]);
		
	}
	
	

}
