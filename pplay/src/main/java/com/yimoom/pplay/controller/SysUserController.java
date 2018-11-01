package com.yimoom.pplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.service.SysUserService;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class SysUserController {
	@Autowired
    private SysUserService sysUservice;

    @RequestMapping(method = RequestMethod.GET)
    public List<SysUser> getUsers() {
        return sysUservice.getUser(null);
    }

}
