Ext.define('WE.department.app.store.DepartmentStore', {
	extend : 'Ext.data.Store',
	model : modelFactory.getModelByName('com.jtms.system.department.model.Department', 'id'),
	pageSize: 10,
	proxy : {
		api : {
			save : '/JTMS/department/save',
			remove : '/JTMS/department/remove'
		},
		type : 'ajax',
		url : '',
		reader : {
			type : 'json',
			root : 'topics'
		},
		writer : {
			type : 'json'
		}
	},
	autoLoad : {
		start : 0, 
		limit : 10
	}
})