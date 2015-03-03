package com.felipeska.banking.presenter;

import com.felipeska.banking.error.Error;
import com.felipeska.banking.interactor.AddClientIteractor;
import com.felipeska.banking.interactor.AddClientIteractorImpl;
import com.felipeska.banking.listener.OnSaveClientListener;
import com.felipeska.banking.view.ClientAddView;

public class ClientAddPresenterImpl implements ClientAddPresenter,
		OnSaveClientListener {

	private ClientAddView clientAddView;
	private AddClientIteractor addClientIteractor;

	public ClientAddPresenterImpl(ClientAddView clientAddView) {
		this.clientAddView = clientAddView;
		this.addClientIteractor = new AddClientIteractorImpl();
	}

	@Override
	public void saveClient(String name, String identification, String address,
			String phone) {
		clientAddView.showProgress();
		addClientIteractor.save(name, identification, address, phone, this);
	}

	@Override
	public void onSuccess() {
		clientAddView.hideProgress();
		clientAddView.saveClientSuccess();
	}

	@Override
	public void onFailed(Error saveError) {
		clientAddView.hideProgress();
		clientAddView.saveClientError(saveError);
	}

}