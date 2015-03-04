package com.felipeska.banking.presenter;

import com.felipeska.banking.error.Error;
import com.felipeska.banking.interactor.DeleteClientInteractor;
import com.felipeska.banking.interactor.DeleteClientInteractorImpl;
import com.felipeska.banking.listener.OnDeleteClientListener;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.view.ClientDeleteView;

public class ClientDeletePresenterImpl implements ClientDeletePresenter,
		OnDeleteClientListener {

	private ClientDeleteView clientDeleteView;
	private DeleteClientInteractor deleteClientIteractor;

	public ClientDeletePresenterImpl(ClientDeleteView clientDeleteView) {
		this.clientDeleteView = clientDeleteView;
		this.deleteClientIteractor = new DeleteClientInteractorImpl();
	}

	@Override
	public void deleteClient(Client client) {
		this.clientDeleteView.showProgress();
		this.deleteClientIteractor.delete(client, this);
	}

	@Override
	public void onSuccess() {
		clientDeleteView.hideProgress();
		clientDeleteView.deleteClientSuccess();
	}

	@Override
	public void onFailed(Error error) {
		clientDeleteView.hideProgress();
		clientDeleteView.deleteClientError(error);
	}

}
