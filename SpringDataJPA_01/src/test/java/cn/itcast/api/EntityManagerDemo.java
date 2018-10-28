package cn.itcast.api;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

//EntityManager对象详解
//功能: 封装了JPA中的一切数据库操作 => 无论增删改查都是通过该对象来完成
public class EntityManagerDemo {

 //增|查|改|删|JPQL查询
 @Test
 //新增
  public void fun1() {
    //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //创建客户对象
  Customer c = new Customer();
  c.setCust_name("传智播客");
  //调用api保存
  em.persist(c);
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }
 @Test
 //查=> OID查询
 public void fun2_1() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //------------------------------------------------------------------------------
  //查询id为1的客户
  Customer customer = em.find(Customer.class, 1l);//立即加载
  System.out.println("hehe");
  System.out.println(customer);
  //------------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }
 @Test
 //查=> OID查询
 public void fun2_2() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //------------------------------------------------------------------------------
  //查询id为1的客户
  //延迟加载 => 查询时并不真正查询数据库.先返回一个具有查询功能的代理对象,使用对象时,对象自动查询数据库加载数据
  Customer customer = em.getReference(Customer.class, 1l);
  System.out.println("hehe");
  System.out.println(customer);
  //------------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }

 @Test
 //修改 => 先查后改
 public void fun3() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //------------------------------------------------------------------------------
  //查询id为1的客户
  Customer customer = em.find(Customer.class, 1l);
  //修改属性
  customer.setCust_name("黑马程序员");
  //修改
  em.merge(customer);
  //------------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }

 @Test
 //删除 => 先查后删
 public void fun4() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //------------------------------------------------------------------------------
  //查询id为1的客户
  Customer customer = em.find(Customer.class, 1l);
  //删除
  em.remove(customer);
  //------------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }
}
