package ${conf.basePackage}.${conf.daoPackage}<#if table.prefix!="">.${table.prefix}</#if>;

import com.fishsaying.common.db.DBRepository;
import ${conf.basePackage}.${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>.${table.beanName};


/**
* @Author fanwei
* @date ${.now}
*/
@Repository
public class ${table.beanName}Repository extends DBRepository<${table.beanName},${table.properties["id"]}> {


}