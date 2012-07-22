package com.example.alo.test;

// THIS TEST ALLWAYS FAILS because of the random placed pictures
// if you want to make the test pass, the search-match-algorithm may be extra implemented

import android.test.ActivityInstrumentationTestCase2;

import com.example.alo.CentralActivity;
import com.jayway.android.robotium.solo.Solo;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;

public class ALOFullTestRecord extends
		ActivityInstrumentationTestCase2<CentralActivity> {

	private Solo solo;
	private ExtSolo extSolo;
	protected Integer screenWidth = null;
	protected Integer screenHeight = null;

	public ALOFullTestRecord() {
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
			assertTrue(
					"Wait for image (id: com.example.alo.R.id.imageView3) failed.",
					solo.waitForView(extSolo
							.findViewById(com.example.alo.R.id.imageView3),
							20000, true));
			solo.clickOnView(extSolo
					.findViewById(com.example.alo.R.id.imageView3));
			solo.waitForActivity("GameActivity", 5000);
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.617f),
					extSolo.toScreenY(0.269f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.629f),
					extSolo.toScreenY(0.579f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.617f),
					extSolo.toScreenY(0.375f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.396f),
					extSolo.toScreenY(0.469f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.596f),
					extSolo.toScreenY(0.480f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.375f),
					extSolo.toScreenY(0.373f));
			solo.sleep(2000);
			assertTrue("Wait for button (text: Ok) failed.",
					solo.waitForText("Ok", 1, 20000));
			solo.clickOnButton("Ok");
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.629f),
					extSolo.toScreenY(0.664f));
			solo.sleep(2000);
			assertTrue("Wait for button (text: Ok) failed.",
					solo.waitForText("Ok", 1, 20000));
			solo.clickOnButton("Ok");
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.396f),
					extSolo.toScreenY(0.561f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.404f),
					extSolo.toScreenY(0.654f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.625f),
					extSolo.toScreenY(0.650f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.402f),
					extSolo.toScreenY(0.280f));
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.387f),
					extSolo.toScreenY(0.352f));
			solo.waitForActivity("ResultsActivity", 5000);
			solo.sleep(2000);
			solo.clickOnScreen(extSolo.toScreenX(0.519f),
					extSolo.toScreenY(0.926f));
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
		} catch (AssertionFailedError e) {
			extSolo.takeScreenshot("com.example.alo.test.CentralActivityTest.testRecorded_scr_fail");
			throw e;
		} catch (Exception e) {
			extSolo.takeScreenshot("com.example.alo.test.CentralActivityTest.testRecorded_scr_fail");
			throw e;
		}
	}

}
