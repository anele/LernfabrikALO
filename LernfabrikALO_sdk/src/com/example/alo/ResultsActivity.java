package com.example.alo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends Activity {
	private OnClickListener buttonListener2;
	private Button buttonMenu;
	private Button buttonEnd;

	@SuppressWarnings("static-access")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		RegistryActivity.register(this);

		GameActivity game = new GameActivity();

		TextView right = (TextView) findViewById(R.id.right);
		TextView wrong = (TextView) findViewById(R.id.wrong);

		right.setText("X  " + game.getNumRight());
		wrong.setText("X  " + game.getNumFalse());

		buttonMenu = (Button) findViewById(R.id.button1);
		buttonEnd = (Button) findViewById(R.id.button2);

		buttonListener2 = new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v == buttonMenu) {
					Intent newIntent = new Intent(ResultsActivity.this,
							MainActivity.class);
					startActivity(newIntent);
				} else {
					RegistryActivity.finishAll();
				}
			}
		};
		buttonMenu.setOnClickListener(buttonListener2);
		buttonEnd.setOnClickListener(buttonListener2);

	}

}
