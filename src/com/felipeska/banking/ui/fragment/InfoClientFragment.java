package com.felipeska.banking.ui.fragment;

import butterknife.InjectView;

import com.felipeska.banking.R;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.error.ErrorMessage;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.presenter.ClientDeletePresenter;
import com.felipeska.banking.presenter.ClientDeletePresenterImpl;
import com.felipeska.banking.presenter.ClientPresenter;
import com.felipeska.banking.presenter.ClientPresenterImpl;
import com.felipeska.banking.view.ClientDeleteView;
import com.felipeska.banking.view.ClientShowView;
import com.felipeska.banking.widget.CroutonStyle;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class InfoClientFragment extends BaseFragment implements ClientShowView,
		ClientDeleteView {

	public interface Listener {
		void editClient(String clientId);

		void showAccounts(String clientId);
	}

	public final static String FRAGMENT_ID = "ShowClient";
	private static final String CLIENT_ID = "list_id";
	private ClientPresenter clientPresenter;
	private ClientDeletePresenter clientDeletePresenter;
	private Listener listener;

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

	private Client client;

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
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (Listener) activity;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.menu_info_client, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_add_account) {
			listener.showAccounts(client.getIdentification());
		} else if (id == R.id.action_delete_user) {
			deleteUser();
		} else if (id == R.id.action_edit_user) {
			listener.editClient(client.getIdentification());
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		clientPresenter = new ClientPresenterImpl(this);
		clientDeletePresenter = new ClientDeletePresenterImpl(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		clientPresenter.onClient(getClientId());
	}

	private void populateView() {
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
		this.client = client;
		populateView();
	}

	private void deleteUser() {
		if (this.client.hasAccounts()) {
			actionBarListener.displayCroutonMessage(
					getString(R.string.warning_delete_client),
					CroutonStyle.ALERT);
		} else {
			this.clientDeletePresenter.deleteClient(client);
		}

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

	@Override
	public void deleteClientSuccess() {
		actionBarListener
				.displayCroutonMessage(
						getString(R.string.success_delete_client),
						CroutonStyle.CONFIRM);
		actionBarListener.navigateToHome();
	}

	@Override
	public void deleteClientError(Error error) {
		actionBarListener.displayCroutonMessage(
				ErrorMessage.obtain(error, getResources()), CroutonStyle.ALERT);
	}
}
