package com.aowin.dao.vehicle;

import java.util.List;

import com.aowin.model.card.Card;
import com.aowin.model.repair.Deal;
import com.aowin.model.repair.Deploy;
import com.aowin.model.repair.Info;
import com.aowin.model.repair.Pile;

public interface IVehicleDao {
	//调出
	
	/*1 车辆调出  查询所有车桩信息 2pile.status=2 显示所有无车的车桩信息 */
    public List<Pile> queryAllPileMessageByStatus(Pile pile);
    /*1 车辆调出 查询在桩  且车辆销毁日期为空的车辆 */
    public List<Info> queryBikeMessageByPileId_status3(Pile pile);
    //员工卡才能调出  根据卡号判断 判断卡类型是否是4 员工卡
    public Card ifEmployeeCard(Card card);
    
    //被选中的车辆的车辆状态改成（4：普通调出）
    public int updateBicycleStatus(Info bike);
    //将所在车桩的状态改成  调入时改为 1：有车 。 调出时改为（2：无车） 
    public int updatePileStatus(Pile pile);
    //车辆调配明细，调入的内容可以不填写，调出原因填写（4：普通调出）
    public int addBicyleDeploy(Deploy deploy);
    
    //车辆业务流水，业务类型为（4：普通调出），关联的业务记录id填写车辆调配明细id，
    //业务名称填写(普通调出)，是否发生费用为（0：未发生），费用金额填0。
    public int addBicyleDeal(Deal deal);
    
    //调入
    //车辆调入首页 显示所有状态是普通调出的车辆
    public List<Info> queryAllBike_status4();
    //显示所有无车的车桩信息 
    //public List<Pile> queryAllPileMessage_status2();
    
    
}
