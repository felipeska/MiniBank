package com.felipeska.banking.view;

import com.felipeska.banking.error.Error;

public interface ClientAddView {
	public void showProgress();

	public void hideProgress();

	public void saveClientSuccess();

	public void saveClientError(Error error);
}
