package com.weexcel.guestexpress.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weexcel.guestexpress.R;

public class SplashTwoFragment extends Fragment {
	View _view;
	TextView name1, name2;
	public static Fragment newInstance(Context context) {
		SplashTwoFragment splashTwoFragment = new SplashTwoFragment();

		return splashTwoFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		try {
			_view = inflater.inflate(R.layout.fragment_splash_two,container,false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return _view;

	}

}
