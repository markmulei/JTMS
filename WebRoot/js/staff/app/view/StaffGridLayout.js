/**
 * 员工列表布局
 */
Ext.define('WE.staff.app.view.StaffGridLayout', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.staffGridLayout',
	layout : 'border',
	title : '用户信息列表',
	tbar : [
		{xtype : 'buttontransparent', text : '添加', ref : 'user_add', iconCls : 'icon-plus'},
		{xtype : 'buttontransparent', text : '删除', ref : 'user_del', iconCls : 'icon-trash'},
		{xtype : 'buttontransparent', text : '重置密码', ref : 'user_reset', iconCls : 'icon-retweet'}
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
				fieldLabel : '员工姓名',
				//width : 150,
				name : 'userName'
			}, {
				xtype : 'button',
				iconCls : 'icon-search',
				text : '查询',
				ref : 'find'
			}]
		}]
	}, {
		region : 'center',
		xtype : 'staffGrid'
	}]
})