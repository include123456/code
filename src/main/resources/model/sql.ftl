<#if sql??>
-- Create table
create table ${sql.tableName}
(
<#list sql.propList as p>
    <#if p.fieldName == "id">
${p.name?lower_case} varchar(<#if p.length != "">${p.length}<#else>32</#if>) primary key,
    <#else>
${p.name?lower_case} ${p.type}<#if p.length != "">(${p.length})</#if><#if p_has_next>,</#if>
    </#if>
</#list>
)
-- Add comments to the table
comment on table ${sql.tableName}
is '${sql.tableComment}';
-- Add comments to the columns
<#list sql.propList as p>
comment on column ${sql.tableName}.${p.name?lower_case}
is '${p.comment}';
</#list>
</#if>