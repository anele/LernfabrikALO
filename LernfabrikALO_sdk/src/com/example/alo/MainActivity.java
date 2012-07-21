package com.example.alo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	// 0=sign 1=number
	private static int game = -1;
	private ImageView imageSign;
	private static Object lock = new Object();

	@Override
	// Called then the activity is first created
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RegistryActivity.register(this);

		imageSign = (ImageView) findViewById(R.id.imageView2);
		ImageView imageNumber = (ImageView) findViewById(R.id.imageView3);

		ButtonListener buttonListener1 = new ButtonListener();
		imageSign.setOnClickListener(buttonListener1);
		imageNumber.setOnClickListener(buttonListener1);

		Button buttonEnd = (Button) findViewById(R.id.button2);
		buttonEnd.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				RegistryActivity.finishAll();

			}
		});
	}

	public static int getGame() {
		return game;
	}

	class ButtonListener implements OnClickListener {

		public void onClick(View v) {

			synchronized (lock) {

				if (v == imageSign) {
					MainActivity.game = 0;
				} else {
					MainActivity.game = 1;
				}

				Intent newIntent = new Intent(MainActivity.this,
						GameActivity.class);
				startActivity(newIntent);
			}
		}
	}

}
