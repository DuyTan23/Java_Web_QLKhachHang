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
						<div class="detail__header-heading">Cập nhật hóa đơn</div>
					</div>

					<div class="detail__data">

						<form:form action="saveEditHoaDon" modelAttribute="hoadon">
							<div class="detail__data-grid">

								<form:hidden path="idhoadon" />

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Hợp đồng chưa tạo hóa đơn</label>
									<form:select path="idhopdong" cssClass="detail__item">
										<form:options itemValue="idhopdong" items="${hopdong }"
											itemLabel="displayLabel"></form:options>
									</form:select>
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Chọn sản phẩm</label>
									<form:select path="idsanpham" cssClass="detail__item">
										<form:options itemValue="idsanpham" items="${sanpham }"
											itemLabel="tensanpham"></form:options>
									</form:select>
								</div>
								
								<div class="detail__data-list">
									<label for="" class="detail__data-label">Chọn bộ phận</label>
									<form:select path="idbophan" cssClass="detail__item">
										<form:options itemValue="idbophan" items="${bophan }"
											itemLabel="tenbophan"></form:options>
									</form:select>
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Ngày xuất</label>
									<form:input path="ngayxuat" cssClass="detail__item" />
								</div>

								

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Hiện trạng thanh toán</label>
									<label class="detail__item"> <input type="radio" name="option" value="true" <c:if test="${hientrang}">checked</c:if>> Đã thanh toán</label > 
									<label class="detail__item"> <input type="radio" name="option"value="false" <c:if test="${!hientrang}">checked</c:if>> Chưa thanh toán</label>
								</div>
								
								<div class="detail__data-list">
									<label for="" class="detail__data-label">Ngày thanh toán</label>
									<form:input path="ngaythanhtoan" cssClass="detail__item" />
								</div>

								<div class="detail__data-list">
									<div class="detail__data-list">
										<form:button  class="detail-btn">
											<i class="fa-solid fa-plus detail-icon"></i> Thêm
										</form:button>
									</div>
								</div>



							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

		<!-- Footter -->
		
	</div>
</body>
</html>