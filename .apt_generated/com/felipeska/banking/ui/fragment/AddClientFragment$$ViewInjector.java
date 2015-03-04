// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AddClientFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.AddClientFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296321, "field 'mEditTextClientName'");
    target.mEditTextClientName = finder.castView(view, 2131296321, "field 'mEditTextClientName'");
    view = finder.findRequiredView(source, 2131296322, "field 'mEditTextClientAddress'");
    target.mEditTextClientAddress = finder.castView(view, 2131296322, "field 'mEditTextClientAddress'");
    view = finder.findRequiredView(source, 2131296328, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131296328, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131296323, "field 'mEditTextClientPhone'");
    target.mEditTextClientPhone = finder.castView(view, 2131296323, "field 'mEditTextClientPhone'");
    view = finder.findRequiredView(source, 2131296324, "field 'containerView'");
    target.containerView = view;
    view = finder.findRequiredView(source, 2131296325, "field 'mEditTextClientId'");
    target.mEditTextClientId = finder.castView(view, 2131296325, "field 'mEditTextClientId'");
    view = finder.findRequiredView(source, 2131296326, "method 'cancelAddClient'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cancelAddClient();
        }
      });
    view = finder.findRequiredView(source, 2131296327, "method 'addClient'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.addClient();
        }
      });
  }

  @Override public void reset(T target) {
    target.mEditTextClientName = null;
    target.mEditTextClientAddress = null;
    target.progressBar = null;
    target.mEditTextClientPhone = null;
    target.containerView = null;
    target.mEditTextClientId = null;
  }
}
