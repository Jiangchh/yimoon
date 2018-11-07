package com.yimoom.pplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.domain.sys.query.QuerySysUser;
import com.yimoom.pplay.service.SysUserService;
@Controller
@RequestMapping("/user")
@PreAuthorize("hasRole('admin')")
public class SysUserController {
	@Autowired
    private SysUserService sysUservice;

    @RequestMapping(value="/searchAllUser",method = RequestMethod.POST)
    @ResponseBody
    //@RequestBody(required = false)
    public List<SysUser> getUsers(@RequestBody(required = false) QuerySysUser qsr,Model model) {
    	System.err.println("############$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+qsr);
    	List<SysUser> qs=sysUservice.SearchUser(qsr);
    	model.addAttribute("sysuserlist", qs);
        return qs;
    }

}
