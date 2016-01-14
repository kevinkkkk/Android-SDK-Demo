package com.example.test1;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimeSetDemo extends Activity{

	TextView timeView;
	DateFormat dateAndTime = DateFormat.getDateTimeInstance();
	Calendar calendar = Calendar.getInstance();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timeset);
		timeView = (TextView)findViewById(R.id.timeView);
		
		updateDT();
		
	}
	
	private void updateDT() {
		// TODO Auto-generated method stub
		timeView.setText(dateAndTime.format(calendar.getTime()));
		
	}

	public void setupDate(View v){
		new DatePickerDialog(TimeSetDemo.this, d,
				calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH)).show();
	}
	
	public void setupTime(View v){
		new TimePickerDialog(TimeSetDemo.this, t,
				calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE), true).show();
		
	}
	
	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, monthOfYear);
			calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateDT();
		}
	};
	
	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
			calendar.set(Calendar.MINUTE, minute);
			updateDT();
		}
	};

}
