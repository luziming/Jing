package com.jing.injector.module;

import com.jing.activity.base.IBasePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashActivityModule_ProvidePresenterFactory implements Factory<IBasePresenter> {
  private final SplashActivityModule module;

  public SplashActivityModule_ProvidePresenterFactory(SplashActivityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public IBasePresenter get() {
    return Preconditions.checkNotNull(
        module.providePresenter(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IBasePresenter> create(SplashActivityModule module) {
    return new SplashActivityModule_ProvidePresenterFactory(module);
  }
}
