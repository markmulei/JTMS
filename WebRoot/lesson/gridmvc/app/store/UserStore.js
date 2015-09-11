//User数据集合类
Ext.define('LESSON.store.UserStore', {
	extend : 'Ext.data.Store',
	model : 'LESSON.model.User',
	storeId : 's_user',
	proxy : {
		type : 'ajax',
		url : '/JTMS/lesson/gridmvc/list',
		reader : {
			type : 'json',
			root : 'topics'
		},
		writer : {
			type : 'json'
		}
	},
	autoLoad: true
})