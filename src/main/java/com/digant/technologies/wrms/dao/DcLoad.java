package com.digant.technologies.wrms.dao;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dcload")
public class DcLoad {

	private Long id;
	private String imei;
	private Double load1;
	private Double load2;
	private Double load3;
	private Double load4;
	private Double voltage;
	private Date dataTime;
	private Timestamp insertTime;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "imei")
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Column(name = "load1")
	public Double getLoad1() {
		return load1;
	}

	public void setLoad1(Double load1) {
		this.load1 = load1;
	}

	@Column(name = "load2")
	public Double getLoad2() {
		return load2;
	}

	public void setLoad2(Double load2) {
		this.load2 = load2;
	}

	@Column(name = "load3")
	public Double getLoad3() {
		return load3;
	}

	public void setLoad3(Double load3) {
		this.load3 = load3;
	}

	@Column(name = "load4")
	public Double getLoad4() {
		return load4;
	}

	public void setLoad4(Double load4) {
		this.load4 = load4;
	}

	@Column(name = "voltage")
	public Double getVoltage() {
		return voltage;
	}

	public void setVoltage(Double voltage) {
		this.voltage = voltage;
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
