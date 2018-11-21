package com.project.se.arlingtonauto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static Object UserRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setContentView(R.layout.activity_anushree);

        // Adding drop down also known as spinner
        Spinner spinner = findViewById(R.id.user_role);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_role, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                UserRole = parent.getItemAtPosition(pos);
                Log.d("SELECTED ROLE", (String) UserRole);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // Login Button
        Button login = findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Code to check if the user exist will come here !!!
                tostMsg();
                if (UserRole.equals("User")) {
                    startActivity(new Intent(MainActivity.this, Dashboard.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else if (UserRole.equals("Admin")) {
                    startActivity(new Intent(MainActivity.this, AdminDashboard.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else if (UserRole.equals("Manager")) {
                    startActivity(new Intent(MainActivity.this, RentalManager_HomeScreen.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else {
                    Log.d("SELECTED ROLE", (String) UserRole);
                }

//                startActivity(new Intent(MainActivity.this, Anushree.class));
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        Button register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Code to check if the user exist will come here !!!
                registerMsg();
                startActivity(new Intent(MainActivity.this, Registration.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


    }

    private void tostMsg() {
        Context context = getApplicationContext();
        CharSequence text = "Logged In successfully";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void registerMsg() {
        Context context = getApplicationContext();
        CharSequence text = "Please Register !!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
