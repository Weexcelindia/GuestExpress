package com.weexcel.guestexpress.controller.activity; // package name

/***
 * @author: WE Excel
 * This class is used to call the fragment which shows the items selected i.e. added in the cart
 */

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.weexcel.guestexpress.R;
import com.weexcel.guestexpress.controller.fragment.MySelectionFragment;
import com.weexcel.guestexpress.util.CommonUtil;
import com.weexcel.guestexpress.util.applyfont.QuickFontManager;

/*** Class Starts ***/
public class MySelectionActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_common);
        customActionBarFont(CommonUtil.roboto_light); // Method call to customize the actionbar

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.commonContainer, new MySelectionFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home)
        {
            onBackPressed(); // if icon in the actionbar is clicked it takes back to the previous screen
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
//        s.setSpan(new ForegroundColorSpan(R.color.textWhite), 0, s.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        ActionBar actionBar = getActionBar();
//        actionBar.setTitle(s);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);


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
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
    }
}

/*** Class Ends ***/
