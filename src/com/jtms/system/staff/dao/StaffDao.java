package com.jtms.system.staff.dao;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.dao.BaseDao;

/**
 * 
 * @ClassName: StaffDao 
 * @Description: 员工数据库处理层接口
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 1:57:18 PM 
 *
 */
public interface StaffDao extends BaseDao {
	
	/**
	 * 
	 * @Title: getList 
	 * @Description: 获取员工列表
	 * @param filter
	 * @return
	 * @throws Exception
	 * @return QueryResult 
	 * @throws 
	 * @author mulei Jul 31, 2015 2:03:29 PM
	 */
	public QueryResult getList(RequestFilter filter) throws Exception;

}
