package com.aowin.model.repair;
//车桩
public class Pile {
	private Integer pile_id;		//车桩id
	private Integer vender_id;		//车桩供应商
	private String pile_code;		//车桩编号	
	private Integer station_id;		//所属车点
	private String status;			//状态
	private String install_time;	//安装日期
	private String disassembly_time;//拆解日期
	private Integer user_id;		//操作人
	private String operator_time;	//操作时间
	private String bicycle_id;		//所存车辆
	private String remark;			//备注
	public Integer getPile_id() {
		return pile_id;
	}
	public void setPile_id(Integer pile_id) {
		this.pile_id = pile_id;
	}
	public Integer getVender_id() {
		return vender_id;
	}
	public void setVender_id(Integer vender_id) {
		this.vender_id = vender_id;
	}
	public String getPile_code() {
		return pile_code;
	}
	public void setPile_code(String pile_code) {
		this.pile_code = pile_code;
	}
	
	public Integer getStation_id() {
		return station_id;
	}
	public void setStation_id(Integer stationId) {
		station_id = stationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInstall_time() {
		return install_time;
	}
	public void setInstall_time(String install_time) {
		this.install_time = install_time;
	}
	public String getDisassembly_time() {
		return disassembly_time;
	}
	public void setDisassembly_time(String disassembly_time) {
		this.disassembly_time = disassembly_time;
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
	public String getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(String bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
