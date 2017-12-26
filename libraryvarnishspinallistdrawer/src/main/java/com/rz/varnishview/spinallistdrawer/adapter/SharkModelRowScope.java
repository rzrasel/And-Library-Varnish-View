package com.rz.varnishview.spinallistdrawer.adapter;

import java.util.HashMap;

/**
 * Created by Rz Rasel on 2017-12-26.
 */

public class SharkModelRowScope {
    //<String, String> 1) String is for "field id" or "field resource id", 2) String is for field value
    private HashMap<String, String> hashMapRowIdValueItems = new HashMap<String, String>();

    public SharkModelRowScope() {
    }

    public SharkModelRowScope(HashMap<String, String> argHashMapRowIdValueItems) {
        this.hashMapRowIdValueItems = argHashMapRowIdValueItems;
    }

    public HashMap<String, String> getHashMapRowIdValueItems() {
        return this.hashMapRowIdValueItems;
    }

    public void setHashMapRowIdValueItems(HashMap<String, String> argHashMapRowIdValueItems) {
        this.hashMapRowIdValueItems = argHashMapRowIdValueItems;
    }

    public static SharkModelRowScope onGetSetRow(HashMap<String, String> argHashMapRowIdValueItems) {
        return new SharkModelRowScope(argHashMapRowIdValueItems);
    }
}