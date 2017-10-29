package com.example.wenli.judaoproject.urls;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenli on 2017/10/27.
 */

public class ImageUrl {
    public static List<Uri> imageList(){
        List<Uri> imageUrls = new ArrayList<>();
        imageUrls.add(Uri.parse("http://p2.gexing.com/shaitu/20130216/2108/511f84c3bb834.jpg"));
        imageUrls.add(Uri.parse("http://image.tianjimedia.com/uploadImages/2013/141/QR3VB4M6NR44_1920x1200.jpg"));
        imageUrls.add(Uri.parse("http://img2.imgtn.bdimg.com/it/u=97192082,1937580666&fm=214&gp=0.jpg"));
        imageUrls.add(Uri.parse("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1301/04/c1/17113466_1357280465809.jpg"));
        imageUrls.add(Uri.parse("http://img1.gamersky.com/image2013/10/20131031lx_5/gamersky_009small_018_201310311432CDF.jpg"));
        imageUrls.add(Uri.parse("http://p2.gexing.com/shaitu/20130207/1806/51137c9aa8ef6.jpg"));
        imageUrls.add(Uri.parse("http://imgstore.cdn.sogou.com/app/a/100540002/726395.jpg"));
        imageUrls.add(Uri.parse("http://p4.image.hiapk.com/uploads/allimg/150331/7730-150331100131.jpg"));
        imageUrls.add(Uri.parse("http://dl.bizhi.sogou.com/images/2013/07/17/347770.jpg"));
        imageUrls.add(Uri.parse("http://a.hiphotos.baidu.com/zhidao/pic/item/7dd98d1001e93901597db94678ec54e736d1964e.jpg"));
        return  imageUrls;
    }
}
