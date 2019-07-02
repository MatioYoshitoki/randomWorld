package com.matio.prefer;

import com.matio.master.WorldBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by matioyoshitoki on 2019/3/22.
 */
public class BasePrefer extends WorldBase {

    private Double LK ;
    private Double NK ;
    private Double MK ;
    private Double LN ;
    private Double N ;
    private Double MN;
    private Double LE ;
    private Double NE ;
    private Double ME ;

    private HashMap<String, Double> preferMap = new HashMap<String, Double>();

    private List<String> nameList = new ArrayList<String>();

    public BasePrefer(){
        preferMap.put("LK",1d/9d);
        preferMap.put("NK",1d/9d);
        preferMap.put("MK",1d/9d);
        preferMap.put("LN",1d/9d);
        preferMap.put("N",1d/9d);
        preferMap.put("MN",1d/9d);
        preferMap.put("LE",1d/9d);
        preferMap.put("NE",1d/9d);
        preferMap.put("ME",1d/9d);
        nameList.add("LK");
        nameList.add("NK");
        nameList.add("MK");
        nameList.add("LN");
        nameList.add("N");
        nameList.add("MN");
        nameList.add("LE");
        nameList.add("NE");
        nameList.add("ME");
    }

    public void adjustSet(Double prefer , String name){
        if (!nameList.contains(name)){
            return;
        }
        Double old = preferMap.get(name);
        Double drt = (prefer - old)/8d;
        for (String key:nameList){
            if (!key.equals(name)){
                preferMap.put(key ,preferMap.get(key)+drt);
            }else {
                preferMap.put(key ,prefer);
            }

        }
    }

    public void adjustAdd(Double prefer , String name){
        if (!nameList.contains(name)){
            return;
        }

        for (String key:nameList){
            if (!key.equals(name)){
                preferMap.put(key ,preferMap.get(key)-(prefer/8d));
            }else {
                preferMap.put(key ,preferMap.get(key)+prefer);
            }

        }
    }
}
