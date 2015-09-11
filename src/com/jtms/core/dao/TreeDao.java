package com.jtms.core.dao;

import java.util.List;
import java.util.Map;

public interface TreeDao {
	
	public List<Map<String, Object>> getTree();
	
	public List<Map<String, Object>> getChildTree(String id);

}
