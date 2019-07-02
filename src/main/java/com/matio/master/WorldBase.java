package com.matio.master;

/**
 * Created by matioyoshitoki on 2019/3/23.
 */
public class WorldBase {
    private String globalID ;
    private String localID ;
    private String name ;

    public void setGlobalID(String globalID) {
        this.globalID = globalID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getGlobalID() {
        return globalID;
    }

    public String getLocalID() {
        return localID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
