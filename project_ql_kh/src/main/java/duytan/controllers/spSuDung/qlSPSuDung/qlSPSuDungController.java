package duytan.controllers.spSuDung.qlSPSuDung;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.KhachHangDAO;
import duytan.dao.SPSuDungDAO;
import duytan.dao.SanPhamDAO;
import duytan.entities.SPSuDung;
import duytan.entities.account.AccountDetails;

@Controller
@RequestMapping("/qlSPSuDung")
public class qlSPSuDungController {

	@Autowired
	KhachHangDAO khachHangDAO;

	@Autowired
	SanPhamDAO sanPhamDAO;

	@Autowired
	SPSuDungDAO spSuDungDAO;

	@RequestMapping("/addSPSuDung")
	public String addsp(Model model) {

		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("account", account);
		model.addAttribute("khachhang", khachHangDAO.getAll());
		model.addAttribute("sanpham", sanPhamDAO.getAllNotspsd());
		return "admin/sp_su_dung/form_Add";
	}

	@RequestMapping("/saveAddSPSuDung")
	public String saveAddSPSuDung(Model model, @Nullable @RequestParam("idkh") int idkh,
			@Nullable @RequestParam("idsanpham") int idsanpham,
			@Nullable @RequestParam("ngayhoatdong") String ngayhoatdong) {

		// chuyển kiểu string thành date

		Date date1 = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date1 = formatter.parse(ngayhoatdong);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		spSuDungDAO.insert(new SPSuDung(idkh, idsanpham, ngayhoatdong));

		return "redirect:/viewSPSuDung/";
	}

	@RequestMapping("/deleteSPSuDung")
	public String deleteSPSuDung(Model model, @RequestParam("idkh") int idkh,
			 @RequestParam("idsanpham") int idsanpham) {
		
		spSuDungDAO.delete(idkh, idsanpham);

		return "redirect:/viewSPSuDung/";
	}
}
