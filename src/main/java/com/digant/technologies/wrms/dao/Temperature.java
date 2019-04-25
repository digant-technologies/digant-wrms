package com.digant.technologies.wrms.dao;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Temperature")
public class Temperature {

	private BigInteger id;
	private String imei;
	private Float degreeC;
	private Date dataTime;
	private Timestamp insertTime;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = "imei")
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Column(name = "degreeC")
	public Float getDegreeC() {
		return degreeC;
	}

	public void setDegreeC(Float degreeC) {
		this.degreeC = degreeC;
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
