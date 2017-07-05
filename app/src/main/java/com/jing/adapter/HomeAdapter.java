package com.jing.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jing.R;

import java.util.List;

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
public class HomeAdapter  extends BaseItemDraggableAdapter<Integer, BaseViewHolder> {

    private Context context;

    public HomeAdapter(List<Integer> data, Context context) {
        super(R.layout.item_home, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        Glide.with(context).load("http://cn.bing.com/az/hprichbg/rb/RestArea_ZH-CN13518721881_720x1280.jpg").asBitmap().into((ImageView)helper.getView(R.id.iv_splash));
        helper.setText(R.id.id_num, item + "");
    }
}
