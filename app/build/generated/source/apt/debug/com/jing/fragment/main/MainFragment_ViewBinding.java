// Generated code from Butter Knife. Do not modify!
package com.jing.fragment.main;

import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.internal.Utils;
import com.jing.R;
import com.jing.activity.base.BaseFragment_ViewBinding;
import com.melnykov.fab.FloatingActionButton;
import java.lang.Override;

public class MainFragment_ViewBinding<T extends MainFragment> extends BaseFragment_ViewBinding<T> {
  @UiThread
  public MainFragment_ViewBinding(T target, View source) {
    super(target, source);

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
    target.mAppBarLayout = Utils.findRequiredViewAsType(source, R.id.mAppBarLayout, "field 'mAppBarLayout'", AppBarLayout.class);
    target.mViewpager = Utils.findRequiredViewAsType(source, R.id.mViewpager, "field 'mViewpager'", ViewPager.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'fab'", FloatingActionButton.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinator, "field 'coordinatorLayout'", CoordinatorLayout.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    super.unbind();

    target.toolbar = null;
    target.tabLayout = null;
    target.mAppBarLayout = null;
    target.mViewpager = null;
    target.fab = null;
    target.coordinatorLayout = null;
  }
}
