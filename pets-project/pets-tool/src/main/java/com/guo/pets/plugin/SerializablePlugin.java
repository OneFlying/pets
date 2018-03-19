package com.guo.pets.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Random;

public class SerializablePlugin extends PluginAdapter {
	private FullyQualifiedJavaType serializable;

	public SerializablePlugin() {
		super();
		serializable = new FullyQualifiedJavaType("java.io.Serializable"); //$NON-NLS-1$

	}

	public boolean validate(List<String> warnings) {
		// this plugin is always valid
		return true;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	protected void makeSerializable(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		topLevelClass.addImportedType(serializable);
		topLevelClass.addSuperInterface(serializable);

		Field field = new Field();
		field.setFinal(true);
		field.setInitializationString(String.valueOf(new Random().nextLong()) + "L"); //$NON-NLS-1$
		field.setName("serialVersionUID"); //$NON-NLS-1$
		field.setStatic(true);
		field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$
		field.setVisibility(JavaVisibility.PRIVATE);
		context.getCommentGenerator().addFieldComment(field, introspectedTable);

		topLevelClass.addField(field);
	}
}
