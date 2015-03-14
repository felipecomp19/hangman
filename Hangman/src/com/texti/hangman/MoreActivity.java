package com.texti.hangman;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.texti.hangman.R;

public class MoreActivity extends ActionBarActivity {

	Typeface tf;

	TextView tv_games_won;
	TextView tv_games_lost;
	TextView tx_games_won;
	TextView tx_games_lost;

	Button b_clear, b_download;

	CheckBox cb_keyboard, cb_easy, cb_letters;

	String keyboard;
	int easy;
	int letters;

	int win, lose;

	private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more);

		// Create the interstitial.
		interstitial = new InterstitialAd(this);
		//interstitial.setAdUnitId("ca-app-pub-7124948529897131/3832547282");
		interstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));

		// Create ad request.
		AdRequest adRequest = new AdRequest.Builder().build();

		// Begin loading your interstitial.
		interstitial.loadAd(adRequest);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		tf = Typeface.createFromAsset(getAssets(), "font.ttf");

		SharedPreferences settings = getSharedPreferences("PREFS", 0);
		keyboard = settings.getString("keyboard", "classic");
		easy = settings.getInt("easy", 1);
		letters = settings.getInt("letters", 1);
		win = settings.getInt("win", 0);
		lose = settings.getInt("lose", 0);
		
		//vitorias
		tx_games_won = (TextView) findViewById(R.id.tx_games_won);
		tx_games_won.setTypeface(tf);
		tv_games_won = (TextView) findViewById(R.id.tv_games_won);
		tv_games_won.setTypeface(tf);
		tv_games_won.setText(String.valueOf(win));
		
		//derrotas
		tx_games_lost = (TextView) findViewById(R.id.tx_games_lost);
		tx_games_lost.setTypeface(tf);
		tv_games_lost = (TextView) findViewById(R.id.tv_games_lost);
		tv_games_lost.setTypeface(tf);
		tv_games_lost.setText(String.valueOf(lose));

		b_download = (Button) findViewById(R.id.b_download);
		b_download.setTypeface(tf);

		b_download.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Uri uri = Uri
						.parse("market://details?id=com.rogamen.hangman");
				Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
				try {
					startActivity(goToMarket);
				} catch (ActivityNotFoundException e) {
					/*startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("http://play.google.com/store/apps/details?id=com.rogamen.hangman")));*/
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("http://play.google.com/")));
				}
			}
		});

		b_clear = (Button) findViewById(R.id.b_clear);
		b_clear.setTypeface(tf);

		b_clear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				win = 0;
				lose = 0;
				SharedPreferences settings = getSharedPreferences("PREFS", 0);
				SharedPreferences.Editor editor = settings.edit();
				editor.putInt("win", win);
				editor.putInt("lose", lose);
				editor.commit();
				tv_games_won.setText(String.valueOf(win));
				tv_games_lost.setText(String.valueOf(lose));
			}
		});

		cb_letters = (CheckBox) findViewById(R.id.cb_letters);
		cb_letters.setTypeface(tf);

		if (letters == 1) {
			cb_letters.setChecked(true);
		} else if (letters == 0) {
			cb_letters.setChecked(false);
		}

		cb_letters.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (cb_letters.isChecked()) {
					SharedPreferences settings = getSharedPreferences("PREFS",
							0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putInt("letters", 1);
					editor.commit();
				} else {
					SharedPreferences settings = getSharedPreferences("PREFS",
							0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putInt("letters", 0);
					editor.commit();
				}
			}
		});

		cb_easy = (CheckBox) findViewById(R.id.cb_easy);
		cb_easy.setTypeface(tf);

		if (easy == 1) {
			cb_easy.setChecked(true);
		} else if (easy == 0) {
			cb_easy.setChecked(false);
		}

		cb_easy.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (cb_easy.isChecked()) {
					SharedPreferences settings = getSharedPreferences("PREFS",
							0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putInt("easy", 1);
					editor.commit();
				} else {
					SharedPreferences settings = getSharedPreferences("PREFS",
							0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putInt("easy", 0);
					editor.commit();
				}
			}
		});

		cb_keyboard = (CheckBox) findViewById(R.id.cb_keyboard);
		cb_keyboard.setTypeface(tf);

		if (keyboard.equalsIgnoreCase("classic")) {
			cb_keyboard.setChecked(true);
		} else if (keyboard.equalsIgnoreCase("new")) {
			cb_keyboard.setChecked(false);
		}

		cb_keyboard.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (cb_keyboard.isChecked()) {
					SharedPreferences settings = getSharedPreferences("PREFS",
							0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putString("keyboard", "classic");
					editor.commit();
				} else {
					SharedPreferences settings = getSharedPreferences("PREFS",
							0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putString("keyboard", "new");
					editor.commit();
				}
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			displayInterstitial();
			super.onBackPressed();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void displayInterstitial() {
		if (interstitial.isLoaded()) {
			interstitial.show();
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		displayInterstitial();
		super.onBackPressed();
	}

}
