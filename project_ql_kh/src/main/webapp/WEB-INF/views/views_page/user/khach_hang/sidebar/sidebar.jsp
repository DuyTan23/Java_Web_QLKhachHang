<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<div class="grid__column-3-5">
	<div class="manage__item-tool">


		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Khách hàng hết hạn hợp đồng </span>
			</div>
			<div class="manage__inputs">
				<form action="hetHanBaoTri">

					<input type="date" class="manage__input" name="ngayhethan">

					<select name="iddichvu" class="manage__input" id="iddichvu">

						<option value="0" selected>Chọn loại dịch vụ</option>

						<c:forEach items="${loaidvu }" var="dv">
							<option value="${dv.iddichvu }">${ dv.tendichvu}</option>

						</c:forEach>

					</select> <input type="submit" class="manage__input" value="Tra Cứu">

				</form>
			</div>
		</div>


		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Bộ lọc tra cứu khách hàng </span>
			</div>
			<div class="manage__inputs">
				<form action="timKhachHang">
					<input type="text" class="manage__input" name = "tenkh"
						placeholder="Nhập tên"> 
					<input type="text"
						class="manage__input" name = "diachikh" placeholder="Nhập địa chỉ"> 
					<input
						type="text" class="manage__input" name = "sodtkh"
						placeholder="Nhập số điện thoại"> 
					<input type="submit"
						class="manage__input" value="Tra Cứu">
				</form>
			</div>

		</div>
	</div>
</div>