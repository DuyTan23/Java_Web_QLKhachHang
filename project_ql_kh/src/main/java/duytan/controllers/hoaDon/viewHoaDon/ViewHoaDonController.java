package duytan.controllers.hoaDon.viewHoaDon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.HoaDonDAO;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/viewHoaDon")
public class ViewHoaDonController {
	@Autowired
	HoaDonDAO hoaDonDAO;

	@RequestMapping("/")
	public String index(Model model,@Nullable @RequestParam("page") Integer page, @Nullable @RequestParam("option") String option,
			@Nullable @RequestParam("ngayhethan") String ngayhethan) {

		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		
		int pagesize = 2;
		page = page == null ? 1 : page;
		int count = hoaDonDAO.count();
		int pagecount = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;

		if (option != null) {
			model.addAttribute("hoadon", hoaDonDAO.searchThanhToan(option));
		}

		else if (ngayhethan != null) {
			model.addAttribute("hoadon", hoaDonDAO.searchThanhToanngay(ngayhethan));
		}

		else {
			model.addAttribute("hoadon", hoaDonDAO.showAll(page, pagesize));
		}
		
		model.addAttribute("pagecount", pagecount);

		return "user/hoa_don/main/home";

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

	@RequestMapping("/homeHoaDon")
	public String homeHoaDon() {
		return "redirect:/viewHoaDon/";
	}

	@RequestMapping("/timHoaDonTheotinhtang")
	public String timHoaDonTheotinhtang(@RequestParam("option") String option, Model model) {

		model.addAttribute("option", option);

		return "redirect:/viewHoaDon/";

	}

	@RequestMapping("/traCuuHoaDonTg")

	public String traCuuHoaDonTg(@Nullable @RequestParam("ngayhethan") String ngayhethan, Model model) {

		model.addAttribute("ngayhethan", ngayhethan);

		return "redirect:/viewHoaDon/";

	}

	@RequestMapping("/addHoaDon")

	public String addHoaDon() {

		return "redirect:/qlHoaDon/addHoaDon";

	}

	@RequestMapping("/editHoadon")
	public String editHoadon(@RequestParam("id") int id, Model model) {

		model.addAttribute("id", id);

		return "redirect:/qlHoaDon/editHoaDon";

	}

	@RequestMapping("/deleteHoaDon")
	public String deleteHoaDon(@RequestParam("id") int id, Model model) {

		model.addAttribute("id", id);

		return "redirect:/qlHoaDon/deleteHoaDon";

	}

}
