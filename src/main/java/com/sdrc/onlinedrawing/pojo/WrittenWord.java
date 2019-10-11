package com.sdrc.onlinedrawing.pojo;

/**
 * 文字实体类
 */
public class WrittenWord {
    private Integer Id;
    private String Content;   //文字内容
    private String plate;   //板块信息
    private Integer IsDelete;   //是否已经删除  0表示为删除  1 表示已删除


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Integer isDelete) {
        IsDelete = isDelete;
    }


    @Override
    public String toString() {
        return "WrittenWord{" +
                "Id=" + Id +
                ", Content='" + Content + '\'' +
                ", plate='" + plate + '\'' +
                ", IsDelete=" + IsDelete +
                '}';
    }
}
