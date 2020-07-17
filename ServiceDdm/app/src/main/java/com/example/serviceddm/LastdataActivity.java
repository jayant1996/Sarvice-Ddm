package com.example.serviceddm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;

public class LastdataActivity extends AppCompatActivity {
    TextView listdata, category,mobile_no,address,des;
    ImageView imageView;
    ImageView call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastdata);
        listdata = findViewById(R.id.listdata);
        category = findViewById(R.id.category);
        mobile_no = findViewById(R.id.mobile_no);
        address = findViewById(R.id.address);
        des = findViewById(R.id.des);
        call = findViewById(R.id.call);
        imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        String receivedDes =  intent.getStringExtra("des");
        String receivedMobile_no =  intent.getStringExtra("mobile_no");
        String receivedAddress =  intent.getStringExtra("address");
        String receivedCategory =  intent.getStringExtra("category");
        String receivedImage = intent.getStringExtra("imagepath");

        listdata.setText(receivedName);
        category.setText(receivedCategory);
        mobile_no.setText(receivedMobile_no);
        address.setText(receivedAddress);
        des.setText(receivedDes);
        // imageView.setImageResource(receivedImage);
        Glide.with(this).load(receivedImage).into(imageView);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall=new Intent(Intent.ACTION_CALL);
                intentCall.setData(Uri.parse("tel:"+mobile_no.getText().toString()));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(), "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                }else{
                    startActivity(intentCall);
                }
            }
        });

        //enable back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    private void requestPermission(){
        ActivityCompat.requestPermissions(LastdataActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}

