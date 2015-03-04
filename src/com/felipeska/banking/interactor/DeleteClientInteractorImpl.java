package com.felipeska.banking.interactor;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.listener.OnDeleteClientListener;
import com.felipeska.banking.model.Client;

public class DeleteClientInteractorImpl implements DeleteClientInteractor {

	@Override
	public void delete(Client client, OnDeleteClientListener listener) {
		boolean deleted = deleteClient(client);

		if (deleted) {
			listener.onSuccess();
		} else {
			listener.onFailed(Error.ERROR_DELETE_CLIENT);
		}
	}

	private boolean deleteClient(final Client client) {
		return DatabaseHelper.load().delete(client) != null ? true : false;
	}

}
