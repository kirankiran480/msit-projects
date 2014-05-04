package com.ebt.android.npuzzle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ebt.android.db.DBHelper;
import com.ebt.android.db.UserDetails;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;

public class ScoresActivity extends Activity {
	TableLayout layout;
	TextView userName;
	TextView rank;
	TextView moves;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scores);
		layout = (TableLayout) findViewById(R.id.scorestable);
		TableRow row;
		row = new TableRow(this);
		TableLayout.LayoutParams paramss = new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		paramss.setMargins(0, 0, 0, 0);
		row.setLayoutParams(paramss);
		userName = new TextView(this);
		rank = new TextView(this);
		moves = new TextView(this);
		rank.setText("Rank");
		userName.setText("Name of the Player");
		moves.setText("Moves");
		row.addView(rank);
		row.addView(userName);
		row.addView(moves);
		userName.setTextSize(20);
		userName.setPadding(5,5,10,5);
		moves.setTextSize(20);
		moves.setPadding(5,5,10,5);
		rank.setTextSize(20);
		rank.setPadding(5,5,10,5);
		
		userName.setTypeface(userName.getTypeface(),Typeface.BOLD);
		rank.setTypeface(rank.getTypeface(),Typeface.BOLD);
		moves.setTypeface(moves.getTypeface(),Typeface.BOLD);
		layout.addView(row);
		
		
		
		DBHelper db = new DBHelper(getApplicationContext());
		ArrayList<UserDetails> list = db.getAllRecords();
		Iterator<UserDetails> it = list.iterator();
		Log.e("size",String.valueOf(list.size()));
		int count=1;
		while(it.hasNext()){
			userName = new TextView(this);
			rank = new TextView(this);
			moves = new TextView(this);
			
			UserDetails user = it.next();
			
			rank.setText(String.valueOf(count));
			userName.setText(user.getUserName());
			moves.setText(String.valueOf(user.getMoves()));
			
			userName.setTextSize(20);
			userName.setPadding(5,5,5,5);
			moves.setTextSize(20);
			moves.setPadding(5,5,5,5);
			rank.setTextSize(20);
			rank.setPadding(5,5,5,5);
			
			row = new TableRow(this);
			TableLayout.LayoutParams params = new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 0, 0, 0);
			row.setLayoutParams(params);
			row.addView(rank);
			row.addView(userName);
			row.addView(moves);
			layout.addView(row);
			count++;
		}
	}

	
}
