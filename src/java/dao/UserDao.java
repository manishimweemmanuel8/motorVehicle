/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import domain.User;
import hibernateutility.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Blaise
 */
public class UserDao extends GenericDao<User>{
     public List<User>login(String u,String password){
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        Query q=s.createQuery("from User u where u.username= :v and u.password=:p");
        q.setParameter("v", u);
        q.setParameter("p", password);
        List<User> l=q.list();
        return l;
    }
}
