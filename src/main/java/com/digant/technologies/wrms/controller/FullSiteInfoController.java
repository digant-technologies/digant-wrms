/*package com.digant.technologies.wrms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digant.technologies.wrms.dao.Alarm;
import com.digant.technologies.wrms.dao.FullSiteInfo;
import com.digant.technologies.wrms.service.FullSiteInfoService;
import com.digant.technologies.wrms.utils.DigantConstants;

@RestController
@RequestMapping("/digant/wrms")
public class FullSiteInfoController {

	private static final Logger logger = LoggerFactory.getLogger(FullSiteInfoController.class);
	
	@Autowired
	FullSiteInfoService fullSiteInfoService;
	
	@GetMapping(value = "/fetch/siteInfo")
	public ResponseEntity<?> fetchFullSiteInfo() {
		try {
			logger.info(DigantConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());

			List<FullSiteInfo> obj = fullSiteInfoService.fetchFullSiteInfo();

			logger.info(DigantConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<List<FullSiteInfo>>(obj, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(DigantConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
*/