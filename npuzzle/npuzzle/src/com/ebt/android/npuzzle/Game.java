package com.ebt.android.npuzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.ebt.android.db.DBHelper;
import com.ebt.android.db.UserDetails;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableLayout.LayoutParams;

public class Game extends Activity {
	TextView highScore;
	MediaPlayer background;
	int level,last;
	Bitmap tiles[];
	int count;
	ArrayList<Integer> al = new ArrayList<Integer>();
	RelativeLayout game_layout;
	TextView tv;
	EditText uname;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamescreen);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		background = MediaPlayer.create(getApplicationContext(), R.raw.titanic);
		background.setLooping(true);
		background.start();
		Bundle game = this.getIntent().getExtras();
		level = game.getInt("level");
		last = (level*level)-1;
		tiles = new Bitmap[level*level];
		int image = game.getInt("imageindex");
		if(level==0)
			level = 3;		
		DisplayMetrics displaymetrics = new DisplayMetrics();
	    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	    int screenHeight = displaymetrics.heightPixels;
	    int screenWidth = displaymetrics.widthPixels;
	    int size = screenWidth;
	    Bitmap org = BitmapFactory.decodeResource(this.getResources(),image);
	    final Bitmap scaled = Bitmap.createScaledBitmap(org, size, size, true);
	    int increment = size/level;
	    int startX=0,startY=0;
	    count = 0;

	    for(int i=0; i<level; i++){
		 	for(int j=0; j<level; j++){
				startX = j*increment;
				startY = i*increment;
				if(i == (level-1) && j == i)
					tiles[count] = Bitmap.createBitmap(increment, increment, Bitmap.Config.ARGB_8888);
				else
					tiles[count] = Bitmap.createBitmap(scaled, startX, startY, increment, increment);
				al.add(count);
				count++;
			}
		}
	    
	    //Collections.shuffle(al);
	    Button shuffle = new Button(this);
	    tv = new TextView(this);
	    try{
			game_layout = (RelativeLayout)this.findViewById(R.id.game_layout);
			TableLayout grids = new TableLayout(this);
			grids.setId(200);
			grids.setShrinkAllColumns(true);
			shuffle.setText("Shuffle");
			shuffle.setId(100);
			tv.setId(300);
			
			count = 0;
			for(int i=0; i<level; i++){
				TableRow tr = new TableRow(this);
				TableLayout.LayoutParams params = new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				params.setMargins(0, -11, 0, 0);
				tr.setLayoutParams(params);

				for(int j=0; j<level; j++){
					ImageView iv = new ImageView(this);
					iv.setId(count);
					iv.setImageBitmap(tiles[count]);
					tr.addView(iv);
					count++;					
				}
				grids.addView(tr);
				
				shuffle.setOnClickListener(new View.OnClickListener() {					
					@Override
					public void onClick(View v) {
						shuffle();
						Button btn = (Button)findViewById(100);
						btn.setText("Reshuffle");
						tv.setText("No. of Moves : "+0);
						tv.setTextSize(15);
						tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
					}
				});
			}
			game_layout.addView(grids);
			game_layout.addView(shuffle);
			game_layout.addView(tv);
			
			RelativeLayout.LayoutParams btn_param = (RelativeLayout.LayoutParams)shuffle.getLayoutParams();
			btn_param.addRule(RelativeLayout.BELOW, grids.getId());
			btn_param.addRule(RelativeLayout.CENTER_HORIZONTAL);			
			shuffle.setLayoutParams(btn_param);
			
			RelativeLayout.LayoutParams tv_param = (RelativeLayout.LayoutParams)tv.getLayoutParams();
			tv_param.addRule(RelativeLayout.BELOW, shuffle.getId());
			tv_param.addRule(RelativeLayout.CENTER_HORIZONTAL);
			tv.setLayoutParams(tv_param);
			
		}catch(Exception e){
			e.printStackTrace();
		}   	
	}
	
	public void shuffle(){
		ImageView iv;
		count = 0;
		tv = (TextView)findViewById(300);
		Collections.shuffle(al);
		for(int i=0; i<=last;i++){
			iv = (ImageView)findViewById(i);
			iv.setImageBitmap(tiles[al.get(i)]);
			
			iv.setOnClickListener(new View.OnClickListener() {						
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					int src = v.getId();
					ImageView from,to;
					Bitmap source, blank;
					from = (ImageView)findViewById(src);
					source = 	((BitmapDrawable)from.getDrawable()).getBitmap();	
					ArrayList<Integer> target = getTargetList(src,level);							
					
					for(int i=0; i<target.size(); i++){
						to = (ImageView)findViewById(target.get(i));
						blank = ((BitmapDrawable)to.getDrawable()).getBitmap();		
						if(blank.sameAs(tiles[last])){							
							to.setImageBitmap(source);
							from.setImageBitmap(tiles[last]);
							count++;
							tv.setText("No. of Moves : "+count);
							tv.setTextSize(15);
							tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
							break;
						}
					}
					if(haveWon()){
						background.stop();
						background = MediaPlayer.create(getApplicationContext(), R.raw.claps);
						background.start();
						showOneButtonDialog();
					}
				}
			});
		}
	}
	
	public ArrayList<Integer> getTargetList(int src,int level){
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(src - level >= 0)
			al.add(src-level);
		if(src+level < level*level)
			al.add(src+level);
		if(src%level != 0)
			al.add(src-1);
		if((src+1)%level != 0)
			al.add(src+1);
		Iterator<Integer> it = al.iterator();
		while(it.hasNext()){
			Log.e("locations", it.next().toString());
		}		
		return al;
	}
	
	@SuppressLint("NewApi")
	public boolean haveWon(){
		ImageView iv;
		Bitmap image;
		for(int i=0; i<(level*level)-1; i++){
			iv = (ImageView)findViewById(i);
			image = ((BitmapDrawable)iv.getDrawable()).getBitmap();
			if(!(image.sameAs(tiles[i])))
				return false;
		}
		return true;
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		background.stop();
	}
	public void showOneButtonDialog(){
		DBHelper db = new DBHelper(getApplicationContext());
		int h_score = 0;
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		highScore = new TextView(this);
		UserDetails user = db.getHighestRecord();
		h_score = user.getMoves();
		uname = new EditText(this);
		uname.setText("Player");
		dialogBuilder.setTitle("Hurray!! Game Completed");
		if(user!=null && h_score!=0){
			Log.e("Message","message");
			dialogBuilder.setMessage("Best Record: "+h_score+"\n\nYour moves: "+count);
		}
		else{
			dialogBuilder.setMessage("Your Moves : "+count);
		}
		dialogBuilder.setView(uname);
		dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
			
			public void onClick(DialogInterface dialog, int which){
				DBHelper db = new DBHelper(getApplicationContext());
				UserDetails user = new UserDetails(uname.getText().toString(),count);
				long id = db.insertUserDetails(user);
				
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});
		AlertDialog alertDialog = dialogBuilder.create();
		alertDialog.show();
	}
}
