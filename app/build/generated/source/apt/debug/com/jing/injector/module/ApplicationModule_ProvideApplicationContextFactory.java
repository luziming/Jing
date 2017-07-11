package com.jing.injector.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideApplicationContextFactory implements Factory<Context> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideApplicationContextFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        module.provideApplicationContext(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Context> create(ApplicationModule module) {
    return new ApplicationModule_ProvideApplicationContextFactory(module);
  }
}
