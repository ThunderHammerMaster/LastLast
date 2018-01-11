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
	span{
		color:white;
		font-size: 30px;
		font-weight: bold;
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
			var id=$(this).parent().prev().prev().prev().prev().prev().children().text();
			var sal=$(this).parent().prev().children().val();
			window.location.href="${pageContext.request.contextPath}/emp/admit?infoId="+id+"&salary="+sal;
		})
		
		<!--点击不录取-->
		$("button[name=fail]").click(function(){
			var id=$(this).parent().prev().prev().prev().prev().prev().prev().children().text();
			window.location.href="${pageContext.request.contextPath}/emp/intvFail?infoId="+id;
		})
		
		<!--查询部门表格显现-->
		$("h1[name=qDepart]").click(function(){
			$("table").hide();
			$("table[name=qDepartEmp]").show();
		})
		
		<!--查询部门和职位的二级联动-->
		$("select[name=rDepart]").change(function(){
			var a=$(this).get(0).selectedIndex;
			<!--全部隐藏-->
			$("tr[name=emp]").hide();
			$("select[name=rJob]").hide();
			<!--把想要的显示出来-->
			$("select[name=rJob]").eq(a).show();
			var b=$("select[name=rJob]").eq(a).val();
			$("tr."+b).show();
		})
		
		<!--查询部门和职位职位和员工的二级联动-->
		$("select[name=rJob]").change(function(){
			var a=$(this).val();
			$("tr[name=emp]").hide();
			$("tr."+a).show();
			
			
		})
		
		<!--在刚进入界面还未执行操作时的默认操作-->
		var start=$("select[name=rDepart]").get(0).selectedIndex;
		$("select[name=rJob]").hide();
		$("tr[name=emp]").hide();
		$("select[name=rJob]").eq(start).show();
		var b=$("select[name=rJob]").eq(start).val();
		$("tr."+b).show();
		
		<!--上班打卡按钮-->
		$("button[name=pCardMor]").click(function(){
			window.location.href="${pageContext.request.contextPath}/emp/signMorning";
		})
		
		<!--下班打卡按钮-->
		$("button[name=pCardAft]").click(function(){
			window.location.href="${pageContext.request.contextPath}/emp/signAfternoon";
		})
		
	})
	<!--提示消息-->
	function promptt(){
		var infoNum=${sessionScope.user.empInfo};
		alert("您有"+infoNum+"条信息未查看，请检查反馈");
	}
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p6.jpg" style="background-size:100%;background-attachment:fixed">
	<div class="leftdiv">
		<h2 style="color:white">欢迎员工用户登录：${sessionScope.user.empName }</h2>
		<h1>个人信息</h1>
		<h1 name="qDepart">部门职位</h1>
		<h1>培训</h1>
		<h1>奖惩</h1>
		<h1>薪资</h1>
		<h1 name="empInfo">反馈</h1>
		<h1 name="backHome">退出</h1>
	</div>
	
	<div class="rightdiv">
		<button style="margin-left: 600px;margin-top: 20px" name="pCardMor">上班打卡</button>&nbsp;&nbsp;&nbsp;<button name="pCardAft">下班打卡</button>
		
		<!-- 查询部门 -->
		<table name="qDepartEmp" hidden cellpadding="10" cellspacing="0" style="margin-left: 60px;text-align: center;" background="${pageContext.request.contextPath }/Picture/p7.jpg">
			<tr>
				<td><span>部门</span></td>
				<td>
					<select name="rDepart">
							<c:forEach items="${sessionScope.depart }" var="depart">
								<option value="${depart.departName }">${depart.departName }</option>
							</c:forEach>
					</select>
				</td>
				<td><span>职位</span></td>
				<td width="150">
					<c:forEach items="${sessionScope.depart }" var="depart">
							<select name="rJob" hidden>
									<c:forEach items="${depart.job }" var="job">
										<option value="${job.jobName }">${job.jobName }</option>
									</c:forEach>
							</select>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td><span>员工编号</span></td>
				<td><span>员工名字</span></td>
				<td><span>员工年龄</span></td>
				<td><span>员工状态</span></td>
			</tr>
			<c:forEach items="${sessionScope.depart }" var="depart">
				<c:forEach items="${depart.job }" var="job">
					<c:forEach items="${job.emp }" var="emp">
						<tr class="${job.jobName }" hidden name="emp">
							<td><span>${emp.empId }</span></td>
							<td><span>${emp.empName }</span></td>
							<td><span>${emp.empAge }</span></td>
							<td><span>${emp.empStatus }</span></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</c:forEach>
			
		</table>
		
		<!-- 主管面试信息确认 -->
		<c:if test="${sessionScope.user.empLevel==1 }">
			<table name="intvinfo" hidden border="2 solid" cellpadding="10" cellspacing="0" style="margin-left: 80px;text-align: center;">
				<tr>
					<td><h2>应聘编号</h2></td>
					<td><h2>应聘者编号</h2></td>
					<td><h2>面试时间</h2></td>
					<td><h2>面试状态</h2></td>
					<td><h2>薪资</h2></td>
					<td colspan="2"><h2>操作</h2></td>
				</tr>
				<c:forEach items="${sessionScope.intvinfo}" var="intvinfo">
					<tr>
						<td><h2>${intvinfo.intvinfoId}</h2></td>
						<td><h2>${intvinfo.intvinfoTorId}</h2></td>
						<td><h2><f:formatDate value="${intvinfo.intvinfoIntvtime}" pattern="yyyy-MM-dd"/></h2></td>
						<td><h2>${intvinfo.intvinfoIntv}</h2></td>
						<td><input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" size="5"></td>
						<td><button name="success">录取</button></td>
						<td><button name="fail">不录取</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
	</div>
</body>
</html>