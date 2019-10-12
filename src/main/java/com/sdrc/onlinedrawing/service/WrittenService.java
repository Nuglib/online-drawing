package com.sdrc.onlinedrawing.service;

import com.sdrc.onlinedrawing.pojo.WrittenWord;
import com.sdrc.onlinedrawing.util.InfoUtils;

public interface WrittenService {
    public InfoUtils getNewWrittenWord();

    public InfoUtils getHotWrittenWord();

    WrittenWord getRandomWrittenWord();

    InfoUtils getWrittenWordStyleElement();
}
