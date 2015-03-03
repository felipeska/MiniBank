package com.felipeska.banking.ui.fragment;

import butterknife.InjectView;
import butterknife.OnClick;

import com.felipeska.banking.R;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.presenter.ClientAddPresenter;
import com.felipeska.banking.presenter.ClientAddPresenterImpl;
import com.felipeska.banking.view.ClientAddView;
import com.felipeska.widget.CroutonStyle;

import de.keyboardsurfer.android.widget.crouton.Style;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class AddClientFragment extends BaseFragment implements ClientAddView {

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

	private ClientAddPresenter clientAddPresenter;

	public final static String FRAGMENT_ID = "AddClient";

	public static AddClientFragment newInstance() {
		AddClientFragment fragment = new AddClientFragment();
		return fragment;
	}

	public AddClientFragment() {
	}

	@OnClick(R.id.buttonAddClient)
	void addClient() {
		validateInfoClient();
	}

	@OnClick(R.id.buttonExitAddClient)
	void cancelAddClient() {
		actionBarListener.displayClicked();
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		clientAddPresenter = new ClientAddPresenterImpl(this);
	}

	private void validateInfoClient() {
		final String name = mEditTextClientName.getText().toString();
		final String identification = mEditTextClientId.getText().toString();
		final String address = mEditTextClientAddress.getText().toString();
		final String phone = mEditTextClientPhone.getText().toString();

		if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(identification)) {
			saveClient(name, identification, address, phone);
		} else {
			actionBarListener.displayCroutonMessage(
					getResources().getString(
							R.string.required_fields_add_client),
					CroutonStyle.ALERT);
		}
	}

	private void saveClient(String name, String identification, String address,
			String phone) {
		clientAddPresenter.saveClient(name, identification, address, phone);
	}

	@Override
	public void showProgress() {
		if (isAdded()) {
			progressBar.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void hideProgress() {
		if (isAdded()) {
			progressBar.setVisibility(View.INVISIBLE);
		}
	}

	@Override
	public void saveClientSuccess() {
		actionBarListener.displayCroutonMessage(
				getResources().getString(R.string.success_save_client),
				CroutonStyle.CONFIRM);
		actionBarListener.displayClicked();
	}

	@Override
	public void saveClientError(Error saveError) {
		actionBarListener.displayCroutonMessage(
				getResources().getString(R.string.falied_save_client),
				Style.ALERT);
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_add_client;
	}

	@Override
	protected String getTitle() {
		return getResources().getString(R.string.client_add_title);
	}

	@Override
	protected boolean actionBarEnabled() {
		return true;
	}
}
