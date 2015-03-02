package com.felipeska.banking;

import java.util.Arrays;
import java.util.List;

import com.codeslap.persistence.Persistence;
import com.felipeska.banking.database.DatabaseSpecs;
import com.felipeska.banking.model.Account;
import com.felipeska.banking.model.Client;

import android.app.Application;
import android.content.Context;

public class BankingApplication extends Application {

	private static BankingApplication application;

	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		DatabaseSpecs.create();
		loadFakeData();
	}

	public final static Context getAppContext() {
		return application.getApplicationContext();
	}

	// TODO: fake data - remove this method please
	private void loadFakeData() {
		List<Client> clients = Arrays.asList(new Client("Felipe Calderon",
				"12456786", "Cra 117 # 89 A 25 INT 11-104", "3163320944"),
				new Client("Bart Simpson", "12345678", "EventGreen Avenue",
						"3163334544"), new Client("Homero J Simspon",
						"239028509"));
		Persistence.getAdapter(getApplicationContext()).storeCollection(
				clients, null);
		Account citibankAccount = new Account("42425345", "12456786");
		Persistence.getAdapter(getApplicationContext()).store(citibankAccount);
	}
}
