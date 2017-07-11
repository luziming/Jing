// Generated code from Butter Knife. Do not modify!
package com.jing.fragment;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.jing.R;
import com.jing.activity.base.BaseFragment_ViewBinding;
import java.lang.Override;

public class JokeBaseFragment_ViewBinding<T extends JokeBaseFragment> extends BaseFragment_ViewBinding<T> {
  @UiThread
  public JokeBaseFragment_ViewBinding(T target, View source) {
    super(target, source);

    target.recycleView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'recycleView'", RecyclerView.class);
    target.tv_toast = Utils.findRequiredViewAsType(source, R.id.tv_toast, "field 'tv_toast'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    super.unbind();

    target.recycleView = null;
    target.tv_toast = null;
  }
}
