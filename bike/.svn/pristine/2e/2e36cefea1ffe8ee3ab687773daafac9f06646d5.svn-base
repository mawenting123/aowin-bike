<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bike_away.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="tool/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
         $(function(){
           //显示"调出成功" 等提示信息
           if(${not empty mess}){
              alert("${mess}");
           }
           var table=document.getElementById("pileTable");
           if(table.rows.length==1){
             location.href="queryAllPileMessage.do";
           }
           //if(location.href.split(".")[1]=="jsp"){
             //location.href="queryAllPileMessage.do";
           //}
            
         })
         
         //选择某一车桩的车辆 进入调出页面
         function showBikes(pile_id){
            location.href="queryBikeMessageByPileId_status3.do?pile_id="+pile_id;
         }
         
    </script>
  </head>
  
  <body>
   
	<table width="100%" border="1px" cellspacing=0 id="pileTable">
		<tr align="center" >
			<td>序号</td>
			<td>车桩id</td>
			<td>车桩编号</td>
			<td>所属车点</td>
			<td>状态</td>
			<td>安装日期</td>
			<td>操作人</td>
			<td>操作时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${piles}" var="temp" varStatus="i">
		  <tr align="center">
			<td>${i.count}</td>
			<td>${temp.pile_id}</td>
			<td>${temp.pile_code}</td>
			<td>${temp.station_id}</td>
			<td>
               <c:if test="${temp.status==1}">有车</c:if>
               <c:if test="${temp.status==2}">无车</c:if>
               <c:if test="${temp.status==9}">报废</c:if>
            </td>
			<td>${temp.install_time}</td>
			<td>${temp.user_id}</td>
			<td>${temp.operator_time}</td>
			<td>
			<c:if test="${temp.status==1}">
			   <input type="button" value="车辆" onclick="showBikes(${temp.pile_id})">
			</c:if>
			</td>
		</tr>
		</c:forEach>
		
	</table>
  </body>
</html>
