package com.test.model;

import com.test.annotation.Table;
import com.test.annotation.TableFiled;

@Table(clazzName = "Tb2bProductDTO", name = "B2B_PRODUCT", comment = "商品信息表")
public class Product {

    @TableFiled(comment = "主键")
    String id;
    @TableFiled(comment = "用户名", length = "100")
    String productName;
}
