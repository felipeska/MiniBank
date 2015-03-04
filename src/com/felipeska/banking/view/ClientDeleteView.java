package com.felipeska.banking.view;

import com.felipeska.banking.error.Error;

public interface ClientDeleteView {

	public void showProgress();

	public void hideProgress();

	public void deleteClientSuccess();

	public void deleteClientError(Error error);

}
