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
import android.widget.TextView;

import com.weexcel.guestexpress.R;
import com.weexcel.guestexpress.model.ProductItemData;

import java.util.ArrayList;

/**
 * Class Starts *
 */

public class MyListItemsAdapter extends BaseAdapter {

    /**
     * Declaring the Variables **
     */
    Context context;
    LayoutInflater layoutInflater;
    int count;
    com.weexcel.guestexpress.util.applyfont.TextView tv_itemname, tv_extra, tv_price;
    ArrayList<ProductItemData> list;
    /**
     * Constructor of the Class - used to initialize the variables **
     */
    public MyListItemsAdapter(Context context, ArrayList<ProductItemData> list) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    /**
     * An override method to get the count
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * An override method to get the position
     */

    @Override
    public Object getItem(int position) {
        return position;
    }

    /**
     * An override method to get the itemID
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * An override method to Create the View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {  //checking whether the view is null or not
            convertView = layoutInflater.inflate(R.layout.listview_row_item, null);
        }
            tv_itemname = (com.weexcel.guestexpress.util.applyfont.TextView) convertView.findViewById(R.id.tv_itemname);
            tv_extra = (com.weexcel.guestexpress.util.applyfont.TextView) convertView.findViewById(R.id.tv_extra);
            tv_price = (com.weexcel.guestexpress.util.applyfont.TextView) convertView.findViewById(R.id.tv_price);
            tv_itemname.setText(list.get(position).getItem_name());
            tv_extra.setText(list.get(position).getItem_extra());
            tv_price.setText(list.get(position).getItem_price());

        return convertView; //the view is returned
    }
}

/*** Class Ends here ***/
