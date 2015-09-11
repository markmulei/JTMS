package com.jtms.system.function.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.service.BaseService;

/**
 * 
 * @ClassName: FunctionService 
 * @Description: 功能服务层接口
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 2:26:08 PM 
 *
 */
@Service("FunctionService")
public interface FunctionService extends BaseService {

	/**
	 * 
	 * @Title: getAccordion
	 * @Description: 获取导航菜单栏
	 * @return
	 * @return List<Map<String,Object>>
	 * @throws
	 * @author mulei Jul 31, 2015 2:23:57 PM
	 */
	public List<Map<String, Object>> getAccordion() throws Exception;

	/**
	 * 
	 * @Title: getChildTree
	 * @Description: 递归查询功能子节点
	 * @param id
	 * @return
	 * @return List<Map<String,Object>>
	 * @throws
	 * @author mulei Jul 31, 2015 2:24:01 PM
	 */
	public List<Map<String, Object>> getChildTree(String id) throws Exception;

	/**
	 * 
	 * @Title: getList
	 * @Description: 功能列表显示
	 * @param filter
	 * @return
	 * @return QueryResult
	 * @throws
	 * @author mulei Jul 31, 2015 2:24:05 PM
	 */
	public QueryResult getList(RequestFilter filter) throws Exception;

}
