package com.android.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.learningapp.MicrocontrollersBasics.Breadboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Map;

public class CodingBasics extends AppCompatActivity implements View.OnClickListener, SearchView.OnQueryTextListener{

    Button back, quick, breadboard,upload;
   // androidx.appcompat.widget.SearchView searchView;
    FirebaseFirestore firebaseFirestore;
    ArrayList<String> allTopics = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_coding);
        back = findViewById(R.id.back_button);
        quick = findViewById(R.id.quickstart);
       // searchView = findViewById(R.id.search);
        firebaseFirestore = FirebaseFirestore.getInstance();
        back.setOnClickListener(this);
        quick.setOnClickListener(this);
     //   searchView.setOnQueryTextListener(this);
        allTopics.clear();
        breadboard = findViewById(R.id.breadboard);
        upload=findViewById(R.id.help);

        breadboard.setOnClickListener(this);
        upload.setOnClickListener(this);
        getAllTopics();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(CodingBasics.this, query, Toast.LENGTH_SHORT).show();
        if(allTopics.contains(query))
        {
        Intent intent = new Intent(CodingBasics.this, SyntaxSlide.class);
        intent.putExtra("Topic", query);
        startActivity(intent);
        finish();
        }
        else
            Toast.makeText(CodingBasics.this, "No such topic listed.", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    public void getAllTopics() {
        firebaseFirestore.collection("App Resources").document("Arduino Programming")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    assert document != null;
                    if (document.exists()) {
                        allTopics.clear();
                        Map<String, Object> map = document.getData();
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            if (entry.getKey().equals("All Topics")) {
                                Log.d("TAG", entry.getValue().toString());
                                allTopics = (ArrayList<String>) entry.getValue();
                                Log.d("TAGX", allTopics.toString());
                            }
                        }
                    } else {
                        Log.d("DEBUG Arduino", "Found null document");
                    }
                } else {
                    Log.d("DEBUG Arduino", "Error finding the document");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                startActivity(new Intent(CodingBasics.this, TabbedActivity.class));
                finish();
                break;
            case R.id.quickstart:
                startActivity(new Intent(CodingBasics.this, CodingSlide.class));
                break;
            case R.id.breadboard:
                startActivity(new Intent(CodingBasics.this, Breadboard.class));
                finish();
                break;
                case R.id.help:
                startActivity(new Intent(CodingBasics.this, Uploadacode.class));
                finish();
                break;
        }
    }
}
