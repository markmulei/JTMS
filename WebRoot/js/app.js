Ext.onReady(function(){
	Ext.Loader.setConfig({
		enabled:true
	});
	Ext.setGlyphFontFamily('FontAwesome'); // 设置图标字体文件，只有设置了以后才能用glyph属性
	// 代办(规划中)
	/*Ext.Ajax.request({
		
	});*/
	
	// 必须要创建的组件，应用程序的入口
	Ext.application({
		name : 'WE',
		appFolder : 'js',
		uses : ['js.ux.ButtonTransparent'],
		// 动态加载  新加载controller触发的事件
		newControllerAdded : function(idx, cntr){
			//cntr.init();(推测由于异步加载，通过getController来加载对应的controller，若继续init会导致controller中的事件方法重复触发)
		},
		/*// 判断是否有controller
		hasController: function(name){
			return this.controllers.get(name);
		},
		// 动态加载  添加controller触发的事件
		addController: function(name){
			return this.getController(name);
		},*/
		controllers : [
			'WE.controller'
		],
		launch : function() {
			Ext.tip.QuickTipManager.init(); // 初始化全局的QuickTips,为创建QuickTips做准备
			this.controllers.addListener('add', this.newControllerAdded, this);
			// Viewport创建唯一，应用的入口程序
			Ext.create('Ext.container.Viewport', {
				layout : 'border',
				items : [{
					region : 'north',
					xtype : 'panel',
					height : 60,
					id : 'top-grid',
					layout : 'fit',
					autoLoad : {
						url : "/JTMS/jsp/top.jsp"
					}
				}, {
					region : 'west',
					title : '导航栏',
					id : 'west-tree',
					glyph : 0xf0c9,
					xtype : 'panel',
					width : 250,
					//hideHeaders : true,
					split : true,
					minWidth: 175,
                	maxWidth: 400,
					collapsible : true,
					animCollapse : true,
					//autoScroll : true,
					layout : 'accordion'
				}, {
					region : 'center',
					xtype : 'tabpanel',
					id : 'center-grid',
					autoDestroy : false,
					deferredRender : false,
					layout : 'fit',
					plugins : Ext.create('Ext.ux.TabCloseMenu', {  
                    	closeTabText : '关闭当前页',  
                    	closeOthersTabsText : '关闭其他页',  
                    	closeAllTabsText : '关闭所有页'  
                    }), 
                    items : [{
                    	xtype : 'panel',
                    	title : '<center height="15">首页</center>',
                    	layout : 'fit',
                    	items : [
                    		//Ext.create('ExtMVC.view.Viewport')
                    	]
                    }]
				}, {
					region : 'south',
					xtype : 'panel',
//					margins : '1 1 1 1',
					height : 36,
					id : 'bottom-grid',
					layout : 'fit',
					tbar : ['-', {
						xtype : 'buttontransparent',
						text : '退出系统',
						iconCls : 'icon-search',
						handler : function(btn) {
							exitSystem();
						}
					}, '-', {
						text : '个人设置',
						xtype : 'buttontransparent',
						iconCls : 'icon-cogs',
						menu : {
							xtype : 'menu',
							items : [{
		                		text : '编辑个人信息',
		                		iconCls : 'icon-user-md',
		                		handler: function(btn) {
		                			
		                		}
		                	}, {
		                		text: '修改密码',
		                		iconCls : 'icon-unlock',
		                		handler: function(btn) {
		                			
		                		}
		                	}, {
		                		text: '意见反馈',
		                		iconCls : 'icon-envelope-alt',
		                		handler: function(btn) {
		                			
		                		}
		                	}]
						}
					}, '-', {
						xtype : 'buttontransparent',
						text : '联系我们',
						iconCls : 'icon-comment',
						handler : function(btn) {
							
						}
					}, {
						xtype : 'buttontransparent',
						text : '在线用户',
						iconCls : 'icon-eye-open',
						handler : function(btn) {
							//Ext.create('WE.index.app.view.OnlineUserWindow', {}).show();
						}
					}/*, {
						xtype : 'label',
						html: '<img height="25" src="/JTMS/image/gif/fighting.gif"></img>'
					}*/, '->', Ext.Date.format(new Date(), 'Y-m-d'), clock],
					listeners : {
						render : {
							fn : function() {
								Ext.TaskManager.start({
									run : function() {
										Ext.fly(clock.getEl()).update(Ext.Date.format(new Date(), 'g:i:s A'));
									},
				                    interval: 1000
								});
							},
							delay : 100
						}
					}
				}]
			});
		}
	});
	var clock = Ext.create('Ext.toolbar.TextItem', {
		text : Ext.Date.format(new Date(), 'g:i:s A')
	});
	// 加载west属性接口所需的子节点数据集
	var createStore = function(id){
		return Ext.create('Ext.data.TreeStore',{
			defaultRootId : 'root',
			root : {
				expanded : true					
			},
			proxy : {
				type : 'ajax',
				url : '/JTMS/function/getChildTree?id='+id,
				method : 'POST',
				async : false,
				reader : 'json'
			},
			clearOnLoad : true
		});
	}
	// 定时器（作用是执行timeHandler函数，加载树形结构）
	var a = window.setInterval(timeHandler,10);
	// 加载west导航栏数据函数
	function timeHandler(){
		Ext.Ajax.request({
			url : '/JTMS/function/getAccordion',
			method : 'POST',
			async : false,
			success : function(response, param) {
				var menuNew = [];
				var s = response.responseText;
				menuNew = s.split("*");
				var accordion = Ext.getCmp('west-tree');
				if (accordion != 'undefined' && accordion != null) {
					window.clearInterval(a);
					for (var i=0; i<menuNew.length; i++) {
						accordion.add(Ext.create('Ext.tree.Panel', {
							title : menuNew[i].split(",")[1].split(":")[1].replace(/\"/g,""),
							rootVisible : false,
							animate: true,
							store: createStore(menuNew[i].split(",")[0].split(":")[1].replace(/\"/g,"")),
							useArrows: true
						}));
					}
				}
			}
		});
	}
});