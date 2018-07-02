package com.forewei.freemarker.creator.impl;

import com.forewei.freemarker.bean.Conf;
import com.forewei.freemarker.bean.Constants;
import com.forewei.freemarker.bean.TableInfo;
import com.forewei.freemarker.creator.AbstractFileCreator;

/**
 * 创建bean
 *
 * @author forewei
 */
public class EntityClassCreator extends AbstractFileCreator {

	private static EntityClassCreator creator;

	private EntityClassCreator() {
		super();
	}

	private EntityClassCreator(Conf conf) {
		super();
		init(conf);
	}

	public static synchronized EntityClassCreator getInstance(Conf conf) {
		if (null == creator) {
			creator = new EntityClassCreator(conf);
		}
		return creator;
	}

	@Override
	public String getFileName(TableInfo tableInfo) {
		return tableInfo.getBeanName() + Constants.JAVA_SUFFIX;
	}

	@Override
	public String getTempletName() {
		return ModuleEnum.Entity.name() + Constants.TEMPLET_SUFFIX;
	}

	@Override
	public String getDirPath() {
		return javaPath + conf.getEntityPackage();
	}

	@Override
	public void setPackageName(TableInfo tableInfo) {
		String entityPackage = conf.getBasePackage() + Constants.PACKAGE_SEPARATOR + conf.getEntityPackage();
		tableInfo.setEntityPackage(entityPackage);
	}

}
