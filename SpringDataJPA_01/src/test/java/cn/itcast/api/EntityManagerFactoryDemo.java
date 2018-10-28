package cn.itcast.api;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//EntityManagerFactory对象详解
//功能: 创建EntityManager对象
//特性:  1.资源占用比较大
//      2.线程安全
//结论: 该对象在项目开发中应使用单例模式,确保一个项目中有且只有一个实例存在
public class EntityManagerFactoryDemo {

 @Test
  public void fun1() {
  EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
  //创建EntityManager对象
  EntityManager entityManager = factory.createEntityManager();

 }
}
