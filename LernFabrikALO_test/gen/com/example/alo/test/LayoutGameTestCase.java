/**
 * 
 */
package com.example.alo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;

import com.example.alo.GameActivity;
import com.example.alo.R;

/**
 * @author alex
 * 
 */
public class LayoutGameTestCase extends
		ActivityInstrumentationTestCase2<GameActivity> {

	private GameActivity activity;

	public LayoutGameTestCase() {
		// TODO Auto-generated constructor stub
		super("com.example.alo", GameActivity.class);
	}

	public void setUp() throws Exception {
		activity = getActivity();
	}

	public void touchLayout() {
		assertNotNull(activity.findViewById(R.id.button1));
		Button button = (Button) activity.findViewById(R.id.button1);
		assertEquals("Menü", button.getText());
		TouchUtils.clickView(this, button);
	}
}
