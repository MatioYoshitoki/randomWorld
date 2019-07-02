package com.matio.person.item;

import com.matio.group.area.block.BaseGoods;
import com.matio.master.WorldBase;
import com.matio.master.WorldMaster;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by matioyoshitoki on 2019/3/22.
 */
public class BaseBag  extends WorldBase {
    private Integer size ;//背包容量
    private Map<String, BaseGoods> goodsMap ;

    public Integer getSize() {
        return size;
    }

    public Integer getAvailable(){
        Integer available = size;
        Iterator<String> keys = goodsMap.keySet().iterator();
        while (keys.hasNext()){
            available -= goodsMap.get(keys.next()).getSize();
        }
        return available;
    }
    public void addGoods(BaseGoods goods){
        if (goods.getSize()<=getAvailable()) {
            String localID = WorldMaster.getLocalID();
            while (goodsMap.containsKey(localID)){
                localID = WorldMaster.getLocalID();
            }
            goodsMap.put(localID,goods);
        }
    }
}
