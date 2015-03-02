// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AddClientFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.AddClientFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296321, "field 'mEditTextClientPhone'");
    target.mEditTextClientPhone = finder.castView(view, 2131296321, "field 'mEditTextClientPhone'");
    view = finder.findRequiredView(source, 2131296319, "field 'mEditTextClientName'");
    target.mEditTextClientName = finder.castView(view, 2131296319, "field 'mEditTextClientName'");
    view = finder.findRequiredView(source, 2131296322, "field 'mEditTextClientId'");
    target.mEditTextClientId = finder.castView(view, 2131296322, "field 'mEditTextClientId'");
    view = finder.findRequiredView(source, 2131296320, "field 'mEditTextClientAddress'");
    target.mEditTextClientAddress = finder.castView(view, 2131296320, "field 'mEditTextClientAddress'");
    view = finder.findRequiredView(source, 2131296324, "method 'addClient'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.addClient();
        }
      });
    view = finder.findRequiredView(source, 2131296323, "method 'cancelAddClient'");
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
    target.mEditTextClientPhone = null;
    target.mEditTextClientName = null;
    target.mEditTextClientId = null;
    target.mEditTextClientAddress = null;
  }
}
