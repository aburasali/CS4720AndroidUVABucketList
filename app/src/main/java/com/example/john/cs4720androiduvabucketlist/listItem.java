package com.example.john.cs4720androiduvabucketlist;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by John on 2/2/16.
 */
public class listItem implements Parcelable{
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

    /* By making this object parcelable, we can add it to an intent to push from activity to another  */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(info);
        parcel.writeByte((byte) (selected ? 1 : 0));
    }

    public static final Parcelable.Creator<listItem> CREATOR = new Parcelable.Creator<listItem>() {
        public listItem createFromParcel(Parcel in) {
            return new listItem(in);
        }

        public listItem[] newArray(int size) {
            return new listItem[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private listItem(Parcel in) {
        name = in.readString();
        info = in.readString();
        selected = in.readByte() != 0;

    }
}
