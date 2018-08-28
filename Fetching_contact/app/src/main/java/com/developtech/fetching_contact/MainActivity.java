package com.developtech.fetching_contact;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.ListContacts;
import Beans.EmpBean;

public class MainActivity extends AppCompatActivity {
 private ListView listView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

    }

    private void initComponents()

    {
        listView=(ListView)findViewById(R.id.listView);
        ListContacts lc=null;

        ContentResolver cr=getContentResolver();
        Cursor cursor=cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        ArrayList<EmpBean> ar=new ArrayList<>();

        while (cursor.moveToNext()) {

            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String contactId =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

            EmpBean objbean=new EmpBean();
            objbean.setName(name);

            Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
            while (phones.moveToNext()) {
                String number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                objbean.setNumber(number);

            }
            phones.close();
            Cursor emailCur = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + contactId,null, null);

            while (emailCur.moveToNext()) {

                String email = emailCur.getString(emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                objbean.setEmail(email);
            }

            emailCur.close();

            ar.add(objbean);

        }
        cursor.close();

        lc=new ListContacts(MainActivity.this,R.layout.row_layout,ar);
        listView.setAdapter(lc);
    }
}
