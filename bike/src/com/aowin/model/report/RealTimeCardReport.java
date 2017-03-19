package com.aowin.model.report;

public class RealTimeCardReport {
   private Integer total_num;//所有租车卡的总张数
   private Integer total_record_num;//所有租车卡的有租车记录张数
   private Float total_charge_money;//所有租车卡的总充值金额
   private Integer total_charge_count;//所有租车卡的总充值次数
   private Float total_frozen_money;//所有租车卡的总现冻结金额
   private Float total_statin;//所有租车卡的总现可用余额
   private Float total_rent_money;//所有租车卡总消费金额
   private Float total_rent_hour;//所有租车卡的总租车小时数
   private Integer total_rent_count;//所有租车卡的总租车次数
   
   private Integer card_id;
   private String card_code;
   private String name;
   private String idcard;
   private Integer rent_record;//有租车记录
   private Float charge_money;//单张租车卡的总充值金额
   private Integer charge_count;//单张租车卡的总充值次数
   private Float frozen_money;//单张租车卡的总现冻结金额
   private Float statin;//单张租车卡的总现可用余额
   private Float rent_money;//单张租车卡总消费金额
   private Float rent_hour;//单张租车卡的总租车小时数
   private Integer rent_count;//单张租车卡的总租车次数
   
   public RealTimeCardReport() {
	super();
   }

public Integer getTotal_num() {
	return total_num;
}

public void setTotal_num(Integer totalNum) {
	total_num = totalNum;
}

public Integer getTotal_record_num() {
	return total_record_num;
}

public void setTotal_record_num(Integer totalRecordNum) {
	total_record_num = totalRecordNum;
}

public Float getTotal_charge_money() {
	return total_charge_money;
}

public void setTotal_charge_money(Float totalChargeMoney) {
	total_charge_money = totalChargeMoney;
}

public Integer getTotal_charge_count() {
	return total_charge_count;
}

public void setTotal_charge_count(Integer totalChargeCount) {
	total_charge_count = totalChargeCount;
}

public Float getTotal_frozen_money() {
	return total_frozen_money;
}

public void setTotal_frozen_money(Float totalFrozenMoney) {
	total_frozen_money = totalFrozenMoney;
}

public Float getTotal_statin() {
	return total_statin;
}

public void setTotal_statin(Float totalStatin) {
	total_statin = totalStatin;
}

public Float getTotal_rent_money() {
	return total_rent_money;
}

public void setTotal_rent_money(Float totalRentMoney) {
	total_rent_money = totalRentMoney;
}

public Float getTotal_rent_hour() {
	return total_rent_hour;
}

public void setTotal_rent_hour(Float totalRentHour) {
	total_rent_hour = totalRentHour;
}

public Integer getTotal_rent_count() {
	return total_rent_count;
}

public void setTotal_rent_count(Integer totalRentCount) {
	total_rent_count = totalRentCount;
}

public Integer getCard_id() {
	return card_id;
}

public void setCard_id(Integer cardId) {
	card_id = cardId;
}

public String getCard_code() {
	return card_code;
}

public void setCard_code(String cardCode) {
	card_code = cardCode;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getIdcard() {
	return idcard;
}

public void setIdcard(String idcard) {
	this.idcard = idcard;
}

public Integer getRent_record() {
	return rent_record;
}

public void setRent_record(Integer rentRecord) {
	rent_record = rentRecord;
}

public Float getCharge_money() {
	return charge_money;
}

public void setCharge_money(Float chargeMoney) {
	charge_money = chargeMoney;
}

public Integer getCharge_count() {
	return charge_count;
}

public void setCharge_count(Integer chargeCount) {
	charge_count = chargeCount;
}

public Float getFrozen_money() {
	return frozen_money;
}

public void setFrozen_money(Float frozenMoney) {
	frozen_money = frozenMoney;
}

public Float getStatin() {
	return statin;
}

public void setStatin(Float statin) {
	this.statin = statin;
}

public Float getRent_money() {
	return rent_money;
}

public void setRent_money(Float rentMoney) {
	rent_money = rentMoney;
}

public Float getRent_hour() {
	return rent_hour;
}

public void setRent_hour(Float rentHour) {
	rent_hour = rentHour;
}

public Integer getRent_count() {
	return rent_count;
}

public void setRent_count(Integer rentCount) {
	rent_count = rentCount;
}
    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
