package com.felipeska.banking.ui.listener;

import de.keyboardsurfer.android.widget.crouton.Style;

public interface SupportActionBarListener {
	public void displayHomeAsUpEnabled(boolean display);

	public void displayClicked();

	public void displayCroutonMessage(String message, Style style);
}