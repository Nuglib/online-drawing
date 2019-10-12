package com.sdrc.onlinedrawing.mapper;

import com.sdrc.onlinedrawing.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ImageMapper extends Mapper {

    /**
     * 查询banner轮播图
     * @return
     */
    @Select("select id as Id, plate as plate, image_path as ImagePath from table_image where plate='banner' and is_delete=0 ")
   public Image[] selectBannerImage();

    /**
     * 获取最新图片轮播图
     * @return
     */
    @Select("select id as Id, plate as plate,image_path as ImagePath from table_image where plate='newestimage' and is_delete=0 order by upload_time desc limit 0,9 ")
    public Image[] selectNewEstImage();

    /**
     * 获取最热轮播图片
     * @return
     */
    @Select("select id as Id, plate as Plate, image_path as ImagePath, hot as Hot from table_image where  is_delete=0 order by hot desc limit 0,9")
    public Image[] selectHotImageInfo();

    /**
     * 随机查询图片
     * @return
     */
    @Select("SELECT id as Id, plate as Plate, image_path as ImagePath FROM table_image WHERE id >= (SELECT FLOOR( MAX(id) * RAND()) FROM table_image ) and is_delete=0 ORDER BY id LIMIT 1 ")
    Image selectRandomImage();

    /**
     *
     * @param lable
     * @return
     */
    @Select("select id as Id, plate as Plate, image_path as ImagePath, hot as Hot from table_image where  is_delete=0 and label=#{label}")
    Image[] selectStyleElementGroup(@Param("label") String lable);
}