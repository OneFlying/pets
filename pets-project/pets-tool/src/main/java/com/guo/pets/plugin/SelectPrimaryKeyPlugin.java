package com.guo.pets.plugin;

import java.text.MessageFormat;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class SelectPrimaryKeyPlugin extends PluginAdapter {

	private static final String SELECT_KEY_TEMPLATE = "\t<selectKey keyProperty=\"{0}\" resultType=\"java.lang.Long\" order=\"BEFORE\">SELECT S_{0}.NEXTVAL AS ID FROM DUAL</selectKey>";

	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.PluginAdapter#sqlMapInsertElementGenerated(
	 * org.mybatis.generator.api.dom.xml.XmlElement,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

		List<IntrospectedColumn> primaryKeys = introspectedTable.getPrimaryKeyColumns();

		if (primaryKeys.size() == 0 || primaryKeys.size() > 1)
			return true;

		final String alias = introspectedTable.getTableConfiguration().getAlias();
		final IntrospectedColumn primaryKeyColumn = primaryKeys.get(0);

		Element el = new Element() {

			@Override
			public String getFormattedContent(int indentLevel) {
				return MessageFormat.format(SELECT_KEY_TEMPLATE, primaryKeyColumn.getActualColumnName());
			}

		};
		element.addElement(el);

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.PluginAdapter#sqlMapInsertSelectiveElementGenerated
	 * (org.mybatis.generator.api.dom.xml.XmlElement,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		return sqlMapInsertElementGenerated(element, introspectedTable);
	}

}
