package com.yimoom.pplay.service;

import java.util.List;

import com.yimoom.pplay.domain.app.query.PlayListQueryDo;

public interface PlayService {
	public List<PlayListQueryDo>getPlayListView(PlayListQueryDo playListQueryDo);
}
