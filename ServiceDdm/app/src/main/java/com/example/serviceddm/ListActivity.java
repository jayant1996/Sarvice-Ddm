package com.example.serviceddm;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListActivity extends AppCompatActivity {
    TextView listdata;
    String urladdress="https://websitename/userdata.php?name=";
    String[] name;
    String[] des;
    String[] mobile_no;
    String[] category;
    String[] address;
    String[] imagepath;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listdata = findViewById(R.id.listdata);

        String receivedName =  getIntent().getStringExtra("name");
        // int receivedImage = intent.getIntExtra("image",0);

        listdata.setText(receivedName);

        listView=(ListView)findViewById(R.id.lview);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        CustomListView customListView = new CustomListView(this,name,des,imagepath,mobile_no,category,address);
        listView.setAdapter(customListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),name[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),LastdataActivity.class);
                intent.putExtra("name", name[i]);
                intent.putExtra("des", des[i]);
                intent.putExtra("mobile_no", mobile_no[i]);
                intent.putExtra("category", category[i]);
                intent.putExtra("address", address[i]);
                intent.putExtra("imagepath", imagepath[i]);
                startActivity(intent);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void collectData()

    {
        String urllink= urladdress + listdata.getText().toString().trim();
//Connection
        try{
            URL url=new URL(urllink);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

//JSON
        try{
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            name=new String[ja.length()];
            imagepath=new String[ja.length()];
            mobile_no=new String[ja.length()];
            address=new String[ja.length()];
            category=new String[ja.length()];
            des=new String[ja.length()];


            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                name[i]=jo.getString("full_name");
                imagepath[i]=jo.getString("images");
                mobile_no[i]=jo.getString("mobile_no");
                address[i]=jo.getString("address");
                category[i]=jo.getString("category");
                des[i]=jo.getString("des");



            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
