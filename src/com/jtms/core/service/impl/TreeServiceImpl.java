package com.jtms.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtms.core.dao.TreeDao;
import com.jtms.core.service.TreeService;

@Service("TreeService")
public class TreeServiceImpl implements TreeService {
	
	@Autowired
	private TreeDao dao;

	@Override
	public List<Map<String, Object>> getTree() {
		List<Map<String, Object>> list = dao.getTree();
		return list;
	}

	@Override
	public List<Map<String, Object>> getChildTree(String id) {
		List<Map<String, Object>> list = dao.getChildTree(id);
		return list;
	}

}
