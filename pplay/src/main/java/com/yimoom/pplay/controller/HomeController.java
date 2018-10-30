package com.yimoom.pplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    @GetMapping({ "/", "","/index" })
	String welcome(Model model) {
		
		return "redirect:/login";
	}
    //@Secured({"ROLE_ADMIN","ROLE_USER"})//此方法只允许 ROLE_ADMIN 和ROLE_USER 角色 访问
//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
//    	return null;
//    	/*
//        // 登录失败从request中获取shiro处理的异常信息。
//        // shiroLoginFailure:就是shiro异常类的全类名.
//        Object exception = request.getAttribute("shiroLoginFailure");
//        String msg = "";
//        if (exception != null) {
//            if (UnknownAccountException.class.isInstance(exception)) {
//                msg = "账户不存在或密码不正确";
//            } else if (IncorrectCredentialsException.class.isInstance(exception)) {
//                msg = "账户不存在或密码不正确";
//            } else {
//                msg = "其他异常";
//            }
//        }
//        map.put("msg", msg);
//        // 此方法不处理登录成功,由shiro进行处理.
//        return "login";
//    */}


}

