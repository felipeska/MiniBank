package com.felipeska.banking.ui.fragment;

import java.util.List;

import butterknife.InjectView;

import com.felipeska.banking.R;
import com.felipeska.banking.model.Transaction;
import com.felipeska.banking.presenter.TransactionHistoryPresenter;
import com.felipeska.banking.presenter.TransactionHistoryPresenterImpl;
import com.felipeska.banking.ui.adapter.ListTransactionAdapter;
import com.felipeska.banking.view.TransactionHistoryView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

public class HistoryTransactionsFragment extends BaseFragment implements
		TransactionHistoryView {

	public final static String ACCOUNT_NUMBER = "account_number";
	public final static String ID = "AccountHistory";

	@InjectView(android.R.id.list)
	ListView listView;
	@InjectView(R.id.emptyElement)
	View emptyView;
	@InjectView(R.id.progress)
	ProgressBar progressBar;
	private ListTransactionAdapter adapter;
	private TransactionHistoryPresenter presenter;

	public static HistoryTransactionsFragment newInstance(String accountNumber) {
		HistoryTransactionsFragment fragment = new HistoryTransactionsFragment();
		Bundle args = new Bundle();
		args.putString(ACCOUNT_NUMBER, accountNumber);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		adapter = new ListTransactionAdapter(activity);
		presenter = new TransactionHistoryPresenterImpl(this);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		listView.setAdapter(adapter);
		listView.setEmptyView(emptyView);
	}

	@Override
	public void onResume() {
		super.onResume();
		presenter.findHistory(getAccountNumber());
	}

	private String getAccountNumber() {
		return getArguments().getString(ACCOUNT_NUMBER);
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_history_transactions;
	}

	@Override
	protected String getTitle() {
		return getResources().getString(R.string.account_history,
				getAccountNumber());
	}

	@Override
	protected boolean actionBarEnabled() {
		return true;
	}

	@Override
	public void showProgress() {
		if (isAdded()) {
			progressBar.setVisibility(View.VISIBLE);
			listView.setVisibility(View.INVISIBLE);
			emptyView.setVisibility(View.INVISIBLE);
		}
	}

	@Override
	public void hideProgress() {
		if (isAdded()) {
			progressBar.setVisibility(View.INVISIBLE);
			listView.setVisibility(View.VISIBLE);
			listView.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void setClients(List<Transaction> transactions) {
		adapter.call(transactions);
	}

}
