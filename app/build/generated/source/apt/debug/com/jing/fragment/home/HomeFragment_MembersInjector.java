package com.jing.fragment.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.activity.base.IBasePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final Provider<IBasePresenter> mPresenterProvider;

  private final Provider<BaseQuickAdapter> mAdapterProvider;

  public HomeFragment_MembersInjector(
      Provider<IBasePresenter> mPresenterProvider, Provider<BaseQuickAdapter> mAdapterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
    assert mAdapterProvider != null;
    this.mAdapterProvider = mAdapterProvider;
  }

  public static MembersInjector<HomeFragment> create(
      Provider<IBasePresenter> mPresenterProvider, Provider<BaseQuickAdapter> mAdapterProvider) {
    return new HomeFragment_MembersInjector(mPresenterProvider, mAdapterProvider);
  }

  @Override
  public void injectMembers(HomeFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.jing.activity.base.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
    com.jing.fragment.JokeBaseFragment_MembersInjector.injectMAdapter(instance, mAdapterProvider);
  }
}
