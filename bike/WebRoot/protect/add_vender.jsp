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
    
    <title>新增供应商</title>
    
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
		function checkAddVender(){
			if(!/^[0-9]{1,12}$/.test($("input[name=registered_capital]").val()) || $("input[name=vender_name]").val()=="" || $("input[name=address]").val()=="" 
			|| $("input[name=telphone]").val()=="" || $("input[name=contacts]").val()=="" 
			|| $("input[name=product_license]").val()=="" || $("input[name=bussiness_registration_no]").val()==""){
				alert("您输入的信息有误");
				return false;
			}else{
				return true;
			}
		}
	</script>
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="welcome.jsp">管理首页</a>><a href="protect/vender.jsp">供应商维护</a>><a href="protect/add_vender.jsp">供应商新增</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<a href="protect/add_vender.jsp" target="content"><input type="button" class="sub-btn" value="新增供应商"></a>
			</div>
			<div class="form-group" align="center" style="color:red ">注有*的为必填</div>
			<div class="public-content-cont">
			<form action="addVender" method="post">
				<div class="form-group">
					<label for="">分类名称</label>
					<select name="vender_type" class="form-select">
						<option value="1">生产商</option>
						<option value="2">供应商</option>
					</select>
				</div>
				<div class="form-group">
					<label for="">名称</label>
					<input class="form-input-txt" type="text" name="vender_name" value="" />
					&nbsp;<span style="color:red">*</span>
				</div>
				<div class="form-group">
					<label for="">地址</label>
					<input class="form-input-txt" type="text" name="address" value=""/>
					&nbsp;<span style="color:red">*</span>
				</div>
				<div class="form-group">
					<label for="">联系电话</label>
					<input class="form-input-txt" type="text" name="telphone" value=""/>
					&nbsp;<span style="color:red">*</span>					
				</div>
				<div class="form-group">
					<label for="">联系人</label>
					<input class="form-input-txt" type="text" name="contacts" value=""/>
					&nbsp;<span style="color:red">*</span>
				</div>
				<div class="form-group">
					<label for="">生产许可证</label>
					<input class="form-input-txt" type="text" name="product_license" value=""/>
					&nbsp;<span style="color:red">*</span>
				</div>
				<div class="form-group">
					<label for="">工商注册号</label>
					<input class="form-input-txt" type="text" name="bussiness_registration_no" value=""/>
					&nbsp;<span style="color:red">*</span>
				</div>
				<div class="form-group">
					<label for="">注册资金</label>
					<input class="form-input-txt" type="text" name="registered_capital" value="0"/>
					&nbsp;<span style="color:red">*</span>
				</div>
				<div class="form-group">
					<label for="">操作人</label>
					<input class="form-input-txt" type="text" name="user_id" value="${syuserExtend.user_id }" readonly />
				</div>
				<div class="form-group">
					<label for="">备注</label>
					<input class="form-input-txt" type="text" name="remark" value=""/>
				</div>
				<div class="form-group" style="margin-left:150px;">
					<input type="submit" class="sub-btn" value="提  交" onclick="return checkAddVender()" />
				</div>
				</form>
				<c:if test="${not empty message}">
					<div style="padding-left:190px;margin-top:20px"><span style="color: red">${message }</span></div>
				</c:if>   
			</div>
		</div>
	</div>
</body>
</html>
