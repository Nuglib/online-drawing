package com.sdrc.onlinedrawing.pojo;

public class Image {
    private int Id;   //Id
    private String Plate;   //板块
    private String ImagePath;    //地址
    private int IsDelete;     //是否删除了1表示删除0表示没有删除可以显示

    private int Hot;    //热度

    public Image() {
    }

    public Image(int id, String plate, String imagePath, int isDelete) {
        Id = id;
        Plate = plate;
        ImagePath = imagePath;
        IsDelete = isDelete;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPlate() {
        return Plate;
    }

    public void setPlate(String plate) {
        Plate = plate;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(int isDelete) {
        IsDelete = isDelete;
    }

    public int getHot() {
        return Hot;
    }

    public void setHot(int hot) {
        Hot = hot;
    }

    @Override
    public String toString() {
        return "Image{" +
                "Id=" + Id +
                ", Plate='" + Plate + '\'' +
                ", ImagePath='" + ImagePath + '\'' +
                ", IsDelete=" + IsDelete +
                ", Hot=" + Hot +
                '}';
    }
}
