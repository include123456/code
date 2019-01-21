<#if dao??>
package com.sinovatech.b2b.b2b.model.dao;
<#assign B2bDao>${dao.clazzName?replace("Tb","B")?replace("DTO","Dao")}</#assign>
import com.sinovatech.b2b.b2b.model.dto.${dao.clazzName};
import com.sinovatech.common.dao.BaseDaoSupport;

/**
* ${dao.tableComment}
*
* @author shuyi
* @date ${.now?string["yyyy-MM-dd HH:mm:ss"]}
*/
public class ${B2bDao} extends BaseDaoSupport {

    /**
    * 注入sessionFactory
    *
    * @param sessionFactory
    */
    @Resource(name = "sessionFactory")
    public void setMySessionf(SessionFactory sessionFactory) {
    super.setSessionFactory(sessionFactory);
    }


    /**
    * 获取
    *
    * @param id
    * @return
    * @throws Exception
    */
    public ${dao.clazzName} get(String id) throws Exception {
        return super.getUniqueResult(${dao.clazzName}.class, id);
    }

    /**
    * 保存
    *
    * @param dto
    * @throws Exception
    */
    public void save(${dao.clazzName} dto) throws Exception {
        super.save(dto);
    }

    /**
    * 删除
    *
    * @param id
    * @throws Exception
    */
    public void delete(String id) throws Exception {
        super.delete(${dao.clazzName}.class, id);
    }

    /**
    * 更新
    *
    * @param dto
    * @throws Exception
    */
    public void update(${dao.clazzName} dto) throws Exception {
        super.update(dto);
    }

    /**
    * 根据参数获取dto
    *
    * @param dto
    * @return
    */
    public ${dao.clazzName} getByParams(${dao.clazzName} dto) throws Exception {
        return super.getUniqueResultByDTO(dto);
    }
}
</#if>