package com.matio.message;

import com.matio.choose.BaseChoose;
import com.matio.master.WorldBase;

import java.util.List;

/**
 * Created by matioyoshitoki on 2019/3/21.
 */
public class BaseMessage extends WorldBase{

    public Long time ;
    public String source ;
    public String text ;
    public List<BaseChoose> chooses ;

    public List<BaseChoose> getChooses() {
        return chooses;
    }

    public void setChooses(List<BaseChoose> chooses) {
        this.chooses = chooses;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTime() {
        return time;
    }

    public String getSource() {
        return source;
    }

    public String getText() {
        return text;
    }
}
