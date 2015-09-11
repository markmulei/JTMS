Ext.define('WE.sysUser.app.model.SysUserModel', {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'SYS_USER_ID', type : 'aoto', sortable : true},
		{name : 'SYS_USER_NAME', type : 'aoto', sortable : true},
		{name : 'SYS_USER_PASSWORD', type : 'aoto', sortable : true},
		{name : 'SYS_USER_EMAIL', type : 'aoto', sortable : true}
	]
})