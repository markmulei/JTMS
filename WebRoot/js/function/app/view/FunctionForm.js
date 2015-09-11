var required = '<span style="color:red;font-weight:bold" data-qtip="Required">＊</span>';
Ext.define('WE.function.app.view.FunctionForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.functionForm',
	uses : ['js.ux.TreeComboBox'],
	layout : 'auto',
	align : 'right',
	margin : '20 0 0 30',
	border : false,
	fieldDefaults : {
    	msgTarget : 'side',
    	labelAlign : 'right',
  		labelWidth : 100,
  		width : 500
  	},
  	defaultType: 'textfield',
	items : [{
		name : 'id',
		hidden : true
	}, {
		fieldLabel : '功能名称',
		name : 'fun_name',
		allowBlank : false, //是否允许为空
		beforeLabelTextTpl: required
	}, {
		xtype : 'combo',
		fieldLabel : '类型',
		name : 'fun_type',
		allowBlank : false,
		beforeLabelTextTpl : required,
		editable : false,
		fields : ['id', 'text'],
		queryMode : 'local',
		valueField : 'id',
		displayField : 'text',
		triggerAction : 'all',
		store : [['0', '菜单栏'],['1', '功能节点']]
	}, {
		xtype : 'treecombobox',
		fieldLabel : '父节点',
		name : 'fun_pid',
		valueField : 'id',  
    	displayField : 'text',
    	rootVisible : false,
    	store : Ext.create('Ext.data.TreeStore', {
    		fields: ['id','text'],
    		//defaultRootId : 'root',
	    	root: {  
	            expanded: true  
	        },  
	        proxy: {   
	            type : 'ajax',
				url : '/JTMS/function/getChildTree?id=0',
				method : 'POST',
				async : false,
				reader : 'json'  
	        }  
	    })
	}, {
		fieldLabel : '控制器',
		name : 'fun_controller'
	}, {
		fieldLabel : '总体布局',
		name : 'fun_layout'
	}, {
		fieldLabel : '别名',
		name : 'fun_alias'
	}, {
		xtype : 'textareafield',
		fieldLabel : '功能描述',
		name : 'fun_description',
		grow : true,
		anchor : '100%'
	}, {
		name : 'fun_leaf',
		value : true,
		hidden : true
	}, {
		xtype : 'datefield',
		name : 'create_date',
		format: 'Y-m-d',
		hidden : true
	}, {
		name : 'creater',
		hidden : true
	}/*, {
		name : 'fun_checked',
		value : true,
		hidden : true
	}*/],
	initComponent:function(){
		this.callParent(arguments);
	}
})