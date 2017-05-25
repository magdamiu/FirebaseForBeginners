package com.magdamiu.firebaseforbeginners;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.magdamiu.firebaseforbeginners.helpers.Utils;
import com.magdamiu.firebaseforbeginners.model.Country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RealtimeDatabaseActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseActivity";
    private TextView firebaseTextView;
    private FirebaseDatabase database;
    private EditText nameEditText, townEditText;
    private ArrayList<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();

        firebaseTextView = (TextView) findViewById(R.id.tv_firebase);
        nameEditText = (EditText) findViewById(R.id.et_name);
        townEditText = (EditText) findViewById(R.id.et_town);
    }


    private void helloWorld() {
        DatabaseReference helloWorldReference = database.getReference("message");

        helloWorldReference.setValue("Hello, World!");

        // Read from the database
        helloWorldReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                firebaseTextView.setText("Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void btnHelloWorld_onClick(View view) {
        helloWorld();
    }

    public void btnAddCountry_onClick(View view) {
        String name = nameEditText.getText().toString();
        String town = townEditText.getText().toString();
        if (!Utils.isEmpty(name) && !Utils.isEmpty(town)) {
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("countries");

            String countryId = mDatabase.push().getKey();
            Country country = new Country();
            country.setName(name);
            country.setTown(town);

            mDatabase.child(countryId).setValue(country);

            nameEditText.setText("");
            townEditText.setText("");
        } else {
            Toast.makeText(RealtimeDatabaseActivity.this, getString(R.string.fill_the_inputs), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnReadCountries_onClick(View view) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("countries");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Country country = null;
                countries = new ArrayList<>();
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    String name = (String) messageSnapshot.child("name").getValue();
                    String town = (String) messageSnapshot.child("town").getValue();
                    country = new Country();
                    country.setName(name);
                    country.setTown(town);
                    countries.add(country);
                }
                firebaseTextView.setText("Countries are: " + countries.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        mDatabase.addValueEventListener(postListener);
    }

}
