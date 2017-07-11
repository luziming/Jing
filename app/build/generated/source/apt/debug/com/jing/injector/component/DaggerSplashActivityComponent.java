package com.jing.injector.component;

import com.jing.activity.base.IBasePresenter;
import com.jing.activity.splash.SplashActivity;
import com.jing.activity.splash.SplashActivity_MembersInjector;
import com.jing.injector.module.SplashActivityModule;
import com.jing.injector.module.SplashActivityModule_ProvidePresenterFactory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSplashActivityComponent implements SplashActivityComponent {
  private Provider<IBasePresenter> providePresenterProvider;

  private MembersInjector<SplashActivity> splashActivityMembersInjector;

  private DaggerSplashActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.providePresenterProvider =
        DoubleCheck.provider(
            SplashActivityModule_ProvidePresenterFactory.create(builder.splashActivityModule));

    this.splashActivityMembersInjector =
        SplashActivity_MembersInjector.create(providePresenterProvider);
  }

  @Override
  public void inject(SplashActivity splashActivity) {
    splashActivityMembersInjector.injectMembers(splashActivity);
  }

  public static final class Builder {
    private SplashActivityModule splashActivityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public SplashActivityComponent build() {
      if (splashActivityModule == null) {
        throw new IllegalStateException(
            SplashActivityModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerSplashActivityComponent(this);
    }

    public Builder splashActivityModule(SplashActivityModule splashActivityModule) {
      this.splashActivityModule = Preconditions.checkNotNull(splashActivityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
