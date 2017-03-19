<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>供应商信息</title>
    
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
	<style type="text/css">
		#tab{margin: auto; }
		th{border: 2px solid;  width: 115px; }
		td{border: 2px solid; text-align: center;}
		a{ }
	</style>
	
  </head>
  
  <body align="center" class="public-content">
	<table id="tab" class="public-content-cont">
		<tr>
			<th>供应商编号</th>
			<th>名称</th>
			<th>地址</th>
			<th>联系电话</th>
			<th>联系人</th>
			<th>生产许可证</th>
			<th>工商注册号</th>
			<th>注销标识</th>
			<th>操作</th>
		</tr>		
		<c:forEach items="${venders}" var="temp">
			<tr>
				<td>${temp.vender_code }</td>
				<td>${temp.vender_name }</td>
				<td>${temp.address }</td>
				<td>${temp.telphone }</td>
				<td>${temp.contacts }</td>
				<td>${temp.product_license }</td>
				<td>${temp.bussiness_registration_no }</td>
				<td><c:if test="${temp.zxbj=='0' }">正常</c:if>
					<c:if test="${temp.zxbj=='1' }">已注销</c:if>
				</td>
				<td>
					<div class="table-fun">
						<a href="showUpdateVender?vender_id=${temp.vender_id }">修改</a>
						<c:if test="${temp.zxbj == '0'}">
							<a onclick="updateVenderZXBJ('${temp.vender_id}')">注销</a>
						</c:if>
						<c:if test="${temp.zxbj == '1'}">
							<a onclick="recoverVenderZXBJ('${temp.vender_id}')">恢复</a>
						</c:if>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>

	<div class="page" align="center">
		<input type="button" value="首页" class="sub-btn" onclick="paging(1)" />
		<c:if test="${bpage.pageCode > 1 }">
			<input type="button" value="上一页" class="sub-btn"
				onclick="paging(${bpage.pageCode-1})" />
		</c:if>
		<c:if test="${bpage.pageCode < bpage.totalPage }">
			<input type="button" value="下一页" class="sub-btn"
				onclick="paging(${bpage.pageCode+1 })" />
		</c:if>
		<input type="button" value="末页" class="sub-btn"
			onclick="paging(${bpage.totalPage})" /> 第<span
			style="color:red;font-weight:600">${bpage.pageCode }</span>页 共<span
			style="color:red;font-weight:600">${bpage.totalPage }</span>页
	</div>

</body>
</html>
