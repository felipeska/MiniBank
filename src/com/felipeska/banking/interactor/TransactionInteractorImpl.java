package com.felipeska.banking.interactor;

import java.util.Date;
import com.felipeska.banking.database.DatabaseHelper;
import com.felipeska.banking.error.Error;
import com.felipeska.banking.listener.OnTransactionListener;
import com.felipeska.banking.model.Account;
import com.felipeska.banking.model.Transaction;
import com.felipeska.banking.model.Transaction.TransactionType;

public class TransactionInteractorImpl implements TransactionInteractor {

	@Override
	public void transation(String accountNumber, long balance,
			long transactionValue, TransactionType transactionType,
			OnTransactionListener listener) {
		boolean transactionIsPossible = validateTransactionType(
				transactionValue, balance, transactionType);
		if (transactionIsPossible) {
			boolean success = makeTransaction(balance, transactionValue,
					transactionType, accountNumber);
			if (success) {
				listener.onSuccessTransaction();
			} else {
				listener.onFailedTransaction(Error.TRANSACTION_ERROR);
			}
		} else {
			listener.onFailedTransaction(Error.NO_HAVE_MONEY);
		}
	}

	private boolean makeTransaction(long balance, long value,
			TransactionType transactionType, String accountNumber) {
		long newValue = 0;
		switch (transactionType) {
		case CREDIT:
			newValue = balance - value;
			break;
		case DEBIT:
			newValue = balance + value;
		default:
			break;
		}

		if (updateAccount(newValue, accountNumber)
				&& saveTransaction(transactionType.getValue(),
						new Date().getTime(), newValue, accountNumber)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validateTransactionType(long value, long balance,
			TransactionType transactionType) {
		Transaction transaction = new Transaction();
		switch (transactionType) {
		case CREDIT:
			if (transaction.havePositiveBalance(balance, value)) {
				return true;
			} else {
				return false;
			}
		case DEBIT:
			return true;
		default:
			return false;
		}
	}

	private boolean updateAccount(long newBalance, String accountNumber) {
		Account oldAccount = new Account();
		oldAccount.setNumber(accountNumber);

		Account newAccount = new Account();
		newAccount.setNumber(accountNumber);
		newAccount.setBalance(newBalance);
		return DatabaseHelper.load().update(newAccount, oldAccount) != null ? true
				: false;
	}

	private boolean saveTransaction(int transtactionType, long date,
			float value, String account_number) {
		Transaction transaction = new Transaction(transtactionType, date,
				value, account_number);
		return DatabaseHelper.load().store(transaction) != null ? true : false;
	}
}
