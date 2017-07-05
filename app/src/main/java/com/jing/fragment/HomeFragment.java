package com.jing.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.jing.R;
import com.jing.activity.base.BaseFragment;
import com.jing.activity.base.IBasePresenter;
import com.jing.activity.base.ILoadDataView;
import com.jing.adapter.HomeAdapter;
import com.jing.injector.component.DaggerHomeFragmentComponent;
import com.jing.injector.module.HomeFragmentModule;
import com.jing.util.recycler.RecyclerViewHelper;

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
public class HomeFragment extends BaseFragment<IBasePresenter> implements ILoadDataView<List<Integer>> {

    @BindView(R.id.recyclerView)
    RecyclerView recycleView;


    private OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
        }
    };


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
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<Integer> data) {
        HomeAdapter adapter = new HomeAdapter(data, mContext);
//        是否执行一次
        adapter.isFirstOnly(false);
//        渐显动画
        adapter.openLoadAnimation();
        //拖拽
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(recycleView);
        // 开启拖拽
        adapter.enableDragItem(itemTouchHelper, R.id.cardView, true);
        adapter.setOnItemDragListener(onItemDragListener);
        RecyclerViewHelper.initRecyclerViewG(mContext, recycleView, false, adapter, 2);
    }

    @Override
    public void loadMoreData(List<Integer> data) {

    }
}
