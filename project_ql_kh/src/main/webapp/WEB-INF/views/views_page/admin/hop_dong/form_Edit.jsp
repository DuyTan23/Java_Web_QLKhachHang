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
						<div class="detail__header-heading">Cập nhật hợp đồng mới</div>
					</div>

					<div class="detail__data">

						<form:form action="saveEditHopDong" modelAttribute="hopdong">
							<div class="detail__data-grid">

								<form:hidden path="idhopdong" />

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Chọn khách
										hàng</label>
									<form:select path="idkh" cssClass="detail__item">
										<form:options itemValue="idkh" items="${khachhang }"
											itemLabel="tenkh"></form:options>
									</form:select>
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Loại dịch vụ</label>
									<form:select path="iddichvu" cssClass="detail__item">
										<form:options itemValue="iddichvu" items="${dichvu }"
											itemLabel="tendichvu"></form:options>
									</form:select>
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Mô tả sản phẩm</label>
									<form:textarea path="motasanpham" cssClass="detail__item"
										placeholder="Nhập mô tả sản phẩm...." />
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Ngày ký</label>
									<form:input path="ngayky" cssClass="detail__item" />
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Ngày hết hạn</label>
									<form:input path="ngayhethan" cssClass="detail__item" />
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Giá trị</label>
									<form:input path="giatri" cssClass="detail__item" />
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Hiện trạng hóa đơn</label>
									<label class="detail__item"> 
										<input type="radio" name="option" value="true"  <c:if test="${hientrang}">checked</c:if>>Đã xuất
									</label > <label class="detail__item"> 
										<input type="radio" name="option" value="false" <c:if test="${!hientrang}">checked</c:if>> Chưa xuất
									</label>
								</div>

								<div class="detail__data-list">
									<label for="" class="detail__data-label">Ghi chú</label>
									<form:textarea path="ghichu" cssClass="detail__item"
										placeholder="Ghi chú hợp đồng...." />
								</div>

								<div class="detail__data-list">
									<div class="detail__data-list">
										<form:button  class="detail-btn">
											<i class="fa-solid fa-plus detail-icon"></i> Lưu
										</form:button>
									</div>
								</div>



							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>

		
	</div>
</body>
</html>