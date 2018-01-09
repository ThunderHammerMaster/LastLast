<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		position:absolute;
		width:400px;
		height:200px;
		top: 40%;
		left:15%;
	}
	h1{
		color: white;
	}
	h2{
		color: white;
	}
</style>
<script src="${pageContext.request.contextPath }/Js/jquery-1.7.2.js"></script>
<script>
	$(function(){
		<!--添加部门名字不能为空验证-->
		$("input[name=departName]").blur(function(){
			if($(this).val().length>0){
				$("form[name=addDep]").attr("onsubmit","return true");
			}else{
				$("form[name=addDep]").attr("onsubmit","return false");
			}
		})
		
		<!--返回按钮返回-->
		$("button[name=back]").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/back";
		})
		
		<!--添加职位名字不能为空验证-->
		$("input[name=jobName]").blur(function(){
			if($(this).val().length>0){
				$("form[name=addJob]").attr("onsubmit","return true");
			}else{
				$("form[name=addJob]").attr("onsubmit","return false");
			}
		})
		
	})
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p5.jpg" style="background-size:100%;background-attachment:fixed">
	<!-- 增加部门 -->
	<c:if test="${requestScope.type==1 }">
		<table style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid">
			<form name="addDep" method="post" onsubmit="return false" action="${pageContext.request.contextPath }/admin/addDep">
				<tr><td colspan="2"><h1>增加部门</h1></td></tr>
				<tr>
					<td><h2>部门名字</h2></td>
					<td><input type="text" name="departName"></td>
				</tr>
				<tr><td colspan="2"><input type="submit" value="添加部门">&nbsp&nbsp&nbsp&nbsp<button name="back">返回</button></td></tr>
			</form>
		</table>
	</c:if>
	
	
	<!-- 增加职位 -->
	<c:if test="${requestScope.type==2 }">
		<table style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid">
			<form name="addJob" method="post" onsubmit="return false" action="${pageContext.request.contextPath }/admin/addJob">
				<tr><td colspan="2"><h1>增加职位</h1></td></tr>
				<tr>
					<td>职位名称</td>
					<td colspan="1"><input type="text" name="jobName"></td>
				</tr>
				<tr>
					<td>职位所属部门</td>
					<td>
						<select name="jobDepartId">
							<c:forEach var="dep" items="${sessionScope.depart }"> 
								<option value="${dep.departId }">${dep.departName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr><td colspan="2"><input type="submit" value="添加职位">&nbsp&nbsp&nbsp&nbsp<button name="back">返回</button></td></tr>
			</form>
		</table>
	</c:if>
</body>
</html>