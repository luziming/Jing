package com.jing.fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.activity.base.IBasePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeBaseFragment_MembersInjector<T>
    implements MembersInjector<JokeBaseFragment<T>> {
  private final Provider<IBasePresenter> mPresenterProvider;

  private final Provider<BaseQuickAdapter> mAdapterProvider;

  public JokeBaseFragment_MembersInjector(
      Provider<IBasePresenter> mPresenterProvider, Provider<BaseQuickAdapter> mAdapterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
    assert mAdapterProvider != null;
    this.mAdapterProvider = mAdapterProvider;
  }

  public static <T> MembersInjector<JokeBaseFragment<T>> create(
      Provider<IBasePresenter> mPresenterProvider, Provider<BaseQuickAdapter> mAdapterProvider) {
    return new JokeBaseFragment_MembersInjector<T>(mPresenterProvider, mAdapterProvider);
  }

  @Override
  public void injectMembers(JokeBaseFragment<T> instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.jing.activity.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
    instance.mAdapter = mAdapterProvider.get();
  }

  public static <T> void injectMAdapter(
      JokeBaseFragment<T> instance, Provider<BaseQuickAdapter> mAdapterProvider) {
    instance.mAdapter = mAdapterProvider.get();
  }
}
