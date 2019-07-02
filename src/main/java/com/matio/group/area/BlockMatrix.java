package com.matio.group.area;

import com.matio.group.area.block.BaseBlock;
import com.matio.master.WorldMaster;
import com.matio.message.BaseMessagePool;

/**
 * Created by matioyoshitoki on 2019/3/22.
 */
public class BlockMatrix {

    private BaseBlock[][] baseBlocks ;
    private Integer width ;
    private Integer height;

    public static BlockMatrix init(Integer width, Integer height){
        BlockMatrix blockMatrix = new BlockMatrix(width, height);
        for (int x=0;x<blockMatrix.getWidth();x++){
            for (int y = 0; y<blockMatrix.getHeight(); y++){
                BaseMessagePool messagePool = BaseMessagePool.init();
                WorldMaster.addMessagePool(messagePool, messagePool.getLocalID());
                BaseBlock baseBlock = BaseBlock.init(x, y, messagePool.getGlobalID());
                blockMatrix.getBaseBlocks()[x][y] = baseBlock;
            }
        }
        return blockMatrix;
    }

    BlockMatrix(Integer width, Integer height){

        width = width==null?0:width;
        height = height==null?0:height;

        width = width>0?width:0;
        height = height>0?height:0;
        this.width = width ;
        this.height = height ;
        this.baseBlocks = new BaseBlock[width][height];
    }

    public BaseBlock[][] getBaseBlocks() {
        return baseBlocks;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setBaseBlocks(BaseBlock[][] baseBlocks) {
        this.baseBlocks = baseBlocks;
    }

    public void setOneBlock(Integer x, Integer y, BaseBlock block){
        if ( x<width && y< height){
            baseBlocks[x][y] = block;
        }
    }
}
