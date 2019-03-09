<#if service??>
    package com.sinovatech.b2b.b2b.model.service;
    <#assign B2bService>${service.clazzName?replace("Tb","B")?replace("DTO","Service")}</#assign>

    import com.sinovatech.b2b.b2b.model.dto.${service.clazzName};

    /**
    * ${service.tableComment}
    *
    * @author ${author}
    * @date ${.now?string["yyyy-MM-dd HH:mm:ss"]}
    */
    public interface ${B2bService} {

    /**
    * 获取
    *
    * @param id
    * @return
    */
    ${service.clazzName} get(String id) throws Exception;

    /**
    * 保存
    *
    * @param dto
    * @throws Exception
    */
    void save(${service.clazzName} dto) throws Exception;

    /**
    * 删除
    *
    * @param id
    * @throws Exception
    */
    public void delete(String id) throws Exception;

    /**
    * 更新
    *
    * @param dto
    * @throws Exception
    */
    public void update(${service.clazzName} dto) throws Exception;

    /**
    * 通过参数获取dto
    *
    * @param dto
    * @throws Exception
    */
    ${service.clazzName} getByParams(${service.clazzName} dto) throws Exception;

    }
</#if>