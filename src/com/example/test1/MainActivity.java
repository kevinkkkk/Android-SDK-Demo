package com.example.test1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	String Classes[] = {"HttpTest", "SQLtest", "ExternalSDtest", "HandleTest", "SurfaceTest", "LifeCycle", "TouchTest", 
			"MPointTest","AccTest", "FullScreenTest", 
			"DrawTest", "BitmapTest", "extendViewTest", "LinearTest", "ListAdapterTest", "InteractiveList","TimeSetDemo", "AlertTest",
			"IntentCallTest"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String> (MainActivity.this, android.R.layout.simple_list_item_1, Classes));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try {
			Class OurClass = Class.forName("com.example.test1."+Classes[position]);
			Intent OurIntent = new Intent(MainActivity.this, OurClass);
			startActivity(OurIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.mymenu, menu);
		return true;
	}

	

	
}
