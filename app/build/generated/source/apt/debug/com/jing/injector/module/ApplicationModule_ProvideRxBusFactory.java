package com.jing.injector.module;

import com.jing.rxbus.RxBus;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideRxBusFactory implements Factory<RxBus> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideRxBusFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public RxBus get() {
    return Preconditions.checkNotNull(
        module.provideRxBus(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RxBus> create(ApplicationModule module) {
    return new ApplicationModule_ProvideRxBusFactory(module);
  }
}
