package com.digant.technologies.wrms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepo extends CrudRepository<Alarm, Integer>{
	
	//List<Alarm> findAllByOrderByDataTimeDesc();
	
	@Query("FROM Alarm WHERE insertTime IN (SELECT MAX(insertTime) FROM Alarm GROUP BY imei)")
	List<Alarm> findAllByOrderByInsertTimeDesc();
}
