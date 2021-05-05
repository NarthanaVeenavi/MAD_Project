package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Blood_Banks extends AppCompatActivity {

    Button button1, button2;
    EditText blood_bank_name, address, phone_number, district, city, postal_code, username, password, re_password;
    DatabaseHelperClass myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__blood__banks);

        button1 = findViewById(R.id.button_donor);
        blood_bank_name = findViewById(R.id.blood_bank_name);
        address = findViewById(R.id.address);
        phone_number = findViewById(R.id.phone_number);
        district = findViewById(R.id.district);
        city = findViewById(R.id.city);
        postal_code = findViewById(R.id.postal_code);
        username = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        re_password = findViewById(R.id.re_type_password);
        button2 = findViewById(R.id.button_organization);
        myDb = new DatabaseHelperClass(Add_Blood_Banks.this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strBlood_bank_name = blood_bank_name.getText().toString();
                String strAddress = address.getText().toString();
                String strPhoneNumber = phone_number.getText().toString();
                String strDistrict = district.getText().toString();
                String strCity = city.getText().toString();
                String strPostalCode = postal_code.getText().toString();
                String strUserName = username.getText().toString();
                String strPassword = password.getText().toString();
                String strRePassword = re_password.getText().toString();


                /*if(strBlood_bank_name.length() <=0 || strAddress.length() <=0 || strPhoneNumber.length() <= 0 || strDistrict.length() <= 0 || strCity.length() <= 0 || strPostalCode.length() <= 0 || strUserName.length() <= 0 || strPassword.length() <= 0 || strRePassword.length() <= 0 ){
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }
                else if(!strPassword.equals(strRePassword)){
                    Toast.makeText(MainActivity.this, "The Two Passwords do not match. Enter Again", Toast.LENGTH_SHORT).show();
                }
                else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    BloodBankDetailsModelClass bloodBankDetailsModelClass = new BloodBankDetailsModelClass(strBlood_bank_name, strAddress, strPhoneNumber, strDistrict, strCity, strPostalCode, strUserName, strRePassword);
                    databaseHelperClass.addBloodBanks(bloodBankDetailsModelClass);
                    Toast.makeText(MainActivity.this, "Added blood bank successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(MainActivity.this,Dashboard.class);
                    startActivity(intent);
                    //startActivity(getIntent());
                }*/

                if(strBlood_bank_name.length() <=0 || strAddress.length() <=0 || strPhoneNumber.length() <= 0 || strDistrict.length() <= 0 || strCity.length() <= 0 || strPostalCode.length() <= 0 || strUserName.length() <= 0 || strPassword.length() <= 0 || strRePassword.length() <= 0 ){
                    Toast.makeText(Add_Blood_Banks.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(strPassword.equals(strRePassword)){
                        Boolean userCheck = myDb.checkUserName(strUserName);
                        if(userCheck == false){
                            BloodBankDetailsModelClass bloodBankDetailsModelClass = new BloodBankDetailsModelClass(strBlood_bank_name, strAddress, strPhoneNumber, strDistrict, strCity, strPostalCode, strUserName, strRePassword);
                            myDb.addBloodBanks(bloodBankDetailsModelClass);
                            Toast.makeText(Add_Blood_Banks.this, "Added blood bank successfully", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent intent= new Intent(Add_Blood_Banks.this,Dashboard.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Add_Blood_Banks.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Add_Blood_Banks.this, "Password not Matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Add_Blood_Banks.this, Dashboard.class);
                startActivity(intent);

            }
        });
    }
}