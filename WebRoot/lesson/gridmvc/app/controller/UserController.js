Ext.define('LESSON.controller.UserController', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
			'userview button[id=del]' : {
				click : function(btn) {
					//var grid = btn.findParentByType('gridpanel');
					var grid = btn.ownerCt.ownerCt;
					var data = grid.getSelectionModel().getSelection();
					if (data.length == 0) {
						Ext.Msg.alert('提示', '您最少要选择一条数据！');
					} else {
						//1.先得到ID的数组
						var store = grid.getStore();
						var ids = [];
						Ext.Array.each(data, function(record){
							ids.push(record.get('id'));
						});
						//2.后台操作
						Ext.Ajax.request({
							url : '/JTMS/lesson/gridmvc/delete',
							params : {ids : ids.join(',')},
							method : 'post',
							timeout : 2000,
							success : function(response, opts){
								alert('----------');
							}
						});
					}
				}
			}
		});
	},
	views : ['UserView'],
	stores : ['UserStore'],
	models : ['User']
});