// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class InfoClientFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.InfoClientFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296326, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131296326, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131296321, "field 'textClientPhone'");
    target.textClientPhone = finder.castView(view, 2131296321, "field 'textClientPhone'");
    view = finder.findRequiredView(source, 2131296320, "field 'textClientAddress'");
    target.textClientAddress = finder.castView(view, 2131296320, "field 'textClientAddress'");
    view = finder.findRequiredView(source, 2131296328, "field 'textTotalAccounts'");
    target.textTotalAccounts = finder.castView(view, 2131296328, "field 'textTotalAccounts'");
    view = finder.findRequiredView(source, 2131296323, "field 'textClientId'");
    target.textClientId = finder.castView(view, 2131296323, "field 'textClientId'");
    view = finder.findRequiredView(source, 2131296327, "field 'containerView'");
    target.containerView = view;
    view = finder.findRequiredView(source, 2131296319, "field 'textViewClientName'");
    target.textViewClientName = finder.castView(view, 2131296319, "field 'textViewClientName'");
  }

  @Override public void reset(T target) {
    target.progressBar = null;
    target.textClientPhone = null;
    target.textClientAddress = null;
    target.textTotalAccounts = null;
    target.textClientId = null;
    target.containerView = null;
    target.textViewClientName = null;
  }
}
