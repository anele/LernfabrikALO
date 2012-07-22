package com.example.alo.test;

import static org.junit.Assert.assertEquals;

import com.example.alo.MainActivity;

public class FunktionsTestCase {

	private MainActivity mainActivity;

	public FunktionsTestCase() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void setUp() throws Exception {
		mainActivity = new MainActivity();
	}

	@SuppressWarnings("static-access")
	public void testMainActivity() {
		assertEquals(-1, mainActivity.getGame());
	}
}
