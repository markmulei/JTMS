package com.jtms.system.staff.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.controller.BaseController;
import com.jtms.system.staff.service.StaffService;

/**
 * 
 * @ClassName: StaffController 
 * @Description: 员工控制层
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 1:49:12 PM 
 *
 */
@Controller
@RequestMapping("/staff")
public class StaffController extends BaseController {
	
	@Resource
	private StaffService staffService;
	
	/**
	 * 
	 * @Title: list 
	 * @Description: 获取员工列表
	 * @param response
	 * @return void 
	 * @throws 
	 * @author mulei Jul 31, 2015 2:22:16 PM
	 */
	@RequestMapping("/list")
	public void list(HttpServletResponse response) throws Exception {
		RequestFilter filter = new RequestFilter(getRequest());
		QueryResult qr = staffService.getList(filter);
		listToJson(qr, response);
	}
	
}
