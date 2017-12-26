package com.rz.varnishview.spinallistdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rasel on 2017-12-26.
 */

public class SpinalRowDrawerDraw {
    //|------------------------------------------------------------|
    private Activity activity;
    private Context context;
    public SpinalToolBar spinalToolBar = new SpinalToolBar();
    public SpinalDrawerMenu spinalDrawerMenu = new SpinalDrawerMenu();

    //|------------------------------------------------------------|
    public SpinalRowDrawerDraw(Activity argActivity, Context argContext) {
        this.activity = argActivity;
        this.context = argContext;
    }

    //|------------------------------------------------------------|
    //|------------------------------------------------------------|
    public class SpinalToolBar {
        /*
        //|USAGES: SpinalRowDrawerDraw.SpinalToolBar spinalToolBar = spinalRowDrawerDraw.new SpinalToolBar();
        */
        private Toolbar spinalToolBar;
        private ActionBar actionBar;

        public SpinalToolBar initToolBar(Toolbar argSpinalToolBar) {
            this.spinalToolBar = argSpinalToolBar;
            return this;
        }

        public SpinalToolBar onHideActionBar() {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null)
                actionBar.hide();
            return this;
        }

        public SpinalToolBar onSetActionBar() {
            if (spinalToolBar != null) {
                ((AppCompatActivity) activity).setSupportActionBar(spinalToolBar);
            }
            actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            return this;
        }

        public SpinalToolBar onSetTitleText(String argTitle) {
            /*if (spinalToolBar != null) {
                spinalToolBar.setTitle(argTitle);
            } else {
                ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (actionBar != null) {
                    actionBar.setTitle(argTitle);
                }
            }*/
            if (actionBar != null) {
                actionBar.setTitle(argTitle);
            }
            return this;
        }

        public SpinalToolBar onSetTitleTextColor(String argHtmlColorCode) {
            //"#ffffff"
            //spinalToolBar.setTitleTextColor(Color.parseColor(argHtmlColorCode));
            if (spinalToolBar != null) {
                spinalToolBar.setTitleTextColor(Color.parseColor(argHtmlColorCode));
            }
            return this;
        }

        public SpinalToolBar onSetSubTitleText(String argSubTitle) {
            /*if (spinalToolBar != null) {
                //spinalToolBar.setTitle(argTitle);
                spinalToolBar.setSubtitle(argSubTitle);
            } else {
                ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (actionBar != null) {
                    //actionBar.setTitle(argTitle);
                    actionBar.setSubtitle(argSubTitle);
                }
            }*/
            if (actionBar != null) {
                //actionBar.setTitle(argTitle);
                actionBar.setSubtitle(argSubTitle);
            }
            return this;
        }

        public SpinalToolBar onSetSubTitleTextColor(String argHtmlColorCode) {
            //"#ffffff"
            if (spinalToolBar != null) {
                spinalToolBar.setSubtitleTextColor(Color.parseColor(argHtmlColorCode));
            }
            return this;
        }

        public SpinalToolBar onShowHomeButton() {
            /*((AppCompatActivity) activity).getSupportActionBar().setHomeButtonEnabled(true);
            ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
            if (actionBar != null) {
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
            return this;
        }

        public SpinalToolBar onSetBackgroundColor(String argHtmlColorCode) {
            //"#80000000"
            ((AppCompatActivity) activity).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(argHtmlColorCode)));
            return this;
        }

        public SpinalToolBar onSetElevation(int argElevation) {
            //0
            ((AppCompatActivity) activity).getSupportActionBar().setElevation(argElevation);
            return this;
        }

        public SpinalToolBar onSetStatusBarDark(boolean argIsDark) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                View decor = activity.getWindow().getDecorView();
                if (!argIsDark) {
                    decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                } else {
                    // We want to change tint color to white again.
                    // You can also record the flags in advance so that you can turn UI back completely if
                    // you have set other flags before, such as translucent or full screen.
                    decor.setSystemUiVisibility(0);
                }
            }
            return this;
        }

        public SpinalToolBar onSetNavigationOnClickListener(View.OnClickListener argOnClickListener) {
            if (spinalToolBar != null && argOnClickListener != null) {
                spinalToolBar.setNavigationOnClickListener(argOnClickListener);
                System.out.println("DEBUG");
            }
            return this;
        }
    }

    //|------------------------------------------------------------|
    public class SpinalDrawerMenu {
        /*
        //|USAGES: SpinalRowDrawerDraw.SpinalDrawerMenu spinalDrawerMenu = spinalRowDrawerDraw.new SpinalDrawerMenu();
        */
    }
    //|------------------------------------------------------------|
    //|------------------------------------------------------------|
}
