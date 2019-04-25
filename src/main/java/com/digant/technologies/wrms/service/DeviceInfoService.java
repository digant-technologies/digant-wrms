package com.digant.technologies.wrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digant.technologies.wrms.dao.DeviceInfo;
import com.digant.technologies.wrms.dao.DeviceInfoRepo;

@Service
public class DeviceInfoService {
	
	@Autowired
	DeviceInfoRepo deviceInfoRepo;

	public List<DeviceInfo> fetchdeviceInfoData() {

		return deviceInfoRepo.findAllByOrderByInsertTimeDesc();
	}

}
