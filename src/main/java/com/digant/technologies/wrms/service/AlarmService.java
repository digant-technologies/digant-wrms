package com.digant.technologies.wrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digant.technologies.wrms.dao.Alarm;
import com.digant.technologies.wrms.dao.AlarmRepo;

@Service
public class AlarmService {

	@Autowired
	AlarmRepo alarmRepo;
	
	public List<Alarm> fetchAlarmData() {
		
		return alarmRepo.findAllByOrderByInsertTimeDesc();
	}

}
