package com.felipeska.banking.database;

import com.codeslap.persistence.DatabaseSpec;
import com.codeslap.persistence.HasMany;
import com.codeslap.persistence.PersistenceConfig;
import com.felipeska.banking.model.Account;
import com.felipeska.banking.model.Client;

public class DatabaseSpecs {

	public static void create() {
		DatabaseSpec database = PersistenceConfig
				.registerSpec(DatabaseHelper.DATABASE_VERSION);
		database.matchNotAutoIncrement(new HasMany(Client.class, Account.class,
				"identification"));
	}

}
