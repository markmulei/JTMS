/**
 * 工厂类
 */
Ext.define('WE.model.ModelFactory', {
	//数据类模型的集合
	models: new Ext.util.MixedCollection(),
	//字段集合
	fields: new Ext.util.MixedCollection(),
	getModelByName : function(modelName, modelId) {
		//声明类，返回类的ClassName
		if (this.models.containsKey(modelName)) {
			return modelName;
		} else {
			//ajax拿到我们的字段集合
			var fields = [];
			if (this.fields.containsKey(modelName)) {
				fields = this.fields.containsKey(modelName);
			} else {
				Ext.Ajax.request({
					url : '/JTMS/base/getModelFields?modelName=' + modelName,
					method : 'POST',
					async : false, //关键，我不需要异步操作
					success : function(response, opts) {
						fields = eval(response.responseText);
					}
				});
			}
			this.fields.add(modelName, fields);
			var newModel = Ext.define(modelName, {
				extend : 'Ext.data.Model',
				idProperty: modelId,
				fields: fields
			});
			this.models.add(modelName, newModel);
			return modelName;
		}
	}
});
var modelFactory = Ext.create('WE.model.ModelFactory', {});