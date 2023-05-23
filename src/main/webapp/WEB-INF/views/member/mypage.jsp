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
	width:400px;
	background-color: #EEEFF1;
	border-radius: 5px;
	text-align: center;
	margin-top : 200px;
	padding: 20px;
}


</style>




</head>
<body>

	<form action = "/member/update" method = "post">
	 <table border = "1" align = "center">
	 	<tr>
	 	<th colspan = "2" align = "center">${dto.name} MyPage
	 	<tr>
	 	<td> ID
	 	<td> <input type ="text" value ="${dto.id}" name = "id"  readonly >
	 	<tr>
	 	<td> 연락처
 	 	<td> <input type = "text" value = "${dto.contact}" name = "contact"   readonly> 
	 	<tr>
	 	<td> 이메일
	 	<td> <input type = "text" value = "${dto.email}"  name = "email"  readonly>
	 	<tr>
	 	<td> 우편번호
	 	<td> <input type = "text" value = "${dto.zipcode}" name = "zipcode" readonly> 
	 	<tr>
	 	<td> 주소 
	 	<td> <input type = "text" value = "${dto.address1}" name = "address1"  readonly>
	 	<tr>
	 	<td> 상세 주소
	 	<td> <input type = "text" value = "${dto.address2}" name = "address2"   readonly> 
	 	 <input type = "text" value = "${dto.seq}" name = "seq" style = "display : none"> 
	 	<tr>
	 	<td colspan = "2" align ="center" id = "btncontroller"> <button id = "modbtn" type = "button">수정</button>
		<a href="/"><button id = "backbtn" type = "button">이전</button></a>
	 </table>
 	 </form>

	<script>
		$("#modbtn").on("click",function(){	
			$("input").removeAttr("readonly");
			
			$("#modbtn,#backbtn").css("display","none");
			
			let modsubmit = $("<button>").text("수정완료").attr('type','submit');

			let cancel = $("<button>");
			cancel.attr("type","button");
			cancel.text("취소");
			
			cancel.on("click",function(){
				location.reload(); 
			})
			
			$("#btncontroller").append(modsubmit,cancel);		

		
		})
	
	</script>

</body>
</html>