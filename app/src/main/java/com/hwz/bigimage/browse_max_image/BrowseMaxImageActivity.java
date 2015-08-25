package com.hwz.bigimage.browse_max_image;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.hwz.bigimage.R;
import com.hwz.bigimage.browse_max_image.adapter.BrowseImagePagerAdapter;
import com.hwz.bigimage.browse_max_image.fragment.ImageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 浏览图片
 * <p/>
 * param image           ArrayList    图片列表
 * param currentPosition int          当前显示的下标
 *
 * @author devin
 */
public class BrowseMaxImageActivity extends FragmentActivity
{
    //个数
    private TextView tvNumbers;

    //界面滑动布局
    private ViewPager vpImage;

    //当前显示的个数
    private int currentPosition;

    //fragment列表
    List<Fragment> fragmentList;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_max_image);
        init();
    }

    private void init()
    {
        Intent intent = getIntent();
        ArrayList<String> imageList = (ArrayList<String>) intent.getSerializableExtra("image");
        currentPosition = intent.getIntExtra("currentPosition", 0);

        fragmentList = new ArrayList<Fragment>();
        tvNumbers = (TextView) findViewById(R.id.tv_numbers);
        vpImage = (ViewPager) findViewById(R.id.vp_image);

        //显示图片数据
        if (imageList != null && imageList.size() > 0)
        {
            tvNumbers.setText((currentPosition + 1) + "/" + imageList.size());

            for (int i = 0; i < imageList.size(); i++)
            {
                String imageStr = imageList.get(i);
                fragmentList.add(i, new ImageFragment(imageStr));
            }
            BrowseImagePagerAdapter browseImagePagerAdapter = new BrowseImagePagerAdapter(getSupportFragmentManager(), fragmentList);
            vpImage.setAdapter(browseImagePagerAdapter);
            vpImage.setCurrentItem(currentPosition);
            vpImage.setOnPageChangeListener(new MyOnPageChangeListener());
            //设置页间隔
            vpImage.setPageMargin((int) getResources().getDimensionPixelOffset(R.dimen.dimens_13) * 2);
        }

    }

    /**
     * 返回
     *
     * @param v
     */
    public void back(View v)
    {
        activityExit();
    }

    /**
     * 重写返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            activityExit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 点击图片关闭
     *
     * @param v
     */
    public void imageExit(View v)
    {
        activityExit();
    }

    /**
     * 关闭界面，并带动画
     */
    private void activityExit()
    {
        this.finish();
        overridePendingTransition(R.anim.open_activity_from_scale, R.anim.close_activity_from_scale);
    }

    /**
     * ViewPager的滑动事件
     */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener
    {
        private int bmpW;//横线图片宽度
        private int offset;//图片移动的偏移量
        private int one = offset * 2 + bmpW;//两个相邻页面的偏移量

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrollStateChanged(int arg0)
        {
            // TODO Auto-generated method stub
        }

        @Override
        public void onPageSelected(int arg0)
        {
            // TODO Auto-generated method stub
            tvNumbers.setText((arg0 + 1) + "/" + fragmentList.size());
        }
    }

}
