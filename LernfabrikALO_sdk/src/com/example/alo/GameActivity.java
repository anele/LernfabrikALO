package com.example.alo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GameActivity extends Activity {

	private String[] imageArray = new String[26];
	private String[] signArray = new String[26];
	private Map<Drawable, String> mapLetter;
	private Map<Drawable, String> mapImage;
	private ButtonListener buttonListener;
	private List<Drawable> imageList;
	private List<Drawable> signList;
	private Drawable firstImage;
	private static Object lock;
	private String firstCard;
	private String secondCard;
	private TableLayout mainTable;
	private ImageView imageLetter;
	private Context context;
	private static int numRight = 0;
	private static int numFalse = 0;
	private static int ROW_COUNT = -1;
	private static int COL_COUNT = -1;
	private String imageBaseDirectory;
	private String jsonFile;
	private int b_id = 0;
	private int z_id = 0;
	private int var;

	@SuppressWarnings("static-access")
	public void onCreate(Bundle savedInstanceState) {
		String img_url;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		MainActivity main = new MainActivity();
		mainTable = (TableLayout) findViewById(R.id.TableLayout01);
		RegistryActivity.register(this);
		
		mapLetter = new HashMap<Drawable, String>();
		mapImage = new HashMap<Drawable, String>();
		imageList = new ArrayList<Drawable>(var);
		signList = new ArrayList<Drawable>(var);
		buttonListener = new ButtonListener();
		lock = new Object();

		if (main.getGame() == main.gameSign) {
			imageBaseDirectory = "http://10.0.2.2:3000/images/alphabet/";
			jsonFile = "http://10.0.2.2:3000/photos.json";
			var = 26;
			ROW_COUNT = 7;
			COL_COUNT = 4;
		} else {
			var = 10;
			imageBaseDirectory = "http://10.0.2.2:3000/images/number/";
			jsonFile = "http://10.0.2.2:3000/photo1s.json";
			ROW_COUNT = 5;
			COL_COUNT = 2;
		}
		
		

		Button buttonMenu = (Button) findViewById(R.id.button1);
		buttonMenu.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent newIntent = new Intent(GameActivity.this,
						MainActivity.class);
				startActivity(newIntent);
			}
		});

		context = mainTable.getContext();

		try {
			getImages();
			for (int i = 1; i <= var; i++) {
				if (signArray[i - 1] != null) {
					img_url = imageBaseDirectory + signArray[i - 1];
					loadImagesLetter(img_url, signArray[i - 1]);
				}
			}
			showLetter();

			for (int i = 1; i <= var; i++) {
				img_url = imageBaseDirectory + imageArray[i - 1];
				if (imageArray[i - 1] != null) {
					loadImages(img_url, imageArray[i - 1]);
				}
			}

			// newGame(4,7);
			newGame();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// private void newGame(int c, int r) {
	private void newGame() {
		// ROW_COUNT = r;
		// COL_COUNT = c;
		TableRow tr = ((TableRow) findViewById(R.id.TableRow01));
		tr.removeAllViews();
		setNumRight(0);
		setNumFalse(0);

		mainTable = new TableLayout(context);
		tr.addView(mainTable);

		for (int y = 0; y < ROW_COUNT; y++) {
			mainTable.addView(createRow(y));
		}
		firstCard = null;
	}

	private TableRow createRow(int y) {
		TableRow row = new TableRow(context);
		row.setHorizontalGravity(Gravity.CENTER);

		for (int x = 0; x < COL_COUNT; x++) {
			row.addView(createImageButton(x, y));
		}
		return row;
	}

	private View createImageButton(int x, int y) {
		Button button = new Button(context);
		button.setId(100 * x + y);
		if (button.getId() == 206 || button.getId() == 306) {
			button.setVisibility(View.INVISIBLE);
		} else {
			Random r = new Random();
			int idx = r.nextInt(var);
			button.setBackgroundDrawable(imageList.get(idx));

			TableRow.LayoutParams blp = new TableRow.LayoutParams();
			blp.leftMargin = 20;
			blp.rightMargin = 20;
			blp.topMargin = 15;
			button.setLayoutParams(blp);

			imageList.remove(idx);
			var--;
		}

		button.setOnClickListener(buttonListener);
		return button;
	}

	private void getImages() {
		// TODO Auto-generated method stub
		JSONArray jsonArray;
		try {
			jsonArray = readJsonData();
			Log.v("Anzahl Elemente", ":" + jsonArray.length());
			// 52
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject json = jsonArray.getJSONObject(i);
				String imagetype = json.getString("image_type");
				if (imagetype.compareTo("2") == 0) {
					imageArray[b_id] = json.getString("image_name");
					b_id = b_id + 1;
				} else {
					signArray[z_id] = json.getString("image_name");
					z_id = z_id + 1;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loadImages(String img_url, String img_name) throws IOException {
		URL myFileUrl = new URL(img_url);
		HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
		conn.setDoInput(true);
		conn.connect();
		InputStream is = conn.getInputStream();
		Drawable d = Drawable.createFromStream(is, img_url);
		imageList.add(d);
		mapImage.put(d, img_name);
	}

	private void showLetter() {
		Resources res = getResources();
		imageLetter = (ImageView) findViewById(res.getIdentifier("imageView1",
				"id", getPackageName()));
		imageLetter.setBackgroundDrawable(signList.get(0));
		firstImage = signList.get(0);
	}

	private void loadImagesLetter(String img_url, String img_name)
			throws IOException {
		URL myFileUrl = new URL(img_url);
		HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
		conn.setDoInput(true);
		conn.connect();
		InputStream is = conn.getInputStream();
		Drawable d1 = Drawable.createFromStream(is, img_url);
		signList.add(d1);

		mapLetter.put(d1, img_name);
	}

	private JSONArray readJsonData() throws Exception {
		JSONArray jsonArray = null;
		String daten = "";
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(jsonFile);
		HttpResponse response = client.execute(httpGet);
		StatusLine statuslinie = response.getStatusLine();
		int statusCode = statuslinie.getStatusCode();
		if (statusCode == 200) {
			HttpEntity entity = response.getEntity();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					entity.getContent()));
			String zeile = "";
			while ((zeile = reader.readLine()) != null) {
				daten += zeile;
			}

			daten = daten.substring(daten.indexOf("["),
					daten.lastIndexOf("]") + 1);
			jsonArray = new JSONArray(daten);
		}
		return jsonArray;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public static void setNumRight(int numRight) {
		GameActivity.numRight = numRight;
	}

	public static int getNumRight() {
		return numRight;
	}

	public static void setNumFalse(int numFalse) {
		GameActivity.numFalse = numFalse;
	}

	public static int getNumFalse() {
		return numFalse;
	}

	class ButtonListener implements OnClickListener {

		public void onClick(View v) {
			synchronized (lock) {
				firstCard = mapLetter.get(firstImage);

				Drawable temp = v.getBackground();

				secondCard = mapImage.get(temp);

				if (firstCard.split("_")[0].equals(secondCard.split("_")[0])) {
					v.setVisibility(View.INVISIBLE);
					signList.remove(0);
					numRight++;
					if (signList.isEmpty()) {
						imageLetter.setVisibility(View.INVISIBLE);
						Intent newIntent1 = new Intent(GameActivity.this,
								ResultsActivity.class);
						startActivity(newIntent1);
					} else {
						showLetter();
					}
				} else {
					AlertDialog alertDialog = new AlertDialog.Builder(context)
							.create();
					alertDialog.setMessage("nochmal versuchen!");
					alertDialog.setButton("Ok",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									((AlertDialog) dialog).getButton(which)
											.setVisibility(View.INVISIBLE);
								}
							});
					alertDialog.show();
					numFalse++;
					numRight--;

					return;
				}
			}

		}

	}
}
