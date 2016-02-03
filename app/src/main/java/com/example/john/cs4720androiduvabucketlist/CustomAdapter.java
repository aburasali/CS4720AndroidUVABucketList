package com.example.john.cs4720androiduvabucketlist;

import android.content.Context;
import android.widget.*;
import java.util.*;
import android.view.*;
import android.app.*;
/**
 * Created by John on 2/2/16.
 */
public class CustomAdapter extends ArrayAdapter<listItem> {
    /* Fields */
    private ArrayList<listItem> list;
    private final Activity context;


    /* Constructor */

    public CustomAdapter(Activity context, ArrayList<listItem> ls) {
        super(context, R.layout.custom_adapter);
        list = ls;
        this.context = context;
    }

    /* Methods */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.custom_adapter, parent, false);
        }

        TextView itemName = (TextView)convertView.findViewById(R.id.name);
        TextView number = (TextView)convertView.findViewById(R.id.number);
        CheckedTextView isChecked = (CheckedTextView)convertView.findViewById(R.id.bucketList);

        number.setText(""+position +1);
        itemName.setText(list.get(position).name);
        isChecked.setChecked(list.get(position).selected);

        return convertView;
    }

}
