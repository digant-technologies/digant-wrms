package com.digant.technologies.wrms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceConfigRepo extends CrudRepository<DeviceConfig, Integer>{

	List<DeviceConfig> findAllByOrderByInsertTimeDesc();

	
}
