package com.jing.fragment.home;

import android.animation.ObjectAnimator;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.R;
import com.jing.activity.base.BaseFragment;
import com.jing.activity.base.IBasePresenter;
import com.jing.activity.base.ILoadDataView;
import com.jing.adapter.HomeAdapter;
import com.jing.anim.recyclerview.animators.ScaleInRightAnimator;
import com.jing.entry.Jokes;
import com.jing.injector.component.DaggerHomeFragmentComponent;
import com.jing.injector.module.HomeFragmentModule;
import com.jing.util.recycler.RecyclerViewHelper;
import com.jing.view.CustomLoadMoreView;
import com.jing.view.SnackBarObserver;
import com.melnykov.fab.FloatingActionButton;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
public class HomeFragment extends BaseFragment<IBasePresenter> implements ILoadDataView<List<Jokes.Joke>>, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recycleView;
    @BindView(R.id.tv_toast)
    TextView tv_toast;

    private List<Jokes.Joke> mJokeList = new ArrayList<>();
    private boolean isFistt = true;

    private FloatingActionButton actionButton;
    private CoordinatorLayout coordinatorLayout;
    private HomeAdapter adapter;

    public void setView(FloatingActionButton actionButton, CoordinatorLayout coordinatorLayout) {
        this.actionButton = actionButton;
        this.coordinatorLayout = coordinatorLayout;
        Log.e("HomeFragment", "Aciton == Null ? :" + (actionButton == null));
        Log.e("HomeFragment", "Coordinator == Null ? :" + (coordinatorLayout == null));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInjector() {
        DaggerHomeFragmentComponent.builder()
                .applicationComponent(getAppComponent())
                .homeFragmentModule(new HomeFragmentModule(this))
                .build().inject(this);
    }

    @Override
    protected void initViews() {
        assert mSwipeRefresh != null;
        mSwipeRefresh.setColorSchemeResources(R.color.blue_600, R.color.blue_600);
        actionButton.attachToRecyclerView(recycleView);
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new HomeAdapter(mJokeList);
        //渐显动画
        adapter.openLoadAnimation();
        //加载更多
        adapter.setOnLoadMoreListener(this, recycleView);
        //第一次不加载
        adapter.disableLoadMoreIfNotFullPage();
        //自定义加载布局
        adapter.setLoadMoreView(new CustomLoadMoreView());
        adapter.setOnItemChildClickListener(this);
        RecyclerViewHelper.initRecyclerViewV(mContext, recycleView, false, adapter);
        recycleView.setItemAnimator(new ScaleInRightAnimator());
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        if (isRefresh) {
            adapter.setEnableLoadMore(false);
        }
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<Jokes.Joke> data) {
        mJokeList.clear();
        mJokeList.addAll(data);
        adapter.notifyDataSetChanged();
        if (!adapter.isLoadMoreEnable()) {
            adapter.setEnableLoadMore(true);
        }
        toast(data.size() + "条新内容");
//        adapter.setNewData(mJokeList);
    }

    @Override
    public void loadMoreData(List<Jokes.Joke> data) {
        mJokeList.addAll(data);
        adapter.notifyDataSetChanged();
        adapter.loadMoreComplete();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getMoreData();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        mJokeList.remove(position);
        adapter.notifyItemRemoved(position);
        actionButton.showWithSnackHeight(100);
        SnackbarManager.show(Snackbar.with(mContext).text("小鲸鱼")
                .eventListener(new SnackBarObserver() {
                    @Override
                    public void onShow(Snackbar snackbar) {
                        actionButton.showWithSnackHeight(snackbar.getHeight());
                    }

                    @Override
                    public void onDismiss(Snackbar snackbar) {
                        actionButton.showWithSnackHeight(0);
                    }
                }).duration(500));
    }

    public void toast(String content) {
        content = isFistt ?  "首页已更新" : content;
        isFistt = false;
        tv_toast.setText(content);
        tv_toast.setVisibility(View.VISIBLE);
        ObjectAnimator anim = ObjectAnimator.ofFloat(tv_toast, "alpha", 0.0f, 0.4f, 0.8f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.8f, 0.4f, 0.0f);
        anim.setDuration(2000);
        anim.start();
    }
}
