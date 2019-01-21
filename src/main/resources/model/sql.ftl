-- Create table
create table B2B_CUSTOMER
(
customer_id      VARCHAR2(32) not null,
login_code       VARCHAR2(50),
password         VARCHAR2(32),
phone_no         VARCHAR2(50),
name             VARCHAR2(50),
status           VARCHAR2(5),
agreement_or_not VARCHAR2(5),
register_time    DATE,
update_time      DATE,
freeze_time      DATE,
email            VARCHAR2(50)
)
tablespace AHB2B
pctfree 10
initrans 1
maxtrans 255
storage
(
initial 64
minextents 1
maxextents unlimited
);
-- Add comments to the table
comment on table B2B_CUSTOMER
is 'c端用户信息表映射';
-- Add comments to the columns
comment on column B2B_CUSTOMER.customer_id
is 'id主键';
comment on column B2B_CUSTOMER.login_code
is '登录工号';
comment on column B2B_CUSTOMER.password
is '登录密码';
comment on column B2B_CUSTOMER.phone_no
is '手机号码';
comment on column B2B_CUSTOMER.name
is '客户姓名';
comment on column B2B_CUSTOMER.status
is '客户状态（0-待审核，1-审核通过，3-冻结）';
comment on column B2B_CUSTOMER.agreement_or_not
is '是否同意协议（0-未同意，1-已同意）';
comment on column B2B_CUSTOMER.register_time
is '注册时间';
comment on column B2B_CUSTOMER.update_time
is '修改时间';
comment on column B2B_CUSTOMER.freeze_time
is '冻结时间';
comment on column B2B_CUSTOMER.email
is '邮箱';
-- Create/Recreate primary, unique and foreign key constraints
alter table B2B_CUSTOMER
add primary key (CUSTOMER_ID)
using index
tablespace AHB2B
pctfree 10
initrans 2
maxtrans 255
storage
(
initial 64K
minextents 1
maxextents unlimited
);