// Generated code from Butter Knife. Do not modify!
package com.jing.activity;

import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.internal.Utils;
import com.jing.R;
import com.jing.activity.base.BaseActivity_ViewBinding;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> extends BaseActivity_ViewBinding<T> {
  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    super(target, source);

    target.mDrawerLayout = Utils.findRequiredViewAsType(source, R.id.dl_left, "field 'mDrawerLayout'", DrawerLayout.class);
    target.navigation_view = Utils.findRequiredViewAsType(source, R.id.navigation_view, "field 'navigation_view'", NavigationView.class);
    target.ll_left = Utils.findRequiredViewAsType(source, R.id.ll_left, "field 'll_left'", LinearLayout.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    super.unbind();

    target.mDrawerLayout = null;
    target.navigation_view = null;
    target.ll_left = null;
  }
}
