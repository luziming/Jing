// Generated code from Butter Knife. Do not modify!
package com.jing.activity;

import android.support.annotation.UiThread;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.internal.Utils;
import com.jing.R;
import com.jing.activity.base.BaseActivity_ViewBinding;
import java.lang.Override;

public class AboutMeActivity_ViewBinding<T extends AboutMeActivity> extends BaseActivity_ViewBinding<T> {
  @UiThread
  public AboutMeActivity_ViewBinding(T target, View source) {
    super(target, source);

    target.titleBar = Utils.findRequiredViewAsType(source, R.id.titleBar, "field 'titleBar'", Toolbar.class);
    target.collapsingToolbar = Utils.findRequiredViewAsType(source, R.id.collapsing_toolbar, "field 'collapsingToolbar'", CollapsingToolbarLayout.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'fab'", FloatingActionButton.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    super.unbind();

    target.titleBar = null;
    target.collapsingToolbar = null;
    target.fab = null;
  }
}
