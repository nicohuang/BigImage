package com.hwz.bigimage.browse_max_image.fragment;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwz.bigimage.browse_max_image.GestureImageView.GestureImageView;
import com.hwz.bigimage.browse_max_image.ImageLoaderHelper;
import com.hwz.bigimage.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * 图片显示 fragment
 *
 * @author Devin
 */
@SuppressLint("ValidFragment")
public class ImageFragment extends Fragment
{
    //图片
    private GestureImageView givMaxImage;

    //图片地址
    private String imageUrl;

    //图片加载options
    private DisplayImageOptions imageOptions;

    public ImageFragment(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View result = inflater.inflate(R.layout.item_browse_image, container, false);
        init(result);
        showImage();
        return result;
    }

    private void init(View result)
    {
        imageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)           //缓存至内存
                .cacheOnDisc(true)             //不缓存至手机SDCard
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();

        givMaxImage = (GestureImageView) result.findViewById(R.id.giv_max_image);
    }

    /**
     * 显示图片
     */
    private void showImage()
    {
        //加载logo
        ImageLoaderHelper.getInstance(getActivity()).displayImage(imageUrl, givMaxImage, imageOptions);
    }

}
