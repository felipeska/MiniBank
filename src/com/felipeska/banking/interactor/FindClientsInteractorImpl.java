package com.felipeska.banking.interactor;

import java.util.List;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.listener.OnFinishedLoadClientsListener;
import com.felipeska.banking.model.Client;

public class FindClientsInteractorImpl implements FindClientsInteractor {

	@Override
	public void findClients(final OnFinishedLoadClientsListener listener) {
		listener.onFinished(getClients());
	}

	private List<Client> getClients() {
		return DatabaseHelper.load().findAll(Client.class);
	}

}
