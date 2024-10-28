package duytan.controllers.hopDong.viewHopDong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.HopDongDAO;
import duytan.dao.KhachHangDAO;
import duytan.dao.LoaiDichVuDAO;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/viewHopDong")
public class ViewHopDongController {
	@Autowired
	HopDongDAO hopDongDAO;
	@Autowired
	KhachHangDAO khachHangDAO;
	@Autowired
	LoaiDichVuDAO loaiDichVuDAO;
	
	@RequestMapping("/")
	public String index(Model model,@Nullable @RequestParam("page") Integer page,
									@Nullable@RequestParam("option") String option,
									@Nullable@RequestParam("iddichvu") Integer iddichvu,
									@Nullable@RequestParam("tenkh") String tenkh,
									@Nullable@RequestParam("ngaybatdau") String ngaybatdau,
									@Nullable@RequestParam("ngayketthuc") String ngayketthuc) {
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		
		int pagesize = 2;
		page = page == null ? 1 : page;
		int count = hopDongDAO.count();
		int pagecount = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		
		if(option != null) {
			model.addAttribute("hd", hopDongDAO.serchHd(option));
		}
		else if (iddichvu != null || tenkh != null ) {
			if(iddichvu != null) {
				model.addAttribute("hd", hopDongDAO.serchHd1( iddichvu,tenkh));
			}
			else {
				model.addAttribute("hd", hopDongDAO.serchHd2( tenkh));
			}
			
		}
		else if(ngaybatdau != null && ngayketthuc != null) {
			model.addAttribute("hd", hopDongDAO.serchHd3(ngaybatdau, ngayketthuc));
		}
		
		else {
			
			model.addAttribute("hd", hopDongDAO.showAll(page, pagesize));
		}
		
		model.addAttribute("dichvu", loaiDichVuDAO.getAll());
		
		model.addAttribute("pagecount", pagecount);
		
		return "user/hop_dong/main/home";
		
	}
	
	@RequestMapping("/timHopDongTheotinhtang")
	public String timHopDongTheotinhtang(@RequestParam("option") String option, Model model) {
		
		model.addAttribute("option", option);
		
		return "redirect:/viewHopDong/";
	}
	
	@RequestMapping("/homeHopDong")
	public String homeHopDong() {
		return "redirect:/viewHopDong/";
	}
	
	@RequestMapping("/homeSanPham")
	public String homeSanPham() {
		return "redirect:/viewSanpham/";
	}
	
	@RequestMapping("/homeSPSuDung")
	public String homeSPSuDung() {
		return "redirect:/viewSPSuDung/";
	}
	
	@RequestMapping("/homeKhachHang")
	public String homeKhachHang() {
		return "redirect:/viewKhachHang/";
	}
	
	@RequestMapping("/traCuuChiTiet")
	public String traCuuChiTiet(@Nullable@RequestParam("iddichvu") Integer iddichvu, 
			@Nullable@RequestParam("tenkh") String tenkh, Model model) {
		
		
		if(iddichvu != null) {
			model.addAttribute("iddichvu", iddichvu);
			model.addAttribute("tenkh", tenkh);
			
		}
		else {
			model.addAttribute("tenkh", tenkh);
			
		}
		return "redirect:/viewHopDong/";
		
	}
	
	@RequestMapping("/traCuuChiTietTg")
	public String traCuuChiTietTg(@Nullable@RequestParam("ngaybatdau") String ngaybatdau, @Nullable@RequestParam("ngayketthuc") String ngayketthuc,Model model) {
		
		model.addAttribute("ngaybatdau", ngaybatdau);
		
		model.addAttribute("ngayketthuc", ngayketthuc);
		
		return "redirect:/viewHopDong/";
	}
	
	@RequestMapping("/viewHopDong")
	public String viewHopDong(@RequestParam("id") int id, Model model) {
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		
		model.addAttribute("hd", hopDongDAO.getByid(id));
		
		Object object = hopDongDAO.getByid(id);
		
		return "user/hop_dong/main/view_hop_dong";
		
	}
	
	@RequestMapping("/addHopDong")
	public String addHopDong() {
		
		return "redirect:/qlHopDong/addHopDong";
	}
	
	@RequestMapping("/updateHopDong")
	public String updateHopDong(@RequestParam("id") int id, Model model) {
		
		model.addAttribute("id", id);
		
		return "redirect:/qlHopDong/updateHopDong";
	}
	
	@RequestMapping("/deleteHopDong")
	public String deleteHopDong(@RequestParam("id") int id, Model model) {
		
		model.addAttribute("id", id);
		
		return "redirect:/qlHopDong/deleteHopDong";
	}
	
	@RequestMapping("/homeHoaDon")
	public String homeHoaDon() {
		return "redirect:/viewHoaDon/";
	}



}
