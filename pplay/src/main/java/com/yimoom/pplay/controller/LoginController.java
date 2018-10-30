package com.yimoom.pplay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.service.UserService;

@RestController
public class LoginController {
	@Autowired
    UserService userservice;
    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(@AuthenticationPrincipal SysUser loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return null;
        }
        if (loginedUser != null) {
            return loginedUser;
        }
        return null;
    }
    @RequestMapping(value="/offline", method = RequestMethod.GET)
    @ResponseBody
    public String offline (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            //设置为离线状态
        	userservice.updateUserOnlineStatus(((SysUser)auth.getPrincipal()).getUid(), 4 ,null);
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "ok";
    }

}

