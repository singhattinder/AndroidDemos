package com.developtech.contactapp.beans;

import java.io.Serializable;

/**
 * Created by Attinder on 25/03/16.
 */
public class ContactBean implements Serializable {

    private int contact_id;
    private String firstname,lastname;
    private String contact;
    private String emailid,address,dob;

    public String getFirstName() {return firstname;}
    public String getLastName() {return lastname;}

    public String getContact() {return contact;}

    public String getEmailid() {return emailid;}

    public String getAddress() {return address;}

    public String getDob() {return dob;}
    public int getContact_id(){return contact_id;}


    //Setters

    public void setContact(String contact) {this.contact=contact;}

    public void setContact_id(int contact_id) {this.contact_id=contact_id;}

    public void setFirstName(String firstname) {this.firstname=firstname;}

    public void setLastname(String lastname) {this.lastname=lastname;}

    public void setEmailid (String emailid) {this.emailid=emailid;}

    public void setAddress (String address) {this.address=address;}

    public  void setDob (String dob) {this.dob=dob;}



}
