package com.sinovatech.b2b.b2b.model.facade;
<#assign B2bBpo>${facade.clazzName?replace("Tb","B")?replace("DTO","Bpo")}</#assign>
<#assign b2bBpo>${facade.clazzName?replace("Tb","b")?replace("DTO","Bpo")}</#assign>
<#assign b2bFacade>${facade.clazzName?replace("Tb","B")?replace("DTO","Facade")}</#assign>

import com.sinovatech.b2b.b2b.model.bpo.${B2bBpo};
import com.sinovatech.b2b.b2b.model.dto.${facade.clazzName};

/**
* ${facade.tableComment}
*
* @author ${author}
* @date ${.now?string["yyyy-MM-dd HH:mm:ss"]}
*/
public class ${b2bFacade} {

        private ${B2bBpo} ${b2bBpo};

        /**
        * 获取
        *
        * @param id
        * @return
        */
        public ${facade.clazzName} get(String id) throws Exception {
                return ${b2bBpo}.get(id);
        }

        /**
        * 保存
        *
        * @param dto
        * @throws Exception
        */
        public void save(${facade.clazzName} dto) throws Exception {
                ${b2bBpo}.save(dto);
        }

        /**
        * 删除
        *
        * @param id
        * @throws Exception
        */
        public void delete(String id) throws Exception {
                ${b2bBpo}.delete(id);
        }

        /**
        * 更新
        *
        * @param dto
        * @throws Exception
        */
        public void update(${facade.clazzName} dto) throws Exception {
                ${b2bBpo}.update(dto);
        }

        /**
        * 通过参数获取dto
        *
        * @param dto
        * @throws Exception
        */
        public ${facade.clazzName} getByParams(${facade.clazzName} dto) throws Exception {
                return ${b2bBpo}.getByParams(dto);
        }

        public ${B2bBpo} get${B2bBpo}() {
                return ${b2bBpo};
        }

        public void set${B2bBpo}(${B2bBpo} ${b2bBpo}) {
                this.${b2bBpo} = ${b2bBpo};
        }
}
