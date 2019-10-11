package com.sdrc.onlinedrawing.mapper;

import com.sdrc.onlinedrawing.pojo.WrittenWord;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WrittenMapper {

    /**
     * 获取最新上传文字
     * @return
     */
    @Select("select id as Id, content as content, plate as Plate, upload_time from table_writing where is_delete=0  order by upload_time desc limit 0,9")
    WrittenWord[] selectNewWrittenWord();

    /**
     * 获取点击量量多的前九条数据
     * @return
     */
    @Select("select id as Id, content as content, plate as Plate from table_writing where is_delete=0 order by hot desc limit 0,9")
    public WrittenWord[] selectHotWrittenWord();
}