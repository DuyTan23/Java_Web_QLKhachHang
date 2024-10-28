<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<div class="grid__column-3-5">
	<div class="manage__item-tool">


		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text">Tra cứu tinh trạng xuất háo đơn </span>
			</div>
			<div class="manage__inputs">
				<form action="timHopDongTheotinhtang">
					<div class="radio-group">
						<h2>Chọn Tình trạng hóa đơn:</h2>

						<label> <input type="radio" name="option"
							value="true"> Đã xuất
						</label>
						 <label> <input type="radio" name="option"
							value="false"> Chưa xuất
						</label>
					</div>
					<input type="submit" class="manage__input" value="Tra Cứu">
				</form>
			</div>
		</div>
		
		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Tra cứu hợp đồng </span>
			</div>
			<div class="manage__inputs">
				<form action="traCuuChiTiet">
					<select name="iddichvu" class="manage__input">
						<option value="" selected = "selected">Chon loại dịch vụ</option>
						<c:forEach items = "${dichvu }" var = "dv">
							<option value="${dv.iddichvu }" >${dv.tendichvu  }</option>
						</c:forEach>
					</select>
					
					<input type="text" class="manage__input" name="tenkh" placeholder="Nhập tên Khách hàng"> 
					
					<input type="submit" class="manage__input" value="Tra Cứu">
				</form>
			</div>

		</div>
		
		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Hợp đồng đến hạn xuất hóa đơn </span>
			</div>
			<div class="manage__inputs">
				<form action="traCuuChiTietTg">
					
					<input type="date" class="manage__input" name="ngaybatdau"> 
					
					<input type="date" class="manage__input" name="ngayketthuc">
					
					<input type="submit" class="manage__input" value="Tra Cứu">
				</form>
			</div>

		</div>

	</div>

</div>