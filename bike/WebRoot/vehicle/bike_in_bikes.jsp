<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bike_away_bikes.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="tool/jquery-1.9.1.min.js"></script>
    <script type="text/javascript"><!--
        $(function(){
           if(${not empty mess}){
              alert("${mess}");
           }
           //该车桩的所有车辆  
           var table=document.getElementById("bikesTable");
           if(table.rows.length==1){
              location.href="queryAllBike_status4.do";
           }
           
        })
       
        //点击车桩  进入显示所有无车车桩的显示页面
        function bike_in(bicycle_id,bicycle_code){
        alert(bicycle_code);
            location.href="queryAllPileMessage_status2.do?bicycle_id="+bicycle_id+"&bicycle_code="+bicycle_code;
        }
       
    --></script>
  </head>
  
  <body>
     <table width="100%" border="1px" cellspacing=0 id="bikesTable">
        <tr align="center">
          <td>序号</td>
          <td>车辆id</td>
          <td>车辆编号</td>
          <td>状态</td>
          <td>所在车桩</td>
          <td>操作人</td>
          <td>操作时间</td>
          <td>租车卡id</td>
          <td>备注</td>
          <td>操作</td>
        </tr>
        <c:forEach items="${infos}" var="temp" varStatus="i">
          <tr align="center">
             <td>${i.count }</td>
             <td>${temp.bicycle_id}</td>
             <td>${temp.bicycle_code}</td>
             <td>
               <c:if test="${temp.status==1}">购入未入桩</c:if>
               <c:if test="${temp.status==2}">借出</c:if>
               <c:if test="${temp.status==3}">在桩</c:if>
               <c:if test="${temp.status==4}">普通调出</c:if>
               <c:if test="${temp.status==5}">维修调出</c:if>
               <c:if test="${temp.status==6}">报废</c:if>
               <c:if test="${temp.status==7}">维修调入</c:if>
               <c:if test="${temp.status==8}">普通调入</c:if>
             </td>
             <td>${temp.pile_id}</td>
             <td>${temp.user_id}</td>
             <td>${temp.operator_time}</td>
             <td>${temp.card_id}</td>
             <td>${temp.remark}</td>
             <td>
               <input type="button" value="车桩" onclick="bike_in(${temp.bicycle_id},'${temp.bicycle_code}')" />
             </td>
          </tr>
        </c:forEach>
        
     </table>
  </body>
</html>
