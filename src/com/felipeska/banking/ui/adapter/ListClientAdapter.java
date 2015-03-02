package com.felipeska.banking.ui.adapter;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.felipeska.banking.R;
import com.felipeska.banking.model.Client;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public final class ListClientAdapter extends BaseAdapter {
	private final LayoutInflater inflater;
	private List<Client> items = Collections.emptyList();
	private final Context context;

	public ListClientAdapter(Context context) {
		this.inflater = LayoutInflater.from(context);
		this.context = context;
	}

	public void call(List<Client> items) {
		this.items = items;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Client getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public String getClientId(int position) {
		return items.get(position).getIdentification();
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.client_item_row, parent,
					false);
		}
		ViewHolder holder = ViewHolder.obtain(convertView);
		final Client client = getItem(position);
		holder.populate(client, context);
		return convertView;
	}

	public static class ViewHolder {
		private final static String FORMAT_DISPLAY_DATA = "%s:  %s";
		@InjectView(R.id.client_name)
		TextView mTextViewName;
		@InjectView(R.id.client_address)
		TextView mTextViewAddress;
		@InjectView(R.id.client_phone)
		TextView mTextViewPhone;

		private ViewHolder(View view) {
			ButterKnife.inject(this, view);
		}

		public void populate(Client client, Context context) {
			String dummyData = context.getString(R.string.not_especified);
			String clientName = client.getName();
			String address = client.getAddress();
			String phone = client.getPhone();
			mTextViewName.setText(String.format(FORMAT_DISPLAY_DATA,
					context.getString(R.string.client), clientName));
			mTextViewAddress.setText(String.format(FORMAT_DISPLAY_DATA,
					context.getString(R.string.address),
					validateEmptyData(address, dummyData)));
			mTextViewPhone.setText(String.format(FORMAT_DISPLAY_DATA,
					context.getString(R.string.phone),
					validateEmptyData(phone, dummyData)));
		}

		private String validateEmptyData(String data, String dummyData) {
			return TextUtils.isEmpty(data) ? dummyData : data;
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
