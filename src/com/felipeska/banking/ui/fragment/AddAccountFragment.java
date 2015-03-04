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
import com.felipeska.banking.presenter.AccountAddPresenter;
import com.felipeska.banking.presenter.AccountAddPresenterImpl;
import com.felipeska.banking.view.AccountAddView;
import com.felipeska.banking.widget.CroutonStyle;

import de.keyboardsurfer.android.widget.crouton.Style;

public class AddAccountFragment extends BaseFragment implements AccountAddView {

	public final static String FRAGMENT_ID = "AddAccount";
	private static final String CLIENT_ID = "client_id";
	private static final String CLIENT_NAME = "client_name";

	@InjectView(R.id.progress)
	ProgressBar progressBar;

	@InjectView(R.id.rootContainer)
	View containerView;

	@InjectView(R.id.account_number)
	EditText mEditTextNumber;

	@InjectView(R.id.account_balance)
	EditText mEditTextBalance;

	private AccountAddPresenter accountAddPresenter;

	@OnClick(R.id.buttonExit)
	void cancelAddClient() {
		actionBarListener.navigateToHome();
	}

	@OnClick(R.id.buttonSuccess)
	void addAccount() {
		validateInfoAccount();
	}

	public static AddAccountFragment newInstance(String clientId,
			String clientName) {
		AddAccountFragment fragment = new AddAccountFragment();
		Bundle arguments = new Bundle();
		arguments.putString(CLIENT_ID, clientId);
		arguments.putString(CLIENT_NAME, clientName);
		fragment.setArguments(arguments);
		return fragment;
	}

	public AddAccountFragment() {
	}

	private String getClientId() {
		return getArguments().getString(CLIENT_ID);
	}

	private String getClientName() {
		return getArguments().getString(CLIENT_NAME);
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_add_account;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		this.accountAddPresenter = new AccountAddPresenterImpl(this);
	}

	@Override
	protected String getTitle() {
		return getResources().getString(R.string.account_new_title)
				.concat(" - ").concat(getClientName());
	}

	@Override
	protected boolean actionBarEnabled() {
		return true;
	}

	@Override
	public void showProgress() {
		if (isAdded()) {
			containerView.setVisibility(View.INVISIBLE);
			progressBar.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void hideProgress() {
		if (isAdded()) {
			containerView.setVisibility(View.VISIBLE);
			progressBar.setVisibility(View.INVISIBLE);
		}
	}

	@Override
	public void saveAccountSuccess() {
		actionBarListener.displayCroutonMessage(
				getResources().getString(R.string.success_save_account),
				CroutonStyle.CONFIRM);
		actionBarListener.navigateToHome();
	}

	@Override
	public void saveAccountError(Error error) {
		actionBarListener.displayCroutonMessage(
				ErrorMessage.obtain(error, getResources()), Style.ALERT);
	}

	public void validateInfoAccount() {
		String number = mEditTextNumber.getText().toString().trim();
		long balance = 0;
		if (!TextUtils.isEmpty(number)) {
			if (!TextUtils
					.isEmpty(mEditTextBalance.getText().toString().trim())) {
				balance = Long.parseLong(mEditTextBalance.getText().toString()
						.trim());
			}
			accountAddPresenter.saveAccount(number, getClientId(), balance);
		} else {
			actionBarListener.displayCroutonMessage(
					getResources().getString(
							R.string.required_fields_add_client),
					CroutonStyle.ALERT);
		}

	}

}
