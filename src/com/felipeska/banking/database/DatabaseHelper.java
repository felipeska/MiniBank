package com.felipeska.banking.database;

import java.util.List;
import com.codeslap.persistence.Persistence;
import com.codeslap.persistence.SqlAdapter;
import com.felipeska.banking.BankingApplication;

public class DatabaseHelper {

	public static final int DATABASE_VERSION = 1;
	static volatile DatabaseHelper singleton = null;
	private SqlAdapter adapter;

	DatabaseHelper() {
		adapter = getAdapter();
	}

	public static DatabaseHelper load() {
		if (singleton == null) {
			synchronized (DatabaseHelper.class) {
				if (singleton == null) {
					singleton = new DatabaseHelper();
				}
			}
		}
		return singleton;
	}

	private SqlAdapter getAdapter() {
		return Persistence.getAdapter(BankingApplication.getAppContext());
	}

	public <T> List<T> findAll(Class<T> modelClass) {
		return adapter.findAll(modelClass);
	}

	public <T> T find(T object) {
		return adapter.findFirst(object);
	}

	public <T> Object store(T object) {
		return adapter.store(object);
	}

}
