/**
 * 员工实体
 */
Ext.define('WE.staff.app.model.StaffModel', {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'aoto', sortable : true},
		{name : 'name', type : 'aoto', sortable : true},
		{name : 'password', type : 'aoto', sortable : true},
		{name : 'email', type : 'aoto', sortable : true}
	]
})