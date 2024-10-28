package duytan.controllers.khachHang.qlKhachHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.BoPhanQLDAO;
import duytan.dao.KhachHangDAO;
import duytan.dao.LoaiDonViDAO;
import duytan.entities.KhachHang;
import duytan.entities.SanPham;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/qlKhachHang")
public class qlKhachHangController {
	
	@Autowired
	KhachHangDAO khachHangDAO;
	
	@Autowired
	LoaiDonViDAO loaiDonViDAO;
	
	@Autowired
	BoPhanQLDAO bopPhanQLDAO;
	
	@RequestMapping("/addKhachHang")
	public String addKhachHang(Model model) {
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("khachhang", new KhachHang());
		model.addAttribute("loaidonvi", loaiDonViDAO.getAll());
		model.addAttribute("bophanql", bopPhanQLDAO.getAll());
		return "admin/khach_hang/form_Add";
	}
	
	
	@RequestMapping("/editKhachHang")
	public String editKhachHang(Model model, @RequestParam("id") int id) {
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("khachhang", khachHangDAO.getById(id));
		model.addAttribute("loaidonvi", loaiDonViDAO.getAll());
		model.addAttribute("bophanql", bopPhanQLDAO.getAll());
		return "admin/khach_hang/form_Edit";
		
	}
	
	@RequestMapping("/deleteKhachHang")
	public String deleteKhachHang(Model model, @RequestParam("id") int id) {
		khachHangDAO.delete(id);
		return "redirect:/user/";
	}
	
	@RequestMapping("/saveEditKhachHang")
	public String saveEditKhachHang(@ModelAttribute("khachhang") KhachHang khachHang) {
		
		khachHangDAO.update(khachHang);
		
		return "redirect:/user/";
		
	}
	@RequestMapping("saveAddKhachHang")
	public String saveAddKhachHang(@ModelAttribute("khachhang") KhachHang khachHang, ModelMap map) {
		
		khachHangDAO.insert(khachHang);
		
		return "redirect:/user/";
	}
	
	

}
