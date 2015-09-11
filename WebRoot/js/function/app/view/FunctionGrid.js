Ext.define('WE.function.app.view.FunctionGrid', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.functionGrid',
	store : 'WE.function.app.store.FunctionStore',
	columnLines : true,
	columns : [
		//Ext.create('Ext.grid.RowNumberer'),
		{text : '功能名称', dataIndex : 'fun_name',  width : 100},
		{text : '控制器', dataIndex : 'fun_controller', width : 250},
		{text : '总体布局', dataIndex : 'fun_layout', width : 250},
		{text : '别名', dataIndex : 'fun_alias', width : 150},
		{text : '类型', dataIndex : 'fun_type', 
			renderer : function(c) {
				if (c == 0) {
					return '菜单栏';
				} else {
					return '功能节点';
				}
			}
		},
		{text : '是否为子节点', dataIndex : 'fun_leaf'}
	],
	plugins : [{
		ptype : 'rowexpander',
		rowBodyTpl : new Ext.XTemplate(
			'<p><b>功能描述：</b> <span style="color:green">{fun_description}</span></p>'
		)
	}],
    animCollapse : false,
	dockedItems : [{
		xtype : 'pagingtoolbar',
		store : 'WE.function.app.store.FunctionStore',
		dock : 'bottom',
		displayInfo : true
	}],
	//selType : 'checkboxmodel',
	forceFit : true, //列自动填充
	initComponent : function() {
		this.callParent(arguments);
		//this.getStore().load();
	}
})