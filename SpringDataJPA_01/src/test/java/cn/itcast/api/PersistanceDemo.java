package cn.itcast.api;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//详解Persistance对象
//功能: 用于读取配置文件,并创建EntityManagerFactory对象
public class PersistanceDemo {
 public void fun1(){
  //<persistence-unit name="myJpa" transaction-type="RESOURCE_LOCAL">
  //读取配置文件,并创建EntityManagerFactory对象
  EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
 }
}
