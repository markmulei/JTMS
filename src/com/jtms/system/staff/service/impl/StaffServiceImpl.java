package com.jtms.system.staff.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.service.impl.BaseServiceImpl;
import com.jtms.system.staff.dao.StaffDao;
import com.jtms.system.staff.service.StaffService;

/**
 * 
 * @ClassName: StaffServiceImpl 
 * @Description: 员工服务层实现类
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 2:17:23 PM 
 *
 */
@Service("StaffService")
public class StaffServiceImpl extends BaseServiceImpl implements StaffService {
	
	@Autowired
	private StaffDao staffDao;

	/**
	 * 
	 * @Title: getList 
	 * @Description: 获取员工列表
	 * @param filter
	 * @return
	 * @return QueryResult 
	 * @throws 
	 * @author mulei Jul 31, 2015 1:52:08 PM
	 */
	@Override
	public QueryResult getList(RequestFilter filter) throws Exception {
		QueryResult qr = staffDao.getList(filter);
		return qr;
	}


}
