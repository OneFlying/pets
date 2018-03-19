package com.guo.pets.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class OptimisticLockPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	@Override
	public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		List<Element> list = element.getElements();

		boolean bool = super.sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);

		return bool;
	}

	@Override
	public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
		return super.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
	}

}
