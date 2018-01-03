<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.login{
		position:absolute;
		width:500px;
		height: 400px;
		top: 50%;
		left:50%;
		margin-left: -250px;
		margin-top: -200px;
	}
	font{
		font-weight:bold;
		font-size: 10;
	}
</style>
</head>
<body background="${pageContext.request.contextPath }/Picture/p1.jpg" style="background-size:100%">
	<div class="login" align="center">
		<table style="text-align:center" cellpadding="10" cellspacing="0">
			<form action="${pageContext.request.contextPath }/tor/login">
				<tr>
					<td colspan="2"><h1>肥宅管理登陆页面</h1></td>
				</tr>
				<tr>
					<td><font>用户名：</font></td>
					<td><input type="text" name="tName"></td>
				</tr>
				<tr>
					<td><font>密码：</font></td>
					<td><input type="text" name="tPassword"></td>
				</tr>
				<tr><td colspan="2"><font style="color:red">${requestScope.err }</font></td></tr>
				<tr><td colspan="2"><input type="submit" value="登陆"></td></tr>
			</form>
			<form action="${pageContext.request.contextPath }/tor/toRegist">
				<tr><td colspan="2"><input type="submit" value="注册"></td></tr>
			</form>
		</table>
		
	</div>
</body>
</html>