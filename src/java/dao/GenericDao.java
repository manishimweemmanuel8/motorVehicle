/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernateutility.NewHibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Blaise
 */
public class GenericDao<X> {

    public String register(X s) {
        try {
          Session ss = NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(s);
        ss.getTransaction().commit();
        
        ss.close();  
        return "Saved well!";
        } catch (Exception e) {
           return e.getCause().getMessage();
        }

    }

    public void Update(X s) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(s);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Delete(X s) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(s);
        ss.getTransaction().commit();
        ss.close();
    }

    public List<X> FindAll(Class c) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from " + c.getName() + "");
        List<X> list = q.list();
        ss.close();
        return list;
    }

    public X FindById(Class c, Serializable id) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        X s = (X) ss.get(c, id);
        ss.close();
        return s;
    }
}