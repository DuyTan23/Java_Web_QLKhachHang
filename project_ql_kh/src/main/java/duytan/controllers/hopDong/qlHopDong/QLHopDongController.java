package duytan.controllers.hopDong.qlHopDong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.HopDongDAO;
import duytan.dao.KhachHangDAO;
import duytan.dao.LoaiDichVuDAO;
import duytan.entities.HopDong;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/qlHopDong")
public class QLHopDongController {

	@Autowired
	KhachHangDAO khachHangDAO;

	@Autowired
	LoaiDichVuDAO loaiDichVuDAO;

	@Autowired
	HopDongDAO hopDongDAO;

	@RequestMapping("/addHopDong")
	public String addHopDong(Model model) {
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("hopdong", new HopDong());
		model.addAttribute("khachhang", khachHangDAO.getAll());
		model.addAttribute("dichvu", loaiDichVuDAO.getAll());
		return "admin/hop_dong/form_Add";
	}

	@RequestMapping("/saveAddHopDong")
	public String saveAddHopDong(@ModelAttribute("hopdong") HopDong hopDong, @RequestParam("option") String option,
			Model model) {

		boolean b = Boolean.parseBoolean(option);

		hopDong.setHientrangdon(b);

		hopDongDAO.insert(hopDong);

		return "redirect:/viewHopDong/";

	}

	@RequestMapping("/updateHopDong")
	public String updateHopDong(@RequestParam("id") int id, Model model) {
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("hopdong", hopDongDAO.getById2(id));
		boolean b = hopDongDAO.getById2(id).isHientrangdon();
		model.addAttribute("hientrang", b);
		model.addAttribute("khachhang", khachHangDAO.getAll());
		model.addAttribute("dichvu", loaiDichVuDAO.getAll());
		return "admin/hop_dong/form_Edit";
	}

	@RequestMapping("/saveEditHopDong")
	public String saveEditHopDong(@ModelAttribute("hopdong") HopDong hopDong, @RequestParam("option") String option,
			Model model) {
		boolean b = Boolean.parseBoolean(option);
		hopDong.setHientrangdon(b);
		hopDongDAO.update(hopDong);

		return "redirect:/viewHopDong/";
	}
	
	@RequestMapping("/deleteHopDong")
	public String deleteHopDong(@RequestParam("id") int id, Model model) {
		hopDongDAO.delete(id);
		return "redirect:/viewHopDong/";
	}

}
