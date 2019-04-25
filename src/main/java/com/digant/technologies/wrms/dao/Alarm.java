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
@Table(name = "Alarm")
public class Alarm {

	private Long id;
	private String imei;
	private Boolean di01;
	private Boolean di02;
	private Boolean di03;
	private Boolean di04;
	private Boolean di05;
	private Boolean di06;
	private Boolean di07;
	private Boolean di08;
	private Boolean di09;
	private Boolean di10;
	private Boolean di11;
	private Boolean di12;
	private Boolean di13;
	private Boolean di14;
	private Boolean di15;
	private Boolean di16;
	private Boolean tamper;
	private Date dataTime;
	private Timestamp insertTime;

	@Id
	@GeneratedValue(strategy = IDENTITY)
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

	@Column(name = "di01")
	public Boolean getDi01() {
		return di01;
	}

	public void setDi01(Boolean di01) {
		this.di01 = di01;
	}

	@Column(name = "di02")
	public Boolean getDi02() {
		return di02;
	}

	public void setDi02(Boolean di02) {
		this.di02 = di02;
	}

	@Column(name = "di03")
	public Boolean getDi03() {
		return di03;
	}

	public void setDi03(Boolean di03) {
		this.di03 = di03;
	}

	@Column(name = "di04")
	public Boolean getDi04() {
		return di04;
	}

	public void setDi04(Boolean di04) {
		this.di04 = di04;
	}

	@Column(name = "di05")
	public Boolean getDi05() {
		return di05;
	}

	public void setDi05(Boolean di05) {
		this.di05 = di05;
	}

	@Column(name = "di06")
	public Boolean getDi06() {
		return di06;
	}

	public void setDi06(Boolean di06) {
		this.di06 = di06;
	}

	@Column(name = "di07")
	public Boolean getDi07() {
		return di07;
	}

	public void setDi07(Boolean di07) {
		this.di07 = di07;
	}

	@Column(name = "di08")
	public Boolean getDi08() {
		return di08;
	}

	public void setDi08(Boolean di08) {
		this.di08 = di08;
	}
	
	@Column(name = "di09")
	public Boolean getDi09() {
		return di09;
	}

	public void setDi09(Boolean di09) {
		this.di09 = di09;
	}

	@Column(name = "di10")
	public Boolean getDi10() {
		return di10;
	}

	public void setDi10(Boolean di10) {
		this.di10 = di10;
	}

	@Column(name = "di11")
	public Boolean getDi11() {
		return di11;
	}

	public void setDi11(Boolean di11) {
		this.di11 = di11;
	}

	@Column(name = "di12")
	public Boolean getDi12() {
		return di12;
	}

	public void setDi12(Boolean di12) {
		this.di12 = di12;
	}

	@Column(name = "di13")
	public Boolean getDi13() {
		return di13;
	}

	public void setDi13(Boolean di13) {
		this.di13 = di13;
	}

	@Column(name = "di14")
	public Boolean getDi14() {
		return di14;
	}

	public void setDi14(Boolean di14) {
		this.di14 = di14;
	}

	@Column(name = "di15")
	public Boolean getDi15() {
		return di15;
	}

	public void setDi15(Boolean di15) {
		this.di15 = di15;
	}

	@Column(name = "di16")
	public Boolean getDi16() {
		return di16;
	}

	public void setDi16(Boolean di16) {
		this.di16 = di16;
	}

	@Column(name = "tamper")
	public Boolean getTamper() {
		return tamper;
	}

	public void setTamper(Boolean tamper) {
		this.tamper = tamper;
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
