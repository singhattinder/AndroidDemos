package com.developtech.sharewave.sharewave.home;

/**
 * Created by Attinder on 01/05/16.
 */
public class EmpBeanSendReceive {

    private int filesize;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  void setPath(String path)
    {
        this.path=path;
    }
    public String getPath()
    {
        return path;
    }

    private String path;
    private String name;

    public int getSentdata() {
        return sentdata;
    }

    public void setSentdata(int sentdata) {
        this.sentdata = sentdata;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    private int sentdata;



}
