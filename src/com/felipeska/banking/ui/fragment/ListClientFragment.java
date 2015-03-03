package com.felipeska.banking.ui.fragment;

import java.util.List;

import com.felipeska.banking.R;
import com.felipeska.banking.model.Client;
import com.felipeska.banking.presenter.ClientListPresenter;
import com.felipeska.banking.presenter.ClientListPresenterImpl;
import com.felipeska.banking.ui.adapter.ListClientAdapter;
import com.felipeska.banking.view.ClientListView;
import butterknife.InjectView;
import butterknife.OnItemClick;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import static android.view.MenuItem.SHOW_AS_ACTION_ALWAYS;

public class ListClientFragment extends BaseFragment implements ClientListView {

	public final static String FRAGMENT_ID = "Clients";

	public interface Listener {
		void onNewAddClientClicked();

		void showClient(String id);
	}

	@InjectView(android.R.id.list)
	ListView listView;
	@InjectView(R.id.emptyElement)
	View emptyView;
	@InjectView(R.id.progress)
	ProgressBar progressBar;
	private Listener clientListener;
	private ListClientAdapter adapter;
	private ClientListPresenter presenter;

	@OnItemClick(android.R.id.list)
	void listClicked(int listId) {
		presenter.onItemClicked(adapter.getClientId(listId));
	}

	public static ListClientFragment newInstance() {
		ListClientFragment fragment = new ListClientFragment();
		return fragment;
	}

	public ListClientFragment() {
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		clientListener = (Listener) activity;
		adapter = new ListClientAdapter(activity);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		menu.add(R.string.client)
				.setShowAsActionFlags(SHOW_AS_ACTION_ALWAYS)
				.setIcon(R.drawable.ic_action_client_add)
				.setOnMenuItemClickListener(
						new MenuItem.OnMenuItemClickListener() {
							@Override
							public boolean onMenuItemClick(MenuItem item) {
								clientListener.onNewAddClientClicked();
								return true;
							}
						});
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		listView.setAdapter(adapter);
		listView.setEmptyView(emptyView);
		presenter = new ClientListPresenterImpl(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		presenter.onResume();
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
	public void setClients(List<Client> clients) {
		adapter.call(clients);
	}

	@Override
	public void clientSelected(String clientId) {
		clientListener.showClient(clientId);
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.fragment_list_client;
	}

	@Override
	protected String getTitle() {
		return getResources().getString(R.string.client_list_title);
	}

	@Override
	protected boolean actionBarEnabled() {
		return false;
	}
}
