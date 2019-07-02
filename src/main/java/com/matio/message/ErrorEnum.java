package com.matio.message;

/**
 * Created by matioyoshitoki on 2019/3/22.
 */
public enum  ErrorEnum {

    SUCCESS("0", "成功"),
    FINISH("-1", "失败"),
    PersonGoodsPutSuccess("0","人物/物品放置成功!"),
    PersonGoodsPutFailed("-1","人物/物品放置失败,位置已被占用..."),
    GoodsRemoveFailedBagNoAva("-1","物品移除失败,背包空间不足..."),
    PersonGoodsRemoveSuccess("0","物品/人物移除成功!"),
    GoodsRemoveFailedNoGoods("-1","物品移除失败,该处无物品..."),
    PersonRemoveFailedNoPerson("-1","人物移除失败,人物无物品..."),;


    private String code;

    private String msg;

    ErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
