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
    
    <title>My JSP 'showCardRecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="tool/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	   $(function(){
	      
	   })
	</script>
  </head>
  
  <body>
     <table border="1px" cellspacing="0px" width="100%">
       <tr align="center">
        <th>序号</th>
        <th>卡id</th>
        <th>费用类型</th>
        <th>月票变化金额</th>
        <th>钱包变化金额</th>
        <th>冻结变化金额</th>
        <th>发生时间</th>
        <th>创建人</th>
        <th>备注</th>
        <th>注销标志</th>
       </tr>
       <c:forEach items="${records}" var="temp" varStatus="i">
         <tr align="center">
            <td>${i.count }</td>
	        <td>${temp.card_id }</td>
	        <td>
	        <c:if test="${temp.fee_type==1 }">月票充值</c:if>
	        <c:if test="${temp.fee_type==2 }">钱包充值</c:if>
	        <c:if test="${temp.fee_type==3 }">租车</c:if>
	        <c:if test="${temp.fee_type==4 }">消费</c:if>
	        <c:if test="${temp.fee_type==5 }">提款</c:if>
	        </td>
	        <td>${temp.chg_monthly_money}</td>
	        <td>${temp.chg_wallet_money}</td>
	        <td>${temp.chg_frozen_money}</td>
	        <td>${temp.create_time}</td>
	        <td>${temp.user_id}</td>
	        <td>${temp.remark}</td>
	        <td>
	           <c:if test="${temp.zxbj==1}">是</c:if>
	           <c:if test="${temp.zxbj==0}">否</c:if>
	        </td>
	     </tr>
       </c:forEach>
     </table>
  </body>
</html>
