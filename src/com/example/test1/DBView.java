package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DBView extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dbresult);
		TextView result = (TextView) findViewById(R.id.sqlResult);
		HotorNot ReadHelper = new HotorNot(this);
		ReadHelper.open();
		result.setText(ReadHelper.show());
		ReadHelper.close();
		
	}

}
