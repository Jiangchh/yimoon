package com.yimoom.pplay.service;

import org.springframework.stereotype.Service;

import com.yimoom.pplay.domain.LogDO;
import com.yimoom.pplay.utils.Query;


@Service
public interface LogService {
	void save(LogDO logDO);
	
	int remove(Long id);
	int batchRemove(Long[] ids);
}
