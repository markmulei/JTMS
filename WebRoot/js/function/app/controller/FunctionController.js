Ext.define('WE.function.app.controller.FunctionController', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
			/**
			 * 功能管理--功能信息列表--【添加】按钮点击事件
			 */
			'functionGridLayout button[ref=fun_add]' : {
				click : function(btn) {
					var panel = btn.up('functionLayout');
					var reset_btn = panel.down('functionFormLayout button[ref=fun_reset]');
					reset_btn.setVisible(true);
					var formObj = panel.down('functionForm').getForm();
					formObj.reset();
					nextprev(panel, 'next');
				}
			},
			/**
			 * 功能管理--功能信息列表--【编辑】按钮点击事件
			 */
			'functionGridLayout button[ref=fun_edit]' : {
				click : function(btn) {
					var panel = btn.up('functionLayout');
					var reset_btn = panel.down('functionFormLayout button[ref=fun_reset]');
					reset_btn.setVisible(false);
					var grid = panel.down('functionGrid');
					var records = grid.getSelectionModel().getSelection();
					if (records.length == 0) {
						Ext.example.msg('提示', '请选择一条数据!');
						return;
					}
					var formObj = panel.down('functionForm').getForm();
					formObj.reset();
					formObj.loadRecord(records[0]);
					// 获得combo，触发select事件
					var combo = formObj.findField('fun_type');
					combo.fireEvent('select', combo);
					nextprev(panel, 'next');
				}
			},
			/**
			 * 功能管理--功能信息列表--【删除】按钮点击事件
			 */
			'functionGridLayout button[ref=fun_del]' : {
				click : function(btn) {
					var panel = btn.up('functionLayout');
					var grid = panel.down('functionGrid');
					var records = grid.getSelectionModel().getSelection();
					if (records.length == 0) {
						Ext.example.msg('提示', '请选择一条数据!');
						return;
					}
					// 判断是否含有子节点
					if (records[0].data.fun_leaf == 'false') {
						Ext.Msg.alert("提示", "该功能包含子功能，无法删除！");
						return;
					}
					Ext.Msg.confirm("提示","是否进行删除操作吗?",function(c) {
						if (c == "yes") {
							curdFactory.doDelete(grid);
						}
					})
				}
			},
			/**
			 * 功能管理--功能详细信息--【返回】按钮点击事件
			 */
			'functionFormLayout button[ref=fun_back]' : {
				click : function(btn) {
					var panel = btn.up('functionLayout');
					var formObj = panel.down('functionForm').getForm();
					formObj.reset();
					nextprev(panel, 'prev');
				}
			},
			/**
			 * 功能管理--功能详细信息--【重置】按钮点击事件
			 */
			'functionFormLayout button[ref=fun_reset]' : {
				click : function(btn) {
					var panel = btn.up('functionLayout');
					var formObj = panel.down('functionForm').getForm();
					formObj.reset();
				}
			},
			/**
			 * 功能管理--功能详细信息--【保存】按钮点击事件
			 */
			'functionFormLayout button[ref=fun_save]' : {
				click : function(btn) {
					var panel = btn.up('functionLayout');
					var formObj = panel.down('functionForm').getForm();
					var grid = panel.down('functionGrid');
					if (formObj.isValid()) {
						curdFactory.doSaveForm(formObj, grid);
						nextprev(panel, 'prev');
					} else {
						showMsg.formSubmit(1);
					}
				}
			},
			/**
			 * 功能管理--功能详细信息--【类型下拉】选择事件
			 */
			'functionForm combobox[name=fun_type]' : {
				select : function(combo, records, eOpts) {
					var form = combo.up('functionForm');
					var combo2 = form.down('treecombobox[name=fun_pid]');
					var field1 = form.down('textfield[name=fun_controller]');
					var field2 = form.down('textfield[name=fun_layout]');
					var field3 = form.down('textfield[name=fun_alias]');
					var id = combo.getValue();
					if (id == 0) {
						combo2.setDisabled(true);
						combo2.reset();
						field1.setDisabled(true);
						field1.reset();
						field2.setDisabled(true);
						field2.reset();
						field3.setDisabled(true);
						field3.reset();
					} else {
						combo2.setDisabled(false);
						field1.setDisabled(false);
						field2.setDisabled(false);
						field3.setDisabled(false);
					}
				}
			}
			
		});
	},
	views : [
		'WE.function.app.view.FunctionLayout',
		'WE.function.app.view.FunctionGridLayout',
		'WE.function.app.view.FunctionGrid',
		'WE.function.app.view.FunctionFormLayout',
		'WE.function.app.view.FunctionForm'
	],
	stores : [
		'WE.function.app.store.FunctionStore'
	],
	models : [
		
	]
})