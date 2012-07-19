package com.example.alo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class CentralActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_central);
		
		//register activity in a list for finishing all activities
		RegistryActivity.register(this);
		
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		
		image.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent newIntent = new Intent(CentralActivity.this,
						MainActivity.class);
				startActivity(newIntent);
			}
		});

	}

}
