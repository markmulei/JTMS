package com.jtms.system.department.model;

import com.jtms.core.model.BaseModel;

/**
 * 
 * @ClassName: Department
 * @Description: 组织机构表model
 * @author mulei 157799470@qq.com
 * @date Aug 5, 2015 4:28:43 PM
 *
 */
public class Department extends BaseModel {

	private String id;
	private String dep_number;
	private String dep_name;
	private String dep_status;
	private String dep_pid;
	private String dep_tel;
	private String dep_remark;

	/**
	 * 获取主键
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置主键
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取部门编号
	 */
	public String getDep_number() {
		return dep_number;
	}

	/**
	 * 设置主键
	 * 
	 * @param id
	 */
	public void setDep_number(String dep_number) {
		this.dep_number = dep_number;
	}

	/**
	 * 获取部门名称
	 */
	public String getDep_name() {
		return dep_name;
	}

	/**
	 * 设置部门名称
	 * 
	 * @param dep_name
	 */
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	/**
	 * 获取状态
	 */
	public String getDep_status() {
		return dep_status;
	}

	/**
	 * 设置状态
	 * 
	 * @param dep_status
	 */
	public void setDep_status(String dep_status) {
		this.dep_status = dep_status;
	}

	/**
	 * 获取部门父节点
	 */
	public String getDep_pid() {
		return dep_pid;
	}

	/**
	 * 设置部门父节点
	 * 
	 * @param dep_pid
	 */
	public void setDep_pid(String dep_pid) {
		this.dep_pid = dep_pid;
	}

	/**
	 * 获取部门电话
	 */
	public String getDep_tel() {
		return dep_tel;
	}

	/**
	 * 设置部门电话
	 * 
	 * @param dep_tel
	 */
	public void setDep_tel(String dep_tel) {
		this.dep_tel = dep_tel;
	}

	/**
	 * 获取备注
	 */
	public String getDep_remark() {
		return dep_remark;
	}

	/**
	 * 设置备注
	 * 
	 * @param dep_remark
	 */
	public void setDep_remark(String dep_remark) {
		this.dep_remark = dep_remark;
	}

}
