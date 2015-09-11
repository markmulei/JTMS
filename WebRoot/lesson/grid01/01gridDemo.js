Ext.onReady(function(){
	//User类
	Ext.define('user', {
		extend : 'Ext.data.Model',
		fields : [
			{name : 'id', type : 'string', sortable : true},
			{name : 'name', type : 'string', sortable : true},
			{name : 'age', type : 'int', sortable : true},
			{name : 'email', type : 'string', sortable : true}
		]
	});
	//创建store
	var store = Ext.create('Ext.data.Store', {
		model : 'user',
		autoLoad: true,
		storeId : 's_user',
		proxy : {
			type : 'ajax',
			url : '/JTMS/lesson/gridmvc/list',
			reader : {
				type : 'json',
				root : 'topics'
			},
			writer : {
				type : 'json'
			}
		}
	});
	//Ext.QuickTips.init();
	//创建一个grid的高级组件会用到grid的面板
	var grid = Ext.create('Ext.grid.Panel', {
		frame: true,
		title : 'Grid Demo', // 标题
		//forceFit : true, // 自动填充列宽
		store : store,
		columns : [
			{text : 'ID', dataIndex : 'id', width : 60},
			{text : 'Name', dataIndex : 'name', width : 150},
			{text : 'Age', dataIndex : 'age', width : 80},
			{text : 'Email', dataIndex : 'email', width : 250, 
				field : {
					xtype : 'textfield',
					allowBlank : false
				}
			}
		],
		//选项栏
		tbar : [{
			xtype : 'button',
			text : '添加'
		}, {
			xtype : 'button',
			text : '删除',
			handler : function(btn) {
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
		}, {
			xtype : 'button',
			text : '修改'
		}],
		//分页栏
		bbar: Ext.create('Ext.PagingToolbar', {
			store : store,
			displayInfo : true,
			displayMsg: 'Displaying topics {0} - {1} of {2}',
			emptyMsg: "No topics to display"
		}),
		//多选框
		selType : 'checkboxmodel', //设定选择模式
		multiSelect : true, //允许多选
		//添加插件
		plugins : [
			Ext.create('Ext.grid.plugin.CellEditing', {//需要配合列的列模式配置
				clicksToEdit : 1
			})
		],
		renderTo :'example-grid',
		width : 600,
		height : 280
	})
});