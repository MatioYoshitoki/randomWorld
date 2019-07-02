package com.matio.message;

/**
 * Created by matioyoshitoki on 2019/3/22.
 */
public class ErrorMessage extends BaseMessage {

    private String errCode ;

    public ErrorMessage(ErrorEnum errorEnum){
        this.text = errorEnum.getMsg();
        this.errCode = errorEnum.getCode();
    }

    public String getErrCode() {
        return errCode;
    }

}
