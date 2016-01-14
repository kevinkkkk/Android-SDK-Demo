package com.example.test1;

import java.util.concurrent.atomic.AtomicBoolean;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HandleTest extends Activity{
	ProgressBar bar;
	TextView th;
	Boolean isDone = false;
	AtomicBoolean isRunning = new AtomicBoolean();
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			if (isDone) th.setVisibility(View.VISIBLE);
			bar.incrementProgressBy(5);
			
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handletest);
		th = (TextView)findViewById(R.id.tHandle);
		bar = (ProgressBar)findViewById(R.id.progress);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		bar.setProgress(0);
		Thread bkrun = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for (int i = 0; i<20 && isRunning.get(); i++){
						Thread.sleep(200);
						handler.sendMessage(handler.obtainMessage());
						if (i==19)
							isDone = true;
					}
				}catch (Throwable t){
					
				}
			}
			
		});
		isRunning.set(true);
		bkrun.start();
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		isRunning.set(false);
		th.setVisibility(View.VISIBLE);
	}
	

}
