package com.android.learningapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.android.learningapp.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

import static com.facebook.FacebookSdk.getApplicationContext;

public class FragmentSocial extends Fragment implements View.OnClickListener {

    Button weekly;
    CallbackManager callbackManager;
    LoginButton btnFBLogin;
    CardView facebookLogin;
    ConstraintLayout fb;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FacebookSdk.sdkInitialize(getApplicationContext());
//        callbackManager = CallbackManager.Factory.create();
//        facebookLogin.setOnClickListener(this);
//        btnFBLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Toast.makeText(getContext(), "Success Login" + "\n" +
//                        "User = " + loginResult.getAccessToken().getUserId() + "\n" +
//                        "Token = " + loginResult.getAccessToken().getToken(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException e) {
//
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social, container, false);
        facebookLogin = view.findViewById(R.id.fb_login);
        btnFBLogin = view.findViewById(R.id.fbbtn);
        weekly = view.findViewById(R.id.weekly);
        fb=view.findViewById(R.id.fb);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        facebookLogin.setOnClickListener(this);
        btnFBLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getContext(), "Success Login" + "\n" +
                        "User = " + loginResult.getAccessToken().getUserId() + "\n" +
                        "Token = " + loginResult.getAccessToken().getToken(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
    }

    public void guide() {
        Log.d("Inside the guide", "Social/-guide");
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(getActivity(), "Social");

        sequence.setConfig(config);
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(fb)
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Facebook Login")
                .withRectangleShape()
                .build());
        sequence.setConfig(config);
        sequence.addSequenceItem(new MaterialShowcaseView.Builder(getActivity())
                .setTarget(weekly)
                .setGravity(0)
                .setDismissText("OK")
                .setContentText("Check your weekly activities here")
                .withRectangleShape()
                .build());


        sequence.start();

    }

    public void updateTour(int pos) {
        Log.d("Inside the fragment", "Task" + pos);
        if (pos == 3) {
            guide();
        }


    }

}
