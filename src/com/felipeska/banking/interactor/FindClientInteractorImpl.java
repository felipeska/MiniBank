package com.felipeska.banking.interactor;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.listener.OnFinishedLoadClientListener;
import com.felipeska.banking.model.Client;

public class FindClientInteractorImpl implements FindClientInteractor {

	@Override
	public void findClient(String clientId,
			OnFinishedLoadClientListener listener) {
		listener.onFinished(getClient(clientId));
	}

	private Client getClient(String clientId) {
		Client clientToFind = new Client();
		clientToFind.setIdentification(clientId);
		return DatabaseHelper.load().find(clientToFind);
	}
}
