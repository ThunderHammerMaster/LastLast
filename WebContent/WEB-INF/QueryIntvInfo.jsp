<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		position:absolute;
		width:550px;
		height:200px;
		top: 10%;
		left:10%;
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
		$("button[name=back]").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/back";
		})
	})
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p5.jpg" style="background-size:100%;background-attachment:fixed">
	<form method="post" action="${pageContext.request.contextPath }/admin/sendIntvinfo">
		<table style="text-align:center" cellpadding="10" cellspacing="0" border="2 solid">
			<tr><td colspan="4"><h1>查询应聘简历</h1></td></tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rName }"></td>
				<td>性别</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rSex }"></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rAge }"></td>
				<td>学历</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rEducation }"></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rPhone }"></td>
				<td>Email</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rEmail }"></td>
			</tr>
			<tr>
				<td>部门职位</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rDepart },${requestScope.infoResume.rJob }"></td>
				<td>政治面貌</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rOutlook }"></td>
			</tr>
			<tr>
				<td>工作经验</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rExperience }"></td>
				<td>期望薪资</td>
				<td><input type="text" readonly="readonly" value="${requestScope.infoResume.rWantSalary }"></td>
			</tr>
			<tr>
				<td>兴趣爱好</td>
				<td colspan="3"><input type="text" readonly="readonly" value="${requestScope.infoResume.rHobby }" size="60"></td>
			</tr>
			
				<tr>
					<td>
						面试时间
					</td>
					<td>
						<input type="text" name="intvinfoIntvtime">
					</td>
					<td>
						面试主管
					</td>
					<td>
						${requestScope.mainEmp.empUser }
						<input type="hidden" value="${requestScope.mainEmp.empId }" name="intvinfoIntvEmpId">
						<input type="hidden" value="${requestScope.infoResume.rId }" name="intvinfoResId">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="面试">
					</td>
					<td colspan="2">
						<button name="back">返回</button>
					</td>
				</tr>
			
		</table>
	</form>
</body>
</html>