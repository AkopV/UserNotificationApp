package com.vardanian.usernotificationapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserData implements Parcelable {

    @SerializedName("results")
    @Expose
    private List<User> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Parcelable.Creator<UserData> CREATOR = new Creator<UserData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserData createFromParcel(Parcel in) {
            UserData instance = new UserData();
            in.readList(instance.results, (User.class.getClassLoader()));
            instance.info = ((Info) in.readValue((Info.class.getClassLoader())));
            return instance;
        }

        public UserData[] newArray(int size) {
            return (new UserData[size]);
        }

    };

    public List<User> getUsers() {
        return results;
    }

    public void setUsers(List<User> users) {
        this.results = users;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }
}

