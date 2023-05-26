<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
}

body {
	background-color: #FAC8C8;
}

table {
	margin: auto;
	width: 300px;
	background-color: #EEEFF1;
	border-radius: 5px;
	text-align: center;
	padding: 20px;
}
</style>
</head>

<body>


	<table border="1">
		<tr>
			<th>작성 글</th>
		</tr>
		<tr>
			<td width="540"><select>
					<option>뉴스</option>
					<option>유머</option>
					<option>잡담</option>
			</select> <input type="text" name="title" value="${dto.title}"
				style="width: 200px" readonly> <input type="text"
				name="writer" value="${dto.writer}" readonly></td>
		</tr>
		<c:choose>
		<c:when test="${!empty files}">
		<tr>
		<td>
			<c:forEach var="file" items="${files}">
				 <a href="download?sysName=${file.sysName}"> ${file.oriName} </a> <br>
			</c:forEach>
			</c:when>	
		</c:choose>	
		<tr>
			<td><textarea name="contents" cols="74" rows="15" readonly>${dto.contents}</textarea></td>
		</tr>
		<tr>
			<td align="right" id="btncontroller"><a
				href="/board/modify?id=${dto.seq}&writer=${dto.writer}"><button
						type="button">수정</button></a> <a href="/board/delete?id=${dto.seq}"><button
						type="button" id="delbtn">삭제</button></a></td>
		</tr>
	</table>


	<script>
		
	</script>

</body>
</html>