package com.example.john.cs4720androiduvabucketlist;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by John on 2/2/16.
 */
public class CustomAdapter extends ArrayAdapter<listItem> {
    /* Fields */
    private ArrayList<listItem> list;
    private final Activity context;

    /* Constructor */

    public CustomAdapter(Activity context,int resource, ArrayList<listItem> ls) {
        super(context, resource, ls);
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

        number.setText(""+ (position +1) + ".");
        itemName.setText(list.get(position).name);
        isChecked.setChecked(list.get(position).selected);

        //this onclick listener is meant to allow for checkbox clicking
        final listItem Litem = list.get(position);
        isChecked.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Litem.checkOff();
                notifyDataSetChanged();
                Log.d("Bool Check", ""+Litem.getSelected());
            }
        });
        return convertView;
    }

}
