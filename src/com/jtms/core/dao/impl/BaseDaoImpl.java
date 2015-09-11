package com.jtms.core.dao.impl;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jtms.core.bean.QueryResult;
import com.jtms.core.dao.BaseDao;
import com.jtms.core.util.PropertiesUtils;
import com.jtms.system.function.model.Function;

/**
 * 数据库操作层基类
 * 
 * @author 穆磊
 *
 */
@Repository
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/** 设置一些操作的常量 */
	public static final String SQL_INSERT = "insert";
	public static final String SQL_UPDATE = "update";
	public static final String SQL_DELETE = "delete";

	/**
	 * 获取分页结果集对象
	 * 
	 * @param sql
	 *            执行的SQL语句
	 * @param firstNo
	 *            分页其实位置
	 * @param limitNo
	 *            每页显示条数
	 * @param orderBy
	 *            SQL排序语句
	 * @return QueryResult 查询结果集
	 * 
	 */
	@Override
	public QueryResult getResultList(String sql, int firstNo, int limitNo, String orderBy) throws Exception {
		QueryResult qr = new QueryResult();
		StringBuffer sb = new StringBuffer(sql);
		if (orderBy != null) {
			sb.append(orderBy);
		}
		qr.setTotal(getTotal(sb.toString()));
		if (firstNo != -1 && limitNo != -1) {
			sb.append(" LIMIT ").append(firstNo).append(",").append(limitNo);
		}
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sb.toString());
		qr.setResultList(list);
		return qr;
	}

	/**
	 * 获取分页结果集对象
	 * 
	 * @param sql
	 *            执行的SQL语句
	 * @param firstNo
	 *            分页其实位置
	 * @param limitNo
	 *            每页显示条数
	 * @return QueryResult 查询结果集
	 * 
	 */
	@Override
	public QueryResult getResultList(String sql, int firstNo, int limitNo) throws Exception {
		return getResultList(sql, firstNo, limitNo, null);
	}

	/**
	 * 获取分页结果集对象
	 * 
	 * @param sql
	 *            执行的SQL语句
	 * @param orderBy
	 *            SQL排序语句
	 * @return QueryResult 查询结果集
	 * 
	 */
	@Override
	public QueryResult getResultList(String sql, String orderBy) throws Exception {
		return getResultList(sql, -1, -1, orderBy);
	}

	/**
	 * 获取分页结果集对象
	 * 
	 * @param sql
	 *            执行的SQL语句
	 * @return QueryResult 查询结果集
	 * 
	 */
	@Override
	public QueryResult getResultList(String sql) throws Exception {
		return getResultList(sql, -1, -1, null);
	}

	/**
	 * 获取查询结果集总条数
	 * 
	 * @param sql
	 *            执行的SQL语句
	 * @return long 返回条数
	 * 
	 * @author 穆磊
	 */
	private Long getTotal(String sql) throws Exception {
		Long total = (long) 0;
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		if (list != null && list.size() > 0) {
			total = (long) list.size();
		}
		return total;
	}

	/**
	 * 保存数据
	 * 
	 * @param entity
	 *            Model类对象
	 * 
	 * @author 穆磊
	 */
	@Override
	public <T> void saveModel(T model) throws Exception {
		String sql = this.makeSql(SQL_INSERT, model);
		Object[] args = this.setParams(model, SQL_INSERT);
		int[] argTypes = this.setParamTypes(model, SQL_INSERT);
		getJdbcTemplate().update(sql, args, argTypes);
	}

	/**
	 * 通过id获得对象model
	 * 
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T findModelById(T model, String id) throws Exception {
		StringBuffer sql = new StringBuffer();
		Class<T> clazz = (Class<T>) model.getClass();
		String className = clazz.getSimpleName();
		className = PropertiesUtils.getTableNameByProperties(className);
		Field[] fields = clazz.getDeclaredFields();
		String column = "id";
		if (fields[0].getName().indexOf("id") != -1) {
			column = fields[0].getName();
		}
		sql.append("SELECT * FROM " + className + " WHERE " + column + "=?");
		RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(clazz);
		return getJdbcTemplate().query(sql.toString(), rowMapper, id).get(0);
	}

	public <T> void updateModel(T model) throws Exception {
		String sql = this.makeSql(SQL_UPDATE, model);
		Object[] args = this.setParams(model, SQL_UPDATE);
		int[] argTypes = this.setParamTypes(model, SQL_UPDATE);
		getJdbcTemplate().update(sql, args, argTypes);
	}

	public static void main(String[] args) throws Exception {
		Function f = new Function();
		StringBuffer sql = new StringBuffer();
		Field[] fields = f.getClass().getDeclaredFields();
		Field[] sub_fields = f.getClass().getSuperclass().getDeclaredFields();
		sql.append(" UPDATE SYS_FUNCTION SET ");
		String id = "id";
		for (int i = 0; fields != null && i < fields.length; i++) {
			fields[i].setAccessible(true);
			String column = fields[i].getName();
			if (i == 0 && column.indexOf("id") != -1) {
				id = column;
				continue;
			}
			sql.append(column).append("=").append("?,");
		}
		for (int i = 0; sub_fields != null && i < sub_fields.length; i++) {
			sub_fields[i].setAccessible(true);
			String column = sub_fields[i].getName();
			sql.append(column).append("=").append("?,");
		}
		sql = sql.deleteCharAt(sql.length() - 1);
		sql.append(" WHERE " + id + "=? ");
		System.out.println("SQL=" + sql);
	}

	/**
	 * 拼接SQL语句
	 * 
	 * @param model
	 *            实体类
	 * @param sqlFlag
	 *            CRUD标识符
	 * @return String 拼接后的SQL
	 */
	@SuppressWarnings("unchecked")
	private <T> String makeSql(String sqlFlag, T model) throws Exception {
		StringBuffer sql = new StringBuffer();
		Class<T> clazz = (Class<T>) model.getClass();
		String className = clazz.getSimpleName();
		className = PropertiesUtils.getTableNameByProperties(className);
		Field[] fields = clazz.getDeclaredFields();
		Field[] sub_fields = clazz.getSuperclass().getDeclaredFields();
		if ((SQL_INSERT).equals(sqlFlag)) {
			sql.append(" INSERT INTO " + className);
			sql.append("(");
			for (int i = 0; fields != null && i < fields.length; i++) {
				fields[i].setAccessible(true); // 暴力反射
				String column = fields[i].getName();
				sql.append(column).append(",");
			}
			for (int i = 0; sub_fields != null && i < sub_fields.length; i++) {
				sub_fields[i].setAccessible(true); // 暴力反射
				String column = sub_fields[i].getName();
				sql.append(column).append(",");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(") VALUES (");
			for (int i = 0; fields != null && i < fields.length; i++) {
				sql.append("?,");
			}
			for (int i = 0; sub_fields != null && i < sub_fields.length; i++) {
				sql.append("?,");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(") ");
		} else if ((SQL_UPDATE).equals(sqlFlag)) {
			sql.append(" UPDATE " + className + " SET ");
			String id = "id";
			for (int i = 0; fields != null && i < fields.length; i++) {
				fields[i].setAccessible(true);
				String column = fields[i].getName();
				if (i == 0 && column.indexOf("id") != -1) {
					id = column;
					continue;
				}
				sql.append(column).append("=").append("?,");
			}
			for (int i = 0; sub_fields != null && i < sub_fields.length; i++) {
				sub_fields[i].setAccessible(true);
				String column = sub_fields[i].getName();
				sql.append(column).append("=").append("?,");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE " + id + "=? ");
		}
		System.out.println("SQL=" + sql);
		return sql.toString();
	}

	/**
	 * 设置参数
	 * 
	 * @param model
	 *            实体类
	 * @param sqlFlag
	 *            CRUD标识符
	 * 
	 * @return Object[] 参数对象数组
	 */
	@SuppressWarnings("unchecked")
	private <T> Object[] setParams(T model, String sqlFlag) throws Exception {
		Class<T> clazz = (Class<T>) model.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field[] sub_fields = clazz.getSuperclass().getDeclaredFields();
		if ((SQL_INSERT).equals(sqlFlag)) {
			Object[] params = new Object[fields.length + sub_fields.length];
			int count = 0;
			for (int i = 0; params != null && i < fields.length; i++) {
				count++;
				fields[i].setAccessible(true);
				params[i] = fields[i].get(model);
			}
			for (int i = 0; i < sub_fields.length; i++) {
				sub_fields[i].setAccessible(true);
				params[i + count] = sub_fields[i].get(model);
			}
			return params;
		} else if ((SQL_UPDATE).equals(sqlFlag)) {
			Object[] tempArr = new Object[fields.length + sub_fields.length];
			int count = 0;
			for (int i = 0; tempArr != null && i < fields.length; i++) {
				count++;
				fields[i].setAccessible(true);
				tempArr[i] = fields[i].get(model);
			}
			for (int i = 0; i < sub_fields.length; i++) {
				sub_fields[i].setAccessible(true);
				tempArr[i + count] = sub_fields[i].get(model);
			}
			Object[] params = new Object[fields.length + sub_fields.length];
			System.arraycopy(tempArr, 1, params, 0, tempArr.length - 1); // 数组拷贝
			params[params.length - 1] = tempArr[0];
			return params;
		}
		return null;
	}

	/**
	 * 设置参数类型
	 * 
	 * @param <T>
	 * 
	 * @param model
	 *            实体类
	 * @param sqlFlag
	 *            CRUD标识符
	 * 
	 * @return Object[] 参数对象数组
	 */
	@SuppressWarnings("unchecked")
	private <T> int[] setParamTypes(T model, String sqlFlag) throws Exception {
		Class<T> clazz = (Class<T>) model.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field[] sub_fields = clazz.getSuperclass().getDeclaredFields();
		if ((SQL_INSERT).equals(sqlFlag)) {
			int[] paramTypes = new int[fields.length + sub_fields.length];
			int count = 0;
			try {
				for (int i = 0; paramTypes != null && i < fields.length; i++) {
					count++;
					fields[i].setAccessible(true);
					if (("java.lang.String").equals(fields[i].getType().getName())) {
						paramTypes[i] = Types.VARCHAR;
					} else if (("java.lang.Double").equals(fields[i].getType().getName())) {
						paramTypes[i] = Types.DECIMAL;
					} else if (("java.lang.Integer").equals(fields[i].getType().getName())) {
						paramTypes[i] = Types.INTEGER;
					} else if (("java.util.Date").equals(fields[i].getType().getName())) {
						paramTypes[i] = Types.DATE;
					}
				}
				for (int i = 0; paramTypes != null && i < sub_fields.length; i++) {
					sub_fields[i].setAccessible(true);
					if (("java.lang.String").equals(sub_fields[i].getType().getName())) {
						paramTypes[i + count] = Types.VARCHAR;
					} else if (("java.lang.Double").equals(sub_fields[i].getType().getName())) {
						paramTypes[i + count] = Types.DECIMAL;
					} else if (("java.lang.Integer").equals(sub_fields[i].getType().getName())) {
						paramTypes[i + count] = Types.INTEGER;
					} else if (("java.util.Date").equals(sub_fields[i].getType().getName())) {
						paramTypes[i + count] = Types.DATE;
					}
				}
				return paramTypes;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (SQL_UPDATE.equals(sqlFlag)) {
			int[] tempArgTypes = new int[fields.length + sub_fields.length];
			int[] paramTypes = new int[fields.length + sub_fields.length];
			int count = 0;
			try {
				for (int i = 0; tempArgTypes != null && i < fields.length; i++) {
					count++;
					fields[i].setAccessible(true);
					if (("java.lang.String").equals(fields[i].getType().getName())) {
						tempArgTypes[i] = Types.VARCHAR;
					} else if (("java.lang.Double").equals(fields[i].getType().getName())) {
						tempArgTypes[i] = Types.DECIMAL;
					} else if (("java.lang.Integer").equals(fields[i].getType().getName())) {
						tempArgTypes[i] = Types.INTEGER;
					} else if (("java.util.Date").equals(fields[i].getType().getName())) {
						tempArgTypes[i] = Types.DATE;
					}
				}
				for (int i = 0; i < sub_fields.length; i++) {
					sub_fields[i].setAccessible(true);
					if (("java.lang.String").equals(sub_fields[i].getType().getName())) {
						tempArgTypes[i + count] = Types.VARCHAR;
					} else if (("java.lang.Double").equals(sub_fields[i].getType().getName())) {
						tempArgTypes[i + count] = Types.DECIMAL;
					} else if (("java.lang.Integer").equals(sub_fields[i].getType().getName())) {
						tempArgTypes[i + count] = Types.INTEGER;
					} else if (("java.util.Date").equals(sub_fields[i].getType().getName())) {
						tempArgTypes[i + count] = Types.DATE;
					}
				}
				System.arraycopy(tempArgTypes, 1, paramTypes, 0, tempArgTypes.length - 1);
				paramTypes[paramTypes.length - 1] = tempArgTypes[0];
			} catch (Exception e) {
				e.printStackTrace();
			}
			return paramTypes;
		}
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param <T>
	 * 
	 * @param model
	 *            实体类
	 * @param id
	 *            主键ID
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> int deleteModel(T model, String ids) throws Exception {
		StringBuffer sql = new StringBuffer();
		Class<T> clazz = (Class<T>) model.getClass();
		String className = clazz.getSimpleName();
		className = PropertiesUtils.getTableNameByProperties(className);
		Field[] fields = clazz.getDeclaredFields();
		String column = "id";
		if (fields[0].getName().indexOf("id") != -1) {
			column = fields[0].getName();
		}
		sql.append("DELETE FROM " + className + " WHERE " + column + " in (" + ids + ")");
		return getJdbcTemplate().update(sql.toString());
	}

}
