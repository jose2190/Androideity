package com.androideity.gridviewtest;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.GridView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.image_2, R.drawable.image_3,
            R.drawable.image_4, R.drawable.image_5,
            R.drawable.image_6, R.drawable.image_7,
            R.drawable.image_0, R.drawable.image_1,
            R.drawable.image_2, R.drawable.image_3,
            R.drawable.image_4, R.drawable.image_5,
            R.drawable.image_6, R.drawable.image_7,
            R.drawable.image_0, R.drawable.image_1,
            R.drawable.image_2, R.drawable.image_3,
            R.drawable.image_4, R.drawable.image_5,
            R.drawable.image_6, R.drawable.image_7
    };

}
