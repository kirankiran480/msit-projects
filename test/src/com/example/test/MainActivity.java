package com.example.test;

import android.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void clickme(View view)
    {
    	TextView tv = (TextView) findViewById(R.id.mytext);
    	tv.setVisibility(View.VISIBLE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds texitems to the action bar if it is present.
       getMenuInflater().inflate(R.menu.main, menu);
       
        return true;
    }
    
}
