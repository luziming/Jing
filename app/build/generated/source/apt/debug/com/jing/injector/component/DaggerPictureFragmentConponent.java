package com.jing.injector.component;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.activity.base.IBasePresenter;
import com.jing.fragment.picture.PictureFragment;
import com.jing.fragment.picture.PictureFragment_MembersInjector;
import com.jing.injector.module.PictureFragmentModule;
import com.jing.injector.module.PictureFragmentModule_ProvideAdapterFactory;
import com.jing.injector.module.PictureFragmentModule_ProvidePresenterFactory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerPictureFragmentConponent implements PictureFragmentConponent {
  private Provider<IBasePresenter> providePresenterProvider;

  private Provider<BaseQuickAdapter> provideAdapterProvider;

  private MembersInjector<PictureFragment> pictureFragmentMembersInjector;

  private DaggerPictureFragmentConponent(Builder builder) {
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
            PictureFragmentModule_ProvidePresenterFactory.create(builder.pictureFragmentModule));

    this.provideAdapterProvider =
        DoubleCheck.provider(
            PictureFragmentModule_ProvideAdapterFactory.create(builder.pictureFragmentModule));

    this.pictureFragmentMembersInjector =
        PictureFragment_MembersInjector.create(providePresenterProvider, provideAdapterProvider);
  }

  @Override
  public void inject(PictureFragment fragment) {
    pictureFragmentMembersInjector.injectMembers(fragment);
  }

  public static final class Builder {
    private PictureFragmentModule pictureFragmentModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public PictureFragmentConponent build() {
      if (pictureFragmentModule == null) {
        throw new IllegalStateException(
            PictureFragmentModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerPictureFragmentConponent(this);
    }

    public Builder pictureFragmentModule(PictureFragmentModule pictureFragmentModule) {
      this.pictureFragmentModule = Preconditions.checkNotNull(pictureFragmentModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
