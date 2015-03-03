package com.felipeska.banking.interactor;

import com.felipeska.banking.listener.OnSaveClientListener;

public interface AddClientIteractor {
	void save(String name, String identification, String address, String phone,
			OnSaveClientListener listener);
}
