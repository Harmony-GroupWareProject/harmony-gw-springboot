package com.harmony.gw.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

public class IdGenerator implements IdentifierGenerator {
 
   @Override
   public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
       String formattedYear = String.valueOf(LocalDate.now().getYear());

       String queryStr = String.format("select count(id) from %s where id like :prefix", object.getClass().getSimpleName());
       Query<Long> query = session.createQuery(queryStr, Long.class);
       query.setParameter("prefix", formattedYear + "%");
       Long count = query.uniqueResult();

       int num = 1;
       if (count != null) {
           String queryStr1 = String.format("select max(id) from %s where id like :prefix", object.getClass().getSimpleName());
           Query<String> query1 = session.createQuery(queryStr1, String.class);
           query1.setParameter("prefix", formattedYear + "%");
           String maxId = query1.uniqueResult();
           if (maxId != null) {
               String maxIdStr = maxId.toString();
               num = Integer.parseInt(maxIdStr.substring(maxIdStr.lastIndexOf("-") + 1)) + 1;
           }
       }  

     
       String suffix = String.format("%06d", num);
       

       return formattedYear + "-" + suffix;
   }

}
