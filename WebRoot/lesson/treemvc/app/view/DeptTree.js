Ext.define('LESSON.view.DeptTree', {
	extend : 'Ext.tree.Panel',
	alias : 'widget.depttree',
	title : '部门树',
	width : 250,
	height : 300,
	padding : '5 3 3 10',
	rootVisible : false, // 控制根节点显隐的属性
	dockedItems : [{
		xtype : 'toolbar',
		dock : 'top',
		ui : 'footer',
		items : [{
			xtype : 'button', text: '添加', id: 'add'
		}, {
			xtype : 'button', text: '删除', id: 'delete'
		}, {
			xtype : 'button', text: '复制', id: 'copy'
		}]
	}, {
		xtype : 'toolbar',
		dock : 'bottom',
		items : [{
			xtype : 'button',
			id : 'allopen',
			text : '展开全部'
		}, {
			xtype : 'button',
			id : 'allclose',
			text : '收缩全部'
		}]
	}],
	store : 'DeptStore'
	/*root : {
		text : 'root',
		id : '0',
		leaf : false,
		children : [{
			text : '技术部',
			checked : false, // 不被选中的状态
			id : '01',
			leaf : false,
			children : [{
				checked : false,
				text : '研发部',
				id : '0101',
				leaf : true
			}, {
				checked : false,
				text : '实施部',
				id : '0102',
				leaf : true
			}]
		}, {
			text : '运营部',
			checked : false,
			id : '02',
			leaf : false,
			children : [{
				checked : false,
				text : '人事部',
				id : '0201',
				leaf : true
			}, {
				checked : false,
				text : '行政部',
				id : '0202',
				leaf : true
			}]
		}]
	}*/
});