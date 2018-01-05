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
</style>
<script src="${pageContext.request.contextPath }/Js/jquery-1.7.2.js"></script>
<script>
	$(function(){
		<!--添加招聘信息表格显现-->
		$("h1[name=addIntv]").click(function(){
			$("table").hide();
			$("table[name=aIntvTable]").show();
		})
		
		<!--管理员添加招聘信息二级联动-->
		$("select[name=intvDepart]").change(function(){
			var a=$(this).get(0).selectedIndex;
			<!--全部隐藏并修改名字-->
			$("select[name=intvJ]").hide();
			$("select[name=intvJob]").hide();
			$("select[name=intvJob]").attr("name","intvJ");
			<!--把想要的显示出来并且赋予真正的名字-->
			$("select[name=intvJ]").eq(a).show();
			$("select[name=intvJ]").eq(a).attr("name","intvJob");
		})
		<!--在刚进入界面还未执行操作时的默认操作-->
		var start=$("select[name=intvDepart]").get(0).selectedIndex;
		$("select[name=intvJ]").hide();
		$("select[name=intvJob]").hide();
		$("select[name=intvJob]").attr("name","intvJ")
		$("select[name=intvJ]").eq(start).show();
		$("select[name=intvJ]").eq(start).attr("name","intvJob");
		
		<!--查询招聘信息表格显现-->
		$("h1[name=queryIntv]").click(function(){
			$("table").hide();
			$("table[name=qIntvTable]").show();
		})
	})
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p4.jpg" style="background-size:100%">
	<div class="leftdiv">
		<h2 style="color:white">当前管理员用户：${sessionScope.user.aName }</h2>
		<h1 name="addIntv">发布招聘信息</h1>
		<h1>删除招聘信息</h1>
		<h1>修改招聘信息</h1>
		<h1 name="queryIntv">查询招聘信息</h1>
	</div>
	
	<div class="rightdiv">
		<!-- 查询招聘信息 -->
		<c:forEach items="${sessionScope.interview }" var="intv">
			<table name="qIntvTable" hidden style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid" align="center">
				<tr><td colspan="4">招聘信息</td></tr>
				<tr>
					<td>招聘标题</td>
					<td colspan="3">${intv.intvTitle }</td>
				</tr>
				<tr>
					<td>招聘职位</td>
					<td>${intv.intvDepart },${intv.intvJob }</td>
					<td>发布日期</td>
					<td><f:formatDate value="${intv.intvDate }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr><td colspan="4">描述</td></tr>
				<tr><td colspan="4" style="height:100px;width:100px">${intv.intvDesc }</td></tr>
			</table>
		</c:forEach>
		
		<!-- 添加招聘信息 -->
		<table name="aIntvTable" hidden style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid" align="center">
			<form action="${pageContext.request.contextPath }/admin/addIntv" method="post">
				<tr><td colspan="4">发布招聘信息</td></tr>
				<tr>
					<td>招聘标题</td>
					<td colspan="3"><input type="text" name="intvTitle" size="35"></td>
				</tr>
				<tr>
					<td colspan="2">招聘职位</td>
					<td colspan="2">
						<select name="intvDepart">
							<c:forEach items="${sessionScope.depart }" var="depart">
								<option value="${depart.departName }">${depart.departName }</option>
							</c:forEach>
						</select>
						<c:forEach items="${sessionScope.depart }" var="depart">
							<select name="intvJ" hidden>
									<c:forEach items="${depart.job }" var="job">
										<option value="${job.jobName }">${job.jobName }</option>
									</c:forEach>
							</select>
						</c:forEach>
					</td>
				</tr>
				<tr><td colspan="4">描述</td></tr>
				<tr><td colspan="4" style="height:100px;width:100px"><input type="text" name="intvDesc" style="width:300px"></td></tr>
				<tr><td colspan="4"><input type="submit" value="添加招聘信息"></td></tr>
			</form>
		</table>
	</div>
</body>
</html>