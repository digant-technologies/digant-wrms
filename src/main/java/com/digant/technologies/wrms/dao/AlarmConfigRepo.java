package com.digant.technologies.wrms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmConfigRepo extends CrudRepository<AlarmConfig, Integer>{

}
