package com.forewei.freemarker.creator.impl;

import com.forewei.freemarker.bean.Conf;
import com.forewei.freemarker.bean.Constants;
import com.forewei.freemarker.bean.TableInfo;
import com.forewei.freemarker.creator.AbstractFileCreator;

/**
 * 创建mapperClass
 *
 * @author forewei
 */
public class DaoClassCreator extends AbstractFileCreator {
	private static DaoClassCreator creator;

	private DaoClassCreator() {
		super();
	}

	private DaoClassCreator(Conf conf) {
		super();
		init(conf);
	}

	public static synchronized DaoClassCreator getInstance(Conf conf) {
		if (null == creator) {
			creator = new DaoClassCreator(conf);
		}
		return creator;
	}

	@Override
	public String getFileName(TableInfo tableInfo) {
		return tableInfo.getBeanName() + conf.getDaoName() + Constants.JAVA_SUFFIX;
	}

	@Override
	public String getTempletName() {
		return ModuleEnum.Dao.name() + Constants.TEMPLET_SUFFIX;
	}

	@Override
	public String getDirPath() {
		return javaPath + conf.getDaoPackage();
	}

	@Override
	public void setPackageName(TableInfo tableInfo) {
		String daoPackage = conf.getBasePackage() + Constants.PACKAGE_SEPARATOR + conf.getDaoPackage();
		tableInfo.setDaoPackage(daoPackage);
	}

}
