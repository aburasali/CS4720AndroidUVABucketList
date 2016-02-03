package com.example.john.cs4720androiduvabucketlist;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView chklst = (ListView) findViewById(R.id.checkableList);
        chklst.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //Declared bucket list items
        String[] bucket_list_items = getResources().getStringArray(R.array.bucket_list_items);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_layout, R.id.bucketList, bucket_list_items);
        chklst.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
