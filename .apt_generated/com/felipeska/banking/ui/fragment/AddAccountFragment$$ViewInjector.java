// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AddAccountFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.AddAccountFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296327, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131296327, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131296324, "field 'containerView'");
    target.containerView = view;
    view = finder.findRequiredView(source, 2131296319, "field 'mEditTextNumber'");
    target.mEditTextNumber = finder.castView(view, 2131296319, "field 'mEditTextNumber'");
    view = finder.findRequiredView(source, 2131296320, "field 'mEditTextBalance'");
    target.mEditTextBalance = finder.castView(view, 2131296320, "field 'mEditTextBalance'");
    view = finder.findRequiredView(source, 2131296326, "method 'addAccount'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.addAccount();
        }
      });
    view = finder.findRequiredView(source, 2131296325, "method 'cancelAddClient'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cancelAddClient();
        }
      });
  }

  @Override public void reset(T target) {
    target.progressBar = null;
    target.containerView = null;
    target.mEditTextNumber = null;
    target.mEditTextBalance = null;
  }
}
