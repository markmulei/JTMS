Ext.define('WE.sysUser.app.view.SysUserLayout', {
	extend : 'Ext.panel.Panel',
	name : 'SysUserLayout',
	alias : 'widget.sysUserLayout',
	closable : true,
	layout : 'card',
	title : '<center height="15">用户管理</center>',
	margin : '1 1 1 1',
	items : [{
		xtype : 'sysUserGridLayout'
	}, {
		xtype : 'panel'
	}]
});