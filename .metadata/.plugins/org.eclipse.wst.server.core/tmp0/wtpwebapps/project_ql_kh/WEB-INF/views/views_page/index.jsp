<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="/resources/design/assets/css/base.css" />" rel="stylesheet">
<link href="<c:url value="/resources/design/assets/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/design/assets/fonts/fontawesome-free-6.4.2/fontawesome-free-6.4.2/css/all.css" />" rel="stylesheet">
<link href="<c:url value="/resources/design/assets/fonts/themify-icons/themify-icons.css" />" rel="stylesheet">
<title>DTSoft</title>
</head>
<body>
	<div class="app">

		<!-- header -->
		<header class="header">
			<div class="header__logo">
				<div class="header__logo-wrap">
					<a href="" class="header__logo-link"> <span
						class="header__logo-round">D</span> <span
						class="header__logo-text">DTSoft</span>
					</a>
				</div>
			</div>

			<div class="header__login">
				<button class="header__login-language">
					<svg class="header__login-language-icon"
						xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
						fill="currentColor" width="24" height="24">
                        <path
							d="M4.42676427,15 L7.19778729,15 C7.069206,14.209578 7,13.3700549 7,12.5 C7,11.6299451 7.069206,10.790422 7.19778729,10 L4.42676427,10 C4.15038555,10.7819473 4,11.6234114 4,12.5 C4,13.3765886 4.15038555,14.2180527 4.42676427,15 Z M4.86504659,16 C5.7403587,17.6558985 7.21741102,18.9446239 9.0050441,19.5750165 C8.30729857,18.6953657 7.74701714,17.4572396 7.39797964,16 L4.86504659,16 Z M18.5732357,15 C18.8496144,14.2180527 19,13.3765886 19,12.5 C19,11.6234114 18.8496144,10.7819473 18.5732357,10 L15.8022127,10 C15.930794,10.790422 16,11.6299451 16,12.5 C16,13.3700549 15.930794,14.209578 15.8022127,15 L18.5732357,15 Z M18.1349534,16 L15.6020204,16 C15.2529829,17.4572396 14.6927014,18.6953657 13.9949559,19.5750165 C15.782589,18.9446239 17.2596413,17.6558985 18.1349534,16 Z M8.21230689,15 L14.7876931,15 C14.9240019,14.2216581 15,13.3811544 15,12.5 C15,11.6188456 14.9240019,10.7783419 14.7876931,10 L8.21230689,10 C8.07599807,10.7783419 8,11.6188456 8,12.5 C8,13.3811544 8.07599807,14.2216581 8.21230689,15 Z M8.42865778,16 C9.05255412,18.3998027 10.270949,20 11.5,20 C12.729051,20 13.9474459,18.3998027 14.5713422,16 L8.42865778,16 Z M4.86504659,9 L7.39797964,9 C7.74701714,7.54276045 8.30729857,6.30463431 9.0050441,5.42498347 C7.21741102,6.05537614 5.7403587,7.34410146 4.86504659,9 Z M18.1349534,9 C17.2596413,7.34410146 15.782589,6.05537614 13.9949559,5.42498347 C14.6927014,6.30463431 15.2529829,7.54276045 15.6020204,9 L18.1349534,9 Z M8.42865778,9 L14.5713422,9 C13.9474459,6.60019727 12.729051,5 11.5,5 C10.270949,5 9.05255412,6.60019727 8.42865778,9 Z M11.5,21 C6.80557963,21 3,17.1944204 3,12.5 C3,7.80557963 6.80557963,4 11.5,4 C16.1944204,4 20,7.80557963 20,12.5 C20,17.1944204 16.1944204,21 11.5,21 Z"></path>
                      </svg>
				</button>

				<button class="header__login-btn">
					<a href="login" class="header__login-link">Đăng nhập</a>
				</button>
			</div>
		</header>

		<!-- container -->
		<div class="container">
			<div class="start">
				<span class="start__name"> Chương trình quản lý Thông tin
					khách hàng và Hợp đồng dịch vụ </span> <span class="start__sologant">
					Nhấn bắt đầu để vào trang chủ </span>
				<a href="login"><button class="start__btn">Bắt đầu</button></a>
			</div>

			<div class="introduce">
				<div class="grid__column-3">
					<div class="introduce__imgs">
						<div class="introduce__img"
							style="background-image: url(${pageContext.request.contextPath}/resources/design/assets/img/introduce/introduce2.png);"></div>
					</div>
				</div>

				<div class="grid__column-3-5">
					<div class="introduce__imgs">
						<div class="introduce__img"
							style="background-image: url(${pageContext.request.contextPath}/resources/design/assets/img/introduce/introducemain.png);"></div>
					</div>
				</div>

				<div class="grid__column-3">
					<div class="introduce__imgs">
						<div class="introduce__img"
							style="background-image: url(${pageContext.request.contextPath}/resources/design/assets/img/introduce/introduce1.png);"></div>
					</div>
				</div>
			</div>
		</div>

		<!-- footer -->
		<div class="footer"></div>
	</div>
</body>
</html>