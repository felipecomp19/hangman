package com.texti.hangman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.texti.hangman.R;

public class MultiGameActivity extends ActionBarActivity {

	Typeface tf;

	Button b_a, b_b, b_c, b_d, b_e, b_f, b_g, b_h, b_i, b_j, b_k, b_l, b_m,
			b_n, b_o, b_p, b_q, b_r, b_s, b_t, b_u, b_v, b_w, b_x, b_y, b_z;

	Button b_new;

	TextView tv_word, tv_status;

	ImageView iv_image;

	String word, keyboard;

	int mistakes = 0;

	int easy;
	int letters;

	Button[] buttons;
	int objectLength = 26;
	// ---------------------------------------------------------------

	private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// Create the interstitial.
		interstitial = new InterstitialAd(this);
		//interstitial.setAdUnitId("ca-app-pub-7124948529897131/6646412888");
		interstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));

		// Create ad request.
		AdRequest adRequest = new AdRequest.Builder().build();

		// Begin loading your interstitial.
		interstitial.loadAd(adRequest);

		SharedPreferences settings = getSharedPreferences("PREFS", 0);
		word = settings.getString("word", "");
		keyboard = settings.getString("keyboard", "classic");
		easy = settings.getInt("easy", 1);
		letters = settings.getInt("letters", 1);

		if (keyboard.equalsIgnoreCase("classic")) {
			setContentView(R.layout.activity_game);
		} else if (keyboard.equalsIgnoreCase("new")) {
			setContentView(R.layout.activity_game2);
		}

		tf = Typeface.createFromAsset(getAssets(), "font.ttf");

		b_new = (Button) findViewById(R.id.b_new);
		b_new.setTypeface(tf);
		b_new.setVisibility(View.GONE);

		b_a = (Button) findViewById(R.id.b_a);
		b_b = (Button) findViewById(R.id.b_b);
		b_c = (Button) findViewById(R.id.b_c);
		b_d = (Button) findViewById(R.id.b_d);
		b_e = (Button) findViewById(R.id.b_e);
		b_f = (Button) findViewById(R.id.b_f);
		b_g = (Button) findViewById(R.id.b_g);
		b_h = (Button) findViewById(R.id.b_h);
		b_i = (Button) findViewById(R.id.b_i);
		b_j = (Button) findViewById(R.id.b_j);
		b_k = (Button) findViewById(R.id.b_k);
		b_l = (Button) findViewById(R.id.b_l);
		b_m = (Button) findViewById(R.id.b_m);
		b_n = (Button) findViewById(R.id.b_n);
		b_o = (Button) findViewById(R.id.b_o);
		b_p = (Button) findViewById(R.id.b_p);
		b_q = (Button) findViewById(R.id.b_q);
		b_r = (Button) findViewById(R.id.b_r);
		b_s = (Button) findViewById(R.id.b_s);
		b_t = (Button) findViewById(R.id.b_t);
		b_u = (Button) findViewById(R.id.b_u);
		b_v = (Button) findViewById(R.id.b_v);
		b_w = (Button) findViewById(R.id.b_w);
		b_x = (Button) findViewById(R.id.b_x);
		b_y = (Button) findViewById(R.id.b_y);
		b_z = (Button) findViewById(R.id.b_z);

		b_a.setTypeface(tf);
		b_b.setTypeface(tf);
		b_c.setTypeface(tf);
		b_d.setTypeface(tf);
		b_e.setTypeface(tf);
		b_f.setTypeface(tf);
		b_g.setTypeface(tf);
		b_h.setTypeface(tf);
		b_i.setTypeface(tf);
		b_j.setTypeface(tf);
		b_k.setTypeface(tf);
		b_l.setTypeface(tf);
		b_m.setTypeface(tf);
		b_n.setTypeface(tf);
		b_o.setTypeface(tf);
		b_p.setTypeface(tf);
		b_q.setTypeface(tf);
		b_r.setTypeface(tf);
		b_s.setTypeface(tf);
		b_t.setTypeface(tf);
		b_u.setTypeface(tf);
		b_v.setTypeface(tf);
		b_w.setTypeface(tf);
		b_x.setTypeface(tf);
		b_y.setTypeface(tf);
		b_z.setTypeface(tf);

		b_a.setTag("a");
		b_b.setTag("b");
		b_c.setTag("c");
		b_d.setTag("d");
		b_e.setTag("e");
		b_f.setTag("f");
		b_g.setTag("g");
		b_h.setTag("h");
		b_i.setTag("i");
		b_j.setTag("j");
		b_k.setTag("k");
		b_l.setTag("l");
		b_m.setTag("m");
		b_n.setTag("n");
		b_o.setTag("o");
		b_p.setTag("p");
		b_q.setTag("q");
		b_r.setTag("r");
		b_s.setTag("s");
		b_t.setTag("t");
		b_u.setTag("u");
		b_v.setTag("v");
		b_w.setTag("w");
		b_x.setTag("x");
		b_y.setTag("y");
		b_z.setTag("z");

		buttons = new Button[objectLength];

		buttons[0] = b_a;
		buttons[1] = b_b;
		buttons[2] = b_c;
		buttons[3] = b_d;
		buttons[4] = b_e;
		buttons[5] = b_f;
		buttons[6] = b_g;
		buttons[7] = b_h;
		buttons[8] = b_i;
		buttons[9] = b_j;
		buttons[10] = b_k;
		buttons[11] = b_l;
		buttons[12] = b_m;
		buttons[13] = b_n;
		buttons[14] = b_o;
		buttons[15] = b_p;
		buttons[16] = b_q;
		buttons[17] = b_r;
		buttons[18] = b_s;
		buttons[19] = b_t;
		buttons[20] = b_u;
		buttons[21] = b_v;
		buttons[22] = b_w;
		buttons[23] = b_x;
		buttons[24] = b_y;
		buttons[25] = b_z;

		iv_image = (ImageView) findViewById(R.id.iv_image);
		iv_image.setImageResource(R.drawable.human_1);

		tv_word = (TextView) findViewById(R.id.tv_word);
		tv_word.setTypeface(tf);

		tv_status = (TextView) findViewById(R.id.tv_status);
		tv_status.setTypeface(tf);
		tv_status.setText("Guess the word!");

		// word = "bam";

		String dots = "";
		for (int i = 0; i < word.length(); i++) {
			if (String.valueOf(word.charAt(i)).equalsIgnoreCase(" ")) {
				dots = dots + " ";
			} else {
				dots = dots + "_";
			}
		}

		// show first and last letter
		if (letters == 0) {
			if (word.length() > 3) {
				dots = word.charAt(0) + dots.substring(1, dots.length());
				dots = dots.substring(0, dots.length() - 1)
						+ word.charAt(word.length() - 1);
			}
		}

		tv_word.setText(dots);

		// Toast.makeText(this, word, Toast.LENGTH_SHORT).show();

		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					tv_status.setVisibility(View.INVISIBLE);
					v.setVisibility(View.INVISIBLE);
					String letter = (String) v.getTag();
					String dots = tv_word.getText().toString();
					for (int i = 0; i < word.length(); i++) {
						if (String.valueOf(word.charAt(i)).equalsIgnoreCase(
								letter)) {
							StringBuilder temp = new StringBuilder(dots);
							temp.setCharAt(i, letter.charAt(0));
							dots = String.valueOf(temp);
						}
					}

					if (tv_word.getText().toString().equalsIgnoreCase(dots)) {
						mistakes = mistakes + 1;
						if (easy == 0) {
							setImage();
						} else if (easy == 1) {
							setImageEasy();
						}
					}

					tv_word.setText(dots);

					endGame();
				}
			});
		}
		
		b_new.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				displayInterstitial();
				finish();
			}
		});
	}

	void endGame() {
		if (tv_word.getText().toString().equalsIgnoreCase(word)) {
			tv_status.setText("You Won!");
			tv_status.setVisibility(View.VISIBLE);
			LinearLayout ll = (LinearLayout) findViewById(R.id.lay_keyboard);
			ll.setVisibility(View.INVISIBLE);

			b_new.setVisibility(View.VISIBLE);
		}
		if (mistakes == 6 && easy == 0) {
			tv_status.setText("You Lost!");
			tv_word.setText(word);
			tv_status.setVisibility(View.VISIBLE);
			LinearLayout ll = (LinearLayout) findViewById(R.id.lay_keyboard);
			ll.setVisibility(View.INVISIBLE);

			b_new.setVisibility(View.VISIBLE);
		}
		if (mistakes == 8 && easy == 1) {
			tv_status.setText("You Lost!");
			tv_word.setText(word);
			tv_status.setVisibility(View.VISIBLE);
			LinearLayout ll = (LinearLayout) findViewById(R.id.lay_keyboard);
			ll.setVisibility(View.INVISIBLE);

			b_new.setVisibility(View.VISIBLE);
		}
	}

	void setImage() {
		if (mistakes == 0) {
			iv_image.setImageResource(R.drawable.human_1);
		}
		if (mistakes == 1) {
			iv_image.setImageResource(R.drawable.human_2);
		}
		if (mistakes == 2) {
			iv_image.setImageResource(R.drawable.human_3);
		}
		if (mistakes == 3) {
			iv_image.setImageResource(R.drawable.human_4);
		}
		if (mistakes == 4) {
			iv_image.setImageResource(R.drawable.human_5);
		}
		if (mistakes == 5) {
			iv_image.setImageResource(R.drawable.human_6);
		}
		if (mistakes == 6) {
			iv_image.setImageResource(R.drawable.human_7);
		}
	}

	void setImageEasy() {
		if (mistakes == 0) {
			iv_image.setImageResource(R.drawable.easy_human_1);
		}
		if (mistakes == 1) {
			iv_image.setImageResource(R.drawable.easy_human_2);
		}
		if (mistakes == 2) {
			iv_image.setImageResource(R.drawable.easy_human_3);
		}
		if (mistakes == 3) {
			iv_image.setImageResource(R.drawable.easy_human_4);
		}
		if (mistakes == 4) {
			iv_image.setImageResource(R.drawable.easy_human_5);
		}
		if (mistakes == 5) {
			iv_image.setImageResource(R.drawable.easy_human_6);
		}
		if (mistakes == 6) {
			iv_image.setImageResource(R.drawable.easy_human_7);
		}
		if (mistakes == 7) {
			iv_image.setImageResource(R.drawable.easy_human_8);
		}
		if (mistakes == 8) {
			iv_image.setImageResource(R.drawable.easy_human_9);
		}
	}

	@Override
	public void onBackPressed() {
		if (tv_word.getText().toString().equalsIgnoreCase(word)) {
			displayInterstitial();
			finish();
		} else if (mistakes < 6 && easy == 0) {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					MultiGameActivity.this);
			alertDialogBuilder.setTitle(getResources().getString(R.string.exit));
			alertDialogBuilder
					.setMessage(getResources().getString(R.string.exit_msg))
					.setIcon(R.drawable.ic_launcher)
					.setCancelable(true)
					.setPositiveButton(getResources().getString(R.string.yes),
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();

									Toast.makeText(MultiGameActivity.this,
											word.toUpperCase(),
											Toast.LENGTH_SHORT).show();
								}
							})
					.setNegativeButton(getResources().getString(R.string.no),
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();
		} else if (mistakes < 8 && easy == 1) {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					MultiGameActivity.this);
			alertDialogBuilder.setTitle(getResources().getString(R.string.exit));
			alertDialogBuilder
					.setMessage(getResources().getString(R.string.exit_msg))
					.setIcon(R.drawable.ic_launcher)
					.setCancelable(true)
					.setPositiveButton(getResources().getString(R.string.yes),
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();

									Toast.makeText(MultiGameActivity.this,
											word.toUpperCase(),
											Toast.LENGTH_SHORT).show();
								}
							})
					.setNegativeButton(getResources().getString(R.string.no),
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();
		}
	}

	public void displayInterstitial() {
		if (interstitial.isLoaded()) {
			interstitial.show();
		}
	}
}
