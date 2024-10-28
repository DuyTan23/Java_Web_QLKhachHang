<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="<c:url value="/resources/design/assets/fonts/fontawesome-free-6.4.2/fontawesome-free-6.4.2/css/all.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/design/assets/fonts/themify-icons/themify-icons.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/design/assets/css/base.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/design/assets/css/detail.css" />"
	rel="stylesheet">
<title>Document</title>
</head>
<body>
	
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
			</div>
		</header>

		<!-- container -->
		<div class="container">
			<div class="grid">
				<div class="detail">
					<div class="detail__header">
						<a href="javascript:history.back()" class="detail__back"> <i
							class="fa-solid fa-arrow-left detail__icon-back"></i>
						</a>
						<div class="detail__header-heading">Chi tiết khách hàng</div>
						<c:forEach items="${kh }" var="kh">
							<div class="detail__header-menu">

								<p class="detail__header-name">${kh[1] }</p>


								<div class="detail-btns">
									<a href="updateKhachHang?id=${kh[0] }" class="detail-btn"> <i
										class="fa-solid fa-refresh detail-icon"></i> Cập nhập
									</a> <a href="deleteKhachHang?id=${kh[0] }" onclick="return confirm('Bạn có muốn xóa không?')" class="detail-btn delete"> <i
										class="fa-solid fa-trash detail-icon"></i> Xóa
									</a>
								</div>
							</div>
						</c:forEach>
					</div>

					<div class="detail__data">
						<div class="detail__data-grid">
							<c:forEach items="${kh }" var="kh">
								<p class="detail__item">Tên Khách hàng</p>
								<p class="detail__item">${kh[1] }</p>

								<p class="detail__item">Địa chỉ khách hàng</p>
								<p class="detail__item">${kh[2] }</p>

								<p class="detail__item">Số điện thoại</p>
								<p class="detail__item">${kh[3] }</p>

								<p class="detail__item">Đơn vị trực thuộc</p>
								<p class="detail__item">${kh[6] }</p>

								<p class="detail__item">Bộ phận quản lý</p>
								<p class="detail__item">${kh[7] }</p>
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
		</div>

		
</body>
</html>