package com.weexcel.guestexpress.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weexcel.guestexpress.R;

public class ProductFragment extends Fragment {
	View _view;

	public static Fragment newInstance(Context context) {
		ProductFragment productFragment = new ProductFragment();
		return productFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		try {
			_view = inflater.inflate(R.layout.product_item, container, false);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return _view;
	}
}
