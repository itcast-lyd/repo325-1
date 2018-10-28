package cn.itcast.domain;

import javax.persistence.*;

/*
CREATE TABLE cst_customer (
  cust_id bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  cust_name varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
  cust_source varchar(32) DEFAULT NULL COMMENT '客户信息来源',
  cust_industry varchar(32) DEFAULT NULL COMMENT '客户所属行业',
  cust_level varchar(32) DEFAULT NULL COMMENT '客户级别',
  cust_address varchar(128) DEFAULT NULL COMMENT '客户联系地址',
  cust_phone varchar(64) DEFAULT NULL COMMENT '客户联系电话',
  PRIMARY KEY (`cust_id`)
)
 */
//表示该类为实体类
@Entity
//指定该实体类对应数据库中的哪张表
@Table(name="cst_customer")
public class Customer {
 //指定那个属性为与数据库主键列对应的属性 => OID
 @Id
 /*配置属性对应的列
 *  length:指定数据长度
 *  nullable : 是否可以为空
 *  unique : 取值是否唯一
 *  insertable : 是否在插入时维护该属性的值
 *  updatable : 是否在更新时维护该属性的值
 * */
 @Column(name = "cust_id")
 //指定主键生成策略
 /*
  GenerationType.IDENTITY 依赖于数据库的主键自增
  GenerationType.SEQUENCE 依赖于数据库(Oracle)中的序列来生成主键值
  GenerationType.AUTO 自动选择主键生成策略
  GenerationType.TABLE 主键自增 -> 使用Hilo算法由程序实现主键自增,同时需要一张表来存放生成标记.
  不指定主键生成策略=> 需要手动指定主键值
  */
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long cust_id;
 @Column(name="cname")
 private String cust_name;
 @Column
 private String cust_source;
 @Column
 private String cust_industry;
 @Column
 private String cust_level;
 @Column
 private String cust_address;
 @Column
 private String cust_phone;

 public Long getCust_id() {
  return cust_id;
 }

 public void setCust_id(Long cust_id) {
  this.cust_id = cust_id;
 }

 public String getCust_name() {
  return cust_name;
 }

 public void setCust_name(String cust_name) {
  this.cust_name = cust_name;
 }

 public String getCust_source() {
  return cust_source;
 }

 public void setCust_source(String cust_source) {
  this.cust_source = cust_source;
 }

 public String getCust_industry() {
  return cust_industry;
 }

 public void setCust_industry(String cust_industry) {
  this.cust_industry = cust_industry;
 }

 public String getCust_level() {
  return cust_level;
 }

 public void setCust_level(String cust_level) {
  this.cust_level = cust_level;
 }

 public String getCust_address() {
  return cust_address;
 }

 public void setCust_address(String cust_address) {
  this.cust_address = cust_address;
 }

 public String getCust_phone() {
  return cust_phone;
 }

 public void setCust_phone(String cust_phone) {
  this.cust_phone = cust_phone;
 }

 @Override
 public String toString() {
  return "Customer{" +
   "cust_id=" + cust_id +
   ", cust_name='" + cust_name + '\'' +
   '}';
 }
}
