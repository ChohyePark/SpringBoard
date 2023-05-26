<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

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
	<form action="/board/insert"  method = "post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>자유게시판 글 작성하기</th>
			</tr>
			<tr>
				<td width="540"><select>
						<option>뉴스</option>
						<option>유머</option>
						<option>잡담</option>
				</select> 
				<input type="text" name="title" placeholder="글 제목을 입력하세요"
				style="width: 200px"> 
				<input type="text" name="writer" value ="${loginID}"></td>
			</tr>
			<tr>
				<td><textarea name="contents" placeholder="글 내용을 입력하세요"
						cols="74" rows="15"></textarea></td>
			</tr>
			<tr>
				<td><input type = "file" name = "files" multiple>
			</tr>
			<tr>
				<td align="right">
				<a href="/board/list">
				<button type="button">목록으로</button></a> 
				<button type="submit">작성완료</button></td>
			</tr>
		</table>
	</form>


</body>
</html>