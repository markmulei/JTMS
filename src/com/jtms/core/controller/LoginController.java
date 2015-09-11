package com.jtms.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jtms.system.staff.model.Staff;

/**
 * 
 * @ClassName: LoginController 
 * @Description: 后台系统登录控制层
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 11:28:41 AM 
 *
 */
@Controller
@RequestMapping("")
public class LoginController extends BaseController {
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 登录
	 * @param sysUser
	 * @return
	 * @return String 
	 * @throws 
	 * @author mulei Jul 31, 2015 11:29:01 AM
	 */
	@RequestMapping("/login")
	public String login(Staff staff) {
		String userName = staff.getName();
		String password = staff.getPassword();
		String url = "";

		if (userName != null && !"".equals(userName) && password != null
				&& !"".equals(password)) {
			if ("admin".equals(userName) && "admin".equals(password)) {
				url = "/index";
			} else {
				getRequest().setAttribute("error", "用户名和密码不正确！");
				url = "/errorMsg";
			}
		} else {
			getRequest().setAttribute("error", "用户名和密码不能为空！");
			url = "/errorMsg";
		}

		String contextPath = getRequest().getServletContext().getContextPath();
		getRequest().setAttribute("contextPath", contextPath);
		return url;
	}
	
	@RequestMapping("/ext")
	public String ext(HttpServletRequest request) {
		request.setAttribute("result", "欢迎进入EXT测试环境");
		return "/ext";
	}

}
