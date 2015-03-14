package com.texti.hangman;

import com.texti.hangman.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import android.widget.TextView;
import android.widget.Toast;

public class MultiActivity extends ActionBarActivity {

	Typeface tf;

	Button b_a, b_b, b_c, b_d, b_e, b_f, b_g, b_h, b_i, b_j, b_k, b_l, b_m,
	b_n, b_o, b_p, b_q, b_r, b_s, b_t, b_u, b_v, b_w, b_x, b_y, b_z;

	Button b_start, b_delete, b_space;

	TextView tv_word;

	String word;

	Button[] buttons;
	int objectLength = 26;

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
		setContentView(R.layout.activity_multi);

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

		b_start = (Button) findViewById(R.id.b_start);
		b_start.setTypeface(tf);

		b_delete = (Button) findViewById(R.id.b_delete);
		b_delete.setTypeface(tf);

		tv_word = (TextView) findViewById(R.id.tv_word);
		tv_word.setTypeface(tf);
		//tv_word.setHint("Write one or more words to guess!");
		tv_word.setHint(getResources().getString(R.string.write_word));
		

		word = "";
		tv_word.setText(word);

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

		b_space = (Button) findViewById(R.id.b_space);
		b_space.setTypeface(tf);

		b_space.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				word = word + " ";
				tv_word.setText(word);
			}
		});

		b_start.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String temp_word = word.replace(" ", "");

				if (word.length() > 3 && temp_word.length() > 3) {
					SharedPreferences settings = getSharedPreferences("PREFS",
							0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putString("word", word);
					editor.commit();

					Intent next = new Intent(MultiActivity.this,
							MultiGameActivity.class);
					startActivity(next);
				} else {
					b_delete.performClick();
					//Toast.makeText(MultiActivity.this, "Write longer word!", Toast.LENGTH_SHORT).show();
					Toast.makeText(MultiActivity.this, getResources().getString(R.string.longer_word), Toast.LENGTH_SHORT).show();
				}
			}
		});

		b_delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				word = "";
				tv_word.setText(word);
			}
		});

		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					word = word + v.getTag();
					tv_word.setText(word);
				}
			});
		}
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(
				@SuppressWarnings("rawtypes") AdapterView parent, View view,
				int position, long id) {
			if (position == 0) {
				Intent intent = new Intent(MultiActivity.this,
						MenuActivity.class);
				startActivity(intent);
				overridePendingTransition(0, 0);
				finish();
				mDrawerLayout.closeDrawers();
			}
			if (position == 1) {
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
			Intent next = new Intent(MultiActivity.this, MoreActivity.class);
			startActivity(next);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onResume() {
		super.onResume(); // Always call the superclass method first

		word = "";
		tv_word.setText(word);
	}
}
