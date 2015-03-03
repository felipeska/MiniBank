package com.felipeska.banking.database;

import com.codeslap.persistence.DatabaseSpec;
import com.codeslap.persistence.HasMany;
import com.codeslap.persistence.PersistenceConfig;
import com.felipeska.banking.model.Account;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.model.Transaction;

public class DatabaseSpecs {

	public static final int DATABASE_VERSION = 1;
	private static String fOREIGN_KEY_CLIENT = "identification";
	private static String FOREIGN_KEY_ACCOUNT = "number";

	public static void create() {
		DatabaseSpec database = PersistenceConfig
				.registerSpec(DATABASE_VERSION);
		database.matchNotAutoIncrement(new HasMany(Client.class, Account.class,
				fOREIGN_KEY_CLIENT));
		database.match(new HasMany(Account.class, Transaction.class,
				FOREIGN_KEY_ACCOUNT));
	}

}
