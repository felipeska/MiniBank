// Generated code from Butter Knife. Do not modify!
package com.felipeska.banking.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class InfoClientFragment$$ViewInjector<T extends com.felipeska.banking.ui.fragment.InfoClientFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296321, "field 'textViewClientName'");
    target.textViewClientName = finder.castView(view, 2131296321, "field 'textViewClientName'");
    view = finder.findRequiredView(source, 2131296322, "field 'textClientAddress'");
    target.textClientAddress = finder.castView(view, 2131296322, "field 'textClientAddress'");
    view = finder.findRequiredView(source, 2131296328, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131296328, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131296330, "field 'textTotalAccounts'");
    target.textTotalAccounts = finder.castView(view, 2131296330, "field 'textTotalAccounts'");
    view = finder.findRequiredView(source, 2131296329, "field 'containerView'");
    target.containerView = view;
    view = finder.findRequiredView(source, 2131296323, "field 'textClientPhone'");
    target.textClientPhone = finder.castView(view, 2131296323, "field 'textClientPhone'");
    view = finder.findRequiredView(source, 2131296325, "field 'textClientId'");
    target.textClientId = finder.castView(view, 2131296325, "field 'textClientId'");
  }

  @Override public void reset(T target) {
    target.textViewClientName = null;
    target.textClientAddress = null;
    target.progressBar = null;
    target.textTotalAccounts = null;
    target.containerView = null;
    target.textClientPhone = null;
    target.textClientId = null;
  }
}
