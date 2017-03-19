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
           if(${not empty mess}){
              alert("${mess}");
           }
           
           //var table=document.getElementById("pileTable");
           //if(table.rows.length==1){
             //location.href="queryAllPileMessage_status2.do";
           //}
          })
         
         function bike_in(index){
           var card_code=window.prompt("请输入卡号");
           if(card_code!=""&&card_code!=null){
             $("input[name='card_code']").val(card_code);
             var forms=$("form[name='form_in']")[index];
             forms.submit();
           }
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
			<c:if test="${temp.status==2}">
			  <form action="bike_in.do" name="form_in">
               <input type="button" value="调入" onclick="bike_in(${i.index})">
               <input type="hidden" name="card_code"/>
               <input type="hidden" name="pile_id" value="${temp.pile_id}"/>
               <input type="hidden" name="bicycle_id" value="${bicycle_id}"/>
               <input type="hidden" name="bicycle_code" value="${bicycle_code}"/>
               <input type="hidden" name="user_id" value="1001"/>
              </form>
			   
			</c:if>
			</td>
		</tr>
		</c:forEach>
		
	</table>
  </body>
</html>
