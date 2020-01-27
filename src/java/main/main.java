/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import hibernateutility.NewHibernateUtil;



/**
 *
 * @author Blaise
 */
public class main {
    public static void main(String[] args) {
        NewHibernateUtil.getSessionFactory().openSession();
//
//Province p = new Province();
//        p.setCode("KI");
//        p.setName("KIGALI");
//        new ProvinceDao().register(p);
        
//        Province p = new Province();
//        p.setCode("EA");
//        p.setName("EASTERN");
//        new ProvinceDao().register(p);
        
//           Province p = new Province();
//        p.setCode("WE");
//        p.setName("WESTERN");
//        new ProvinceDao().register(p);

//    Province p = new Province();
//        p.setCode("NO");
//        p.setName("NOTHERN");
//        new ProvinceDao().register(p);

// Province p = new Province();
//        p.setCode("SU");
//        p.setName("SOUTHERN");
//        new ProvinceDao().register(p);

// District d = new District();
//        d.setCode("GAS");
//        d.setName("GASABO");
//        d.setProvince(new ProvinceDao().FindById(Province.class, "KI"));
//        new DistrictDao().register(d);

// District d = new District();
//        d.setCode("NYA");
//        d.setName("NYARUGENGE");
//        d.setProvince(new ProvinceDao().FindById(Province.class, "KI"));
//        new DistrictDao().register(d);

// District d = new District();
//        d.setCode("CYA");
//        d.setName("CYANGUGU");
//        d.setProvince(new ProvinceDao().FindById(Province.class, "EA"));
//        new DistrictDao().register(d);

//        Sector d = new Sector();
//        d.setCode("BUMB");
//        d.setName("BUMBOGO");
//        d.setDistrict(new DistrictDao().FindById(District.class, "GAS"));
//        new SectorDao().register(d);

//   Sector d = new Sector();
//        d.setCode("KIMI");
//        d.setName("KIMIRONKO");
//        d.setDistrict(new DistrictDao().FindById(District.class, "GAS"));
//        new SectorDao().register(d);
        
// Sector d = new Sector();
//        d.setCode("GASO");
//        d.setName("GASOGI");
//        d.setDistrict(new DistrictDao().FindById(District.class, "GAS"));
//        new SectorDao().register(d);
    }   
}
