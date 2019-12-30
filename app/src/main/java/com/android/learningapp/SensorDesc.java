package com.android.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Map;

public class SensorDesc extends AppCompatActivity implements View.OnClickListener {

    Button back;
    TextView desc, title;
    ImageView image;
    String sensorName;
    String Fdesc;
    String Fimag;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_desc);
        Intent intent = getIntent();
       // getData();
        sensorName = intent.getStringExtra("Sensor");
        back = findViewById(R.id.back_button);
        desc = findViewById(R.id.textSensor);
        title = findViewById(R.id.title);
        image = findViewById(R.id.sensor_image);
        back.setOnClickListener(this);
        title.setText(sensorName);
        if("LED".equals(sensorName))
        {
        image.setImageResource(R.drawable.rgbled);
        desc.setText("LED is a digital device which emmits light when a voltage is applied across it. While interfacing an LED with a micro-controller the longer leg (positive terminal) is connected to a digital pin and the shorter leg (negative terminal) is connected to ground (GND) of the micro-controller. Whenever a HIGH signal is given to the digital pin the LED emits light. the HIGH signal is generated on the digital pins with the help of some functions.");
        }
       else if("Potentiometer".equals(sensorName))
        {
            image.setImageResource(R.drawable.ppotentiometer);
            desc.setText("A potentiometer is a three-terminal resistor with a sliding or rotating contact that forms an adjustable voltage divider. If only two terminals are used, one end and the wiper, it acts as a variable resistor or rheostat.\n" +
                                 "\n" +
                    "Potentiometers are commonly used to control electrical devices such as volume controls on audio equipment. Potentiometers operated by a mechanism can be used as position transducers, for example, in a joystick.");
        }
        else if("Switch".equals(sensorName))
        {
            image.setImageResource(R.drawable.dpdtswitch);
            desc.setText("In electrical engineering, a switch is an electrical component that can disconnect or connect the conducting path in an electrical circuit, interrupting the electric current or diverting it from one conductor to another.[1][2] The most common type of switch is an electromechanical device consisting of one or more sets of movable electrical contacts connected to external circuits. When a pair of contacts is touching current can pass between them, while when the contacts are separated no current can flow.");
        }



    }

//    private void getData() {
//        firebaseFirestore.collection("App Resources").document("Sensors").collection(sensorName).document("Sensor")
//                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    assert document != null;
//                    if (document.exists()) {
//                        title.setText(sensorName);
//                        Fdesc = document.getString("Description");
//                        Fimag = document.getString("Image");
//                        desc.setText(Fdesc);
//                        Glide.with(SensorDesc.this).load(Fimag)
//                                .into(image);
//                    }
//                } else {
//                    Log.d("DEBUG Arduino", "Found null document");
//                }
//            }
//        });
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                startActivity(new Intent(SensorDesc.this, CodingBasics.class));
                finish();
                break;
        }
    }
}
