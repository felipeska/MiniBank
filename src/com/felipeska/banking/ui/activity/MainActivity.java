package com.felipeska.banking.ui.activity;

import com.felipeska.banking.R;
import com.felipeska.banking.ui.fragment.AddAccountFragment;
import com.felipeska.banking.ui.fragment.AddClientFragment;
import com.felipeska.banking.ui.fragment.EditClientFragment;
import com.felipeska.banking.ui.fragment.HistoryTransactionsFragment;
import com.felipeska.banking.ui.fragment.InfoClientFragment;
import com.felipeska.banking.ui.fragment.ListAccountFragment;
import com.felipeska.banking.ui.fragment.ListClientFragment;
import com.felipeska.banking.ui.fragment.TransactionFragment;
import com.felipeska.banking.ui.listener.SupportActionBarListener;

import de.keyboardsurfer.android.widget.crouton.Style;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MainActivity extends BaseActivity implements
		ListClientFragment.Listener, InfoClientFragment.Listener,
		ListAccountFragment.Listener, SupportActionBarListener,
		TransactionFragment.Listener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
			loadFragment(ListClientFragment.newInstance(),
					ListClientFragment.FRAGMENT_ID, false);
		}
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.main_activity;
	}

	@Override
	public void onNewAddClientClicked() {
		loadFragment(AddClientFragment.newInstance(),
				AddClientFragment.FRAGMENT_ID, true);
	}

	void loadFragment(Fragment fragment, String id, boolean inStack) {
		if (inStack) {
			getSupportFragmentManager()
					.beginTransaction()
					.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right)
					.replace(R.id.container, fragment, id).addToBackStack(null)
					.commit();
		} else {
			getSupportFragmentManager()
					.beginTransaction()
					.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right)
					.replace(R.id.container, fragment, id).commit();
		}
	}

	@Override
	public void displayHomeAsUpEnabled(boolean display) {
		enableHomeAsUp(display);
	}

	@Override
	public void navigateToHome() {
		getSupportFragmentManager().popBackStack();
	}

	@Override
	public void showClient(String clientId) {
		loadFragment(InfoClientFragment.newInstance(clientId),
				InfoClientFragment.FRAGMENT_ID, true);
	}

	@Override
	public void displayCroutonMessage(String message, Style style) {
		showCrouton(message, style);
	}

	@Override
	public void editClient(String clientId) {
		loadFragment(EditClientFragment.newInstance(clientId),
				EditClientFragment.FRAGMENT_ID, true);
	}

	@Override
	public void showAccounts(String clientId, String clientName) {
		loadFragment(ListAccountFragment.newInstance(clientId, clientName),
				ListAccountFragment.FRAGMENT_ID, true);
	}

	@Override
	public void onNewAccountClicked(String name, String clientId) {
		loadFragment(AddAccountFragment.newInstance(clientId, name),
				AddAccountFragment.FRAGMENT_ID, true);
	}

	@Override
	public void onItemAccountClicked(String accountNumber, long balance) {
		loadFragment(TransactionFragment.newInstance(accountNumber, balance),
				TransactionFragment.FRAGMENT_ID, true);

	}

	@Override
	public void showHistoryCliked(String accountNumber) {
		loadFragment(HistoryTransactionsFragment.newInstance(accountNumber),
				HistoryTransactionsFragment.ID, true);
	}
}
