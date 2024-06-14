package com.Event.Management.Model;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

    @Table(name="user")
    @Entity

    public class UserModelData {

        @Id
        @Column(name="id",length=50)
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer id;

        @Column(name="fname",length=50)
        private  String fname;


        @Column(name="lname",length=50)
        private  String lname;


        @Column(name="email",length=50,unique = true)

        private  String email;


        @Column(name="password",length=50)
        private  String password;

        public UserModelData() {

        }

        public UserModelData(Integer id,String fname,String lname,String email,String pasword) {
            super();
            this.id=id;
            this.fname=fname;
            this.lname=lname;
            this.email=email;
            this.password=pasword;

        }

        public Integer getId() {
            return this.id;
        }

        public String getfname() {
            return this.fname;
        }
        public String getlname() {
            return this.lname;
        }
        public String getemail() {
            return this.email;
        }
        public String getpassword() {
            return this.password;
        }

    }


