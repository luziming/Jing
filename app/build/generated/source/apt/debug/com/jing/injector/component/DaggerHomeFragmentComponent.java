package com.jing.injector.component;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.activity.base.IBasePresenter;
import com.jing.fragment.home.HomeFragment;
import com.jing.fragment.home.HomeFragment_MembersInjector;
import com.jing.injector.module.HomeFragmentModule;
import com.jing.injector.module.HomeFragmentModule_ProvideAdapterFactory;
import com.jing.injector.module.HomeFragmentModule_ProvidePresenterFactory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerHomeFragmentComponent implements HomeFragmentComponent {
  private Provider<IBasePresenter> providePresenterProvider;

  private Provider<BaseQuickAdapter> provideAdapterProvider;

  private MembersInjector<HomeFragment> homeFragmentMembersInjector;

  private DaggerHomeFragmentComponent(Builder builder) {
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
            HomeFragmentModule_ProvidePresenterFactory.create(builder.homeFragmentModule));

    this.provideAdapterProvider =
        DoubleCheck.provider(
            HomeFragmentModule_ProvideAdapterFactory.create(builder.homeFragmentModule));

    this.homeFragmentMembersInjector =
        HomeFragment_MembersInjector.create(providePresenterProvider, provideAdapterProvider);
  }

  @Override
  public void inject(HomeFragment fragment) {
    homeFragmentMembersInjector.injectMembers(fragment);
  }

  public static final class Builder {
    private HomeFragmentModule homeFragmentModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public HomeFragmentComponent build() {
      if (homeFragmentModule == null) {
        throw new IllegalStateException(
            HomeFragmentModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerHomeFragmentComponent(this);
    }

    public Builder homeFragmentModule(HomeFragmentModule homeFragmentModule) {
      this.homeFragmentModule = Preconditions.checkNotNull(homeFragmentModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
