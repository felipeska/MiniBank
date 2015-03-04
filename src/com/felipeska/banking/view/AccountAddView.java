package com.felipeska.banking.view;

import com.felipeska.banking.error.Error;

public interface AccountAddView {
	public void showProgress();

	public void hideProgress();

	public void saveAccountSuccess();

	public void saveAccountError(Error error);

}
