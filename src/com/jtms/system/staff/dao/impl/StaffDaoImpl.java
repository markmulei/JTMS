package com.jtms.system.staff.dao.impl;

import org.springframework.stereotype.Repository;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.dao.impl.BaseDaoImpl;
import com.jtms.system.staff.dao.StaffDao;

/**
 * 
 * @ClassName: StaffDaoImpl
 * @Description: 员工数据库处理层实现类
 * @author mulei 157799470@qq.com
 * @date Jul 31, 2015 2:07:18 PM
 *
 */
@Repository
public class StaffDaoImpl extends BaseDaoImpl implements StaffDao {

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
	@Override
	public QueryResult getList(RequestFilter filter) throws Exception {
		StringBuffer sql = new StringBuffer("select * from SYS_STAFF s ");
		StringBuffer orderBy = new StringBuffer("order by s.create_date desc ");
		return getResultList(sql.toString(), filter.getFirst(), filter.getLimit(), orderBy.toString());
	}

}
