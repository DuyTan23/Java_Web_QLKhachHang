<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="app">
	<header class="header">
		<div class="grid">
			<div class="header__width">
				<div class="header__logo">
					<div class="header__logo-wrap">
						<a href="" class="header__logo-link"> <span
							class="header__logo-round">D</span> <span
							class="header__logo-text">DTSoft</span>
						</a>
					</div>
				</div>

				<div class="header__login">
					<div class="header__user">
						<img
							src="${pageContext.servletContext.contextPath}/${account.avatar}"
							alt="" class="header__user-img"> <span
							class="header__user-name">${pageContext.request.userPrincipal.name}</span>

						<ul class="header__user-list">
							<li class="header__user-item"><a href="">Thông tin tài
									khoản</a></li>

							<li class="header__user-item"><a
								href="<c:url value='/logout'/>"> Đăng xuất <i
									class="fa-solid fa-right-to-bracket header__user-icon"></i>
							</a></li>
						</ul>
					</div>
				</div>
			</div>


			<nav class="menu">
				<div class="grid">
					<div class="menu__list">
						<a class="menu__header"  href="homeKhachHang"><div class="menu__item" id = "menu__header-active-kh">
								<i class="fa-solid fa-user menu__item-icon"></i> Khách hàng
							</div> </a> 
						<a class="menu__header"   href="homeSanPham"><div class="menu__item" id = "menu__header-active-sp">
								<i class="fa-solid fa-briefcase menu__item-icon"></i> Sản phẩm
							</div></a>
						<a class="menu__header" href="homeSPSuDung"><div class="menu__item" id = "menu__header-active-spsd">
							<i class="fa-solid fa-user-tie menu__item-icon"></i> Sản phẩm
							đang sử dụng 
						</div></a>
						<a class="menu__header" href="homeHopDong"><div class="menu__item" id = "menu__header-active-hd">
							<i class="fa-solid fa-users menu__item-icon"></i> Hợp đồng
						</div></a>
						<a class="menu__header" href="homeHoaDon"><div class="menu__item" id = "menu__header-active-hdon">
							<i class="fa-solid fa-box menu__item-icon"></i> Hóa đơn
						</div></a>
						<div class="line"></div>
					</div>
				</div>
			</nav>
		</div>
	</header>