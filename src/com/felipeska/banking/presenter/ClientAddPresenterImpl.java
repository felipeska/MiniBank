package com.felipeska.banking.presenter;

import com.felipeska.banking.error.Error;
import com.felipeska.banking.interactor.AddClientInteractor;
import com.felipeska.banking.interactor.AddClientInteractorImpl;
import com.felipeska.banking.listener.OnSaveClientListener;
import com.felipeska.banking.view.ClientAddView;

public class ClientAddPresenterImpl implements ClientAddPresenter,
		OnSaveClientListener {

	private ClientAddView clientAddView;
	private AddClientInteractor addClientIteractor;

	public ClientAddPresenterImpl(ClientAddView clientAddView) {
		this.clientAddView = clientAddView;
		this.addClientIteractor = new AddClientInteractorImpl();
	}

	@Override
	public void saveClient(String name, String identification, String address,
			String phone) {
		clientAddView.showProgress();
		addClientIteractor.save(name, identification, address, phone, this);
	}

	@Override
	public void onSuccessSave() {
		clientAddView.hideProgress();
		clientAddView.saveClientSuccess();
	}

	@Override
	public void onFailedSave(Error saveError) {
		clientAddView.hideProgress();
		clientAddView.saveClientError(saveError);
	}

}