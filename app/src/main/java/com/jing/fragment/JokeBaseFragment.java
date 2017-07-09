package com.jing.fragment;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jing.R;
import com.jing.activity.base.BaseFragment;
import com.jing.activity.base.IBasePresenter;
import com.jing.activity.base.ILoadDataView;
import com.jing.view.CustomLoadMoreView;
import com.jing.view.SnackBarObserver;
import com.melnykov.fab.FloatingActionButton;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/8.
 */

public abstract class JokeBaseFragment<T> extends BaseFragment<IBasePresenter> implements ILoadDataView<List<T>>, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.recyclerView)
    public RecyclerView recycleView;
    @BindView(R.id.tv_toast)
    public TextView tv_toast;


    protected List<T> mJokeList = new ArrayList<>();
    protected boolean isFistt = true;

    protected FloatingActionButton actionButton;

    @Inject
    protected BaseQuickAdapter mAdapter;


    protected abstract void initRecyclerViewHelper();


    public void setView(FloatingActionButton actionButton ) {
        this.actionButton = actionButton;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
        assert mSwipeRefresh != null;
        mSwipeRefresh.setColorSchemeResources(R.color.blue_600, R.color.blue_600);
        actionButton.attachToRecyclerView(recycleView);
        initRecyclerView();
    }


    private void initRecyclerView() {
        //渐显动画
        mAdapter.openLoadAnimation();
        //加载更多
        mAdapter.setOnLoadMoreListener(this, recycleView);
        //第一次不加载
        mAdapter.disableLoadMoreIfNotFullPage();
        //自定义加载布局
        mAdapter.setLoadMoreView(new CustomLoadMoreView());
        mAdapter.setOnItemChildClickListener(this);
        initRecyclerViewHelper();
    }


    @Override
    protected void updateViews(boolean isRefresh) {
        if (isRefresh) {
            mAdapter.setEnableLoadMore(false);
        }
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<T> data) {
        mJokeList.clear();
        mJokeList.addAll(data);
        mAdapter.notifyDataSetChanged();
        if (!mAdapter.isLoadMoreEnable()) {
            mAdapter.setEnableLoadMore(true);
        }
        toast(data.size() + "条新内容");
    }

    @Override
    public void loadMoreData(List<T> data) {
        mJokeList.addAll(data);
        mAdapter.notifyDataSetChanged();
        mAdapter.loadMoreComplete();
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
        SnackbarManager.show(Snackbar.with(mContext).text("一条小鲸鱼被吃了")
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
        content = isFistt ?  "内容已更新" : content;
        isFistt = false;
        tv_toast.setText(content);
        tv_toast.setVisibility(View.VISIBLE);
        ObjectAnimator anim = ObjectAnimator.ofFloat(tv_toast, "alpha", 0.0f, 0.4f, 0.8f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.8f, 0.4f, 0.0f);
        anim.setDuration(2000);
        anim.start();
    }
}
