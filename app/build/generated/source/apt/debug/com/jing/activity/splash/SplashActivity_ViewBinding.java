// Generated code from Butter Knife. Do not modify!
package com.jing.activity.splash;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.jing.R;
import com.jing.activity.base.BaseActivity_ViewBinding;
import com.jing.view.SimpleButton;
import java.lang.Override;

public class SplashActivity_ViewBinding<T extends SplashActivity> extends BaseActivity_ViewBinding<T> {
  @UiThread
  public SplashActivity_ViewBinding(T target, View source) {
    super(target, source);

    target.iv_splash = Utils.findRequiredViewAsType(source, R.id.iv_splash, "field 'iv_splash'", ImageView.class);
    target.simpleButton = Utils.findRequiredViewAsType(source, R.id.sb_skip, "field 'simpleButton'", SimpleButton.class);
    target.tv_copyright = Utils.findRequiredViewAsType(source, R.id.tv_copyright, "field 'tv_copyright'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    super.unbind();

    target.iv_splash = null;
    target.simpleButton = null;
    target.tv_copyright = null;
  }
}
