package com.jtms.core.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BaseModel {

	private String creater;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date create_date;

	private String updater;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date update_date;

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

}
