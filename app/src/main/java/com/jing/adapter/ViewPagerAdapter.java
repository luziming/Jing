package com.jing.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.jing.activity.base.BaseFragment;
import com.jing.fragment.home.HomeFragment;
import com.jing.fragment.picture.PictureFragment;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * 写代码救不了中国人
 * ---------------------------------
 * Created by luziming on 2017/7/5.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = {"每日一笑","趣味图片","福利视频"};

    private List<BaseFragment> fragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, FloatingActionButton fab) {
        super(fm);
//        for (int i = 0; i < 3; i++) {
//            HomeFragment fragment = new HomeFragment();
//            fragment.setView(fab);
//            fragments.add(fragment);
//        }
        HomeFragment fragment = new HomeFragment();
        fragment.setView(fab);
        PictureFragment pictureFragment = new PictureFragment();
        pictureFragment.setView(fab);
        fragments.add(fragment);
        fragments.add(pictureFragment);
        fragment = new HomeFragment();
        fragment.setView(fab);
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
