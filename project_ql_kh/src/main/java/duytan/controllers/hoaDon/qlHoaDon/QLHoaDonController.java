package duytan.controllers.hoaDon.qlHoaDon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.BoPhanQLDAO;
import duytan.dao.HoaDonDAO;
import duytan.dao.HopDongDAO;
import duytan.dao.SanPhamDAO;
import duytan.entities.HoaDon;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/qlHoaDon")
public class QLHoaDonController {

	@Autowired
	HoaDonDAO hoaDonDAO;
	@Autowired
	HopDongDAO hopDongDAO;
	@Autowired
	SanPhamDAO sanPhamDAO;

	@Autowired
	BoPhanQLDAO boPhanQLDAO;

	@RequestMapping("/addHoaDon")
	public String addHoaDon(Model model) {

		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);

		model.addAttribute("hoadon", new HoaDon());

		model.addAttribute("hopdong", hopDongDAO.getAllNotHd());

		model.addAttribute("sanpham", sanPhamDAO.getAllNotHd());

		model.addAttribute("bophan", boPhanQLDAO.getAll());
		return "admin/hoa_don/form_Add";
	}

	@RequestMapping("/saveAddHoaDon")
	public String saveAddHoaDon(@ModelAttribute("hoadon") HoaDon hoaDon, @RequestParam("option") String option,
			Model model) {
		boolean b = Boolean.parseBoolean(option);

		hoaDon.setHientrang(b);

		hoaDonDAO.insert(hoaDon);

		return "redirect:/viewHoaDon/";
	}

	@RequestMapping("/editHoaDon")
	public String editHoaDon(@RequestParam("id") int id, Model model) {

		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);

		HoaDon hoaDon = hoaDonDAO.getById(id);

		boolean b = hoaDon.isHientrang();

		model.addAttribute("hoadon", hoaDon);

		model.addAttribute("hientrang", b);

		model.addAttribute("hopdong", hopDongDAO.getAllNotHdId(hoaDon.getIdhopdong()));

		model.addAttribute("sanpham", sanPhamDAO.getAllNotHdId(hoaDon.getIdsanpham()));

		model.addAttribute("bophan", boPhanQLDAO.getAll());

		return "admin/hoa_don/form_Edit";
	}

	@RequestMapping("/saveEditHoaDon")
	public String saveEditHoaDon(@ModelAttribute("hoadon") HoaDon hoaDon, @RequestParam("option") String option,
			Model model) {
		
		boolean b = Boolean.parseBoolean(option);

		hoaDon.setHientrang(b);

		hoaDonDAO.update(hoaDon);

		return "redirect:/viewHoaDon/";
	}
	
	@RequestMapping("/deleteHoaDon")
	public String deleteHoaDon(@RequestParam("id") int id) {
		
		hoaDonDAO.delete(id);
		
		return "redirect:/viewHoaDon/";
		
		
	}

}
