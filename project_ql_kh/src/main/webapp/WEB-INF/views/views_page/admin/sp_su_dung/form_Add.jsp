<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<link href="<c:url value="/resources/design/assets/css/create.css" />"
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
		<div class="container">
			<div class="grid">
				<div class="detail">
					<div class="detail__header">
						<a href="javascript:history.back()" class="detail__back"> <i
							class="fa-solid fa-arrow-left detail__icon-back"></i>
						</a>
						<div class="detail__header-heading">Thêm sản phẩm đã sử dụng</div>
					</div>
					<div class="detail__data">

						<form action="saveAddSPSuDung">
							<div class="detail__data-grid">
								<div class="detail__data-list">
									<label for="" class="detail__data-label">Chọn Khách
										hàng</label> <select name="idkh" Class="detail__item">
										<option value="" selected="selected">Chon khách hàng</option>
										<c:forEach items="${khachhang }" var="kh">
											<option value="${kh.idkh }">${kh.tenkh }</option>
										</c:forEach>
									</select>
								</div>


								<div class="detail__data-list">
									<label for="" class="detail__data-label">Chọn sản phẩm</label>
									<select name="idsanpham" Class="detail__item">
										<option value="" selected="selected">Chon sản phẩm</option>
										<c:forEach items="${sanpham }" var="sp">
											<option value="${sp.idsanpham }">${sp.tensanpham  }</option>
										</c:forEach>
									</select>
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Ngày hoạt
										động</label> <input type="date" name="ngayhoatdong"
										Class="detail__item">
								</div>
								<div class="detail__data-list">
									<input class="detail-btn" type="submit" value="Lưu">
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
