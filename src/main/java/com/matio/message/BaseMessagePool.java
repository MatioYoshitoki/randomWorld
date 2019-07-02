package com.matio.message;

import com.matio.master.WorldBase;
import com.matio.master.WorldMaster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matioyoshitoki on 2019/3/23.
 */
public class BaseMessagePool extends WorldBase {

    List<BaseMessage> messages ;

    public static BaseMessagePool init(){
        return new BaseMessagePool();
    }

    public BaseMessagePool(){
        WorldMaster.register(this,null);
        messages = new ArrayList<BaseMessage>();
    }

}
