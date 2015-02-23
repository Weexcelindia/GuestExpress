package com.weexcel.guestexpress.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.weexcel.guestexpress.R;

/**
 * Created by Ankit on 18-Feb-15.
 */
public class BenchMarkListItemAdapter extends BaseAdapter {

    Context cnt;
    int count;
    LayoutInflater inflator;
    public BenchMarkListItemAdapter(Context cnt,int count){
        this.cnt=cnt;
        this.count=count;
        inflator=LayoutInflater.from(cnt);
    }
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        try{
            if(view==null){
                view=inflator.inflate(R.layout.choose_layout_row_item,null);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }
}
