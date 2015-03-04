// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class EditClientFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.EditClientFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296323, "field 'mEditTextClientPhone'");
    target.mEditTextClientPhone = finder.castView(view, 2131296323, "field 'mEditTextClientPhone'");
    view = finder.findRequiredView(source, 2131296322, "field 'mEditTextClientAddress'");
    target.mEditTextClientAddress = finder.castView(view, 2131296322, "field 'mEditTextClientAddress'");
    view = finder.findRequiredView(source, 2131296327, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131296327, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131296321, "field 'mEditTextClientName'");
    target.mEditTextClientName = finder.castView(view, 2131296321, "field 'mEditTextClientName'");
    view = finder.findRequiredView(source, 2131296328, "field 'mEditTextClientId'");
    target.mEditTextClientId = finder.castView(view, 2131296328, "field 'mEditTextClientId'");
    view = finder.findRequiredView(source, 2131296324, "field 'containerView'");
    target.containerView = view;
    view = finder.findRequiredView(source, 2131296325, "method 'cancelEditlCient'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cancelEditlCient();
        }
      });
    view = finder.findRequiredView(source, 2131296326, "method 'successEditlient'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.successEditlient();
        }
      });
  }

  @Override public void reset(T target) {
    target.mEditTextClientPhone = null;
    target.mEditTextClientAddress = null;
    target.progressBar = null;
    target.mEditTextClientName = null;
    target.mEditTextClientId = null;
    target.containerView = null;
  }
}
