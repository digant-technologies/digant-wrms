package com.digant.technologies.wrms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digant.technologies.wrms.dao.Alarm;
import com.digant.technologies.wrms.service.AlarmService;
import com.digant.technologies.wrms.utils.DigantConstants;

@RestController
@RequestMapping("/digant/wrms")
public class AlarmController {

	private static final Logger logger = LoggerFactory.getLogger(AlarmController.class);

	@Autowired
	AlarmService alarmService;

	@GetMapping(value = "/fetch/alaram/data")
	public ResponseEntity<?> fetchAlarmData() {
		try {
			logger.info(DigantConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());

			java.util.List<Alarm> alarm = alarmService.fetchAlarmData();

			logger.info(DigantConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<java.util.List<Alarm>>(alarm, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(DigantConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
