/**
 * 
 */
package com.example.alo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alo.CentralActivity;
import com.example.alo.R;

/**
 * @author alex
 * 
 */
public class LayoutCentralTestCase extends
		ActivityInstrumentationTestCase2<CentralActivity> {

	private CentralActivity activity;
	
	public LayoutCentralTestCase() {
		// TODO Auto-generated constructor stub
		super("com.example.alo", CentralActivity.class);
	}

	public void setUp() throws Exception {
		activity = getActivity();
	}

	public void touchLayout() {
		assertNotNull(activity.findViewById(R.id.textView2));
		TextView text = (TextView) activity.findViewById(R.id.textView2);
		assertEquals("Lernfabrik ALO", text.getText());
		
		ImageView image = (ImageView) activity.findViewById(R.id.imageView1);
		TouchUtils.clickView(this, image);
	}
}
