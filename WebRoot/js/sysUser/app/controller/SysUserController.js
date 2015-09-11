Ext.define('WE.sysUser.app.controller.SysUserController', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
		
		});
	},
	views : [
		'WE.sysUser.app.view.SysUserLayout',
		'WE.sysUser.app.view.SysUserGridLayout',
		'WE.sysUser.app.view.SysUserGrid'
	],
	stores : [
		'WE.sysUser.app.store.SysUserStore'
	],
	models : [
		'WE.sysUser.app.model.SysUserModel'
	]
});