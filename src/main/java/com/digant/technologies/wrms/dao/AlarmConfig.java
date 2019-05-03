package com.digant.technologies.wrms.dao;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alarm_config")
public class AlarmConfig {

	private Integer id;
	private String siteId;
	private String alarms;
	private String alarmName;
	private Timestamp timestamp;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "site_id")
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@Column(name = "alarms")
	public String getAlarms() {
		return alarms;
	}

	public void setAlarms(String alarms) {
		this.alarms = alarms;
	}

	@Column(name = "alarm_names")
	public String getAlarmName() {
		return alarmName;
	}

	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

	@Column(name = "timestamp")
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
