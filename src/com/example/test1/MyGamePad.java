package com.example.test1;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyGamePad extends SurfaceView implements Runnable{
	SurfaceHolder MyHolder;
	Boolean isRunning = true;
	Thread t;
	
	public MyGamePad(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		MyHolder = this.getHolder();
		
	}
	
	public void pause(){
		isRunning = false;
		while (true){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
			
	}
	
	public void resume(){
		isRunning = true;
		t = new Thread(this);
		t.start();
	}
	

	@Override
	public void run() {
		Random rr = new Random();
		
		// TODO Auto-generated method stub
		while (isRunning){
			if (!MyHolder.getSurface().isValid()) continue;
		
		Canvas cc = MyHolder.lockCanvas();
		cc.drawRGB(rr.nextInt(254), rr.nextInt(254), rr.nextInt(254));
		MyHolder.unlockCanvasAndPost(cc);
		
		}
	}

	public void touch() {
		// TODO Auto-generated method stub
		if (isRunning){
			isRunning =false;
		}else{
			isRunning = true;
			t = new Thread(this);
			t.start();
		
		}
		
	}

}
 