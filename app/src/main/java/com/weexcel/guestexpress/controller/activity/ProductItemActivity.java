package com.weexcel.guestexpress.controller.activity; // Package Name

/**
 * @author: WE Excel
 * This class is used to display the fragment which has the details of the product
 */

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.weexcel.guestexpress.R;
import com.weexcel.guestexpress.adapter.ProductPagerAdapter;
import com.weexcel.guestexpress.util.CommonUtil;
import com.weexcel.guestexpress.util.applyfont.QuickFontManager;
import com.weexcel.guestexpress.view.CirclePageIndicator;

/*** Class Starts ***/
public class ProductItemActivity extends FragmentActivity {
	CirclePageIndicator circleIndicator;
	ViewPager pager;
	ProductPagerAdapter adapter;
	TextView tv_time, tv_room,tv_ingredients;
    RatingBar ratingBar;
    String product_name,product_extra,product_price;
    com.weexcel.guestexpress.util.applyfont.TextView tv_itemname,tv_itemextra,tv_itemprice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_item);
        if(savedInstanceState==null){
            product_name=getIntent().getStringExtra("product_name");
            product_extra=getIntent().getStringExtra("product_extra");
            product_price=getIntent().getStringExtra("product_price");
        }
        else{
            product_name=savedInstanceState.getString("product_name");
            product_extra=savedInstanceState.getString("product_extra");
            product_price=savedInstanceState.getString("product_price");
        }

        customActionBarFont(CommonUtil.roboto_light); // Method call to customize the action bar
        init(); // Initializing the UI and the variables

		tv_time.setText(Html.fromHtml("<font color='#888888'>"
				+ "time of delivery " + "</font>" + "<font color='#404040'>"
				+ " 10 " + "</font>" + "<font color='#888888'>" + " minutes"
				+ "</font>"));

		tv_room.setText(Html.fromHtml("<font color='#888888'>"
				+ "to room" + "</font>"));

		tv_ingredients.setText(Html.fromHtml("<font color='#404040'>"
				+ "Ingredients: " + "</font>"+"<font color='#888888'>"+"Tomato,Potato,Onion,Cheese,etc "+"</font>"));
    }

    /***
     * Takes back to the previous screen
     */

	@Override
	public void onBackPressed() {
		super.onBackPressed();
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
		// overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out); // Smooth animation for the back action of the screen
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        // Here we get the action view we defined
        MenuItem menuItem = menu.findItem(R.id.actionCart);
        View actionView = menuItem.getActionView();

        // We then get the edit text view that is part of the action view
        if (actionView != null) {

            LinearLayout linearLayout = (LinearLayout) actionView.findViewById(R.id.layoutCartNotification);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent openMySelections = new Intent(getApplicationContext(), MySelectionActivity.class);
                    openMySelections.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(openMySelections);
                 overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left);
                }
            });

        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    /***
     * User defined method to customize the ActionBar - apply the font on ActionBar Title
     * @param fontName
     * parameter used to set font of particluar fontfamily on view
     */

    public void customActionBarFont(String fontName)
    {
//        Typeface tf = QuickFontManager.getTypeface(getApplicationContext(), fontName).first;
//        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
//        TextView yourTextView = (TextView) findViewById(titleId);
//        yourTextView.setTypeface(tf);

//        SpannableString s = new SpannableString("Guest Express");
//        s.setSpan(new TypefaceSpan(fontName), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ActionBar actionBar = getActionBar();
//        actionBar.setTitle(s);
//
//        actionBar.setDisplayHomeAsUpEnabled(true);
//

        this.getActionBar().setHomeButtonEnabled(false);
        this.getActionBar().setDisplayShowHomeEnabled(false);
        this.getActionBar().setDisplayShowCustomEnabled(true);
        this.getActionBar().setDisplayShowTitleEnabled(false);

        LayoutInflater inflator = LayoutInflater.from(this);
        View v = inflator.inflate(R.layout.custom_actionbar, null);
        ImageView iconActionBar = (ImageView) v.findViewById(R.id.iconActionBar);
        //if you need to customize anything else about the text, do it here.
        //I'm using a custom TextView with a custom font in my layout xml so all I need to do is set title
        ((TextView)v.findViewById(R.id.title)).setText(this.getTitle());

        iconActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //assign the view to the actionbar
        this.getActionBar().setCustomView(v);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("product_name",product_name);
        outState.putString("product_extra",product_extra);
        outState.putString("product_price",product_price);
        super.onSaveInstanceState(outState);
    }

    /***
     *
     * User defined method to initialize the variable and the UI
     */
    public void init()
    {
        tv_itemname=(com.weexcel.guestexpress.util.applyfont.TextView)findViewById(R.id.tv_itemname);
        tv_itemextra=(com.weexcel.guestexpress.util.applyfont.TextView)findViewById(R.id.tv_itemextra);
        tv_itemprice=(com.weexcel.guestexpress.util.applyfont.TextView)findViewById(R.id.tv_itemprice);
        tv_itemname.setText(product_name);
        tv_itemextra.setText(product_extra);
        tv_itemprice.setText(product_price);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        circleIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        pager = (ViewPager) findViewById(R.id._pager);
        float density = getResources().getDisplayMetrics().density;
        circleIndicator.setFillColor(getResources().getColor(R.color.TorchRed));
        circleIndicator.setStrokeColor(getResources().getColor(R.color.textWhite));
        circleIndicator.setStrokeWidth(1);
        circleIndicator.setRadius(6 * density);
        adapter = new ProductPagerAdapter(this, getSupportFragmentManager());
        pager.setAdapter(adapter);
        circleIndicator.setViewPager(pager);
        tv_time = (TextView) findViewById(R.id.textView_Time);
        tv_room = (TextView) findViewById(R.id.tv_room);
        tv_ingredients = (TextView) findViewById(R.id.textView_Ingredients);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.buttonsbackground), PorterDuff.Mode.SRC_ATOP);
    }
}
/*** Class Ends ***/