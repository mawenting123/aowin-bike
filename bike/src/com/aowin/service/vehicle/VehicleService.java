package com.aowin.service.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.aowin.dao.card.ICardDao;
import com.aowin.dao.vehicle.IVehicleDao;
import com.aowin.model.card.Card;
import com.aowin.model.repair.Deal;
import com.aowin.model.repair.Deploy;
import com.aowin.model.repair.Info;
import com.aowin.model.repair.Pile;


@Service
public class VehicleService {
   @Autowired
   private IVehicleDao bikeDao;
   @Autowired
   private ICardDao cardDao;
   
   //调出
   
   
   /*1 车辆调出  查询所有车桩信息 */
   public List<Pile> queryAllPileMessage(){
	   Pile pile=new Pile();
	   pile.setStatus(null);
	   List<Pile> piles=bikeDao.queryAllPileMessageByStatus(pile);
	   return piles;
   }
   /*1 车辆调出 查询在桩  且车辆销毁日期为空的车辆 */
   public List<Info> queryBikeMessageByPileId_status3(Pile pile){
	   List<Info> bikes=bikeDao.queryBikeMessageByPileId_status3(pile);
	   return bikes;
   }
   
   //员工卡才能调出  根据卡号判断 判断卡类型是否是4 员工卡
   public Card ifEmployeeCard(Card card){
	   Card c=bikeDao.ifEmployeeCard(card);
	   return c;
   }
   
   //车辆调出  1业务流水 2车辆调配明细 3车辆信息 4车桩
   @Transactional(propagation=Propagation.REQUIRED)
   public void bike_away(Card card,Info info,Pile pile,Deploy deploy,Deal deal) throws Exception{
	   Card getCard=cardDao.queryByCardCode(card);
	   //info
	   info.setStatus("4"); //车辆状态 4:普通调出
	   info.setPile_id(null);  //车辆所在车桩改为空
	   //pile
	   pile.setStatus("2"); //车桩状态 2:无车
	   
	   //deploy
	   deploy.setBicycle_id(info.getBicycle_id());
	   deploy.setFrom_pile_id(pile.getPile_id());
	   deploy.setFrom_card_id(getCard.getCard_id());
	   deploy.setFrom_reason("4");
	   
	   bikeDao.updateBicycleStatus(info);
	   bikeDao.updatePileStatus(pile);
	   bikeDao.addBicyleDeploy(deploy);
	   //deal
	   deal.setDeal_name("普通调出");
	   deal.setDeal_type("4");
	   deal.setRecord_id(deploy.getDeploy_id());
	   deal.setCard_id(getCard.getCard_id());
	   deal.setBicycle_id(info.getBicycle_id());
	   deal.setPile_id(pile.getPile_id());
	   
	   bikeDao.addBicyleDeal(deal);
    } 
   
   
   
   
   
   //调入
   
   //车辆调入首页 显示所有状态是普通调出的车辆
   public List<Info> queryAllBike_status4(){
	  List<Info> infos= bikeDao.queryAllBike_status4();
	  return infos;
   }
   
   //显示所有无车的车桩信息 
   public List<Pile> queryAllPileMessage_status2(){
	   Pile pile=new Pile();
	   pile.setStatus("2");
	   List<Pile> piles=bikeDao.queryAllPileMessageByStatus(pile);
	   return piles;
   }
   
   //车辆调入 1业务流水 2车辆调配明细 3车辆信息 4车桩
   @Transactional(propagation=Propagation.REQUIRED)
   public void bike_in(Card card,Info info,Pile pile,Deploy deploy,Deal deal) throws Exception{
	   Card getCard=cardDao.queryByCardCode(card);
	   //info
	   info.setStatus("8");  //车辆状态 8普通调入
	   info.setPile_id(pile.getPile_id());  //所在车桩
	   bikeDao.updateBicycleStatus(info);
	   //pile
	   pile.setStatus("1");
	   bikeDao.updatePileStatus(pile);
	   //deploy
	   deploy.setBicycle_id(info.getBicycle_id());
	   deploy.setTo_pile_id(pile.getPile_id());
	   deploy.setTo_card_id(getCard.getCard_id());
	   deploy.setTo_reason("5");
	   bikeDao.addBicyleDeploy(deploy);
	   //deal
	   deal.setDeal_name("普通调入");
	   deal.setDeal_type("5");
	   deal.setRecord_id(deploy.getDeploy_id());
	   deal.setCard_id(getCard.getCard_id());
	   bikeDao.addBicyleDeal(deal);
   }
   
   
   
   
   public IVehicleDao getBikeDao() {
	  return bikeDao;
   }

   public void setBikeDao(IVehicleDao bikeDao) {
	  this.bikeDao = bikeDao;
   }
   public ICardDao getCardDao() {
	  return cardDao;
   }
   public void setCardDao(ICardDao cardDao) {
	  this.cardDao = cardDao;
   }
   
   
   
}
