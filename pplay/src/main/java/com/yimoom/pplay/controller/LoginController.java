package com.yimoom.pplay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value="/offline", method = RequestMethod.GET)
    @ResponseBody
    public String offline (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            //设置为离线状态
        	//userservice.updateUserOnlineStatus(((SysUser)auth.getPrincipal()).getUid(), 4 ,null);
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "ok";
    }

}

