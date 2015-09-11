Ext.define('WE.sysUser.app.view.SysUserGrid', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.sysUserGrid',
	store : 'WE.sysUser.app.store.SysUserStore',
	columnLines : true,
	columns : [
		{text : 'ID', dataIndex : 'id'},
		{text : 'Name', dataIndex : 'name'},
		{text : 'Password', dataIndex : 'password'},
		{text : 'Birthday', dataIndex : 'birthday'},
		{text : '创建日期', dataIndex : 'create_date'},
		{text : 'Email', dataIndex : 'email'}
	],
	dockedItems : [{
		xtype : 'pagingtoolbar',
		store : 'WE.sysUser.app.store.SysUserStore',
		dock : 'bottom',
		displayInfo : true
	}],
	//多选框
	selType : 'checkboxmodel', //设定选择模式
	multiSelect : true, //允许多选
	forceFit : true, //列自动填充
	initComponent : function() {
		this.callParent(arguments);
		this.getStore().load();
	}
})