package com.weexcel.guestexpress.controller.activity; // package name

/***
 * @author: WE Excel
 * This class is used to call the fragment which shows the items selected i.e. added in the cart
 */

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
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
     *
     * @param fontName
     * User defined method to customize the ActionBar - apply the font on ActionBar Title and showing the home up button
     */

    public void customActionBarFont(String fontName)
    {
        Typeface tf = QuickFontManager.getTypeface(getApplicationContext(), fontName).first;
        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
        TextView yourTextView = (TextView) findViewById(titleId);
        yourTextView.setTypeface(tf);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }
}

/*** Class Ends ***/
