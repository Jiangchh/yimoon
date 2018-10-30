package com.yimoom.pplay.constants;

import java.util.HashMap;
import java.util.Map;

import com.yimoom.pplay.base.BaseEnum;

public enum OnlineStatus implements BaseEnum<Integer, String>{


   

    ALREADY_LOGIN_IN(4, "已登陆"),

    ALREADY_OFF_LINE(5, "已下线");

    private int code;

    private String desc;

    private static Map<Integer, String> allMap = new HashMap<>();

    OnlineStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static {
        for(OnlineStatus enums : OnlineStatus.values()){
            allMap.put(enums.code, enums.desc);
        }
    }

    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String desc() {
        return desc;
    }

    public String desc(int code) {
        return allMap.get(code);
    }


}
