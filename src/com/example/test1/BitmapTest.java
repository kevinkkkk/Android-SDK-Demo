package com.example.test1;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public abstract class BitmapTest extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (getStart()){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}
			setContentView(new MyView(this));
		
	}
	
	public abstract boolean getStart();
	
	class MyView extends View{

		Bitmap bm1, bm2;
		Rect dst = new Rect();
		
		public MyView (Context bt) {
			// TODO Auto-generated constructor stub
			super(bt);
			AssetManager am = bt.getAssets();
			InputStream is;
			try {
				is = am.open("background.png");
				bm1 = BitmapFactory.decodeStream(is);
				is.close();
				Log.d("BitmapText", "background.png format: "+bm1.getConfig());
				
				is = am.open("background.png");
				BitmapFactory.Options op = new BitmapFactory.Options();
				op.inPreferredConfig = Bitmap.Config.RGB_565;
				bm2 = BitmapFactory.decodeStream(is, null, op);
				is.close();
				Log.d("Bitmap Text", "background.png format: "+bm2.getConfig());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			dst.set(50, 50, 700, 1000);
			canvas.drawBitmap(bm1, null, dst, null);
			canvas.drawBitmap(bm2, 100, 100, null);
			invalidate();
		}
		
	
		
	}
	
	

}
