package com.felipeska.banking.listener;

import com.felipeska.banking.error.Error;

public interface OnEditClientListener {
	public void onSuccess();

	public void onFailed(Error error);
}
