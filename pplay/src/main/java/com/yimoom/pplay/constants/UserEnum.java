package com.yimoom.pplay.constants;

import java.util.HashMap;
import java.util.Map;

import com.yimoom.pplay.common.base.constants.BaseEnum;

public enum UserEnum implements BaseEnum<Integer, String>{
	FEMALE(0, "女"),
	MALE(1, "男"),
	LOCK(2, "冻结"),
	UNLOCK(3, "正常");
	private Integer code;

    private String desc;

    private static Map<Integer, String> allMap = new HashMap<>();

    UserEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static {
        for(UserEnum enums : UserEnum.values()){
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

    public static String desc(Integer code) {
        return allMap.get(code);
    }
		
}
