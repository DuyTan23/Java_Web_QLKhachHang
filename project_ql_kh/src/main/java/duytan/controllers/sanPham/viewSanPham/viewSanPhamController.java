package duytan.controllers.sanPham.viewSanPham;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.BoPhanQLDAO;
import duytan.dao.KhachHangDAO;
import duytan.dao.LoaiDichVuDAO;
import duytan.dao.SanPhamDAO;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/viewSanpham")
public class viewSanPhamController {
	
	@Autowired
	KhachHangDAO khachHangDAO;
	
	@Autowired
	BoPhanQLDAO boPhanQLDAO;
	
	@Autowired
	SanPhamDAO sanPhamDAO;
	@RequestMapping("/")
	public String index(@Nullable @RequestParam("page") Integer page,
						@Nullable @RequestParam("idbophan") Integer idbophan,
						@Nullable@RequestParam("option") String option,
						@Nullable@RequestParam("tensanpham") String tensanpham,
						@Nullable@RequestParam("kihieu") String kihieu,Model model) {
		// Lấy thông tin tài khoản khi login thành công
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		
		int pagesize = 2;
		page = page == null ? 1 : page;
		int count = sanPhamDAO.count();
		int pagecount = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		
		if(idbophan != null) {
			model.addAttribute("sanpham", sanPhamDAO.searchSP_bophan(idbophan));
			
		}
		else if (option != null) {
			model.addAttribute("sanpham", sanPhamDAO.searchSP_tinhTrang(option));
		}
		
		else if (tensanpham != null || kihieu != null) {
			model.addAttribute("sanpham", sanPhamDAO.searchSP_tenkh(tensanpham, kihieu));
		}

		
		
		else {
			model.addAttribute("sanpham", sanPhamDAO.getAll(page,pagesize));
		}
		
		
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("bophanql", boPhanQLDAO.getAll());
		
		
		return "user/san_pham/main/home";
	}
	
	@RequestMapping("/homeKhachHang")
	public String homeKhachHang() {
		return "redirect:/viewKhachHang/";
	}
	
	@RequestMapping("/homeSanPham")
	public String homeSanPham() {
		return "redirect:/viewSanpham/";
	}
	
	@RequestMapping("/timSPTheoTinhTrang")
	public String timSPTheoTinhTrang(@RequestParam("option") String option, ModelMap model) {
		model.addAttribute("option", option);
		return "redirect:/viewSanpham/";
	}
	
	@RequestMapping("/timSPTheoBoPhan")
	public String timSPTheoBoPhan(@RequestParam("idbophan") int idbophan, ModelMap model) {
		
		model.addAttribute("idbophan", idbophan);
		return "redirect:/viewSanpham/";
		
	}
	
	@RequestMapping("/timSPTheoTenKH")
	public String timSPTheoTenKH(@RequestParam("tensanpham") String tensanpham, @RequestParam("kihieu") String kihieu, ModelMap model) {
		
		model.addAttribute("tensanpham", tensanpham);
		model.addAttribute("kihieu", kihieu);
		
		return "redirect:/viewSanpham/";
	}
	
	@RequestMapping("/updateSanPham")
	public String updateSanPham(@RequestParam("id") int id, Model model) {
		model.addAttribute("id", id);
		//return "redirect:/qlSanPham/editSanPham";
		return "redirect:/qlSanPham/editSanPham";
	}
	
	@RequestMapping("/deleteSanPham")
	public String deleteSanPham(@RequestParam("id") int id, Model model) {
		model.addAttribute("id", id);
		return "redirect:/qlSanPham/deleteSanPham";
	}
	
	@RequestMapping("/addSanPham")
	public String addSanPham() {
		return "redirect:/qlSanPham/addSanPham";
	}
	
	@RequestMapping("/homeSPSuDung")
	public String homeSPSuDung() {
		return "redirect:/viewSPSuDung/";
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
