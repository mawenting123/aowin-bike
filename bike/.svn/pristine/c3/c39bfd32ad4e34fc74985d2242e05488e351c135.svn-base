package com.aowin.dao.report;

import java.util.List;

import com.aowin.model.card.Card;
import com.aowin.model.card.CardRecord;
import com.aowin.model.report.RealTimeCardReport;
import com.aowin.model.report.YearAndMonthCardFeeReport;

public interface IReportDao {
    
	//实时、卡费用统计
	public List<RealTimeCardReport> realTimeReportEachCard(Card card);
	//提供该卡的费用流水，按时间降序排列。
	public List<CardRecord> query_card_record_byid(Card card);
	//月度/年度卡费用统计
	public List<YearAndMonthCardFeeReport> cardFeeReportEachCard(YearAndMonthCardFeeReport query);
	
	
	
	
	
}
