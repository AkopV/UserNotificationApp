package com.vardanian.usernotificationapp.view.users;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vardanian.usernotificationapp.R;
import com.vardanian.usernotificationapp.interfaces.MVPUserDataManager;
import com.vardanian.usernotificationapp.model.User;
import com.vardanian.usernotificationapp.model.UserData;
import com.vardanian.usernotificationapp.model.UserPicture;
import com.vardanian.usernotificationapp.presenter.UserDataManagerPresenter;
import com.vardanian.usernotificationapp.presenter.UserManagerPresenter;
import com.vardanian.usernotificationapp.utils.RoundedTransformation;
import com.vardanian.usernotificationapp.view.DetailUserActivity;
import com.vardanian.usernotificationapp.view.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

public class MainActivityFragment extends Fragment /*implements MVPUserDataManager.UserDataView*/ {

    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();
    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;

    @BindView(R.id.rv_users)
    RecyclerView rvUsers;
    //    @BindView(R.id.tv_username)
//    TextView tvUserName;
//    @BindView(R.id.iv_user)
//    ImageView iv_user;
    private UserData userDatas;
    private UserAdapter adapter;

//    public MVPUserDataManager.UserPresenter presenter;
    public MVPUserDataManager.UserDataPresenter presenter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        initUI(root);
//        presenter = new UserManagerPresenter();
        presenter = new UserDataManagerPresenter();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

//        presenter.setView(this);
//        presenter.getUsers();
    }

    private void initUI(View root) {

        userDatas = new UserData();
        rvUsers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        setupAdapter();
    }

    private void setupAdapter() {
        userDatas = new UserData();
        adapter = new UserAdapter(getContext(), userDatas);
        rvUsers.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_RESULT_CODE) {
            if (requestCode == RESULT_OK) {
//               String username = data.getStringExtra(userDatas.getResults().get(0).getName().getFirst() + " " +
//               userDatas.getResults().get(0).getName().getLast());

                return;
            }
        }
    }

//    public void updateUI(User user) {
//        Picasso.with(getContext())
//                .load(user.getPicture().getLarge())
//                .placeholder(R.drawable.ic_user_48x48)
//                .transform(new RoundedTransformation(100, 4))
//                .into(iv_user);
//    }

//    @Override
//    public void onUserDataReceived(UserData userData) {
//        this.userDatas.getResults().clear();
//        this.userDatas.getResults().addAll(userDatas.getResults());
//        adapter.notifyDataSetChanged();
//    }

//    @Override
//    public void onError(String error) {
//        Toast.makeText(getContext(), "Error:"+error,
//                Toast.LENGTH_SHORT).show();
//    }
}
