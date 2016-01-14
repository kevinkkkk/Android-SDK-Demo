package com.example.test1;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class InteractiveList extends ListActivity{
	final static String[] list ={"ew","dsdsd","fdfg","dsds","dsds","jhgjh","uyuy","dsdsd","fdfg","dsds",
		"dsds","jhgjh","uyuy","ew","dsdsd","fdfg","dsds","dsds","jhgjh","uyuy","ew","dsdsd","fdfg","dsds","dsds","jhgjh","uyuy","ew","dsdsd","fdfg","dsds","dsds","jhgjh","uyuy"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ArrayList<AList> newList =new ArrayList<AList>();
		for (String s:list){
			newList.add(new AList(s));
		}
		
		setListAdapter(new InteractiveListAdapter(this, R.layout.interactivelist, R.id.label, newList));
	}
	
	public AList getItem(int position){
		return (((InteractiveListAdapter)getListAdapter()).getItem(position));
	}
	
	
class InteractiveListAdapter extends ArrayAdapter<AList>{

	public InteractiveListAdapter(Context c, int r1, int r2, ArrayList<AList> newList){
		super(c, r1, r2, newList);
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row=super.getView(position, convertView, parent);
		ViewHolder vh = (ViewHolder)row.getTag();
		
		RatingBar.OnRatingBarChangeListener l = new RatingBar.OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				// TODO Auto-generated method stub
				Integer myPosition = (Integer)ratingBar.getTag();
				AList one = getItem(myPosition);
				one.ratting=rating;
				
				LinearLayout parent = (LinearLayout)ratingBar.getParent();
				TextView item = (TextView)parent.findViewById(R.id.label);
				item.setText(one.toString());
				
			}
		};
		
		if (vh==null){
			vh = new ViewHolder(row);
			row.setTag(vh);
			vh.rate.setOnRatingBarChangeListener(l);	
		}
		
		AList one = getItem(position);
		vh.rate.setTag(position);
		vh.rate.setRating(one.ratting);
		
		return(row);
		
	}
	
	
	
}
	
class AList{
	String label;
	float ratting = 2.0f;
	
	public AList(String s){
		this.label=s;
		
	}
	
	@Override
	public String toString(){
		if (ratting>=3.0f)
			return (label.toUpperCase());
		return (label);
	}
	
	
	
}

private class ViewHolder {
	
	RatingBar rate=null;
	
	ViewHolder(View v){
		
		this.rate = (RatingBar)v.findViewById(R.id.rates);
	}
}
	

}
