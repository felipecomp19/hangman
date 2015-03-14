package com.texti.hangman;

import java.util.Random;

import com.texti.hangman.R;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MenuActivity extends ActionBarActivity {

	Typeface tf;

	Button b_countries, b_cities, b_movies, b_cars, b_animals, b_seas,
			b_fruits, b_celebs;

	Random r;

	Resources res;
	String[] countries, cities, movies, cars, animals, seas, fruits, celebs;

	// menu
	private String[] mActivityTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private CharSequence mTitle;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		// menu
		mActivityTitles = getResources().getStringArray(R.array.activity_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// Set the adapter for the list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mActivityTitles));
		// Set the list's click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* nav drawer icon to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description */
		R.string.drawer_close /* "close drawer" description */
		) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				//getSupportActionBar().setTitle("Hangman");
				getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getSupportActionBar().setTitle("Menu");
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		// -----------------------------------------------------------------

		tf = Typeface.createFromAsset(getAssets(), "font.ttf");

		r = new Random();

		res = getResources();
		countries = res.getStringArray(R.array.countries);
		cities = res.getStringArray(R.array.cities);
		movies = res.getStringArray(R.array.movies);
		cars = res.getStringArray(R.array.cars);
		animals = res.getStringArray(R.array.animals);
		seas = res.getStringArray(R.array.seas);
		fruits = res.getStringArray(R.array.fruits);
		celebs = res.getStringArray(R.array.celebs);

		b_countries = (Button) findViewById(R.id.b_countries);
		b_countries.setTypeface(tf);

		b_countries.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame(v, countries);
			}
		});

		b_cities = (Button) findViewById(R.id.b_cities);
		b_cities.setTypeface(tf);

		b_cities.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame(v, cities);
			}
		});

		b_movies = (Button) findViewById(R.id.b_movies);
		b_movies.setTypeface(tf);

		b_movies.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame(v, movies);
			}
		});

		b_cars = (Button) findViewById(R.id.b_cars);
		b_cars.setTypeface(tf);

		b_cars.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame(v, cars);
			}
		});

		b_animals = (Button) findViewById(R.id.b_animals);
		b_animals.setTypeface(tf);

		b_animals.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame(v, animals);
			}
		});

		b_seas = (Button) findViewById(R.id.b_seas);
		b_seas.setTypeface(tf);

		b_seas.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame(v, seas);
			}
		});

		b_fruits = (Button) findViewById(R.id.b_fruits);
		b_fruits.setTypeface(tf);

		b_fruits.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame(v, fruits);
			}
		});

		b_celebs = (Button) findViewById(R.id.b_celebs);
		b_celebs.setTypeface(tf);

		b_celebs.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame(v, celebs);
			}
		});
	}

	void startGame(View v, String[] category) {
		int temp = r.nextInt(category.length);

		SharedPreferences settings = getSharedPreferences("PREFS", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("word", category[temp]);
		editor.putString("category", ((Button) v).getText().toString());
		editor.commit();

		Intent next = new Intent(MenuActivity.this, GameActivity.class);
		startActivity(next);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(
				@SuppressWarnings("rawtypes") AdapterView parent, View view,
				int position, long id) {
			if (position == 0) {
				mDrawerLayout.closeDrawers();
			}
			if (position == 1) {
				Intent intent = new Intent(MenuActivity.this,
						MultiActivity.class);
				startActivity(intent);
				overridePendingTransition(0, 0);
				finish();
				mDrawerLayout.closeDrawers();
			}
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		switch (item.getItemId()) {
		case R.id.item_stats:
			Intent next = new Intent(MenuActivity.this, MoreActivity.class);
			startActivity(next);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
