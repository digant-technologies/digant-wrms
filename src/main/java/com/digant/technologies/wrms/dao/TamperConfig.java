package com.digant.technologies.wrms.dao;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tamper_config")
public class TamperConfig {

	private Integer id;
	private String siteId;
	private String alaramName;
	private Timestamp timestamp;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name= "site_id")
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@Column(name= "alarm_name")
	public String getAlaramName() {
		return alaramName;
	}

	public void setAlaramName(String alaramName) {
		this.alaramName = alaramName;
	}

	@Column(name= "timestamp")
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
