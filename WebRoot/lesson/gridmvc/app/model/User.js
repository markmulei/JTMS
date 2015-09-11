//User类
Ext.define('LESSON.model.User', {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id', type : 'string', sortable : true},
		{name : 'name', type : 'string', sortable : true},
		{name : 'age', type : 'int', sortable : true},
		{name : 'email', type : 'string', sortable : true}
	]
});