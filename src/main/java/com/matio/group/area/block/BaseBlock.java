package com.matio.group.area.block;

import com.matio.group.area.block.attribute.BlockType;
import com.matio.group.area.block.attribute.OccupyFlag;
import com.matio.master.WorldBase;
import com.matio.master.WorldMaster;
import com.matio.person.BasePerson;
import com.matio.message.ErrorEnum;
import com.matio.message.ErrorMessage;

/**
 * Created by matioyoshitoki on 2019/3/22.
 */
public class BaseBlock extends WorldBase {

    private Integer x ;
    private Integer y ;
    private BlockType blockType ;
    private OccupyFlag occupyFlag ;
    private BaseGoods goods;
    private BasePerson person;
    private String messagePoolID ;

    public static BaseBlock init(Integer x, Integer y, String messagePoolID){
        BaseBlock baseBlock = new BaseBlock(x, y, messagePoolID);
        WorldMaster.addBlock(baseBlock, baseBlock.getLocalID());
        return baseBlock;
    }

    BaseBlock(Integer x, Integer y, String messagePoolID){
        this.x = x ;
        this.y = y ;
        this.messagePoolID = messagePoolID;
        WorldMaster.register(this, null);
    }

    public ErrorMessage setGoods(BaseGoods goods){
        ErrorMessage errorMessage ;
        if (occupyFlag == OccupyFlag.Unoccupied){
            this.goods = goods;
            errorMessage = new ErrorMessage(ErrorEnum.PersonGoodsPutSuccess);
            blockType = BlockType.GoodsBlock;
            occupyFlag = OccupyFlag.Occupied;
            return errorMessage;
        }else {
            errorMessage = new ErrorMessage(ErrorEnum.PersonGoodsPutFailed);
            return errorMessage;
        }
    }

    public Integer getGoodsSize() {
        return goods.getSize();
    }

    public BaseGoods getGoods() {
        return goods;
    }

    public ErrorMessage removeGoods(BasePerson basePerson){
        ErrorMessage errorMessage ;
        if (occupyFlag == OccupyFlag.Unoccupied){
            errorMessage = new ErrorMessage(ErrorEnum.GoodsRemoveFailedNoGoods);
        }else {
            if (blockType == BlockType.GoodsBlock) {
                if (basePerson.getBagAvailable() < getGoodsSize()) {
                    errorMessage = new ErrorMessage(ErrorEnum.GoodsRemoveFailedBagNoAva);
                } else {
                    errorMessage = new ErrorMessage(ErrorEnum.PersonGoodsRemoveSuccess);
                    occupyFlag = OccupyFlag.Unoccupied;
                    blockType = BlockType.NothingBlock;
                    basePerson.receiveGoods(getGoods());
                }
            }else{
                errorMessage = new ErrorMessage(ErrorEnum.GoodsRemoveFailedNoGoods);
            }
        }
        return  errorMessage ;
    }

    public ErrorMessage setPerson(BasePerson basePerson){
        ErrorMessage errorMessage ;
        if (occupyFlag == OccupyFlag.Unoccupied){
            this.person = basePerson;
            errorMessage = new ErrorMessage(ErrorEnum.PersonGoodsPutSuccess);
            blockType = BlockType.PersonBlock;
            occupyFlag = OccupyFlag.Occupied;
            return errorMessage;
        }else {
            errorMessage = new ErrorMessage(ErrorEnum.PersonGoodsPutFailed);
            return errorMessage;
        }
    }

    public ErrorMessage removePerson(){
        ErrorMessage errorMessage ;
        if (occupyFlag == OccupyFlag.Unoccupied){
            errorMessage = new ErrorMessage(ErrorEnum.PersonRemoveFailedNoPerson);
        }else {
            if (blockType == BlockType.PersonBlock) {
                errorMessage = new ErrorMessage(ErrorEnum.PersonGoodsRemoveSuccess);
                occupyFlag = OccupyFlag.Unoccupied;
                blockType = BlockType.NothingBlock;
            }else{
                errorMessage = new ErrorMessage(ErrorEnum.PersonRemoveFailedNoPerson);
            }
        }
        return  errorMessage ;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public OccupyFlag getOccupyFlag() {
        return occupyFlag;
    }
}
