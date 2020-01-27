/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UserDao;
import domain.User;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Blaise
 */
@ManagedBean
@SessionScoped
public class userModel extends HttpServlet{
    List<User> userList = new UserDao().FindAll(User.class);
    String message = new String();
    User user = new User();
    List<User> users = new ArrayList<>();   
    User userDetails = new User();
    String searchKey = new String();
    private String username;
    private String password;
    private int id;
    String userdetails;
    private String sid;
   public void createUser(){
       System.out.println(user);
        message = new UserDao().register(user);
        userList = new UserDao().FindAll(User.class);
        user = new User();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));       
   }
   
   
   public String login() throws IOException{
        findUser();
         ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        if(user!=null){
            userdetails = user.getUserType()+"  "+user.getUsername()+" "+user.getPassword();
            sid = user.getUserId();
            
//            HttpSession session = request.getSession();session.setAttribute("session", staff);
            switch (user.getUserType()) {
                case "admin":
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", user);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usernameSession", user.getUsername());
                     ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
                    return "faces/index.xhtml?faces-redirect=true";
                case "student":
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", user);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usernameSession", user.getUsername());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSession", user.getUserId());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("typeSession", user.getUserType());
                    ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
                    return "faces/index.xhtml?faces-redirect=true";
                default:
                    user=null;
                    
                    try {
                        ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(userModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return "faces/login.xhtml";
            }
                  
        }else{
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Wrong Password Or Username"));
           return "/faces/login.xhtml";
        }
    }
//    
        public void findUser(){
        List<User> usersLogin=new UserDao().login(username, password);
        
        if(!usersLogin.isEmpty()){
            for(User u: usersLogin){
               user=u;
            }
        }else{
          user=null;
        } 
    }
        
//        public void findStudent(){
//            
//        List<Student> foundStudent = new StudentDao().findStudent(id);
//        if(!foundStudent.isEmpty()){
//            for(Student u: foundStudent){
//               student=u;
//            }
//        }else{
//          student=null;
//        } 
//    }
        
        
        public void logout() throws IOException{
         FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         user = null;
         ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
         ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml");        
     }
           
//   public void activate(User u){
//        try{
//              new UserDao().Update(u);
//            users=new UserDao().FindAll(User.class);
//             FacesContext.getCurrentInstance().addMessage("users", new FacesMessage(msg, ""));
//        }catch(Exception ex){
//              FacesContext.getCurrentInstance().addMessage("users", new FacesMessage("There is a problem", ""));
//        }
//        
//    }
//        public void block(Users u){
//        try{
//             String msg=new UserDao().update(u);
//            users=new UserDao().findAll(Users.class);
//             FacesContext.getCurrentInstance().addMessage("users", new FacesMessage(msg, ""));
//        }catch(Exception ex){
//            FacesContext.getCurrentInstance().addMessage("users", new FacesMessage("There is a problem", ""));
//        }
//        
//    }
        

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(String userdetails) {
        this.userdetails = userdetails;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    
   
}
