package com.jing.activity.splash;

import com.jing.activity.base.IBasePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
  private final Provider<IBasePresenter> mPresenterProvider;

  public SplashActivity_MembersInjector(Provider<IBasePresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<SplashActivity> create(
      Provider<IBasePresenter> mPresenterProvider) {
    return new SplashActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(SplashActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.jing.activity.base.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
