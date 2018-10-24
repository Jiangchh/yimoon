package com.yimoom.pplay.base;
/**
 * @version 1.0
 * @author jiangchenghua 2018-10-24
 *
 */
public interface BaseEnum<K,V> {
	 /**
     * 获取编码
     *
     * @return 编码
     */
    K code();

    /**
     * 获取描述
     * 
     * @return 描述
     */
    V desc();
}
