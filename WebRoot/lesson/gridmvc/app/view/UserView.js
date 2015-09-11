Ext.define('LESSON.view.UserView', {
	extend : 'Ext.grid.Panel',
	title : 'Grid Demo', // 标题
	frame : true, //面板渲染
	width : 600,
	height : 280,
	alias : 'widget.userview', // 别名，方便其他组件引用
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
	tbar : [
		{xtype : 'button', id : "add", text : '添加'}, 
		{xtype : 'button', id : "del", text : '删除'}, 
		{xtype : 'button', id : "update", text : '修改'}
	],
	//分页栏
	/*bbar: Ext.create('Ext.PagingToolbar', {
		store : 'UserStore',
		displayInfo : true,
		displayMsg: 'Displaying topics {0} - {1} of {2}',
		emptyMsg: "No topics to display"
	}),*/
	dockedItems : [{
		xtype : 'pagingtoolbar',
		store : 'UserStore',
		dock : 'bottom',
		displayInfo : true
	}],
	//添加插件
	plugins : [
		Ext.create('Ext.grid.plugin.CellEditing', {//需要配合列的列模式配置
			clicksToEdit : 2
		})
	],
	//多选框
	selType : 'checkboxmodel', //设定选择模式
	multiSelect : true, //允许多选
	store : 'UserStore',
	//renderTo :'example-grid',
	initComponent : function() {
		this.callParent(arguments);
	}
});