Ext.define('WE.function.app.view.FunctionGridLayout', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.functionGridLayout',
	layout : 'border',
	title : '功能信息列表',
	glyph : 0xf022,
	tbar : [
		{xtype : 'buttontransparent', text : '添加', ref : 'fun_add', iconCls : 'icon-plus'},
		{xtype : 'buttontransparent', text : '编辑', ref : 'fun_edit', iconCls : 'icon-edit'},
		{xtype : 'buttontransparent', text : '删除', ref : 'fun_del', iconCls : 'icon-trash'}
	],
	items : [{
		region : 'north',
		xtype : 'fieldcontainer',
		height : 35,
		layout : 'fit',
		items : [{
			xtype : 'form',
			layout : 'table',
			border : false,
			defaults : {
				labelAlign: 'right',
				labelWidth: 80,
				margin: '5 1 1 1'
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : '功能名称',
				name : 'sys_fun_name'
			}, {
				xtype : 'button',
				iconCls : 'icon-search',
				text : '查询',
				ref : 'find'
			}]
		}]
	}, {
		region : 'center',
		xtype : 'functionGrid'
	}]
})