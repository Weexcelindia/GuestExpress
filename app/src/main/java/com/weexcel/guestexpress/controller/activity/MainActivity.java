package com.weexcel.guestexpress.controller.activity; //Package Name

/**
 * @author: WE Excel
 * This is the Main Activity Class which runs first (Main Screen of the Application)
 */

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.weexcel.guestexpress.R;
import com.weexcel.guestexpress.controller.fragment.MainFragment;
import com.weexcel.guestexpress.util.CommonUtil;
import com.weexcel.guestexpress.util.applyfont.QuickFontManager;


/*** Class Starts ***/
public class MainActivity extends FragmentActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_common);
        customActionBarFont(CommonUtil.roboto_light);   // Customizing the action bar by calling the method

        /*** Opening the fragment connected to this Activity Class ***/
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.commonContainer, new MainFragment()).commit();
        }
    }

    /**
     *
     *
     * @param menu
     * @return
     * Method to create and inflate the Menu in the actionbar
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        // Here we get the action view we defined
        MenuItem menuItem = menu.findItem(R.id.actionCart);
        View actionView = menuItem.getActionView();

        // We then get the edit text view that is part of the action view
        if (actionView != null) {
            // Getting the layout which contains the Cart View
            LinearLayout linearLayout = (LinearLayout) actionView.findViewById(R.id.layoutCartNotification);
            linearLayout.setOnClickListener(new View.OnClickListener() {

                // If the cart is clicked then perform the following
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

    /***
     * User defined method to customize the ActionBar - apply the font on ActionBar Title
     * @param fontName
     * parameter used to set font of particluar fontfamily on view
     */

    public void customActionBarFont(String fontName)
    {
        this.getActionBar().setHomeButtonEnabled(false);
        this.getActionBar().setDisplayShowHomeEnabled(false);
        this.getActionBar().setDisplayShowCustomEnabled(true);
        this.getActionBar().setDisplayShowTitleEnabled(false);

        LayoutInflater inflator = LayoutInflater.from(this);
        View v = inflator.inflate(R.layout.custom_actionbar, null);


        //if you need to customize anything else about the text, do it here.
        //I'm using a custom TextView with a custom font in my layout xml so all I need to do is set title
        ((TextView)v.findViewById(R.id.title)).setText(this.getTitle());



        //assign the view to the actionbar
        this.getActionBar().setCustomView(v);
    }
}

/*** Class Ends ***/
