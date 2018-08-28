package com.developtech.sharewave.sharewave.home;

import com.developtech.sharewave.sharewave.home.EmpBeanSendReceive;

import java.util.ArrayList;

/**
 * Created by Attinder on 01/05/16.
 */

public class ServiceSendReceive {


    private static ArrayList<EmpBeanSendReceive> al=new ArrayList<>();

    public ServiceSendReceive()
    {

        EmpBeanSendReceive objbean=new EmpBeanSendReceive();
        objbean.setFilesize(12);
        objbean.setSentdata(12);
        objbean.setName("Song");
        objbean.setType("audio");
        al.add(objbean);

        EmpBeanSendReceive objbean1=new EmpBeanSendReceive();
        objbean1.setFilesize(11);
        objbean1.setSentdata(11);
        objbean1.setName("Song 2");
        objbean1.setType("audio");
        al.add(objbean1);

        EmpBeanSendReceive objbean3=new EmpBeanSendReceive();
        objbean3.setFilesize(2);
        objbean3.setSentdata(2);
        objbean3.setName("Image 2");
        objbean3.setType("image");
        al.add(objbean3);

    }

    public static ArrayList getSentList()
    {
        return al;
    }



    public static void addData(EmpBeanSendReceive objbean)
    {
        al.add(objbean);


    }
}
