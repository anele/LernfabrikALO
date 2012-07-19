package com.example.alo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {
	private ButtonListener buttonListener1;
	private static Object lock = new Object();
	private Button buttonEnd;
	
	//0=sign    1=number
	private static int game=-1;
	public static final int gameSign = 0;
	public static final int gameNumber = 1;
	private ImageView imageSign;
	private ImageView imageNumber;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RegistryActivity.register(this);
		
		imageSign = (ImageView)findViewById(R.id.imageView2);
		imageNumber = (ImageView)findViewById(R.id.imageView3);	
		
		buttonListener1 = new ButtonListener();		
		imageSign.setOnClickListener(buttonListener1);
		imageNumber.setOnClickListener(buttonListener1);
		
		buttonEnd= (Button)findViewById(R.id.button2);
		buttonEnd.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RegistryActivity.finishAll();
								
			}
		});
	}
	
	public static void setGame(int game) {
		MainActivity.game = game;
	}

	public static int getGame() {
		return game;
	}
	
	class ButtonListener implements OnClickListener {

		public void onClick(View v) {
			synchronized (lock) {
				
				
				if(v == imageSign){					
					setGame(0);
				}
				else
				{
					setGame(1);
				}
				
				Intent newIntent = new Intent(MainActivity.this,GameActivity.class);
				startActivity(newIntent);
				
			}
			
		}

		
		}

	
}
