package com.digant.technologies.wrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digant.technologies.wrms.dao.DeviceConfigRepo;
import com.digant.technologies.wrms.dao.DeviceConfig;

@Service
public class DeviceConfigService {
	
	@Autowired
	DeviceConfigRepo deviceConfigRepo;

	public List<DeviceConfig> fetchDeviceConfigData() {
		
		return deviceConfigRepo.findAllByOrderByInsertTimeDesc();
	}

}
