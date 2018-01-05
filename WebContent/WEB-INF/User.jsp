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
		$("h1[name=writeTorResume]").click(function(){
			$("table").hide();
			$("table[name=wrt]").show();
		})
		
		<!--游客简历里的部门和职位的二级联动-->
		$("select[name=rDepart]").change(function(){
			var a=$(this).get(0).selectedIndex;
			<!--全部隐藏并修改名字-->
			$("select[name=rJ]").hide();
			$("select[name=rJob]").hide();
			$("select[name=rJob]").attr("name","rJ");
			<!--把想要的显示出来并且赋予真正的名字-->
			$("select[name=rJ]").eq(a).show();
			$("select[name=rJ]").eq(a).attr("name","rJob");
		})
		<!--在刚进入界面还未执行操作时的默认操作-->
		var start=$("select[name=rDepart]").get(0).selectedIndex;
		$("select[name=rJ]").hide();
		$("select[name=rJob]").hide();
		$("select[name=rJob]").attr("name","rJ")
		$("select[name=rJ]").eq(start).show();
		$("select[name=rJ]").eq(start).attr("name","rJob");
		
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
		
		<!--游客填写简历的邮箱格式验证-->
		$("input[name=rEmail]").blur(function(){
			if(!$(this).val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
				$("span[name=emailErr]").show();
			}else{
				$("span[name=emailErr]").hide();
			}
		})
		
		<!--游客填写简历提交验证-->
		$("input[name=rName]").blur(function(){
			if($(this).val().length<1 || $("input[name=rPhone]").val().length<1){
				$("form[name=sendResume]").attr("onsubmit","return false");
			}else{
				$("form[name=sendResume]").attr("onsubmit","return true");
			}
		})
		$("input[name=rPhone]").blur(function(){
			if($(this).val().length<1 || $("input[name=rName]").val().length<1){
				$("form[name=sendResume]").attr("onsubmit","return false");
			}else{
				$("form[name=sendResume]").attr("onsubmit","return true");
			}
		})
		
		<!--游客查询简历-->
		$("h1[name=queryTorResume]").click(function(){
			$("table").hide();
			$("table[name=qrt]").show();
		})
		
		<!--游客修改简历-->
		$("h1[name=updateTorResume]").click(function(){
			$("table").hide();
			$("table[name=urt]").show()
		})
		
		<!--游客修改简历里的部门和职位的二级联动-->
		$("select[name=urDepart]").change(function(){
			var a=$(this).get(0).selectedIndex;
			<!--全部隐藏并修改名字-->
			$("select[name=urJ]").hide();
			$("select[name=urJob]").hide();
			$("select[name=urJob]").attr("name","urJ");
			<!--把想要的显示出来并且赋予真正的名字-->
			$("select[name=urJ]").eq(a).show();
			$("select[name=urJ]").eq(a).attr("name","urJob");
		})
		<!--在刚进入界面还未执行操作时的修改简历里的默认操作-->
		var start=$("select[name=urDepart]").get(0).selectedIndex;
		$("select[name=urJ]").hide();
		$("select[name=urJob]").hide();
		$("select[name=urJob]").attr("name","urJ")
		$("select[name=urJ]").eq(start).show();
		$("select[name=urJ]").eq(start).attr("name","urJob");
		
		<!--查询招聘信息表格显现-->
		$("h1[name=queryIntv]").click(function(){
			$("table").hide();
			$("table[name=qIntvTable]").show();
		})
	})
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p3.jpg" style="background-size:100%">
	<div class="leftdiv">
	<h2 style="color:white">当前游客用户：${sessionScope.user.tName }</h2>
		<h1 name="queryIntv">浏览招聘信息</h1>
		<h1 name="writeTorResume">填写公司简历</h1>
		<h1 name="queryTorResume">查看公司简历</h1>
		<h1 name="updateTorResume">修改公司简历</h1>
		<h1 name="updatePassword">修改密码</h1>
		<h1>反馈</h1>
		<h1 name="back">退出</h1>
		<h1></h1>
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
		
		<!--修改简历 -->
		<table name="urt" hidden style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid" align="center">
			<form name="updateResume" method="post" action="${pageContext.request.contextPath }/tor/updateRes">
				<tr><td colspan="4"><h1 style="color:black">修改简历</h1></td></tr>
				<tr>
					<td>姓名*</td>
					<td><input type="text" name="rName" value="${sessionScope.myResume.rName }"></td>
					<td>性别</td>
					<c:if test="${sessionScope.myResume.rSex=='男' }">
						<td>男<input type="radio" name="rSex" value="男" checked="checked">&nbsp女<input type="radio" name="rSex" value="女"></td>
					</c:if>
					<c:if test="${sessionScope.myResume.rSex=='女' }">
						<td>男<input type="radio" name="rSex" value="男">&nbsp女<input type="radio" name="rSex" value="女" checked="checked"></td>
					</c:if>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="rAge" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="2" value="${sessionScope.myResume.rAge }"></td>
					<td>学历</td>
					<td>
						<select name="rEducation">
							<option value="${sessionScope.myResume.rEducation }">${sessionScope.myResume.rEducation }</option>
							<option value="幼儿园">幼儿园</option>
							<option value="小学生">小学生</option>
							<option value="初中">初中</option>
							<option value="高中">高中</option>
							<option value="大学">大学</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>联系方式*</td>
					<td><input type="text" name="rPhone" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" value="${sessionScope.myResume.rPhone }"></td>
					<td>Email</td>
					<td><input type="text" name="rEmail" value="${sessionScope.myResume.rEmail }"><span style="color:red" hidden name="emailErr">邮箱格式错误</span></td>
				</tr>
				<tr>
					<td>部门职位</td>
					<td>
						<select name="urDepart">
							<c:forEach items="${sessionScope.depart }" var="depart">
								<option value="${depart.departName }">${depart.departName }</option>
							</c:forEach>
						</select>
						
						<c:forEach items="${sessionScope.depart }" var="depart">
							<select name="urJ" hidden>
									<c:forEach items="${depart.job }" var="job">
										<option value="${job.jobName }">${job.jobName }</option>
									</c:forEach>
							</select>
						</c:forEach>
					</td>
					<td>政治面貌</td>
					<td>
						<select name="rOutlook">
							<option value="${sessionScope.myResume.rOutlook }">${sessionScope.myResume.rOutlook }</option>
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
					<td><input type="text" name="rExperience" value="${sessionScope.myResume.rExperience }"></td>
					<td>期望薪资</td>
					<td>
						<select name="rWantSalary">
							<option value="${sessionScope.myResume.rWantSalary }">${sessionScope.myResume.rWantSalary }</option>
							<option value="3000-4000">3000-4000</option>
							<option value="5000-6000">5000-6000</option>
							<option value="7000-8000">7000-8000</option>
							<option value="10000+">10000+</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>兴趣爱好</td>
					<td colspan="3"><input type="text" name="rHobby" size="60" value="${sessionScope.myResume.rHobby }"></td>
				</tr>
				<tr><td colspan="4"><input type="submit" value="提交修改简历"></td></tr>
			</form>
		</table>
		
		<!-- 查看简历 -->
		<table name="qrt" hidden style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid" align="center">
				<tr><td colspan="4"><h1 style="color:black">查询简历</h1></td></tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rName }"></td>
					<td>性别</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rSex }"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rAge }"></td>
					<td>学历</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rEducation }"></td>
				</tr>
				<tr>
					<td>联系方式</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rPhone }"></td>
					<td>Email</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rEmail }"></td>
				</tr>
				<tr>
					<td>部门职位</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rDepart },${sessionScope.myResume.rJob }"></td>
					<td>政治面貌</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rOutlook }"></td>
				</tr>
				<tr>
					<td>工作经验</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rExperience }"></td>
					<td>期望薪资</td>
					<td><input type="text" readonly="readonly" value="${sessionScope.myResume.rWantSalary }"></td>
				</tr>
				<tr>
					<td>兴趣爱好</td>
					<td colspan="3"><input type="text" readonly="readonly" value="${sessionScope.myResume.rHobby }" size="60"></td>
				</tr>
		</table>
	
		<!--填写简历  -->
		<table name="wrt" hidden style="text-align:center" cellpadding="10" cellspacing="0" border="2px solid" align="center">
			<form name="sendResume" onsubmit="return false" method="post" action="${pageContext.request.contextPath }/tor/sendResume?sRId=${sessionScope.user.tId}">
				<tr><td colspan="4"><h1 style="color:black">填写简历</h1></td></tr>
				<tr>
					<td>姓名*</td>
					<td><input type="text" name="rName"></td>
					<td>性别</td>
					<td>男<input type="radio" name="rSex" value="男">&nbsp女<input type="radio" name="rSex" value="女"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="rAge" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="2"></td>
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
					<td>联系方式*</td>
					<td><input type="text" name="rPhone" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')"></td>
					<td>Email</td>
					<td><input type="text" name="rEmail"><span style="color:red" hidden name="emailErr">邮箱格式错误</span></td>
				</tr>
				<tr>
					<td>部门职位</td>
					<td>
						<select name="rDepart">
							<c:forEach items="${sessionScope.depart }" var="depart">
								<option value="${depart.departName }">${depart.departName }</option>
							</c:forEach>
						</select>
						<c:forEach items="${sessionScope.depart }" var="depart">
							<select name="rJ" hidden>
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
			<form action="${pageContext.request.contextPath }/tor/updatePW?tName=${sessionScope.user.tName}" method="post" onsubmit="return false" name="updPassw">
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
</body>
</html>