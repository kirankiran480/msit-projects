package com.ebt.android.npuzzle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;

public class ImageSelectorActivity extends Activity {
	
	String level;
	int imageIndex;
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.image_seclector);

	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        @SuppressWarnings("deprecation")
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            imageIndex = position;
	            
	            showListDialog();
	        }
	    });
	}
	private void showListDialog(){
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		final String[] levels={"Easy","Medium","Hard"};
		dialogBuilder.setTitle("Choose your Level");
		dialogBuilder.setItems(levels,new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int index){
				level=levels[index];
				moveToNextIntent();
			}
		});
		AlertDialog dialog = dialogBuilder.create();
		dialog.show();
	}
	private void moveToNextIntent(){
		int levelIndex = 0;
		Intent intent = new Intent(getApplicationContext(),Game.class);
		
		if(level.equals("Easy"))
			levelIndex = 3;
		if(level.equals("Medium"))
			levelIndex = 4;
		if(level.equals("Hard"))
			levelIndex = 5;
		intent.putExtra("level",levelIndex);
		int imageId = new ImageAdapter(this).getImageId(imageIndex);
		intent.putExtra("imageindex",imageId);	
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
	
}
