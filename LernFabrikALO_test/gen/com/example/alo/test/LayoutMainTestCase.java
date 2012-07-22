/**
 * 
 */
package com.example.alo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.alo.MainActivity;
import com.example.alo.R;

/**
 * @author alex
 * 
 */
public class LayoutMainTestCase extends
		ActivityInstrumentationTestCase2<MainActivity> {

	MainActivity activity;

	public LayoutMainTestCase() {
		// TODO Auto-generated constructor stub
		super("com.example.alo", MainActivity.class);
	}

	public void setUp() throws Exception {
		activity = getActivity();
	}

	
	public void touchLayout() {
		assertNotNull(activity.findViewById(R.id.button2));
		Button button = (Button) activity.findViewById(R.id.button2);
		assertEquals("Ende", button.getText());
		
		assertNotNull(activity.findViewById(R.id.imageView3));
		ImageView image = (ImageView) activity.findViewById(R.id.imageView3);
		TouchUtils.clickView(this, image);
	}	
}
