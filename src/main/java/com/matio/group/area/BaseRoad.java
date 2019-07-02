package com.matio.group.area;

import com.matio.group.area.block.BaseBlock;
import com.matio.master.WorldBase;
import com.matio.master.WorldMaster;
import com.matio.pojo.AreaSize;
import com.matio.pojo.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matioyoshitoki on 2019/3/23.
 */
public class BaseRoad extends BaseArea {

    public List<String> pointA ;
    public List<String> pointB ;

    public static BaseArea init(AreaSize areaSize, String areaName){

        BaseRoad baseRoad = new BaseRoad(areaName);
        baseRoad.setBlockMatrix(BlockMatrix.init(areaSize.getWidth(), areaSize.getHeight()));
        WorldMaster.addRoad(baseRoad, baseRoad.getLocalID());
        return baseRoad;

    }



    public BaseRoad(String areaName) {
        super(areaName);
    }


    public void setPointA(List<String> pointA) {
        this.pointA = pointA;
    }

    public void setPointB(List<String> pointB) {
        this.pointB = pointB;
    }

    public List<String> getPointA() {
        return pointA;
    }

    public List<String> getPointB() {
        return pointB;
    }
}
