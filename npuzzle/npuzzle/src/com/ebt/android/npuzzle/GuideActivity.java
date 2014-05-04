package com.ebt.android.npuzzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class GuideActivity extends Activity {
	Button back;
	Button start;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		back = (Button) findViewById(R.id.guidebackbutton);
		start = (Button) findViewById(R.id.guidestartbutton);
		back.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});

		
		start.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				Intent intent = new Intent(getApplicationContext(),ImageSelectorActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
