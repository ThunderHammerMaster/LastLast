<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.leftdiv{
		width:29%;
		height:100%;
		text-align:center;
		float:left;
	}
	.rightdiv{
		width:70%;
		height:100%;
		text-align:center;
		
		float:left;
	}
	h1{
		color:white;
	}
	font{
		size:10;
		color:white;
	}
</style>
<script src="${pageContext.request.contextPath }/Js/jquery-1.7.2.js"></script>
<script>
	$(function (){
		$("h1[name=back]").click(function(){
			window.location.href="${pageContext.request.contextPath}/tor/back";
		})
		
		$("h1[name=updatePassword]").click(function(){
			$("table[name=updatePassw]").show();
		})
	})
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p3.jpg" style="background-size:100%">
	<c:if test="${requestScope.type==2 }">
		<div class="leftdiv">
		<h2 style="color:white">当前游客用户：${requestScope.user.tName }</h2>
			<h1>浏览招聘信息</h1>
			<h1>填写公司简历</h1>
			<h1>查看公司简历</h1>
			<h1>修改公司简历</h1>
			<h1 name="updatePassword">修改密码</h1>
			<h1>反馈</h1>
			<h1 name="back">退出</h1>
			<h1></h1>
		</div>
		<div class="rightdiv">
			<table name="updatePassw" hidden style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid" align="center">
				<form action="${pageContext.request.contextPath }/tor/updatePW?tName=${requestScope.user.tName}">
					<tr>
						<td colspan="2"><h1 style="color:black">修改密码</h1></td>
					</tr>
					<tr>
						<td><font style="color:black">新密码：</font></td>
						<td><input type="text" name="tPassword"></td>
					</tr>
					<tr><td colspan="2"><input type="submit" value="修改"></td></tr>
				</form>
			</table>
		</div>
	</c:if>
	
	
	
	<c:if test="${requestScope.type==0 }">
	
	</c:if>
	<c:if test="${requestScope.type==1 }">
	
	</c:if>
</body>
</html>