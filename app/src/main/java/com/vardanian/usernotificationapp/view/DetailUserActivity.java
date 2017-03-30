package com.vardanian.usernotificationapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.vardanian.usernotificationapp.R;
import com.vardanian.usernotificationapp.model.User;
import com.vardanian.usernotificationapp.view.users.MainActivity;
import com.vardanian.usernotificationapp.view.users.MainActivityFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailUserActivity extends AppCompatActivity {

    User user = new User();
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_detail);

        if (fragment == null) {
            fragment = new MainActivityFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_detail, fragment)
                    .commit();
        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), MainActivity.class);
////                intent.putExtra(User.class.getName(), user);
//                intent.putExtra("ActivityResult", activityResult);
//                setResult(RESULT_OK, intent);
//                finish();
//            }
//        });
    }

}
