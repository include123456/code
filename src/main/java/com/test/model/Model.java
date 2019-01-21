package com.test.model;

import com.test.annotation.Table;
import com.test.annotation.TableFiled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 这是个模板,依靠此文件生成 hmb.xml,DTO ,Dao ,Service ,ServiceImpl,sql
 */
@Table(clazzName = "Tb2bUserDTO", name = "B2B_User", comment = "用户信息表")
public class Model {

    @TableFiled(comment = "主键")
    String id;
    @TableFiled(comment = "用户名", length = "100")
    String userName;
    @TableFiled(comment = "年龄")
    Integer userAge;
    @TableFiled(comment = "创建时间")
    Date createTime;
    @TableFiled(comment = "财产")
    Double userMoney;

}
