package com.digant.technologies.wrms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DcloadRepo extends CrudRepository<DcLoad, Integer>{

//	List<DcLoad> findAllByOrderByInsertTimeDesc();
//	
//	List<DcLoad> findTop25ByOrderByInsertTimeDesc();

	@Query("FROM DcLoad WHERE insertTime IN (SELECT MAX(insertTime) FROM DcLoad GROUP BY imei)")
	List<DcLoad> findAllByOrderByInsertTimeDesc();
}
