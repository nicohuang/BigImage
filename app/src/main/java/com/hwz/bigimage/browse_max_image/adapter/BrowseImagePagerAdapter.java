package com.hwz.bigimage.browse_max_image.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 自定义viewpager嵌套fragment 的适配器
 *
 * @author devin
 */
public class BrowseImagePagerAdapter extends FragmentPagerAdapter
{
    private List<Fragment> imageListViews;

    public BrowseImagePagerAdapter(FragmentManager fm, List<Fragment> imageListViews)
    {
        super(fm);
        this.imageListViews = imageListViews;
    }

    public List<Fragment> getImageListViews()
    {
        return imageListViews;
    }

    public void setImageListViews(List<Fragment> imageListViews)
    {
        this.imageListViews = imageListViews;
    }

    @Override
    public int getCount()
    {
        return imageListViews.size();
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {
        return imageListViews.get(position);
    }
}
