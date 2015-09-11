package com.jtms.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("TreeService")
public interface TreeService {
	
	public List<Map<String, Object>> getTree();
	
	public List<Map<String, Object>> getChildTree(String id);

}
