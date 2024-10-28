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

		<!-- container -->
		<div class="container">
			<div class="grid">
				<div class="detail">
					<div class="detail__header">
						<a href="javascript:history.back()" class="detail__back"> <i
							class="fa-solid fa-arrow-left detail__icon-back"></i>
						</a>
						<div class="detail__header-heading">Cập nhật khách hàng</div>
					</div>

					<div class="detail__data">

						<form:form action="saveEditKhachHang" modelAttribute="khachhang">
							<div class="detail__data-grid">

								<form:hidden path="idkh" />

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Tên Khách hàng</label>
									<form:input path="tenkh" type="text" cssClass="detail__item"
										placeholder="Nhập tên...." />
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Địa chỉ khách
										hàng</label>
									<form:input path="diachikh" type="text" cssClass="detail__item"
										placeholder="Nhập địa chỉ...." />
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Số điện thoại:</label>
									<form:input path="sodtkh" type="text" cssClass="detail__item"
										placeholder="Nhập số điện thoại...." />
								</div>

								<form:hidden path="username" />

								<form:hidden path="password" />

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Đơn vị:</label>
									<form:select path="iddonvi" cssClass="detail__item">
										<form:options itemValue="iddonvi" items="${loaidonvi }"
											itemLabel="tendonvi"></form:options>
									</form:select>
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Bộ phận quản lý:</label>
									<form:select path="idbophan" cssClass="detail__item">
										<form:options itemValue="idbophan" items="${bophanql }"
											itemLabel="tenbophan"></form:options>
									</form:select>
								</div>

								<div class="detail__data-list">
									<div class="detail__data-list">
										<form:button href="" class="detail-btn"> <i
											class="fa-solid fa-plus detail-icon"></i> Cập nhật
										</form:button>
									</div>
								</div>

							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>

</body>
</html>