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
		font-size:20px;
		color:white;
	}
	font2{
		font-size:20px;
	}
</style>
<script src="${pageContext.request.contextPath }/Js/jquery-1.7.2.js"></script>
<script>
	$(function (){
		<!--游客返回-->
		$("h1[name=back]").click(function(){
			window.location.href="${pageContext.request.contextPath}/tor/back";
		})
		<!--游客修改密码-->
		$("h1[name=updatePassword]").click(function(){
			$("table").hide();
			$("table[name=updatePassw]").show();
		})
		<!--游客填写简历-->
		$("h1[name=writeResume]").click(function(){
			$("table").hide();
			$("table[name=wrt]").show();
		})
		<!--游客简历里的部门和职位的二级联动-->
		$("select[name=rDepart]").change(function(){
			var a=$("select[name=rDepart]").get(0).selectedIndex;
			$("select[name=rJob]").hide();
			$("select[name=rJob]").eq(a).show();
		})
		var start=$("select[name=rDepart]").get(0).selectedIndex;
		$("select[name=rJob]").hide();
		$("select[name=rJob]").eq(start).show();
		<!--游客修改密码的新密码的新密码验证-->
		$("input[name=tPassword]").blur(function(){
			if($(this).val().length<6){
				$("form[name=updPassw]").attr("onsubmit","return false");
				$("span[name=updateErr]").show();
			}else{
				$("form[name=updPassw]").attr("onsubmit","return true");
				$("span[name=updateErr]").hide();
			}
		})
	})
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p3.jpg" style="background-size:100%">
	
	<!--游客模式  -->
	<c:if test="${requestScope.type==2 }">
		<div class="leftdiv">
		<h2 style="color:white">当前游客用户：${requestScope.user.tName }</h2>
			<h1>浏览招聘信息</h1>
			<h1 name="writeResume">填写公司简历</h1>
			<h1>查看公司简历</h1>
			<h1>修改公司简历</h1>
			<h1 name="updatePassword">修改密码</h1>
			<h1>反馈</h1>
			<h1 name="back">退出</h1>
			<h1></h1>
		</div>
		<div class="rightdiv">
			<!--填写简历  -->
			<table name="wrt" hidden style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid" align="center">
				<form>
					<tr><td colspan="4"><h1 style="color:black">填写简历</h1></td></tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="rName"></td>
						<td>性别</td>
						<td>男<input type="radio" name="sex" value="男">&nbsp女<input type="radio" name="sex" value="女"></td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><input type="text" name="rAge" onkeyup="value=value.replace(/[^\d]/g,'')"></td>
						<td>学历</td>
						<td>
							<select name="rEducation">
								<option value="幼儿园">幼儿园</option>
								<option value="小学生">小学生</option>
								<option value="初中">初中</option>
								<option value="高中">高中</option>
								<option value="大学">大学</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>联系方式</td>
						<td><input type="text" name="rPhone" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')"></td>
						<td>Email</td>
						<td><input type="text" name="rEmail"></td>
					</tr>
					<tr>
						<td>部门职位</td>
						<td>
							<select name="rDepart">
								<c:forEach items="${requestScope.depart }" var="depart">
									<option value="${depart.departName }">${depart.departName }</option>
								</c:forEach>
							</select>
							<c:forEach items="${requestScope.depart }" var="depart">
								<select name="rJob" hidden>
										<c:forEach items="${depart.job }" var="job">
											<option value="${job.jobName }">${job.jobName }</option>
										</c:forEach>
								</select>
							</c:forEach>
						</td>
						<td>政治面貌</td>
						<td>
							<select name="rOutlook">
								<option value="群众">群众</option>
								<option value="少先队员">少先队员</option>
								<option value="团员">团员</option>
								<option value="党员">党员</option>
								<option value="仙人">仙人</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>工作经验</td>
						<td><input type="text" name="rExperience"></td>
						<td>期望薪资</td>
						<td>
							<select name="rWantSalary">
								<option value="3000-4000">3000-4000</option>
								<option value="5000-6000">5000-6000</option>
								<option value="7000-8000">7000-8000</option>
								<option value="10000+">10000+</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>兴趣爱好</td>
						<td colspan="3"><input type="text" name="rHobby" size="60"></td>
					</tr>
					<tr><td colspan="4"><input type="submit" value="提交简历"></td></tr>
				</form>
			</table>
		
			<!--修改密码-->
			<table name="updatePassw" hidden style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid" align="center">
				<form action="${pageContext.request.contextPath }/tor/updatePW?tName=${requestScope.user.tName}" method="post" onsubmit="return false" name="updPassw">
					<tr>
						<td colspan="2"><h1 style="color:black">修改密码</h1></td>
					</tr>
					<tr>
						<td><font style="color:black">新密码：</font></td>
						<td><input type="text" name="tPassword"><span name="updateErr" style="color:red" hidden>新密码必须大于6位数</span></td>
					</tr>
					
					<tr><td colspan="2"><input type="submit" value="修改"></td></tr>
				</form>
			</table>
		</div>
	</c:if>
	
	
	<!-- 管理员模式 -->
	<c:if test="${requestScope.type==0 }">
	
	</c:if>
	
	<!-- 员工模式 -->
	<c:if test="${requestScope.type==1 }">
	
	</c:if>
</body>
</html>