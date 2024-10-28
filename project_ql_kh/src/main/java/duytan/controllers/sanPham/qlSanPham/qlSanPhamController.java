package duytan.controllers.sanPham.qlSanPham;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.BoPhanQLDAO;
import duytan.dao.SanPhamDAO;
import duytan.entities.SanPham;
import duytan.entities.account.AccountDetails;


@Controller 
@RequestMapping("/qlSanPham")
public class qlSanPhamController {
	@Autowired
	SanPhamDAO sanPhamDAO;
	
	@Autowired
	BoPhanQLDAO boPhanQLDAO;
	
	@RequestMapping("/editSanPham")
	public String editSanPham(@RequestParam("id") int id, Model model) {
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("sanpham", sanPhamDAO.getById(id));
		model.addAttribute("bophanql", boPhanQLDAO.getAll());
		return "admin/san_pham/form_Edit";
	}
	
	@RequestMapping("/deleteSanPham")
	public String deleteSanPham(@RequestParam("id") int id, Model model) {
		sanPhamDAO.delete(id);
		return "redirect:/viewSanpham/";
	}
	
	@RequestMapping("/addSanPham")
	public String addSanPham(Model model) {
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("bophanql", boPhanQLDAO.getAll());
		model.addAttribute("sanpham", new SanPham());
		return "admin/san_pham/form_Add";
	}
	
	@RequestMapping("/saveEditSanPham")
	public String saveEditSanPham(@ModelAttribute("sanpham") SanPham sanpham){
		
		sanPhamDAO.update(sanpham);
		
		return "redirect:/viewSanpham/";
	}
	
	@RequestMapping("/saveAddSanPham")
	public String saveAddSanPham(@ModelAttribute("sanpham") SanPham sanPham) {
		
		sanPhamDAO.insert(sanPham);
		
		return "redirect:/viewSanpham/";
		
	}
	
	
}
