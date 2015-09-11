package com.jtms.core.bean;

import java.util.List;
import java.util.Map;

public class QueryResult {

	private List<Map<String, Object>> resultList;

	private Long total;

	public List<Map<String, Object>> getResultList() {
		return resultList;
	}

	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
