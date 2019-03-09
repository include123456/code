<#if dto??>
package com.sinovatech.b2b.b2b.model.dto;

import java.io.Serializable;
    <#list packageSet as package >
import ${package};
    </#list>

/**
* ${dto.tableComment}
*
* @author ${author}
* @date ${.now?string["yyyy-MM-dd HH:mm:ss"]}
*/
public class ${dto.clazzName} extends BaseDtoSupport {

    <#list dto.propList as p>
        /** ${p.comment} */
        private ${p.type?substring(p.type?last_index_of(".")+1)} ${p.fieldName};
    </#list>


    public ${dto.clazzName}() {}

    <#list dto.propList as p>
    public void set${p.fieldName?substring(0,1)?upper_case}${p.fieldName?substring(1)}(${p.type?substring(p.type?last_index_of(".")+1)} ${p.fieldName}) {
        this.${p.fieldName} = ${p.fieldName};
    }

    public ${p.type?substring(p.type?last_index_of(".")+1)} get${p.fieldName?substring(0,1)?upper_case}${p.fieldName?substring(1)}() {
        return ${p.fieldName};
    }

    </#list>
    @Override
    public String toString() {
        return super.toString();
    }
}
</#if>