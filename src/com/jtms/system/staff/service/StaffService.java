package com.jtms.system.staff.service;

import org.springframework.stereotype.Service;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.service.BaseService;

/**
 * 
 * @ClassName: StaffService 
 * @Description: 员工服务层接口
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 1:52:34 PM 
 *
 */
@Service("StaffService")
public interface StaffService extends BaseService {
	
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
	public QueryResult getList(RequestFilter filter) throws Exception;

}
