package cn.itcast.api;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//EntityTransaction对象详解
//功能: 事务管理对象,用于进行事务操作
public class EntityTransactionDemo {

 @Test
  public void fun1() {
  EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
  //创建EntityManager对象
  EntityManager entityManager = factory.createEntityManager();
  //获得EntityTransaction对象
  EntityTransaction tx = entityManager.getTransaction();
  //开启事务
  tx.begin();

  //提交事务
  tx.commit();
  //回滚事务
  tx.rollback();

 }
}
