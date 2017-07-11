package com.jing.injector.module;

import com.chad.library.adapter.base.BaseQuickAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeFragmentModule_ProvideAdapterFactory implements Factory<BaseQuickAdapter> {
  private final HomeFragmentModule module;

  public HomeFragmentModule_ProvideAdapterFactory(HomeFragmentModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public BaseQuickAdapter get() {
    return Preconditions.checkNotNull(
        module.provideAdapter(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<BaseQuickAdapter> create(HomeFragmentModule module) {
    return new HomeFragmentModule_ProvideAdapterFactory(module);
  }
}
