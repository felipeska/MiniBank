// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class TransactionFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.TransactionFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296333, "field 'radioGroupTransactionType'");
    target.radioGroupTransactionType = finder.castView(view, 2131296333, "field 'radioGroupTransactionType'");
    view = finder.findRequiredView(source, 2131296324, "field 'containerView'");
    target.containerView = view;
    view = finder.findRequiredView(source, 2131296319, "field 'textAccountNumber'");
    target.textAccountNumber = finder.castView(view, 2131296319, "field 'textAccountNumber'");
    view = finder.findRequiredView(source, 2131296320, "field 'textAccountBalance'");
    target.textAccountBalance = finder.castView(view, 2131296320, "field 'textAccountBalance'");
    view = finder.findRequiredView(source, 2131296327, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131296327, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131296336, "field 'editTextValue'");
    target.editTextValue = finder.castView(view, 2131296336, "field 'editTextValue'");
    view = finder.findRequiredView(source, 2131296326, "method 'addClient'");
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
    target.radioGroupTransactionType = null;
    target.containerView = null;
    target.textAccountNumber = null;
    target.textAccountBalance = null;
    target.progressBar = null;
    target.editTextValue = null;
  }
}
