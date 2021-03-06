package com.jing.fragment.picture;

import com.jing.anim.recyclerview.animators.ScaleInRightAnimator;
import com.jing.entry.JokeImgs;
import com.jing.fragment.JokeBaseFragment;
import com.jing.injector.component.DaggerPictureFragmentConponent;
import com.jing.injector.module.PictureFragmentModule;
import com.jing.util.recycler.RecyclerViewHelper;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/7.
 */

public class PictureFragment extends JokeBaseFragment<JokeImgs.Image> {


    @Override
    protected void initRecyclerViewHelper() {
        RecyclerViewHelper.initRecyclerViewSV(mContext,recycleView,false,mAdapter,1);
        recycleView.setItemAnimator(new ScaleInRightAnimator());
    }

    @Override
    protected void initInjector() {
        DaggerPictureFragmentConponent.builder()
                .pictureFragmentModule(new PictureFragmentModule(this,mJokeList))
                .applicationComponent(getAppComponent())
                .build()
                .inject(this);
    }
    // TODO: 2017/7/9 图片加载模式,动图点开再播放,以及图片缓存问题
}
