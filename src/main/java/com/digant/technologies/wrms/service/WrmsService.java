/*package com.digant.technologies.wrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digant.technologies.wrms.dao.WrmsAlaram;
import com.digant.technologies.wrms.dao.AlarmRepo;

@Service
public class WrmsService {

	@Autowired
	AlarmRepo wrmsRepo;

	public List<WrmsAlaram> fetchAllWrmsDataBySiteId(int siteId) {

		return wrmsRepo.findAllBySiteId(siteId);
	}

	public List<WrmsAlaram> fetchWrmsDataByImei(int imeiNumber) {

		return wrmsRepo.findAllByImeiNumber(imeiNumber);
	}

	public List<WrmsAlaram> fetchWrmsDataByTimestamp() {

		return wrmsRepo.findAllByOrderByDataTimeDesc();
	}

}
*/