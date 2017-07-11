// Generated code from Butter Knife. Do not modify!
package com.jing.activity.base;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jing.R;
import com.jing.view.EmptyLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BaseFragment_ViewBinding<T extends BaseFragment> implements Unbinder {
  protected T target;

  @UiThread
  public BaseFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.mEmptyLayout = Utils.findOptionalViewAsType(source, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
    target.mSwipeRefresh = Utils.findOptionalViewAsType(source, R.id.swipe_refresh, "field 'mSwipeRefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mEmptyLayout = null;
    target.mSwipeRefresh = null;

    this.target = null;
  }
}
