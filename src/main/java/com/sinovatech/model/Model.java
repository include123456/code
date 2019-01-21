package com.sinovatech.model;

import com.sinovatech.annotation.Table;
import com.sinovatech.annotation.TableFiled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 这是个模板,依靠此文件生成 hmb.xml,DTO ,Dao ,Service ,ServiceImpl,sql
 */

@Component
@Table(clazzName = "Tb2bCustomerDTO", name = "B2B_CUSTOMER", comment = "c端用户信息表映射")
public class Model {

    @TableFiled(comment = "主键")
    String id;
    @TableFiled(comment = "登录工号", length = "32")
    String loginCode;
    @TableFiled(comment = "登录密码", length = "32")
    private String password;
    @TableFiled(comment = "手机号码", length = "20")
    private String phoneNo;
    @TableFiled(comment = "姓名", length = "50")
    private String name;
    @TableFiled(comment = "客户状态", length = "32")
    private String status;
    @TableFiled(comment = "是否同意协议（0-未同意，1-已同意)", length = "50")
    private String agreementOrNot;
    @TableFiled(comment = "注册时间")
    private Date registerTime;
    /** 修改时间 */
    @TableFiled(comment = "修改时间")
    private Date updateTime;
    /** 冻结时间 */
    @TableFiled(comment = "冻结时间")
    private Date freezeTime;
    @TableFiled(comment = "邮箱", length = "32")
    private String email;

}
