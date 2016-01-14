package com.example.test1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertTest extends Activity{
	
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		b = new Button(this);
		b.setText("Click me!");
	
		setContentView(b);
		
		View.OnClickListener l = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showAlert();
				
			}
		}; 
		
			b.setOnClickListener(l);
		
	}
	
	public void showAlert(){
		
		new AlertDialog.Builder(this).setTitle("Message for you").setMessage("Let's raise a toast!")
		.setNeutralButton("Here click here!", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast 
				.makeText(AlertTest.this, "this is the toast!", Toast.LENGTH_SHORT).show();
				
			}
		}).show();
		
	}

}
