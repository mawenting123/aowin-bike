  //获取当前时间
   function getNowTime(){
      var date=new Date();
      var year=date.getFullYear();
      var mon=(date.getMonth()+1)<10?"0"+(date.getMonth()+1):(date.getMonth()+1);
	  var day=date.getDate()<10?"0"+date.getDate():date.getDate();
	  var hour=date.getHours()<10?"0"+date.getHours():date.getHours();
	  var min=date.getMinutes()<10?"0"+date.getMinutes():date.getMinutes();
	  var ss=date.getSeconds()<10?"0"+date.getSeconds():date.getSeconds();
	  return year+"-"+mon+"-"+day+" "+hour+":"+min+":"+ss;
   }