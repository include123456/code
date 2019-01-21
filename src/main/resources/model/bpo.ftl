package com.sinovatech.b2b.b2b.model.bpo;

import com.sinovatech.b2b.b2b.model.dao.b2bCustomerDao;
import com.sinovatech.b2b.b2b.model.dto.Tb2bCustomerDTO;
import com.sinovatech.common.model.bpo.BpoSupport;

public class TBpo extends BpoSupport {

private B2bCustomerDao b2bCustomerDao;

    /**
    * 获取
    *
    * @param id
    * @return
    */
    public Tb2bCustomerDTO get(String id) throws Exception {
        return b2bCustomerDao.get(id);
    }

    /**
    * 保存
    *
    * @param dto
    * @throws Exception
    */
    public void save(Tb2bCustomerDTO dto) throws Exception {
        b2bCustomerDao.save(dto);
    }

    /**
    * 删除
    *
    * @param id
    * @throws Exception
    */
    public void delete(String id) throws Exception {
        b2bCustomerDao.delete(id);
    }

    /**
    * 更新
    *
    * @param dto
    * @throws Exception
    */
    public void update(Tb2bCustomerDTO dto) throws Exception {
        b2bCustomerDao.update(dto);
    }

    /**
    * 通过参数获取dto
    *
    * @author: shuyi
    * @date 2019/1/21 15:23
    */
    public Tb2bCustomerDTO getByParams(Tb2bCustomerDTO dto) throws Exception {
        return b2bCustomerDao.getByParams(dto);
    }

    public b2bCustomerDao getb2bCustomerDao() {
        return b2bCustomerDao;
    }

    public void setb2bCustomerDao(b2bCustomerDao b2bCustomerDao) {
        this.b2bCustomerDao = b2bCustomerDao;
    }
}
