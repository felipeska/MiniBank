package com.felipeska.banking.listener;

import com.felipeska.banking.error.Error;

public interface OnTransactionListener {
	public void onSuccessTransaction();

	public void onFailedTransaction(Error error);
}
