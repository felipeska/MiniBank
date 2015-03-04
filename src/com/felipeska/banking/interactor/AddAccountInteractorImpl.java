package com.felipeska.banking.interactor;

import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.listener.OnSaveAccountListener;
import com.felipeska.banking.model.Account;
import com.felipeska.banking.model.Account.Status;

public class AddAccountInteractorImpl implements AddAccountInteractor {

	@Override
	public void onSave(String number, String clientId, long balance,
			OnSaveAccountListener listener) {
		boolean existAccount = existAccount(number);
		if (existAccount) {
			listener.onFailedSave(Error.ACCOUNT_ALREADY_REGISTERED);
		} else {
			boolean saved = saveAccount(number, clientId, balance);
			if (saved) {
				listener.onSuccessSave();
			} else {
				listener.onFailedSave(Error.ERROR_SAVE_ACCOUNT);
			}
		}
	}

	private boolean saveAccount(String number, String clientId, long balance) {
		Account newAccount = new Account(number, clientId, balance,
				Status.ACTIVE.getValue());
		return DatabaseHelper.load().store(newAccount) != null ? true : false;
	}

	private boolean existAccount(String number) {
		Account existAccount = new Account();
		existAccount.setNumber(number);
		return DatabaseHelper.load().find(existAccount) != null ? true : false;
	}
}
