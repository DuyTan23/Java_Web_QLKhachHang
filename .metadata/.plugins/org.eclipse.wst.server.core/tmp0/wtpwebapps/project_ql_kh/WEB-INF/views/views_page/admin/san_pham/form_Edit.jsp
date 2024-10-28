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
						<div class="detail__header-heading">Cập nhật sản phẩm</div>
					</div>

					<div class="detail__data">

						<form:form action="saveEditSanPham" modelAttribute="sanpham">
							<div class="detail__data-grid">

								<form:hidden path="idsanpham" />

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Tên sản phẩm</label>
									<form:input path="tensanpham" type="text"
										cssClass="detail__item" placeholder="Nhập tên...." />
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Ki hiệu</label>
									<form:input path="kihieu" type="text" cssClass="detail__item"
										placeholder="Nhập kí hiệu...." />

								</div>

							<div class="detail__data-list">
									<label for="" class="detail__data-label">Tình trạng:</label>
									<label class="detail__item"><form:radiobutton path="tinhtrang" value="Hoàn thành"   Label="Hoàn thành" />Hoàn thành</label>
									<label class="detail__item"><form:radiobutton path="tinhtrang" value="Chưa hoàn thành" Label="Chưa hoàn thành" />Chưa hoàn thành</label>
								</div>


								<div class="detail__data-list">
									<label for="" class="detail__data-label">Bộ phận quản
										lý:</label>
									<form:select path="idbophan" cssClass="detail__item">
										<form:options itemValue="idbophan" items="${bophanql }" 
											itemLabel="tenbophan"></form:options>
									</form:select>
								</div>

								<div class="detail__data-list">
									<div class="detail__data-list">
										<form:button href="" class="detail-btn">
											<i class="fa-solid fa-plus detail-icon"></i> Cập nhật
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
</body>
</html>