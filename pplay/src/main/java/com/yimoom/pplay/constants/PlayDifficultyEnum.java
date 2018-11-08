package com.yimoom.pplay.constants;

import java.util.HashMap;
import java.util.Map;

import com.yimoom.pplay.common.base.constants.BaseEnum;

public enum PlayDifficultyEnum implements BaseEnum<Integer, String>{
	SIMPLE(0, "简单"),
	NORMAL(1, "普通"),
	DIFFICULT(2,"困难");
	private Integer code;

    private String desc;

    private static Map<Integer, String> allMap = new HashMap<>();

    PlayDifficultyEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static {
        for(PlayDifficultyEnum enums : PlayDifficultyEnum.values()){
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
