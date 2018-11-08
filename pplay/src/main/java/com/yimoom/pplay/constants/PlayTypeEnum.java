package com.yimoom.pplay.constants;

import java.util.HashMap;
import java.util.Map;

import com.yimoom.pplay.common.base.constants.BaseEnum;

public enum PlayTypeEnum implements BaseEnum<Integer, String>{
	CITY(0,"都市"),
	SUSPENSE(1,"悬疑"),
	COURT(2,"宫廷"),
	STRANGE(3,"奇幻"),
	CAMPUS(4,"校园"),
	EROTICA(5,"言情"),
	HISTORY(6,"历史"),
	MARTIAL(7,"武侠"),
	OTHER(8,"其他");
	private Integer code;

    private String desc;

    private static Map<Integer, String> allMap = new HashMap<>();

    PlayTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static {
        for(PlayTypeEnum enums : PlayTypeEnum.values()){
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
