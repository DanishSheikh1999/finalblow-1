package com.android.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.Locale;

public class Uploadacode extends AppCompatActivity implements View.OnClickListener {

    TextView textView,textView2;
    Button button,button2;
    int count=0;

    ObjectAnimator objectAnimator;
    PhotoView imageview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadacode);
        button = findViewById(R.id.next);
        button2 = findViewById(R.id.back);
        textView = findViewById(R.id.stepstextbox);
        textView2=findViewById(R.id.txtView);
       imageview2 = (PhotoView) findViewById(R.id.Blink);

        textView.setText("Step 1: Open Arduino IDE and open a new sketch. ");


        button.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.next:
                switch(count) {
                    case 0:
                        textView.setText("Step 1: Open Arduino I D E and open a new sketch. \nStep 2:" +
                                "Write the code in your blank sketch \n (Image is zoomable)."  );
                        imageview2.setImageResource(R.drawable.blanksketch);
                        objectAnimator=ObjectAnimator.ofFloat(imageview2,View.ALPHA,0.0f,1.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                     //   speak();

                        count = count + 1;
                        break;
                    case 1:
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,1.0f,0.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        textView.setText("Step 3: Go to Tools (then) Board (then) Node MCU");
                        imageview2.setImageResource(R.drawable.board);
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,0.0f,1.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        count = count + 1;
                   //     speak();
                        break;
                    case 2:
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,1.0f,0.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        textView.setText("Step 4: Go to Tools (then) port and select the port your Node MCU is connected to.");
                        imageview2.setImageResource(R.drawable.port);
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,0.0f,1.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();

                        count = count + 1;


                     //   speak();
                        break;
                    case 3:
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,1.0f,0.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        textView.setText("Step 5: Upload the code to your Node MCU ");
                        imageview2.setImageResource(R.drawable.upload);
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,0.0f,1.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();

                        count = count + 1;
                      //  speak();
                        break;

                    case 4:
                        startActivity(new Intent(this, TabbedActivity.class));
                        finish();
                        break;
                }
                break;
            case R.id.back:
                switch(count) {
                    case 0:
                        startActivity(new Intent(this, TabbedActivity.class));
                        finish();
                        break;
                    case 1:
                        textView.setText("Step 1: Open Arduino IDE and open a new sketch. ");
                        imageview2.setImageResource(R.drawable.blanksketch);
                        objectAnimator=ObjectAnimator.ofFloat(imageview2,View.ALPHA,0.0f,1.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        count=count-1;
                        break;

                    case 2:
                        textView.setText("Step 1: Open Arduino I D E and open a new sketch. \nStep 2:" +
                                "Write the code in your blank sketch \n (Doubleclick on the image to zoom in)."  );
                        imageview2.setImageResource(R.drawable.blanksketch);
                        objectAnimator=ObjectAnimator.ofFloat(imageview2,View.ALPHA,0.0f,1.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        count = count - 1;
                        break;
                    case 3:
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,1.0f,0.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        textView.setText("Step 3: Go to Tools (then) Board (then) Node MCU");
                        imageview2.setImageResource(R.drawable.board);
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,0.0f,1.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        count = count - 1;
                        break;
                    case 4:
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,1.0f,0.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        textView.setText("Step 4: Go to Tools (then) port and select the port your Node MCU is connected to.");
                        imageview2.setImageResource(R.drawable.port);
                        objectAnimator=ObjectAnimator.ofFloat(imageview2, View.ALPHA,0.0f,1.0f);
                        objectAnimator.setDuration(500);
                        objectAnimator.start();
                        count = count - 1;
                        break;

                }
                break;
        }


    }

//    void speak(){
//        String texxxt = textView.getText().toString();
//        textToSpeech.speak(texxxt, TextToSpeech.QUEUE_FLUSH, null);
//
//    }

}
