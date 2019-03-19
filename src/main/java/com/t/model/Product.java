package com.t.model;

import com.t.annotation.Table;
import com.t.annotation.TableFiled;

@Table(clazzName = "Tb2bProductDTO", tableName = "B2B_PRODUCT", comment = "商品信息表")
public class Product {

    @TableFiled(comment = "主键")
    String id;
    @TableFiled(comment = "用户名", length = "100")
    String productName;
}
