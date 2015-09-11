Ext.define('ExtMVC.view.portal.PortletPanel', {
	extend: 'ExtMVC.view.app.PortalPanel',
	alias: 'widget.portletpanel',
	getTools: function() {
		return [{
			xtype: 'tool',
			type: 'refresh',
			handler: function(e, target, panelHeader, tool) {
				var portlet = panelHeader.ownerCt;
				portlet.setLoading('Loading...');
				Ext.defer(function() {
					portlet.items.items[0].getStore().load();
					portlet.setLoading(false);
				}, 2000);
			}
		}/*, {
					xtype : 'tool',
					type : 'search',
					handler : function(e, target, panelHeader, tool) {
						var portlet = panelHeader.ownerCt;
						portlet.setLoading('Loading...');
						Ext.defer(function() {
									portlet.setLoading(false);
								}, 2000);
					}
				}*/];
	},
	initComponent: function() {
		Ext.apply(this, {
			items: [{
				id: 'col-1',
				items: [{
					id: 'portlet-1',
					title: '新闻',
					tools: this.getTools(),
					height: 200,
					width: 100,
					layout: 'fit',
					colspan: 2,
					items: [{
						//xtype: 'indexNewsInfomationsView'
					}]
				},{
					id: 'portlet-11',
					title: '公告',
					tools: this.getTools(),
					height: 200,
					layout: 'fit',
					items: [{
						//xtype: 'indexNoticeInfomationsView'
					}]
				}]
			}, {
				id: 'col-2',
				items: [{
					id: 'portlet-111',
					title: '制度',
					tools: this.getTools('indexInstitutionInfomationsView'),
					height: 200,
					layout: 'fit',
					items: [{
						//xtype: 'indexInstitutionInfomationsView'
					}]
				}, {
					id: 'portlet-3',
					title: '个人信息',
					tools: this.getTools(),
					height: 150,
					layout: 'fit',
					html: 'ccc'
				}, {
					id: 'portlet-2',
					title: '新闻',
					tools: this.getTools(),
					height: 150,
					html: 'bbb'
				}]
			}]
		});
	this.callParent(arguments);
	}
});
Ext.define('ExtMVC.view.Viewport', {
	extend: 'Ext.panel.Panel',
	uses: ['ExtMVC.view.app.PortalPanel',
			'ExtMVC.view.app.PortalColumn',
			'ExtMVC.view.portal.PortletPanel'],
	margin: '1 1 1 1',
	border: 0,
	initComponent: function() {
		Ext.apply(this, {
			id: 'app-viewport',
			layout: {
				type: 'border'
			},
			items: [{
				id: 'app-portal',
				xtype: 'portletpanel',
				region: 'center'
			}]
		});
		this.callParent(arguments);
	}
});