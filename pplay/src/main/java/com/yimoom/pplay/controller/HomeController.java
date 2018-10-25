package com.yimoom.pplay.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yimoom.pplay.domain.Msg;
import com.yimoom.pplay.log.WebLog;


@Controller
public class HomeController {
	@WebLog("登陆主页")
    @RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }
}

