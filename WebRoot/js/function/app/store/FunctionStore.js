Ext.define('WE.function.app.store.FunctionStore', {
	extend : 'Ext.data.Store',
	model : modelFactory.getModelByName('com.jtms.system.function.model.Function', 'id'),
	pageSize: 10,
	proxy : {
		api : {
			save : '/JTMS/function/save',
			remove : '/JTMS/function/remove'
		},
		type : 'ajax',
		url : '/JTMS/function/list',
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