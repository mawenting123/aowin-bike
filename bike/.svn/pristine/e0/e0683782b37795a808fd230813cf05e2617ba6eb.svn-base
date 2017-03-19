<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'bikefee.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="tool/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
   $(function(){
      //显示近10年的下拉年份
      var date=new Date();
      $("select[name='year']").append("<option>请选择</option>");
      var first=date.getFullYear();
      for(var i=9;i>=0;i--){
         $("select[name='year']").append("<option>"+first+"</option>");
         first--;
      }
      //var table=document.getElementById("cardFeeTable");
      //if(table.rows.length==1){
        //location.href="cardFeeReportEachCard.do";
      //}
      $("input[name='card_code']").val("${total_cardFee.card_code}");
      
      $("select[name='year']").val("${total_cardFee.year}");
      $("select[name='month']").val("${total_cardFee.month}");
   })
</script>

</head>

<body>
  <form action="cardFeeReportEachCard.do" method="post">
	<table width="100%" border="1" cellspacing="0" >
		<tr align="center">
			<td colspan="8">月度/年度卡费用统计</td>
		</tr>
	
		<tr align="center">
			<td colspan="8">
			卡编号:<input type="text" name="card_code"/>
			年份：<select name="year"></select>
                               月份：<select name="month">
					<option>请选择</option>
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
			</select> 
			<input type="submit" value="查询">
		</td>
		</tr>
		<tr align="center">
			<td>总充值金额</td>
			<td>总消费金额</td>
			<td>总租车小时数</td>
			<td>总租车次数</td>
			<td>平均租车次数</td>
			<td>平均租车时间数</td>
		</tr>
		<tr align="center">
			<td>${total_cardFee.total_charge_money }</td>
			<td>${total_cardFee.total_rent_money}</td>
			<td>${total_cardFee.total_rent_hour}</td>
			<td>${total_cardFee.total_rent_count}</td>
			<td>${total_cardFee.total_avg_rent_count}</td>
			<td>${total_cardFee.total_avg_rent_hour}</td>
		</tr>
	</table>
	</form>
	<br/><br/>
	<table id="cardFeeTable" border="1px" width="100%" cellspacing="0px" style="table-layout: fixed">
	   <tr align="center">
	      <td>序号</td>
	      <td>卡id</td>
	      <td>卡编号</td>
	      <td>年份</td>
	      <td>月份</td>
	      <td>充值金额</td>
	      <td>消费金额</td>
	      <td>租车次数</td>
	      <td>租车小时数</td>
	      <td>平均租车时间</td>
	   </tr>
	   <c:forEach items="${cardFees}" var="temp" varStatus="i" >
	     <tr align="center">
	        <td>${i.count }</td>
	        <td>${temp.card_id}</td>
	        <td>${temp.card_code}</td>
	        <td>${temp.year}</td>
	        <td>${temp.month}</td>
	        <td>${temp.charge_money }</td>
	        <td>${temp.rent_money}</td>
	        <td>${temp.rent_count}</td>
	        <td>${temp.rent_hour}</td>
	        <td>${temp.avg_rent_hour}</td>
	        
	     </tr>
	   </c:forEach>
	
	</table>
</body>
</html>
