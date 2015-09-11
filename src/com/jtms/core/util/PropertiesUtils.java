package com.jtms.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @ClassName: PropertiesUtils
 * @Description: 资源文件工具类
 * @author mulei 157799470@qq.com
 * @date Jul 31, 2015 11:13:40 AM
 *
 */
public final class PropertiesUtils {

	/**
	 * 
	 * @Title: getTableNameByProperties
	 * @Description: 根据key值通过table.properties获得对应的value
	 * @param key
	 *            文件对应的key值
	 * @return
	 * @return String
	 * @throws
	 * @author mulei Jul 31, 2015 11:13:35 AM
	 */
	public static String getTableNameByProperties(String key) {
		String tableName = "";
		Properties ps = new Properties();
		String url = PropertiesUtils.class.getClassLoader().getResource("config/table.properties").getPath();
		try {
			ps.load(new FileInputStream(url));
			tableName = (String) ps.get(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tableName;
	}

}
