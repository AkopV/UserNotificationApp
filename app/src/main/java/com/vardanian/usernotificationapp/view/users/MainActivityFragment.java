package com.vardanian.usernotificationapp.view.users;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vardanian.usernotificationapp.R;
import com.vardanian.usernotificationapp.interfaces.MVPUserDataManager;
import com.vardanian.usernotificationapp.model.User;
import com.vardanian.usernotificationapp.model.UserData;
import com.vardanian.usernotificationapp.presenter.UserManagerPresenter;
import com.vardanian.usernotificationapp.view.DetailUserActivity;
import com.vardanian.usernotificationapp.view.adapter.UserAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityFragment extends Fragment implements MVPUserDataManager.UserView {

    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    @BindView(R.id.rv_users)
    RecyclerView rvUsers;
    @BindView(R.id.fab_add)
    FloatingActionButton fab;
    private UserData userData;
    private UserAdapter adapter;

    public MVPUserDataManager.UserPresenter presenter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        initUI(root);
        presenter = new UserManagerPresenter();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.setView(this);
        presenter.loadData(getActivity().getIntent());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.notifyDataSetChanged();
    }

    private void initUI(View root) {
        userData = new UserData();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailUserActivity.class);
                intent.putExtra(User.class.getName(), userData);
                startActivityForResult(intent, Activity.RESULT_OK);
            }
        });
        rvUsers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        setupAdapter();
    }

    private void setupAdapter() {

        adapter = new UserAdapter(getContext(), userData);
        rvUsers.setAdapter(adapter);
    }

    public void updateUI(UserData userData) {
        if (userData != null) {
            this.userData = userData;
            adapter = new UserAdapter(getContext(), this.userData);
            rvUsers.setAdapter(adapter);
        }
    }

    @Override
    public void onUserReceived(UserData userData) {
        updateUI(userData);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
    }
}
