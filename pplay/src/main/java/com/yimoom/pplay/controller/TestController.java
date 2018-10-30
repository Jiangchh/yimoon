package com.yimoom.pplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.service.UserService;

@RestController
public class TestController {
	@Autowired
	UserService uif;
	
	@RequestMapping(value = "/test/{username}", method = RequestMethod.GET)
	@ResponseBody
	public SysUser hello(@PathVariable(name = "username") String username) {
		//return uif.findByUsername(username);
		return null;
	}
}
