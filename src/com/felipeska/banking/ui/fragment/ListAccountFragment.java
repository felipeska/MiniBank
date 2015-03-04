package com.felipeska.banking.ui.fragment;

import static android.view.MenuItem.SHOW_AS_ACTION_ALWAYS;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.InjectView;
import butterknife.OnItemClick;

import com.felipeska.banking.R;
import com.felipeska.banking.model.Account;
import com.felipeska.banking.presenter.AccountListPresenter;
import com.felipeska.banking.presenter.AccountListPresenterImpl;
import com.felipeska.banking.ui.adapter.ListAccountAdapter;
import com.felipeska.banking.view.AccountListView;

public class ListAccountFragment extends BaseFragment implements
		AccountListView {

	public interface Listener {
		public void onNewAccountClicked(String name, String clientId);

		public void onItemAccountClicked(String accountNumber, long balance);
	}

	private static final String CLIENT_ID = "client_id";
	private static final String CLIENT_NAME = "client_name";
	public final static String FRAGMENT_ID = "AccountListClient";

	@InjectView(android.R.id.list)
	ListView listView;
	@InjectView(R.id.emptyElement)
	View emptyView;
	@InjectView(R.id.progress)
	ProgressBar progressBar;

	@OnItemClick(android.R.id.list)
	void listClicked(int listId) {
		listener.onItemAccountClicked(adapter.getAccountNumber(listId),
				adapter.getBalance(listId));
	}

	public ListAccountFragment() {
	}

	private ListAccountAdapter adapter;
	private AccountListPresenter presenter;
	private Listener listener;

	public static ListAccountFragment newInstance(String clientId,
			String clientName) {
		ListAccountFragment fragment = new ListAccountFragment();
		Bundle arguments = new Bundle();
		arguments.putString(CLIENT_ID, clientId);
		arguments.putString(CLIENT_NAME, clientName);
		fragment.setArguments(arguments);
		return fragment;
	}

	private String getClientId() {
		return getArguments().getString(CLIENT_ID);
	}

	private String getClientName() {
		return getArguments().getString(CLIENT_NAME);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (!(activity instanceof Listener)) {
			throw new IllegalStateException(
					"Activity must implement fragment Listener."
							+ Listener.class.getSimpleName());
		}
		listener = (Listener) activity;
		adapter = new ListAccountAdapter(activity);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		listView.setAdapter(adapter);
		listView.setEmptyView(emptyView);
		presenter = new AccountListPresenterImpl(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		presenter.findAccounts(getClientId());
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		menu.add(R.string.acccount_list_title)
				.setShowAsActionFlags(SHOW_AS_ACTION_ALWAYS)
				.setIcon(R.drawable.ic_action_new_account)
				.setOnMenuItemClickListener(
						new MenuItem.OnMenuItemClickListener() {
							@Override
							public boolean onMenuItemClick(MenuItem item) {
								Log.d("DAFT_PUNK", "fASTER");
								listener.onNewAccountClicked(getClientName(),
										getClientId());
								return true;
							}
						});
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_list_account;
	}

	@Override
	protected String getTitle() {
		return getResources().getString(R.string.acccount_list_title)
				.concat(" - ").concat(getClientName());
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
	public void setClients(List<Account> accounts) {
		adapter.call(accounts);
	}

}
