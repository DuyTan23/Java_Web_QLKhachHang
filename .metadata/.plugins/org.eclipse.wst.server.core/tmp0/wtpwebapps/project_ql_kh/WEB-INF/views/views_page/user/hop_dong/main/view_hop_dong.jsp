<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
										Khoảng</a></li>

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
						<div class="detail__header-heading">Chi tiết Hợp đồng</div>

						<div class="detail__header-menu">
							<div class="detail-btns">
								<a href="updateHopDong?id=${hd[0] }" class="detail-btn"> <i
									class="fa-solid fa-refresh detail-icon"></i> Cập nhập
								</a> 
								<a href="deleteHopDong?id=${hd[0] }"
									onclick="return confirm('Bạn có muốn xóa không?')"
									class="detail-btn delete"> <i
									class="fa-solid fa-trash detail-icon"></i> Xóa
								</a>
							</div>
						</div>

					</div>

					<div class="detail__data">
						<div class="detail__data-grid">
							<p class="detail__item">Tên khách hàng</p>
							<p class="detail__item">${hd[1] }</p>

							<p class="detail__item">Loại dịch vụ</p>
							<p class="detail__item">${hd[2] }</p>

							<p class="detail__item">Mô tả sản phẩm</p>
							<p class="detail__item">${hd[3] }</p>

							<p class="detail__item">Ngày ký hợp đồng</p>
							<p class="detail__item">${hd[4] }</p>

							<p class="detail__item">ngày hết hạn</p>
							<p class="detail__item">${hd[5] }</p>

							<p class="detail__item">Giá trị</p>
							<p class="detail__item">
								<fmt:formatNumber value="${hd[6] }" type="number"
									maxFractionDigits="0" minFractionDigits="0" />
							</p>

							<p class="detail__item">Hiện trạng hóa đơn</p>
							<p class="detail__item">
								<c:choose>
									<c:when test="${hd[7] }">Đã Xuất</c:when>
									<c:otherwise>Chưa xuất</c:otherwise>
								</c:choose>
							</p>




						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	
</body>
</html>