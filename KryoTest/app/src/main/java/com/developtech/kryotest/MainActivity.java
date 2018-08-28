package com.developtech.kryotest;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.kryonet.util.InputStreamSender;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.FileInputStream;

import java.net.URISyntaxException;


public class MainActivity extends AppCompatActivity {
    long l=0;
    private Button btnpick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents()
    {
        btnpick=(Button)findViewById(R.id.btnpick);
        btnpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("video/*");
                startActivityForResult(intent,1);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode==1 && resultCode ==RESULT_OK)
        {
            Uri uri=data.getData();

            try {
                File file = new File(getFilePath(MainActivity.this, uri));
                Log.i("test",file.toString());

                if(file.exists()) {
                    try {



                        KryoServer(file);


                    }
                    catch (Exception e)
                    {

                        Toast.makeText(MainActivity.this,String.valueOf(e),Toast.LENGTH_SHORT).show();
                    }
                }
            }
            catch (Exception e)
            {
                Toast.makeText(MainActivity.this,String.valueOf(e),Toast.LENGTH_SHORT).show();
            }



        }
    }

    public  String getFilePath(Context context, Uri uri) throws URISyntaxException {
        String selection = null;
        String[] selectionArgs = null;
        // Uri is different in versions after KITKAT (Android 4.4), we need to
        if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context.getApplicationContext(), uri)) {
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            } else if (isDownloadsDocument(uri)) {
                final String id = DocumentsContract.getDocumentId(uri);
                uri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
            } else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if ("image".equals(type)) {
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                selection = "_id=?";
                selectionArgs = new String[]{
                        split[1]
                };
            }
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {
                    MediaStore.Images.Media.DATA
            };
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver()
                        .query(uri, projection, selection, selectionArgs, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
    public String getPath(Uri uri)
    {
        String[] projection = { MediaStore.Video.VideoColumns.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) return null;
        int column_index =cursor.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.DATA);
        cursor.moveToFirst();
        String s=cursor.getString(column_index);
        cursor.close();
        return s;
    }




    private void KryoServer(final File file)

    {

        final int largeDataSize = 633542;

        final Server server = new Server(10485, 10485);
        server.getKryo().setRegistrationRequired(false);
        new Thread(server).start();

        try{
        server.bind(1234);}
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,String.valueOf(e),Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(MainActivity.this,"Server running..",Toast.LENGTH_SHORT).show();

        long time=System.currentTimeMillis();
        server.addListener(new Listener() {
            public void connected(Connection connection) {

               // Toast.makeText(MainActivity.this,"Connected",Toast.LENGTH_SHORT).show();
                Log.i("test","connected");


                ByteArrayOutputStream output = new ByteArrayOutputStream(largeDataSize);
                FileInputStream fis = null;
                try
                {
                    fis = new FileInputStream(file);

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
        });
        long time1=System.currentTimeMillis();
        long time2=(time-time1)/1000;
        Log.i("time","time taken"+time2);

    }

    }

