package com.example.serviceddm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;
    EditText et_username, et_password, et_email, et_phone_number;
    TextView link1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btn_register);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_email = findViewById(R.id.et_email);
        et_phone_number = findViewById(R.id.et_phone_number);
        link1 = findViewById(R.id.link1);

        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }
    public void register(){
        final String name= et_email.getText().toString();
        final String pass= et_password.getText().toString();
        StringRequest request = new StringRequest(Request.Method.POST, "https://websitename/register1.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("1")){
                            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            //Toast.makeText(Main3Activity.this, "Register Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                            intent.putExtra("email",name);
                            startActivity(intent);
                            User user=new User(RegisterActivity.this);
                            user.setName(name);
                            user.setPass(pass);
                        }else if (response.contains("2")){
                            Toast.makeText(getApplicationContext(), "Already Email register Try other", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Fill The Block", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", et_username.getText().toString());
                params.put("password", et_password.getText().toString());
                params.put("email", et_email.getText().toString());
                params.put("phone", et_phone_number.getText().toString());
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }
}
