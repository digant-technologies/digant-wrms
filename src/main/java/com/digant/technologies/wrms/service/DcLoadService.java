package com.digant.technologies.wrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digant.technologies.wrms.dao.DcLoad;
import com.digant.technologies.wrms.dao.DcloadRepo;

@Service
public class DcLoadService {

	@Autowired
	DcloadRepo dcloadRepo;

	public List<DcLoad> fetchDcLoadData() {

		//return dcloadRepo.findAllByOrderByInsertTimeDesc();
		return dcloadRepo.findAllByOrderByInsertTimeDesc();

	}

}
