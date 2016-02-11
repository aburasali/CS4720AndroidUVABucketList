package com.example.john.cs4720androiduvabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        Intent i = getIntent();
        listItem Litem = (listItem) i.getParcelableExtra("object");

        TextView dv1 = (TextView)findViewById(R.id.item);
        TextView dv2 = (TextView)findViewById(R.id.item2);
        TextView dv3 = (TextView)findViewById(R.id.item3);

        dv1.setText(Litem.getName());
        dv2.setText(Litem.getSelected()+"");
        dv3.setText(Litem.getInfo());

    }

}
