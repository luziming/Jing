// Generated code from Butter Knife. Do not modify!
package com.jing.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.github.ybq.android.spinkit.SpinKitView;
import com.jing.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EmptyLayout_ViewBinding<T extends EmptyLayout> implements Unbinder {
  protected T target;

  private View view2131690217;

  @UiThread
  public EmptyLayout_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_net_error, "field 'mTvEmptyMessage' and method 'onViewClicked'");
    target.mTvEmptyMessage = Utils.castView(view, R.id.tv_net_error, "field 'mTvEmptyMessage'", TextView.class);
    view2131690217 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.mRlEmptyContainer = Utils.findRequiredView(source, R.id.rl_empty_container, "field 'mRlEmptyContainer'");
    target.mEmptyLoading = Utils.findRequiredViewAsType(source, R.id.empty_loading, "field 'mEmptyLoading'", SpinKitView.class);
    target.mEmptyLayout = Utils.findRequiredViewAsType(source, R.id.empty_layout, "field 'mEmptyLayout'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTvEmptyMessage = null;
    target.mRlEmptyContainer = null;
    target.mEmptyLoading = null;
    target.mEmptyLayout = null;

    view2131690217.setOnClickListener(null);
    view2131690217 = null;

    this.target = null;
  }
}
