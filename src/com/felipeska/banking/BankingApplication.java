package com.felipeska.banking;

import com.felipeska.banking.database.DatabaseSpecs;

import android.app.Application;
import android.content.Context;

public class BankingApplication extends Application {

	private static BankingApplication application;

	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		DatabaseSpecs.create();
	}

	public final static Context getAppContext() {
		return application.getApplicationContext();
	}
}
