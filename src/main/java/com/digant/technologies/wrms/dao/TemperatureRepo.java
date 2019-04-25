package com.digant.technologies.wrms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepo extends CrudRepository<Temperature, Integer>{

	//List<Temperature> findAllByOrderByInsertTimeDesc();
	
	@Query("FROM Temperature WHERE insertTime IN (SELECT MAX(insertTime) FROM Temperature GROUP BY imei)")
	List<Temperature> findAllByOrderByInsertTimeDesc();
}
