<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>供应商维护</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/public.css" />
	<link rel="stylesheet" href="css/content.css" />
	<script type="text/javascript" src="tool/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//paging(1);
			var message = '${message}';
			if(message!=''){
				alert(message);
			}
		});
		
		/* function paging(pageCode){
			$("#venderPage").load("showVender?pageCode="+pageCode+"&vender_type"+$("select[name=vender_type]").val()+
			"&zxbj="+$("select[name=zxbj]").val()+"&vender_name="+$("input[name=vender_name]").val()+
			"&startTime="+$("input[name=startTime]").val()+"&endTime="+$("input[name=endTime]").val());
		} */
		
		function updateVenderZXBJ(vender_id){
			var flag = window.confirm("确认要注销吗？");
			if(flag){
				window.location.href="updateVenderZXBJ?vender_id="+vender_id;
			}
		}
		
		function recoverVenderZXBJ(vender_id){
			var flag = window.confirm("确认要恢复吗？");
			if(flag){
				window.location.href="recoverVenderZXBJ?vender_id="+vender_id;
			}
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="welcome.jsp">管理首页</a>><a href="protect/vender.jsp">供应商维护</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<a href="protect/add_vender.jsp" target="content"><input type="button" class="sub-btn" value="新   增"></a>
			</div>
			<div class="public-content-cont two-col">
				<div class="public-cont-left">
					<div class="public-cont-title">
						<h3>查询</h3>
					</div>
					<form action="queryVender.do" method="post">
						<div class="form-group">
							<label for="">分类名称</label>
							<select name="vender_type" class="form-select">
								<option value=""></option>
								<option value="1">生产商</option>
								<option value="2">供应商</option>
							</select>
						</div>
						<div class="form-group">
							<label for="">注销标识</label>
							<select name="zxbj" class="form-select">
								<option value=""></option>
								<option value="1">已注销</option>
								<option value="0">正常</option>
							</select>
						</div>
						<div class="form-group">
							<label for="">供应商名称</label>
							<input type="text" class="form-select" name="vender_name"/>
						</div>
						<div class="form-group">
						<label for="">开始时间</label>
						<input name="startTime" class="form-select" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
						</div>
						<div class="form-group">
						<label for="">截止时间</label>
						<input name="endTime" class="form-select" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
						</div>
						<div class="form-group mt0" style="text-align:center;margin-top:15px;">
							<input type="submit" class="sub-btn" value="提   交">
						</div>
					</form>
				</div>
				<div id="venderPage">
				</div>
			</div>
		</div>
	</div>
	
	
	
	<script src="kingediter/kindeditor-all-min.js"></script>
	<script src="js/laydate.js"></script>
	<script>
		 KindEditor.ready(function(K) {
	               window.editor = K.create('#editor_id');
	        });
	</script>
</body>
</html>
