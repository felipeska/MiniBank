package com.felipeska.banking.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;

import com.felipeska.banking.R;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.error.ErrorMessage;
import com.felipeska.banking.model.Transaction.TransactionType;
import com.felipeska.banking.presenter.TransactionPresenter;
import com.felipeska.banking.presenter.TransactionPresenterImpl;
import com.felipeska.banking.view.TransactionView;
import com.felipeska.banking.widget.CroutonStyle;

import de.keyboardsurfer.android.widget.crouton.Style;

public class TransactionFragment extends BaseFragment implements
		TransactionView {

	public final static String FRAGMENT_ID = "AccountTransaction";
	private TransactionPresenter transactionPresenter;

	@InjectView(R.id.progress)
	ProgressBar progressBar;

	@InjectView(R.id.rootContainer)
	View containerView;

	@InjectView(R.id.account_number)
	TextView textAccountNumber;

	@InjectView(R.id.account_balance)
	TextView textAccountBalance;

	@InjectView(R.id.value)
	EditText editTextValue;

	@InjectView(R.id.radioGroupTransactionType)
	RadioGroup radioGroupTransactionType;

	@OnClick(R.id.buttonSuccess)
	void addClient() {
		validateTransactionData();
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_transaction;
	}

	public final static String ACCOUNT_NUMBER = "account_number";
	public final static String BALANCE = "balance";

	public static TransactionFragment newInstance(String accountNumber,
			long balance) {
		TransactionFragment fragment = new TransactionFragment();
		Bundle arguments = new Bundle();
		arguments.putString(ACCOUNT_NUMBER, accountNumber);
		arguments.putLong(BALANCE, balance);
		fragment.setArguments(arguments);
		return fragment;
	}

	private long getBalance() {
		return getArguments().getLong(BALANCE);
	}

	private String getAccountNumber() {
		return getArguments().getString(ACCOUNT_NUMBER);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		this.transactionPresenter = new TransactionPresenterImpl(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		populateView();
	}

	private void populateView() {
		textAccountNumber.setText(getResources().getString(
				R.string.account_number, getAccountNumber()));
		textAccountBalance.setText(getResources().getString(
				R.string.account_balance, getBalance()));
	}

	@Override
	protected String getTitle() {
		return getResources().getString(R.string.account_transaction_title);
	}

	@Override
	protected boolean actionBarEnabled() {
		return true;
	}

	private void validateTransactionData() {

		if (!TextUtils.isEmpty(editTextValue.getText().toString().trim())) {
			long value = Long.parseLong(editTextValue.getText().toString());
			doTransaction(value);
		} else {
			actionBarListener.displayCroutonMessage(
					getResources().getString(
							R.string.required_fields_add_client),
					CroutonStyle.ALERT);
		}
	}

	private void doTransaction(long value) {
		transactionPresenter.transation(getAccountNumber(), getBalance(),
				value, obtaintTransactionFromRadioGroup());
	}

	private TransactionType obtaintTransactionFromRadioGroup() {
		if (radioGroupTransactionType.getCheckedRadioButtonId() == R.id.radioButtonDebit) {
			return TransactionType.DEBIT;
		} else if (radioGroupTransactionType.getCheckedRadioButtonId() == R.id.radioButtonCredit) {
			return TransactionType.CREDIT;
		} else {
			return TransactionType.DEBIT;
		}
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
	public void transactionSuccess() {
		actionBarListener.displayCroutonMessage(
				getResources().getString(R.string.success_transaction),
				CroutonStyle.CONFIRM);
		actionBarListener.navigateToHome();
	}

	@Override
	public void transactionError(Error error) {
		actionBarListener.displayCroutonMessage(
				ErrorMessage.obtain(error, getResources()), Style.ALERT);
	}
}
