package com.jtms.system.function.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.bean.RequestFilter;
import com.jtms.core.controller.BaseController;
import com.jtms.core.util.GuidUtil;
import com.jtms.system.function.model.Function;
import com.jtms.system.function.service.FunctionService;

/**
 * 
 * @ClassName: FunctionController
 * @Description: 系统功能点
 * @author mulei 157799470@qq.com
 * @date Jul 31, 2015 11:09:40 AM
 *
 */
@Controller
@RequestMapping("/function")
public class FunctionController extends BaseController {

	@Resource
	private FunctionService service;

	/**
	 * 
	 * @Title: getAccordion
	 * @Description: 获取导航菜单栏
	 * @param response
	 * @return void
	 * @throws
	 * @author mulei Jul 31, 2015 11:09:03 AM
	 */
	@RequestMapping("/getAccordion")
	public void getAccordion(HttpServletResponse response) throws Exception {
		List<Map<String, Object>> list = service.getAccordion();
		String json = JSONArray.fromObject(list).toString();
		json = json.substring(2, json.length() - 2);
		json = json.replace("},{", "*");
		renderText(json, response);
	}

	/**
	 * 
	 * @Title: getChildTree
	 * @Description: 获得每个菜单栏的功能树
	 * @param response
	 * @return void
	 * @throws
	 * @author mulei Jul 31, 2015 11:08:40 AM
	 */
	@RequestMapping("/getChildTree")
	public void getChildTree(HttpServletResponse response) throws Exception {
		String id = getRequest().getParameter("id");
		StringBuffer sb = new StringBuffer();
		sb = findChild(id, sb);
		String json = sb.toString();
		if (!"".equals(json) && json != null) {
			json = json.substring(0, json.length() - 1);
			json = "[" + json + "]";
		}
		renderText(json, response);
	}

	/**
	 * 
	 * @Title: findChild
	 * @Description: 递归查询子节点
	 * @param id
	 * @param sb
	 * @return StringBuffer
	 * @throws
	 * @author mulei Jul 31, 2015 11:07:24 AM
	 */
	private StringBuffer findChild(String id, StringBuffer sb) throws Exception {
		List<Map<String, Object>> list = service.getChildTree(id);
		Map<String, Object> map;
		for (int i = 0; i < list.size(); i++) {
			map = new HashMap<String, Object>();
			map = list.get(i);
			String json = JSONArray.fromObject(map).toString();
			json = json.substring(1, json.length() - 2);
			sb.append(json);
			if ("false".equals(map.get("leaf"))) {
				sb.append(",children:[");
				sb = findChild(map.get("id").toString(), sb);
				sb.append("]},");
			} else {
				sb.append("},");
			}
		}
		return sb;
	}

	/**
	 * 
	 * @Title: list
	 * @Description: 功能列表显示
	 * @param response
	 * @return void
	 * @throws
	 * @author mulei Jul 31, 2015 11:06:31 AM
	 */
	@RequestMapping("/list")
	public void list(HttpServletResponse response) throws Exception {
		RequestFilter filter = new RequestFilter(getRequest());
		QueryResult qr = service.getList(filter);
		listToJson(qr, response);
	}

	/**
	 * 
	 * @Title: save
	 * @Description: 功能保存
	 * @param response
	 * @param function
	 * @return void
	 * @throws
	 * @author mulei Jul 31, 2015 11:06:02 AM
	 */
	@RequestMapping("/save")
	public void save(HttpServletResponse response, Function function)  throws Exception {
		try {
			// 判断主键是否为空
			if ("".equals(function.getId()) || function.getId() == null) {
				Function pf;
				if ("".equals(function.getFun_pid()) || function.getFun_pid() == null) {
					function.setFun_pid("0");
				} else {
					pf = service.findById(function, function.getFun_pid());
					pf.setFun_leaf("false");
					service.update(pf);
				}
				// 设置主键
				function.setId(GuidUtil.generate());
				// 设置创建时间
				function.setCreate_date(new Date());
				// 设置创建人
				function.setCreater("admin");
				service.save(function);
			} else {
				Function pf;
				if ("".equals(function.getFun_pid()) || function.getFun_pid() == null || "0".equals(function.getFun_pid())) {
					function.setFun_pid("0");
				} else {
					pf = service.findById(function, function.getFun_pid());
					pf.setFun_leaf("false");
					service.update(pf);
				}
				// 设置修改时间
				function.setUpdate_date(new Date());
				// 设置修改人
				function.setUpdater("admin");
				service.update(function);
			}
			toWrite("{success:true, msg:'保存成功'}", response);
		} catch (Exception e) {
			toWrite("{failure:true, msg:'保存失败，请联系管理员！'}", response);
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: remove 
	 * @Description: 功能删除
	 * @param response
	 * @throws Exception
	 * @return void 
	 * @throws 
	 * @author mulei Aug 3, 2015 3:47:22 PM
	 */
	@RequestMapping("/remove")
	public void remove(HttpServletResponse response)  throws Exception {
		try {
			String ids = getRequest().getParameter("data");
			Function funciton = new Function();
			int i = service.deleteModel(funciton, ids);
			if (i > 0) {
				toWrite("{success:true, msg:'删除成功'}", response);
			} else {
				toWrite("{success:true, msg:'删除失败，请联系管理员！'}", response);
			}
		} catch (Exception e) {
			toWrite("{failure:true, msg:'删除失败，请联系管理员！'}", response);
			e.printStackTrace();
		}
	}
	
}
