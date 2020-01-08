<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/boot.jsp"></c:import>
<!-- include summernote css/js -->
<meta charset="UTF-8">
<title>notice write</title>
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>

<div class="container">
  <h2>Notice Write form</h2>
  <form:form modelAttribute="noticeVO" id="frm" enctype="multipart/form-data" action="./noticeWrite" method="post">
    <div class="form-group">
      <label for="email">Title</label>
      <form:input path="title" type="text" class="form-control" id="title" name="title"/>
      <form:errors path="title" />
    </div>
    <div class="form-group">
      <label for="writer">Writer:</label>
      <form:input path="writer" type="text" class="form-control" id="writer" value="${member.id}" name="writer"/>
       <form:errors path="writer" />
    </div>
   <div class="form-group">
		      <label for="contents">Contents:</label>
			<form:textarea cssClass="form-control" path="contents" id="contents"/>
			<form:errors cssClass="" path="contents"></form:errors>
			</div>
    <input type="button"  class="btn btn-info col-sm-3" id="add" value="ADD FILE">
	<div id="files" class="col-sm-12"></div>
    <button type="submit" id="write" class="btn btn-default">Submit</button>
  </form:form>
</div>
<script type="text/javascript" src="../js/summernote.js"></script>
<script type="text/javascript" src="../js/fileCount.js">
</script>

</body>
</html>