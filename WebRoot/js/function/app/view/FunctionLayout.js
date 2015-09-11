Ext.define('WE.function.app.view.FunctionLayout', {
	extend : 'Ext.panel.Panel',
	name : 'FunctionLayout',
	alias : 'widget.functionLayout',
	closable : true,
	layout : 'card',
	title : '<center height="15">功能管理</center>',
	margin : '1 1 1 1',
	items : [{
		xtype : 'functionGridLayout'
	}, {
		xtype : 'functionFormLayout'
	}]
})