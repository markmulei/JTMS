/**
 * 员工控制层
 */
Ext.define('WE.staff.app.controller.StaffController', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
		
		});
	},
	views : [
		'WE.staff.app.view.StaffLayout',
		'WE.staff.app.view.StaffGridLayout',
		'WE.staff.app.view.StaffGrid'
	],
	stores : [
		'WE.staff.app.store.StaffStore'
	],
	models : [
		'WE.staff.app.model.StaffModel'
	]
});