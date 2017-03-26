package com.vardanian.usernotificationapp.presenter;

import android.content.Intent;

import com.vardanian.usernotificationapp.data.network.RetrofitUserRepository;
import com.vardanian.usernotificationapp.interfaces.MVPUserDataManager;
import com.vardanian.usernotificationapp.model.User;

public class UserManagerPresenter implements MVPUserDataManager.UserPresenter {

    private MVPUserDataManager.UserView view;
    private final MVPUserDataManager.UserDataModel model;

    public UserManagerPresenter() {
        this.model = new RetrofitUserRepository();;
    }


    @Override
    public void setView(MVPUserDataManager.UserView view) {
        this.view = view;
    }

    @Override
    public void loadData(Intent intent) {
        if (intent == null) {
            UserManagerPresenter.this.view.onError("Can not load data");
        } else {
            User user = intent.getParcelableExtra(User.class.getName());
            UserManagerPresenter.this.view.onUserReceived(user);
        }
    }
}
