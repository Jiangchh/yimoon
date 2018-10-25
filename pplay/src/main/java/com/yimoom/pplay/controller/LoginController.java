package com.yimoom.pplay.controller;



import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yimoom.pplay.domain.Result;

import java.util.List;

@Controller
public class LoginController  {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping({ "/", "" })
	String welcome(Model model) {
		
		return "redirect:/login";
	}

	@GetMapping({ "/index" })
	public String index(Model model) {
//		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
//		model.addAttribute("menus", menus);
//		model.addAttribute("name", getUser().getName());
//		FileDO fileDO = fileService.get(getUser().getPicId());
//		if(fileDO!=null&&fileDO.getUrl()!=null){
//			if(fileService.isExist(fileDO.getUrl())){
//				model.addAttribute("picUrl",fileDO.getUrl());
//			}else {
//				model.addAttribute("picUrl","/img/photo_s.jpg");
//			}
//		}else {
//			model.addAttribute("picUrl","/img/photo_s.jpg");
//		}
//		model.addAttribute("username", getUser().getAccount());
		return "index_v1";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@PostMapping("/login")
	@ResponseBody
	public Result ajaxLogin(String username, String password) {
		return new Result();
	}

	@GetMapping("/logout")
	String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}

}
