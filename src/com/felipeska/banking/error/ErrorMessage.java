package com.felipeska.banking.error;

import com.felipeska.banking.R;
import android.content.res.Resources;

public final class ErrorMessage {

	public ErrorMessage() {
	}

	public static String obtain(Error error, Resources res) {

		switch (error) {
		case CLIENT_ALREADY_REGISTERED:
			return res.getString(R.string.warning_add_client);
		case ERROR_DELETE_CLIENT:
			return res.getString(R.string.failed_delete_client);
		case ERROR_SAVE_CLIENT:
			return res.getString(R.string.falied_save_client);
		case ERROR_EDIT_CLIENT:
			return res.getString(R.string.failed_edit_client);
		case ERROR_SAVE_ACCOUNT:
			return res.getString(R.string.failed_save_account);
		case ACCOUNT_ALREADY_REGISTERED:
			return res.getString(R.string.warning_save_account);
		case NO_HAVE_MONEY:
			return res.getString(R.string.no_have_money);
		case TRANSACTION_ERROR:
			return res.getString(R.string.failed_transaction);
		default:
			return res.getString(R.string.unknown_error);
		}
	}
}
