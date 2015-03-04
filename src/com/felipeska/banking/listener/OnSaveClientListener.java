package com.felipeska.banking.listener;

import com.felipeska.banking.error.Error;

public interface OnSaveClientListener {

	public void onSuccessSave();

	public void onFailedSave(Error error);
}
