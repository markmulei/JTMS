Ext.define('WE.department.app.view.DepartmentLayout', {
	extend : 'Ext.panel.Panel',
	name : 'DepartmentLayout',
	alias : 'widget.departmentLayout',
	closable : true,
	title : '<center height="15">组织机构</center>',
	margin : '1 1 1 1',
	layout : 'border',
	items : [{
		region : 'west',
		title : '组织机构树',
		xtype : 'panel',
		width : 250
	}]
})