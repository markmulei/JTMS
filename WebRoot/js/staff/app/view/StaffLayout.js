/**
 * 员工总布局
 */
Ext.define('WE.staff.app.view.StaffLayout', {
	extend : 'Ext.panel.Panel',
	name : 'StaffLayout',
	alias : 'widget.staffLayout',
	closable : true,
	layout : 'card',
	title : '<center height="15">员工管理</center>',
	margin : '1 1 1 1',
	items : [{
		xtype : 'staffGridLayout'
	}, {
		xtype : 'panel'
	}]
});