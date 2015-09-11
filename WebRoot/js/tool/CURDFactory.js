Ext.define('WE.tool.CURDFactory', {
	/**
	 * 表单保存
	 */
	doSaveForm : function(formObj, grid, arg) {
		if (!(grid)) {
			alert("参数传递不正确");
			return;
		}
		var params = '';
		var id = '';
		if(arguments[2] != undefined) {
			params = arguments[2].substring(0, arguments[2].length - 1);
			console.log(params);
		}
		var store = grid.getStore();
		if (formObj.isValid()) {
			formObj.submit({
				method : 'POST',
				url : store.getProxy().api['save'],
				params : {
					itemselector : params
				},
				success : function(response, action) {
					// 将JSON对象编译为字符串
					//var str = Ext.encode(action.result.msg);
					Ext.example.msg('', action.result.msg);
					store.load();
				},
				failure : function(response, action) {
					Ext.example.msg('', action.result.msg);
				}
			});
		}
	},
	/**
	 * 删除
	 */
	doDelete : function(grid, tree) {
		if (!grid) {
			Ext.example.msg('提示', '参数传递不正确!');
			return;
		}
		// 得到数据集合
		var store = grid.getStore();
		var records = grid.getSelectionModel().getSelection();
		var data = [];
		Ext.Array.each(records, function(model) {
			data.push(Ext.JSON.encode(model.getId()));
		});
		if (data.length > 0) {
			Ext.Ajax.request({
				url : store.getProxy().api['remove'],
				params : {
					data : data.join(",")
				},
				method : 'POST',
				success : function(response, action) {
					var jsons = Ext.decode(response.responseText);
					Ext.example.msg('', jsons.msg);
					store.load();
					/*Ext.Array.each(records, function(model) {
						// 表格删除数据
						store.remove(model);
					});*/
					if (tree != null) {
						tree.getStore().load();
					}
					/*if (store.getProxy().url != null
							&& store.getProxy().url != "") {
						store.load();
					}*/
				}
			})
		}
	}
});
var curdFactory = Ext.create('WE.tool.CURDFactory', {});