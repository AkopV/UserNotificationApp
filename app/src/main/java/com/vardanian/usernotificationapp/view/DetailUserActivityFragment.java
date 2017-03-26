package com.vardanian.usernotificationapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.vardanian.usernotificationapp.presenter.UserDataManagerPresenter;
import com.vardanian.usernotificationapp.utils.RoundedTransformation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailUserActivityFragment extends Fragment implements MVPUserDataManager.UserDataView{

    @BindView(R.id.iv_user_photo)
    ImageView ivUserPhoto;
    @BindView(R.id.et_user_first_name)
    EditText etUserFirstName;
    @BindView(R.id.et_user_last_name)
    EditText etUserLastName;
    @BindView(R.id.et_user_email)
    EditText etUserEmail;
    private UserData userData;
    public MVPUserDataManager.UserDataPresenter presenter;

    public DetailUserActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_detail_user, container, false);
        ButterKnife.bind(this, root);
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
        userData = new UserData();
    }

    public void updateUI(UserData userData) {
        this.userData = userData;
         User user = this.userData.getResults().get(0);
        if (!TextUtils.isEmpty(user.getPicture().getLarge()))
            Picasso.with(getContext())
                    .load(user.getPicture().getLarge())
                    .placeholder(R.drawable.ic_user_48x48)
                    .transform(new RoundedTransformation(100, 4))
                    .into(ivUserPhoto);

        etUserFirstName.setText(user.getName().getFirst());
        etUserLastName.setText(user.getName().getLast());
        etUserEmail.setText(user.getEmail());
    }

    @Override
    public void onUserDataReceived(UserData userDatas) {
        updateUI(userDatas);
    }

    @Override
    public void onError(String error) {
        Toast.makeText(getContext(), "Error:"+error,
                Toast.LENGTH_SHORT).show();
    }
}
