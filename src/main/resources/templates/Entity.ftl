<#-- bean template -->
package ${conf.basePackage}.${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>;

import com.fishsaying.common.db.Column;
import com.fishsaying.common.db.Table;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
<#list table.propTypePackages as package>
${package}
</#list>

/**
*  @Author fanwei
*  @date ${.now}
*/
<#if  table.properties["id"]=="Integer">
@Table(name="${table.tableName}",idAuto=true)
<#else>
@Table(name="${table.tableName}")
</#if>
public class ${table.beanName}  implements Serializable {
	/**
	* serialVersionUID
	*/
	private static final long serialVersionUID = 1L;

<#--
<#assign properties = table.properties/>
<#assign propInfoMap = table.propInfoMap/>
<#assign keys = propInfoMap?keys/>
-->

<#assign allPropInfo = table.allPropInfo/>
<#list allPropInfo as prop>
    <#if prop.propertyDesc != "">
    /**
    * ${prop.propertyDesc}
    */
	</#if>
	<#if table.propertiesAnColumns[prop.propertyName]?index_of("_")!=-1 >
    @Column("${table.propertiesAnColumns[prop.propertyName]}")
	</#if>
	<#if prop.propertyDesc!="">
    @ApiModelProperty("${prop.propertyDesc}")
	</#if>
	private ${prop.propertyType} ${prop.propertyName};

</#list>

<#list allPropInfo as prop>
	public ${prop.propertyType} get${prop.propertyName?cap_first}() {
	return this.${prop.propertyName};
	}
	public void set${prop.propertyName?cap_first}(${prop.propertyType} ${prop.propertyName}) {
	this.${prop.propertyName} = ${prop.propertyName};
	}

</#list>
<#--
<#list keys as key>
	/**
	 * 获取${propInfoMap["${key}"].propertyDesc}
	 */
	public ${properties["${key}"]} get${key?cap_first}() {
		return this.${key};
	}

	/**
	 * 设置${propInfoMap["${key}"].propertyDesc}
	 */
	public void set${key?cap_first}(${properties["${key}"]} ${key}) {
		this.${key} = ${key};
	}

</#list>
-->
	public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
