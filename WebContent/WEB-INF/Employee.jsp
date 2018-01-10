<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	h2{
		color:white;
	}
	
</style>
<script src="${pageContext.request.contextPath }/Js/jquery-1.7.2.js"></script>
<script>
	$(function(){
		<!--提示消息延迟发送-->
		var infoNum=${sessionScope.user.empInfo};
		if(infoNum>0){
			setTimeout("promptt()",200);
		}
		
		<!--反馈按钮表格显现-->
		$("h1[name=empInfo]").click(function(){
			$("table").hide();
			$("table[name=intvinfo]").show();
		})
		
		<!--退出返回主页-->
		$("h1[name=backHome]").click(function(){
			window.location.href="${pageContext.request.contextPath}/emp/backHome";
		})
		
		<!--点击录取-->
		$("button[name=success]").click(function(){
			<!--获取应聘信息id-->
			var id=$(this).parent().prev().prev().prev().prev().children().text();
			window.location.href="${pageContext.request.contextPath}/emp/admit?infoId="+id;
		})
		
	})
	<!--提示消息-->
	function promptt(){
		var infoNum=${sessionScope.user.empInfo};
		alert("您有"+infoNum+"条信息未查看，请检查反馈");
	}
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p6.jpg" style="background-size:100%">
	<div class="leftdiv"> 
		<h1 name="empInfo">反馈</h1>
		<h1 name="backHome">退出</h1>
	</div>
	
	<div class="rightdiv">
		<!-- 主管面试信息确认 -->
		<c:if test="${sessionScope.user.empLevel==1 }">
			<table name="intvinfo" hidden border="2 solid" cellpadding="10" cellspacing="0" style="margin-left: 80px;text-align: center;">
				<tr>
					<td><h2>应聘编号</h2></td>
					<td><h2>应聘者编号</h2></td>
					<td><h2>面试时间</h2></td>
					<td><h2>面试状态</h2></td>
					<td colspan="2"><h2>操作</h2></td>
				</tr>
				<c:forEach items="${sessionScope.intvinfo}" var="intvinfo">
					<tr>
						<td><h2>${intvinfo.intvinfoId}</h2></td>
						<td><h2>${intvinfo.intvinfoTorId}</h2></td>
						<td><h2><f:formatDate value="${intvinfo.intvinfoIntvtime}" pattern="yyyy-MM-dd"/></h2></td>
						<td><h2>${intvinfo.intvinfoIntv}</h2></td>
						<td><button name="success">录取</button></td>
						<td><button name="fail">不录取</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
	</div>
</body>
</html>