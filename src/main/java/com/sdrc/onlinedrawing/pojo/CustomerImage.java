package com.sdrc.onlinedrawing.pojo;

/**
 * 客户上传图片实体
 */
public class CustomerImage {
    private Integer id;
    private String imagePath;

    private String userId;

    public CustomerImage() {
    }

    public CustomerImage(Integer id, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "CustomerImage{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}