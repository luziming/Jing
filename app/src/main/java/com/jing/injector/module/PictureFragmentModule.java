package com.jing.injector.module;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.activity.base.IBasePresenter;
import com.jing.adapter.PictureAdapter;
import com.jing.entry.JokeImgs;
import com.jing.fragment.picture.PictureFragment;
import com.jing.fragment.picture.PicturePresenter;
import com.jing.injector.PerFragment;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/8.
 */
@Module
public class PictureFragmentModule {

    private final PictureFragment mView;
    private List<JokeImgs.Image> mList;

    public PictureFragmentModule(PictureFragment view, List<JokeImgs.Image> mList) {
        this.mView = view;
        this.mList = mList;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new PicturePresenter(mView);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new PictureAdapter(mList,mView.getContext());
    }
}
