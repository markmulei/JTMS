package com.jtms.core.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jtms.core.service.TreeService;

@Controller
@RequestMapping("/westTree")
public class WestTreeController {

	@Resource
	private TreeService service;

	@RequestMapping("/getTree")
	public void getTree(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<Map<String, Object>> list = service.getTree();
		String json = JSONArray.fromObject(list).toString();
		json = json.substring(2, json.length() - 2);
		json = json.replace("},{", "*");
		renderText(json, response);
	}

	@RequestMapping("/getChildTree")
	public void getChildTree(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		StringBuffer sb = new StringBuffer();
		sb = findChild(id, sb);
		String json = sb.toString();
		if(!"".equals(json) && json != null) {
			json = json.substring(0, json.length() - 1);
			json = "[" + json + "]";
		}
		System.out.println(json);
		renderText(json, response);

	}

	private StringBuffer findChild(String id, StringBuffer sb) {
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

	public static void renderText(final String content,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			Writer writer = response.getWriter();
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
