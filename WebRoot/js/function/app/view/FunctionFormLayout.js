Ext.define('WE.function.app.view.FunctionFormLayout', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.functionFormLayout',
	autoScroll: true,
	height : 300,
	title : '功能详细信息',
	glyph : 0xf0f7,
	tbar : [
		{xtype: 'button', text: '返回', ref: 'fun_back', iconCls: 'icon-reply'},
		{xtype: 'button', text: '重置', ref: 'fun_reset', iconCls:'icon-refresh'},
		{xtype: 'button', text: '保存', ref: 'fun_save', iconCls: 'icon-save'}
	],
	items : [{
		xtype : 'functionForm'
	}]
})