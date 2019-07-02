package com.matio.master;

import com.matio.choose.BaseChoose;
import com.matio.group.BaseGroup;
import com.matio.group.area.BaseArea;
import com.matio.group.area.BaseRoad;
import com.matio.group.area.block.BaseBlock;
import com.matio.group.area.block.BaseGoods;
import com.matio.message.BaseMessagePool;
import com.matio.message.ErrorEnum;
import com.matio.message.ErrorMessage;
import com.matio.person.BasePerson;
import com.matio.person.item.BaseBag;
import com.matio.util.SnowFlakeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by matioyoshitoki on 2019/3/21.
 */
public class WorldMaster {

    private static SnowFlakeUtil snowFlakeUtil = new SnowFlakeUtil();

    public static String getGlobalID(){
        return snowFlakeUtil.getUUID();
    }
    public static String getLocalID(){
        return snowFlakeUtil.getShortUUID();
    }
    static HashMap<String, BaseMessagePool> messagePools = new HashMap<String, BaseMessagePool>();
    static HashMap<String, BaseBlock> blocks = new HashMap<String, BaseBlock>();
    static HashMap<String, BaseArea> areas = new HashMap<String, BaseArea>();
    static HashMap<String, BaseGoods> goods = new HashMap<String, BaseGoods>();
    static HashMap<String, BaseGroup> groups = new HashMap<String, BaseGroup>();
    static HashMap<String, BaseChoose> chooses = new HashMap<String, BaseChoose>();
    static HashMap<String, BaseRoad> roads = new HashMap<String, BaseRoad>();
    static HashMap<String, BasePerson> persons = new HashMap<String, BasePerson>();



    public static ErrorMessage register(WorldBase worldBase,String name){

        worldBase.setGlobalID(getGlobalID());
        worldBase.setLocalID(getLocalID());
        worldBase.setName(name);

        return new ErrorMessage(ErrorEnum.FINISH);
    }

    public static void addMessagePool(BaseMessagePool messagePool, String localID){

        if (!messagePools.containsKey(localID)){
            messagePools.put(localID, messagePool);
        }
    }

    public static void addRoad(BaseRoad road, String localID){
        if (!roads.containsKey(localID)){
            roads.put(localID, road);
        }
    }

    public static void addBlock(BaseBlock block, String localID){
        if (!blocks.containsKey(localID)){
            blocks.put(localID, block);
        }
    }

    public static void addArea(BaseArea area, String localID){
        if (!areas.containsKey(localID)){
            areas.put(localID, area);
        }
    }

    public static void addGoods(BaseGoods good, String localID){
        if (!goods.containsKey(localID)){
            goods.put(localID, good);
        }
    }

    public static void addPersons(BasePerson person, String localID){
        if (!persons.containsKey(localID)){
            persons.put(localID, person);
        }
    }

    public static void addGroup(BaseGroup group, String localID){
        if (!groups.containsKey(localID)){
            groups.put(localID, group);
        }
    }

    public static void addChoose(BaseChoose choose, String localID){
        if (!chooses.containsKey(localID)){
            chooses.put(localID, choose);
        }
    }
}
