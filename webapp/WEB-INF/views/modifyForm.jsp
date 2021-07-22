<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 수정</h1>
	<p>수정화면 입니다. 아래 항목을 수정하고 "수정" 버튼을 클릭하세요</p>

	<form action="/phonebook3/modify" method="get">

		이름: <input type="text" name="name" value="${phoneVo.name}"> <br> 핸드폰: <input type="text" name="hp" value="${phoneVo.hp}">
		<br> 회사: <input type="text" name="company" value="${phoneVo.company}"> <br> <input type="hidden" name="personId"
			value="${phoneVo.personId}"> <br>
		<button type="submit">수정</button>
	</form>


</body>
</html>