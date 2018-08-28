package com.developtech.sharewave.sharewave.sendreceive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.developtech.sharewave.sharewave.R;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.kryonet.util.InputStreamSender;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.FileInputStream;


public class KryoSender  {
    long l=0;
   static File f;
    String fn;

    public KryoSender(File file,String filename)
    {
        f=file;
        fn=filename;
        KryoServer();

    }


    private void KryoServer()

    {

        final int largeDataSize = 633542;

        final Server server = new Server(10485, 10485);
        server.getKryo().register(byte[].class);
        server.getKryo().register(FileName.class);
        server.getKryo().register(Flag.class);
        new Thread(server).start();

        try{
        server.bind(1234,4321);}
        catch (Exception e)
        {
            Log.i("test",String.valueOf(e));
        }

        Log.i("test","Server running");
        long time=System.currentTimeMillis();
        server.addListener(new Listener() {
            public void connected(Connection connection) {

                Log.i("test","connected");
                FileName file=new FileName();
                file.text=fn;
                System.out.println(file.text);
                connection.sendTCP(file);
            }
        });

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof Flag ) {

                    ByteArrayOutputStream output = new ByteArrayOutputStream(largeDataSize);
                    FileInputStream fis = null;
                    try
                    {
                        fis = new FileInputStream(f);
                        byte[] b1 = new byte[1048];
                        int c;
                        while ((c = fis.read(b1)) != -1) {
                            output.write(b1);
                        }
                    }catch(Exception e)
                    {
                        Log.i("app",String.valueOf(e));
                    }

                    ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
                    // Send data in 512 byte chunks.
                    connection.addListener(new InputStreamSender(input, 1048) {
                        protected void start() {
                            // Normally would send an object so the receiving side knows how to handle the chunks we are about to send.
                            Log.i("app","Starting");
                        }

                        protected Object next(byte[] bytes) {
                            l=l+bytes.length;
                            Log.i("app","sent "+l);
                            return bytes; // Normally would wrap the byte[] with an object so the receiving side knows how to handle it.
                        }
                    });

                }
            }
        });


        long time1=System.currentTimeMillis();
        long time2=(time-time1)/1000;
        Log.i("time","time taken"+time2);

    }

    }

