package com.jtms.core.dao;

import com.jtms.core.bean.QueryResult;

public interface BaseDao {

	public QueryResult getResultList(String sql, int firstNo, int limitNo, String orderBy) throws Exception;

	public QueryResult getResultList(String sql, int firstNo, int limitNo) throws Exception;

	public QueryResult getResultList(String sql, String whereSql) throws Exception;

	public QueryResult getResultList(String sql) throws Exception;

	public <T> void saveModel(T model) throws Exception;

	public <T> T findModelById(T model, String id) throws Exception;

	public <T> void updateModel(T model) throws Exception;

	public <T> int deleteModel(T model, String ids) throws Exception;

}
