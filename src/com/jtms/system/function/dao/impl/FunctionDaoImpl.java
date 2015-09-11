package com.jtms.system.function.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.dao.impl.BaseDaoImpl;
import com.jtms.system.function.dao.FunctionDao;

/**
 * 
 * @ClassName: FunctionDaoImpl 
 * @Description: TODO
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 2:30:30 PM 
 *
 */
@Repository
public class FunctionDaoImpl extends BaseDaoImpl implements FunctionDao {

	@Override
	public List<Map<String, Object>> getAccordion() throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select s.id as id, ");
		sql.append("s.fun_name as text, ");
		sql.append("s.fun_description as description, ");
		sql.append("s.fun_controller as control, ");
		sql.append("s.fun_layout as layout, ");
		sql.append("s.fun_type as type, ");
		sql.append("s.fun_pid as pid, ");
		sql.append("s.fun_leaf as leaf ");
		sql.append("from SYS_FUNCTION s ");
		sql.append("where s.fun_pid = '0' ");
		return getJdbcTemplate().queryForList(sql.toString());
	}

	@Override
	public List<Map<String, Object>> getChildTree(String id) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select s.id as id, ");
		sql.append("s.fun_name as text, ");
		sql.append("s.fun_controller as control, ");
		sql.append("s.fun_layout AS layout, ");
		sql.append("s.fun_alias AS alias, ");
		sql.append("s.fun_leaf as leaf, ");
		sql.append("s.fun_pid as pid, ");
		sql.append("s.fun_type as type ");
		sql.append("from SYS_FUNCTION s ");
		sql.append("where s.fun_pid = '").append(id).append("' ");
		return getJdbcTemplate().queryForList(sql.toString());
	}

	@Override
	public QueryResult getList(RequestFilter filter) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select * from sys_function ");
		return getResultList(sql.toString(), filter.getFirst(),
				filter.getLimit());
	}

}
