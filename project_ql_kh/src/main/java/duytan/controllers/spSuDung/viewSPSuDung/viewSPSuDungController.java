package duytan.controllers.spSuDung.viewSPSuDung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.SPSuDungDAO;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/viewSPSuDung")
public class viewSPSuDungController {

	@Autowired
	SPSuDungDAO spSuDungDAO;

	@RequestMapping("/")
	public String index (@Nullable @RequestParam("date") String date,@Nullable @RequestParam("page") Integer page,Model model) {

		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		
		int pagesize = 2;
		page = page == null ? 1 : page;
		int count = spSuDungDAO.count();
		int pagecount = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		
		if(date != null) {
			model.addAttribute("spsudung", spSuDungDAO.searchSPSuDung(date));
		}
		
		else {
			model.addAttribute("spsudung", spSuDungDAO.showAll(page, pagesize));
		}
		
		model.addAttribute("pagecount", pagecount);
		
		return "user/sp_su_dung/main/home";
	}

	@RequestMapping("/homeKhachHang")
	public String homeKhachHang() {
		return "redirect:/viewKhachHang/";
	}

	@RequestMapping("/homeSanPham")
	public String homeSanPham() {
		return "redirect:/viewSanpham/";
	}

	@RequestMapping("/homeSPSuDung")
	public String homeSPSuDung() {
		return "redirect:/viewSPSuDung/";
	}

	@RequestMapping("/searchSPSuDung")
	public String searchSPSuDung(@Nullable @RequestParam("ngayhoatdong") String date, Model model) {
		
		model.addAttribute("date", date);
		
		return "redirect:/viewSPSuDung/";
	}
	
	@RequestMapping("/addSPSuDung")
	public String addSPSuDung() {
		return "redirect:/qlSPSuDung/addSPSuDung";
	}
	
	@RequestMapping("/deleteSPSuDung")
	public String deleteSPSuDung(Model model, @RequestParam("idkh") int idkh,
			 @RequestParam("idsanpham") int idsanpham) {
		
		model.addAttribute("idkh", idkh)	;
		model.addAttribute("idsanpham", idsanpham);

		return "redirect:/qlSPSuDung/deleteSPSuDung";
	}
	@RequestMapping("/homeHopDong")
	public String homeHopDong() {
		return "redirect:/viewHopDong/";
	}
	
	@RequestMapping("/homeHoaDon")
	public String homeHoaDon() {
		return "redirect:/viewHoaDon/";
	}

}
