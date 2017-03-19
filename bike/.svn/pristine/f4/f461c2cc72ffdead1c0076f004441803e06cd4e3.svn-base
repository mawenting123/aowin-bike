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
    
    <title>My JSP 'RealTimeCardReport.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	     table{table-layout: fixed;}
	</style>
	<script type="text/javascript" src="tool/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" >
	   $(function(){
	      var table=document.getElementById("eachCardMessTable");
	      var len=table.rows.length;
	      if(len==1){
	         //location.href="realTimeReportEachCard.do";
	      }
	     
	   })
	   //提供该卡的费用流水，按时间降序排列。
	   function showCardRecord(obj){
	      window.open("query_card_record_byid.do?card_id="+obj,'_blank','width=900,height=400,top=200,left=200,location=no,scrollbars=yes,resizable=yes');
	   }
	</script>

  </head>
  
  <body>
       <form action="realTimeReportEachCard.do" method="post" > 
          卡编号<input type="text" name="card_code" value="${query_card_code}"/>
          姓名<input type="text" name="name" value="${query_name }"/>
          <input type="submit" value="查询"/>
       </form>
      
       <table id="totalCardMessTable" width="100%" border="1px" cellspacing="0px">
         <tr align="center">
             <th>租车卡总张数</th><td>${totalMess.total_num}</td>
	         <th>总充值金额</th><td>${totalMess.total_charge_money}</td>
	         <th>总充值次数</th><td>${totalMess.total_charge_count}</td>
	     </tr>
         <tr align="center">
	         <th>总消费金额</th><td>${totalMess.total_rent_money}</td>
	         <th>总租车次数</th><td>${totalMess.total_rent_count}</td>
	         <th>总租车小时数</th><td>${totalMess.total_rent_hour}</td>
	     </tr>
         <tr align="center">
	         <th>有租车记录卡张数</th><td>${totalMess.total_record_num}</td>
	         <th>现冻结金额</th><td>${totalMess.total_frozen_money}</td>
	         <th>现可用余额</th><td>${totalMess.total_statin}</td>
         </tr>
         
        </table>
        <br/><br/>
       <table id="eachCardMessTable" width="100%" border="1px" cellspacing="0px">
         <tr align="center">
	         <th>序号</th>
	         <th>卡id</th>
	         <th>卡编号</th>
	         <th>姓名</th>
	         <th>身份证号</th>
	         <th>充值金额</th>
	         <th>充值次数</th>
	         <th>消费金额</th>
	         <th>租车次数</th>
	         <th>租车小时数</th>
	         <th>租车记录</th>
	         <th>现冻结金额</th>
	         <th>现可用余额</th>
         </tr>
         <c:forEach items="${eachCard}" var="temp" varStatus="i">
           <tr align="center" onclick="showCardRecord(${temp.card_id })">
             <td>${i.count }</td>
	         <td>${temp.card_id }</td>
	         <td>${temp.card_code }</td>
	         <td>${temp.name}</td>
	         <td>${temp.idcard}</td>
	         <td>${temp.charge_money}</td>
	         <td>${temp.charge_count}</td>
	         <td>${temp.rent_money}</td>
	         <td>${temp.rent_count}</td>
	         <td>${temp.rent_hour}</td>
	         <td>
	           <c:if test="${temp.rent_record==1}">有</c:if>
	           <c:if test="${temp.rent_record==0}">无</c:if>
	         </td>
	         <td>${temp.frozen_money}</td>
	         <td>${temp.statin}</td>
           
           </tr>
         </c:forEach>
       </table>
  </body>
</html>
