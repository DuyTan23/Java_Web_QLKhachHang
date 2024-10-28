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
<link href="<c:url value="/resources/design/assets/css/home.css" />"
	rel="stylesheet">
<title>Document</title>
</head>
<body>

	<!-- include phần header, menu, bộ lọc -->
	<jsp:include page="../../header/header.jsp"></jsp:include>





	<div class="container">
		<div class="grid">
			<div class="manage__item manage__item-active">
				<div class="grid__row">
					
					<jsp:include page="../sidebar/sidebar.jsp"></jsp:include>

					<div class="grid__column-9-5">
						<div class="manage__main-menu">
							<h2 class="manage__main-heading">Danh sách khách hàng</h2>
							<h2>${iddonvi }</h2>
							<div class="manage__main-btns">
								<a href="" class="manage__main-btn"> <i
									class="fa-solid fa-plus manage__main-icon"></i> Thêm
								</a> 
							</div>
						</div>

						<div class="manage__grid-client">
							<table class="manage__grid-table table-bordered">
								<tr class="manage__grid-tablerow">
									<th class="manage__grid-tableheader">Tên khách hàng</th>
									<th class="manage__grid-tableheader">Địa chỉ</th>
									<th class="manage__grid-tableheader">Số điện thoại</th>
									<th class="manage__grid-tableheader">Đơn vị</th>
								</tr>

								<c:forEach items="${khachhang }" var="kh">

									<tr class="manage__grid-tablerow">
										<td class="manage__grid-tabledata">${kh[1] }</td>
										<td class="manage__grid-tabledata">${kh[2] }</td>
										<td class="manage__grid-tabledata">${kh[3] }</td>
										<td class="manage__grid-tabledata">${kh[4] }</td>
										<td><a class="btn btn-detail"
											href="viewKhachHang?id=${kh[0] }">Chi tiết </a></td>
									</tr>

								</c:forEach>




							</table>
							<!-- Pagination -->
							<ul class="pagination home-product-pagination">
								<li class="pagination-item"><a href=""
									class="pagination-item-link"> <i
										class="pagination-item-icon fa-solid fa-chevron-left"></i>
								</a></li>

								<li class="pagination-item pagination-item--active"><a
									href="" class="pagination-item-link">1</a></li>

								<li class="pagination-item "><a href=""
									class="pagination-item-link">2</a></li>

								<li class="pagination-item"><a href=""
									class="pagination-item-link">3</a></li>

								<li class="pagination-item"><a href=""
									class="pagination-item-link">4</a></li>

								<li class="pagination-item"><a href=""
									class="pagination-item-link">5</a></li>

								<li class="pagination-item"><a href=""
									class="pagination-item-link">...</a></li>

								<li class="pagination-item"><a href=""
									class="pagination-item-link"> <i
										class="pagination-item-icon fa-solid fa-chevron-right"></i>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			</div>
			</div>
			
			<!-- include phần footer -->
			<jsp:include page="../../footer/footer.jsp"></jsp:include>
</body>
</html>