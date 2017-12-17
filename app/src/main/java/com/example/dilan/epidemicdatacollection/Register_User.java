package com.example.dilan.epidemicdatacollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Register_User extends AppCompatActivity {

    EditText nic;
    EditText firstName;
    EditText middleName;
    EditText lastName;
    EditText gender;
    EditText dob;
    EditText age;
    EditText houseNo;
    EditText street;
    EditText town;
    EditText city;
    EditText province;
    EditText contactNo;
    EditText password;
    EditText hint;

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__user);

        nic = findViewById(R.id.nic);
        firstName = findViewById(R.id.first_name);
        middleName = findViewById(R.id.middle_name);
        lastName = findViewById(R.id.last_name);
        gender = findViewById(R.id.gender);
        dob = findViewById(R.id.dob);
        age = findViewById(R.id.age);
        houseNo = findViewById(R.id.house_number);
        street = findViewById(R.id.street);
        town = findViewById(R.id.town);
        city = findViewById(R.id.city);
        province = findViewById(R.id.province);
        contactNo = findViewById(R.id.contact_no);
        password = findViewById(R.id.pword);
        hint = findViewById(R.id.pword_hint);

        register = (Button) findViewById(R.id.register_User);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nicText = nic.getText().toString();
                String firstNameText = firstName.getText().toString();
                String lastNameText = lastName.getText().toString();
                String middleNameText = middleName.getText().toString();
                String genderText = gender.getText().toString();
                String dobText = dob.getText().toString();
                String ageText = age.getText().toString();
                String houseNoText = houseNo.getText().toString();
                String streetText = street.getText().toString();
                String townText = town.getText().toString();
                String cityText = city.getText().toString();
                String provinceText = province.getText().toString();
                String contactNoText = contactNo.getText().toString();
                String passwordText = password.getText().toString();
                String hintText = hint.getText().toString();


                RequestQueue queue = Volley.newRequestQueue(Register_User.this);

                //CHANGE THE URL TO THE RELEVANT PHP PAGE
                String url = "http://192.168.8.101/Login%20Data/reqRegister.php";

                JSONObject params = new JSONObject();
                //Edit this PAGE
                try {
                    params.put("patient_nic", nicText);
                    params.put("firstName", firstNameText);
                    params.put("middleName", middleNameText);
                    params.put("lastName", lastNameText);
                    params.put("gender", genderText);
                    params.put("birthday", dobText);
                    params.put("houseNo", houseNoText);
                    params.put("age", ageText);
                    params.put("street", streetText);
                    params.put("town", townText);
                    params.put("city", cityText);
                    params.put("province", provinceText);
                    params.put("contactNo", contactNoText);
                    params.put("password", passwordText);
                    params.put("hint", hintText);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String success = null;
                        String message = null;

                        try {
                            success = response.getString("success");
                            message = response.getString("message");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if(success.equals("1")){
                            Toast.makeText(Register_User.this,message,Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Register_User.this,message,Toast.LENGTH_LONG).show();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.getMessage());
                        Toast.makeText(Register_User.this,"Connection failure",Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(request);
            }
        });

    }
}