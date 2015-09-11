package com.jtms.system.function.model;

import com.jtms.core.model.BaseModel;

/**
 * 
 * @ClassName: Function
 * @Description: 后台功能表model
 * @author mulei 157799470@qq.com
 * @date Jul 31, 2015 1:40:00 PM
 *
 */
public class Function extends BaseModel {

	private String id;
	private String fun_name;
	private String fun_description;
	private String fun_controller;
	private String fun_type;
	private String fun_pid;
	private String fun_layout;
	private String fun_alias;
	private String fun_leaf;

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
	 * 获取功能点名称
	 */
	public String getFun_name() {
		return fun_name;
	}

	/**
	 * 设置功能点名称
	 * 
	 * @param fun_name
	 */
	public void setFun_name(String fun_name) {
		this.fun_name = fun_name;
	}

	/**
	 * 获取功能描述
	 */
	public String getFun_description() {
		return fun_description;
	}

	/**
	 * 设置功能描述
	 * 
	 * @param fun_description
	 */
	public void setFun_description(String fun_description) {
		this.fun_description = fun_description;
	}

	/**
	 * 获取功能对应的前台Controller组件全名
	 */
	public String getFun_controller() {
		return fun_controller;
	}

	/**
	 * 设置功能对应的前台Controller组件全名
	 * 
	 * @param fun_controller
	 */
	public void setFun_controller(String fun_controller) {
		this.fun_controller = fun_controller;
	}

	/**
	 * 获取功能点类型
	 */
	public String getFun_type() {
		return fun_type;
	}

	/**
	 * 设置功能点类型
	 * 
	 * @param fun_type
	 */
	public void setFun_type(String fun_type) {
		this.fun_type = fun_type;
	}

	/**
	 * 获取功能父节点
	 */
	public String getFun_pid() {
		return fun_pid;
	}

	/**
	 * 设置功能父节点
	 * 
	 * @param fun_pid
	 */
	public void setFun_pid(String fun_pid) {
		this.fun_pid = fun_pid;
	}

	/**
	 * 获取功能对应的前台Layout组件全名
	 */
	public String getFun_layout() {
		return fun_layout;
	}

	/**
	 * 设置功能对应的前台Layout组件全名
	 * 
	 * @param fun_layout
	 */
	public void setFun_layout(String fun_layout) {
		this.fun_layout = fun_layout;
	}

	/**
	 * 获取功能对应的前台Layout组件别名
	 */
	public String getFun_alias() {
		return fun_alias;
	}

	/**
	 * 设置功能对应的前台Layout组件别名
	 * 
	 * @param
	 */
	public void setFun_alias(String fun_alias) {
		this.fun_alias = fun_alias;
	}

	/**
	 * 获取功能点是否为子节点
	 */
	public String getFun_leaf() {
		return fun_leaf;
	}

	/**
	 * 设置功能点是否为子节点
	 * 
	 * @param fun_leaf
	 */
	public void setFun_leaf(String fun_leaf) {
		this.fun_leaf = fun_leaf;
	}

}
