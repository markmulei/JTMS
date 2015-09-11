package com.jtms.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.util.JsonDateValueProcessor;

@Controller
@RequestMapping("/base")
public class BaseController {

	/**
	 * 获得request
	 * 
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获得Session
	 * 
	 * @return HttpSession
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/getModelFields")
	public String getModelFields(HttpServletResponse response) {
		String modelName = getRequest().getParameter("modelName");
		try {
			// 获得类（根据实体全路径获得类<反射>）
			Class clazz = Class.forName(modelName);
			// 获得字段集合
			Field[] fields = clazz.getDeclaredFields();
			Field[] sub_fields = clazz.getSuperclass().getDeclaredFields();
			StringBuffer sb = new StringBuffer("[");
			for (int i = 0; i < fields.length; i++) {
				sb.append("{name:'").append(fields[i].getName()).append("',type:'auto'},");
			}
			for (int i = 0; i < sub_fields.length; i++) {
				sb.append("{name:'").append(sub_fields[i].getName()).append("',type:'auto'},");
			}
			sb.replace(sb.toString().length() - 1, sb.toString().length(), "]");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println(sb.toString());
			pw.flush();
			pw.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将list转成JSON格式，传到前台
	 * 
	 * @param qr
	 * @param response
	 */
	public void listToJson(QueryResult qr, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		try {
			Writer writer = response.getWriter();
			String json = "";
			if (qr.getResultList() != null && qr.getResultList().size() > 0) {
				JsonConfig jsonConfig = registerJsonValueProcessor(qr.getResultList().get(0));
				json = JSONArray.fromObject(qr.getResultList(), jsonConfig).toString();
			}
			StringBuffer gridJson = new StringBuffer("{\"total\":\"" + qr.getTotal() + "\",\"topics\":");
			gridJson.append(json).append("}");
			writer.write(gridJson.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: registerJsonValueProcessor
	 * @Description: 通过map将所有value为Date的key，作为jsonConfig的过滤条件进行设置
	 * @param map
	 * @return
	 * @throws Exception
	 * @return JsonConfig
	 * @throws
	 * @author mulei Jul 31, 2015 5:03:35 PM
	 */
	private JsonConfig registerJsonValueProcessor(Map<String, Object> map) throws Exception {
		JsonConfig jsonConfig = new JsonConfig();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			if (map.get(key) instanceof Date) {
				jsonConfig.registerJsonValueProcessor(key, new JsonDateValueProcessor("yyyy-MM-dd"));
			}
		}
		return jsonConfig;
	}

	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> s1 = new HashMap<String, Object>();
		s1.put("name", "jim");
		s1.put("age", "15");
		s1.put("time", new Date());
		list.add(s1);
		Map<String, Object> s2 = new HashMap<String, Object>();
		s2.put("name", "lucy");
		s2.put("age", "12");
		s2.put("time", new Date());
		list.add(s2);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSONArray jo = JSONArray.fromObject(list, jsonConfig);
		System.out.println("json:" + jo.toString());
	}

	/**
	 * 将JSON数据传到前台
	 * 
	 * @param content
	 * @param response
	 * @throws IOException
	 */
	public void renderText(String content, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			Writer writer = response.getWriter();
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	protected void toWrite(String content, HttpServletResponse response) {
		if (null != response) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = null;
			try {
				writer = response.getWriter();
				writer.write(content);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				writer.flush();
				writer.close();
			}
		}
	}

}
