package com.jtms.core.service;

import org.springframework.stereotype.Service;

import com.jtms.core.dao.BaseDao;

@Service("BaseService")
public interface BaseService extends BaseDao {

	public <T> void save(T model) throws Exception;

	public <T> T findById(T model, String id) throws Exception;
	
	public <T> void update(T model) throws Exception;
	
	public <T> int remove(T model, String ids) throws Exception;

}
