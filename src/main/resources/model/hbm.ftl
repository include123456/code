<#if hbm??>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">

<hibernate-mapping>
    <class name="com.sinovatech.b2b.b2b.model.dto.${hbm.clazzName}"
           table="${hbm.tableName}">
        <comment>${hbm.tableComment}</comment>
    <#list hbm.propList as p>
        <#if p.name == "id">
        <id name="${p.fieldName}" type="${p.type}">
            <column name="CUSTOMER_ID" length="50"/>
            <generator class="uuid.hex"/>
        </id>
        </#if>
        <property name="loginCode" type="java.lang.String">
            <column name="LOGIN_CODE" length="50">
                <comment>登录工号</comment>
            </column>
        </property>
    </#list>
    </class>
</hibernate-mapping>
</#if>