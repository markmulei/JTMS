Ext.define('LESSON.store.DeptStore', {
	extend : 'Ext.data.TreeStore',
	defaultRoodId : 'root',
	proxy : {
		type : 'ajax',
		url : '/JTMS/lesson/treemvc/getTree',
		reader : 'json',
		autoLoad : true
	}
})