package com.digant.technologies.wrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digant.technologies.wrms.dao.Temperature;
import com.digant.technologies.wrms.dao.TemperatureRepo;

@Service
public class TemperatureService {

	@Autowired
	TemperatureRepo temperatureRepo;

	public List<Temperature> fetchTemperatureData() {

		return temperatureRepo.findAllByOrderByInsertTimeDesc();
	}

}
