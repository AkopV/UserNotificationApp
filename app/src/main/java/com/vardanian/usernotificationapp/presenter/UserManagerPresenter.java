package com.vardanian.usernotificationapp.presenter;

import android.content.Intent;
import android.os.Parcelable;

import com.vardanian.usernotificationapp.data.network.RetrofitUserRepository;
import com.vardanian.usernotificationapp.interfaces.MVPUserDataManager;
import com.vardanian.usernotificationapp.model.User;
import com.vardanian.usernotificationapp.model.UserData;

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
            UserData userData = intent.getParcelableExtra(UserData.class.getName());
            intent.putExtra(UserData.class.getName(), userData);
            UserManagerPresenter.this.view.onUserReceived(userData);
        }
    }
}
