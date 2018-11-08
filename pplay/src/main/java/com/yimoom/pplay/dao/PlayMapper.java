package com.yimoom.pplay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yimoom.pplay.domain.app.query.PlayListQueryDo;

@Mapper
public interface PlayMapper {
	public List<PlayListQueryDo>getPlayListView(PlayListQueryDo playListQueryDo);
}
