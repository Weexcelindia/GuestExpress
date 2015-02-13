package com.weexcel.guestexpress.controller.fragment; // package name

/***
 * @author: WE Excel
 * This class contains the Main Fragment of the Main Screen
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.weexcel.guestexpress.R;
import com.weexcel.guestexpress.adapter.MyListItemsAdapter;
import com.weexcel.guestexpress.adapter.SplashPagerAdapter;
import com.weexcel.guestexpress.controller.activity.MySelectionActivity;
import com.weexcel.guestexpress.controller.activity.ProductItemActivity;
import com.weexcel.guestexpress.view.CirclePageIndicator;
import com.weexcel.guestexpress.view.NestedListView;

/*** Class Starts ***/
public class MainFragment extends Fragment {
    NestedListView crewList, benchmarksList;
    CirclePageIndicator circleIndicator;
    ViewPager pager;
    SplashPagerAdapter splashPagerAdapter;
    LinearLayout btnProduct, btnMySelection, btnSettings;
    static int count1 = 4;
    static int count2 = 4;
    LinearLayout main_layout;
    ProgressBar progressBar1;
    MyListItemsAdapter myListItemsAdapter;

    public MainFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);
        initUI(rootView);

        View v = inflater.inflate(R.layout.listview_header, null);
        final TextView listview_header = (TextView) v.findViewById(R.id.listview_header);
        listview_header.setText(R.string.our_top_items);
        crewList = (NestedListView) rootView.findViewById(R.id.crewList);
        crewList.addHeaderView(v);
        View crewlistview_footer = getActivity().getLayoutInflater().inflate(
                R.layout.listview_crew_footer, null);
        main_layout = (LinearLayout) crewlistview_footer
                .findViewById(R.id.main_layout);
        progressBar1 = (ProgressBar) crewlistview_footer
                .findViewById(R.id.progressBar1);
        crewlistview_footer.setOnClickListener(new View.OnClickListener() {

            /*** Loading the more Items ***/

            @Override
            public void onClick(View v) {
                main_layout.setVisibility(View.GONE);
                progressBar1.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run() {
                                count1 = count1 + 4;
                                main_layout.setVisibility(View.VISIBLE);
                                progressBar1.setVisibility(View.GONE);
                                myListItemsAdapter = new MyListItemsAdapter(getActivity(), "listview1", count1);
                                crewList.setAdapter(myListItemsAdapter);
                            }
                        });
                    }
                }).start();
            }
        });

        crewList.addFooterView(crewlistview_footer);

        myListItemsAdapter = new MyListItemsAdapter(getActivity(),"listview1",count1);
        crewList.setAdapter(myListItemsAdapter);
        benchmarksList = (NestedListView) rootView.findViewById(R.id.benchmarksList);
        View view = inflater.inflate(R.layout.listview_header, null);
        TextView benchmark_header = (TextView) view.findViewById(R.id.listview_header);
        benchmark_header.setText(R.string.also_choose_from);
        benchmarksList.addHeaderView(view);
        View benchmarklistview_footer = getActivity().getLayoutInflater().inflate(
                R.layout.listview_benchmark_footer, null);
        final LinearLayout main_layoutt = (LinearLayout) benchmarklistview_footer
                .findViewById(R.id.main_layout);
        final ProgressBar progressBarr = (ProgressBar) benchmarklistview_footer
                .findViewById(R.id.progressBar1);
        benchmarklistview_footer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                main_layoutt.setVisibility(View.GONE);
                progressBarr.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       getActivity().runOnUiThread(new Runnable() {

                           @Override
                           public void run() {
                               main_layoutt.setVisibility(View.VISIBLE);
                               progressBarr.setVisibility(View.GONE);
                               count2 = count2 + 4;
                               benchmarksList.setAdapter(null);
                               myListItemsAdapter = new MyListItemsAdapter(
                                       getActivity(), "listview2", count2);
                               benchmarksList.setAdapter(myListItemsAdapter);
                           }
                       });
                    }
                }).start();
            }
        });

        benchmarksList.addFooterView(benchmarklistview_footer);
        MyListItemsAdapter benchmarkadapter = new MyListItemsAdapter(getActivity(), "listview2",count2);
        benchmarksList.setAdapter(benchmarkadapter);
        circleIndicator = (CirclePageIndicator) rootView.findViewById(R.id.indicator);
        float density = getResources().getDisplayMetrics().density;
        circleIndicator.setFillColor(getResources().getColor(R.color.TorchRed));
        circleIndicator.setStrokeColor(getResources().getColor(R.color.textWhite));
        circleIndicator.setStrokeWidth(1);
        circleIndicator.setRadius(6 * density);
        pager = (ViewPager) rootView.findViewById(R.id._pager);
        splashPagerAdapter = new SplashPagerAdapter(getActivity(), getFragmentManager());
        pager.setAdapter(splashPagerAdapter);
        circleIndicator.setViewPager(pager);

        crewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openProductActivity();
            }
        });

        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProductActivity();
            }
        });

        btnMySelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMySelectionsActivity();
            }
        });

        return rootView;
    }

    /**
     *
     * @param rootView
     * User defined method to initialize the variables and UI
     */
    private void initUI(View rootView) {

        btnProduct = (LinearLayout) rootView.findViewById(R.id.layoutButtonProduct);
        btnMySelection = (LinearLayout) rootView.findViewById(R.id.layoutButtonMySelection);
        btnSettings = (LinearLayout) rootView.findViewById(R.id.layoutButtonSettings);
    }

    /***
     *
     * @param listView
     * User defined method to set the height of ListView
     */

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth,
                        100));

            view.measure(desiredWidth, 100);
            totalHeight = view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    /***
     * User defined method to open the Intent of ProductItemActivity with the smooth transition
     */
    public void openProductActivity()
    {
        Intent openProduct = new Intent(getActivity(), ProductItemActivity.class);
        openProduct.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(openProduct);
        getActivity().overridePendingTransition(R.anim.push_up_out, R.anim.push_up_in);
    }

    /***
     * User defined method to open the Intent of My Selection Activity with the smooth transition
     */

    public void openMySelectionsActivity()
    {
        Intent openMySelections = new Intent(getActivity(), MySelectionActivity.class);
        openMySelections.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openMySelections);
        getActivity().overridePendingTransition(R.anim.push_up_out, R.anim.push_up_in);
    }

}

/*** Class Ends ***/
