package com.sdrc.onlinedrawing.mapper;

import com.sdrc.onlinedrawing.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;

@Resource
public interface ImageMapper extends Mapper {

    @Select("select id as Id, plate as plate, image_path as ImagePath from table_image")
   public Image[] selectBannerImage();
}
