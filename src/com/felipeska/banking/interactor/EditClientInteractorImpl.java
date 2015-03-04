package com.felipeska.banking.interactor;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.listener.OnEditClientListener;
import com.felipeska.banking.model.Client;

public class EditClientInteractorImpl implements EditClientInteractor {

	@Override
	public void edit(Client oldClient, Client newClient,
			OnEditClientListener listener) {

		boolean edited = edit(oldClient, newClient);

		if (edited) {
			listener.onSuccess();
		} else {
			listener.onFailed(Error.ERROR_EDIT_CLIENT);
		}
	}

	public boolean edit(Client oldClient, Client newClient) {
		return DatabaseHelper.load().update(newClient, oldClient) != null ? true
				: false;
	}

}
