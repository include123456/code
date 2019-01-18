package com.sinovatech.model;

import com.sinovatech.annotation.Table;
import com.sinovatech.annotation.TableFiled;
import org.springframework.stereotype.Component;


/**
 * 这是个模板,依靠此文件生成 hmb.xml,DTO ,Dao ,Service ,ServiceImpl,sql
 */


@Component
@Table(clazzName = "Tb2bCustomerDTO", name = "B2B_CUSTOMER", comment = "c端用户信息表映射")
public class Model {

    @TableFiled(length = "32", comment = "主键")
    String id;

    @TableFiled(length = "100", comment = "登录工号")
    String loginCode;

}
