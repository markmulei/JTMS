Ext.define('WE.controller', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
			'viewport panel[id=west-tree] > treepanel' : {
				itemclick : function(tree, record, item, e, opti) {
					var tabs = Ext.getCmp('center-grid');
					if(record.raw.control == null){
						return;
					}else{
						if(!this.hasController(record.raw.control)){
						    this.populateCenterPanel(record.raw.control);
						}
						
					}
					// 获得点击内容的layout
					var panel = "";
					if(record.raw.alias != null){
						panel = tabs.down(record.raw.alias.split(".")[1]);
					}else{
						var tab = Ext.create(record.raw.layout,{});
						panel = tabs.down(tab.alias.split(".")[1]);
					}
					// 判断是否存在已显示的layout
					if(!panel){
						var tab = Ext.create(record.raw.layout,{});
						tabs.add(tab).show();
					}else{
						tabs.setActiveTab(panel);
					}
				}
			}
		});
	},
	populateCenterPanel : function(name) {
	    this.getController(name);
	},
	hasController: function(name){
		return this.getApplication().controllers.get(name);
	}
});