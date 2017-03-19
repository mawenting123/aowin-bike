package com.aowin.service.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.card.ICardDao;
import com.aowin.dao.card.IChargeDao;
import com.aowin.model.card.Card;
import com.aowin.model.card.CardInfoRecord;
import com.aowin.model.card.CardRecord;

@Service
public class ChargeCardService {
	@Autowired
	private IChargeDao chargeDao;
	
	//月票首充不低于50元   判断是否是当月首充
	public List<CardRecord> ifFirstMonthly(String card_id){
		List<CardRecord> list=chargeDao.ifFirstMonthly(card_id);
		return list;
	}
	
	//月票充值 
	@Transactional(propagation=Propagation.REQUIRED)
    public void charge_mon(Card card,CardRecord record) throws Exception{
    	chargeDao.updateMoney(card);
    	//卡费用流水 
    	//费用变动类型  1 月票充值
    	record.setFee_type(1);
    	record.setChg_monthly_money(card.getMonthly_money());
    	if(record.getChg_wallet_money()==null){
    		record.setChg_wallet_money(0.0);
    	}
    	if(record.getChg_frozen_money()==null){
    		record.setChg_frozen_money(0.0);
    	}
    	chargeDao.chargeAddCard_record(record);
    }
    
    
    //钱包充值 
	@Transactional(propagation=Propagation.REQUIRED)
    public void charge_no_mon(Card card,CardRecord record) throws Exception{
    	chargeDao.updateMoney(card);
    	//卡费用流水 
    	//费用变动类型  1 月票充值  2钱包充值
    	record.setFee_type(2);
    	record.setChg_wallet_money(card.getWallet_money());
    	if(record.getChg_monthly_money()==null){
    		record.setChg_monthly_money(0.0);
    	}
    	if(record.getChg_frozen_money()==null){
    		record.setChg_frozen_money(0.0);
    	}
    	chargeDao.chargeAddCard_record(record);
    }
	
	
	
	
	
	
	
	
	
	public IChargeDao getChargeDao() {
		return chargeDao;
	}
	public void setChargeDao(IChargeDao chargeDao) {
		this.chargeDao = chargeDao;
	}

	
	
	
	
}
