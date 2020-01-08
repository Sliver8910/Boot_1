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

<div class="container">
<form id="frm" action="./noticeList">
			<input type="hidden" value="1" id="curPage" name="curPage">
			<div class="form-group col-xs-2">
				<select name="kind" class="form-control ">
					<option id="kt" value="kt">Title</option>
					<option id="kw" value="kw">Writer</option>
					<option id="kc" value="kc">Contents</option>
				</select>
			</div>
			<div class="input-group col-xs-3">
				<input type="text" class="form-control" placeholder="Search"
					name="search" value="${pager.search}">
				<div class="input-group-btn">
					<button class="btn btn-primary" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
		

	<table class="table table-hover">
		<tr>
			<td>NUM</td>
			<td>Title</td>
			<td>Writer</td>
			<td>Date</td>
			<td>Hit</td>
		</tr>
		
		<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.num}</td>
			<td> <a href="noticeSelect?num=${vo.num}">${vo.title}</a></td>
			<td>${vo.writer}</td>
			<td>${vo.regDate}</td>
			<td>${vo.hit}</td>
		</tr>
		
		</c:forEach>
	</table>
	
	<div>
			<ul class="pagination">
				<c:if test="${pager.curBlock > 1}">
					<li><span id="${pager.startNum-1}" class="list"><</span></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><span id="${i}" class="list">${i}</span></li>
				</c:forEach>
				<c:if test="${pager.curBlock < pager.totalBlock}">
					<li><span id="${pager.lastNum+1}" class="list">></span></li>
				</c:if>
			</ul>

		</div>

			<a class="btn btn-primary" href="./noticeWrite">Write</a>

	</div>
	

	<script type="text/javascript">
		var kind = '${pager.kind}';
		if (kind == '') {
			kind = "kt";
		}
		$("#" + kind).prop("selected", true);
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	</script>
</body>


</html>