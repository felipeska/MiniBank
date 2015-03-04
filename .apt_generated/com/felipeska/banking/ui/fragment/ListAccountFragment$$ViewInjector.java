// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ListAccountFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.ListAccountFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 16908298, "field 'listView'");
    target.listView = finder.castView(view, 16908298, "field 'listView'");
    view = finder.findRequiredView(source, 2131296332, "field 'emptyView'");
    target.emptyView = view;
    view = finder.findRequiredView(source, 2131296328, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131296328, "field 'progressBar'");
  }

  @Override public void reset(T target) {
    target.listView = null;
    target.emptyView = null;
    target.progressBar = null;
  }
}
