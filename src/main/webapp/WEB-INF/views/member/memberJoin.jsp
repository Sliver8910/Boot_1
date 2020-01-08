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
<h1>member Join Page</h1>

<div class="container">
  <form action="./memberJoin" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="id">ID</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
    </div>
    
     <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
    </div>
    
     <div class="form-group">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    
     <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
      <div class="form-group">
      <label for="Files">File</label>
      <input type="file" class="form-control" id="files" placeholder="Enter name" name="files">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>