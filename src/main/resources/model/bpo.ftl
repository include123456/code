<#if bpo??>
package com.sinovatech.b2b.b2b.model.bpo;
<#assign B2bDao>${bpo.clazzName?replace("Tb","B")?replace("DTO","Dao")}</#assign>
<#assign b2bDao>${bpo.clazzName?replace("Tb","b")?replace("DTO","Dao")}</#assign>
<#assign B2bBpo>${bpo.clazzName?replace("Tb","B")?replace("DTO","Bpo")}</#assign>
import com.sinovatech.b2b.b2b.model.dao.${B2bDao};
import com.sinovatech.b2b.b2b.model.dto.${bpo.clazzName};
import com.sinovatech.common.model.bpo.BpoSupport;

/**
* ${bpo.tableComment}
*
* @author shuyi
* @date ${.now?string["yyyy-MM-dd HH:mm:ss"]}
*/
public class ${B2bBpo} extends BpoSupport {

private ${B2bDao} ${b2bDao};

    /**
    * 获取
    *
    * @param id
    * @return
    */
    public ${bpo.clazzName} get(String id) throws Exception {
        return ${b2bDao}.get(id);
    }

    /**
    * 保存
    *
    * @param dto
    * @throws Exception
    */
    public void save(${bpo.clazzName} dto) throws Exception {
        ${b2bDao}.save(dto);
    }

    /**
    * 删除
    *
    * @param id
    * @throws Exception
    */
    public void delete(String id) throws Exception {
        ${b2bDao}.delete(id);
    }

    /**
    * 更新
    *
    * @param dto
    * @throws Exception
    */
    public void update(${bpo.clazzName} dto) throws Exception {
        ${b2bDao}.update(dto);
    }

    /**
    * 通过参数获取dto
    *
    * @param dto
    * @throws Exception
    */
    public ${bpo.clazzName} getByParams(${bpo.clazzName} dto) throws Exception {
        return ${b2bDao}.getByParams(dto);
    }

    public ${B2bDao} get${B2bDao}() {
        return ${b2bDao};
    }

    public void set${B2bDao}(${B2bDao} b2bCustomerDao) {
        this.${b2bDao} = ${b2bDao};
    }
}
</#if>