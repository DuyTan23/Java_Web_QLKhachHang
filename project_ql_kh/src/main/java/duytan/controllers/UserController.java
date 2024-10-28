package duytan.controllers;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.BoPhanQLDAO;
import duytan.dao.KhachHangDAO;
import duytan.dao.LoaiDonViDAO;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	KhachHangDAO khachHangDAO;
	
	@Autowired
	LoaiDonViDAO loaiDonViDAO;
	
	@Autowired
	BoPhanQLDAO bopPhanQLDAO;
	
	@RequestMapping("/")
	public String index(Model model) {
		//Lấy thông tin tài khoản khi login thành công
//		AccountDetails account =  (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("account", account);
//		model.addAttribute("khachhang", khachHangDAO.showALL());
//		model.addAttribute("loaidv", loaiDonViDAO.getAll());
//		
//		return "user/khach_hang/main/home";
		return "redirect:/viewKhachHang/";
		
	}
	
	
	@RequestMapping("/homeKhachHang")
	public String homeKhachHang() {
		return "redirect:/viewKhachHang/";
	}
	
	
	
	
	@RequestMapping("/viewKhachHang")
	public String viewKhachHang(@RequestParam("id") int id, Model model) {
		model.addAttribute("id", id);
		return "redirect:/viewKhachHang/viewKhachHang";
	}
	
	@RequestMapping("/hetHanBaoTri")
	public String hetHanBaoTri(@RequestParam("ngayhethan") String date, Model model) {
		
		model.addAttribute("ngayhethan", date);
		
		return "redirect:/viewKhachHang/hetHanBaoTri";
		
	}
	
	
	
	
}