package com.yimoom.pplay.constants;

import java.nio.charset.Charset;

import com.google.common.base.Charsets;

/**
 * 系统级常量类
 *
 * 
 */
public class Constants {

	public static final String APP_NAME = "sunny";
	/**
	 * redis的超时时间
	 */
	public static final long TOKEN_EXPIRES_HOUR=86400;
	/**
	 * 系统编码
	 */
	public static final Charset CHARSET = Charsets.UTF_8;
	/**
	 * 用户最小会话数量
	 */
	public static final int MINUSERSESSION = 1;
	/**
	 *  有效时间：单位s
	 */
	public static final int TOKENVALIDITYSECONDS=60;

	/**
	 * 标识：是/否、启用/禁用等
	 */
	public interface Flag {

		Integer YES = 1;

		Integer NO = 0;
	}

	/**
	 * 操作类型
	 */
	public interface Operation {
		/**
		 * 添加
		 */
		String ADD = "add";
		/**
		 * 更新
		 */
		String UPDATE = "update";
		/**
		 * 删除
		 */
		String DELETE = "delete";
	}

	/**
	 * 性别
	 */
	public interface Gender {
		/**
		 * 男
		 */
		Integer MALE = 1;
		/**
		 * 女
		 */
		Integer FEMALE = 0;
	}

}
