package com.digant.technologies.wrms.dao;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Device_Info")
public class DeviceInfo {
	
	private String imei;
	private String hwv;
	private String fwv;
	private String simNumber;
	private Integer simSlot;
	private Integer signal;
	private String mobile;
	private Date dataTime;
	private Timestamp insertTime;

	@Id
	@Column(name = "imei")
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Column(name = "hwv")
	public String getHwv() {
		return hwv;
	}

	public void setHwv(String hwv) {
		this.hwv = hwv;
	}

	@Column(name = "fwv")
	public String getFwv() {
		return fwv;
	}

	public void setFwv(String fwv) {
		this.fwv = fwv;
	}

	@Column(name = "simno")
	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	@Column(name = "simslot")
	public Integer getSimSlot() {
		return simSlot;
	}

	public void setSimSlot(Integer simSlot) {
		this.simSlot = simSlot;
	}

	@Column(name = "signal_strength")
	public Integer getSignal() {
		return signal;
	}

	public void setSignal(Integer signal) {
		this.signal = signal;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "DataTime")
	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	@Column(name = "InsertTime")
	public Timestamp getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}


}
