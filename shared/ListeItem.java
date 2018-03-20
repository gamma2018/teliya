package com.example.sad.telpo.adapter;

/**
 * Created by SADGC on 5/30/2016.
 */
public class ListeItem {

    String title;
    String subTitle;

    public ListeItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

}
