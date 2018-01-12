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
	span{
		color:white;
		font-size: 30px;
		font-weight: bold;
	}
</style>
<script src="${pageContext.request.contextPath }/Js/jquery-1.7.2.js"></script>
<script>
	$(function(){
		<!--退出返回主页-->
		$("h1[name=backHome]").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/backHome";
		})
		
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
		
		<!--招聘信息删除按钮-->
		$("button.del").click(function(){
			var a=$(this).attr("name");
			window.location.href="${pageContext.request.contextPath}/admin/delIntv?delIntvId="+a;
		})
		<!--招聘信息编辑按钮跳转-->
		$("button.edit").click(function(){
			var e=$(this).attr("name");
			window.location.href="${pageContext.request.contextPath}/admin/toEditIntv?editIntvId="+e;
		})
		
		<!--查询部门表格显现-->
		$("h1[name=qDepart]").click(function(){
			$("table").hide();
			$("table[name=qDepartEmp]").show();
		})
		<!--查询部门点击显示信息-->
		$("span").click(function(){
			var a=$(this).attr("name");
			if($("tr[name="+a+"]").is(":hidden")){
		        $("tr[name="+a+"]").show();
			}else{
		       $("tr[name="+a+"]").hide();
			}
		})
		
		<!--部门删除-->
		$("button.delDepart").click(function(){
			var index=$(this).parent().parent();
			var a=$(this).attr("name");
			$.ajax({
				url:"${pageContext.request.contextPath }/admin/delDepart",
				type:"post",
				dataType:"text",
				data:{delDepartId:a},
				success:function(data){
					if(data=="1"){
						index.remove();
					}else{
						alert("部门内含有职位，不能删除");
					}
				}
			})
		})
		
		<!--部门修改出现-->
		$("button.editDepart").click(function(){
			var a=$(this).parent().next();
			if(a.is(":hidden")){
				a.show();
			}else{
				a.hide();
			}
		})
		
		<!--部门修改提交-->
		$("button[name=editDepart]").click(function(){
			if($(this).prev().val().length>0){
				var a=$(this).prev().val();
				var b=$(this).prev().attr("name");
				var c=$(this).parent().prev().prev().prev().children();
				$.ajax({
					url:"${pageContext.request.contextPath }/admin/editDepart",
					type:"post",
					dataType:"text",
					data:{departName:a,departId:b},
					success:function(data){
						c.text(a);
					}
				})
			}
		})
		
		<!--职位删除-->
		$("button.delJob").click(function(){
			var index=$(this).parent().parent();
			var a=$(this).attr("name");
			$.ajax({
				url:"${pageContext.request.contextPath }/admin/delJob",
				type:"post",
				dataType:"text",
				data:{delJobId:a},
				success:function(data){
					if(data=="1"){
						index.remove();
					}else{
						alert("职位内含有员工，不能删除");
					}
				}
			})
		})
		
		<!--职位修改出现-->
		$("button.editJob").click(function(){
			var a=$(this).parent().next();
			if(a.is(":hidden")){
				a.show();
			}else{
				a.hide();
			}
		})
		
		<!--职位修改提交-->
		$("button[name=editJob]").click(function(){
			if($(this).prev().val().length>0){
				var a=$(this).prev().val();
				var b=$(this).prev().attr("name");
				var c=$(this).parent().prev().prev().prev().children();
				$.ajax({
					url:"${pageContext.request.contextPath }/admin/editJob",
					type:"post",
					dataType:"text",
					data:{jobName:a,jobId:b},
					success:function(data){
						c.text(a);
					}
				})
			}
		})
		
		<!--增加部门键跳转-->
		$("h1[name=addDepart]").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/toAddDJ?type=1";
		})
		
		<!--增加职位跳转-->
		$("h1[name=addJob]").click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/toAddDJ?type=2";
		})
		
		<!--提示消息延迟发送-->
		var infoNum=${sessionScope.user.aInfo};
		if(infoNum>0){
			setTimeout("promptt()",200);
		}
		
		<!--查看应聘信息表格显现-->
		$("h1[name=queryIntvInfo]").click(function(){
			$("table").hide();
			$("table[name=qIntvInfo]").show();
		})
		
		<!--查看应聘信息按钮-->
		$("button.intvinfoquery").click(function(){
			var infoId=$(this).attr("name");
			window.location.href="${pageContext.request.contextPath}/admin/toIntvInfo?infoId="+infoId;
		})
		
		<!--删除应聘信息按钮-->
		$("button.intvinfoDel").click(function(){
			var infoId=$(this).attr("name");
			var index=$(this).parent().parent();
			$.ajax({
				url:"${pageContext.request.contextPath }/admin/delIntvInfo",
				type:"post",
				dataType:"text",
				data:{infoId:infoId},
				success:function(data){
					index.remove();
				}
			})
		})
		
		<!--上传培训信息-->
		$("h1[name=addTrain]").click(function(){
			if($("table[name=addTra]").is(":hidden")){
				$("table").hide();
				$("table[name=addTra]").show();
			}else{
				$("table").hide();
				$("table[name=addTra]").hide();
			}
		})
		
		<!--查看培训信息-->
		$("h1[name=queryTrain]").click(function(){
			if($("table[name=qTra]").is(":hidden")){
				$("table").hide();
				$("table[name=qTra]").show();
			}else{
				$("table").hide();
				$("table[name=qTra]").hide();
			}
		})
		
	})
	
	<!--提示消息-->
	function promptt(){
		var infoNum=${sessionScope.user.aInfo};
		alert("您有"+infoNum+"条信息未查看，请检查反馈");
	}
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p4.jpg" style="background-size:100%">
	<div class="leftdiv">
		<h2 style="color:white">当前管理员用户：${sessionScope.user.aName }</h2>
		<h1 name="addIntv">发布招聘信息</h1>
		<h1 name="queryIntv">查询招聘信息</h1>
		<h1 name="qDepart">查询部门</h1>
		<h1 name="addDepart">增加部门</h1>
		<h1 name="addJob">增加职位</h1>
		<h1 name="addTrain">发布培训</h1>
		<h1 name="queryTrain">查看培训</h1>
		<h1 name="queryIntvInfo">查看应聘信息</h1>
		<h1 name="backHome">退出</h1>
	</div>
	
	<div class="rightdiv">
		<!-- 查询培训信息表格 -->
		<c:if test="${!empty sessionScope.trainInfo }">
			<table name="qTra" hidden border="2 solid" cellpadding="10" cellspacing="0" style="margin-left: 80px;text-align: center;">
				<tr>
					<td>培训标题</td>
					<td>培训时间</td>
					<td>培训时长</td>
					<td>培训内容</td>
				</tr>
				<c:forEach items="${sessionScope.trainInfo }" var="train">
					<tr>
						<td>${train.trainTitle }</td>
						<td><f:formatDate value="${train.trainDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${train.trainLength }小时</td>
						<td>${train.trainContent }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<!-- 发布培训表格 -->
		<form method="post" action="${pageContext.request.contextPath }/admin/addTrain">
			<table name="addTra" hidden border="2 solid" cellpadding="10" cellspacing="0" style="margin-left: 80px;text-align: center;">
				<tr><td colspan="4">发布培训信息</td></tr>
				<tr>
					<td>培训标题</td>
					<td colspan="3"><input type="text" name="trainTitle"></td>
				</tr>
				<tr>
					<td>培训时间</td>
					<td><input type="text" name="tTime"></td>
					<td>培训时长</td>
					<td><input type="text" name="trainLength"></td>
				</tr>
				<tr>
					<td colspan="2">培训部门</td>
					<td colspan="2">
						<select name="trainDep">
							<c:forEach var="depart" items="${sessionScope.depart }">
								<option value="${depart.departId }">${depart.departName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>培训内容</td>
					<td colspan="3"><input type="text" name="trainContent"></td>
				</tr>
				<tr><td colspan="4"><input type="submit" value="提交培训内容"></td></tr>
			</table>
		</form>
		
		
		<!-- 查看应聘信息 -->
		<c:if test="${!empty sessionScope.intvinfo }">
			<table name="qIntvInfo" hidden border="2 solid" cellpadding="10" cellspacing="0" style="margin-left: 80px;text-align: center;">
				<tr>
					<td>应聘信息编号</td>
					<td>应聘者编号</td>
					<td>应聘信息提交时间</td>
					<td>应聘信息状态</td>
					<td>查看</td>
					<td>删除</td>
				</tr>
				<c:forEach items="${sessionScope.intvinfo }" var="info">
					<tr>
						<td>${info.intvinfoId }</td>
						<td>${info.intvinfoTorId }</td>
						<td><f:formatDate value="${info.intvinfoSendtime }" pattern="yyyy-MM-dd"/></td>
						<td>${info.intvinfoStatus }</td>
						<td><button class="intvinfoquery" name="${info.intvinfoId }">查看</button></td>
						<td><button class="intvinfoDel" name="${info.intvinfoId }">删除</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	
		<!-- 查询部门 -->
		<table name="qDepartEmp" hidden cellpadding="10" cellspacing="0" style="margin-left: 80px;text-align: center;">
				<c:forEach var="depart" items="${sessionScope.depart }">
					<tr>
						<td width="300"><span name="${depart.departName }">${depart.departName }</span></td>
						<td><button name="${depart.departId }" class="delDepart">Delete</button></td>
						<td><button class="editDepart">Edit</button></td>
						<td hidden>
							<input type="text" name="${depart.departId }">&nbsp<button name="editDepart">提交修改</button>
						</td>
					</tr>
					<c:forEach items="${depart.job }" var="job">
						<tr hidden name="${depart.departName }">
							<td>
								<span name="${job.jobName }" style="color:black">${job.jobName }</span>
							</td>
							<td><button name="${job.jobId }" class="delJob">Delete</button></td>
							<td><button class="editJob">Edit</button></td>
							<td hidden>
								<input type="text" name="${job.jobId }">&nbsp<button name="editJob">提交修改</button>
							</td>
						</tr>
						<tr hidden name="${job.jobName }">
							<td><c:forEach items="${job.emp }" var="emp"><span>${emp.empName }</span>&nbsp</c:forEach></td>
						</tr>
					</c:forEach>
				</c:forEach>
			
		</table>
		
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
				<tr><td colspan="4"><button name="${intv.intvId }" class="del">删除</button>&nbsp<button name="${intv.intvId }" class="edit">编辑</button></td></tr>
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