package com.felipeska.banking.view;

import com.felipeska.banking.error.Error;

public interface ClientEditView {

	public void showProgress();

	public void hideProgress();

	public void editClientSuccess();

	public void editClientError(Error error);

}
