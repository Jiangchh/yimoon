package com.yimoom.pplay.service;

import com.yimoom.pplay.domain.LogDO;



public interface LogService {
	void save(LogDO logDO);
	
	int remove(Long id);
	int batchRemove(Long[] ids);
}
