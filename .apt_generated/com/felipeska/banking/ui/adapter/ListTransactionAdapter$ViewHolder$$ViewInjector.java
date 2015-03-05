// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ListTransactionAdapter$ViewHolder$$ViewInjector<T extends com.felipeska.banking.ui.adapter.ListTransactionAdapter.ViewHolder> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296340, "field 'mTextViewValue'");
    target.mTextViewValue = finder.castView(view, 2131296340, "field 'mTextViewValue'");
    view = finder.findRequiredView(source, 2131296341, "field 'mTextViewType'");
    target.mTextViewType = finder.castView(view, 2131296341, "field 'mTextViewType'");
    view = finder.findRequiredView(source, 2131296339, "field 'mTextViewDate'");
    target.mTextViewDate = finder.castView(view, 2131296339, "field 'mTextViewDate'");
  }

  @Override public void reset(T target) {
    target.mTextViewValue = null;
    target.mTextViewType = null;
    target.mTextViewDate = null;
  }
}
