<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DTSoft</title>
    <link rel="icon" type="image/x-icon" href=<c:url value="/resources/assets1/img/logo/logostoreblue.png" />/>
        <link href="<c:url value="/resources/design/assets/css/base.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/design/assets/css/login.css" />" rel="stylesheet">
</head>
<body>
    <div class="login__signup">
        <div class="title">
            <div class="title-wrap">
                <a href="" class="title-link">
                    <span class="title-round">D</span>
                    <span class="title-text">DTSoft</span>
                </a>
            </div>
            <span class="title__desc">Quản lí khách hàng</span>
        </div>

        <form class="wrap" action="<c:url value='loginProcess' />" method='POST'>
            <div class="wrap__login">
                <input type="text" autocomplete="username" class="login__input" name='username' placeholder="Tên tài khoản hoặc email...">
            </div>
            
            <div class="wrap__login">
                <input type="password" autocomplete="password" class="login__input"name="password" placeholder="Mật khẩu">
            </div>

            <div class="wrap__login">
                <button type="submit" class="login__btn">Đăng nhập</button>
            </div>

            <div class="apart"></div>
            
            <div class="wrap__login">
                <a href="signup" class="login__btn-signup">Đăng ký</a>
            </div>
            <input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
        </form>
    </div>
    
    <h1>${id }</h1>
</body>
</html>