package com.weexcel.guestexpress.adapter; //Package Name

/**
 *
 * @author: WE Excel
 * This is the adapter class for the items selected in the cart
 *
 */


/*** Importing the required libraries and the classes ***/
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.weexcel.guestexpress.R;

/** Class Starts **/
public class MySelectionListAdapter extends BaseAdapter {

    /*** Declaring the Variables ***/
	LayoutInflater layoutInflater;
	Context context;
	TextView textView_Position;

    /*** Constructor of the Class - used to initialize the variables ***/
	public MySelectionListAdapter(Context context){
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
	}

    /***
     * An override method to get the count
     */

	@Override
	public int getCount()
	{
		return 2;
	}

    /***
     * An override method to get the position
     */

	@Override
	public Object getItem(int position)
    {
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
     * An override method to create the view
     */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null)  //checking whether the view is null or not
        {
            //if condition is true then the below statement is executed
			convertView = layoutInflater.inflate(R.layout.my_selectionlist_row_item, null);
		}
		textView_Position = (TextView) convertView.findViewById(R.id.tv_pos);  //defining the texView
		textView_Position.setText((position + 1)+"");  //showing / applying the position on the TextView
		return convertView; // view is returned
	}
}

/*** Class Ends here ***/
