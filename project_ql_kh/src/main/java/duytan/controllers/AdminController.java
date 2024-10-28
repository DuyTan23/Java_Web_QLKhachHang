package duytan.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("msg", "QUẢN LÝ THÔNG TIN DÀNH CHO QUẢN TRỊ VIÊN");
		//lấy thông tin tài khoản khi login thành công
		AccountDetails account =  (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		return "admin/home";
	}
	
	@RequestMapping("/toUser")
	public String toUser() {
		return "redirect:/user/";
	}

}