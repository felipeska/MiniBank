// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ListAccountFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.ListAccountFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296332, "field 'emptyView'");
    target.emptyView = view;
    view = finder.findRequiredView(source, 2131296327, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131296327, "field 'progressBar'");
    view = finder.findRequiredView(source, 16908298, "field 'listView' and method 'listClicked'");
    target.listView = finder.castView(view, 16908298, "field 'listView'");
    ((android.widget.AdapterView<?>) view).setOnItemClickListener(
      new android.widget.AdapterView.OnItemClickListener() {
        @Override public void onItemClick(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.listClicked(p2);
        }
      });
  }

  @Override public void reset(T target) {
    target.emptyView = null;
    target.progressBar = null;
    target.listView = null;
  }
}
