package com.jing.activity.base;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseActivity_MembersInjector<T extends IBasePresenter>
    implements MembersInjector<BaseActivity<T>> {
  private final Provider<T> mPresenterProvider;

  public BaseActivity_MembersInjector(Provider<T> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static <T extends IBasePresenter> MembersInjector<BaseActivity<T>> create(
      Provider<T> mPresenterProvider) {
    return new BaseActivity_MembersInjector<T>(mPresenterProvider);
  }

  @Override
  public void injectMembers(BaseActivity<T> instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static <T extends IBasePresenter> void injectMPresenter(
      BaseActivity<T> instance, Provider<T> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
