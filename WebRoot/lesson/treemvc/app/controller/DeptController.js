Ext.define('LESSON.controller.DeptController', {
	extend : 'Ext.app.Controller',
	init : function() {
		this.control({
			'depttree button[id=allopen]' : {
				click : function(b, e) {
					var tree = b.up('depttree');
					tree.expandAll();
				}
			},
			'depttree button[id=allclose]' : {
				click : function(b, e) {
					var tree = b.up('depttree');
					tree.collapseAll();
				}
			},
			'depttree button[id=add]' : {
				click : function(b, e) {
					var tree = b.up('depttree');
					var nodes = tree.getChecked();
					if (nodes.length == 1) {
						/*var node = nodes[0];
						node.appendChild({
							checked : true,
							text : '新增1',
							id : '0103',
							leaf : true
						});*/
					} else {
						alert("请您选择一个节点");
					}
				}
			},
			'depttree' : {
				itemclick : function(tree, record, item, index, e, options) {
					alert(record.get('id'));
				}
			}
		});
	},
	views : [
		'DeptTree'
	],
	stores : [
		'DeptStore'
	],
	models : [
		
	] 
})