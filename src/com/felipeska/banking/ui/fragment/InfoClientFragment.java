package com.felipeska.banking.ui.fragment;

import butterknife.InjectView;

import com.felipeska.banking.R;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.presenter.ClientPresenter;
import com.felipeska.banking.presenter.ClientPresenterImpl;
import com.felipeska.banking.view.ClientView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class InfoClientFragment extends BaseFragment implements ClientView {

	public final static String FRAGMENT_ID = "ShowClient";
	private static final String CLIENT_ID = "list_id";
	private ClientPresenter clientPresenter;

	@InjectView(R.id.containerInfo)
	View containerView;

	@InjectView(R.id.client_name)
	TextView textViewClientName;

	@InjectView(R.id.client_id)
	TextView textClientId;

	@InjectView(R.id.client_address)
	TextView textClientAddress;

	@InjectView(R.id.client_phone)
	TextView textClientPhone;

	@InjectView(R.id.total_accounts)
	TextView textTotalAccounts;

	@InjectView(R.id.progress)
	ProgressBar progressBar;

	public static InfoClientFragment newInstance(String clientId) {
		InfoClientFragment fragment = new InfoClientFragment();
		Bundle arguments = new Bundle();
		arguments.putString(CLIENT_ID, clientId);
		fragment.setArguments(arguments);
		return fragment;
	}

	public InfoClientFragment() {
	}

	private String getClientId() {
		return getArguments().getString(CLIENT_ID);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.menu_info_client, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_add_account) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		clientPresenter = new ClientPresenterImpl(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		clientPresenter.onClient(getClientId());
	}

	private void populateView(Client client) {
		textViewClientName.setText(client.getName());
		textClientId.setText(client.getIdentification());

		if (!TextUtils.isEmpty(client.getAddress())) {
			textClientAddress.setText(client.getAddress());
		}

		if (!TextUtils.isEmpty(client.getPhone())) {
			textClientPhone.setText(client.getPhone());
		}

		textTotalAccounts.setText(getResources().getString(
				R.string.total_accounts, client.totalAccounts()));
	}

	@Override
	public void showProgress() {
		if (isAdded()) {
			progressBar.setVisibility(View.VISIBLE);
			containerView.setVisibility(View.INVISIBLE);
		}
	}

	@Override
	public void hideProgress() {
		if (isAdded()) {
			progressBar.setVisibility(View.INVISIBLE);
			containerView.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void setClient(Client client) {
		populateView(client);
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_info_client;
	}

	@Override
	protected String getTitle() {
		return getResources().getString(R.string.client_info_title);
	}

	@Override
	protected boolean actionBarEnabled() {
		return true;
	}
}
