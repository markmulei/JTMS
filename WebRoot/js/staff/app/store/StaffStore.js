/**
 * 员工数据集
 */
Ext.define('WE.staff.app.store.StaffStore', {
	extend : 'Ext.data.Store',
	//model : 'WE.sysUser.app.model.SysUserModel',
	model : modelFactory.getModelByName('com.jtms.system.staff.model.Staff', 'id'),
	pageSize: 10,
	proxy : {
		type : 'ajax',
		url : '/JTMS/staff/list',
		reader : {
			type : 'json',
			root : 'topics'
		},
		writer : {
			type : 'json'
		}
	},
	//autoLoad : true
	autoLoad : {
		start : 0, 
		limit : 10
	}
})