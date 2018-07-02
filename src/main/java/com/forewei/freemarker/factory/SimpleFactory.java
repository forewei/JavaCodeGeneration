package com.forewei.freemarker.factory;

import com.forewei.freemarker.bean.Conf;
import com.forewei.freemarker.bean.TableInfo;
import com.forewei.freemarker.creator.FileCreator;
import com.forewei.freemarker.creator.impl.*;
import com.forewei.freemarker.creator.impl.*;

/**
 * 生成代码
 */
public class SimpleFactory {
	private SimpleFactory() {
		super();
	}

	public static FileCreator create(String module, Conf conf, TableInfo tableInfo) {

		FileCreator creator = null;
		if (module.equals(ModuleEnum.Entity.name())) {
			creator = EntityClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.Controller.name())) {
			creator = ControllerClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.Service.name())) {
			creator = ServiceClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.ServiceTest.name())) {
			creator = ServiceTestClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.ServiceImpl.name())) {
			creator = ServiceImplClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.Dao.name())) {
			creator = DaoClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.MapperXML.name())) {
			creator = XmlCreator.getInstance(conf);
		}
		return creator;

	}
}
