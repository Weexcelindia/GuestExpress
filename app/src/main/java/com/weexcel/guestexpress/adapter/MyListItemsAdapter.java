package com.weexcel.guestexpress.adapter;   //Package Name

/**
 *
 * @author: WE Excel
 * This is the adapter class to show the top items
 *
 */


/*** Importing the required libraries and the classes ***/
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.weexcel.guestexpress.R;

/** Class Starts **/

public class MyListItemsAdapter extends BaseAdapter {

    /*** Declaring the Variables ***/
	Context context;
	LayoutInflater layoutInflater;
	String from;
    int count;

	/*** Constructor of the Class - used to initialize the variables ***/
    public MyListItemsAdapter(Context context, String from, int count)
    {
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
		this.from = from;
        this.count = count;
	}

    /***
     * An override method to get the count
     */
	@Override
	public int getCount() {
		return count;
	}

    /***
     * An override method to get the position
     */

	@Override
	public Object getItem(int position) {
		return position;
	}

    /***
     * An override method to get the itemID
     */
	@Override
	public long getItemId(int position) {
		return position;
	}

    /***
     * An override method to Create the View
     */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){  //checking whether the view is null or not
			if(from.equalsIgnoreCase("listview1"))  //checking the condition
            {
                //If condition matches the below layout is inflated otherwise it moves to else part
				convertView = layoutInflater.inflate(R.layout.listview_row_item, null);
			}
			else if(from.equalsIgnoreCase("listview2")) // checking the other condition
            {
                //If condition matches the below layout is inflated
				convertView = layoutInflater.inflate(R.layout.choose_layout_row_item, null);
			}
		}
		return convertView; //the view is returned
	}
}

/*** Class Ends here ***/
