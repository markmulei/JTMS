package com.jtms.core.service.impl;

import org.springframework.stereotype.Service;

import com.jtms.core.dao.impl.BaseDaoImpl;
import com.jtms.core.service.BaseService;

@Service("BaseService")
public class BaseServiceImpl extends BaseDaoImpl implements BaseService {

	@Override
	public <T> void save(T model) throws Exception {
		saveModel(model);
	}

	@Override
	public <T> T findById(T model, String id) throws Exception {
		return findModelById(model, id);
	}

	@Override
	public <T> void update(T model) throws Exception {
		updateModel(model);
	}

	@Override
	public <T> int remove(T model, String ids) throws Exception {
		return deleteModel(model, ids);
	}

}
