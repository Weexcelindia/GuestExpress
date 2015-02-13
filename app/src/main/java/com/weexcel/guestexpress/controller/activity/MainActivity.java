package com.weexcel.guestexpress.controller.activity; //Package Name

/**
 * @author: WE Excel
 * This is the Main Activity Class which runs first (Main Screen of the Application)
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
                    overridePendingTransition(R.anim.push_up_out, R.anim.push_up_in);
                }
            });

        }
        return super.onCreateOptionsMenu(menu);
    }

    /***
     *
     * @param fontName
     * User defined method to customize the ActionBar - apply the font on ActionBar Title
     */

    public void customActionBarFont(String fontName)
    {
        Typeface tf = QuickFontManager.getTypeface(getApplicationContext(), fontName).first;
        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView yourTextView = (TextView) findViewById(titleId);
        yourTextView.setTypeface(tf);
    }


}

/*** Class Ends ***/
