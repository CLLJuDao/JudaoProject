package com.example.wenli.judaoproject.bean;

import android.net.Uri;

/**
 * Created by wenli on 2017/10/27.
 */

public class DynamicItem {
    private Uri imageUrl;

    public Uri getImageUrl() {
        return imageUrl;
    }

    public DynamicItem(Uri imageUrl) {
        this.imageUrl = imageUrl;
    }
}
