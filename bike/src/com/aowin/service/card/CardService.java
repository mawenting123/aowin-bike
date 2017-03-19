package com.aowin.service.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.card.ICardDao;
import com.aowin.model.card.Card;
import com.aowin.model.card.CardInfoRecord;
import com.aowin.model.card.CardRecord;
@Service
public class CardService {
	@Autowired
	private ICardDao cardDao;
	
	//办卡时先判断该卡号是否已存在
	public Card checkCardCode(Card card){
		Card c=cardDao.queryByCardCode(card);
		return c;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void addCard(Card card,CardInfoRecord info) throws Exception{
		cardDao.addCard(card);
		info.setCard_id(card.getCard_id());
		info.setInfo_type(1); //写入卡信息记录表 变动类型是新增
		cardDao.addInfoRecord(info);
	}
	
	//一进入新增页面就显示下一个卡号
	public int selCardCode(){
		int cardCode=cardDao.selNextCardCode();
		return cardCode;
	}
	
	//根据条件查询卡信息
	public List<Card> queryCards(Card card){
		List<Card> cards=cardDao.queryCards(card);
		return cards;
	}
	//修改前先查询出该卡号的所有信息
	public Card queryByCode(String card_code){
		Card card=new Card();
		card.setCard_code(card_code);
		Card c=cardDao.queryByCardCode(card);
		return c;
	}
	//修改办卡信息
	public boolean updateOneCard(Card card){
		int m=cardDao.updateOneCard(card);
		return m>0?true:false;
	}
	
	 //卡挂失
	 @Transactional(propagation=Propagation.REQUIRED)
	 public void reportLossCard(CardInfoRecord info) throws Exception{
		info.setInfo_type(2); //写入卡信息记录表 变动类型是挂失
		cardDao.reportLossCard(info);
		cardDao.addInfoRecord(info);
		
	 }
	 
	 
	 //卡注销
	 @Transactional(propagation=Propagation.REQUIRED)
	 public void cancellationCard(CardRecord record,CardInfoRecord info) throws Exception{
		 record.setFee_type(5); //卡注销时 费用类型是提款
		 info.setInfo_type(3);   //卡注销时变动类型是注销卡
		 cardDao.addCard_record(record);
		 cardDao.addInfoRecord(info);
		 cardDao.cancellation_card(record);
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	   
	
	public ICardDao getCardDao() {
		return cardDao;
	}
	public void setCardDao(ICardDao cardDao) {
		this.cardDao = cardDao;
	}

}
