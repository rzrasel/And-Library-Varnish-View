package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_spinal_row_drawer_draw);
        activity = this;
        context = this;
        sysToolBar = (Toolbar) findViewById(R.id.sysToolBar);
        SpinalRowDrawerDraw spinalRowDrawerDraw = new SpinalRowDrawerDraw(activity, context);
        spinalRowDrawerDraw.spinalToolBar.onHideActionBar()
                .initToolBar(sysToolBar)
                .onSetActionBar()
                .onSetTitleText("Spinal Row Drawer")
                .onSetTitleTextColor("#ffffff")
                .onSetSubTitleText("Sub Title")
                .onSetSubTitleTextColor("#ff0000")
                .onShowHomeButton()
                .onSetStatusBarDark(false);
        sysToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View argView) {
                System.out.println("DEBUG_ID: ");
            }
        });
        //|------------------------------------------------------------|
        //|------------------------------------------------------------|
        ListView sysDrawerList;
        SharkArrayAdapter adapterDrawerListAdapter;
        ArrayList<SharkModelRowScope> modelDrawerListItems = new ArrayList<SharkModelRowScope>();
        sysDrawerList = (ListView) findViewById(R.id.sysDrawerList);
        for (int count = 0; count < 40; count++) {
            HashMap<String, String> hashMapRowIdValueItems = new HashMap();
            String val = count + "";
            if (count < 10) {
                val = "0" + count;
            }
            hashMapRowIdValueItems.put("sysDrawerTitle", "Title-" + val);
            hashMapRowIdValueItems.put("sysDrawerDescription", "Description-" + val);
            modelDrawerListItems.add(SharkModelRowScope.onGetSetRow(hashMapRowIdValueItems));
        }
        ArrayList<SharkModelRowViewFields> rowViewFieldListItems = null;
        rowViewFieldListItems = new ArrayList<SharkModelRowViewFields>();
        rowViewFieldListItems.add(SharkModelRowViewFields.onGetSetModelRow(new TextView(context), "sysDrawerTitle"));
        rowViewFieldListItems.add(SharkModelRowViewFields.onGetSetModelRow(new TextView(context), "sysDrawerDescription"));
        adapterDrawerListAdapter = new SharkArrayAdapter(context, R.layout.layout_navigation_drawer_row, modelDrawerListItems);
        adapterDrawerListAdapter.onSetRowViewFieldList(rowViewFieldListItems)
                .onSetRowViewFieldListenerHandler(new SharkArrayAdapter.OnFieldListenerHandler() {
                    @Override
                    public void onSetFieldValue(ArrayList<SharkModelRowViewFields> argRowViewFieldList, Object argObject) {
                        SharkModelRowScope itemScope = (SharkModelRowScope) argObject;
                        //TextView rowField = null;
                        /*if (argRowViewFieldList.size() > 0) {
                            rowField = (TextView) argRowViewFieldList.get(0).getFieldObject();
                            rowField.setText(item.getHashMapRowIdValueItems().get("sysDrawerTitle"));
                            rowField = (TextView) argRowViewFieldList.get(1).getFieldObject();
                            rowField.setText(item.getHashMapRowIdValueItems().get("sysDrawerDescription"));
                        }*/
                        for (SharkModelRowViewFields itemField : argRowViewFieldList) {
                            Object object = itemField.getFieldObject();
                            String fieldResourceId = itemField.getFieldResourceId();
                            if (object instanceof TextView) {
                                TextView rowField = null;
                                rowField = (TextView) itemField.getFieldObject();
                                rowField.setText(itemScope.getHashMapRowIdValueItems().get(fieldResourceId));
                                System.out.println(itemField.getFieldResourceId());
                            }
                        }
                    }
                });
        sysDrawerList.setAdapter(adapterDrawerListAdapter);
        //|------------------------------------------------------------|
        //|------------------------------------------------------------|
    }
}
