package com.recyclerviewdatabinding;

public class DataModel {

    public String local1,local2,local3;

    public DataModel(String loc1,String loc2,String loc3){
        this.local1 = loc1;
        this.local2 = loc2;
        this.local3 = loc3;
    }

    public String getLocal1(){
        return local1;
    }
}
