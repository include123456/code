package com.sinovatech.b2b.b2b.model.service.impl;
<#assign B2bDao>${serviceImpl.clazzName?replace("Tb","B")?replace("DTO","Dao")}</#assign>
<#assign b2bDao>${serviceImpl.clazzName?replace("Tb","b")?replace("DTO","Dao")}</#assign>
<#assign B2bService>${serviceImpl.clazzName?replace("Tb","B")?replace("DTO","Service")}</#assign>
<#assign b2bServiceImpl>${serviceImpl.clazzName?replace("Tb","B")?replace("DTO","ServiceImpl")}</#assign>

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinovatech.b2b.b2b.model.dao.${B2bDao};
import com.sinovatech.b2b.b2b.model.dto.${serviceImpl.clazzName};
import com.sinovatech.b2b.b2b.model.service.${B2bService};

/**
* ${serviceImpl.tableComment}
*
* @author ${author}
* @date ${.now?string["yyyy-MM-dd HH:mm:ss"]}
*/
@Service
public class ${b2bServiceImpl} implements ${B2bService} {

    @Autowired
    private ${B2bDao} ${b2bDao};

    /**
    * 获取
    *
    * @param id
    * @return
    */
    @Override
    public ${serviceImpl.clazzName} get(String id) throws Exception {
        return ${b2bDao}.get(id);
    }

    /**
    * 保存
    *
    * @param dto
    * @throws Exception
    */
    @Override
    public void save(${serviceImpl.clazzName} dto) throws Exception {
        ${b2bDao}.save(dto);
    }

    /**
    * 删除
    *
    * @param id
    * @throws Exception
    */
    @Override
    public void delete(String id) throws Exception {
        ${b2bDao}.delete(id);
    }

    /**
    * 更新
    *
    * @param dto
    * @throws Exception
    */
    @Override
    public void update(${serviceImpl.clazzName} dto) throws Exception {
        ${b2bDao}.update(dto);
    }

    /**
    * 通过参数获取dto
    *
    * @param dto
    * @throws Exception
    */
    @Override
    public ${serviceImpl.clazzName} getByParams(${serviceImpl.clazzName} dto) throws Exception {
        return ${b2bDao}.getByParams(dto);
    }

}
