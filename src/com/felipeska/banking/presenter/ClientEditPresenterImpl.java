package com.felipeska.banking.presenter;

import com.felipeska.banking.error.Error;
import com.felipeska.banking.interactor.EditClientInteractor;
import com.felipeska.banking.interactor.EditClientInteractorImpl;
import com.felipeska.banking.listener.OnEditClientListener;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.view.ClientEditView;

public class ClientEditPresenterImpl implements ClientEditPresenter,
		OnEditClientListener {

	private ClientEditView clientEditView;
	private EditClientInteractor editClientIteractor;

	public ClientEditPresenterImpl(ClientEditView clientEditView) {
		this.clientEditView = clientEditView;
		this.editClientIteractor = new EditClientInteractorImpl();
	}

	@Override
	public void editClient(Client oldClient, Client newClient) {
		this.clientEditView.showProgress();
		this.editClientIteractor.edit(oldClient, newClient, this);
	}

	@Override
	public void onSuccess() {
		this.clientEditView.hideProgress();
		this.clientEditView.editClientSuccess();
	}

	@Override
	public void onFailed(Error error) {
		this.clientEditView.hideProgress();
		this.clientEditView.editClientError(error);
	}

}
