package com.hwz.bigimage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hwz.bigimage.browse_max_image.BrowseMaxImageActivity;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends Activity
{
    private Button btnShow;
    public static File cacheDir;

    private BitmapProcessor bitmapProcessor;

    //logoBitmap
    private Bitmap logoBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = (Button)findViewById(R.id.btn_show);
//图片缓存路径
        bitmapProcessor = new BitmapProcessor()
        {
            @Override
            public Bitmap process(Bitmap bitmap)
            {
                return null;
            }
        };
        cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache");
        btnShow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, BrowseMaxImageActivity.class);
                ArrayList<String> imageArrayList = new ArrayList<String>();
                imageArrayList.add("http://img3.3lian.com/2013/9/11/d/81.jpg");
                imageArrayList.add("http://file-www.sioe.cn/201109/14/222211817.jpg");
                imageArrayList.add("http://image.tianjimedia.com/uploadImages/2014/154/02/74J2B166GIDW.jpg");
                imageArrayList.add("http://img3.3lian.com/2013/c4/14/d/11.jpg");
                imageArrayList.add("http://img3.3lian.com/2013/9/11/d/81.jpg");
                intent.putExtra("image", imageArrayList);
                intent.putExtra("currentPosition", 0);
                startActivity(intent);
            }
        });


    }

}
