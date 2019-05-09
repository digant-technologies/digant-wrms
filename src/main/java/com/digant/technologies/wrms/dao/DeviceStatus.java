package com.digant.technologies.wrms.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Device_Status")
public class DeviceStatus {

	private String imei;
	private Boolean flag;
	private Date dataTime;
	private Date lastDataTime;

	@Id
	@Column(name = "IMEI")
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Column(name = "flag")
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Column(name = "Data_Time")
	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	@Column(name = "Last_Data_Time")
	public Date getLastDataTime() {
		return lastDataTime;
	}

	public void setLastDataTime(Date lastDataTime) {
		this.lastDataTime = lastDataTime;
	}

}
