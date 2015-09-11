Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.Loader.setConfig({
		enabled : true
	});
	Ext.application({
		name : 'LESSON',
		appFolder : 'app',
		launch : function() {
			Ext.create('Ext.container.Viewport', {
				layout : 'auto',
				items : {
					xtype : 'depttree'
				}
			});
		},
		controllers : [
			'DeptController'
		]
	});
});