/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.User;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import model.userModel;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Rwanda
 */
@Entity
public class Admin {
        
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private int id;
        private Date date;
        private String UserName;
        private String Password;
        
          @OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
          
          

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public String getUserName() {
                return UserName;
        }

        public void setUserName(String UserName) {
                this.UserName = UserName;
        }

        public String getPassword() {
                return Password;
        }

        public void setPassword(String Password) {
                this.Password = Password;
        }

        @Override
        public String toString() {
                return "Admin{" + "id=" + id + ", date=" + date + ", UserName=" + UserName + ", Password=" + Password + '}';
        }
        
        
        
}
