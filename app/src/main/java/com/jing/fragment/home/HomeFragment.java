package com.jing.fragment.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.anim.recyclerview.animators.FlipInBottomXAnimator;
import com.jing.entry.Jokes;
import com.jing.fragment.JokeBaseFragment;
import com.jing.injector.component.DaggerHomeFragmentComponent;
import com.jing.injector.module.HomeFragmentModule;
import com.jing.util.recycler.RecyclerViewHelper;

/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/
public class HomeFragment extends JokeBaseFragment<Jokes.Joke> implements BaseQuickAdapter.OnItemChildClickListener {

    @Override
    protected void initInjector() {
        DaggerHomeFragmentComponent.builder()
                .applicationComponent(getAppComponent())
                .homeFragmentModule(new HomeFragmentModule(this,mJokeList))
                .build().inject(this);
    }

    @Override
    protected void initRecyclerViewHelper() {
        RecyclerViewHelper.initRecyclerViewV(mContext, recycleView, false, mAdapter);
        recycleView.setItemAnimator(new FlipInBottomXAnimator());
    }
}
