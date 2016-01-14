package com.example.test1;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class AsyncTaskTest extends ListActivity{
	private String[] list = {"jjjj","dddd","kkkk","dddd","cccc","ffff","xzxz",
							"pppp","3232","dwdwe"};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, 
				new ArrayList<String>()));
		
		new addStringTask().execute();
		
	}
	
	class addStringTask extends AsyncTask <Void,String,Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			for (String item:list){
				publishProgress(item);
				SystemClock.sleep(200);
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			Toast.makeText(AsyncTaskTest.this, "Done!!!", Toast.LENGTH_LONG).show();
		}

		@Override
		protected void onProgressUpdate(String... values) {
			// TODO Auto-generated method stub
			((ArrayAdapter)getListAdapter()).add(values);
		}
		
		
	}
	
	

}
