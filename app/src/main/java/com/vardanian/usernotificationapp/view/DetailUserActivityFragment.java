package com.vardanian.usernotificationapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vardanian.usernotificationapp.R;
import com.vardanian.usernotificationapp.interfaces.MVPUserDataManager;
import com.vardanian.usernotificationapp.model.User;
import com.vardanian.usernotificationapp.model.UserData;
import com.vardanian.usernotificationapp.model.UserName;
import com.vardanian.usernotificationapp.model.UserPicture;
import com.vardanian.usernotificationapp.presenter.UserDataManagerPresenter;
import com.vardanian.usernotificationapp.view.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailUserActivityFragment extends Fragment implements MVPUserDataManager.UserDataView{

    EditText etUserFirstName;
    EditText etUserLastName;
    EditText etUserEmail;
    public ImageView ivUserPhoto;
    RecyclerView rvUsers;
    private UserData userDatas;
    public MVPUserDataManager.UserDataPresenter presenter;
    private UserAdapter adapter;

    public DetailUserActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
//        ButterKnife.bind(this, root);

        initUI(root);
        presenter = new UserDataManagerPresenter();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.setView(this);
        presenter.getUsers();
    }

    private void initUI(View root) {
        rvUsers = (RecyclerView) root.findViewById(R.id.rv_users);
        ivUserPhoto = (ImageView) root.findViewById(R.id.iv_user);
        etUserFirstName = (EditText) root.findViewById(R.id.et_user_first_name);
        etUserLastName = (EditText) root.findViewById(R.id.et_user_last_name);
        etUserEmail = (EditText) root.findViewById(R.id.et_user_email);
        userDatas = new UserData();
        rvUsers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        setupAdapter();
    }

//    public void updateUI(UserData userData) {
//        Picasso.with(getActivity())
//                .load(userData.getResults().get(0).getPicture().getThumbnail())
//                .placeholder(R.drawable.ic_user_48x48)
//                .into(ivUserPhoto);
//        etUserFirstName.setText(userData.getResults().get(0).getName().getFirst());
//        etUserLastName.setText(userData.getResults().get(0).getName().getLast());
//        etUserEmail.setText(userData.getResults().get(0).getEmail());
//    }

    private void setupAdapter() {
        userDatas = new UserData();
        adapter = new UserAdapter(getContext(), userDatas);
        rvUsers.setAdapter(adapter);
    }

    @Override
    public void onUserDataReceived(UserData userDatas) {
        this.userDatas.getResults().clear();
        this.userDatas.getResults().addAll(userDatas.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(getContext(), "Error:"+error,
                Toast.LENGTH_SHORT).show();
    }
}
