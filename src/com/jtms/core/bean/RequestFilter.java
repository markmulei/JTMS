package com.jtms.core.bean;

import javax.servlet.http.HttpServletRequest;

public class RequestFilter {

	/** 分页起始位置 */
	private int start;
	/** 分页每页数量，默认值为-1，表示不限制 */
	private int limit = -1;
	/** 分页页码，表示第几页 */
	private int page;
	/** 分页起始位置，默认值为-1，表示不限制 */
	private int first = -1;

	//private int count;

	//private StringBuffer sql = null;
	
	public RequestFilter(HttpServletRequest request) {
		if (request.getParameter("start") != null
				&& request.getParameter("limit") != null
				&& request.getParameter("page") != null) {
			this.start = Integer.parseInt(request.getParameter("start"));
			this.limit = Integer.parseInt(request.getParameter("limit"));
			this.page = Integer.parseInt(request.getParameter("page"));
			this.first = (this.page - 1) * this.limit;
		}
		//StringBuffer sb = new StringBuffer();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

}
