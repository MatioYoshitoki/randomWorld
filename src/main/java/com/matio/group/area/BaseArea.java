package com.matio.group.area;

import com.matio.group.area.block.BaseBlock;
import com.matio.group.area.block.attribute.BlockType;
import com.matio.group.area.block.attribute.OccupyFlag;
import com.matio.master.WorldBase;
import com.matio.master.WorldMaster;
import com.matio.pojo.AreaSize;
import com.matio.util.CommUtil;

/**
 * Created by matioyoshitoki on 2019/3/21.
 */
public class BaseArea extends WorldBase{

    private BlockMatrix blockMatrix ;


    public static BaseArea init(AreaSize areaSize, String areaName){
        BaseArea baseArea = new BaseArea(areaName);
        baseArea.setBlockMatrix(BlockMatrix.init(areaSize.getWidth(), areaSize.getHeight()));
        WorldMaster.addArea(baseArea, baseArea.getLocalID());
        return baseArea;

    }

    public BaseArea(String areaName){

        WorldMaster.register(this, areaName);


    }

    public void setBlockMatrix(BlockMatrix blockMatrix) {
        this.blockMatrix = blockMatrix;
    }

    public AreaSize getAreaSize(){
        return new AreaSize(blockMatrix.getWidth(), blockMatrix.getHeight());
    }

    public Integer getPersonCount(){
        if (!CommUtil.checkNull(blockMatrix)){
            Integer personCount = 0;
            BaseBlock[][] tmp = blockMatrix.getBaseBlocks();
            for (int i=0;i<blockMatrix.getWidth();i++){
                for (int j=0;j<blockMatrix.getHeight();j++){
                    if (tmp[i][j].getBlockType().equals(BlockType.PersonBlock)&&tmp[i][j].getOccupyFlag().equals(OccupyFlag.Occupied)){
                        personCount ++;
                    }
                }
            }
            return personCount;
        }else {
            return 0;
        }
    }

    public String getAreaName() {
        return getName();
    }
}
