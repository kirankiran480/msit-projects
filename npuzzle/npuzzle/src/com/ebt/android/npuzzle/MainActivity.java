package com.ebt.android.npuzzle;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	MediaPlayer background;
	TextView welcomeText;
	Button guide;
	Button scores;
	Button start;
	Button quit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		welcomeText = (TextView) findViewById(R.id.welcomemessage);
		welcomeText.setTextColor(Color.BLACK);
		start = (Button) findViewById(R.id.start);
		
		
		start.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				Intent intent = new Intent(getApplicationContext(), ImageSelectorActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				//background = MediaPlayer.create(getApplicationContext(), R.raw.titanic);
				//background.start();
			}
		});
		guide = (Button) findViewById(R.id.guide);
		guide.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				Intent intent = new Intent(getApplicationContext(),GuideActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				
			}
		});
		quit = (Button) findViewById(R.id.quit);
		quit.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				MainActivity.this.finish();
			}
		});
		scores = (Button) findViewById(R.id.scoresbutton);
		scores.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				Log.e("message","message");
				Intent intent = new Intent(getApplicationContext(),ScoresActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				Log.e("message","message");
				startActivity(intent);
				Log.e("message","message");
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
