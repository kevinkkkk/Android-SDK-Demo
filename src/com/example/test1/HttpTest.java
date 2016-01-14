package com.example.test1;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class HttpTest extends Activity{
	
	HttpClient client;
	final String URL="http://api.twitter.com/1/statuses/user_timeline.json";

	TextView httpstuff;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
		setContentView(R.layout.http_test);
		httpstuff = (TextView)findViewById(R.id.tv);
		client = new DefaultHttpClient();
		/*GetHttpEx gh = new GetHttpEx();
		String result;
		try {
			result = gh.getInternetData();
			httpstuff.setText(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}
	
	
	

}
