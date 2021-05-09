package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class reg_org extends AppCompatActivity {

    public Button button_register;

    public  EditText editText_orgname, editText_address, editText_phonenumber, editText_district, editText_city, editText_postalcode, editText_username, editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_org);

        editText_orgname = findViewById(R.id.org_name1);
        editText_address = findViewById(R.id.org_address2);
        editText_phonenumber = findViewById(R.id.org_phonenumber3);
        editText_district = findViewById(R.id.org_district4);
        editText_city = findViewById(R.id.org_city5);
        editText_postalcode = findViewById(R.id.org_postalcode6);
        editText_username = findViewById(R.id.org_username7);
        editText_password = findViewById(R.id.org_password8);
        button_register = findViewById(R.id.button_register);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringOrgname = editText_orgname.getText().toString();
                String stringAddress = editText_address.getText().toString();
                String stringPhonenumber = editText_phonenumber.getText().toString();
                String stringDistrict = editText_district.getText().toString();
                String stringCity = editText_city.getText().toString();
                String stringPostalcode = editText_postalcode.getText().toString();
                String stringUsername = editText_username.getText().toString();
                String stringPassword = editText_password.getText().toString();

                if(stringOrgname.length() <= 0 || stringAddress.length() <= 0 || stringPhonenumber.length() <= 0 || stringDistrict.length() <= 0 || stringCity.length() <= 0 || stringPostalcode.length() <= 0 ||stringUsername.length() <= 0 || stringPassword.length() <= 0 )
                {
                    Toast.makeText(reg_org.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }
                else if(stringPhonenumber.length() != 10){
                    Toast.makeText(reg_org.this, "Phone Number should have only 10 numbers", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(reg_org.this);
                    OrganizationModelClass organizationModelClass = new OrganizationModelClass(stringOrgname,stringAddress,stringPhonenumber,stringDistrict,stringCity,stringPostalcode,stringUsername,stringPassword);
                    databaseHelperClass.addOrganization(organizationModelClass);
                    Toast.makeText(reg_org.this, "Add organization Details Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(reg_org.this, organizaion_page.class);
                    startActivity(intent);
                }
            }
        });

      /* button_register.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(reg_org.this, organizaion_page.class);
                startActivity(intent2);
            }
        }));
*/
    }
}