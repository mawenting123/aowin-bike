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
    
    
    <title>My JSP 'updateCardMess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" href="css/content.css" />
	<script type="text/javascript" src="tool/jquery-1.9.1.min.js"></script>
   <script type="text/javascript">
         $(function(){
             //修改前将该卡号的信息找到
             var card_code_up=location.href.split("=")[1];
             if(card_code_up!=null){
                $("#card_code").val(card_code_up);
                $("#hide_card_code").val(card_code_up);
             $.ajax({
               url:"queryByCode.do",
               data:{"card_code":card_code_up},
               success:function(res){
                  var obj=eval("("+res+")");
                  $("#idcard").val(obj.idcard);
                  $("#card_type").val(obj.card_type);
                  $("#name").val(obj.name);
                  $("#sex").val(obj.sex);
                  $("#telphone").val(obj.telphone);
                  $("#mobile").val(obj.mobile);
                  $("#email").val(obj.email);
                  $("#address").val(obj.address);
                  $("#work").val(obj.work);
                  $("#monthly_money").val(obj.monthly_money);
                  $("#frozen_money").val(obj.frozen_money);
                  $("#wallet_money").val(obj.wallet_money);
                  
               }
             })
           }
             if(${not empty mess}){
                 alert("${mess}");
             }
         })
    
    //获取卡号
    function getCardCode(){
       if($("#card_type").val()=="3"||$("#card_type").val()=="市民卡/社保卡"){
           $("#card_code").val($("#idcard").val());
       }else{
           $("#card_code").val($("#hide_card_code").val());
       }
    }
    
    //跳转至查询页面
    function toQueryWin(){
      location.href="card/queryCard2.jsp";
    }
    //跳转至新增页面
    function toAddWin(){
      location.href="card/addCard.jsp";
    }
    
    </script>

  </head>
  
<body>
<input type="button" style="background:#a5cf4c" value="查询" onclick="toQueryWin()"/>
<input type="button" style="background:#a5cf4c" value="办卡" onclick="toAddWin()"/>
  
<form name="form" method="post" action="updateCardMess.do"/>
<TABLE align="center">

<TR>
    <TD>卡号:</TD>
	<TD>
	  <input type="text" id="card_code" name="card_code" readonly />
	</TD>
</TR>
<TR>
    <TD>卡类型:</TD>
	<TD>
	   <select id="card_type" name="card_type" onchange="getCardCode()">
	    <option value="1">A卡</option>
	    <option value="2">D卡</option>
	    <option value="3">市民卡/社保卡</option>
	    <option value="4">员工卡</option>
	    <option value="5">调度卡</option>
	   </select>
	</TD>
</TR>
<TR>
    <TD>身份证:</TD>
	<TD><input name="idcard" id="idcard" onchange="getCardCode()"/></TD>
</TR>
<TR>
	<TD>姓名:</TD>
	<TD><input name="name" id="name"/></TD>
</TR>
<TR>
	<TD>性别:</TD>
	<TD>
		<SELECT NAME="sex" id="sex">
			<option value="1">男</option>
			<option value="0">女</option>
		</SELECT>
	</TD>
</TR>

<TR>
	<TD>手机:</TD>
	<TD><input name="telphone" id="telphone" /></TD>
</TR>
<TR>
	<TD>固话:</TD>
	<TD><input name="mobile" id="mobile"/></TD>
</TR>
<TR>
	<TD>邮箱:</TD>
	<TD><input name="email" id="email"/></TD>
</TR>
<TR>
	<TD>地址:</TD>
	<TD><input name="address" id="address"/></TD>
</TR>
<TR>
	<TD>工作单位:</TD>
	<TD><input name="work" id="work"/></TD>
</TR>
<TR>
<TR>
	<TD>月票金额:</TD>
	<TD><input name="monthly_money" id="monthly_money"/></TD>
</TR>
<TR>
	<TD>冻结金额:</TD>
	<TD><input name="frozen_money" id="frozen_money"/></TD>
</TR>
<TR>
	<TD>钱包金额:</TD>
	<TD><input name="wallet_money" id= "wallet_money"/></TD>
</TR>
<TR>
	
	<TD><input type="submit" class="sub-btn" value="修改" ></TD>
</TR>
</TABLE>
</form>
<input type="hidden" id="hide_card_code"/>
  </body>
</html>
