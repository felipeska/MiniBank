package com.felipeska.banking.ui.adapter;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.felipeska.banking.R;
import com.felipeska.banking.model.Transaction;
import com.felipeska.banking.model.Transaction.TransactionType;
import com.felipeska.banking.utils.DateUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListTransactionAdapter extends BaseAdapter {
	private final LayoutInflater inflater;
	private List<Transaction> items = Collections.emptyList();
	private final Context context;

	public ListTransactionAdapter(Context context) {
		this.inflater = LayoutInflater.from(context);
		this.context = context;
	}

	public void call(List<Transaction> items) {
		this.items = items;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Transaction getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.transaction_item_row,
					parent, false);
		}
		ViewHolder holder = ViewHolder.obtain(convertView);
		final Transaction transaction = getItem(position);
		holder.populate(transaction, context);
		return convertView;
	}

	public static class ViewHolder {
		@InjectView(R.id.transacion_date)
		TextView mTextViewDate;
		@InjectView(R.id.transaction_value)
		TextView mTextViewValue;
		@InjectView(R.id.transaction_type)
		TextView mTextViewType;

		private ViewHolder(View view) {
			ButterKnife.inject(this, view);
		}

		public void populate(Transaction transaction, Context context) {
			mTextViewDate.setText(context.getResources().getString(
					R.string.transaction_date,
					DateUtils.getDateTimeReadable(transaction.getDate())));
			mTextViewValue.setText(context.getResources().getString(
					R.string.transacion_value, transaction.getValue()));
			mTextViewType.setText(context.getResources().getString(
					R.string.transaction_type,
					getTransactionTypeReadable(
							transaction.getTransactionType(), context)));
		}

		private String getTransactionTypeReadable(int type, Context context) {
			TransactionType transactionType = TransactionType
					.getTransactionType(type);
			switch (transactionType) {
			case DEBIT:
				return context.getResources().getString(R.string.debit);
			case CREDIT:
				return context.getResources().getString(R.string.credit);
			default:
				return context.getResources().getString(R.string.debit);
			}
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
