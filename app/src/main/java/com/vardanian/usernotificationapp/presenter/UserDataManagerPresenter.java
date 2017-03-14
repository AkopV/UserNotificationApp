package com.vardanian.usernotificationapp.presenter;

import com.vardanian.usernotificationapp.data.network.RetrofitUserRepository;
import com.vardanian.usernotificationapp.interfaces.MVPUserDataManager;
import com.vardanian.usernotificationapp.model.User;
import com.vardanian.usernotificationapp.model.UserData;
import com.vardanian.usernotificationapp.model.UserName;
import com.vardanian.usernotificationapp.model.UserPicture;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserDataManagerPresenter implements MVPUserDataManager.UserDataPresenter {

    private MVPUserDataManager.UserDataView view;
    private MVPUserDataManager.UserDataModel model;

    public UserDataManagerPresenter() {
        this.model = new RetrofitUserRepository();
    }

    @Override
    public void setView(MVPUserDataManager.UserDataView view) {
       this.view = view;
    }

    @Override
    public void getUsers() {
        model.fetchUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserData>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        UserDataManagerPresenter.this.onError((Exception) e);
                    }

                    @Override
                    public void onNext(UserData userData) {
                        UserDataManagerPresenter.this.updateUIWithResults(userData);
                    }
                });
    }

    private void updateUIWithResults(UserData userData) {
        if (UserDataManagerPresenter.this.view != null) {
            UserDataManagerPresenter.this.view.onUserDataReceived(userData);
//            view.setName();
        }
    }

    private void onError(Exception e) {
        if (UserDataManagerPresenter.this.view != null)
            UserDataManagerPresenter.this.view.onError(e.getLocalizedMessage());
    }

}

