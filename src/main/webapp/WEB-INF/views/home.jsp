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
	background-color: #EEEFF1;
	border-radius: 5px;
	padding: 20px;
}
</style>



</head>
<body>

	<c:choose>
		<c:when test="${loginID != null}">
		<table border ="1" align = "center">
		<tr>
			<th colspan = "4"> 	${loginID} 님 환영합니다.
		<tr>
			<td><a href = "/board/list"><button>자유게시판</button>
			<td><a href = "/member/memberInfo?loginID=${loginID}"><button>마이페이지</button></a>
			<td><button>회원탈퇴</button>
			<td><a href = "/member/logout"><button>로그아웃</button></a>
		</table>
		</c:when>	
	<c:otherwise>
			<table border="1" align="center">
				<tr>
					<th colspan=2 align="center">Login Box</th>
				</tr>
				<tr>
					<td>아이디 :</td>
					<td><input type="text" placeholder="input your id" name="id"
						id="id"></td>

				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" placeholder="input your pw" id="pw"
						name="pw"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<button id="loginbtn">로그인</button> <a href="/member/signup"><button>회원가입</button>
					</a> <br> <input type="checkbox">ID기억하기
					</td>
				</tr>
			</table>
	</c:otherwise>
	
	</c:choose>

	<script>
		$("#loginbtn").on("click", function() {
			const id = $("#id").val();
			const pw = $("#pw").val();

			if (id == "") {
				alert("id를 입력해주세요.")
				return;
			}

			$.ajax({
				url : "/member/idCheck",
				data : {
					id : id
				},
			}).done(function(resp) {
				resp = JSON.parse(resp);
				if (!resp) {
					alert("존재하지 않는 ID입니다.");
					$("#id").val("");
					return;
				} else if (pw == "") {
					alert("비밀번호를 입력해주세요")
					return;
				} else {

					$.ajax({
						url : "/member/login",
						data : {
							id : id,
							pw : pw
						}
					}).done(function(resp) {
						resp = JSON.parse(resp);
						if (resp) {
							location.href = "/"
						} else {
							alert("비밀번호가 틀렸습니다.")
						}
					})

				}
			})

		})
		
	

		
		
	</script>





</body>

</html>