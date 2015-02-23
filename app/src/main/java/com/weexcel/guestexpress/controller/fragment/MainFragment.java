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
import com.weexcel.guestexpress.adapter.BenchMarkListItemAdapter;
import com.weexcel.guestexpress.adapter.MyListItemsAdapter;
import com.weexcel.guestexpress.adapter.SplashPagerAdapter;
import com.weexcel.guestexpress.controller.activity.MySelectionActivity;
import com.weexcel.guestexpress.controller.activity.ProductItemActivity;
import com.weexcel.guestexpress.model.ProductItemData;
import com.weexcel.guestexpress.view.CirclePageIndicator;
import com.weexcel.guestexpress.view.NestedListView;

import java.util.ArrayList;

/*** Class Starts ***/
public class MainFragment extends Fragment {
    NestedListView crewList, benchmarksList;
    CirclePageIndicator circleIndicator;
    ViewPager pager;
    SplashPagerAdapter splashPagerAdapter;
    LinearLayout btnProduct, btnMySelection, btnSettings;
    static int count2 = 4;

    LinearLayout main_layout;

    ProgressBar progressBar1;

    //crewlistview item adapter to show data on crewlist
    MyListItemsAdapter myListItemsAdapter;

    //benchmarklistview item adapter to show data on benchmarklist
    BenchMarkListItemAdapter mybenchmarkadapter;

    //productlist containing data to display on crewlist
    ArrayList<ProductItemData> productlistdata=new ArrayList<ProductItemData>();

    String itemname[]={"Corn Pizaa","Spicey Pizaa","Tomato Pizaa","Onion Pizaa","Potato Pizaa","Carrot Pizaa","Mix Pizaa","Hot Pizaa"};

    String item_extra[]={"with chees","with chees","with chees","with chees","with chees","with chees","with chees","with chees"};

    String price[]={"£11","£12","£13","£14","£15","£16","£17","£18"};

    String product_name,product_extra,product_price;
    public MainFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);

        initUI(rootView); //intialize UI Views

        productlistdata.clear();

        //crewList header view
        View v = inflater.inflate(R.layout.listview_header, null);

        final TextView listview_header = (TextView) v.findViewById(R.id.listview_header);
        listview_header.setText(R.string.our_top_items);

        //crewList, Top Items Listview of main screen
        crewList = (NestedListView) rootView.findViewById(R.id.crewList);
        crewList.addHeaderView(v);

        //crewlist footer view
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
                                main_layout.setVisibility(View.VISIBLE);
                                progressBar1.setVisibility(View.GONE);
                                if(productlistdata.size()<itemname.length){
                                    int sizee=productlistdata.size();
                                    for(int i=sizee;i<=sizee+3;i++){
                                        System.out.println("ival"+i);
                                        ProductItemData data=new ProductItemData();
                                        data.setItem_name(itemname[i]);
                                        data.setItem_extra(item_extra[i]);
                                        data.setItem_price(price[i]);
                                        productlistdata.add(data);
                                    }
                                    crewList.setAdapter(null);
                                    myListItemsAdapter = new MyListItemsAdapter(getActivity(),productlistdata);
                                    crewList.setAdapter(myListItemsAdapter);
                                }
                            }
                        });
                    }
                }).start();
            }
        });
        crewList.addFooterView(crewlistview_footer);
        for(int i=0;i<4;i++){
            ProductItemData data=new ProductItemData();
            data.setItem_name(itemname[i]);
            data.setItem_extra(item_extra[i]);
            data.setItem_price(price[i]);
            productlistdata.add(data);
        }
        myListItemsAdapter = new MyListItemsAdapter(getActivity(),productlistdata);
        crewList.setAdapter(myListItemsAdapter);

        //benchmarkList, Also choose from listview of main screen
        benchmarksList = (NestedListView) rootView.findViewById(R.id.benchmarksList);


        //benchmarklist header view
        View view = inflater.inflate(R.layout.listview_header, null);

        TextView benchmark_header = (TextView) view.findViewById(R.id.listview_header);
        benchmark_header.setText(R.string.also_choose_from);

        benchmarksList.addHeaderView(view);

        //benchmarklist footer view
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
                               mybenchmarkadapter = new BenchMarkListItemAdapter(
                                       getActivity(),count2);
                               benchmarksList.setAdapter(mybenchmarkadapter);
                           }
                       });
                    }
                }).start();
            }
        });

        benchmarksList.addFooterView(benchmarklistview_footer);
        mybenchmarkadapter = new BenchMarkListItemAdapter(
                getActivity(),count2);

        benchmarksList.setAdapter(mybenchmarkadapter);

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
                product_name=productlistdata.get(i-1).getItem_name();
                product_extra=productlistdata.get(i-1).getItem_extra();
                product_price=productlistdata.get(i-1).getItem_price();
                openProductActivity();
            }
        });

        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_name=productlistdata.get(0).getItem_name();
                product_extra=productlistdata.get(0).getItem_extra();
                product_price=productlistdata.get(0).getItem_price();
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
     * method to intialize ui interface
     * @param rootView
     * the parent view to register the child view items
     */
    private void initUI(View rootView) {

        btnProduct = (LinearLayout) rootView.findViewById(R.id.layoutButtonProduct);
        btnMySelection = (LinearLayout) rootView.findViewById(R.id.layoutButtonMySelection);
        btnSettings = (LinearLayout) rootView.findViewById(R.id.layoutButtonSettings);
    }

    /***
     * User defined method to open the Intent of ProductItemActivity with the smooth transition
     */
    public void openProductActivity()
    {
        Intent openProduct = new Intent(getActivity(), ProductItemActivity.class);
        openProduct.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        openProduct.putExtra("product_name",product_name);
        openProduct.putExtra("product_extra",product_extra);
        openProduct.putExtra("product_price",product_price);
        startActivity(openProduct);
        getActivity().overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left);

    }

    /***
     * User defined method to open the Intent of My Selection Activity with the smooth transition
     */

    public void openMySelectionsActivity()
    {
        Intent openMySelections = new Intent(getActivity(), MySelectionActivity.class);
        openMySelections.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(openMySelections);
        getActivity().overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left);
    }
}

/*** Class Ends ***/
