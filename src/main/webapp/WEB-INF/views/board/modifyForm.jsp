<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


	<form action="/board/update"  method = "post">
		<table border="1">
			<tr>
				<th>자유게시판 글 수정하기</th>
			</tr>
			<tr>
				<td width="540"><select>
						<option>뉴스</option>
						<option>유머</option>
						<option>잡담</option>
				</select> 
				<input type="text" name="title" 
				style="width: 200px" > 
				<input type="text" name="writer" value = "${writer}">
				<input type="text" name="writer" value = "${id}" style = "display:none">
				</td>
			</tr>
			<tr>
				<td align = "center"><input type=file name=file>
			<tr>
				<td><textarea name="contents" cols="74" rows="15"></textarea></td>
			</tr>
			<tr>
				<td align="right">
				<button type ="submit">수정완료</button>
				</td>
			</tr>
		</table>
	</form>
	

</body>
</html>