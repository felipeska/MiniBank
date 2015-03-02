package com.felipeska.banking.presenter;

import java.util.List;

import com.felipeska.banking.interactor.FindClientsIteractor;
import com.felipeska.banking.interactor.FindClientsIteractorImpl;
import com.felipeska.banking.listener.OnFinishedLoadClientsListener;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.view.ClientListView;

public class ClientListPresenterImpl implements ClientListPresenter,
		OnFinishedLoadClientsListener {

	private ClientListView clientListView;
	private FindClientsIteractor findClientsIteractor;

	public ClientListPresenterImpl(ClientListView clientListView) {
		this.clientListView = clientListView;
		findClientsIteractor = new FindClientsIteractorImpl();
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

	@Override
	public void onItemClicked(String clientId) {
		clientListView.clientSelected(clientId);
	}
}
