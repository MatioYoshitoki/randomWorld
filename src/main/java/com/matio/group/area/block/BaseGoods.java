package com.matio.group.area.block;

import com.matio.master.WorldBase;
import com.matio.master.WorldMaster;

/**
 * Created by matioyoshitoki on 2019/3/22.
 */
public class BaseGoods extends WorldBase {

    private Integer size ;

    public Integer getSize() {
        return size;
    }

    public static BaseGoods init(String name, Integer size){
        BaseGoods baseGoods = new BaseGoods(name, size);
        WorldMaster.addGoods(baseGoods, baseGoods.getLocalID());
        return baseGoods;
    }

    public BaseGoods(String name, Integer size){

        this.setSize(size);
        WorldMaster.register(this, name);

    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
