package com.digant.technologies.wrms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digant.technologies.wrms.dao.DeviceConfig;
import com.digant.technologies.wrms.service.DeviceConfigService;
import com.digant.technologies.wrms.utils.DigantConstants;

@RestController
@RequestMapping("/digant/wrms")
public class DeviceConfigController {

	private static final Logger logger = LoggerFactory.getLogger(DeviceConfigController.class);

	@Autowired
	DeviceConfigService deviceConfigService;

	@GetMapping(value = "/fetch/deviceConfig/data")
	public ResponseEntity<?> fetchDcLoadData() {
		try {
			logger.info(DigantConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());

			java.util.List<DeviceConfig> deviceConfiguration = deviceConfigService.fetchDeviceConfigData();

			logger.info(DigantConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<java.util.List<DeviceConfig>>(deviceConfiguration, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(DigantConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
