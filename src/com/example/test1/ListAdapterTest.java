package com.example.test1;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapterTest extends ListActivity{
	
	final static String[] list ={"ew","dsdsd","fdfg","dsds","dsds","jhgjh","uyuy","dsdsd","fdfg","dsds",
		"dsds","jhgjh","uyuy","ew","dsdsd","fdfg","dsds","dsds","jhgjh","uyuy","ew","dsdsd","fdfg","dsds","dsds","jhgjh","uyuy","ew","dsdsd","fdfg","dsds","dsds","jhgjh","uyuy"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new MyAdapter(this, R.layout.listview, R.id.tvList, list));
		
	}
	
	private class MyAdapter extends ArrayAdapter<String>{

		public MyAdapter(Context context, int resource, int textViewResourceId,
				String[] list) {
			super(context, resource, textViewResourceId, list);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			//View v= super.getView(position, convertView, parent);
			ViewHolder holder;
			View v = convertView;
			//ViewHolder holder=(ViewHolder)v.getTag();
			if (v==null){
				
				
				LayoutInflater flater = getLayoutInflater();
				v = flater.inflate(R.layout.listview, parent, false);
				
				holder = new ViewHolder(v);
				v.setTag(holder);
			
			//TextView tv = (TextView)v.findViewById(R.id.tvList);
			holder.tv.setText(list[position]);
			
			//ImageView icon = (ImageView)v.findViewById(R.id.imageView1);
			if ((position%4)==0){
				holder.icon.setImageResource(R.drawable.kevin);
			}
			}
			return v;
			
		}
		
		private class ViewHolder {
			ImageView icon = null;
			TextView tv=null;
			
			ViewHolder(View v){
				this.icon = (ImageView)v.findViewById(R.id.imageView1);
				this.tv = (TextView)v.findViewById(R.id.tvList);
			}
		}
		
		
		
	}

}
