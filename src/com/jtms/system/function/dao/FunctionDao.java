package com.jtms.system.function.dao;

import java.util.List;
import java.util.Map;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.dao.BaseDao;

/**
 * 
 * @ClassName: FunctionDao 
 * @Description: 功能数据库处理层接口
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 2:26:53 PM 
 *
 */
public interface FunctionDao extends BaseDao {

	/**
	 * 
	 * @Title: getAccordion 
	 * @Description: 获得导航菜单栏节点
	 * @return
	 * @return List<Map<String,Object>> 
	 * @throws 
	 * @author mulei Jul 31, 2015 2:27:16 PM
	 */
	public List<Map<String, Object>> getAccordion() throws Exception;

	/**
	 * 
	 * @Title: getChildTree 
	 * @Description: 获得功能字节点
	 * @param id
	 * @return
	 * @return List<Map<String,Object>> 
	 * @throws 
	 * @author mulei Jul 31, 2015 2:27:31 PM
	 */
	public List<Map<String, Object>> getChildTree(String id) throws Exception;

	/**
	 * 
	 * @Title: getList 
	 * @Description: 获得功能列表
	 * @param filter
	 * @return
	 * @return QueryResult 
	 * @throws 
	 * @author mulei Jul 31, 2015 2:28:02 PM
	 */
	public QueryResult getList(RequestFilter filter) throws Exception;

}
