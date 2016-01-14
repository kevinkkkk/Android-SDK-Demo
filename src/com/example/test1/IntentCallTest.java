package com.example.test1;

import java.net.URI;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class IntentCallTest extends Activity implements OnClickListener{
	
	Button pick;
	TextView name, number;
	final static int PICK_REQUEST=34355;
	Uri contact=null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.callintent);
		pick = (Button)findViewById(R.id.contactPicker);
		name = (TextView)findViewById(R.id.contactName);
		number = (TextView)findViewById(R.id.contactNumber);
		pick.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
		startActivityForResult(i, PICK_REQUEST);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==PICK_REQUEST){
			if(resultCode==RESULT_OK){
				contact = data.getData();
				String contacts;;       
				       
				Cursor cursor = managedQuery(contact, null, null, null, null);                 
				String textContacts = "";                 
				if (cursor.moveToFirst()) {         
				           
				    do {          
				        textContacts = textContacts + cursor.getString(cursor.getColumnIndex("NAME")) + " : " + cursor.getString(cursor.getColumnIndex("NUMBER")) + "\n";         
				    } while (cursor.moveToNext()); 
				name.setText(textContacts);
				}
			}
		}
	}
	
	
	

}
