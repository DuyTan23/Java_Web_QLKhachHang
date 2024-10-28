<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<div class="grid__column-3-5">
	<div class="manage__item-tool">


		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Hóa đơn theo tình trạng </span>
			</div>
			<div class="manage__inputs">
				<form action="timHoaDonTheotinhtang">
					<div class="radio-group">
						<h2>Tình trang thanh toán:</h2>

						<label> <input type="radio" name="option"
							value="true"> Đã thanh toán
						</label>
						 <label> <input type="radio" name="option"
							value="false"> Chưa thanh toán
						</label>
					</div>
					<input type="submit" class="manage__input" value="Tra Cứu">
				</form>
			</div>
		</div>
		
		
		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Tra cứu hóa đơn chưa thanh toán cho đến ngày </span>
			</div>
			<div class="manage__inputs" >
				<form action="traCuuHoaDonTg" style = "margin-top : 20px">
					
					<input type="date" class="manage__input" name="ngayhethan"> 
					
					<input type="submit" class="manage__input" value="Tra Cứu">
				</form>
			</div>

		</div>
	</div>

</div>