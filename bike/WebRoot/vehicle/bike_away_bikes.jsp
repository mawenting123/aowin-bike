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
           //显示"此卡非员工卡,不能调出车辆" 等提示信息
           if(${not empty mess}){
              alert("${mess}");
           }
           //该车桩的所有车辆  因服务器转发  再次回到该页面  数据不再在model里了  需要重新查询
           var table=document.getElementById("bikesTable");
           if(table.rows.length==1){
              if(${not empty old_pile_id}){
                  var pile_id="${old_pile_id}";
              }
              location.href="queryBikeMessageByPileId_status3.do?pile_id="+pile_id;
           }
        })
    
        //function bike_away(old_pile_id,bicycle_code){
        //alert(bicycle_code);
          // var card_code=window.prompt("请输入卡号");
          // if(card_code!=""&&card_code!=null){
           //  location.href="ifEmployeeCard.do?card_code="+card_code+"&old_pile_id="+old_pile_id+"&bicycle_code="+bicycle_code;
           //}
       //}
        function bike_away(index){
           var card_code=window.prompt("请输入卡号");
           if(card_code!=""&&card_code!=null){
             $("input[name='card_code']").val(card_code);
             var forms=$("form[name='form_away']")[index];
             forms.submit();
           }
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
        <c:forEach items="${bikes}" var="temp" varStatus="i">
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
             <form action="bike_away.do" name="form_away">
               <input type="button" value="调出" onclick="bike_away(${i.index})" />
               <input type="hidden" name="card_code"/>
               <input type="hidden" name="pile_id" value="${temp.pile_id}"/>
               <input type="hidden" name="bicycle_id" value="${temp.bicycle_id}"/>
               <input type="hidden" name="bicycle_code" value="${temp.bicycle_code}"/>
               <input type="hidden" name="user_id" value="1001"/>
             </form>
             </td>
          </tr>
        </c:forEach>
        
     </table>
  </body>
</html>
