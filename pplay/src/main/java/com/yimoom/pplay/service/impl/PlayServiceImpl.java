package com.yimoom.pplay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.dao.PlayMapper;
import com.yimoom.pplay.domain.app.query.PlayListQueryDo;
import com.yimoom.pplay.service.PlayService;
@Service
public class PlayServiceImpl implements PlayService{
	@Autowired
	PlayMapper playMapper;
	@Override
	public List<PlayListQueryDo> getPlayListView(PlayListQueryDo playListQueryDo) {
		return playMapper.getPlayListView(playListQueryDo);
	}

}
