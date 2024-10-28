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
<title>DTSoft - Trang chủ</title>
<style type="text/css">

#menu__header-active-hd {
	opacity: 1;
	
	border-color: rgb(40, 123, 255);
}</style>
</head>
<body>

	<!-- include phần header, menu, bộ lọc -->
	<jsp:include page="../../header/header.jsp"></jsp:include>
	<!-- container -->
	<div class="container">

		<div class="grid">
			<div class="manage__item manage__item-active">
				<div class="grid__row">

					<jsp:include page="../sidebar/sidebar.jsp"></jsp:include>

					<div class="grid__column-9-5">
						<div class="manage__main-menu">
							<h2 class="manage__main-heading">Hợp đồng</h2>

							<div class="manage__main-btns">
								<a href="addHopDong" class="manage__main-btn"> <i
									class="fa-solid fa-plus manage__main-icon"></i> Thêm
								</a>
							</div>
						</div>
						<div class="manage__grid-client">
							<table class="manage__grid-table table-bordered">
								<tr class="manage__grid-tablerow">
									<th class="manage__grid-tableheader">Tên khách hàng</th>
									<th class="manage__grid-tableheader">Dịch vụ</th>
									<th class="manage__grid-tableheader">Ngày kí</th>
									<th class="manage__grid-tableheader">Ngày hết hạn</th>
									<th class="manage__grid-tableheader">hiện trạng háo đơn</th>
								</tr>
								<c:forEach items="${hd }" var="hd">

									<tr class="manage__grid-tablerow">

										<td class="manage__grid-tabledata">${hd[1] }</td>
										<td class="manage__grid-tabledata">${hd[2]}</td>
										<td class="manage__grid-tabledata">${hd[3] }</td>
										<td class="manage__grid-tabledata">${hd[4] }</td>

										<td class="manage__grid-tabledata">
											<c:choose>
												<c:when test="${hd[5] }">Đã Xuất</c:when>
												<c:otherwise>Chưa xuất</c:otherwise>
											</c:choose>
										</td>
										
										<td><a class="btn btn-detail"
											href="viewHopDong?id=${hd[0] }">Chi tiết </a></td>
										
								</c:forEach>
							</table>
							<!-- Pagination -->
							<ul class="pagination home-product-pagination">
								<li class="pagination-item"><a href=""
									class="pagination-item-link"> <i
										class="pagination-item-icon fa-solid fa-chevron-left"></i>
								</a></li>
								<c:forEach var="i" begin="1" end="${pagecount}">
									<li class="pagination-item pagination-item--active"><a
										href="?page=${i}" class="pagination-item-link">${i}</a></li>

								</c:forEach>

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

</body>
<!-- include phần footer -->
<jsp:include page="../../footer/footer.jsp"></jsp:include>

</body>
</html>