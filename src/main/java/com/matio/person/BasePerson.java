package com.matio.person;

import com.matio.group.area.block.BaseBlock;
import com.matio.group.area.block.BaseGoods;
import com.matio.master.WorldBase;
import com.matio.master.WorldMaster;
import com.matio.message.ErrorEnum;
import com.matio.message.ErrorMessage;
import com.matio.person.item.BaseBag;
import com.matio.prefer.BasePrefer;

/**
 * Created by matioyoshitoki on 2019/3/22.
 */
public class BasePerson  extends WorldBase {

    public BaseBag baseBag;
    public BaseBlock location;
    public BasePrefer normalPrefer ;
    public Long money ;

    public BasePerson init(String name){

        BasePrefer prefer = new BasePrefer();
        BasePerson basePerson = new BasePerson(name,prefer);
        WorldMaster.register(basePerson, name);
        return basePerson;
    }

    private BasePerson(String name, BasePrefer normalPrefer){
        this.setName(name);
        this.setNormalPrefer(normalPrefer);
    }

    public Integer getBagAvailable(){
        return baseBag.getAvailable();
    }

    private void setBaseBag(BaseBag baseBag) {
        this.baseBag = baseBag;
    }

    private void setNormalPrefer(BasePrefer normalPrefer) {
        this.normalPrefer = normalPrefer;
    }

    public void receiveGoods(BaseGoods goods){
        baseBag.addGoods(goods);
    }

    public void moveTo(BaseBlock target){
        ErrorMessage errorMessage = location.removePerson();
        if (!errorMessage.getErrCode().equals(ErrorEnum.SUCCESS.getCode())){
            return;
        }
        errorMessage = target.setPerson(this);
        if (!errorMessage.getErrCode().equals(ErrorEnum.SUCCESS.getCode())){
            location.setPerson(this);
            return;
        }

    }

}
