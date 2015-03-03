package com.felipeska.banking.ui.activity;

import com.felipeska.banking.R;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

public abstract class BaseActivity extends ActionBarActivity {

	private Toolbar toolbar;
	final float elevationToolbar = 20.0f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResource());
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		if (toolbar != null) {
			setSupportActionBar(toolbar);
			getSupportActionBar().setElevation(elevationToolbar);
		}
	}

	protected abstract int getLayoutResource();

	protected void setActionBarIcon(int iconRes) {
		toolbar.setNavigationIcon(iconRes);
	}

	protected void enableHomeAsUp(boolean enable) {
		if (toolbar != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
		}
	}

	protected void showCrouton(String message, Style style) {
		final Crouton crouton;
		crouton = Crouton.makeText(this, message, style, R.id.container);
		crouton.show();
	}
}
