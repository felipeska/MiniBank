package com.felipeska.banking.interactor;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.listener.OnSaveClientListener;
import com.felipeska.banking.model.Client;

public class AddClientIteractorImpl implements AddClientIteractor {

	@Override
	public void save(String name, String identification, String address,
			String phone, OnSaveClientListener listener) {
		boolean save = saveClient(name, identification, address, phone);
		if (save) {
			listener.onSuccess();
		} else {
			listener.onFailed(Error.ERROR_SAVE_CLIENT);
		}
	}

	private boolean saveClient(String name, String identification,
			String address, String phone) {
		Client client = new Client(name, identification, address, phone);
		return DatabaseHelper.load().store(client) != null ? true : false;
	}
}
