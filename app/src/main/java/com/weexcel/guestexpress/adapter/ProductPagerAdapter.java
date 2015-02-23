package com.weexcel.guestexpress.adapter;   //Package Name

/**
 *
 * @author: WE Excel
 * This is the adapter class to create a PageView in Product Item View
 *
 */

/*** Importing the required libraries and the classes ***/
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.weexcel.guestexpress.controller.fragment.ProductFragment;
import com.weexcel.guestexpress.controller.fragment.ProductFragment2;
import com.weexcel.guestexpress.controller.fragment.ProductFragment3;

/** Class Starts **/
public class ProductPagerAdapter extends FragmentPagerAdapter {

    /*** Declaring the Variables ***/
	private Context _context;
	public static int totalPage = 3;

    /*** Constructor of the Class - used to initialize the variables ***/
	public ProductPagerAdapter(Context context, FragmentManager fm) {
		super(fm);
		_context = context;
	}


    /***
     * An override method to get the fragment and show the corresponding fragment
     */
	@Override
	public Fragment getItem(int position) {

		Fragment f = new Fragment();
		switch (position){
		case 0:
			f = ProductFragment.newInstance(_context);
			break;
		case 1:
			f = ProductFragment2.newInstance(_context);
			break;
		case 2:
			f = ProductFragment3.newInstance(_context);
			break;
		}
		return f;
	}

	@Override
	public int getCount() {
		return totalPage;
	}
}

/*** Class Ends here ***/
