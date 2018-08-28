package com.developtech.sharewave.sharewave.common.database;

/**
 * Created by Attinder on 04/05/16.
 */
public class EmpBean {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;



    private String contact;

    private String password;
    private String email;
    private String pic;

    private int id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePic(String pic)
    {
        this.pic=pic;
    }
    public String getProfilePic()
    {
        return pic;
    }


}

