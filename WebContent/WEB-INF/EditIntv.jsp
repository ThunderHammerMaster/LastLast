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
		height:400px;
		top: 25%;
		left:15%;
	}
</style>
<script src="${pageContext.request.contextPath }/Js/jquery-1.7.2.js"></script>
<script>
	$(function(){
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
		<!--二级联动回显-->
		$("option[name=${requestScope.editIntv.intvDepart}]").attr("selected","selected");
		$("option[name=${requestScope.editIntv.intvJob}]").attr("selected","selected");
		<!--在刚进入界面还未执行操作时的默认操作-->
		var start=$("select[name=intvDepart]").get(0).selectedIndex;
		$("select[name=intvJ]").hide();
		$("select[name=intvJob]").hide();
		$("select[name=intvJob]").attr("name","intvJ")
		$("select[name=intvJ]").eq(start).show();
		$("select[name=intvJ]").eq(start).attr("name","intvJob");
		
		$("button[name=back]").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/back";
		})
	})
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p5.jpg" style="background-size:100%">
	<!-- 编辑招聘信息 -->
	<table name="eIntvTable" style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid">
			<form action="${pageContext.request.contextPath }/admin/editIntv" method="post">
				<tr><td colspan="4">修改招聘信息<input type="hidden" value="${requestScope.editIntv.intvId }" name="intvId"></td></tr>
				<tr>
					<td>招聘标题</td>
					<td colspan="3"><input type="text" name="intvTitle" size="35" value="${requestScope.editIntv.intvTitle }"></td>
				</tr>
				<tr>
					<td colspan="2">招聘职位</td>
					<td colspan="2">
						<select name="intvDepart">
							<c:forEach items="${sessionScope.depart }" var="depart">
								<option name="${depart.departName }" value="${depart.departName }">${depart.departName }</option>
							</c:forEach>
						</select>
						<c:forEach items="${sessionScope.depart }" var="depart">
							<select name="intvJ" hidden>
									<c:forEach items="${depart.job }" var="job">
										<option name="${job.jobName }" value="${job.jobName }">${job.jobName }</option>
									</c:forEach>
							</select>
						</c:forEach>
					</td>
				</tr>
				<tr><td colspan="4">描述</td></tr>
				<tr><td colspan="4" style="height:100px;width:100px"><input type="text" name="intvDesc" style="width:300px" value="${requestScope.editIntv.intvDesc }"></td></tr>
				<tr><td colspan="4"><input type="submit" value="修改招聘信息">&nbsp&nbsp&nbsp<button name="back">返回</button></td></tr>
			</form>
		</table>
</body>
</html>