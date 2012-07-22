/**
 * 
 */
package com.example.alo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;

import com.example.alo.R;
import com.example.alo.ResultsActivity;

/**
 * @author alex
 * 
 */
public class LayoutResultTestCase extends
		ActivityInstrumentationTestCase2<ResultsActivity> {

	private ResultsActivity activity;

	public LayoutResultTestCase() {
		// TODO Auto-generated constructor stub
		super("com.example.alo", ResultsActivity.class);
	}

	public void setUp() throws Exception {
		activity = getActivity();
	}

	public void touchLayout() {
		assertNotNull(activity.findViewById(R.id.button2));
		Button button = (Button) activity.findViewById(R.id.button2);
		assertEquals("Ende", button.getText());
		TouchUtils.clickView(this, button);
	}
}
