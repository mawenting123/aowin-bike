package com.aowin.model.repair;

public class Record {
	private Integer record_id;		//记录id
	private Integer bicycle_id;		//车辆id
	private String repair_type;		//修理类型
	private String repair_part;		//修理部位
	private String repair_result;	//修理结果
	private Integer fee;			//修理费用
	private String repairer;		//修理人
	private String repair_date;		//修理日期
	private String remark;			//备注
	private Integer user_id;		//创建人
	private String operator_time;	//创建时间
	public Integer getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}
	public Integer getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(Integer bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getRepair_type() {
		return repair_type;
	}
	public void setRepair_type(String repair_type) {
		this.repair_type = repair_type;
	}
	public String getRepair_part() {
		return repair_part;
	}
	public void setRepair_part(String repair_part) {
		this.repair_part = repair_part;
	}
	public String getRepair_result() {
		return repair_result;
	}
	public void setRepair_result(String repair_result) {
		this.repair_result = repair_result;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public String getRepairer() {
		return repairer;
	}
	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}
	public String getRepair_date() {
		return repair_date;
	}
	public void setRepair_date(String repair_date) {
		this.repair_date = repair_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getOperator_time() {
		return operator_time;
	}
	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}
	
}
