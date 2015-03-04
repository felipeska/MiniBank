package com.felipeska.banking.ui.adapter;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.felipeska.banking.R;
import com.felipeska.banking.model.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAccountAdapter extends BaseAdapter {
	private final LayoutInflater inflater;
	private List<Account> items = Collections.emptyList();
	private final Context context;

	public ListAccountAdapter(Context context) {
		this.inflater = LayoutInflater.from(context);
		this.context = context;
	}

	public void call(List<Account> items) {
		this.items = items;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Account getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public String getAccountNumber(int position) {
		return getItem(position).getNumber();
	}

	public long getBalance(int position) {
		return getItem(position).getBalance();
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.account_item_row, parent,
					false);
		}
		ViewHolder holder = ViewHolder.obtain(convertView);
		final Account account = getItem(position);
		holder.populate(account, context);
		return convertView;
	}

	public static class ViewHolder {
		@InjectView(R.id.account_number)
		TextView mTextViewNumber;
		@InjectView(R.id.account_balance)
		TextView mTextViewBalance;

		private ViewHolder(View view) {
			ButterKnife.inject(this, view);
		}

		public void populate(Account account, Context context) {
			mTextViewNumber.setText(context.getString(R.string.account_number,
					account.getNumber()));
			mTextViewBalance.setText(context.getString(
					R.string.account_balance, account.getBalance()));
		}

		public static ViewHolder obtain(View view) {
			ViewHolder holder = (ViewHolder) view.getTag();
			if (holder == null) {
				holder = new ViewHolder(view);
				view.setTag(holder);
			}
			return holder;
		}

	}

}
