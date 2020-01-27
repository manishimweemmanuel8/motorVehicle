/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Admin;
import domain.User;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Rwanda
 */
@Entity
public class Cars {
                @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private int id;
        private Date date;
        private String plateNo;
        private String type;
        private String Category;
        private String subject;
        private String gasEmission;
        private String speedGov;
        private String comment;
        private String branch;
        
        @ManyToOne
    private User user;
        
        @ManyToOne
    private Technician technician;
        
        @OneToOne(mappedBy = "cars", fetch = FetchType.EAGER)
    private Sticker sticker;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public void setSticker(Sticker sticker) {
        this.sticker = sticker;
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

        public String getPlateNo() {
                return plateNo;
        }

        public void setPlateNo(String plateNo) {
                this.plateNo = plateNo;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getCategory() {
                return Category;
        }

        public void setCategory(String Category) {
                this.Category = Category;
        }

        public String getSubject() {
                return subject;
        }

        public void setSubject(String subject) {
                this.subject = subject;
        }

        public String getGasEmission() {
                return gasEmission;
        }

        public void setGasEmission(String gasEmission) {
                this.gasEmission = gasEmission;
        }

        public String getSpeedGov() {
                return speedGov;
        }

        public void setSpeedGov(String speedGov) {
                this.speedGov = speedGov;
        }

        public String getComment() {
                return comment;
        }

        public void setComment(String comment) {
                this.comment = comment;
        }

        public String getBranch() {
                return branch;
        }

        public void setBranch(String branch) {
                this.branch = branch;
        }

        @Override
        public String toString() {
                return "Cars{" + "id=" + id + ", date=" + date + ", plateNo=" + plateNo + ", type=" + type + ", Category=" + Category + ", subject=" + subject + ", gasEmission=" + gasEmission + ", speedGov=" + speedGov + ", comment=" + comment + ", branch=" + branch + '}';
        }
        
        
        
        
}
