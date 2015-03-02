package com.felipeska.banking.presenter;

import com.felipeska.banking.interactor.FindClientInteractorImpl;
import com.felipeska.banking.interactor.FindClientIteractor;
import com.felipeska.banking.listener.OnFinishedLoadClientListener;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.view.ClientView;

public class ClientPresenterImpl implements ClientPresenter,
		OnFinishedLoadClientListener {

	private ClientView clientView;
	private FindClientIteractor findClientIteractor;

	public ClientPresenterImpl(ClientView clientView) {
		this.clientView = clientView;
		this.findClientIteractor = new FindClientInteractorImpl();
	}

	@Override
	public void onFinished(Client client) {
		this.clientView.setClient(client);
		this.clientView.hideProgress();
	}

	@Override
	public void onClient(String clientId) {
		clientView.showProgress();
		findClientIteractor.findClient(clientId, this);
	}

}
