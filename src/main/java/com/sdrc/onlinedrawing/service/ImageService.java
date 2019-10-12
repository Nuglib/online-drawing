package com.sdrc.onlinedrawing.service;

import com.sdrc.onlinedrawing.pojo.Image;
import com.sdrc.onlinedrawing.util.InfoUtils;

public interface ImageService {
    public InfoUtils getBannerImage();

    public InfoUtils getNewEstImage();

    public InfoUtils getHotImageInfo();

    Image getRandomImageInfo();

    InfoUtils getStyleElementsGroup();
}