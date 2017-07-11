package com.jing.injector.module;

import com.jing.activity.base.IBasePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeFragmentModule_ProvidePresenterFactory implements Factory<IBasePresenter> {
  private final HomeFragmentModule module;

  public HomeFragmentModule_ProvidePresenterFactory(HomeFragmentModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public IBasePresenter get() {
    return Preconditions.checkNotNull(
        module.providePresenter(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IBasePresenter> create(HomeFragmentModule module) {
    return new HomeFragmentModule_ProvidePresenterFactory(module);
  }
}
