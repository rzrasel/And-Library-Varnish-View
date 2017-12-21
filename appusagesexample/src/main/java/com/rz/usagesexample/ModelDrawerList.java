package com.rz.usagesexample;

/**
 * Created by Rz Rasel on 2017-12-21.
 */

public class ModelDrawerList {
    String title;
    String description;

    public ModelDrawerList() {
        //
    }

    public ModelDrawerList(String argTitle, String argDescription) {
        this.title = argTitle;
        this.description = argDescription;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String argTitle) {
        this.title = argTitle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String argDescription) {
        this.description = argDescription;
    }

    public static ModelDrawerList onGetSetRow(String argTitle, String argDescription) {
        return new ModelDrawerList(argTitle, argDescription);
    }
}
