<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.login{
		position:absolute;
		width:500px;
		height: 400px;
		top: 50%;
		left:50%;
		margin-left: -250px;
		margin-top: -200px;
	}
	font{
		font-weight:bold;
		font-size: 10;
	}
</style>
<script src="${pageContext.request.contextPath }/Js/jquery-1.7.2.js"></script>
<script>
	$(function(){
		var nc=0;
		var pc=0;
		$("input[name=tName]").blur(function(){
			var a=$(this).val();
			if(a.length<6){
				$("span[name=nerr]").show();
				$("span[name=nerr2]").hide();
				$("form[name=info]").attr("onsubmit","return false");
				nc=0;
			}else{
				$("span[name=nerr]").hide();
				$.ajax({
					url:"${pageContext.request.contextPath }/tor/checkName",
					type:"post",
					dataType:"text",
					data:{tN:a},
					success:function(data){
						if(data=="1"){
							$("span[name=nerr2]").hide();
							nc=1;
							if(nc==1 && pc==1){
								$("form[name=info]").attr("onsubmit","return true");
							}
						}else{
							$("span[name=nerr2]").show();
							nc=0;
							$("form[name=info]").attr("onsubmit","return false");
						}
					}
				})
			}
		})
		$("input[name=tPassword]").blur(function(){
			var v=$(this).val();
			if(v.length<6){
				$("span[name=perr]").show();
				pc=0;
				$("form[name=info]").attr("onsubmit","return false");
			}else{
				$("span[name=perr]").hide();
				pc=1;
				if(nc==1 && pc==1){
					$("form[name=info]").attr("onsubmit","return true");
				}
			}
		})
		
	})
</script>
</head>
<body background="${pageContext.request.contextPath }/Picture/p2.jpg" style="background-size: 100%">
	<div class="login" align="center">
		<table cellpadding="10" cellspacing="0" style="text-align:center">
			<tr>
				<td colspan="2"><h1>注册界面</h1></td>
			</tr>
			<form action="${pageContext.request.contextPath }/tor/regist" onsubmit="return false" name="info">
				<tr>
					<td><font>用户名：</font></td>
					<td><input type="text" name="tName"></td>
				</tr>
				<tr><td colspan="2"><span name="nerr" style="color:red" hidden>用户名长度必须大于6位</span><span name="nerr2" style="color:red" hidden>用户名重复</span></td></tr>
				<tr>
					<td><font>密码：</font></td>
					<td><input type="text" name="tPassword"></td>
				</tr>
				<tr><td colspan="2"><span name="perr" style="color:red" hidden>密码长度必须大于6位</span></td></tr>
				<tr><td colspan="2"><input type="submit" value="注册"></td></tr>
			</form>

			<form action="${pageContext.request.contextPath }/tor/back">
				<tr>
					<td colspan="2"><input type="submit" value="返回"></td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>