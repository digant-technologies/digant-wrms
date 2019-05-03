package com.digant.technologies.wrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digant.technologies.wrms.dao.Alarm;
import com.digant.technologies.wrms.dao.AlarmRepo;
import com.digant.technologies.wrms.dao.ImeiConfig;
import com.digant.technologies.wrms.dao.ImeiConfigRepo;

@Service
public class AlarmService {

	@Autowired
	AlarmRepo alarmRepo;
	
	@Autowired
	ImeiConfigRepo imeiConfigRepo;
	
	public List<Alarm> fetchAlarmData() {
		
		return alarmRepo.findAllByOrderByInsertTimeDesc();
	}

	public ImeiConfig updateImeiConfig(ImeiConfig imeiConfig) {
		
		return imeiConfigRepo.save(imeiConfig);
	}

	public List<ImeiConfig> fetchSiteIds() {

		return imeiConfigRepo.findAll();
	}

}
