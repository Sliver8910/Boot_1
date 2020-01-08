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
<h2>Notice</h2>
	<table class="table ">
			<thead>
				<tr>
					<th class="th1">Title</th><th class="th1">Writer</th><th class="th1">Date</th><th class="th1">Hit</th>
				</tr>
			</thead> 
			<tbody> 
				<tr>
					<td id="title1">${notice.title}</td><td class="th1">${notice.writer}</td><td class="th1 date">${notice.regDate}</td><td class="th1 hit">${notice.hit}</td>
				</tr>
				<tr>
					<td colspan="4"><div class="con1">${notice.contents}</div></td>
				</tr>
			</tbody>
		</table>
		<div>
		<c:forEach items="${files}" var="file">
				<a href="./noticeFileDown?fnum=${file.fnum}">${file.oname}</a>
			</c:forEach>
		
		</div>

 

</body>
</html>