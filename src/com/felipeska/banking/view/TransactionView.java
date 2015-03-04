package com.felipeska.banking.view;

import com.felipeska.banking.error.Error;

public interface TransactionView {

	public void showProgress();

	public void hideProgress();

	public void transactionSuccess();

	public void transactionError(Error error);

}
