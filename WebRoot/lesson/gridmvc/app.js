Ext.onReady(function(){
	Ext.QuickTips.init();
	Ext.Loader.setConfig({
		enabled : true
	});
	Ext.application({
		name : 'LESSON', //应用的名字
		appFolder : 'app', //应用的目录，会去找app目录下对应的LESSON后面的类
		launch : function() {//当前页面加载完成执行的函数
			Ext.create('Ext.container.Viewport', {
				layout : 'auto', //自动布局
				items : {
					xtype : 'userview',
					title : 'User列表',
					html : 'AAAAAAAAAAAAAAAAAAAAAAAA'
				}
			});
		},
		controllers : [
			'UserController'
		]
	});
});