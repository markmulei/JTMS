package com.jtms.system.function.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.service.impl.BaseServiceImpl;
import com.jtms.system.function.dao.FunctionDao;
import com.jtms.system.function.service.FunctionService;

/**
 * 
 * @ClassName: FunctionServiceImpl 
 * @Description: 功能服务层实现类
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 2:26:01 PM 
 *
 */
@Service("FunctionService")
public class FunctionServiceImpl extends BaseServiceImpl implements FunctionService {

	@Autowired
	private FunctionDao dao;

	@Override
	public List<Map<String, Object>> getAccordion() throws Exception{
		return dao.getAccordion();
	}

	@Override
	public List<Map<String, Object>> getChildTree(String id) throws Exception{
		return dao.getChildTree(id);
	}

	@Override
	public QueryResult getList(RequestFilter filter) throws Exception{
		QueryResult qr = dao.getList(filter);
		return qr;
	}

}
