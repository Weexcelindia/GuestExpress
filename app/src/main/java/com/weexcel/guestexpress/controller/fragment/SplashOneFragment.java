package com.weexcel.guestexpress.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weexcel.guestexpress.R;

public class SplashOneFragment extends Fragment {
	TextView name1, name2;
	View _view;
	public static Fragment newInstance(Context context) {
		SplashOneFragment splashOneFragment = new SplashOneFragment();
		return splashOneFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		try
		{
			 _view =inflater.inflate(
					R.layout.fragment_splash_one, container,false);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return _view;
	}

}
