package com.jing.injector.component;

import android.content.Context;
import com.jing.injector.module.ApplicationModule;
import com.jing.injector.module.ApplicationModule_ProvideApplicationContextFactory;
import com.jing.injector.module.ApplicationModule_ProvideRxBusFactory;
import com.jing.rxbus.RxBus;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideApplicationContextProvider;

  private Provider<RxBus> provideRxBusProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideApplicationContextProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApplicationContextFactory.create(builder.applicationModule));

    this.provideRxBusProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideRxBusFactory.create(builder.applicationModule));
  }

  @Override
  public Context getContext() {
    return provideApplicationContextProvider.get();
  }

  @Override
  public RxBus getRxBus() {
    return provideRxBusProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
