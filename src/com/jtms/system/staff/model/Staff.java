package com.jtms.system.staff.model;

import java.util.Date;

import com.jtms.core.model.BaseModel;

/**
 * 
 * @ClassName: Staff 
 * @Description: 员工实体类
 * @author mulei 157799470@qq.com 
 * @date Jul 31, 2015 12:22:52 PM 
 *
 */
public class Staff extends BaseModel {

	private String id;
	private String name;
	private String password;
	private String sex;
	private String real_name;
	private Date birthday;
	private String address;
	private String tel;
	private String mobile;
	private String qq;
	private String email;
	private int level;
	private String status;

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
	 * 获取员工登录名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置员工登录名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取员工密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置员工密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取员工性别
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置员工性别
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取员工真实姓名
	 */
	public String getReal_name() {
		return real_name;
	}

	/**
	 * 设置员工真实姓名
	 * 
	 * @param real_name
	 */
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	/**
	 * 获取员工生日
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 设置员工生日
	 * 
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 获取员工住址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置员工住址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取员工家庭电话
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置员工家庭电话
	 * 
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 获取员工手机号
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置员工手机号
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取员工QQ
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * 设置QQ
	 * 
	 * @param qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * 获取员工电子邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置电子邮件
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取员工级别
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * 设置员工级别
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 获取状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置状态
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
