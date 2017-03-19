package com.aowin.controller.report;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aowin.model.card.Card;
import com.aowin.model.card.CardRecord;
import com.aowin.model.report.RealTimeCardReport;
import com.aowin.model.report.YearAndMonthCardFeeReport;
import com.aowin.service.report.ReportService;

@Controller
public class ReportController {
   @Autowired
   private ReportService reportService;
   
   //实时、卡费用统计  每张卡的统计总充值金额，总充值次数，总消费金额，现冻结金额，
   //现可用余额，总租车小时数，总租车次数，单次租车时间等信息。
   @RequestMapping("/realTimeReportEachCard.do")
   public String realTimeReportEachCard(Card card,Model model){
	   List<RealTimeCardReport> eachCard=reportService.realTimeReportEachCard(card);
	   Integer total_record_num=0;
	   Float total_charge_money=0.0f;
	   Integer total_charge_count=0;
	   Float total_frozen_money=0.0f;
	   Float total_statin=0.0f;
	   Float total_rent_money=0.0f;
	   Float total_rent_hour=0.0f;
	   Integer total_rent_count=0;
	   for(int i=0;i<eachCard.size();i++){
		   total_record_num+=eachCard.get(i).getRent_record();
		   total_charge_money+=eachCard.get(i).getCharge_money();
		   total_charge_count+=eachCard.get(i).getCharge_count();
		   total_frozen_money+=eachCard.get(i).getFrozen_money();
		   total_statin+=eachCard.get(i).getStatin();
		   total_rent_money+=eachCard.get(i).getRent_money();
		   total_rent_hour+=eachCard.get(i).getRent_hour();
		   total_rent_count+=eachCard.get(i).getRent_count();
	   }
	   RealTimeCardReport total=new RealTimeCardReport();
	   total.setTotal_num(eachCard.size());
	   total.setTotal_charge_count(total_charge_count);
	   total.setTotal_charge_money(total_charge_money);
	   total.setTotal_frozen_money(total_frozen_money);
	   total.setTotal_record_num(total_record_num);
	   total.setTotal_rent_count(total_rent_count);
	   total.setTotal_rent_hour(total_rent_hour);
	   total.setTotal_rent_money(total_rent_money);
	   total.setTotal_statin(total_statin);
	   total.setTotal_record_num (total_record_num);
	   //所有租车卡累计数据
	   model.addAttribute("totalMess", total);
	   //每张租车卡的累计
	   model.addAttribute("eachCard", eachCard);
	   //查询条件
	   model.addAttribute("query_card_code", card.getCard_code());
	   model.addAttribute("query_name", card.getName());
	   return "report/RealTimeCardReport.jsp";
   }
   
    //提供该卡的费用流水，按时间降序排列。
    @RequestMapping("/query_card_record_byid.do")
	public String query_card_record_byid(Card card,Model model){
		List<CardRecord> records=reportService.query_card_record_byid(card);
	    model.addAttribute("records", records);
		return "report/showCardRecord.jsp";
	}
    //月度/年度卡费用统计
    @RequestMapping("/cardFeeReportEachCard.do")
	public String cardFeeReportEachCard(YearAndMonthCardFeeReport query,Model model){
    	//每张卡的月度内，年度内，租车卡的充值金额，消费金额，租车次数，租车时间数，平均租车时间。
		List<YearAndMonthCardFeeReport> cardFees=reportService.cardFeeReportEachCard(query);
		model.addAttribute("cardFees", cardFees);
		//所有卡 月度内，年度内，总充值金额，总消费金额，总租车次数，平均租车次数，总租车时间数，平均租车时间数。
		YearAndMonthCardFeeReport report=new YearAndMonthCardFeeReport();
		Float total_charge_money=0.0f;//月度 年度内所有租车卡的总充值金额
		Float total_rent_money=0.0f;//月度 年度内所有租车卡总消费金额
		Float total_rent_hour=0.0f;//月度 年度内所有租车卡的总租车小时数
		Integer total_rent_count=0;//月度 年度内所有租车卡的总租车次数
		Float total_avg_rent_hour=0.0f;//月度 年度内平均所有租车卡的总租车小时数
		Float total_avg_rent_count=0.0f;//月度 年度内平均所有租车卡的总租车次数
		int len=cardFees.size();
		if(len!=0){
		   for(int i=0;i<len;i++){
			   total_charge_money+=cardFees.get(i).getCharge_money();
			   total_rent_money+=cardFees.get(i).getRent_money();
			   total_rent_hour+=cardFees.get(i).getRent_hour();
			   total_rent_count+=cardFees.get(i).getRent_count();
			   
		   }
		   report.setTotal_charge_money(total_charge_money);
		   report.setTotal_rent_money(total_rent_money);
		   report.setTotal_rent_hour(total_rent_hour);
		   report.setTotal_rent_count(total_rent_count);
		   
		   total_avg_rent_count=total_rent_count*1.0f/len;
		   total_avg_rent_hour=total_rent_hour*1.0f/len;
		   total_avg_rent_count=Float.parseFloat(String.format("%.2f",total_avg_rent_count));
		   total_avg_rent_hour=Float.parseFloat(String.format("%.2f", total_avg_rent_hour));
		   //total_avg_rent_count=(int)((total_avg_rent_count)*100)/100.0f;
		   report.setTotal_avg_rent_count(total_avg_rent_count);
		   report.setTotal_avg_rent_hour(total_avg_rent_hour);
		   
		}
		report.setCard_code(query.getCard_code());
		report.setYear(query.getYear());
		report.setMonth(query.getMonth());
		model.addAttribute("total_cardFee", report);
		return "report/year_month_cardfee.jsp";
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
   public ReportService getReportService() {
	  return reportService;
   }

   public void setReportService(ReportService reportService) {
	  this.reportService = reportService;
   }
   
   
}
