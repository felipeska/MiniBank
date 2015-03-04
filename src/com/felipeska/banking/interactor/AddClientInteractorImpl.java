package com.felipeska.banking.interactor;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.listener.OnSaveClientListener;
import com.felipeska.banking.model.Client;

public class AddClientInteractorImpl implements AddClientInteractor {

	@Override
	public void save(String name, String identification, String address,
			String phone, OnSaveClientListener listener) {
		if (existClient(identification)) {
			listener.onFailedSave(Error.CLIENT_ALREADY_REGISTERED);
		} else {
			boolean saved = saveClient(name, identification, address, phone);
			if (saved) {
				listener.onSuccessSave();
			} else {
				listener.onFailedSave(Error.ERROR_SAVE_CLIENT);
			}
		}
	}

	private boolean saveClient(String name, String identification,
			String address, String phone) {
		Client client = new Client(name, identification, address, phone);
		return DatabaseHelper.load().store(client) != null ? true : false;
	}

	private boolean existClient(String identification) {
		Client clientToFind = new Client();
		clientToFind.setIdentification(identification);
		return DatabaseHelper.load().find(clientToFind) != null ? true : false;
	}
}
