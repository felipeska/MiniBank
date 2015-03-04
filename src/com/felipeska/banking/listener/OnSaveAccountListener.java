package com.felipeska.banking.listener;

import com.felipeska.banking.error.Error;

public interface OnSaveAccountListener {
	public void onSuccessSave();

	public void onFailedSave(Error error);
}
