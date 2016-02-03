package com.example.john.cs4720androiduvabucketlist;

/**
 * Created by John on 2/2/16.
 */
public class listItem {
    /* Fields */
    protected String name;
    protected boolean selected = false;
    protected String info;

    /* Default Constructor */
    public listItem () {
        name = "";
        info = "";
    }

    /* Partial Constructor of Name + Info */

    public listItem (String n, String i) {
        name = n;
        info = i;
    }

    /* Getters & Setters */
    public String getName () {
        return name;
    }
    public String getInfo () {
        return info;
    }
    public boolean getSelected () {
        return selected;
    }
    public void setSelected(boolean s) {
        selected = s;
    }
    /* Utility Methods */
    public void checkOff() {
        if (selected == false) selected = true;
        else { selected = false; }
    }
}
