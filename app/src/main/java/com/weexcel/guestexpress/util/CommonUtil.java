package com.weexcel.guestexpress.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.weexcel.guestexpress.R;

/**
 * Created by WE Excel
 * In this class some methods and variable are being declared to use through out the application to avoid code repetition
 */


public class CommonUtil {

    public static String roboto_regular = "Roboto-Regular_0.ttf";
    public static String roboto_light = "Roboto-Light.ttf";
    public static String segoeUI = "segoeui.ttf";

    static Dialog dialog;
    static Handler handler = new Handler();


    /***
     *
     * @param context
     * Method to showDialog
     */
    public static void showDialog(Context context) {
        if (dialog == null || !dialog.isShowing()) {

            LayoutInflater inflator = LayoutInflater.from(context);
            View v = inflator.inflate(R.layout.progressbar_dialog, null);
            final ProgressBar pr_sendorder = (ProgressBar) v
                    .findViewById(R.id.pr_sendorder);
            pr_sendorder.setMax(100);
            new Thread(new Runnable() {
                int i = 0;
                int progressStatus = 0;

                public void run() {
                    while (progressStatus <101) {
                        //progressStatus += doWork();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            public void run() {
                                System.out.println("progressstatus"+progressStatus);
                                if(progressStatus==100){
                                    dialog.dismiss();
                                }
                                pr_sendorder.setProgress(progressStatus);
                                progressStatus=progressStatus+5;
                            }
                        });
                    }
                }

                private int doWork() {

                    return i * 3;
                }

            }).start();

            dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = 500;
            dialog.show();
            dialog.getWindow().setAttributes(lp);
            dialog.setContentView(v);
        }
    }


}
