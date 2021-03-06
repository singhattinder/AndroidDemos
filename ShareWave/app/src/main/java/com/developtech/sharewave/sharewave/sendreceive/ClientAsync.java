package com.developtech.sharewave.sharewave.sendreceive;


import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.developtech.sharewave.sharewave.home.EmpBeanSendReceive;
import com.developtech.sharewave.sharewave.home.ServiceSendReceive;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import java.io.FileOutputStream;


/**
 * Created by Attinder on 24/04/16.
 */
public class ClientAsync extends AsyncTask {

    String filename;



    @Override
    protected Object doInBackground(Object[] param) {
        Log.i("app","client started1");

        final Client client = new Client();
        client.getKryo().register(byte[].class);
        client.getKryo().register(FileName.class);
        client.getKryo().register(Flag.class);
        client.start();

        // InetAddress addr = client.discoverHost(4321, 10000);
        //Log.i("test",addr.toString());
        long time=System.currentTimeMillis();
        Log.i("app","client started2");
        client.addListener(new Listener() {

            public void received (Connection connection, Object object) {


                if (object instanceof byte[]) {

                    //   Log.i("app", "received");

                    // Log.i("app", "getting data");
                    int length = ((byte[]) object).length;
                    byte[] b1 = new byte[1048];
                    b1 = (byte[]) object;
                    FileOutputStream fos = null;

                    try {
                        fos = new FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath() + "/"+filename, true);
                        fos.write(b1,0,1048);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                else if(object instanceof FileName)
                {
                    System.out.println("hello");
                    FileName f=(FileName) object;
                    filename=f.text;
//                    EmpBeanSendReceive bean=new EmpBeanSendReceive();
//                    bean.setName(f.text);
//                    bean.setPath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath() + "/"+filename);
//                    bean.setFilesize(15);
//                    bean.setSentdata(15);

                  //  ServiceSendReceive.addData(bean);
                    Log.i("test",f.text);
                    Flag flag=new Flag();
                    connection.sendTCP(flag);
                }

            }

        });

        long time1=System.currentTimeMillis();
        long time2=(time-time1)/1000;
        Log.i("time","time taken in sec"+time2);

        try {
            client.connect(5000,"172.20.10.14",1234,4321);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
}
