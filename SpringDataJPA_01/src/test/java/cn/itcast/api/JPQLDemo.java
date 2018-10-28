package cn.itcast.api;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

//JPQL详解
/*功能: 起源于hibernate框架中的HQL(HibernateQueryLanguage)语言
*       JPQL就是JPAQueryLanguage => 语法与HQL基本一致
*       相比SQL语句,JPQL是"面向对象"的查询语言.主要用于查询数据
* */
public class JPQLDemo {

 @Test
 //基本查询
  public void fun1() {
    //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
 //----------------------------------------------------------------------------
  //书写JPQL语句
  //String jpql = "select c from cn.itcast.domain.Customer c ";
  //String jpql = "select c from Customer c ";
  String jpql = " from Customer  ";
  //创建查询对象
  Query query = em.createQuery(jpql);
  //执行
  List<Customer> list = query.getResultList();

  System.out.println(list);
  //----------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }


 @Test
 //分页查询
 public void fun2() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //----------------------------------------------------------------------------
  //书写JPQL语句
  String jpql = " from Customer  ";
  //创建查询对象
  Query query = em.createQuery(jpql);
  //设置分页参数  limit 2,2
   query.setFirstResult(2); //第一个问号
   query.setMaxResults(2);  //第二个问号
  //执行
  List<Customer> list = query.getResultList();

  System.out.println(list);
  //----------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }

 @Test
 //条件查询 => 查询名称中包含"石坤"的记录
 public void fun3_1() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //----------------------------------------------------------------------------
  //书写JPQL语句
  String jpql = " from Customer where cust_name like ?  ";
  //创建查询对象
  Query query = em.createQuery(jpql);
  //设置参数占位符的值
  query.setParameter(1,"%石坤%");
  //执行
  List<Customer> list = query.getResultList();

  System.out.println(list);
  //----------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }
 @Test
 //条件查询 => 查询名称中包含"石坤"的记录
 //命名占位符
 public void fun3_2() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //----------------------------------------------------------------------------
  //书写JPQL语句
  String jpql = " from Customer where cust_name like :abc  ";
  //创建查询对象
  Query query = em.createQuery(jpql);
  //设置参数占位符的值
  query.setParameter("abc","%石坤%");
  //执行
  List<Customer> list = query.getResultList();

  System.out.println(list);
  //----------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }

 @Test
 //排序=>与sql语法基本一致
 public void fun4() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //----------------------------------------------------------------------------
  //书写JPQL语句
  String jpql = " from Customer order by cust_id desc ";
  //创建查询对象
  Query query = em.createQuery(jpql);
  //执行
  List<Customer> list = query.getResultList();

  System.out.println(list);
  //----------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }

 @Test
 //统计
 public void fun5() {
  //获得EntityManager对象
  EntityManager em = JPAUtils.createEntityManager();
  //开启事务
  EntityTransaction tx = em.getTransaction();
  tx.begin();
  //----------------------------------------------------------------------------
  //书写JPQL语句
  //String jpql = "select count(c) from Customer c where cust_name like ? ";
  String jpql = " select count(c.cust_id) from Customer c where cust_name like ? ";
  //创建查询对象
  Query query = em.createQuery(jpql);
  //设置参数
  query.setParameter(1,"%石坤%");
  //执行
  Long count = (Long) query.getSingleResult();

  System.out.println(count);
  //----------------------------------------------------------------------------
  //提交事务
  tx.commit();
  //关闭资源
  em.close();
 }
}
