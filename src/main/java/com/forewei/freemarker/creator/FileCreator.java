package com.forewei.freemarker.creator;

import java.io.File;
import java.io.IOException;

import com.forewei.freemarker.bean.TableInfo;

import freemarker.template.TemplateException;

/**
 *
 */
public interface FileCreator {
	public static final String separator = File.separator;

	void createFile(TableInfo tableInfo) throws IOException, TemplateException;

	String getFileName(TableInfo tableInfo);

	String getTempletName();
	
	String getDirPath();
	
	void setPackageName(TableInfo tableInfo);
}
