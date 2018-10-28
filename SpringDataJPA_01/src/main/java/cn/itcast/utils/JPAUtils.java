package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

 private static EntityManagerFactory factory;

 static{
  //创建EntityManagerFactory(确保只创建一次)
   factory = Persistence.createEntityManagerFactory("myJpa");
 }

  //获得EntityManager
  public static EntityManager createEntityManager(){

   //创建EntityManager对象
   EntityManager entityManager = factory.createEntityManager();

   return entityManager;
  }

}
