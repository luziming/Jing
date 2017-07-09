package com.jing.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jing.R;
import com.jing.entry.JokeImgs;

import java.util.List;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/8.
 */

public class PictureAdapter extends BaseQuickAdapter<JokeImgs.Image, BaseViewHolder> {

    private Context context;

    public PictureAdapter(@Nullable List<JokeImgs.Image> data, Context context) {
        super(R.layout.item_picture, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, JokeImgs.Image item) {
        String url = item.getUrl();
        Glide.with(context).load(url).into((ImageView)helper.getView(R.id.iv_picture));
        helper.setText(R.id.tv_title, item.getContent())
                .setText(R.id.tv_time, item.getUpdatetime())
                .setVisible(R.id.tv_gif, url.endsWith(".gif"))
                .addOnClickListener(R.id.iv_del);
    }
}
