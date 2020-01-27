/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Rwanda
 */
@Entity
public class Sticker {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private int id;
        private Date date;
        private String quantity;
        
        @OneToOne
    private Technician technician;
        
         @OneToOne
    private Cars cars;

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
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

        public String getQuantity() {
                return quantity;
        }

        public void setQuantity(String quantity) {
                this.quantity = quantity;
        }

        @Override
        public String toString() {
                return "Sticker{" + "id=" + id + ", date=" + date + ", quantity=" + quantity + '}';
        }
        
        
        
        
}