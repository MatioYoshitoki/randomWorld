package com.matio.pojo;

/**
 * Created by matioyoshitoki on 2019/3/23.
 */
public class AreaSize {
    private Integer width ;
    private Integer height ;

    public AreaSize(Integer width, Integer height){
        this.width = width;
        this.height = height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }
}
