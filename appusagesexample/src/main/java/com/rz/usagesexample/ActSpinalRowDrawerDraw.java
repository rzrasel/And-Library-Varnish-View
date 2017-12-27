package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rz.usagesexample.fragment.FirstFragment;
import com.rz.usagesexample.fragment.SecondFragment;
import com.rz.varnishview.spinallistdrawer.ModelDrawerList;
import com.rz.varnishview.spinallistdrawer.SpinalRowDrawerDraw;
import com.rz.varnishview.spinallistdrawer.adapter.SharkArrayAdapter;
import com.rz.varnishview.spinallistdrawer.adapter.SharkModelRowScope;
import com.rz.varnishview.spinallistdrawer.adapter.SharkModelRowViewFields;

import java.util.ArrayList;
import java.util.HashMap;

public class ActSpinalRowDrawerDraw extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private Toolbar sysToolBar;
    private SpinalRowDrawerDraw spinalRowDrawerDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_spinal_row_drawer_draw);
        activity = this;
        context = this;
        sysToolBar = (Toolbar) findViewById(R.id.sysToolBar);
        spinalRowDrawerDraw = new SpinalRowDrawerDraw(activity, context);
        spinalRowDrawerDraw.spinalToolBar.onHideActionBar()
                .initToolBar(sysToolBar)
                .onSetActionBar()
                .onSetTitleText("Spinal Row Drawer")
                .onSetTitleTextColor("#ffffff")
                .onSetSubTitleText("Sub Title")
                .onSetSubTitleTextColor("#000000")
                .onSetTitleFont("fonts/alex-brush-regular.ttf")
                .onSetSubTitleFont("fonts/lobster-1.3.otf")
                .onShowHomeButton()
                .onSetStatusBarDark(false);
        /*sysToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argView) {
                System.out.println("DEBUG_ID: ");
            }
        });*/
        //|------------------------------------------------------------|
        //|------------------------------------------------------------|
        ListView sysDrawerList;
        SharkArrayAdapter adapterDrawerListAdapter;
        ArrayList<SharkModelRowViewFields> rowViewFieldListItems = new ArrayList<SharkModelRowViewFields>();
        ArrayList<SharkModelRowScope> modelDrawerListItems = new ArrayList<SharkModelRowScope>();
        sysDrawerList = (ListView) findViewById(R.id.sysDrawerList);
        HashMap<String, String> eachRowDataItems = null;
        eachRowDataItems = new HashMap();
        eachRowDataItems.put("sysDrawerTitle", "Title-01");
        eachRowDataItems.put("sysDrawerDescription", "Description-01");
        spinalRowDrawerDraw.spinalDrawerMenu.onSetItemData(eachRowDataItems, FirstFragment.class);
        eachRowDataItems = new HashMap();
        eachRowDataItems.put("sysDrawerTitle", "Title-02");
        eachRowDataItems.put("sysDrawerDescription", "Description-02");
        spinalRowDrawerDraw.spinalDrawerMenu.onSetItemData(eachRowDataItems, SecondFragment.class);
        modelDrawerListItems = spinalRowDrawerDraw.spinalDrawerMenu.onGetDataList();
        spinalRowDrawerDraw.spinalDrawerMenu.onSetRowViewField(SpinalRowDrawerDraw.FIELD_TYPE.TEXT_VIEW, "sysDrawerTitle");
        spinalRowDrawerDraw.spinalDrawerMenu.onSetRowViewField(SpinalRowDrawerDraw.FIELD_TYPE.TEXT_VIEW, "sysDrawerDescription");
        //rowViewFieldListItems = spinalRowDrawerDraw.spinalDrawerMenu.onGetRowViewFieldsList();
        adapterDrawerListAdapter = new SharkArrayAdapter(context, R.layout.layout_navigation_drawer_row, modelDrawerListItems);
        spinalRowDrawerDraw.spinalDrawerMenu.onSetAdapterListener(adapterDrawerListAdapter)
                .onSetDrawerLayout((DrawerLayout) findViewById(R.id.sysDrawerLayout), (RelativeLayout) findViewById(R.id.sysIdDrawerContainer), R.id.sysFrameContainer)
                .onSetDefaultDrawerLayout(0);
        sysDrawerList.setAdapter(adapterDrawerListAdapter);
        spinalRowDrawerDraw.spinalDrawerMenu.onSetDrawerItemClickListener(sysDrawerList);
        /*spinalRowDrawerDraw.onSetFrameLayoutParent((LinearLayout) findViewById(R.id.idLinLayMainContainerView))
                .onSetGravity(Gravity.RIGHT)
                .onConfigureDrawer();*/
        spinalRowDrawerDraw.onSetGravity(Gravity.RIGHT)
                .onConfigureDrawer();
        //|------------------------------------------------------------|
        //|------------------------------------------------------------|
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem argMenuItem) {
        switch (argMenuItem.getItemId()) {
            case android.R.id.home:
                spinalRowDrawerDraw.onOptionsItemSelected(argMenuItem);
                return true;
            default:
                return super.onOptionsItemSelected(argMenuItem);
        }
        //System.out.println("----------------------");
        //return super.onOptionsItemSelected(argMenuItem);
    }

    //|------------------------------------------------------------|
    @Override
    public void onConfigurationChanged(Configuration argNewConfig) {
        super.onConfigurationChanged(argNewConfig);
        spinalRowDrawerDraw.onConfigurationChanged(argNewConfig);
    }
    //|------------------------------------------------------------|

    @Override
    public void onBackPressed() {
        if (!spinalRowDrawerDraw.onSetBackPressed()) {
            super.onBackPressed();
        }
    }

    //|------------------------------------------------------------|
}
