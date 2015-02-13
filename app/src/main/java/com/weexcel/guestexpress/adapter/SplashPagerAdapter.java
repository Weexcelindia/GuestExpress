package com.weexcel.guestexpress.adapter;  //Package Name

/**
 *
 * @author: WE Excel
 * This is the adapter class to create a PageView in Top Offers Today View
 *
 */

/*** Importing the required libraries and the classes ***/
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.weexcel.guestexpress.controller.fragment.SplashOneFragment;
import com.weexcel.guestexpress.controller.fragment.SplashThreeFragment;
import com.weexcel.guestexpress.controller.fragment.SplashTwoFragment;

/** Class Starts **/
public class SplashPagerAdapter extends FragmentPagerAdapter {

    /*** Declaring the Variables ***/
	private Context _context;
	public static int totalPage = 3;

    /*** Constructor of the Class - used to initialize the variables ***/
	public SplashPagerAdapter(Context context, FragmentManager fm) {
		super(fm);
		_context = context;
	}
	@Override
	public Fragment getItem(int position) {
		Fragment f = new Fragment();
		switch (position) {
		case 0:
			f = SplashOneFragment.newInstance(_context);
			break;
		case 1:
			f = SplashTwoFragment.newInstance(_context);
			break;
		case 2:
			f = SplashThreeFragment.newInstance(_context);
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
