package com.example.test1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SQLtest extends Activity implements OnClickListener{
	EditText Name, Hotness;
	boolean DidWork = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqltest);
		Button updateDB, viewDB;

		updateDB = (Button) findViewById(R.id.sUpdate);
		viewDB = (Button) findViewById (R.id.sView);
		Name = (EditText)findViewById(R.id.sName);
		Hotness = (EditText) findViewById(R.id.sHotness);
		updateDB.setOnClickListener(this);
		viewDB.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case (R.id.sUpdate):
		try{
			String inputName = Name.getText().toString();
			String inputHot = Hotness.getText().toString();
			HotorNot MyDb = new HotorNot(SQLtest.this);
			MyDb.open();
			MyDb.update(inputName, inputHot);
			MyDb.close();
			}
		catch (Exception e){
			DidWork = false;
			Dialog tt = new Dialog(this);
			tt.setTitle("Failed");
			TextView tv = new TextView(this);
			tv.setText(e.toString());
			tt.setContentView(tv);
			tt.show();
		}finally {
			if (DidWork) {
				Dialog tt = new Dialog(this);
				tt.setTitle("Sucess!!");
				TextView tv = new TextView(this);
				tv.setText("OK!!");
				tt.setContentView(tv);
				tt.show();
			}
			
		}
		break;
		
		case (R.id.sView):
			Intent i = new Intent("com.example.test1.DBView");
			startActivity(i);
			
			break;
				
		}
	}

}
