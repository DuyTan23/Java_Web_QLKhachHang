package duytan.controllers;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import duytan.dao.account.AccountDAO2;
import duytan.dao.account.AccountRoleDAO;
import duytan.dao.account.RoleDAO;
import duytan.entities.Role;
import duytan.entities.account.Account;
import duytan.entities.account.AccountDetails;
import duytan.entities.account.AccountRole;

@Controller
public class HomeController {

	@Autowired

	AccountDAO2 accountDAO2;

	@Autowired

	RoleDAO roleDAO;
	
	@Autowired
	AccountRoleDAO accountRoleDAO;

	@RequestMapping(value = { "/", "/home", "/trang-chu" }, method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(@Nullable @RequestParam(value = "error") String error, Model model) {
		if (error != null) {
			model.addAttribute("msg", "Đăng nhập sai!");
		}

		return "login/login";
	}

	@RequestMapping("/signupAccount")
	public String String(@RequestParam("username") String username,
						@RequestParam("password") String password,
						@RequestParam("fullname") String fullname, Model model) {
		
		String string1 = BCrypt.hashpw(password, BCrypt.gensalt(12));
		
		Account account = new Account(username, string1, fullname, "resources/images/avatar.webp");
		
		accountDAO2.insert(account);
		
		List<Account> accounts = accountDAO2.getById(username);
		
		List<Role> roles = roleDAO.getAll();
		
		AccountRole accountRole = new AccountRole(accounts.get(0), roles.get(1));
		
		accountRoleDAO.insert(accountRole);
		
		return "redirect:/login";
	}

	@RequestMapping("/signup")
	public String signup() {
		return "login/signup";
	}

	@RequestMapping(value = "/checkrole")
	public String checkRole(Model model) {
		// lấy thông tin tài khoản
		AccountDetails account = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// duyệt role để kiểm tra và điều hướng
		for (var g : account.getAuthorities()) {
			if (g.getAuthority().equals("ROLE_ADMIN")) {
				return "redirect:/admin/";
			}
			if (g.getAuthority().equals("ROLE_USER")) {
				return "redirect:/user/";
			}
		}
		model.addAttribute("msg", "Bạn không có quyền vào trang này!!!");
		return "login/403";
	}

	@RequestMapping("/logoutSuccess")
	public String logout(Model model) {
		model.addAttribute("msg", "Logout thành công!!!");
		return "index";
	}

	@RequestMapping("/403")
	public String accessDenied(Model model) {
		model.addAttribute("msg", "BẠN KHÔNG CÓ QUYỀN TRUY CẬP VÀO TRANG NÀY");
		return "login/403";
	}
}
