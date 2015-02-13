package com.weexcel.guestexpress.controller.fragment; //Package name

/***
 * @author: WE Excel
 * Within this class the My Selection Screen is being Managed
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.weexcel.guestexpress.R;
import com.weexcel.guestexpress.adapter.MySelectionListAdapter;
import com.weexcel.guestexpress.util.CommonUtil;


public class MySelectionFragment extends Fragment {
    ListView listView_ProductList;
    LinearLayout btnGetThis;

    public MySelectionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_selection, container, false);
        initUI(rootView);

        MySelectionListAdapter adapter=new MySelectionListAdapter(getActivity());
        listView_ProductList.setAdapter(adapter);

        btnGetThis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtil.showDialog(getActivity());
            }
        });

        return rootView;
    }

    /***
     *
     * @param rootView
     * User Defined method to initialize the UI and the variables
     */
    private void initUI(View rootView) {
        listView_ProductList = (ListView) rootView.findViewById(R.id.lv_productlist);
        btnGetThis = (LinearLayout) rootView.findViewById(R.id.layoutButtonGetThis);
    }
}
