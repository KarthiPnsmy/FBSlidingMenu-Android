package com.anubavam.fb_menu;


import java.util.Random;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class ContentFragment extends Fragment {
	
	private String titleText = "NONE";
	
	/*
	public ContentFragment() { 
		this(R.color.white);
	}
	*/
	public ContentFragment(String txt) {
		 titleText = txt;
		//mColorRes = colorRes;
		//setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/*
		if (savedInstanceState != null)
			mColorRes = savedInstanceState.getInt("mColorRes");
		int color = getResources().getColor(mColorRes);
		*/
		// construct the RelativeLayout
		RelativeLayout v = new RelativeLayout(getActivity());
		TextView tv = new TextView(getActivity());
		tv.setText(titleText+" Fragment");
		tv.setTextSize(18);
		v.setGravity(Gravity.CENTER);
		
		Random rnd = new Random(); 
		int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));  
		
		v.setBackgroundColor(color);	
		v.addView(tv);
		
		return v;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		//outState.putInt("mColorRes", mColorRes);
	}
}
