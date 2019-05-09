package com.digant.technologies.wrms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepo extends CrudRepository<Alarm, Integer>{
	
	//List<Alarm> findAllByOrderByDataTimeDesc();
	
	@Query("FROM Alarm WHERE insertTime IN (SELECT MAX(insertTime) FROM Alarm GROUP BY imei)")
	List<Alarm> findAllByOrderByInsertTimeDesc();

	/*select * from Device_Status  where  Last_Data_Time >= (NOW() - INTERVAL 5 MINUTE)*/

	@Query(value = "select distinct  a.imei, a.di01, a.di02, a.di03, a.di04, a.di05, a.di06, a.di07, a.di08,\n" + 
			"a.di09 , a.di10 , a.di11 , a.di12 , a.di13, a.di14, a.di15, a.di16, d.voltage, t.degreec,\n" + 
			"s.site_id, s.site_name, s.circle_name, ds.flag, ds.Last_Data_Time, i.signal_strength, a.InsertTime\n" + 
			" from Alarm as a, Dcload as d , Temperature as t, site_info as s, Device_Status as ds, Device_Info as i\n" + 
			" where\n" + 
			" a.InsertTime IN (select max(am.InsertTime) from Alarm as am group by am.imei) \n" + 
			" and d.InsertTime in (select max(dl.InsertTime) from Dcload as dl group by dl.imei)\n" + 
			" and t.InsertTime in (select max(tm.InsertTime) from Temperature as tm group by tm.imei)\n" + 
			" and s.timestamp in (select max(si.timestamp) from site_info as si group by si.imei)\n" + 
			" and a.imei = d.imei and d.imei = t.imei and d.imei = s.imei and d.imei = ds.imei and d.imei = i.imei", nativeQuery = true)
	List<Object[]> findAll(@Param(value = "name") String name);
	
	
}

