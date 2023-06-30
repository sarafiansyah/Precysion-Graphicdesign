package com.rafiansyahdesign.precysion.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Projects implements Parcelable {
    private String id;
    private String title;
    private String nama;
    private String photo;
    private String article;

    public Projects() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.nama);
        dest.writeString(this.photo);
        dest.writeString(this.article);
    }

    protected Projects(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.nama = in.readString();
        this.photo = in.readString();
        this.article = in.readString();
    }

    public static final Parcelable.Creator<Projects> CREATOR = new Parcelable.Creator<Projects>() {
        @Override
        public Projects createFromParcel(Parcel source) {
            return new Projects(source);
        }

        @Override
        public Projects[] newArray(int size) {
            return new Projects[size];
        }
    };
}