package com.felipeska.banking.ui.fragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.felipeska.banking.R;
import com.felipeska.banking.ui.listener.SupportActionBarListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class AddClientFragment extends Fragment {

	@InjectView(R.id.client_name)
	EditText mEditTextClientName;

	@InjectView(R.id.client_id)
	EditText mEditTextClientId;

	@InjectView(R.id.client_address)
	EditText mEditTextClientAddress;

	@InjectView(R.id.client_phone)
	EditText mEditTextClientPhone;

	public final static String FRAGMENT_ID = "AddClient";
	private SupportActionBarListener actionBarListener;

	public static AddClientFragment newInstance() {
		AddClientFragment fragment = new AddClientFragment();
		return fragment;
	}

	public AddClientFragment() {
	}

	@OnClick(R.id.buttonAddClient)
	void addClient() {

	}

	@OnClick(R.id.buttonExitAddClient)
	void cancelAddClient() {
		actionBarListener.displayClicked();
	}

	@Override
	public void onAttach(Activity activity) {
		if (!(activity instanceof SupportActionBarListener)) {
			throw new IllegalStateException(
					"Activity must implement fragment Listener.");
		}
		super.onAttach(activity);
		setHasOptionsMenu(true);
		actionBarListener = (SupportActionBarListener) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_add_client, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.inject(this, view);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home) {
			actionBarListener.displayClicked();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onResume() {
		super.onResume();
		getActivity().setTitle(getString(R.string.client_add_title));
		actionBarListener.displayHomeAsUpEnabled(true);
	}

	@Override
	public void onPause() {
		super.onPause();
		actionBarListener.displayHomeAsUpEnabled(false);
	}
}
