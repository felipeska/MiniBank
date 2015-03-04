package com.felipeska.banking.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.InjectView;
import butterknife.OnClick;

import com.felipeska.banking.R;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.error.ErrorMessage;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.presenter.ClientEditPresenter;
import com.felipeska.banking.presenter.ClientEditPresenterImpl;
import com.felipeska.banking.presenter.ClientPresenter;
import com.felipeska.banking.presenter.ClientPresenterImpl;
import com.felipeska.banking.view.ClientEditView;
import com.felipeska.banking.view.ClientShowView;
import com.felipeska.banking.widget.CroutonStyle;

public class EditClientFragment extends BaseFragment implements ClientShowView,
		ClientEditView {

	@InjectView(R.id.client_name)
	EditText mEditTextClientName;

	@InjectView(R.id.client_id)
	EditText mEditTextClientId;

	@InjectView(R.id.client_address)
	EditText mEditTextClientAddress;

	@InjectView(R.id.client_phone)
	EditText mEditTextClientPhone;

	@InjectView(R.id.progress)
	ProgressBar progressBar;

	@InjectView(R.id.rootContainer)
	View containerView;

	@OnClick(R.id.buttonExit)
	void cancelEditlCient() {
		actionBarListener.navigateToHome();
	}

	@OnClick(R.id.buttonSuccess)
	void successEditlient() {
		validateInfoClient();
	}

	private ClientPresenter clientPresenter;
	private ClientEditPresenter clientEditPresenter;
	private Client client;

	private static final String CLIENT_ID = "list_id";
	public final static String FRAGMENT_ID = "EditClient";

	public static EditClientFragment newInstance(String clientId) {
		EditClientFragment fragment = new EditClientFragment();
		Bundle arguments = new Bundle();
		arguments.putString(CLIENT_ID, clientId);
		fragment.setArguments(arguments);
		return fragment;
	}

	private String getClientId() {
		return getArguments().getString(CLIENT_ID);
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_add_client;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		clientPresenter = new ClientPresenterImpl(this);
		clientEditPresenter = new ClientEditPresenterImpl(this);
		mEditTextClientId.setEnabled(false);
		mEditTextClientId.setTextColor(getResources().getColor(
				R.color.inactive_color));
	}

	@Override
	protected String getTitle() {
		return getResources().getString(R.string.client_edit_title);
	}

	@Override
	protected boolean actionBarEnabled() {
		return true;
	}

	@Override
	public void onResume() {
		super.onResume();
		clientPresenter.onClient(getClientId());
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

	private void populateView() {
		mEditTextClientName.setText(client.getName());
		mEditTextClientId.setText(client.getIdentification());

		if (!TextUtils.isEmpty(client.getAddress())) {
			mEditTextClientAddress.setText(client.getAddress());
		}

		if (!TextUtils.isEmpty(client.getPhone())) {
			mEditTextClientPhone.setText(client.getPhone());
		}
	}

	@Override
	public void editClientSuccess() {
		actionBarListener.displayCroutonMessage(
				getResources().getString(R.string.success_edit_client),
				CroutonStyle.CONFIRM);
		actionBarListener.navigateToHome();
	}

	@Override
	public void editClientError(Error error) {
		actionBarListener.displayCroutonMessage(
				ErrorMessage.obtain(error, getResources()), CroutonStyle.ALERT);
	}

	private void validateInfoClient() {
		final String name = mEditTextClientName.getText().toString();
		final String address = mEditTextClientAddress.getText().toString();
		final String phone = mEditTextClientPhone.getText().toString();

		if (!TextUtils.isEmpty(name)) {
			editClient(name, address, phone);
		} else {
			actionBarListener.displayCroutonMessage(
					getResources().getString(
							R.string.required_fields_add_client),
					CroutonStyle.ALERT);
		}
	}

	private void editClient(String name, String address, String phone) {
		Client updateClient = new Client(name, client.getIdentification(),
				address, phone);
		clientEditPresenter.editClient(client, updateClient);
	}

}
