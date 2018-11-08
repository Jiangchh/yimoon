package com.yimoom.pplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yimoom.pplay.domain.app.query.PlayListQueryDo;
import com.yimoom.pplay.service.PlayService;
@RequestMapping("/play")
@RestController
public class PlayController {
	@Autowired
    private PlayService playService;
	
	 @RequestMapping(value="/getPlayListView")
	public List<PlayListQueryDo>getPlayListView(PlayListQueryDo playListQueryDo){
		 return playService.getPlayListView(playListQueryDo);
	}

}
