package com.sinovatech.b2b.customer.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sinovatech.b2b.b2b.model.dto.Tb2bCustomerDTO;
import com.sinovatech.common.dao.BaseDaoSupport;

/**
* c端用户信息
*
* @author shuyi
* @date 2019.01.16
*/
@Repository
public class B2bCustomerDao extends BaseDaoSupport {

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
* 保存
*
* @param dto
* @throws Exception
*/
public void save(Tb2bCustomerDTO dto) throws Exception {
super.save(dto);
}

/**
* 通过账户密码获取c端用户信息
*
* @param loginCode
* @param password
* @return
* @throws Exception
*/
public Tb2bCustomerDTO getByLoginCodeAndPwd(String loginCode, String password) throws Exception {
String hql = "from Tb2bCustomerDTO where loginCode = ? and password = ? ";
return super.getUniqueResult(hql, loginCode, password);
}

/**
* 根据登录工号获取c端用户信息
*
* @param loginCode
* @return
* @throws Exception
*/
public Tb2bCustomerDTO getByLoginCode(String loginCode) throws Exception {
return super.getUniqueEntityBySQL("select * from b2b_customer c where c.login_code = ? ", Tb2bCustomerDTO.class,
loginCode);
}

/**
* 根据参数获取dto
*
* @param dto
* @return
*/
public Tb2bCustomerDTO getByParams(Tb2bCustomerDTO dto) throws Exception {
return super.getUniqueResultByDTO(dto);
}

}
