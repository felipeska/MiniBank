package com.felipeska.banking.ui.fragment;

import com.felipeska.banking.ui.listener.SupportActionBarListener;

import butterknife.ButterKnife;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

	protected abstract int getLayoutResource();

	protected abstract String getTitle();

	protected abstract boolean actionBarEnabled();

	protected SupportActionBarListener actionBarListener;

	@Override
	public void onAttach(Activity activity) {
		if (!(activity instanceof SupportActionBarListener)) {
			throw new IllegalStateException(
					"Activity must implement fragment Listener.");
		}
		super.onAttach(activity);
		setHasOptionsMenu(true);
		if (actionBarEnabled()) {
			actionBarListener = (SupportActionBarListener) activity;
		}
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(getLayoutResource(), container, false);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
		if (actionBarEnabled()) {
			actionBarListener.displayHomeAsUpEnabled(false);
		}
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.inject(this, view);
	}

	@Override
	public void onResume() {
		super.onResume();
		getActivity().setTitle(getTitle());
		if (actionBarEnabled()) {
			actionBarListener.displayHomeAsUpEnabled(true);
		}
	}

}
