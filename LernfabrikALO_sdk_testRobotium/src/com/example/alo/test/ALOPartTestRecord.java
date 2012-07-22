package com.example.alo.test;

// THIS TEST NEVER FAILS

import android.test.ActivityInstrumentationTestCase2;
import com.example.alo.CentralActivity;
import com.jayway.android.robotium.solo.Solo;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;

public class ALOPartTestRecord extends
		ActivityInstrumentationTestCase2<CentralActivity> {

	private Solo solo;
	private ExtSolo extSolo;
	protected Integer screenWidth = null;
	protected Integer screenHeight = null;

	public ALOPartTestRecord() {
		super(CentralActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
		extSolo = new ExtSolo(getInstrumentation(), solo);
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		extSolo.tearDown();
		super.tearDown();
	}

	public void testRecorded() throws Exception {
		try {
			solo.waitForActivity("CentralActivity", 500);
			solo.sleep(2000);
			assertTrue(
					"Wait for image (id: com.example.alo.R.id.imageView1) failed.",
					solo.waitForView(extSolo
							.findViewById(com.example.alo.R.id.imageView1),
							20000, true));
			solo.clickOnView(extSolo
					.findViewById(com.example.alo.R.id.imageView1));
			solo.waitForActivity("MainActivity", 5000);
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.525f),
					extSolo.toScreenY(0.504f));
			solo.sleep(2000);
			assertTrue(
					"Wait for image (id: com.example.alo.R.id.imageView3) failed.",
					solo.waitForView(extSolo
							.findViewById(com.example.alo.R.id.imageView3),
							20000, true));
			solo.clickOnView(extSolo
					.findViewById(com.example.alo.R.id.imageView3));
			solo.waitForActivity("GameActivity", 5000);
			solo.sleep(2000);
			assertTrue(
					"Wait for button (id: com.example.alo.R.id.button1) failed.",
					solo.waitForView(
							extSolo.findViewById(com.example.alo.R.id.button1),
							20000, true));
			solo.clickOnView(extSolo.findViewById(com.example.alo.R.id.button1));
			solo.waitForActivity("MainActivity", 5000);
			solo.sleep(2000);
			assertTrue(
					"Wait for image (id: com.example.alo.R.id.imageView2) failed.",
					solo.waitForView(extSolo
							.findViewById(com.example.alo.R.id.imageView2),
							20000, true));
			solo.clickOnView(extSolo
					.findViewById(com.example.alo.R.id.imageView2));
			solo.waitForActivity("GameActivity", 5000);
			solo.sleep(2000);
			assertTrue(
					"Wait for button (id: com.example.alo.R.id.button1) failed.",
					solo.waitForView(
							extSolo.findViewById(com.example.alo.R.id.button1),
							20000, true));
			solo.clickOnView(extSolo.findViewById(com.example.alo.R.id.button1));
			solo.waitForActivity("MainActivity", 5000);
			solo.sleep(2000);
			assertTrue(
					"Wait for button (id: com.example.alo.R.id.button2) failed.",
					solo.waitForView(
							extSolo.findViewById(com.example.alo.R.id.button2),
							20000, true));
			solo.clickOnView(extSolo.findViewById(com.example.alo.R.id.button2));
			extSolo.takeScreenshot("com.example.alo.test.ALOTestRobotium.testRecorded_scr_1");
		} catch (AssertionFailedError e) {
			extSolo.takeScreenshot("com.example.alo.test.ALOTestRobotium.testRecorded_scr_fail");
			throw e;
		} catch (Exception e) {
			extSolo.takeScreenshot("com.example.alo.test.ALOTestRobotium.testRecorded_scr_fail");
			throw e;
		}
	}

}
