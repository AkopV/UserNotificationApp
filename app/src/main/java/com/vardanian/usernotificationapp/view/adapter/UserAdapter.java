package com.vardanian.usernotificationapp.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vardanian.usernotificationapp.R;
import com.vardanian.usernotificationapp.model.User;
import com.vardanian.usernotificationapp.model.UserData;
import com.vardanian.usernotificationapp.utils.RoundedTransformation;
import com.vardanian.usernotificationapp.view.DetailUserActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private static final String TAG = "UserAdapter";
    public UserData users;
    private Context context;

    public UserAdapter(Context context, UserData users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public UserAdapter.UserHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.user_item, viewGroup, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(UserHolder userHolder, int position) {
        User user = users.getResults().get(position);
        userHolder.bindUserItem(user);
    }

    public User getItem(int position) {
        return users.getResults() != null ? users.getResults().get(position) : null;
    }

    @Override
    public int getItemCount() {
        return users.getResults().size();
    }

    class UserHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_user)
        ImageView ivUser;
        @BindView(R.id.tv_username)
        TextView tvUserName;
        private User user;
        private Context context;

        public UserHolder(View itemView) {
            super(itemView);
            this.user = new User();
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        public void bindUserItem(User user) {
            this.user = user;
            if (!TextUtils.isEmpty(user.getPicture().getLarge()))
                Picasso.with(context)
                        .load(user.getPicture().getLarge())
                        .placeholder(R.drawable.ic_user_48x48)
                        .transform(new RoundedTransformation(100, 4))
                        .into(ivUser);
            tvUserName.setText(user.getName().getFirst() + " " + user.getName().getLast());
        }
    }
}
