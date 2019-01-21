<#assign B2bDao>${config.clazzName?replace("Tb","B")?replace("DTO","Dao")}</#assign>
<#assign b2bDao>${config.clazzName?replace("Tb","b")?replace("DTO","Dao")}</#assign>
<#assign B2bBpo>${config.clazzName?replace("Tb","B")?replace("DTO","Bpo")}</#assign>
<#assign b2bBpo>${config.clazzName?replace("Tb","b")?replace("DTO","Bpo")}</#assign>
<#assign B2bFacade>${config.clazzName?replace("Tb","B")?replace("DTO","Facade")}</#assign>
<#assign b2bFacade>${config.clazzName?replace("Tb","b")?replace("DTO","Facade")}</#assign>
<!-- ${config.tableComment}-->
<bean id="${b2bDao}" class="com.sinovatech.b2b.b2b.model.dao.${B2bDao}">
    <property name="sessionFactory" ref="sessionFactory" />
</bean>
<bean id="${b2bBpo}" parent="baseTransactionProxy">
    <property name="target">
        <bean class="com.sinovatech.b2b.b2b.model.bpo.${B2bBpo}">
            <property name="${b2bDao}" ref="${b2bDao}" />
        </bean>
    </property>
</bean>
<bean id="${b2bFacade}" class="com.sinovatech.b2b.b2b.model.facade.${B2bFacade}">
    <property name="${b2bBpo}" ref="${b2bBpo}"></property>
</bean>