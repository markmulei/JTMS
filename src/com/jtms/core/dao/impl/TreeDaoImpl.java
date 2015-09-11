package com.jtms.core.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jtms.core.dao.TreeDao;

@Repository
public class TreeDaoImpl implements TreeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> getTree() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT S.SYS_FUN_ID AS id, ");
		sql.append("S.SYS_FUN_NAME AS text, ");
		sql.append("S.SYS_FUN_DESCRIPTION AS description, ");
		sql.append("S.SYS_FUN_CONTROLLER AS control, ");
		sql.append("S.SYS_FUN_LAYOUT AS layout, ");
		sql.append("S.SYS_FUN_TYPE AS type, ");
		sql.append("S.SYS_FUN_PID AS pid, ");
		sql.append("S.SYS_FUN_LEAF AS leaf ");
		sql.append("FROM sys_function S ");
		sql.append("WHERE S.SYS_FUN_PID = '0' ");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
		return list;
	}

	@Override
	public List<Map<String, Object>> getChildTree(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select s.SYS_FUN_ID as id, ");
		sql.append("s.SYS_FUN_NAME as text, ");
		sql.append("s.SYS_FUN_CONTROLLER as control, ");
		sql.append("s.SYS_FUN_LAYOUT AS layout, ");
		sql.append("s.SYS_FUN_ALIAS AS alias, ");
		sql.append("s.SYS_FUN_LEAF as leaf, ");
		sql.append("s.SYS_FUN_PID as pid, ");
		sql.append("s.SYS_FUN_TYPE as type ");
		sql.append("from sys_function s ");
		sql.append("where s.SYS_FUN_PID = '").append(id).append("' ");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
		return list;
	}

}
