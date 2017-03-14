package com.vardanian.usernotificationapp.view.users;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.vardanian.usernotificationapp.R;
import com.vardanian.usernotificationapp.interfaces.MVPUserDataManager;
import com.vardanian.usernotificationapp.model.UserData;
import com.vardanian.usernotificationapp.model.UserPicture;
import com.vardanian.usernotificationapp.presenter.UserDataManagerPresenter;
import com.vardanian.usernotificationapp.view.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityFragment extends Fragment {

    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();
//    @BindView(R.id.rv_users)
//    RecyclerView rvUsers;
//    private UserData userDatas;
//    private UserAdapter adapter;

//    public MVPUserDataManager.UserDataPresenter presenter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        initUI(root);
//        presenter = new UserDataManagerPresenter();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

//        presenter.setView(this);
//        presenter.getUsers();
    }

    private void initUI(View root) {
//        userDatas = new UserData();
//        rvUsers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        setupAdapter();
    }

    private void setupAdapter() {
//        userDatas = new UserData();
//        adapter = new UserAdapter(getContext(), userDatas);
//        rvUsers.setAdapter(adapter);
    }

//    @Override
//    public void onUserDataReceived(UserData userData) {
//        this.userDatas.getResults().clear();
//        this.userDatas.getResults().addAll(userData.getResults());
//        adapter.notifyDataSetChanged();
//    }

//    @Override
//    public void onError(String error) {
//        Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
//    }
}
