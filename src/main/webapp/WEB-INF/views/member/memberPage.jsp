<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/boot.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
<h1>Member Mypage</h1>

<h2>ID : ${member.id}</h2>
<h2>Name : ${member.name}</h2>
<h2>Email : ${member.email}</h2>
<h2>photo</h2>
<img alt="" src="..	/upload/${fname}">
<a href="./memberFileDown?fnum=${fnum}">FileDown</a>
</body>
</html>