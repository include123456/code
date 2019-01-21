<#if hbm??>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">

<hibernate-mapping>
    <class name="com.sinovatech.b2b.b2b.model.dto.${hbm.clazzName}"
           table="${hbm.tableName}">
        <comment>${hbm.tableComment}</comment>
    <#list hbm.propList as p>
        <#if p.fieldName == "id">
        <id name="${p.fieldName}" type="${p.type}">
            <column name="${p.name}" length="<#if p.length != "">${p.length}<#else>32</#if>"/>
            <generator class="uuid.hex"/>
        </id>
        <#else>
        <property name="${p.fieldName}" type="${p.type}">
            <column name="${p.name}" <#if p.length != "">length="${p.length}"</#if>>
                <comment>${p.comment}</comment>
            </column>
        </property>
        </#if>
    </#list>
    </class>
</hibernate-mapping>
</#if>