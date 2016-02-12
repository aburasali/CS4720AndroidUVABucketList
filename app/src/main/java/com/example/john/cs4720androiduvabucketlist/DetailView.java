package com.example.john.cs4720androiduvabucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailView extends Activity {

    listItem Litem;
    Button butt;
    TextView dv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        Intent i = getIntent();
        Litem = (listItem) i.getParcelableExtra("object");

        setTitle(Litem.getName() + " details");

        TextView dv1 = (TextView)findViewById(R.id.item);
        dv2 = (TextView)findViewById(R.id.item2);
        TextView dv3 = (TextView)findViewById(R.id.item3);
        butt = (Button)findViewById(R.id.check);
        if(Litem.getSelected()){
            butt.setText("Mark as incomplete");
            dv2.setText("Currently done!");
        }else{
            butt.setText("Mark as done");
            dv2.setText("Currently incomplete!");
        }
        dv1.setText(Litem.getName());
        dv3.setText(Litem.getInfo());

    }

    public void markAsDone(View view){
        if(Litem.getSelected()){
            Litem.setSelected(false);
            butt.setText("Mark as done");
            dv2.setText("Currently incomplete!");

        }else{
            Litem.setSelected(true);
            butt.setText("Mark as incomplete");
            dv2.setText("Currently done!");
        }

    }

    @Override
    public void onBackPressed() {
        boolean[] data = new boolean[1];
        data[0] = Litem.getSelected();
        Intent intent = new Intent();
        intent.putExtra("MyData", data);
        setResult(RESULT_OK, intent);
        finish();
    }

}
