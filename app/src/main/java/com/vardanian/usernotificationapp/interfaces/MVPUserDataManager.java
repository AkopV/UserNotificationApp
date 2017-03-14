package com.vardanian.usernotificationapp.interfaces;

import com.vardanian.usernotificationapp.model.User;
import com.vardanian.usernotificationapp.model.UserData;
import com.vardanian.usernotificationapp.model.UserName;
import com.vardanian.usernotificationapp.model.UserPicture;

import java.util.List;

import rx.Observable;

public interface MVPUserDataManager {

    interface UserDataView {
        void onUserDataReceived(UserData userData);
        void onError(String error);
//        void setName(UserName userName);
//        void setPicture(UserPicture userPicture);
//        void setUser(User user);
    }

    interface UserDataPresenter {
        void setView(UserDataView view);
        void getUsers();
    }

    interface UserDataModel {
        Observable<UserData> fetchUsers();
    }
}
