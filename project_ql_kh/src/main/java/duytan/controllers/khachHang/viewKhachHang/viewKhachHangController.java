package duytan.controllers.khachHang.viewKhachHang;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.BoPhanQLDAO;
import duytan.dao.KhachHangDAO;
import duytan.dao.LoaiDichVuDAO;
import duytan.dao.LoaiDonViDAO;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/viewKhachHang")
public class viewKhachHangController {

	@Autowired
	KhachHangDAO khachHangDAO;

	@Autowired
	LoaiDonViDAO loaiDonViDAO;

	@Autowired
	BoPhanQLDAO bopPhanQLDAO;

	@Autowired
	LoaiDichVuDAO loaiDichVuDAO;

	@RequestMapping("/")
	public String index(@Nullable @RequestParam("page") Integer page, Model model) {
		// Lấy thông tin tài khoản khi login thành công
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		int pagesize = 2;
		page = page == null ? 1 : page;
		int count = khachHangDAO.count();
		int pagecount = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		model.addAttribute("khachhang", khachHangDAO.showALL(page, pagesize));
		model.addAttribute("loaidvu", loaiDichVuDAO.getAll());
		model.addAttribute("pagecount", pagecount);
		return "user/khach_hang/main/home";
	}

	@RequestMapping("/homeKhachHang")
	public String homeKhachHang() {
		return "redirect:/viewKhachHang/";
	}

	@RequestMapping("/viewKhachHang")
	public String viewKhachHang(@RequestParam("id") int id, Model model) {
		// Lấy thông tin tài khoản khi login thành công
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("id", id);
		model.addAttribute("khachHang", khachHangDAO.getById(id));
		model.addAttribute("kh", khachHangDAO.getById2(id));
		return "user/khach_hang/main/view_khach_hang";
	}

	@RequestMapping("/deleteKhachHang")
	public String deleteKhachHang(@RequestParam("id") int id, Model model) {
		model.addAttribute("id", id);
		return "redirect:/qlKhachHang/deleteKhachHang";
	}

	@RequestMapping("/updateKhachHang")
	public String updateKhachHang(@RequestParam("id") int id, Model model) {
		model.addAttribute("id", id);
		return "redirect:/qlKhachHang/editKhachHang";
	}

	@RequestMapping("/addKhachHang")
	public String addKhachHang() {

		return "redirect:/qlKhachHang/addKhachHang";
	}

	@RequestMapping("/hetHanBaoTri")
	public String hetHanBaoTri(@Nullable @RequestParam("ngayhethan") String date,
			@Nullable @RequestParam("iddichvu") int iddichvu, Model model) {

		// Lấy thông tin tài khoản khi login thành công
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);

		model.addAttribute("ngayhethan", date);

		model.addAttribute("khachhang", khachHangDAO.khachHangHetHanBaoTri(date, iddichvu));

		model.addAttribute("iddichvu", iddichvu);

		model.addAttribute("loaidvu", loaiDichVuDAO.getAll());

		return "user/khach_hang/main/hopdong_hethan";

	}

	@RequestMapping("/timKhachHang")
	public String timKhachHang(@RequestParam("tenkh") String tenkh, @RequestParam("diachikh") String diachikh,
			@RequestParam("sodtkh") String sodtkh, Model model) {

		model.addAttribute("khachhang", khachHangDAO.search_kh(tenkh, diachikh, sodtkh));

		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("loaidvu", loaiDichVuDAO.getAll());

		model.addAttribute("tt", tenkh + diachikh + sodtkh);
		return "user/khach_hang/main/tim_khachhang";
	}

	@RequestMapping("/homeSanPham")
	public String homeSanPham() {
		return "redirect:/viewSanpham/";
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
