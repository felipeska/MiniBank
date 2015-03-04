// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ListClientAdapter$ViewHolder$$ViewInjector<T extends com.felipeska.banking.ui.adapter.ListClientAdapter.ViewHolder> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296323, "field 'mTextViewPhone'");
    target.mTextViewPhone = finder.castView(view, 2131296323, "field 'mTextViewPhone'");
    view = finder.findRequiredView(source, 2131296322, "field 'mTextViewAddress'");
    target.mTextViewAddress = finder.castView(view, 2131296322, "field 'mTextViewAddress'");
    view = finder.findRequiredView(source, 2131296321, "field 'mTextViewName'");
    target.mTextViewName = finder.castView(view, 2131296321, "field 'mTextViewName'");
  }

  @Override public void reset(T target) {
    target.mTextViewPhone = null;
    target.mTextViewAddress = null;
    target.mTextViewName = null;
  }
}
