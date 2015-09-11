Ext.define('WE.tool.ShowMessage', {
	/**
	 * 表单验证信息
	 */
	formSubmit : function(icon) {
		if (icon == 0) {
			icon = Ext.MessageBox.INFO;
		} else if(icon == 1) {
			icon = Ext.MessageBox.WARNING;
		} else if(icon == 2) {
			icon = Ext.MessageBox.QUESTION;
		} else if(icon == 3) {
			icon = Ext.MessageBox.ERROR;
		}
		Ext.MessageBox.show({
			title : '提示',
			msg : '请核对表单信息，再进行提交',
			icon : icon
		});
	}
});
var showMsg = Ext.create('WE.tool.ShowMessage', {});