package com.felipeska.banking.presenter;

import java.util.List;

import com.felipeska.banking.interactor.FindClientsInteractor;
import com.felipeska.banking.interactor.FindClientsInteractorImpl;
import com.felipeska.banking.listener.OnFinishedLoadClientsListener;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.view.ClientListView;

public class ClientListPresenterImpl implements ClientListPresenter,
		OnFinishedLoadClientsListener {

	private ClientListView clientListView;
	private FindClientsInteractor findClientsIteractor;

	public ClientListPresenterImpl(ClientListView clientListView) {
		this.clientListView = clientListView;
		findClientsIteractor = new FindClientsInteractorImpl();
	}

	@Override
	public void onFinished(List<Client> items) {
		clientListView.setClients(items);
		clientListView.hideProgress();
	}

	@Override
	public void onResume() {
		clientListView.showProgress();
		findClientsIteractor.findClients(this);
	}
}
