package com.vardanian.usernotificationapp.interfaces;

import android.content.Intent;

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
    }

    interface UserDataPresenter {
        void setView(UserDataView view);
        void getUsers();
    }

    interface UserDataModel {
        Observable<UserData> fetchUsers();
    }

    interface UserView {
        void onUserReceived(User username);
        void onError(String error);
    }

    interface UserPresenter {
        void setView(UserView view);
        void loadData(Intent intent);
    }

    interface UserModel {
        Observable<User> fetchUser();
    }
}
