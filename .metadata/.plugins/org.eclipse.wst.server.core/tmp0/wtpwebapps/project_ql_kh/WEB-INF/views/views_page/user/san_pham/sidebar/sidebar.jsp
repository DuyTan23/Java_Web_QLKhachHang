<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<div class="grid__column-3-5">
	<div class="manage__item-tool">


		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Sản phẩm theo tình trạng </span>
			</div>
			<div class="manage__inputs">
				<form action="timSPTheoTinhTrang">
					<div class="radio-group">
						<h2>Chọn Tình trạng sản phẩm:</h2>

						<label> <input type="radio" name="option" value="Hoàn thành">
							Hoàn thành
						</label> <label> <input type="radio" name="option" value="Chưa hoàn thành">
							Chưa hoàn thành
					</div>
					</label> <input type="submit" class="manage__input" value="Tra Cứu">
				</form>
			</div>
		</div>
		
		
		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Sản phẩm theo bộ phận quản lý </span>
			</div>
			<div class="manage__inputs">
				<form action="timSPTheoBoPhan">


					<select name=idbophan class="manage__input" id="idbophan">

						<option value="0" selected>Chọn bộ phận</option>

						<c:forEach items="${bophanql }" var="bp">
							<option value="${bp.idbophan }" >${ bp.tenbophan}</option>

						</c:forEach>

					</select> <input type="submit" class="manage__input" value="Tra Cứu">

				</form>
			</div>
		</div>
		


		<div class="manage">
			<div class="manage__heading">
				<span class="manage__text"> Tra cứu theo tên và kí hiệu </span>
			</div>
			<div class="manage__inputs">
				<form action=" ">
					<input type="text" class="manage__input" name="tensanpham"
						placeholder="Nhập tên sản phẩm"> 
					<input type="text" class="manage__input" name="kihieu"
						placeholder="kí hiệu"> <input type="submit"
						class="manage__input" value="Tra Cứu">
				</form>
			</div>

		</div>
	</div>
</div>