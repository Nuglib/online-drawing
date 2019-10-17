package com.sdrc.onlinedrawing.mapper;

import com.sdrc.onlinedrawing.pojo.CustomerImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UploadImageMapper {

    @Insert({
            "<script>",
            "insert into table_customer_image (image_path,upload_time) values",
            "<foreach collection='arrayList' item='item' index='index' separator=','>",
            "(#{item.imagePath}, now())",
            "</foreach>",
            "</script>"
    })
    int insertUploadCustomer(@Param("arrayList") List<CustomerImage> arrayList);
}
