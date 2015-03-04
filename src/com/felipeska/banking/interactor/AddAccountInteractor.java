package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnSaveAccountListener;

public interface AddAccountInteractor {
	public void onSave(String number, String clientId, long balance,
			OnSaveAccountListener listener);
}
