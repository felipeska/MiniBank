// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ListAccountAdapter$ViewHolder$$ViewInjector<T extends com.felipeska.banking.ui.adapter.ListAccountAdapter.ViewHolder> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296319, "field 'mTextViewNumber'");
    target.mTextViewNumber = finder.castView(view, 2131296319, "field 'mTextViewNumber'");
    view = finder.findRequiredView(source, 2131296320, "field 'mTextViewBalance'");
    target.mTextViewBalance = finder.castView(view, 2131296320, "field 'mTextViewBalance'");
  }

  @Override public void reset(T target) {
    target.mTextViewNumber = null;
    target.mTextViewBalance = null;
  }
}
